package com.networkedassets.integrations.json_placeholder.post

import TestBase
import com.fasterxml.jackson.module.kotlin.readValue
import com.networkedassets.integrations.common.objectMapper
import fromClasspath
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class StorageServiceTest : TestBase() {

    @Test
    fun `GIVEN invalid post id WHEN store post as json file THEN null file is stored`() {
        //mock invalid post ids reply
        val givenPosts: Map<Int?, List<Post>> =
            objectMapper.readValue<List<Post>>(fromClasspath("test-data/01-invalid-id-post-reply.json"))
                .groupBy { it.id }

        StorageService.storePostsAsJsonFile(givenPosts)

        // assert posts file creation
        val createdDirectory = File(StorageService.POSTS_DIR)
        Assertions.assertTrue(createdDirectory.exists())
        Assertions.assertTrue(createdDirectory.isDirectory)
        // Not the best file counter assertion to clarify if files are created
        // WARNING: some filesystems may not have the number of files in a directory readily available
        Files.list(Paths.get(StorageService.POSTS_DIR)).also { files -> assertEquals(files.count(), 1) }
    }
}