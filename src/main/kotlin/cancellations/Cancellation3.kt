package cancellations

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import info

// NOTE: Timeout cancellation

fun main() {
    runBlocking {
        timeoutWithNull()
        info("Coroutines are launched")
    }
}

suspend fun timeoutWithNull() {
    val result = withTimeoutOrNull(500) {
        repeat(1000) {
            info("I am sleeping $it...")
            delay(10)
        }
        "timeoutWithNull"
    }
    info("`timeoutWithNull` result: $result")
}