package com.google.shinyay.service

import com.google.shinyay.logger
import org.springframework.stereotype.Service
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Service
class GreetingService {
    fun hello() = "Hello"

    fun helloAtCurrentTime(): String {
        val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:dd.ss.SSS")
        val currentTime = ZonedDateTime.now(ZoneId.of("Japan")).format(dateTimeFormat)
        logger.info(currentTime)
        return "Hello at $currentTime"
    }
}