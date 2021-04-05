package com.google.shinyay

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class BookRepositoryTest(
    @Autowired val repository: BookRepository,
    @Autowired val entityManager: TestEntityManager
) {

    @BeforeEach
    fun setUp() {
        entityManager.persist(Book(title = "Spring Test", author = "shinyay", price = 500))
//        repository.save(Book(title = "Spring Test", author = "shinyay", price = 500))
    }

    @Test
    fun sizeShouldBeOne() {
        assertThat(repository.count()).isEqualTo(1)
    }
}