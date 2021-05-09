package com.google.shinyay.service

import org.springframework.stereotype.Service

@Service
class HamcrestService {

    fun returnStringValue() = "foo"

    fun returnBlank() = ""

    fun returnStringList() = listOf<String>("Alice", "Bob", "Carol")

    fun returnRandomNumber() = (1..10).random()

    fun returnGirl() = People("Alice", 20)
    fun returnBoy() = People("Bob", 20, "Male")
    fun returnPeople(name: String, age: Int, gender: String) = People(name, age, gender)

    data class People(
        val name: String,
        val age: Int,
        val gender: String = "Female"
    )
}