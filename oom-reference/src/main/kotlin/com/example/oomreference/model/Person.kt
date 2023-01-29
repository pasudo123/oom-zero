package com.example.oomreference.model

import java.util.UUID

data class Person(
    val name1: String,
    val name2: String,
    val name3: String,
) {

    companion object {
        fun createRandom(): Person {
            return Person(
                "홍${UUID.randomUUID()}".substring(10),
                "홍${UUID.randomUUID()}".substring(10),
                "홍${UUID.randomUUID()}".substring(10)
            )
        }
    }
}