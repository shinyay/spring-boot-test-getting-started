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
### Slicing Test
|Test Slice|Imported Auto-Configuration|
|----------|---------------------------|
|`@WebMvcTest`|CacheAutoConfiguration<br>MessageSourceAutoConfiguration<br>SpringDataWebAutoConfiguration<br>FreeMarkerAutoConfiguration<br>GroovyTemplateAutoConfiguration<br>GsonAutoConfiguration<br>HypermediaAutoConfiguration<br>HttpMessageConvertersAutoConfiguration<br>JacksonAutoConfiguration<br>JsonbAutoConfiguration<br>MustacheAutoConfiguration<br>OAuth2ClientAutoConfiguration<br>OAuth2ResourceServerAutoConfiguration<br>SecurityAutoConfiguration<br>SecurityFilterAutoConfiguration<br>UserDetailsServiceAutoConfiguration<br>TaskExecutionAutoConfiguration<br>ThymeleafAutoConfiguration<br>ValidationAutoConfiguration<br>HttpEncodingAutoConfiguration<br>WebMvcAutoConfiguration<br>ErrorMvcAutoConfiguration<br>MockMvcAutoConfiguration<br>MockMvcSecurityConfiguration<br>MockMvcWebClientAutoConfiguration<br>MockMvcWebDriverAutoConfiguration|
|`@WebFluxTest`|CacheAutoConfiguration<br>MessageSourceAutoConfiguration<br>FreeMarkerAutoConfiguration<br>GsonAutoConfiguration<br>CodecsAutoConfiguration<br>JacksonAutoConfiguration<br>JsonbAutoConfiguration<br>MustacheAutoConfiguration<br>ReactiveOAuth2ClientAutoConfiguration<br>ReactiveOAuth2ResourceServerAutoConfiguration<br>ReactiveSecurityAutoConfiguration<br>ReactiveUserDetailsServiceAutoConfiguration<br>ThymeleafAutoConfiguration<br>ValidationAutoConfiguration<br>WebFluxAutoConfiguration<br>ErrorWebFluxAutoConfiguration<br>WebTestClientAutoConfiguration|
|`@RestClientTest`|CacheAutoConfiguration<br>GsonAutoConfiguration<br>HttpMessageConvertersAutoConfiguration<br>CodecsAutoConfiguration<br>JacksonAutoConfiguration<br>JsonbAutoConfiguration<br>RestTemplateAutoConfiguration<br>WebClientAutoConfiguration<br>MockRestServiceServerAutoConfiguration<br>WebClientRestTemplateAutoConfiguration|
|`@DataJdbcTest`|CacheAutoConfiguration<br>JdbcRepositoriesAutoConfiguration<br>FlywayAutoConfiguration<br>DataSourceAutoConfiguration<br>DataSourceTransactionManagerAutoConfiguration<br>JdbcTemplateAutoConfiguration<br>LiquibaseAutoConfiguration<br>TransactionAutoConfiguration<br>TestDatabaseAutoConfiguration|
|`@DataJpaTest`|CacheAutoConfiguration<br>JpaRepositoriesAutoConfiguration<br>FlywayAutoConfiguration<br>DataSourceAutoConfiguration<br>DataSourceTransactionManagerAutoConfiguration<br>JdbcTemplateAutoConfiguration<br>LiquibaseAutoConfiguration<br>HibernateJpaAutoConfiguration<br>TransactionAutoConfiguration<br>TestDatabaseAutoConfiguration<br>TestEntityManagerAutoConfiguration|
|`@DataR2dbcTest`|R2dbcDataAutoConfiguration<br>R2dbcRepositoriesAutoConfiguration<br>FlywayAutoConfiguration<br>LiquibaseAutoConfiguration<br>R2dbcAutoConfiguration<br>R2dbcTransactionManagerAutoConfiguration<br>TransactionAutoConfiguration|
||<br><br><br><br><br><br><br>|
|||
|||
|||
|||
|||
|||

- 
- `@DataMongoTest`
- `@DataRedisTest`
- `@DataLdapTest`
- `@JsonTest`
- (`@SpringBootTest`)

Reference: [Test Auto-configuration Annotations](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-test-auto-configuration.html)

#### Web layer Slice Test with `@WebMvcTest`
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
  
##### Test Practices - MockMvcResultMatchers
Static factory methods for ResultMatcher-based result actions.

- RequestResultMatchers
  - accessed via `MockMvcResultMatchers.request()`
  - Factory for assertions on the request
- ModelResultMatchers
  - accessed via `MockMvcResultMatchers.model()`
  - Factory for assertions on the model
- ViewResultMatchers
  - accessed via `MockMvcResultMatchers.view()`
  - Factory for assertions on the selected view
- StatusResultMatchers
  - accessed via `MockMvcResultMatchers.status()`
  - Factory for assertions on the response status
- ContentResultMatchers
  - accessed via `MockMvcResultMatchers.content()`
  - Factory for response content assertions
- HeaderResultMatchers
  - available via `MockMvcResultMatchers.header()`
  - Factory for response header assertions

#### Web Flux Slice Test with `@WebFluxTest`

#### REST Clients Slice Test with `@RestClientTest`
- RestTemplateBuilder
- MockRestServiceServer

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository

##### Test Practices - MockRestServiceServer
@RestClientTest annotation is used to test RestTemplate to interact with external services.
The Spring Test module includes a mock server named MockRestServiceServer.
With this approach, we configure the server to return a particular object when a specific request is dispatched through our RestTemplate instance.

```kotlin
mockServer.expect(ExpectedCount.once(), 
  requestTo(new URI("http://localhost:8080/employee/E001")))
  .andExpect(method(HttpMethod.GET))
  .andRespond(withStatus(HttpStatus.OK)
  .contentType(MediaType.APPLICATION_JSON)
  .body(mapper.writeValueAsString(emp))
)
```

#### JPA Components Slice Test with `@DataJpaTest`
`@DataJpaTest` makes you can test any JPA related parts.
- @Repository
- EntityManager
- TestEntityManager
- DataSource

- `Not Included`
  - @Controller
  - @Service
  - @Component

##### Test Practices - Spring Data JPA
**Setup Before Test**

You can use `TestEntityManager` to operate Database instead of Repository Class.

```kotlin
@Autowired
lateinit var entityManager: TestEntityManager
```

**Display SQL Logging on Standard out and Logging Framework**
```yaml
spring:
  jpa:
    show-sql: true
    properties:
      hibernate:
        format_sql: true
logging:
  level:
    org:
      hibernate:
        SQL: DEBUG
        type:
          descriptor:
            sql:
              BasicBinder: TRACE
```

#### JDBC access Slice Test with `@DataJdbcTest`
If your application uses the `JdbcTemplate` instead of JPA for the database access, Spring Boot also covers testing this slice of your application.
- JdbcTemplate
- DataSource

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository

##### Test Practices - Spring Data JDBC
**`@Sql` Annotation**
@Sql annotation allows us to specify the SQL files to run before the test.

- `scripts`: we can declare the paths to SQL script files to execute
- `statements`: we can declare inline SQL statements to execute
- `executionPhase`: we can also specify when to execute the scripts
  - `BEFORE_TEST_METHOD`
  - `AFTER_TEST_METHOD`
- `config`: local configuration for the SQL scripts
  - `@SqlConfig`
    - `blockCommentStartDelimiter`: delimiter to identify the start of block comments in SQL script files
    - `blockCommentEndDelimiter`: delimiter to denote the end of block comments in SQL script files
    - `commentPrefix`: prefix to identify single-line comments in SQL script files
    - `dataSource`: name of the javax.sql.DataSource bean against which the scripts and statements will be run
    - `encoding`: encoding for the SQL script files, default is platform encoding
    - `errorMode`: mode that will be used when an error is encountered running the scripts
    - `separator`: string used to separate individual statements, default is “–“
    - `transactionManager`: bean name of the PlatformTransactionManager that will be used for transactions
    - `transactionMode`: the mode that will be used when executing scripts in transaction

You can deploy SQL files under `src/main/resources` and `src/test/resources`
The following files are loadable:
- `schema.sql`
- `schema-${platform}.sql`
- `data.sql`
- `data-${platform}.sql`

`${platform}` is specified by `spring.datasource.platform`

```kotlin
@Sql(scripts = ["classpath:schema.sql", "classpath:data.sql"])
```

**`@Import` Annotation**
Test class can not load Repository class. Therefore we should use `@Import` to load the class specifically.

```kotlin
@Import(MemberJdbcRepository::class)
```

#### MongoDB access Slice Test with `@DataMongoTest`
- MongoTemplate
- CrudRepository

- `Not Included`
  - @Controller
  - @Service
  - @Component

#### JSON serialization Slice Test with `@JsonTest`
- @JsonComponent
- ObjectMapper
- Module

- `Not Included`
  - @Controller
  - @Service
  - @Component
  - @Repository

#### Whole Application Test with `@SpringBootTest`
- Everything included





## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References
- [Spring Boot Feature - Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing)
- [MockMvcResultMatchers API Document](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/web/servlet/result/MockMvcResultMatchers.html)
- [Sliced Test Auto-configuration Annotations](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-test-auto-configuration.html)

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
