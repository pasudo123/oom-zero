package com.example.oomreference.weakrefernce

import com.example.oomreference.model.Person
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.ref.WeakReference

class WeakReferenceUsage {

    @Test
    @DisplayName("WeakReference 가리키는 값을 null 로 바꾸어도 무방하다.")
    fun usageWeakReference() {

        // given
        var person: Person? = Person.createRandom()
        val weakPerson = WeakReference(person)

        // then
        person shouldNotBe  null
        weakPerson.get() shouldNotBe null

        person = null
        weakPerson.get() shouldNotBe null
        person shouldBe null
    }
}