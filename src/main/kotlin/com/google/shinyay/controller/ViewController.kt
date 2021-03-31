package com.google.shinyay.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class ViewController {

    @GetMapping("/home")
    fun home(viewHome: ModelAndView): ModelAndView {
        viewHome.viewName = "home"
        viewHome.addObject("msg", "shinyay")
        return viewHome
    }
}