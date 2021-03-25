package com.google.shinyay.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    fun hello() = "Hello"
}