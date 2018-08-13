package flavor.pie.kludge

import org.spongepowered.api.Sponge
import org.spongepowered.api.scheduler.Task

fun sync(plugin: Any, fn: () -> Unit) {
    if (Sponge.isServerAvailable() && Server.isMainThread) {
        fn()
    } else {
        Task.builder().execute(fn).submit(plugin)
    }
}

fun sync(fn: () -> Unit) {
    if (Sponge.isServerAvailable() && Server.isMainThread) {
        fn()
    } else {
        Task.builder().execute(fn).submit(plugin)
    }
}

fun async(plugin: Any, fn: () -> Unit) {
    Task.builder().async().execute(fn).submit(plugin)
}

fun async(fn: () -> Unit) {
    Task.builder().async().execute(fn).submit(plugin)
}
