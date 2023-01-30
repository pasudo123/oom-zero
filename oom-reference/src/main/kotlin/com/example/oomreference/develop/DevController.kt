package com.example.oomreference.develop

import com.example.oomreference.service.StrongReferenceService
import com.example.oomreference.service.SoftReferenceService
import com.example.oomreference.service.WeakReferenceService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dev")
class DevController(
    private val strongReferenceService: StrongReferenceService,
    private val weakReferenceService: WeakReferenceService,
    private val softReferenceService: SoftReferenceService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("strong-ref")
    fun createBasic() {
        log.info("@@@ strong-reference start")
        strongReferenceService.incMemory()
    }

    @PostMapping("strong-ref/static")
    fun createBasicWithStatic() {
        log.info("@@@ strong-reference start with static")
        strongReferenceService.incMemoryWithStatic()
    }

    @PostMapping("weak-ref")
    fun createWeakReference() {
        log.info("@@@ weak-reference start")
        weakReferenceService.incMemory()
    }

    @PostMapping("soft-ref")
    fun createSoftReference() {
        log.info("@@@ soft-reference start")
        softReferenceService.incMemory()
    }


}