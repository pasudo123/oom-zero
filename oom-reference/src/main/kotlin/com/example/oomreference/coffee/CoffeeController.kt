package com.example.oomreference.coffee

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("coffees")
class CoffeeController(
    private val coffeeService: CoffeeService
) {

    @PostMapping
    fun create() {
        coffeeService.create()
    }
}