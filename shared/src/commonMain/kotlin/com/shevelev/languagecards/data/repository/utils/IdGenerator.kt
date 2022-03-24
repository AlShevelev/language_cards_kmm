package com.shevelev.languagecards.data.repository.utils

import kotlin.random.Random

object IdGenerator {
    fun newId(): Long {
        val buffer = Random.nextBytes(16)
        val seed = Random.nextLong()

        return Murmur2.hash(buffer, seed)
    }
}