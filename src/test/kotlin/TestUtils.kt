import com.networkedassets.integrations.json_placeholder.post.Post

fun fromClasspath(resourcePath: String): String {
    require(resourcePath.isNotBlank()) { "Resource path was blank." }
    val path = if (!resourcePath.startsWith("/")) "/$resourcePath" else resourcePath
    val stream = Post::class.java.getResourceAsStream(path)
    requireNotNull(stream) { "$resourcePath not found." }
    return stream.bufferedReader().use { it.readText() }
}