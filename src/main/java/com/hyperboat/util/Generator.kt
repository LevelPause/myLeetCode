package com.hyperboat.util

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.hyperboat.util.generator.data.md.MD
import com.hyperboat.util.generator.data.md.Metadata
import com.hyperboat.util.generator.data.qu.simple.SimpleQu
import com.hyperboat.util.generator.data.qu.whole.Content
import com.hyperboat.util.generator.data.qu.whole.Problem
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.time.Duration
import java.util.*
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists


object Generator {
    @JvmStatic
    val gson by lazy { Gson() }

    /**
     * Main 增量更新, 已存在md的会跳过并提示, 获取问题失败的会提示, 部分问题失败不会中断, 除非是意料之外的异常
     */
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        checkEveryQu()
    }

    private fun getContentFromRemote(slug: String): Content {
        println("get content from slug: $slug")
        val setting = Properties()
        setting.load(Files.newInputStream(Path.of("generator", "setting.yml")))
        val cookie = setting["cookie"]
        checkNotNull(cookie) {
            throw Exception("cookie is null!")
        }
        checkNotNull(setting["url"]) {
            throw Exception("url is null!")
        }
        val uri = URI.create(setting["url"] as String)

        val bodyCn = getCnContentBody(slug)
        val bodyEn = getEncontentBody(slug)
        val respCn = Client.post(uri, cookie as String, bodyCn)
        val respEn = Client.post(uri, cookie, bodyEn)
        val contentCn =
            respCn.getNullable("data")?.asJsonObject?.getNullable("question")?.asJsonObject?.getNullable(
                "translatedContent"
            )?.asString ?: ""
        val contentEn =
            respEn.getNullable("data")?.asJsonObject?.getNullable("question")?.asJsonObject?.getNullable(
                "content"
            )?.asString ?: ""
        return Content(contentCn, contentEn)
    }

    /**
     * Get nullable 扩展JsonObject的方法, 用于实现链式调用的空安全, 好东西, 能便捷的扩展其他API真是太爽了, 再也不会出现大堆的只用一两次的utils
     *
     * @param key
     * @return
     */
    private fun JsonObject.getNullable(key: String): JsonElement? {
        val value: JsonElement = this.get(key) ?: return null

        if (value.isJsonNull) {
            return null
        }

        return value
    }

    /**
     * 将全量的problem all.json列表与不一定全量的详情列表problems.json(里面有problem的markdown)对比, 结合已经有的markdown
     * 筛选出还有那些题目需要同步markdown, 按照slug逐个查找补全markdown, (不会重复写入)
     * 目前来说最好用的实现方式了, 结合https://leetcode.cn/api/problems/all/ 这个get请求获取全量problem简介
     * */
    private fun checkEveryQu() {
        val simple = gson.fromJson(Files.readString(Path.of("generator", "all.json")),
            object : TypeToken<List<SimpleQu>>() {})
        val map = gson.fromJson(
            Files.readString(Path.of("generator", "problems.json")),
            object : TypeToken<Map<String, Problem>>() {})
        val lack = mutableMapOf<String, String>()

        for (qu in simple) {
            val path = Path.of("md", "${qu.stat.frontendQuestionId}.md")
            if (!Files.exists(path)) {
                if (!map.containsKey(qu.stat.frontendQuestionId)) {
                    lack[qu.stat.frontendQuestionId] = qu.stat.questionTitleSlug
                } else {
                    val content = map[qu.stat.frontendQuestionId]?.content?.cn
                    content?.let {
                        Files.createFile(path)
                        Files.writeString(path, it)
                    } ?: lack.put(qu.stat.frontendQuestionId, qu.stat.questionTitleSlug)
                }
            }
        }
        println(lack)
        for (it in lack) {
            val path = Path.of("md", "${it.key}.md")
            if (!Files.exists(path)) {
                val content = getContentFromRemote(it.value).cn
                Files.createFile(path)
                Files.writeString(path, content)
            }
        }

    }


    fun startFetch() {
        println("start fetching all problems")
        val problems = doFetchAll()
        for (en in problems) {
            en.value.content = getContentFromRemote(en.value.titleSlug)
        }
        println("fill problem content over!")
        println("start writing to problem.json")
        Files.writeString(Path.of("generator", "problems.json"), gson.toJson(problems))
        println("fetch-all over! problems.json is up-to-date")
    }

    /**
     * Fetch all 批量获取题目, 直至获取全部题目, 更新至本地  ->> problems.json
     * 这接口并不是很好使, 会限流, 限流很严重, 应该使调用的人太多了, 多调用几次就只返回前一百的数据了
     * 值得一提的是, 在程序被限流后, 同样请求手动提交却能获得正确的结果, 应该是基于令牌桶或者时间窗口类似的限流方式, 还夹杂了ip权重
     * @param offset
     * @param limit
     * @return
     */
    private fun doFetchAll(offset: Int = 0, limit: Int = 50): Map<String, Problem> {
        val setting = Properties()
        setting.load(Files.newInputStream(Path.of("generator", "setting.yml")))
        val cookie = setting["cookie"]
        var start = offset
        val uri = URI.create(setting["url"] as String)
        val body = HttpRequest.BodyPublishers.ofString(
            """
            {
  "query": "\n query problemsetQuestionList(${'$'}categorySlug: String, ${'$'}limit: Int, ${'$'}skip: Int,${'$'}filters: QuestionListFilterInput) { \n problemsetQuestionList(\n categorySlug: ${'$'}categorySlug \n limit: ${'$'}limit\n skip: ${'$'}skip\n filters: ${'$'}filters\n ) {\n hasMore\n total\n questions {\n acRate\n difficulty\n freqBar\n frontendQuestionId\n isFavor\n paidOnly\n solutionNum\n status\n title\n titleCn\n titleSlug\n topicTags {\n name\n nameTranslated\n id\n slug\n }\n extra {\n   hasVideoSolution\n   topCompanyTags {\n   imgUrl\n   slug\n   numSubscribed\n }\n }\n }\n }\n }",
  "variables": {
    "categorySlug": "all-code-essentials",
    "skip": $start,
    "limit": $limit,
    "filters": {}
  },
  "operationName": "problemsetQuestionList"
}
            """.trimIndent()
        )

        val res = mutableMapOf<String, Problem>()
        do {
            val resp = Client.post(uri, cookie as String, body)
            val hasMore =
                resp.getNullable("data")?.asJsonObject?.getNullable("problemsetQuestionList")?.asJsonObject
                    ?.getNullable("hasMore")?.asBoolean ?: false
            val total =
                resp.getNullable("data")?.asJsonObject?.getNullable("problemsetQuestionList")?.asJsonObject
                    ?.getNullable("total")?.asInt ?: 0
            val array =
                resp.getNullable("data")?.asJsonObject?.getNullable("problemsetQuestionList")?.asJsonObject
                    ?.getNullable("questions")?.asJsonArray ?: JsonArray()
            val once = mutableMapOf<String, Problem>()
            for (element in array) {
                val problem = gson.fromJson(element, Problem::class.java)
                once[problem.frontendQuestionId] = problem
                print(problem.frontendQuestionId)
            }
            res.putAll(once)
            start += limit
            println(once.keys)
            println(res.keys)
            println("already fetched ${res.size} problems")
            println(start)
        } while (hasMore && start <= total)
        return res
    }

    /**
     * Get all problems
     * unused 没用到
     *
     * @return
     */
    fun getAllProblems(): List<String> {
        val client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
//            .proxy(ProxySelector.of(InetSocketAddress("proxy.example.com", 80)))
//            .authenticator(Authenticator.g())
            .build()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://leetcode-cn.com/api/problems/all/"))
            .timeout(Duration.ofMinutes(2))
//            .header("Content-Type", "application/json")
            .GET()
            .build()
        val response = client.send(request, BodyHandlers.ofString())
        val res = mutableListOf<String>()
//        val jsonObject =
//            Gson().fromJson(response.body(), object : TypeToken<Map<String, ProblemT>>() {})
        val jsonObject = Gson().fromJson(response.body(), JsonObject::class.java)
        for (e in jsonObject.getAsJsonArray("stat_status_pairs")) {
            val string =
                e.asJsonObject.getAsJsonObject("stat").get("question__title_slug").asString
            res.add(string)
        }
//        println(response.statusCode())
//        println(response.body())
//        println(res)
        return res
    }

    /** 目前这个接口是最好使的, 应该是因为是单条数据, 请求数据量小, 返回数据量小, 不太容易达到限流标准,
     * 似乎频次的限流权重并不大, 或者说压根没有频次限流，防御全靠cloudflare
     * Get content from remote
     * 从服务端获取指定slug的problem content, markdown格式
     * @param slug 前端唯一业务标志
     * @return problem的md
     */
    /**
     * 用于获取制定问题id的问题描述, 并生成一个md文件,将问题描述写入到md中
     * 问题描述的位置位于: json.no.content.cn
     * @Dep
     * @param json leetcode上的所有题目的json汇总
     * @param no 问题id
     * @param path md的存储路径
     */
    @Deprecated("废案, 原用于生成每个问题的md文件, 现在有更好用的方式和接口了")
    @Throws(IOException::class)
    fun generate(file: File, noArr: Array<String>, md: MD) {
        require(file.exists()) {
            "file: ${file.absolutePath} not exists"
        }


        val metadata = gson.fromJson(
            Files.readString(Path.of("generator", "template.json")),
            Metadata::class.java
        )
        val path = Paths.get(md.getPath().joinToString { File.separator })
        for (num in md.getNums()) {

        }
        val problemPath = Path.of("problems.json")
        val json = Files.readString(problemPath)
        val jo = gson.fromJson(json, JsonObject::class.java)
        for (no in noArr) {
            val content = jo?.getAsJsonObject(no)?.getAsJsonObject("content")?.get("cn")?.asString
            if (content == null) {
                println("problem: $no content is null")
                continue
            }
            //父路径不存在时创建父路径
            path.exists().not().let { Files.createDirectories(path) }
            val filePath = Paths.get(path.absolutePathString(), "$no.md")
            if (filePath.exists()) {
                println(filePath.absolutePathString() + " already exists! skip generate")
                continue
            }
            //写入
            val output = Files.createFile(filePath)
            Files.writeString(output, content)
            println("generate $no.md success")
        }

    }
}