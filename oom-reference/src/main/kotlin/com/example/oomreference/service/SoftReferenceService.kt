package com.example.oomreference.service

import com.example.oomreference.constant.CountUtil.CHECK_COUNT
import com.example.oomreference.model.Person
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.lang.ref.SoftReference

@Service
class SoftReferenceService {

    private val log = LoggerFactory.getLogger(javaClass)

    fun incMemory() {

        val persons: MutableList<SoftReference<Person>> = mutableListOf()
        var count = 0L

        try {
            while (true) {
                persons.add(SoftReference(Person.createRandom()))
                count++

                if (count % CHECK_COUNT == 0L) {
                    log.info("count : $count")
                }
            }
        } catch (exception: Exception) {
            log.error("exception.message : ${exception.message}, count[$count]")
        }
    }
}