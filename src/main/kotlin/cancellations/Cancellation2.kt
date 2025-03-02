package cancellations

import kotlinx.coroutines.*
import info

// NOTE: Cancellation is cooperative process
fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis()

        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var n = 0
            while (n < 10) {
                if (System.currentTimeMillis() > nextPrintTime) {
                    info("Doing Iteration ${n++}")
                    nextPrintTime += 500L
                }
                // NOTE:
                //  If we don't call yield, coroutine is going to execute until inner loop breaks.
                //  Which means waits for coroutine done.
                yield()
                // or if (!isActive) return@launc
            }
        }
        delay(1000)
        info("I am tired of waiting!")
        job.cancelAndJoin()
        info("Now, I am quiting!")

    }
}