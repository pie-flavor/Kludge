package flavor.pie.kludge

/**
 * If you've relocated Kludge,
 * - good job on following the documentation
 * - you can assign your main plugin class to this variable. Afterwards,
 *   certain pluginless overloads like [sync] and [dataRegistrationOf] will use
 *   this variable. If you use those overloads without assigning to this
 *   variable, it'll throw an exception.
 */
lateinit var plugin: Any
