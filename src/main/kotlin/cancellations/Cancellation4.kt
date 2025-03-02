package cancellations

import info
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import log
import warn

// NOTE: Closing the resources opened in coroutines
fun main() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    info("Iteration: $it...")
                    delay(500)
                }
            } finally {
                warn("Closing all resources")
            }
        }

        delay(1300)
        info("I am tired of waiting")
        job.cancelAndJoin()
        info("Now, I am quiting")
    }
}