package flavor.pie.kludge

import java.util.Optional

operator fun <T> Optional<T>?.not(): T? = this?.orElse(null)

val <T: Any?> T.optional: Optional<T> get() = Optional.ofNullable(this)