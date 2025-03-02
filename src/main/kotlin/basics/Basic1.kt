package basics

import info
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        info("PROGRAM: Basic1.kt")
        launch {
            doOperation("Launch#1")
        }

        val deferred = async {
            doOperation("Async#1")
            1000
        }

        info("Coroutines launched execution")
        info("Async Operation Result: ${deferred.await()}")
        info("Coroutines finished execution")
    }
}

private suspend fun doOperation(text: String) {
    repeat(3) {
        info("Inside doOperation: $text")
        delay(200)
    }
}