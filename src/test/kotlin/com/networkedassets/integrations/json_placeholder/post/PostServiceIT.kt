package com.networkedassets.integrations.json_placeholder.post

import TestBase
import com.networkedassets.integrations.json_placeholder.post.StorageService.POSTS_DIR
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


class PostServiceIT : TestBase() {

    @Test
    fun `GIVEN GET posts request WHEN sending to JSONPlaceholder THEN json files are stored`() {
        // fetch all posts from JSONPlaceholder
        PostService.fetchPosts()

        // assert posts file creation
        val createdDirectory = File(POSTS_DIR)
        assertTrue(createdDirectory.exists())
        assertTrue(createdDirectory.isDirectory)
        // Not the best file counter assertion to clarify if files are created
        // WARNING: some filesystems may not have the number of files in a directory readily available
        Files.list(Paths.get(POSTS_DIR)).also { files -> assertTrue(files.count() > 0) }
    }
}