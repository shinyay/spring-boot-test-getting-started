package com.google.shinyay

import com.google.shinyay.controller.ViewController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@WebMvcTest(controllers = [ViewController::class])
class ViewControllerTest {
}