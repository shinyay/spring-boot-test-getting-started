package com.google.shinyay

import com.google.shinyay.controller.GreetingController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@WebMvcTest(GreetingController::class)
class WebMVCTestForGreeting {
}