package flows

import info
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// NOTE:
//  `flow` is a powerful instrument for working with an async streams of data.
//  It is similar in some way to Kotlin sequence because it's sequential and col
//  And to Android.LiveData because you can subscribe to updates from it

// The difference is that flows are async and utilize coroutine API and
// suspend functions for producing values.

fun main() {
    runBlocking {
        launch {
            basicIteration()
        }
        simpleFlow().collect { value ->
            info("The flow value: $value")
        }
        info("FIN")
    }
}

private suspend fun basicIteration(from: Int = 1, to: Int = 10, delayBetween: Long = 200) {
    for (k in from..to) {
        info("I am not block $k")
        delay(delayBetween)
    }
}

private fun simpleFlow(): Flow<Int> = flow {
    repeat(10) {
        emit(it)
        delay(200)
    }
}