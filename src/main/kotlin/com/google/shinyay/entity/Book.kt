package com.google.shinyay.entity

import javax.persistence.*

@Entity
data class Book (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long
        )