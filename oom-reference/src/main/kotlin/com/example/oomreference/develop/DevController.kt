package com.example.oomreference.develop

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dev")
class DevController(
    private val devService: DevService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("basic")
    fun createBasic() {
        log.info("basic start")
        devService.incMemory()
    }

    @PostMapping("weak-ref")
    fun createWeakReference() {

    }
}