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
