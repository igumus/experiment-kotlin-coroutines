package dispatchers

import info
import kotlinx.coroutines.*

// NOTE: You can combine a few context elements when launching a coroutine
fun main() {
    runBlocking {
        val myJob = Job()
        val myName = "test"
        launch(context = Dispatchers.Default + myJob + CoroutineName(myName)) {
            info("coroutine($myName) is working")
        }
        info("--- Coroutines are launched")
    }
}