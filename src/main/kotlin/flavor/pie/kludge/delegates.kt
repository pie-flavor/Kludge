package flavor.pie.kludge

import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class Service<out T : Any>(private val clazz: KClass<T>) {
    companion object {
        inline operator fun <reified T: Any> getValue(thisRef: Any?, property: KProperty<*>): T? {
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
        inline operator fun <reified T: Any> getValue(thisRef: Any?, property: KProperty<*>): T {
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

object CachedService {
    inline operator fun <reified T: Any> provideDelegate(thisRef: Any?, property: KProperty<*>): Service<T>
            = Service(T::class)
}

object CachedUncheckedService {
    inline operator fun <reified T: Any> provideDelegate(thisRef: Any?, property: KProperty<*>): UncheckedService<T>
            = UncheckedService(T::class)
}
