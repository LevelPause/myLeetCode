package com.hyperboat.util

import com.google.gson.JsonObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest.BodyPublisher
import java.net.http.HttpRequest.newBuilder
import java.net.http.HttpResponse
import java.time.Duration

object Client {
    fun post(uri: URI, cookie: String, body: BodyPublisher, retry: Int = 5): JsonObject {
        val client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build()

        val request = newBuilder()
            .uri(uri)
            .timeout(Duration.ofMinutes(2))
            .header("Accept", "application/json, text/plain, */*")
            .header("Content-Type", "application/json")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36")
            .header("Cookie", cookie)
            .POST(body)
            .build()
        var response: HttpResponse<String>? = null;
        //重试 有时候会有莫名其妙的报错, 相同的请求再试一次就好了
        for (i in 0..retry) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString())
            if (response.statusCode() == 200) {
                break
            }
            if (i > 0) {
                println("request failed! retrying, curr retry: $i")
            }
        }
        if (response?.statusCode() != 200) {
            throw Exception(
                "fail to fetch problems! status: ${response?.statusCode()} data: ${response?.body().toString()}"
            )
        }
        return Generator.gson.fromJson(response.body(), JsonObject::class.java)
    }

    fun get(uri: URI, cookie: String): JsonObject {
        val client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build()

        val request = newBuilder()
            .uri(uri)
            .timeout(Duration.ofMinutes(2))
            .header("Accept", "application/json, text/plain, */*")
            .header("Content-Type", "application/json")
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36")
            .header("Cookie", cookie)
            .GET()
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return Generator.gson.fromJson(response.body(), JsonObject::class.java)
    }
}