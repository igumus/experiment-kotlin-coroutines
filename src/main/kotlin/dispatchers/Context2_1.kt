package dispatchers

import info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// NOTE: Unconfined dispatcher coroutines launch immediately
fun main() {
    runBlocking {
        launch(Dispatchers.Unconfined) {
            repeat(10) {
                info("Iteration: $it")
            }
        }
        info("----- Coroutines are launched")
    }
}