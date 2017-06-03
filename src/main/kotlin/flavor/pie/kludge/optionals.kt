package flavor.pie.kludge

import java.util.Optional

operator fun <T> Optional<T>?.not(): T? = this.unwrap()

val <T: Any> T?.optional: Optional<T> get() = Optional.ofNullable(this)

fun <T> Optional<T>?.unwrap(): T? = this?.orElse(null)