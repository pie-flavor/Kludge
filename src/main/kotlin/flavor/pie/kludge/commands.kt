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

fun ((CommandSource, CommandContext) -> CommandResult).command(): CommandExecutor = CommandExecutor(this)
fun CommandSpec.Builder.executor(executor: (CommandSource, CommandContext) -> CommandResult): CommandSpec.Builder =
        this.executor(executor.command())
fun CommandSpec.Builder.arguments(arguments: WrapperGenericArguments.() -> Unit): CommandSpec.Builder =
        arguments(WrapperGenericArguments().apply(arguments).toCommandElement())
fun commandArgumentsOf(arguments: WrapperGenericArguments.() -> Unit): CommandElement =
        WrapperGenericArguments().apply(arguments).toCommandElement()

typealias Argument = WrapperGenericArguments.Companion.() -> CommandElement
typealias ArgumentSeq = WrapperGenericArguments.() -> Unit

fun CommandFlags.Builder.build(): CommandElement = buildWith(GenericArguments.none())

fun CommandSource.execute(command: String): CommandResult = CommandManager.process(this, command)

fun CommandElement.asOptional(): CommandElement = GenericArguments.optional(this)
fun CommandElement.asOptional(value: Any): CommandElement = GenericArguments.optional(this, value)
fun CommandElement.asOptionalWeak(): CommandElement = GenericArguments.optionalWeak(this)
fun CommandElement.asOptionalWeak(value: Any): CommandElement = GenericArguments.optionalWeak(this, value)
fun CommandElement.allOf(): CommandElement = GenericArguments.allOf(this)
fun CommandElement.onlyOne(): CommandElement = GenericArguments.onlyOne(this)
fun CommandElement.requiringPermission(permission: String): CommandElement =
        GenericArguments.requiringPermission(this, permission)
fun CommandElement.repeated(times: Int): CommandElement = GenericArguments.repeated(this, times)

@Suppress("UNUSED_EXPRESSION")
class WrapperGenericArguments {
    companion object {
        fun allOf(element: CommandElement): CommandElement = GenericArguments.allOf(element)
        fun bigDecimal(key: Text): CommandElement = GenericArguments.bigDecimal(key)
        fun bigInteger(key: Text): CommandElement = GenericArguments.bigInteger(key)
        fun bool(key: Text): CommandElement = GenericArguments.bigInteger(key)
        fun catalogedElement(key: Text, catalogType: Class<out CatalogType>): CommandElement =
                GenericArguments.catalogedElement(key, catalogType)
        inline fun <reified T: CatalogType> catalogedElement(key: Text): CommandElement =
                catalogedElement(key, T::class.java)
        fun choices(key: Text, choices: Map<String, *>): CommandElement = GenericArguments.choices(key, choices)
        fun choices(key: Text, choices: Map<String, *>, choicesInUsage: Boolean): CommandElement =
                GenericArguments.choices(key, choices, choicesInUsage)
        fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>): CommandElement =
                GenericArguments.choices(key, choices, values)
        fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>,
                    choicesInUsage: Boolean): CommandElement =
                GenericArguments.choices(key, choices, values, choicesInUsage)
        fun dataContainer(key: Text): CommandElement = GenericArguments.dataContainer(key)
        fun dateTime(key: Text): CommandElement = GenericArguments.dateTime(key)
        fun dateTimeOrNow(key: Text): CommandElement = GenericArguments.dateTimeOrNow(key)
        fun dimension(key: Text): CommandElement = GenericArguments.dimension(key)
        fun doubleNum(key: Text): CommandElement = GenericArguments.doubleNum(key)
        fun duration(key: Text): CommandElement = GenericArguments.duration(key)
        fun entity(key: Text): CommandElement = GenericArguments.entity(key)
        fun entity(key: Text, clazz: Class<out Entity>): CommandElement = GenericArguments.entity(key, clazz)
        inline fun <reified T: Entity> entityExtending(key: Text): CommandElement = entity(key, T::class.java)
        fun entity(key: Text, type: EntityType): CommandElement = GenericArguments.entity(key, type)
        fun entityOrSource(key: Text): CommandElement = GenericArguments.entityOrSource(key)
        fun entityOrTarget(key: Text): CommandElement = GenericArguments.entityOrTarget(key)
        fun entityOrTarget(key: Text, clazz: Class<out Entity>): CommandElement =
                GenericArguments.entityOrTarget(key, clazz)
        inline fun <reified T: Entity> entityOrTargetExtending(key: Text): CommandElement =
                entityOrTarget(key, T::class.java)
        fun entityOrTarget(key: Text, type: EntityType): CommandElement = GenericArguments.entityOrTarget(key, type)
        fun <T: Enum<T>> enumValue(key: Text, type: Class<T>): CommandElement = GenericArguments.enumValue(key, type)
        inline fun <reified T: Enum<T>> enumValue(key: Text): CommandElement = enumValue(key, T::class.java)
        fun firstParsing(vararg elements: CommandElement): CommandElement = GenericArguments.firstParsing(*elements)
        inline fun firstParsing(elements: ArgumentSeq): CommandElement =
                GenericArguments.firstParsing(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
        fun integer(key: Text): CommandElement = GenericArguments.integer(key)
        fun ip(key: Text): CommandElement = GenericArguments.ip(key)
        fun ipOrSource(key: Text): CommandElement = GenericArguments.ipOrSource(key)
        fun literal(key: Text, putValue: Any, vararg expectedArgs: String): CommandElement =
                GenericArguments.literal(key, putValue, *expectedArgs)
        fun literal(key: Text, vararg expectedArgs: String): CommandElement =
                GenericArguments.literal(key, *expectedArgs)
        fun location(key: Text): CommandElement = GenericArguments.location(key)
        fun longNum(key: Text): CommandElement = GenericArguments.longNum(key)
        fun none(): CommandElement = GenericArguments.none()
        fun onlyOne(element: CommandElement): CommandElement = element.onlyOne()
        fun optional(element: CommandElement): CommandElement = element.asOptional()
        fun optional(element: CommandElement, value: Any): CommandElement = element.asOptional(value)
        fun optionalWeak(element: CommandElement): CommandElement = element.asOptionalWeak()
        fun optionalWeak(element: CommandElement, value: Any): CommandElement = element.asOptionalWeak(value)
        fun player(key: Text): CommandElement = GenericArguments.player(key)
        fun playerOrSource(key: Text): CommandElement = GenericArguments.playerOrSource(key)
        fun plugin(key: Text): CommandElement = GenericArguments.plugin(key)
        fun remainingJoinedStrings(key: Text): CommandElement = GenericArguments.remainingJoinedStrings(key)
        fun remainingRawJoinedStrings(key: Text): CommandElement = GenericArguments.remainingRawJoinedStrings(key)
        fun repeated(element: CommandElement, times: Int): CommandElement = element.repeated(times)
        fun requiringPermission(element: CommandElement, permission: String): CommandElement =
                element.requiringPermission(permission)
        fun seq(vararg elements: CommandElement): CommandElement = GenericArguments.seq(*elements)
        inline fun seq(elements: ArgumentSeq): CommandElement =
                GenericArguments.seq(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
        fun string(key: Text): CommandElement = GenericArguments.string(key)
        fun text(key: Text, serializer: TextSerializer = TextSerializers.FORMATTING_CODE,
                 allRemaining: Boolean = false): CommandElement = GenericArguments.text(key, serializer, allRemaining)
        fun url(key: Text): CommandElement = GenericArguments.url(key)
        fun user(key: Text): CommandElement = GenericArguments.user(key)
        fun userOrSource(key: Text): CommandElement = GenericArguments.userOrSource(key)
        fun uuid(key: Text): CommandElement = GenericArguments.uuid(key)
        fun vector3d(key: Text): CommandElement = GenericArguments.vector3d(key)
        fun withConstrainedSuggestions(element: CommandElement, predicate: Predicate<String>): CommandElement =
                GenericArguments.withConstrainedSuggestions(element, predicate)
        fun withSuggestions(element: CommandElement,
                            suggestions: Function<CommandSource, Iterable<String>>): CommandElement =
                GenericArguments.withSuggestions(element, suggestions)
        fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>,
                            requireBegin: Boolean): CommandElement =
                GenericArguments.withSuggestions(element, suggestions, requireBegin)
        fun withSuggestions(element: CommandElement, suggestions: Iterable<String>): CommandElement =
                GenericArguments.withSuggestions(element, suggestions)
        fun withSuggestions(element: CommandElement, suggestions: Iterable<String>,
                            requireBegin: Boolean): CommandElement =
                GenericArguments.withSuggestions(element, suggestions, requireBegin)
        fun world(key: Text): CommandElement = GenericArguments.world(key)
    }

    val elements: MutableList<CommandElement> = mutableListOf()
    private var flags: (CommandFlags.Builder.() -> Unit)? = null

    fun toCommandElement(): CommandElement {
        return if (flags == null) {
            GenericArguments.seq(*elements.toTypedArray())
        } else {
            GenericArguments.flags().apply(flags!!).buildWith(GenericArguments.seq(*elements.toTypedArray()))
        }
    }

    operator fun plus(element: CommandElement) {
        this.elements += element
    }

    inline fun allOf(element: Argument) {
        this.elements += element()
    }
    fun allOf(element: CommandElement) {
        this.elements += element
    }
    fun bigDecimal(key: Text) {
        this.elements += GenericArguments.bigDecimal(key)
    }
    fun bigInteger(key: Text) {
        this.elements += GenericArguments.bigInteger(key)
    }
    fun bool(key: Text) {
        this.elements += GenericArguments.bigInteger(key)
    }
    fun catalogedElement(key: Text, catalogType: Class<out CatalogType>) {
        this.elements += GenericArguments.catalogedElement(key, catalogType)
    }
    inline fun <reified T: CatalogType> catalogedElement(key: Text) {
        catalogedElement(key, T::class.java)
    }
    fun choices(key: Text, choices: Map<String, *>) {
        this.elements += GenericArguments.choices(key, choices)
    }
    fun choices(key: Text, choices: Map<String, *>, choicesInUsage: Boolean) {
        this.elements += GenericArguments.choices(key, choices, choicesInUsage)
    }
    fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>) {
        this.elements += GenericArguments.choices(key, choices, values)
    }
    fun choices(key: Text, choices: Supplier<Collection<String>>, values: Function<String, *>,
                choicesInUsage: Boolean) {
        this.elements += GenericArguments.choices(key, choices, values, choicesInUsage)
    }
    fun dataContainer(key: Text) {
        this.elements += GenericArguments.dataContainer(key)
    }
    fun dateTime(key: Text) {
        this.elements += GenericArguments.dateTime(key)
    }
    fun dateTimeOrNow(key: Text) {
        this.elements += GenericArguments.dateTimeOrNow(key)
    }
    fun dimension(key: Text) {
        this.elements += GenericArguments.dimension(key)
    }
    fun doubleNum(key: Text) {
        this.elements += GenericArguments.doubleNum(key)
    }
    fun duration(key: Text) {
        this.elements += GenericArguments.duration(key)
    }
    fun entity(key: Text) {
        this.elements += GenericArguments.entity(key)
    }
    fun entity(key: Text, clazz: Class<out Entity>) {
        this.elements += GenericArguments.entity(key, clazz)
    }
    inline fun <reified T: Entity> entityExtending(key: Text) {
        entity(key, T::class.java)
    }
    fun entity(key: Text, type: EntityType) {
        this.elements += GenericArguments.entity(key, type)
    }
    fun entityOrSource(key: Text) {
        this.elements += GenericArguments.entityOrSource(key)
    }
    fun entityOrTarget(key: Text) {
        this.elements += GenericArguments.entityOrTarget(key)
    }
    fun entityOrTarget(key: Text, clazz: Class<out Entity>) {
        this.elements += GenericArguments.entityOrTarget(key, clazz)
    }
    inline fun <reified T: Entity> entityOrTargetExtending(key: Text) {
        entityOrTarget(key, T::class.java)
    }
    fun entityOrTarget(key: Text, type: EntityType) {
        this.elements += GenericArguments.entityOrTarget(key, type)
    }
    fun <T: Enum<T>> enumValue(key: Text, type: Class<T>) {
        this.elements += GenericArguments.enumValue(key, type)
    }
    inline fun <reified T: Enum<T>> enumValue(key: Text) {
        enumValue(key, T::class.java)
    }
    fun firstParsing(vararg elements: CommandElement) {
        this.elements += GenericArguments.firstParsing(*elements)
    }
    inline fun firstParsing(elements: ArgumentSeq) {
        this.elements += GenericArguments.firstParsing(
                *WrapperGenericArguments().apply(elements).elements.toTypedArray())
    }
    fun flags(fn: CommandFlags.Builder.() -> Unit) {
        flags = fn
    }
    fun integer(key: Text) {
        this.elements += GenericArguments.integer(key)
    }
    fun ip(key: Text) {
        this.elements += GenericArguments.ip(key)
    }
    fun ipOrSource(key: Text) {
        this.elements += GenericArguments.ipOrSource(key)
    }
    fun literal(key: Text, putValue: Any, vararg expectedArgs: String) {
        this.elements += GenericArguments.literal(key, putValue, *expectedArgs)
    }
    fun literal(key: Text, vararg expectedArgs: String) {
        this.elements += GenericArguments.literal(key, *expectedArgs)
    }
    fun location(key: Text) {
        this.elements += GenericArguments.location(key)
    }
    fun longNum(key: Text) {
        this.elements += GenericArguments.longNum(key)
    }
    fun none() {
        this.elements += GenericArguments.none()
    }
    fun onlyOne(element: CommandElement) {
        this.elements += element.onlyOne()
    }
    inline fun onlyOne(element: Argument) {
        this.elements += element().onlyOne()
    }
    fun optional(element: CommandElement) {
        this.elements += element.asOptional()
    }
    inline fun optional(element: Argument) {
        this.elements += element().asOptional()
    }
    fun optional(element: CommandElement, value: Any) {
        this.elements += element.asOptional(value)
    }
    inline fun optional(element: Argument, value: Any) {
        this.elements += element().asOptional(value)
    }
    fun optionalWeak(element: CommandElement) {
        this.elements += element.asOptionalWeak()
    }
    inline fun optionalWeak(element: Argument) {
        this.elements += element().asOptionalWeak()
    }
    fun optionalWeak(element: CommandElement, value: Any) {
        this.elements += element.asOptionalWeak(value)
    }
    inline fun optionalWeak(element: Argument, value: Any) {
        this.elements += element().asOptionalWeak(value)
    }
    fun player(key: Text) {
        this.elements += GenericArguments.player(key)
    }
    fun playerOrSource(key: Text) {
        this.elements += GenericArguments.playerOrSource(key)
    }
    fun plugin(key: Text) {
        this.elements += GenericArguments.plugin(key)
    }
    fun remainingJoinedStrings(key: Text) {
        this.elements += GenericArguments.remainingJoinedStrings(key)
    }
    fun remainingRawJoinedStrings(key: Text) {
        this.elements += GenericArguments.remainingRawJoinedStrings(key)
    }
    fun repeated(element: CommandElement, times: Int) {
        this.elements += element.repeated(times)
    }
    inline fun repeated(element: Argument, times: Int) {
        this.elements += element().repeated(times)
    }
    fun requiringPermission(element: CommandElement, permission: String) {
        this.elements += element.requiringPermission(permission)
    }
    inline fun requiringPermission(element: Argument, permission: String) {
        this.elements += element().requiringPermission(permission)
    }
    fun seq(vararg elements: CommandElement) {
        this.elements += GenericArguments.seq(*elements)
    }
    inline fun seq(elements: ArgumentSeq) {
        this.elements += GenericArguments.seq(*WrapperGenericArguments().apply(elements).elements.toTypedArray())
    }
    fun string(key: Text) {
        this.elements += GenericArguments.string(key)
    }
    fun text(key: Text, serializer: TextSerializer = TextSerializers.FORMATTING_CODE, allRemaining: Boolean = false) {
        this.elements += GenericArguments.text(key, serializer, allRemaining)
    }
    fun url(key: Text) {
        this.elements += GenericArguments.url(key)
    }
    fun user(key: Text) {
        this.elements += GenericArguments.user(key)
    }
    fun userOrSource(key: Text) {
        this.elements += GenericArguments.userOrSource(key)
    }
    fun uuid(key: Text) {
        this.elements += GenericArguments.uuid(key)
    }
    fun vector3d(key: Text) {
        this.elements += GenericArguments.vector3d(key)
    }
    fun withConstrainedSuggestions(element: CommandElement, predicate: Predicate<String>) {
        this.elements += GenericArguments.withConstrainedSuggestions(element, predicate)
    }
    inline fun withConstrainedSuggestions(element: Argument, predicate: Predicate<String>) {
        this.elements += GenericArguments.withConstrainedSuggestions(element(), predicate)
    }
    fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>) {
        this.elements += GenericArguments.withSuggestions(element, suggestions)
    }
    inline fun withSuggestions(element: Argument,
                        suggestions: Function<CommandSource, Iterable<String>>) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions)
    }
    fun withSuggestions(element: CommandElement, suggestions: Function<CommandSource, Iterable<String>>,
                        requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element, suggestions, requireBegin)
    }
    inline fun withSuggestions(element: Argument,
                               suggestions: Function<CommandSource, Iterable<String>>, requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions, requireBegin)
    }
    fun withSuggestions(element: CommandElement, suggestions: Iterable<String>) {
        this.elements += GenericArguments.withSuggestions(element, suggestions)
    }
    inline fun withSuggestions(element: Argument, suggestions: Iterable<String>) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions)
    }
    fun withSuggestions(element: CommandElement, suggestions: Iterable<String>, requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element, suggestions, requireBegin)
    }
    inline fun withSuggestions(element: Argument, suggestions: Iterable<String>,
                               requireBegin: Boolean) {
        this.elements += GenericArguments.withSuggestions(element(), suggestions, requireBegin)
    }
    fun world(key: Text) {
        this.elements += GenericArguments.world(key)
    }
}
