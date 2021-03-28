package com.google.shinyay

import com.google.shinyay.controller.GreetingController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(GreetingController::class)
class WebMVCTestForGreeting(val mockMVC: MockMvc) {
}