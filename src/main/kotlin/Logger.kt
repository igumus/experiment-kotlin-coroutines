enum class LogLevel {
    INFO,
    WARN
}

fun log(level: LogLevel, msg: String) {
    println("[Level: $level, Thread: ${Thread.currentThread().name}] $msg")
}

fun info(msg: String) {
    log(LogLevel.INFO, msg)
}

fun warn(msg: String) {
    log(LogLevel.WARN, msg)
}