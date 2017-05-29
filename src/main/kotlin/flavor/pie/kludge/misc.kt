package flavor.pie.kludge

import java.util.Optional

operator fun <T> Optional<T>.not(): T? = this.orElse(null)
