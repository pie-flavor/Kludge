package flavor.pie.kludge

import java.util.Optional

/**
 * @see unwrap
 */
operator fun <T> Optional<T>?.not(): T? = this.unwrap()

/**
 * Converts a nullable into an optional via [Optional.ofNullable].
 */
fun <T: Any> T?.optional(): Optional<T> = Optional.ofNullable(this)

/**
 * Converts an optional into a nullable via [`orElse(null)`][Optional.orElse].
 */
fun <T> Optional<T>?.unwrap(): T? = this?.orElse(null)
