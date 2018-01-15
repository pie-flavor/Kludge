package flavor.pie.kludge

import java.util.Optional

operator fun <T> Optional<T>?.not(): T? = this.unwrap()

fun <T: Any> T?.optional(): Optional<T> = Optional.ofNullable(this)

fun <T> Optional<T>?.unwrap(): T? = this?.orElse(null)