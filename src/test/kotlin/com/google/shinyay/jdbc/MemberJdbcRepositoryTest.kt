package com.google.shinyay.jdbc

import com.google.shinyay.repository.MemberJdbcRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.jdbc.Sql

@DataJdbcTest
@Sql(scripts = ["classpath:schema.sql", "classpath:data.sql"])
@Import(MemberJdbcRepository::class)
class MemberJdbcRepositoryTest(@Autowired val memberJdbcRepository: MemberJdbcRepository) {

    @Test
    fun whenInjectInMemoryDataSource_thenReturnCorrectMemberCount() {
        assertThat(memberJdbcRepository.getCountOfMembers()).isEqualTo(3)
    }
}