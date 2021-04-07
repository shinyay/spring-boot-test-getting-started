package com.google.shinyay.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.shinyay.controller.BookController
import com.google.shinyay.entity.Book
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@RestClientTest(BookController::class)
class BookControllerTest(
    @Autowired val mockServer: MockRestServiceServer,
    @Autowired val objectMapper: ObjectMapper,
    val controller: BookController
) {
    @BeforeEach
    fun setup() {
        val detailsString = objectMapper.writeValueAsString(Book(title = "Test", author = "JohnDoe",price = 50))
        mockServer.expect(requestTo("/book"))
            .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON))
    }
}