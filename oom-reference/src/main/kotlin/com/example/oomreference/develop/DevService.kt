package com.example.oomreference.develop

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DevService {

    private val log = LoggerFactory.getLogger(javaClass)

    fun incMemory() {

        val persons: MutableList<Person> = mutableListOf()
        var count = 0L

        try {
            while (true) {
                persons.add(Person(
                    "홍${UUID.randomUUID()}".substring(10),
                    "홍${UUID.randomUUID()}".substring(10),
                    "홍${UUID.randomUUID()}".substring(10)
                ))
                count++

                if (count % 1000000L == 0L) {
                    log.info("count : $count")
                }
            }
        } catch (exception: Exception) {
            log.error("exception.message : ${exception.message}, count[$count]")
        }
    }
}