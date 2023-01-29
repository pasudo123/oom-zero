package com.example.oomreference.develop

import com.example.oomreference.service.BasicService
import com.example.oomreference.service.WeakReferenceService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dev")
class DevController(
    private val basicService: BasicService,
    private val weakReferenceService: WeakReferenceService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("basic")
    fun createBasic() {
        log.info("basic start")
        basicService.incMemory()
    }

    @PostMapping("weak-ref")
    fun createWeakReference() {
        log.info("weak-reference start")
        weakReferenceService.incMemory()
    }
}