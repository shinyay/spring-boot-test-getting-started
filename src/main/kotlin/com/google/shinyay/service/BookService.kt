package com.google.shinyay.service

import com.google.shinyay.entity.Book
import org.springframework.stereotype.Service

@Service
class BookService {

    fun displayBook(book: Book) = book
}