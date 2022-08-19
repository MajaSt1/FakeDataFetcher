package com.networkedassets.integrations.json_placeholder.post

import com.networkedassets.integrations.common.logger
import com.networkedassets.integrations.common.objectMapper
import java.io.File
import java.io.IOException

object StorageService {
    private val LOGGER = logger(this::class.java)
    private const val POST_DIR = "posts/"

    fun storePostAsJsonFile(posts: Map<Int?, Post>) {
        LOGGER.debug("Create directory for posts...")
        createDir()
        // TODO - what about null objects
        posts.forEach { post ->
            try {
                objectMapper.writeValue(File("$POST_DIR${post.key}.json"), post.value)
            } catch (e: IOException) {
                LOGGER.error("Error while store posts as file: ${e.localizedMessage}")
            }
        }
        LOGGER.info("Posts files created.")
    }

    private fun createDir() {
        val directory = File(POST_DIR)
        if (!directory.exists()) {
            directory.mkdir()
        } else {
            LOGGER.debug("Remove directory with posts json files.")
            deleteDirectoryWithContent(directory)
        }
    }

    private fun deleteDirectoryWithContent(directory: File) {
        if (!directory.deleteRecursively()) {
            //TODO- throw exception
            LOGGER.error("Error while delete posts json files.")
        } else {
            directory.mkdir()
        }
    }
}