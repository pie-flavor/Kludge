package flavor.pie.kludge

import org.spongepowered.api.scheduler.Task

fun sync(plugin: Any, fn: () -> Unit): Task {
    return Task.builder().execute(fn).submit(plugin)
}

fun async(plugin: Any, fn: () -> Unit): Task {
    return Task.builder().execute(fn).submit(plugin)
}
