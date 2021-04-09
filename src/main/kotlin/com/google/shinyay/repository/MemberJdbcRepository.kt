package com.google.shinyay.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.stereotype.Repository

@Repository
class MemberJdbcRepository(val jdbcTemplate: JdbcTemplate) {

    fun getCountOfMembers(): Long? {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM member", Long::class.java)
    }
}