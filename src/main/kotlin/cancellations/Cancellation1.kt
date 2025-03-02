package cancellations

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import info

// NOTE: You can cancel the coroutine whenever you need
fun main() {
    runBlocking {
        val job = launch {
            repeat(1000) {
                info("Iteration $it")
                delay(500)
            }
        }
        info("Coroutine launched")
        delay(1500)
        info("I am tired of waiting!")
        job.cancelAndJoin()
        info("Now I am quiting")
    }
}