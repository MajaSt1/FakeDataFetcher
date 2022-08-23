package com.networkedassets.integrations.json_placeholder.post

import com.networkedassets.integrations.common.FakeAPIRequestConfig
import com.networkedassets.integrations.common.objectMapper
import java.net.URL

fun sendRequestToGetAllPosts(fakeAPIRequestConfig: FakeAPIRequestConfig): Map<Int?, List<Post>> {
    return URL("${fakeAPIRequestConfig.requestBaseUrl}/posts").openConnection().apply {
        readTimeout = fakeAPIRequestConfig.receiveTimeout
        connectTimeout = fakeAPIRequestConfig.connectionTimeout
    }.getInputStream().use {
        val result = objectMapper.readTree(it).map { node ->
            val userId = node.get("userId").asInt()
            val id = node.get("id").asInt()
            val title = node.get("title").asText()
            val body = node.get("body").asText()

            return@map Post(userId, id, title, body)
        }.groupBy(Post::id)
        result
    }
}

data class Post(val userId: Int?, val id: Int?, val title: String?, val body: String?)