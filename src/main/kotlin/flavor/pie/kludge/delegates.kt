package flavor.pie.kludge

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class Service<out T : Any>(private val clazz: KClass<T>) {
    companion object {
        inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T? {
            return !ServiceManager.provide(T::class.java)
        }
    }

    private var t: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (t == null) {
            t = !ServiceManager.provide(clazz.java)
        }
        return t
    }
}

class UncheckedService<out T : Any>(private val clazz: KClass<T>) {
    companion object {
        inline operator fun <reified T> getValue(thisRef: Any?, property: KProperty<*>): T {
            return ServiceManager.provideUnchecked(T::class.java)
        }
    }

    private var t: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (t == null) {
            t = ServiceManager.provideUnchecked(clazz.java)
        }
        println(property)
        return t!!
    }
}
