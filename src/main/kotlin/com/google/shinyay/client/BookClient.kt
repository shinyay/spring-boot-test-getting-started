package com.google.shinyay.client

import com.google.shinyay.entity.Book
import com.google.shinyay.logger
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BookClient(val restTemplateBuilder: RestTemplateBuilder) {
    val restTemplate: RestTemplate = restTemplateBuilder.build()

    val uri = "/book"

    fun testBookService(book: Book): ResponseEntity<Book> {

        val result = restTemplate.postForEntity(uri, book ,Book::class.java)
        logger.info(result.toString())
        return result
    }
}