package dispatchers

import info
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// NOTE: Explicit creation of coroutine scope
fun main() {
    CoroutineScope(Dispatchers.IO).launch {
        work("op#1")
    }
    CoroutineScope(Dispatchers.Default).launch {
        work("op#2")
    }
    info("----- Coroutines are launched")
    Thread.sleep(2000)
}

private suspend fun work(name: String) {
    info("($name) Do some long running operation in thread")
    delay(1000)
    info("($name) Finished long running operation in thread")
}
