@file:Suppress("RedundantLambdaArrow")

package flavor.pie.kludge

import org.spongepowered.api.scheduler.Task
import java.util.concurrent.TimeUnit
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

fun task(fn: suspend TaskCoroutineContext.Companion.() -> Unit) {
    fn.startCoroutine(TaskCoroutineContext.Companion, Continuation(EmptyCoroutineContext) {})
}

fun task(plugin: Any, fn: suspend TaskCoroutineContext.() -> Unit) {
    fn.startCoroutine(TaskCoroutineContext(plugin), Continuation(EmptyCoroutineContext) {})
}

class TaskCoroutineContext(val plugin: Any) {

    companion object {
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
