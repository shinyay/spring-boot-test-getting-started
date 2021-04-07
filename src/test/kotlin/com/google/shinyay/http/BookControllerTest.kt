package com.google.shinyay.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.shinyay.client.BookClient
import com.google.shinyay.controller.BookController
import com.google.shinyay.entity.Book
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

@RestClientTest(BookClient::class)
class BookControllerTest(
    @Autowired val mockServer: MockRestServiceServer,
    @Autowired val objectMapper: ObjectMapper,
    @Autowired val client: BookClient
) {
    @BeforeEach
    fun setup() {
        val detailsString = objectMapper.writeValueAsString(Book(title = "Test", author = "JohnDoe",price = 50))
        mockServer.expect(requestTo("/book"))
            .andExpect(MockRestRequestMatchers.method(HttpMethod.POST))
            .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON))
    }

    @Test
    fun whenCallingGetBookDetails_ThenClientMakesCorrectCall() {
        val detail = client.testBookService(Book())
        Assertions.assertThat(detail.body?.title).isEqualTo("Test")
    }
}