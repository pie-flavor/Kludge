@file:Suppress("RedundantLambdaArrow")

package flavor.pie.kludge

import org.spongepowered.api.scheduler.Task
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine
import flavor.pie.kludge.plugin as plugin_

fun task(fn: suspend () -> Unit) {
    fn.startCoroutine(Continuation(EmptyCoroutineContext) {})
}

fun task(plugin: Any, fn: suspend TaskCoroutineContext.() -> Unit) {
    fn.startCoroutine(TaskCoroutineContext(plugin), Continuation(EmptyCoroutineContext) {})
}

suspend fun desync(plugin: Any = plugin_) {
    suspendCoroutine<Unit> { cont ->
        Task.builder().async().execute { ->
            cont.resume(Unit)
        }.submit(plugin)
    }
}

suspend fun resync(plugin: Any = plugin_) {
    if (!Server.isMainThread) {
        suspendCoroutine<Unit> { cont ->
            Task.builder().execute { ->
                cont.resume(Unit)
            }.submit(plugin)
        }
    }
}

suspend fun delayTicks(ticks: Long, plugin: Any = plugin_) {
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

suspend fun delay(delay: Long, unit: TimeUnit, plugin: Any = plugin_) {
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

class TaskCoroutineContext(private val plugin: Any) {

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
