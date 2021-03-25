package com.google.shinyay

import com.google.shinyay.controller.HelloController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContextTests(@Autowired val helloController: HelloController) {

	@Test
	fun contextLoads() {
		assertThat(helloController).isNotNull
	}

}
