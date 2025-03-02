package suspendedfuncs

import info
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// NOTE: LAZY start won't launch coroutines until done explicitly
fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { doWorkOne() }
            val two = async(start = CoroutineStart.LAZY) { doWorkTwo() }

            one.start()
            two.start()

            // NOTE:
            //  without start function invocation await will wait
            //  until got result. Execution took ~2000ms
            info("The answer is ${one.await() + two.await()}")

            // val concurrentSum = doConcurrentSum()
            // info("The answer is $concurrentSum")
        }
        info("Completed execution in $time ms")
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

private suspend fun doConcurrentSum() {
    coroutineScope {
        val one = async { doWorkOne() }
        val two = async { doWorkTwo() }
        one.await() + two.await()
    }
}