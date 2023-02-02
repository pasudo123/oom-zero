package com.example.oomwithk8s

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OomWithK8sApplication

fun main(args: Array<String>) {
    runApplication<OomWithK8sApplication>(*args)
}
