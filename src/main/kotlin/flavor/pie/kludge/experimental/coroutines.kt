package flavor.pie.kludge.experimental

import flavor.pie.kludge.*
import org.spongepowered.api.scheduler.Task
import java.util.concurrent.TimeUnit
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine


fun taskCoroutine(fn: suspend TaskCoroutineContext.() -> Unit) {
    fn.startCoroutine(TaskCoroutineContext, TaskContinuation)
}

object TaskCoroutineContext {
    suspend fun desync() {
        suspendCoroutine<Unit> { cont ->
            Task.builder().async().execute { _ ->
                cont.resume(Unit)
            }.submit(plugin)
        }
    }
    suspend fun resync() {
        if (Server.isMainThread) {
            return
        } else {
            suspendCoroutine<Unit> { cont ->
                Task.builder().execute { _ ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }
    suspend fun delayTicks(ticks: Long) {
        suspendCoroutine<Unit> { cont ->
            if (Server.isMainThread) {
                Task.builder().delayTicks(ticks).execute { _ ->
                    cont.resume(Unit)
                }.submit(plugin)
            } else {
                Task.builder().async().delayTicks(ticks).execute { _ ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }
    suspend fun delay(num: Long, unit: TimeUnit) {
        suspendCoroutine<Unit> { cont ->
            if (Server.isMainThread) {
                Task.builder().delay(num, unit).execute { _ ->
                    cont.resume(Unit)
                }.submit(plugin)
            } else {
                Task.builder().async().delay(num, unit).execute { _ ->
                    cont.resume(Unit)
                }.submit(plugin)
            }
        }
    }
}

object TaskContinuation : Continuation<Unit> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resume(value: Unit) = Unit

    override fun resumeWithException(exception: Throwable) {
        throw exception
    }
}