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
        entityManager.persist(Book(title = "Spring Boot", author = "shinyay", price = 300))
        entityManager.persist(Book(title = "Spring Test", author = "shinyay", price = 900))
        entityManager.persist(Book(title = "Spring Cloud", author = "shinyay", price = 700))
        entityManager.persist(Book(title = "Spring Cloud GCP", author = "shinyay", price = 1100))
        entityManager.persist(Book(title = "Google Cloud", author = "shinyay", price = 500))

    }

    @Test
    fun initialSizeShouldBeFive() {
        assertThat(repository.findAllByAuthorOrderByPrice("shinyay").size).isEqualTo(5)
        assertThat(repository.findAllByAuthorOrderByPriceDesc("shinyay").size).isEqualTo(5)
    }

    @Test
    fun titleOrderedByPriceAscShouldReturnCorrectOne() {
        assertThat(repository.findAllByAuthorOrderByPrice("shinyay")[0].title).isEqualTo("Spring Boot")
        assertThat(repository.findAllByAuthorOrderByPrice("shinyay")[0].price).isEqualTo(300)
    }

    @Test
    fun titleOrderedByPriceDescShouldReturnCorrectOne() {
        assertThat(repository.findAllByAuthorOrderByPriceDesc("shinyay")[0].title).isEqualTo("Spring Cloud GCP")
        assertThat(repository.findAllByAuthorOrderByPriceDesc("shinyay")[0].price).isEqualTo(1100)
    }
}