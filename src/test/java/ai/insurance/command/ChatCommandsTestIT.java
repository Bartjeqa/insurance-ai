package ai.insurance.command;

import dev.langchain4j.data.message.ContentType;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ChatCommandsTestIT {

    @Test
    void testChatEndpoint() {
        // Create the input JSON for the POST request
        String inputJson = "{\"message\": \"Hello\"}";

        // Perform the HTTP POST request
        given()
            .contentType(JSON)
            .body(inputJson)
            .when()
            .post("/chat")
            .then()
            .statusCode(200)
            .contentType(String.valueOf(ContentType.TEXT))
            .body(is("Bot response")); // Assert the expected response
    }
}