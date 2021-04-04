package com.google.shinyay.entity

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,
    var title: String,
    var author: String,
    var price: Long
)