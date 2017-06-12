package flavor.pie.kludge

import kotlin.reflect.KProperty

object Service {
    inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T? {
        return !ServiceManager.provide(T::class.java)
    }
}

object UncheckedService {
    inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T {
        return ServiceManager.provideUnchecked(T::class.java)
    }
}
