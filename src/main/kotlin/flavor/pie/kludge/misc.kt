package flavor.pie.kludge

import com.google.common.reflect.TypeToken

inline fun <reified T> typeTokenOf(): TypeToken<T> = object: TypeToken<T>() {}
