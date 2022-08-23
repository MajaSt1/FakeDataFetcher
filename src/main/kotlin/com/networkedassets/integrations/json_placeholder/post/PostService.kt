package com.networkedassets.integrations.json_placeholder.post

import com.networkedassets.integrations.common.FakeAPIRequestConfig
import com.networkedassets.integrations.common.logger
import com.networkedassets.integrations.json_placeholder.post.StorageService.storePostsAsJsonFile

object PostService {

    private val logger = logger(this::class.java)
    private const val JSON_PlACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com"

    fun fetchPosts() {
        try {
            val posts = sendRequestToGetAllPosts(FakeAPIRequestConfig(JSON_PlACEHOLDER_BASE_URL))
            storePostsAsJsonFile(posts)
        } catch (exc: Exception) {
            logger.error("Fetch posts error: [${exc.localizedMessage}]")
        }
    }
}