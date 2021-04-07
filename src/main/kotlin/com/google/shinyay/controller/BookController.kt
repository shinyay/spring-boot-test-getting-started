package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.service.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val service: BookService) {

    @PostMapping("/book")
    fun displayBook(@RequestBody book:Book): Book {
        return service.displayBook(book)
    }
}