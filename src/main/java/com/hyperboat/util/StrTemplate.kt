package com.hyperboat.util

import java.net.http.HttpRequest

/**
 * graphQL 请求体模板
 * */
fun getCnContentBody(slug: String) = HttpRequest.BodyPublishers.ofString(
    """
                {
                  "query": "\n query questionTranslations(${'$'}titleSlug: String!) {\n question(titleSlug:${'$'}titleSlug) {\n translatedTitle \n translatedContent \n } \n } ",
                  "variables": {
                    "titleSlug": "$slug"
                  },
                  "operationName": "questionTranslations"
                }
            """.trimIndent()
)

fun getEncontentBody(slug: String) = HttpRequest.BodyPublishers.ofString(
    """
               {
  "query": "\n query questionContent(${'$'}titleSlug: String!) {\n question(titleSlug: ${'$'}titleSlug) { \n content \n editorType \n mysqlSchemas \n dataSchemas \n } \n}",
  "variables": {
    "titleSlug": "$slug"
  },
  "operationName": "questionContent"
}

            """.trimIndent()
)