package org.hibernate.search.demos.quarkuskotlin

import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class TShirtServiceTest {

    @Test
    fun testHelloEndpoint() {
        When {
            get("/tshirt/search?terms=collaboration")
        } Then {
            statusCode(200)
            body(`is`("hello"))
        }
    }

}