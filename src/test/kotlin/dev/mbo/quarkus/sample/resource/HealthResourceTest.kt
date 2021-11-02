package dev.mbo.quarkus.sample.resource

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test

@QuarkusTest
class HealthResourceTest {

    @Test
    fun testHelloEndpoint() {
        RestAssured.given()
            .`when`()["/actuator/health"]
            .then()
            .statusCode(200)
            .body(CoreMatchers.`is`("OK"))
    }
}
