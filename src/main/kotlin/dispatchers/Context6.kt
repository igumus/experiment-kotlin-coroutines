package dispatchers

import info
import kotlinx.coroutines.*

// NOTE: Children of coroutine
fun main() {
    runBlocking {
        // launch a coroutine to process some kind of incoming request
        val request = launch {
            // this coroutine inherits the parent coroutine context, and it's job is a child of parent job
            // (parent context, and job connected to parent job)
            launch {
                work("job1")
            }
            // still inherits parent job, so will be bound to parent coroutine and cancel
            // (Context from Dispatchers.IO, but job is connected to parent job
            launch(Dispatchers.IO) {
                work("job2")
            }

            // Coroutine with other job specified
            // (parent context, but now connected to other job)
            launch(Job()) {
                work("job3")
            }
            info("---- (request) Coroutines are launched")
        }
        info("---- Coroutines are launched")
    }
}

private suspend fun work(name: String, delayAmount: Long = 1000L) {
    info("($name) started in thread")
    delay(delayAmount)
    info("($name) finished in thread")
}
