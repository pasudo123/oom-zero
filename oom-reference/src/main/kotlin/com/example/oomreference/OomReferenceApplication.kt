package com.example.oomreference

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class OomReferenceApplication

fun main(args: Array<String>) {
    runApplication<OomReferenceApplication>(*args)
}
