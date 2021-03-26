package com.google.shinyay

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootTestGettingStartedApplication

fun main(args: Array<String>) {
	runApplication<SpringBootTestGettingStartedApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this::class.java)
