@file:Suppress("RedundantLambdaArrow")

package flavor.pie.kludge

import org.spongepowered.api.scheduler.Task
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.RestrictsSuspension
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine
import flavor.pie.kludge.plugin as plugin_

fun task(plugin: Any = plugin_, fn: suspend TaskCoroutineContext.() -> Unit) {
    fn.startCoroutine(TaskCoroutineContext(plugin), Continuation(EmptyCoroutineContext) {})
}

fun taskCancellable(plugin: Any = plugin_, fn: suspend TaskCoroutineContextCancellable.() -> Unit): CoroutineTask {
    val context = TaskCoroutineContextCancellable(plugin)
    fn.startCoroutine(context, Continuation(EmptyCoroutineContext) {})
    return context.task
}

class TaskCoroutineContext internal constructor (private val plugin: Any) {

    suspend fun desync() {
        suspendCoroutine<Unit> { cont ->
            Task.builder().async().execute { ->
                cont.resume(Unit)
            }.submit(plugin)
        }
    }

    suspend fun resync() {
        if (!Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                Task.builder().execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

    suspend fun delayTicks(ticks: Long) {
        if (Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                Task.builder().delayTicks(ticks).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        } else {
            suspendCoroutine<Unit> { cont ->
                Task.builder().async().delayTicks(ticks).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

    suspend fun delay(delay: Long, unit: TimeUnit) {
        if (Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                Task.builder().delay(delay, unit).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        } else {
            suspendCoroutine<Unit> { cont ->
                Task.builder().async().delay(delay, unit).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

}

@RestrictsSuspension
class TaskCoroutineContextCancellable internal constructor (private val plugin: Any = plugin_) {

    internal var task: CoroutineTask = CoroutineTask()

    suspend fun desync() {
        suspendCoroutine<Unit> { cont ->
            if (!task.isRunning) {
                return@suspendCoroutine
            }
            task.lastTask = Task.builder().async().execute { ->
                cont.resume(Unit)
            }.submit(plugin)
        }
    }

    suspend fun resync() {
        if (!Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                if (!task.isRunning) {
                    return@suspendCoroutine
                }
                task.lastTask = Task.builder().execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

    suspend fun delayTicks(ticks: Long) {
        if (Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                if (!task.isRunning) {
                    return@suspendCoroutine
                }
                task.lastTask = Task.builder().delayTicks(ticks).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        } else {
            suspendCoroutine<Unit> { cont ->
                if (!task.isRunning) {
                    return@suspendCoroutine
                }
                task.lastTask = Task.builder().async().delayTicks(ticks).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

    suspend fun delay(delay: Long, unit: TimeUnit) {
        if (Server.isMainThread) {
            suspendCoroutine<Unit> { cont ->
                if (!task.isRunning) {
                    return@suspendCoroutine
                }
                task.lastTask = Task.builder().delay(delay, unit).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        } else {
            suspendCoroutine<Unit> { cont ->
                if (!task.isRunning) {
                    return@suspendCoroutine
                }
                task.lastTask = Task.builder().async().delay(delay, unit).execute { ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }

}

class CoroutineTask internal constructor () {

    internal var lastTask: Task? = null

    var isRunning: Boolean = false
        private set
    fun cancel() {
        lastTask?.cancel()
        isRunning = false
    }

}
