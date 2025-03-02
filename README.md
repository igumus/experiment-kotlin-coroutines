# Kotlin Coroutines Exploration

This repo is a place to experiment and explore Kotlin's powerful `Coroutines` API to understand asynchronous
programming, concurrency, and structured concurrency in Kotlin.

## Table of Contents

- [Why Kotlin Coroutines?](#why-kotlin-coroutines)
- [Installation](#installation)
- [Code Examples](#code-examples)

## Why Kotlin Coroutines?

Kotlin Coroutines are a powerful tool for asynchronous programming. They allow for writing non-blocking code that is
easier to read and maintain than traditional callback-based approaches. With Kotlin Coroutines, you can:

- Write asynchronous code in a sequential manner
- Simplify complex concurrency tasks
- Avoid callback hell and nested async code
- Manage thread pools more efficiently

## Installation

To get started with the Kotlin Coroutines examples, you need to have the following set up on your system:

1. **Install Kotlin**: Make sure you have Kotlin installed. You can use [IntelliJ IDEA](https://www.jetbrains.com/idea/)
   or any IDE of your choice.
2. **Add the Coroutines Dependency**: To use Kotlin Coroutines in your project, add the following to your `build.gradle`
   or `build.gradle.kts` file:

    ```gradle
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    ```

   Alternatively, you can also use a newer version of Kotlin Coroutines by checking the
   latest [releases](https://github.com/Kotlin/kotlinx.coroutines/releases).

3. **Sync Gradle**: After adding the dependency, sync your project to download the required libraries.

## Code Examples

Some of the key topics include:

1. [Basic Coroutines](src/main/kotlin/basics): How to launch and manage simple coroutines.
2. [Cancellation](src/main/kotlin/cancellations): Cancellation experiments.
3. [Dispatchers](src/main/kotlin/dispatchers): Exploring coroutine contexts.
4. [Flows](src/main/kotlin/flows): Exploring Kotlin Flows for handling streams of data asynchronously.
5. [Suspend Functions](src/main/kotlin/suspendedfuncs): Using suspend functions to write non-blocking code.
6. Coroutine Builders: Exploring launch, async, and other coroutine builders.
7. Error Handling in Coroutines: TBD
8. Channels: TBD
9. Actors: TBD


