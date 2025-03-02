package dispatchers

import info
import kotlinx.coroutines.*

// NOTE: Unconfined vs Confined
fun main() {
    runBlocking {
        launch(Dispatchers.Unconfined) {
            // runs immediately
            // not confined -- will work with main thread
            val name = "Unconfined"
            info(name)
            val delayAmount = 100L
            withContext(Dispatchers.Default) {
                delay(delayAmount)
            }
            info("$name after $delayAmount ms")
        }

        launch {
            val name = "main"
            info(name)
            val delayAmount = 200L
            withContext(Dispatchers.Default) {
                delay(delayAmount)
            }
            info("$name after $delayAmount ms")
        }
        info("------ Coroutines are launched ------------ ")
    }
}
