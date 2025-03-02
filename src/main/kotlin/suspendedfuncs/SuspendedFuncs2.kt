package suspendedfuncs

import info
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// NOTE: You can launch suspended functions asynchronously using async/launch coroutine builders
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async { doWorkOne() }
            val two = async { doWorkTwo() }
            info("The answer is ${one.await() + two.await()}")
        }
        info("Completed in $time ms, expected execution time ~1000ms")
    }
}

private suspend fun doWorkOne(): Int {
    // pretend we are doing something useful here
    delay(1000)
    return 13
}

private suspend fun doWorkTwo(): Int {
    // pretend we are doing something useful here
    delay(1000)
    return 23
}
