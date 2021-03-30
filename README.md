# Getting Started with Spring Test

Spring Boot provides a number of utilities and annotations to help when testing your application.
Test support is provided by two modules:
- `spring-boot-test`:  contains core items
- `spring-boot-test-autoconfigure`: auto-configuration for tests.

## Description
### Dependencies
- org.springframework.boot
  - `spring-boot-starter-test`

spring-boot-starter-test contains the following libraries:
- **JUnit 5**: The de-facto standard for unit testing Java applications.
- **Spring Test** & Spring Boot Test: Utilities and integration test support for Spring Boot applications.
- **AssertJ**: A fluent assertion library.
- **Hamcrest**: A library of matcher objects (also known as constraints or predicates).
- **Mockito**: A Java mocking framework.
- **JSONassert**: An assertion library for JSON.
- **JsonPath**: XPath for JSON.


### Test for Application Context
- `@Autowired` for Application Context
- `org.assertj.core.api.Assertions.assertThat().isNotNull`

```kotlin
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContextTest(@Autowired val helloController: HelloController) {
	@Test
	fun contextLoads() {
		assertThat(helloController).isNotNull
	}
}
```

### Test for Controller with HTTP Request
- `webEnciroment` and `RANDOM_PORT`
- `@LocalServerPort`
- `TestRestTemplate`

```kotlin
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest(
    @LocalServerPort val port: Int,
    @Autowired val restTemplate: TestRestTemplate
) {
    @Test
    fun helloShouldReturnDefaultMessage() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:$port/hello", String::class.java)).isEqualTo("Hello")
    }
}
```

### Test for Controller with Mock without HTTP Server
- `@AutoConfigureMockMvc`
- `MockMvc`

```kotlin
@SpringBootTest
@AutoConfigureMockMvc
class ControllerTestWithMock(@Autowired val mockMvc: MockMvc) {
    @Test
    fun helloShouldReturnDefaultMessage() {
        mockMvc.perform(get("/hello"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello")))
    }
}
```

### Web layer Slice Test with `@WebMvcTest`
`@WebMvcTest` makes you get Spring Context includes components required for testing Spring MVC.
- @Controller
- @ControllerAdvice
- @JsonComponent
- Converter
- Filter
- WebMvcConfigurer

- `Not Included`
  - @Service
  - @Component
  - @Repository

### JPA Components Slice Test with `@DataJpaTest`
`@DataJpaTest` makes you can test any JPA related parts.
- @Repository
- EntityManager
- TestEntityManager
- DataSource

- `Not Included`
  - @Controller
  - @Service
  - @Component

### JDBC access Slice Test with `@JdbcTest`
If your application uses the `JdbcTemplate` instead of JPA for the database access, Spring Boot also covers testing this slice of your application.
- JdbcTemplate
- DataSource

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository

### MongoDB access Slice Test with `@DataMongoTest`
- MongoTemplate
- CrudRepository

- `Not Included`
  - @Controller
  - @Service
  - @Component

### JSON serialization Slice Test with `@JsonTest`
- @JsonComponent
- ObjectMapper
- Module

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository
  
### HTTP clients Slice Test with `@RestClientTest`
- RestTemplateBuilder
- MockRestServiceServer

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository

### Whole Application Test with `@SpringBootTest`
- Everything included

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
