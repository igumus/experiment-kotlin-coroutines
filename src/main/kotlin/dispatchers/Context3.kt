package dispatchers

import info
import kotlinx.coroutines.*

// NOTE:
//  Coroutine start types
//      - DEFAULT
//      - LAZY
//      - ATOMIC
//      - UN DISPATCHED

fun main() {
    runBlocking {
        launch(start = CoroutineStart.DEFAULT) {
            info("(DEFAULT) Started later in thread")
        }
        launch(start = CoroutineStart.ATOMIC) {
            // NOTE: you can not cancel it before starting
            info("(ATOMIC) Started later in thread")
        }
        launch(context = Dispatchers.Default, start = CoroutineStart.UNDISPATCHED) {
            // NOTE: you can not cancel it before starting
            val waiting = 100L
            info("(UNDISPATCHED) Started immediately in thread")
            delay(waiting)
            info("(UNDISPATCHED) After $waiting ms delay in thread")
        }
        val job = launch(start = CoroutineStart.LAZY) {
            info("(LAZY) Started only on explicitly start thread")
        }
        info("---- Coroutines are launched")
        delay(300)
        info("Launching LAZY coroutine")
        job.start()
    }
}
