package basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import info

// NOTE: coroutineScope{} builder
fun main() {
    runBlocking {
        info("PROGRAM: Basic2.kt")
        doWork()
        info("Coroutines launched execution")
    }
    info("Coroutines finished execution")
}

private suspend fun doWork() {
    coroutineScope {
        launch {
            info("work#1 started")
            delay(200)
            info("work#1 finished")
        }

        launch {
            info("work#2 started")
            delay(200)
            info("work#2 finished")
        }
        info("doWork launched")
    }
}