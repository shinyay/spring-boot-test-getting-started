package com.google.shinyay.entity

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var title: String = "",
    var author: String = "",
    var price: Long = 0
)