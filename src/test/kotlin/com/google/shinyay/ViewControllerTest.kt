package com.google.shinyay

import com.google.shinyay.controller.ViewController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc

@WebMvcTest(controllers = [ViewController::class])
class ViewControllerTest(@Autowired val mockMvc: MockMvc) {
}