package flavor.pie.kludge

import com.google.common.reflect.ImmutableTypeToInstanceMap
import com.google.common.reflect.Invokable
import com.google.common.reflect.TypeParameter
import com.google.common.reflect.TypeToInstanceMap
import com.google.common.reflect.TypeToken
import ninja.leaping.configurate.ConfigurationNode
import ninja.leaping.configurate.objectmapping.ObjectMappingException
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.value.BaseValue
import org.spongepowered.api.event.Event
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.EventManager
import org.spongepowered.api.event.Order
import java.util.function.Supplier

/**
 * @see [TypeToInstanceMap.getInstance]
 */
inline fun <reified T> TypeToInstanceMap<in T>.getInstance(): T? = getInstance(typeTokenOf())

/**
 * @see [TypeToInstanceMap.putInstance]
 */
inline fun <reified T> TypeToInstanceMap<in T>.putInstance(value: T): T? = putInstance(typeTokenOf(), value)

/**
 * @see [ImmutableTypeToInstanceMap.putInstance]
 */
@Deprecated("unsupported operation", level = DeprecationLevel.ERROR)
@Suppress("DEPRECATION")
inline fun <reified T> ImmutableTypeToInstanceMap<in T>.putInstance(value: T): T? = putInstance(typeTokenOf(), value)

/**
 * @see [ImmutableTypeToInstanceMap.Builder.put]
 */
inline fun <reified T : B, B> ImmutableTypeToInstanceMap.Builder<B>.put(value: T): ImmutableTypeToInstanceMap.Builder<B> =
    put(typeTokenOf(), value)

/**
 * @see Invokable.returning
 */
inline fun <reified R, T> Invokable<T, in R>.returning(): Invokable<T, R> = returning(typeTokenOf())

/**
 * @see TypeToken.where
 */
inline fun <reified X, T> TypeToken<T>.where(typeParam: TypeParameter<X>): TypeToken<T> =
    where(typeParam, typeTokenOf())

/**
 * @see TypeToken.isSupertypeOf
 */
inline fun <reified T> TypeToken<*>.isSupertypeOf(): Boolean = isSupertypeOf(typeTokenOf<T>())

/**
 * @see TypeToken.isSubtypeOf
 */
inline fun <reified T> TypeToken<*>.isSubtypeOf(): Boolean = isSubtypeOf(typeTokenOf<T>())

/**
 * @see ConfigurationNode.getList
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getList(): List<T> = getList(typeTokenOf())

/**
 * @see ConfigurationNode.getList
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getList(def: List<T>): List<T> = getList(typeTokenOf(), def)

/**
 * @see ConfigurationNode.getList
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getList(defSupplier: Supplier<List<T>>): List<T> =
    getList(typeTokenOf(), defSupplier)

/**
 * @see ConfigurationNode.getValue
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getValueT(): T? = getValue(typeTokenOf())

/**
 * @see ConfigurationNode.getValue
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getValueT(def: T): T = getValue(typeTokenOf(), def)

/**
 * @see ConfigurationNode.getValue
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.getValueT(defSupplier: Supplier<T>): T =
    getValue(typeTokenOf<T>(), defSupplier)

/**
 * @see ConfigurationNode.setValue
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> ConfigurationNode.setValueT(value: T?): ConfigurationNode = setValue(typeTokenOf(), value)

/**
 * @see TypeSerializer.deserialize
 */
@Throws(ObjectMappingException::class)
inline fun <reified S, T> TypeSerializer<T>.deserialize(value: ConfigurationNode): T? =
    deserialize(typeTokenOf<S>(), value)

/**
 * @see TypeSerializer.serialize
 */
@Throws(ObjectMappingException::class)
inline fun <reified S, T> TypeSerializer<T>.serialize(obj: T?, value: ConfigurationNode) =
    serialize(typeTokenOf<S>(), obj, value)

/**
 * @see TypeSerializerCollection.get
 */
inline fun <reified T> TypeSerializerCollection.get(): TypeSerializer<T> = get(typeTokenOf())

/**
 * @see TypeSerializerCollection.registerType
 */
inline fun <reified T> TypeSerializerCollection.registerType(serializer: TypeSerializer<in T>): TypeSerializerCollection =
    registerType(typeTokenOf<T>(), serializer)

/**
 * @see Key.Builder.type
 */
inline fun <T, reified B : BaseValue<T>> Key.Builder<*, *>.type(): Key.Builder<T, B> = type(typeTokenOf<B>())

/**
 * @see EventManager.registerListener
 */
inline fun <reified T : Event> EventManager.registerListener(plugin: Any, listener: EventListener<in T>) =
    registerListener(plugin, typeTokenOf<T>(), listener)

/**
 * @see [EventManager.registerListener]
 */
inline fun <reified T : Event> EventManager.registerListener(plugin: Any, order: Order, listener: EventListener<in T>) =
    registerListener(plugin, typeTokenOf<T>(), order, listener)

/**
 * @see [EventManager.registerListener]
 */
inline fun <reified T : Event> EventManager.registerListener(
    plugin: Any,
    order: Order,
    beforeModifications: Boolean,
    listener: EventListener<in T>
) = registerListener(plugin, typeTokenOf<T>(), order, beforeModifications, listener)
