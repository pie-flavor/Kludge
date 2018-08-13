package flavor.pie.kludge

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import org.spongepowered.api.service.ServiceManager

/**
 * A delegate which pulls values from the [ServiceManager]. Use the companion
 * object for live calls, or the class for a lazy value.
 * @see org.spongepowered.api.service.ServiceManager.provide
 */
class Service<out T : Any>(private val clazz: KClass<T>) {
    companion object {
        inline operator fun <reified T: Any> getValue(thisRef: Any?, property: KProperty<*>): T? {
            return !ServiceManager.provide(T::class.java)
        }

        /**
         * @see Service
         */
        inline operator fun <reified T: Any> invoke(): Service<T> = Service(T::class)
    }

    private var t: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (t == null) {
            t = !ServiceManager.provide(clazz.java)
        }
        return t
    }
}

/**
 * A delegate which pulls unchecked values from the [ServiceManager]. Use the
 * companion object for live calls, or the class for a lazy value.
 * @see ServiceManager.provideUnchecked
 */
class UncheckedService<out T : Any>(private val clazz: KClass<T>) {
    companion object {
        inline operator fun <reified T: Any> getValue(thisRef: Any?, property: KProperty<*>): T {
            return ServiceManager.provideUnchecked(T::class.java)
        }

        /**
         * @see UncheckedService
         */
        inline operator fun <reified T: Any> invoke(): UncheckedService<T> = UncheckedService(T::class)
    }

    private var t: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (t == null) {
            t = ServiceManager.provideUnchecked(clazz.java)
        }
        return t!!
    }
}

//object CachedService {
//    inline operator fun <reified T: Any> provideDelegate(thisRef: Any?, property: KProperty<*>): Service<T>
//            = Service(T::class)
//}
//
//object CachedUncheckedService {
//    inline operator fun <reified T: Any> provideDelegate(thisRef: Any?, property: KProperty<*>): UncheckedService<T>
//            = UncheckedService(T::class)
//}
