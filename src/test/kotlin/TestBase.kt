import com.networkedassets.integrations.json_placeholder.post.StorageService
import org.junit.jupiter.api.AfterEach
import java.io.File

open class TestBase {
    // comment if not needed or add mvn profile
    @AfterEach
    fun cleanup() {
        File(StorageService.POSTS_DIR).deleteRecursively()
    }
}