package com.google.shinyay.web

import com.google.shinyay.controller.ViewController
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(controllers = [ViewController::class])
class ViewControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun homePage() {
        mockMvc.perform(
            get("/home")
        )
            .andDo(print())
            .andExpect {
            status().is2xxSuccessful
            view().name("home")
            model().attributeExists("msg")
            model().attribute("msg", "shinyay")
            content().contentType(MediaType.TEXT_HTML)
            content().string(containsString("shinyay"))
        }

    }
}