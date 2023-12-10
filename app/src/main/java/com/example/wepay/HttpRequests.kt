import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.content.TextContent
import io.ktor.http.contentType
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class UserExpenseAggregation(
    val userId: Int,
    // Add other properties based on your API response
)

suspend fun getUserExpenseAggregation(userId: Int): String {
    val client = HttpClient()

    val response = client.get<String>("https://api.alinowrouzii.ir/wepay/api/users/userExepenseAggregation") {
        parameter("userId", userId)
        contentType(ContentType.Application.Json)
    }

    return Json.decodeFromString<UserExpenseAggregation>(response).toString()
}

