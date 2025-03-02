package dispatchers

import info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// NOTE: Coroutines can switch threads on the go
fun main() {
    runBlocking {
        launch(Dispatchers.IO) {
            work("Coroutine#1")
        }
        launch(Dispatchers.IO) {
            work("Coroutine#2")
        }
        info("--- Coroutines are launched")
    }
}

private suspend fun work(tag: String) {
    val amount = 1000L
    info("($tag) Working")
    delay(amount)
    info("($tag) Working after delayOf(${amount}ms)")
    delay(amount)
    info("($tag) Working after delayOf(${amount}ms)")
}