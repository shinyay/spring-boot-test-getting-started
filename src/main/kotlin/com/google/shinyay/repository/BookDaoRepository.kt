package com.google.shinyay.repository

import com.google.shinyay.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDaoRepository: JpaRepository<Book, Long> {
    fun findAllByAuthorOrderByPrice(author: String): List<Book>

    fun findAllByAuthorOrderByPriceDesc(author: String): List<Book>

    fun findBookByTitleContains(title: String): List<Book>
}