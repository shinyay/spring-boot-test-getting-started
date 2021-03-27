package com.google.shinyay.controller

import com.google.shinyay.service.GreetingService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController(val service: GreetingService) {

    @RequestMapping("/greeting")
    @ResponseBody
    fun greeting() = service.hello()
}