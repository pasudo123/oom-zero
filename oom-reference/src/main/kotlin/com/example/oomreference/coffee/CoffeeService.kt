package com.example.oomreference.coffee

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CoffeeService {

    private val log = LoggerFactory.getLogger(javaClass)

    fun create() = runBlocking {

        val coffees = mutableListOf<Coffee>()

        while (true) {
            val current = Coffee.createRandom()

            if (current.price == 100L) {
                log.info("[clear] coffee.size[${coffees.size}], current : $current")
                coffees.clear()
            }

            coffees.add(current)

            if (coffees.size % 10000 == 0) {
                delay(1000)
                log.info("coffee ${coffees.size} 돌파!!")
            }
        }
    }
}