package com.google.shinyay.handler

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Component
class WebFluxHandler {
    fun currentTime(): Mono<ServerResponse> {
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))
        val json = """
            {
              "message" : "Now - $currentTime"
            }
        """.trimMargin()
        return ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(Flux.just(json), String::class.java)
    }
}