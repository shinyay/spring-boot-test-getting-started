package com.google.shinyay

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
class BookRepositoryTest(
    @Autowired
    val repository: BookRepository
) {
    @Autowired
    lateinit var entityManager: TestEntityManager

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

    @Test
    fun shouldReturnBookAfterPersistence() {
        val book = repository.save(Book(title = "GKE", author = "Google", price = 1000))

        assertThat(book).hasFieldOrPropertyWithValue("title", "GKE")
        assertThat(book).hasFieldOrPropertyWithValue("author", "Google")
        assertThat(book).hasFieldOrPropertyWithValue("price", 1000L)
    }

    @Test
    fun shouldReturnSizeZeroAfterDelete() {
        assertThat(repository.findAll()).hasSize(5)
        repository.deleteAll()
        assertThat(repository.findAll()).isEmpty()
        assertThat(repository.findAll()).hasSize(0)
    }

    @Test
    fun shouldFindBookByTitle() {
        val book1 = Book(title = "GKE-Tutorial", author = "yanashin", price = 500)
        val book2 = Book(title = "CloudRun-Tutorial", author = "yanashin", price = 300)
        entityManager.persist(book1)
        entityManager.persist(book2)
        val books = repository.findBookByTitleContains("Tutorial")
        assertThat(books).hasSize(2).contains(book1, book2)
    }
}