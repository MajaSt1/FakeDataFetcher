package com.networkedassets.integrations.json_placeholder.post

import com.networkedassets.integrations.common.logger
import com.networkedassets.integrations.common.objectMapper
import java.io.File

object StorageService {
    private val LOGGER = logger(this::class.java)
    const val POSTS_DIR = "posts/"

    fun storePostsAsJsonFile(posts: Map<Int?, List<Post>>) {
        LOGGER.debug("Create directory for posts...")
        createDir()
        posts.forEach { (postId, post) ->
            try {
                objectMapper.writeValue(File("$POSTS_DIR${postId}.json"), post)
            } catch (e: Exception) {
                LOGGER.error("Error while store posts as file: ${e.localizedMessage}")
            }
        }
        LOGGER.info("Posts files created.")
    }

    private fun createDir() {
        val directory = File(POSTS_DIR)
        if (!directory.exists()) {
            directory.mkdir()
        } else {
            LOGGER.debug("Remove directory with content posts json files.")
            deleteDirectoryWithContent(directory)
        }
    }

    private fun deleteDirectoryWithContent(directory: File) {
        if (!directory.deleteRecursively()) {
            throw DeleteDirectoryException("Delete posts json files error: Check path $POSTS_DIR dir for partial deletion of files.")
        } else {
            directory.mkdir()
        }
    }
}

class DeleteDirectoryException(message: String) : Exception("Storing posts error: $message")