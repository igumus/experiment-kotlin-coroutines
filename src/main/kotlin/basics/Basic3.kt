package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import info

// NOTE: Coroutines are light-weight
fun main() {
    runBlocking {
        info("PROGRAM: Basic3.kt")
        repeat(10_000) {
            launch {
                delay(200)
                info("Operation#$it")
            }
        }
    }
    info("Coroutines finished execution")
}
