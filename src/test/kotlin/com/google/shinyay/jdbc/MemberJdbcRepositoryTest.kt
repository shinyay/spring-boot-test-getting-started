package com.google.shinyay.jdbc

import com.google.shinyay.repository.MemberJdbcRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.test.context.jdbc.Sql

@JdbcTest
@Sql(scripts = ["schema.sql", "data.sql"])
class MemberJdbcRepositoryTest(@Autowired val memberJdbcRepository: MemberJdbcRepository) {

    @Test
    fun whenInjectInMemoryDataSource_thenReturnCorrectMemberCount() {
        assertThat(memberJdbcRepository.getCountOfMembers()).isEqualTo(4)
    }
}