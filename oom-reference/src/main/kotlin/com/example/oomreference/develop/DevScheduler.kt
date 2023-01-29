package com.example.oomreference.develop

import com.example.oomreference.service.BasicService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DevScheduler(
    private val basicService: BasicService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Scheduled(cron = "0 */1 * * * *")
    fun task() {
        // log.info("Hello : ${LocalDateTime.now()}")
    }
}