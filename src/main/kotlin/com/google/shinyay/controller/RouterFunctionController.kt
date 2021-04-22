package com.google.shinyay.controller

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@Component
class RouterFunctionController {

    @Bean
    fun routes(): RouterFunction<ServerResponse> {
        return route(GET("/funtion/time"), { req ->
            ok().body(
                Flux.just(
                    "Current Time:",
                    ZonedDateTime.now(ZoneId.of("Japan")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
                ),
                String::class.java
            )
        })
    }
}