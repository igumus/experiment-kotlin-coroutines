package dispatchers

import info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

// NOTE:
//  Each coroutine is launched in some coroutine context.
//  (like ThreadPool which is used to launch coroutines)
fun main() {
    runBlocking {
        launch {
            // context of the parent, main runBlocking coroutine
            info("Dispatcher: main, I am working in thread")
        }
        launch(Dispatchers.Unconfined) {
            // new confined -- will work with main thread
            info("Dispatcher: unconfined, I am working in thread")
        }
        launch(Dispatchers.Default) {
            // Will get dispatched to DefaultDispatcher
            // Default dispatchers are used for long-running CPU heavy ops.
            info("Dispatcher: default, I am working in thread")
        }

        // This new context should be closed or stored in some top-level variable
        // and used throughout the application
        val threadName = "MyOwnThread"
        newSingleThreadContext(threadName).let {
            launch(it) {
                // will get its own thread
                info("Dispatcher: $threadName, I am working in thread")
            }
            it.close()
        }
    }
}