package flavor.pie.kludge

import com.google.common.reflect.TypeToken

/**
 * Creates a TypeToken of type [T]. Generic-safe.
 */
inline fun <reified T> typeTokenOf(): TypeToken<T> = object: TypeToken<T>() {}
