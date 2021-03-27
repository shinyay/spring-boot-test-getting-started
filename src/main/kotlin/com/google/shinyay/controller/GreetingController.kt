package com.google.shinyay.controller

import com.google.shinyay.service.GreetingService
import org.springframework.stereotype.Controller

@Controller
class GreetingController(val service: GreetingService) {
}