package flavor.pie.kludge

import org.spongepowered.api.Sponge
import org.spongepowered.api.scheduler.Task

/**
 * Synchronizes [fn] with the main server thread and then runs it.
 */
fun sync(plugin: Any, fn: () -> Unit) {
    if (Sponge.isServerAvailable() && Server.isMainThread) {
        fn()
    } else {
        Task.builder().execute(fn).submit(plugin)
    }
}

/**
 * Synchronizes [fn] with the main server thread and then runs it. Requires
 * [plugin] to have been set.
 */
fun sync(fn: () -> Unit) {
    if (Sponge.isServerAvailable() && Server.isMainThread) {
        fn()
    } else {
        Task.builder().execute(fn).submit(plugin)
    }
}

/**
 * Desynchronizes [fn] with the current thread and then runs it.
 */
fun async(plugin: Any, fn: () -> Unit) {
    Task.builder().async().execute(fn).submit(plugin)
}

/**
 * Desynchronizes [fn] with the current thread and then runs it. Requires
 * [plugin] to have been set.
 */
fun async(fn: () -> Unit) {
    Task.builder().async().execute(fn).submit(plugin)
}

/**
 * Runs [fn] after [ticks] ticks.
 */
fun delay(plugin: Any, ticks: Long, fn: () -> Unit) {
    Task.builder().delayTicks(ticks).execute(fn).submit(plugin)
}

/**
 * Runs [fn] after [ticks] ticks. Requires [plugin] to have been set.
 */
fun delay(ticks: Long, fn: () -> Unit) {
    Task.builder().delayTicks(ticks).execute(fn).submit(plugin)
}
