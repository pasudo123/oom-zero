package com.example.oomreference.coffee

import java.time.LocalDate
import kotlin.random.Random

data class Coffee(
    val name: String,
    val store: String,
    val origin: String,
    val price: Long,
    val expiration: LocalDate
) {

    companion object {
        val originGroup = listOf("쿠바", "에티오피아", "케냐", "콩고", "리베리아", "콜롬비아", "브라질", "인도네시아", "코스타리카")

        fun createRandom(): Coffee {
            return Coffee(
                name ="아메리카노-${Random.nextLong(1000, 10000)}",
                store = "엔제리너스-${Random.nextLong(1000, 10000)}",
                origin = originGroup.shuffled().first(),
                price = Random.nextLong(10, 100000000),
                expiration = LocalDate.now().plusDays(Random.nextLong(1, 40))
            )
        }
    }
}
