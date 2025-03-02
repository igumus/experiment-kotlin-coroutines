package suspendedfuncs

import info
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// NOTE: Suspend functions are sequential by default
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = doWorkOne()
            val two = doWorkTwo()
            info("The answer is ${one + two}")
        }
        info("Completed in $time ms, expected execution time ~2000ms")
    }
}

private suspend fun doWorkOne(): Int {
    delay(1000)
    return 13
}

private suspend fun doWorkTwo(): Int {
    delay(1000)
    return 23
}
