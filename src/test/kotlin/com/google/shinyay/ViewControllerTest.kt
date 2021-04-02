package com.google.shinyay

import com.google.shinyay.controller.ViewController
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [ViewController::class])
class ViewControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun homePage() {
        mockMvc.perform(
            get("/home")
        ).andExpect(status().is2xxSuccessful)
            .andExpect(view().name("home"))
            .andExpect(model().attributeExists("msg"))
            .andExpect(model().attribute("msg", "shinyay"))
            .andExpect(content().contentType("text/html;charset=UTF-8"))
            .andExpect(content().string(containsString("shinyay")))
    }
}