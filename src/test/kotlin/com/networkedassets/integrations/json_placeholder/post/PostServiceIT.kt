package com.networkedassets.integrations.json_placeholder.post

import org.junit.jupiter.api.Test


class PostServiceIT {
    @Test
    fun `GIVEN GET posts request WHEN sending to JSONPlaceholder THEN json files are stored`() {
        PostService.fetchPosts()

// test to verify json posts files creation
    }
}