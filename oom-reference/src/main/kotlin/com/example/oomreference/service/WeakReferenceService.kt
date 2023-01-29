package com.example.oomreference.service

import com.example.oomreference.constant.CountUtil.CHECK_COUNT
import com.example.oomreference.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.ref.WeakReference

@Service
class WeakReferenceService {

    private val log = LoggerFactory.getLogger(javaClass)

    fun incMemory() {

        val persons: MutableList<WeakReference<Person>> = mutableListOf()
        var count = 0L

        try {
            while (true) {
                persons.add(WeakReference(Person.createRandom()))
                count++
                // persons.last().get()

                if (count % CHECK_COUNT == 0L) {
                    log.info("count : $count")
                }
            }
        } catch (exception: Exception) {
            log.error("exception.message : ${exception.message}, count[$count]")
        }
    }
}