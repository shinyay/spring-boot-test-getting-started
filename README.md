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
