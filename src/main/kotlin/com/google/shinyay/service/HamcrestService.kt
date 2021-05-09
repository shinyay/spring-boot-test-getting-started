package com.google.shinyay.service

import org.springframework.stereotype.Service

@Service
class HamcrestService {

    fun returnStringValue() = "foo"

    fun returnBlank() = ""

    fun returnStringList() = listOf<String>("Alice", "Bob", "Carol")

    fun returnRandomNumber() = (1..10).random()

    fun returnPeople() = People("Alice", 20)

    data class People(
        val name: String,
        val age: Int
    )
}