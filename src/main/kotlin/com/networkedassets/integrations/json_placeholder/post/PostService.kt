package com.networkedassets.integrations.json_placeholder.post

import com.networkedassets.integrations.common.FakeAPIRequestConfig
import com.networkedassets.integrations.json_placeholder.post.StorageService.storePostAsJsonFile

object PostService {

    private const val JSON_PlACEHOLDER_BASE_URL = "https://jsonplaceholder.typicode.com"

    fun fetchPosts() {
        val posts = sendRequestToGetAllPosts(FakeAPIRequestConfig(JSON_PlACEHOLDER_BASE_URL))
        storePostAsJsonFile(posts)
    }
}