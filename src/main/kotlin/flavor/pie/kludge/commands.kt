package flavor.pie.kludge

import org.spongepowered.api.CatalogType
import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.args.CommandElement
import org.spongepowered.api.command.args.CommandFlags
import org.spongepowered.api.command.args.GenericArguments
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.EntityType
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.serializer.TextSerializer
import org.spongepowered.api.text.serializer.TextSerializers
import java.util.function.Supplier
import java.util.function.Function
import java.util.function.Predicate

/**
 * Converts a function type into a [CommandExecutor].
 */
fun ((CommandSource, CommandContext) -> CommandResult).command(): CommandExecutor = CommandExecutor(this)

/**
 * @see CommandSpec.Builder.executor
 */
fun CommandSpec.Builder.executor(executor: (CommandSource, CommandContext) -> CommandResult): CommandSpec.Builder =
        this.executor(executor.command())

/**
 * @see CommandSpec.Builder.arguments
 */
fun CommandSpec.Builder.arguments(arguments: ArgumentSeq): CommandSpec.Builder =
        arguments(WrapperGenericArguments().apply(arguments).toCommandElement())

/**
 * Converts an [ArgumentSeq] into a [CommandElement].
 */
fun commandArgumentsOf(arguments: ArgumentSeq): CommandElement =
        WrapperGenericArguments().apply(arguments).toCommandElement()

typealias Argument = WrapperGenericArguments.Companion.() -> CommandElement
typealias ArgumentSeq = WrapperGenericArguments.() -> Unit

/**
 * Builds a [CommandFlags] without appending any arguments.
 */
fun CommandFlags.Builder.build(): CommandElement = buildWith(GenericArguments.none())

/**
 * @see org.spongepowered.api.command.CommandManager.process
 */
fun CommandSource.execute(command: String): CommandResult = CommandManager.process(this, command)

/**
 * @see GenericArguments.optional
 */
fun CommandElement.asOptional(): CommandElement = GenericArguments.optional(this)

/**
 * @see GenericArguments.optional
 */
fun CommandElement.asOptional(value: Any): CommandElement = GenericArguments.optional(this, value)

/**
 * @see GenericArguments.optionalWeak
 */
fun CommandElement.asOptionalWeak(): CommandElement = GenericArguments.optionalWeak(this)

/**
 * @see GenericArguments.optionalWeak
 */
fun CommandElement.asOptionalWeak(value: Any): CommandElement = GenericArguments.optionalWeak(this, value)

/**
 * @see GenericArguments.allOf
 */
fun CommandElement.allOf(): CommandElement = GenericArguments.allOf(this)

/**
 * @see GenericArguments.onlyOne
 */
fun CommandElement.onlyOne(): CommandElement = GenericArguments.onlyOne(this)

/**
 * @see GenericArguments.requiringPermission
 */
fun CommandElement.requiringPermission(permission: String): CommandElement =
        GenericArguments.requiringPermission(this, permission)

/**
 * @see GenericArguments.repeated
 */
fun CommandElement.repeated(times: Int): CommandElement = GenericArguments.repeated(this, times)

@Suppress("UNUSED_EXPRESSION")
/**
 * Utility class for de-namespacing [GenericArguments] while constructing a
 * [GenericArguments.seq]. All methods representing an argument are the
 * equivalent of calling [WrapperGenericArguments.plus] on the result of the
 * matching method in [GenericArguments].
 */
class WrapperGenericArguments {
    /**
     * Utility object for de-namespacing [GenericArguments].
     */
    companion object {
        /**
         * @see GenericArguments.allOf
         */
        fun allOf(element: CommandElement): CommandElement = GenericArguments.allOf(element)
        /**
         * @see GenericArguments.bigDecimal
         */
        fun bigDecimal(key: Text): CommandElement = GenericArguments.bigDecimal(key)
        /**
         * @see GenericArguments.bigInteger
         */
        fun bigInteger(key: Text): CommandElement = GenericArguments.bigInteger(key)
        /**
         * @see GenericArguments.bool
         */
        fun bool(key: Text): CommandElement = GenericArguments.bigInteger(key)
        /**
         * @see GenericArguments.catalogedElement
         */
        fun catalogedElement(key: Text, catalogType: Class<out CatalogType>): CommandElement =
                GenericArguments.catalogedElement(key, catalogType)
        /**
         * @see GenericArguments.catalogedElement
         */
        inline fun <reified T: CatalogType> catalogedElement(key: Text): CommandElement =
                catalogedElement(key, T::class.java)
        /**
         * @see GenericArguments.choices
         */
        fun choices(key: Text, choices: Map<String, *>): CommandElement = GenericArguments.choices(key, choices)
        /**
         * @see GenericArguments.choices
         */
        fun choices(key: Text, choices: Map<String, *>, choicesInUsage: Boolean): CommandElement =
                GenericArguments.choices(key, choices, choicesInUsage)
        /**
         * @see GenericArguments.choices
         */
        fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>): CommandElement =
                GenericArguments.choices(key, choices, values)
        /**
         * @see GenericArguments.choices
         */
        fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>,
                    choicesInUsage: Boolean): CommandElement =
                GenericArguments.choices(key, choices, values, choicesInUsage)
        /**
         * @see GenericArguments.dataContainer
         */
        fun dataContainer(key: Text): CommandElement = GenericArguments.dataContainer(key)
        /**
         * @see GenericArguments.dateTime
         */
        fun dateTime(key: Text): CommandElement = GenericArguments.dateTime(key)
        /**
         * @see GenericArguments.dateTimeOrNow
         */
        fun dateTimeOrNow(key: Text): CommandElement = GenericArguments.dateTimeOrNow(key)
        /**
         * @see GenericArguments.dimension
         */
        fun dimension(key: Text): CommandElement = GenericArguments.dimension(key)
        /**
         * @see GenericArguments.doubleNum
         */
        fun doubleNum(key: Text): CommandElement = GenericArguments.doubleNum(key)
        /**
         * @see GenericArguments.duration
         */
        fun duration(key: Text): CommandElement = GenericArguments.duration(key)
        /**
         * @see GenericArguments.entity
         */
        fun entity(key: Text): CommandElement = GenericArguments.entity(key)
        /**
         * @see GenericArguments.entity
         */
        fun entity(key: Text, clazz: Class<out Entity>): CommandElement = GenericArguments.entity(key, clazz)
        /**
         * @see GenericArguments.entity
         */
        inline fun <reified T: Entity> entityExtending(key: Text): CommandElement = entity(key, T::class.java)
        /**
         * @see GenericArguments.entity
         */
        fun entity(key: Text, type: EntityType): CommandElement = GenericArguments.entity(key, type)
        /**
         * @see GenericArguments.entityOrSource
         */
        fun entityOrSource(key: Text): CommandElement = GenericArguments.entityOrSource(key)
        /**
         * @see GenericArguments.entityOrTarget
         */
        fun entityOrTarget(key: Text): CommandElement = GenericArguments.entityOrTarget(key)
        /**
         * @see GenericArguments.entityOrTarget
         */
        fun entityOrTarget(key: Text, clazz: Class<out Entity>): CommandElement =
                GenericArguments.entityOrTarget(key, clazz)
        /**
         * @see GenericArguments.entityOrTarget
         */
        inline fun <reified T: Entity> entityOrTargetExtending(key: Text): CommandElement =
                entityOrTarget(key, T::class.java)
        /**
         * @see GenericArguments.entityOrTarget
         */
        fun entityOrTarget(key: Text, type: EntityType): CommandElement = GenericArguments.entityOrTarget(key, type)
        /**
         * @see GenericArguments.enumValue
         */
        fun <T: Enum<T>> enumValue(key: Text, type: Class<T>): CommandElement = GenericArguments.enumValue(key, type)
        /**
         * @see GenericArguments.enumValue
         */
        inline fun <reified T: Enum<T>> enumValue(key: Text): CommandElement = enumValue(key, T::class.java)
        /**
         * @see GenericArguments.firstParsing
         */
        fun firstParsing(vararg elements: CommandElement): CommandElement = GenericArguments.firstParsing(*elements)
        /**
         * @see GenericArguments.firstParsing
         */
        inline fun firstParsing(elements: ArgumentSeq): CommandElement =
                GenericArguments.firstParsing(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
        /**
         * @see GenericArguments.integer
         */
        fun integer(key: Text): CommandElement = GenericArguments.integer(key)
        /**
         * @see GenericArguments.ip
         */
        fun ip(key: Text): CommandElement = GenericArguments.ip(key)
        /**
         * @see GenericArguments.ipOrSource
         */
        fun ipOrSource(key: Text): CommandElement = GenericArguments.ipOrSource(key)
        /**
         * @see GenericArguments.literal
         */
        fun literal(key: Text, putValue: Any, vararg expectedArgs: String): CommandElement =
                GenericArguments.literal(key, putValue, *expectedArgs)
        /**
         * @see GenericArguments.literal
         */
        fun literal(key: Text, vararg expectedArgs: String): CommandElement =
                GenericArguments.literal(key, *expectedArgs)
        /**
         * @see GenericArguments.location
         */
        fun location(key: Text): CommandElement = GenericArguments.location(key)
        /**
         * @see GenericArguments.longNum
         */
        fun longNum(key: Text): CommandElement = GenericArguments.longNum(key)
        /**
         * @see GenericArguments.none
         */
        fun none(): CommandElement = GenericArguments.none()
        /**
         * @see GenericArguments.onlyOne
         */
        fun onlyOne(element: CommandElement): CommandElement = element.onlyOne()
        /**
         * @see GenericArguments.optional
         */
        fun optional(element: CommandElement): CommandElement = element.asOptional()
        /**
         * @see GenericArguments.optional
         */
        fun optional(element: CommandElement, value: Any): CommandElement = element.asOptional(value)
        /**
         * @see GenericArguments.optionalWeak
         */
        fun optionalWeak(element: CommandElement): CommandElement = element.asOptionalWeak()
        /**
         * @see GenericArguments.optionalWeak
         */
        fun optionalWeak(element: CommandElement, value: Any): CommandElement = element.asOptionalWeak(value)
        /**
         * @see GenericArguments.player
         */
        fun player(key: Text): CommandElement = GenericArguments.player(key)
        /**
         * @see GenericArguments.playerOrSource
         */
        fun playerOrSource(key: Text): CommandElement = GenericArguments.playerOrSource(key)
        /**
         * @see GenericArguments.plugin
         */
        fun plugin(key: Text): CommandElement = GenericArguments.plugin(key)
        /**
         * @see GenericArguments.remainingJoinedStrings
         */
        fun remainingJoinedStrings(key: Text): CommandElement = GenericArguments.remainingJoinedStrings(key)
        /**
         * @see GenericArguments.remainingRawJoinedStrings
         */
        fun remainingRawJoinedStrings(key: Text): CommandElement = GenericArguments.remainingRawJoinedStrings(key)
        /**
         * @see GenericArguments.repeated
         */
        fun repeated(element: CommandElement, times: Int): CommandElement = element.repeated(times)
        /**
         * @see GenericArguments.requiringPermission
         */
        fun requiringPermission(element: CommandElement, permission: String): CommandElement =
                element.requiringPermission(permission)
        /**
         * @see GenericArguments.seq
         */
        fun seq(vararg elements: CommandElement): CommandElement = GenericArguments.seq(*elements)
        /**
         * @see GenericArguments.seq
         */
        inline fun seq(elements: ArgumentSeq): CommandElement =
                GenericArguments.seq(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
        /**
         * @see GenericArguments.string
         */
        fun string(key: Text): CommandElement = GenericArguments.string(key)
        /**
         * @see GenericArguments.text
         */
        fun text(key: Text, serializer: TextSerializer = TextSerializers.FORMATTING_CODE,
                 allRemaining: Boolean = false): CommandElement = GenericArguments.text(key, serializer, allRemaining)
        /**
         * @see GenericArguments.url
         */
        fun url(key: Text): CommandElement = GenericArguments.url(key)
        /**
         * @see GenericArguments.user
         */
        fun user(key: Text): CommandElement = GenericArguments.user(key)
        /**
         * @see GenericArguments.userOrSource
         */
        fun userOrSource(key: Text): CommandElement = GenericArguments.userOrSource(key)
        /**
         * @see GenericArguments.uuid
         */
        fun uuid(key: Text): CommandElement = GenericArguments.uuid(key)
        /**
         * @see GenericArguments.vector3d
         */
        fun vector3d(key: Text): CommandElement = GenericArguments.vector3d(key)
        /**
         * @see GenericArguments.withConstrainedSuggestions
         */
        fun withConstrainedSuggestions(element: CommandElement, predicate: Predicate<String>): CommandElement =
                GenericArguments.withConstrainedSuggestions(element, predicate)
        /**
         * @see GenericArguments.withSuggestions
         */
        fun withSuggestions(element: CommandElement,
                            suggestions: Function<CommandSource, Iterable<String>>): CommandElement =
                GenericArguments.withSuggestions(element, suggestions)
        /**
         * @see GenericArguments.withSuggestions
         */
        fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>,
                            requireBegin: Boolean): CommandElement =
                GenericArguments.withSuggestions(element, suggestions, requireBegin)
        /**
         * @see GenericArguments.withSuggestions
         */
        fun withSuggestions(element: CommandElement, suggestions: Iterable<String>): CommandElement =
                GenericArguments.withSuggestions(element, suggestions)
        /**
         * @see GenericArguments.withSuggestions
         */
        fun withSuggestions(element: CommandElement, suggestions: Iterable<String>,
                            requireBegin: Boolean): CommandElement =
                GenericArguments.withSuggestions(element, suggestions, requireBegin)
        /**
         * @see GenericArguments.world
         */
        fun world(key: Text): CommandElement = GenericArguments.world(key)
    }

    /**
     * The list of elements added to this wrapper.
     */
    val elements: MutableList<CommandElement> = mutableListOf()
    private var flags: (CommandFlags.Builder.() -> Unit)? = null

    /**
     * Constructs a [CommandElement] out of this wrapper, including flags
     * if necessary.
     */
    fun toCommandElement(): CommandElement {
        return if (flags == null) {
            GenericArguments.seq(*elements.toTypedArray())
        } else {
            GenericArguments.flags().apply(flags!!).buildWith(GenericArguments.seq(*elements.toTypedArray()))
        }
    }

    /**
     * Adds a [CommandElement] to this wrapper. For any arguments located
     * in [GenericArguments], the other methods in this class are recommended.
     */
    operator fun plus(element: CommandElement) {
        this.elements += element
    }

    /**
     * @see GenericArguments.allOf
     */
    inline fun allOf(element: Argument) {
        this.elements += element()
    }
    /**
     * @see GenericArguments.allOf
     */
    fun allOf(element: CommandElement) {
        this.elements += element
    }
    /**
     * @see GenericArguments.bigDecimal
     */
    fun bigDecimal(key: Text) {
        this.elements += GenericArguments.bigDecimal(key)
    }
    /**
     * @see GenericArguments.bigInteger
     */
    fun bigInteger(key: Text) {
        this.elements += GenericArguments.bigInteger(key)
    }
    /**
     * @see GenericArguments.bool
     */
    fun bool(key: Text) {
        this.elements += GenericArguments.bigInteger(key)
    }
    /**
     * @see GenericArguments.catalogedElement
     */
    fun catalogedElement(key: Text, catalogType: Class<out CatalogType>) {
        this.elements += GenericArguments.catalogedElement(key, catalogType)
    }
    /**
     * @see GenericArguments.catalogedElement
     */
    inline fun <reified T: CatalogType> catalogedElement(key: Text) {
        catalogedElement(key, T::class.java)
    }
    /**
     * @see GenericArguments.choices
     */
    fun choices(key: Text, choices: Map<String, *>) {
        this.elements += GenericArguments.choices(key, choices)
    }
    /**
     * @see GenericArguments.choices
     */
    fun choices(key: Text, choices: Map<String, *>, choicesInUsage: Boolean) {
        this.elements += GenericArguments.choices(key, choices, choicesInUsage)
    }
    /**
     * @see GenericArguments.choices
     */
    fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>) {
        this.elements += GenericArguments.choices(key, choices, values)
    }
    /**
     * @see GenericArguments.choices
     */
    fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>,
                choicesInUsage: Boolean) {
        this.elements += GenericArguments.choices(key, choices, values, choicesInUsage)
    }
    /**
     * @see GenericArguments.dataContainer
     */
    fun dataContainer(key: Text) {
        this.elements += GenericArguments.dataContainer(key)
    }
    /**
     * @see GenericArguments.dateTime
     */
    fun dateTime(key: Text) {
        this.elements += GenericArguments.dateTime(key)
    }
    /**
     * @see GenericArguments.dateTimeOrNow
     */
    fun dateTimeOrNow(key: Text) {
        this.elements += GenericArguments.dateTimeOrNow(key)
    }
    /**
     * @see GenericArguments.dimension
     */
    fun dimension(key: Text) {
        this.elements += GenericArguments.dimension(key)
    }
    /**
     * @see GenericArguments.doubleNum
     */
    fun doubleNum(key: Text) {
        this.elements += GenericArguments.doubleNum(key)
    }
    /**
     * @see GenericArguments.duration
     */
    fun duration(key: Text) {
        this.elements += GenericArguments.duration(key)
    }
    /**
     * @see GenericArguments.entity
     */
    fun entity(key: Text) {
        this.elements += GenericArguments.entity(key)
    }
    /**
     * @see GenericArguments.entity
     */
    fun entity(key: Text, clazz: Class<out Entity>) {
        this.elements += GenericArguments.entity(key, clazz)
    }
    /**
     * @see GenericArguments.entity
     */
    inline fun <reified T: Entity> entityExtending(key: Text) {
        entity(key, T::class.java)
    }
    /**
     * @see GenericArguments.entity
     */
    fun entity(key: Text, type: EntityType) {
        this.elements += GenericArguments.entity(key, type)
    }
    /**
     * @see GenericArguments.entityOrSource
     */
    fun entityOrSource(key: Text) {
        this.elements += GenericArguments.entityOrSource(key)
    }
    /**
     * @see GenericArguments.entityOrTarget
     */
    fun entityOrTarget(key: Text) {
        this.elements += GenericArguments.entityOrTarget(key)
    }
    /**
     * @see GenericArguments.entityOrTarget
     */
    fun entityOrTarget(key: Text, clazz: Class<out Entity>) {
        this.elements += GenericArguments.entityOrTarget(key, clazz)
    }
    /**
     * @see GenericArguments.entityOrTarget
     */
    inline fun <reified T: Entity> entityOrTargetExtending(key: Text) {
        entityOrTarget(key, T::class.java)
    }
    /**
     * @see GenericArguments.entityOrTarget
     */
    fun entityOrTarget(key: Text, type: EntityType) {
        this.elements += GenericArguments.entityOrTarget(key, type)
    }
    /**
     * @see GenericArguments.enumValue
     */
    fun <T: Enum<T>> enumValue(key: Text, type: Class<T>) {
        this.elements += GenericArguments.enumValue(key, type)
    }
    /**
     * @see GenericArguments.enumValue
     */
    inline fun <reified T: Enum<T>> enumValue(key: Text) {
        enumValue(key, T::class.java)
    }
    /**
     * @see GenericArguments.firstParsing
     */
    fun firstParsing(vararg elements: CommandElement) {
        this.elements += GenericArguments.firstParsing(*elements)
    }
    /**
     * @see GenericArguments.firstParsing
     */
    inline fun firstParsing(elements: ArgumentSeq) {
        this.elements += GenericArguments.firstParsing(
                *WrapperGenericArguments().apply(elements).elements.toTypedArray())
    }
    /**
     * @see GenericArguments.flags
     */
    fun flags(fn: CommandFlags.Builder.() -> Unit) {
        flags = fn
    }
    /**
     * @see GenericArguments.integer
     */
    fun integer(key: Text) {
        this.elements += GenericArguments.integer(key)
    }
    /**
     * @see GenericArguments.ip
     */
    fun ip(key: Text) {
        this.elements += GenericArguments.ip(key)
    }
    /**
     * @see GenericArguments.ipOrSource
     */
    fun ipOrSource(key: Text) {
        this.elements += GenericArguments.ipOrSource(key)
    }
    /**
     * @see GenericArguments.literal
     */
    fun literal(key: Text, putValue: Any, vararg expectedArgs: String) {
        this.elements += GenericArguments.literal(key, putValue, *expectedArgs)
    }
    /**
     * @see GenericArguments.literal
     */
    fun literal(key: Text, vararg expectedArgs: String) {
        this.elements += GenericArguments.literal(key, *expectedArgs)
    }
    /**
     * @see GenericArguments.location
     */
    fun location(key: Text) {
        this.elements += GenericArguments.location(key)
    }
    /**
     * @see GenericArguments.longNum
     */
    fun longNum(key: Text) {
        this.elements += GenericArguments.longNum(key)
    }
    /**
     * @see GenericArguments.none
     */
    fun none() {
        this.elements += GenericArguments.none()
    }
    /**
     * @see GenericArguments.onlyOne
     */
    fun onlyOne(element: CommandElement) {
        this.elements += element.onlyOne()
    }
    /**
     * @see GenericArguments.onlyOne
     */
    inline fun onlyOne(element: Argument) {
        this.elements += element().onlyOne()
    }
    /**
     * @see GenericArguments.optional
     */
    fun optional(element: CommandElement) {
        this.elements += element.asOptional()
    }
    /**
     * @see GenericArguments.optional
     */
    inline fun optional(element: Argument) {
        this.elements += element().asOptional()
    }
    /**
     * @see GenericArguments.optional
     */
    fun optional(element: CommandElement, value: Any) {
        this.elements += element.asOptional(value)
    }
    /**
     * @see GenericArguments.optional
     */
    inline fun optional(element: Argument, value: Any) {
        this.elements += element().asOptional(value)
    }
    /**
     * @see GenericArguments.optionalWeak
     */
    fun optionalWeak(element: CommandElement) {
        this.elements += element.asOptionalWeak()
    }
    /**
     * @see GenericArguments.optionalWeak
     */
    inline fun optionalWeak(element: Argument) {
        this.elements += element().asOptionalWeak()
    }
    /**
     * @see GenericArguments.optionalWeak
     */
    fun optionalWeak(element: CommandElement, value: Any) {
        this.elements += element.asOptionalWeak(value)
    }
    /**
     * @see GenericArguments.optionalWeak
     */
    inline fun optionalWeak(element: Argument, value: Any) {
        this.elements += element().asOptionalWeak(value)
    }
    /**
     * @see GenericArguments.player
     */
    fun player(key: Text) {
        this.elements += GenericArguments.player(key)
    }
    /**
     * @see GenericArguments.playerOrSource
     */
    fun playerOrSource(key: Text) {
        this.elements += GenericArguments.playerOrSource(key)
    }
    /**
     * @see GenericArguments.plugin
     */
    fun plugin(key: Text) {
        this.elements += GenericArguments.plugin(key)
    }
    /**
     * @see GenericArguments.remainingJoinedStrings
     */
    fun remainingJoinedStrings(key: Text) {
        this.elements += GenericArguments.remainingJoinedStrings(key)
    }
    /**
     * @see GenericArguments.remainingRawJoinedStrings
     */
    fun remainingRawJoinedStrings(key: Text) {
        this.elements += GenericArguments.remainingRawJoinedStrings(key)
    }
    /**
     * @see GenericArguments.repeated
     */
    fun repeated(element: CommandElement, times: Int) {
        this.elements += element.repeated(times)
    }
    /**
     * @see GenericArguments.repeated
     */
    inline fun repeated(element: Argument, times: Int) {
        this.elements += element().repeated(times)
    }
    /**
     * @see GenericArguments.requiringPermission
     */
    fun requiringPermission(element: CommandElement, permission: String) {
        this.elements += element.requiringPermission(permission)
    }
    /**
     * @see GenericArguments.requiringPermission
     */
    inline fun requiringPermission(element: Argument, permission: String) {
        this.elements += element().requiringPermission(permission)
    }
    /**
     * @see GenericArguments.seq
     */
    fun seq(vararg elements: CommandElement) {
        this.elements += GenericArguments.seq(*elements)
    }
    /**
     * @see GenericArguments.seq
     */
    inline fun seq(elements: ArgumentSeq) {
        this.elements += GenericArguments.seq(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
    }
    /**
     * @see GenericArguments.string
     */
    fun string(key: Text) {
        this.elements += GenericArguments.string(key)
    }
    /**
     * @see GenericArguments.text
     */
    fun text(key: Text, serializer: TextSerializer = TextSerializers.FORMATTING_CODE, allRemaining: Boolean = false) {
        this.elements += GenericArguments.text(key, serializer, allRemaining)
    }
    /**
     * @see GenericArguments.url
     */
    fun url(key: Text) {
        this.elements += GenericArguments.url(key)
    }
    /**
     * @see GenericArguments.user
     */
    fun user(key: Text) {
        this.elements += GenericArguments.user(key)
    }
    /**
     * @see GenericArguments.userOrSource
     */
    fun userOrSource(key: Text) {
        this.elements += GenericArguments.userOrSource(key)
    }
    /**
     * @see GenericArguments.uuid
     */
    fun uuid(key: Text) {
        this.elements += GenericArguments.uuid(key)
    }
    /**
     * @see GenericArguments.vector3d
     */
    fun vector3d(key: Text) {
        this.elements += GenericArguments.vector3d(key)
    }
    /**
     * @see GenericArguments.withConstrainedSuggestions
     */
    fun withConstrainedSuggestions(element: CommandElement, predicate: Predicate<String>) {
        this.elements += GenericArguments.withConstrainedSuggestions(element, predicate)
    }
    /**
     * @see GenericArguments.withConstrainedSuggestions
     */
    inline fun withConstrainedSuggestions(element: Argument, predicate: Predicate<String>) {
        this.elements += GenericArguments.withConstrainedSuggestions(element(), predicate)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>) {
        this.elements += GenericArguments.withSuggestions(element, suggestions)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    inline fun withSuggestions(element: Argument,
                        suggestions: Function<CommandSource, Iterable<String>>) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>,
                        requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element, suggestions, requireBegin)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    inline fun withSuggestions(element: Argument,
                               suggestions: Function<CommandSource, Iterable<String>>, requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions, requireBegin)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    fun withSuggestions(element: CommandElement, suggestions: Iterable<String>) {
        this.elements += GenericArguments.withSuggestions(element, suggestions)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    inline fun withSuggestions(element: Argument, suggestions: Iterable<String>) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    fun withSuggestions(element: CommandElement, suggestions: Iterable<String>, requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element, suggestions, requireBegin)
    }
    /**
     * @see GenericArguments.withSuggestions
     */
    inline fun withSuggestions(element: Argument, suggestions: Iterable<String>,
                               requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions, requireBegin)
    }
    /**
     * @see GenericArguments.world
     */
    fun world(key: Text) {
        this.elements += GenericArguments.world(key)
    }
}
