package com.example.oomreference.model

import java.util.UUID
import kotlin.random.nextULong

data class Coffee(
    val name: String,
    val price: Long
) {

    companion object {
        fun createRandom(): Coffee {
            return Coffee(
                name = "아메리카노-${UUID.randomUUID()}",
                price = Random.nextLong(1000, 10000)
            )
        }
    }
}