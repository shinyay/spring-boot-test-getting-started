package com.google.shinyay

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTestWithHttpRequest(
    @LocalServerPort val port: Int,
    @Autowired val restTemplate: TestRestTemplate
) {
    @Test
    fun helloShouldReturnDefaultMessage() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:$port/hello", String::class.java)).isEqualTo("Hello")
    }
}