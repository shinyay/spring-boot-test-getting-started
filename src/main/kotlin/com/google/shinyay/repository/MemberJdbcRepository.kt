package com.google.shinyay.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.stereotype.Repository

@Repository
class BookJdbcRepository(val jdbcTemplate: JdbcTemplate) {

    fun getCountOfBooks() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM book")
    }
}