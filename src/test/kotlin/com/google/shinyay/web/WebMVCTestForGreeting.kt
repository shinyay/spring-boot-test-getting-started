package com.google.shinyay.web

import com.google.shinyay.controller.GreetingController
import com.google.shinyay.service.GreetingService
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(GreetingController::class)
class WebMVCTestForGreeting(
    @Autowired private val mockMvc: MockMvc
) {
    @MockBean private lateinit var service: GreetingService

    @Test
    fun greetingShouldBeOk() {
        `when`(service.hello()).thenReturn("Hello")

        mockMvc.perform(get("/greeting"))
            .andDo(print())
            .andExpect(status().isOk)
    }

    @Test
    fun greetingShouldReturnMessageFromService() {
        `when`(service.hello()).thenReturn("Hello")

        mockMvc.perform(get("/greeting"))
            .andDo(print())
            .andExpect(content().string(containsString("Hello")))
    }
}