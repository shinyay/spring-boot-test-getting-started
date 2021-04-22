package com.google.shinyay.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/reactive")
class WebFluxController {

    @GetMapping("/monotime")
    fun currentTime():Mono<String> {
        return Mono.just(ZonedDateTime.now(ZoneId.of("Japan")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")))
    }

    @GetMapping("/fluxtime")
    fun timeAndMessage(): Flux<String> {
        return Flux.just("Current Time",
            ZonedDateTime.now(ZoneId.of("Japan")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")),
            "Now"
        )
    }
}