package flavor.pie.kludge

import com.flowpowered.math.vector.Vector3i
import com.google.common.collect.ArrayTable
import com.google.common.collect.ClassToInstanceMap
import com.google.common.collect.FluentIterable
import com.google.common.collect.ImmutableClassToInstanceMap
import com.google.common.collect.MultimapBuilder
import com.google.common.reflect.TypeParameter
import com.google.common.reflect.TypeToInstanceMap
import com.google.common.reflect.TypeToken
import com.google.common.util.concurrent.TimeLimiter
import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.TypeAdapter
import ninja.leaping.configurate.ConfigurationOptions
import ninja.leaping.configurate.objectmapping.ObjectMapperFactory
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.spongepowered.api.CatalogType
import org.spongepowered.api.GameRegistry
import org.spongepowered.api.advancement.criteria.trigger.FilteredTriggerConfiguration
import org.spongepowered.api.advancement.criteria.trigger.Trigger
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataManager
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.DataRegistration
import org.spongepowered.api.data.DataSerializable
import org.spongepowered.api.data.DataView
import org.spongepowered.api.data.ImmutableDataBuilder
import org.spongepowered.api.data.ImmutableDataHolder
import org.spongepowered.api.data.Property
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.manipulator.DataManipulator
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator
import org.spongepowered.api.data.persistence.DataBuilder
import org.spongepowered.api.data.persistence.DataContentUpdater
import org.spongepowered.api.data.persistence.DataTranslator
import org.spongepowered.api.data.property.DirectionRelativePropertyHolder
import org.spongepowered.api.data.property.LocationBasePropertyHolder
import org.spongepowered.api.data.property.PropertyHolder
import org.spongepowered.api.data.property.PropertyRegistry
import org.spongepowered.api.data.property.PropertyStore
import org.spongepowered.api.data.value.ValueContainer
import org.spongepowered.api.data.value.immutable.ImmutableValueStore
import org.spongepowered.api.entity.ai.task.AITaskType
import org.spongepowered.api.entity.ai.task.AbstractAITask
import org.spongepowered.api.entity.living.Agent
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.data.ChangeDataHolderEvent
import org.spongepowered.api.registry.CatalogRegistryModule
import org.spongepowered.api.util.Direction
import org.spongepowered.api.util.ResettableBuilder
import org.spongepowered.plugin.meta.McModInfo
import java.io.Reader
import java.util.concurrent.TimeUnit
import com.google.gson.reflect.TypeToken as GsonTypeToken

inline fun <reified T: CatalogType> GameRegistry.getType(id: String): T? = getType(T::class.java, id).unwrap()
inline fun <reified T: CatalogType> GameRegistry.getAllOf(): Collection<T> = getAllOf(T::class.java)
inline fun <reified T: CatalogType> GameRegistry.getAllFor(pluginId: String): Collection<T> = getAllFor(pluginId, T::class.java)
inline fun <reified T: CatalogType> GameRegistry.getAllForMinecraft(): Collection<T> = getAllForMinecraft(T::class.java)
inline fun <reified T: CatalogType> GameRegistry.getAllForSponge(): Collection<T> = getAllForSponge(T::class.java)
inline fun <reified T: CatalogType> GameRegistry.registerTypedModule(module: CatalogRegistryModule<T>): GameRegistry = registerModule(T::class.java, module)
inline fun <reified T> GameRegistry.registerBuilderSupplier(noinline supplier: () -> T): GameRegistry = registerBuilderSupplier(T::class.java) { supplier() }
inline fun <reified T: ResettableBuilder<*, in T>> GameRegistry.createBuilder(): T = createBuilder(T::class.java)
@Deprecated(message = "Scheduled to be removed in API 8, use GameRegistryEvent.Register")
inline fun <reified T: CatalogType> GameRegistry.register(t: T): T = register(T::class.java, t)
inline fun <reified T: AbstractAITask<out Agent>> GameRegistry.registerAITaskType(plugin: Any, id: String, name: String): AITaskType = registerAITaskType(plugin, id, name, T::class.java)
inline fun <reified T> Trigger.Builder<*>.dataSerializableConfig(): Trigger.Builder<T> where T: FilteredTriggerConfiguration, T: DataSerializable = dataSerializableConfig(T::class.java)
inline fun <reified T: FilteredTriggerConfiguration> Trigger.Builder<*>.typeSerializableConfig(): Trigger.Builder<T> = typeSerializableConfig(T::class.java)
inline fun <reified T: FilteredTriggerConfiguration> Trigger.Builder<*>.typeSerializableConfig(collection: TypeSerializerCollection): Trigger.Builder<T> = typeSerializableConfig(T::class.java, collection)
inline fun <reified T: FilteredTriggerConfiguration> Trigger.Builder<*>.jsonSerializableConfig(): Trigger.Builder<T> = jsonSerializableConfig(T::class.java)
inline fun <reified T: FilteredTriggerConfiguration> Trigger.Builder<*>.jsonSerializableConfig(gson: Gson): Trigger.Builder<T> = jsonSerializableConfig(T::class.java, gson)
inline fun <reified T: DataSerializable> DataManager.registerBuilder(builder: DataBuilder<T>) = registerBuilder(T::class.java, builder)
inline fun <reified T: DataSerializable> DataManager.registerContentUpdater(updater: DataContentUpdater) = registerContentUpdater(T::class.java, updater)
inline fun <reified T: DataSerializable> DataManager.getWrappedContentUpdater(fromVersion: Int, toVersion: Int): DataContentUpdater? = getWrappedContentUpdater(T::class.java, fromVersion, toVersion).unwrap()
inline fun <reified T: DataSerializable> DataManager.getBuilder(): DataBuilder<T>? = getBuilder(T::class.java).unwrap()
inline fun <reified T: DataSerializable> DataManager.deserialize(view: DataView): T? = deserialize(T::class.java, view).unwrap()
inline fun <reified T: ImmutableDataHolder<T>, B: ImmutableDataBuilder<T, B>> DataManager.register(builder: B) = register(T::class.java, builder)
inline fun <reified T: ImmutableDataHolder<T>, B: ImmutableDataBuilder<T, B>> DataManager.getImmutableBuilder(): B? = getImmutableBuilder<T, B>(T::class.java).unwrap()
inline fun <reified T: DataManipulator<T, I>, I: ImmutableDataManipulator<I, T>> DataManager.getManipulatorBuilder(): DataManipulatorBuilder<T, I>? = getManipulatorBuilder(T::class.java).unwrap()
inline fun <reified T: ImmutableDataManipulator<T, M>, M: DataManipulator<M, T>> DataManager.getImmutableManipulatorBuilder(): DataManipulatorBuilder<M, T>? = getImmutableManipulatorBuilder(T::class.java).unwrap()
inline fun <reified T> DataManager.registerTranslator(translator: DataTranslator<T>) = registerTranslator(T::class.java, translator)
inline fun <reified T> DataManager.getTranslator(): DataTranslator<T>? = getTranslator(T::class.java).unwrap()
inline fun <reified T: M, M: DataManipulator<M, I>, I: ImmutableDataManipulator<I, M>> DataRegistration.Builder<M, I>.dataImplementation(): DataRegistration.Builder<M, I> = dataImplementation(T::class.java)
inline fun <reified T: I, M: DataManipulator<M, I>, I: ImmutableDataManipulator<I, M>> DataRegistration.Builder<M, I>.immutableImplementation(): DataRegistration.Builder<M, I> = immutableImplementation(T::class.java)
inline fun <reified T: DataSerializable> DataView.getSerializable(query: DataQuery): T? = getSerializable(query, T::class.java).unwrap()
inline fun <reified T: DataSerializable> DataView.getSerializableList(query: DataQuery): List<T>? = getSerializableList(query, T::class.java).unwrap()
inline fun <reified T> DataView.getObject(query: DataQuery): T? = getObject(query, T::class.java).unwrap()
inline fun <reified T> DataView.getObjectList(query: DataQuery): List<T>? = getObjectList(query, T::class.java).unwrap()
inline fun <reified T: CatalogType> DataView.getCatalogType(query: DataQuery): T? = getCatalogType(query, T::class.java).unwrap()
inline fun <reified T: CatalogType> DataView.getCatalogTypeList(query: DataQuery): List<T>? = getCatalogTypeList(query, T::class.java).unwrap()
inline fun <reified T: DataHolder> Key<*>.registerEvent(listener: EventListener<ChangeDataHolderEvent.ValueChange>) = registerEvent(T::class.java, listener)
inline fun <reified T: Property<*, *>> DirectionRelativePropertyHolder.getProperty(direction: Direction): T? = getProperty(direction, T::class.java).unwrap()
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getProperty(coords: Vector3i): T? = getProperty(coords, T::class.java).unwrap()
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getProperty(x: Int, y: Int, z: Int): T? = getProperty(x, y, z, T::class.java).unwrap()
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getProperty(coords: Vector3i, direction: Direction): T? = getProperty(coords, direction, T::class.java).unwrap()
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getProperty(x: Int, y: Int, z: Int, direction: Direction): T? = getProperty(x, y, z, direction, T::class.java).unwrap()
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getFacesWithProperty(coords: Vector3i): Collection<Direction> = getFacesWithProperty(coords, T::class.java)
inline fun <reified T: Property<*, *>> LocationBasePropertyHolder.getFacesWithProperty(x: Int, y: Int, z: Int): Collection<Direction> = getFacesWithProperty(x, y, z, T::class.java)
inline fun <reified T: Property<*, *>> PropertyHolder.getProperty(): T? = getProperty(T::class.java).unwrap()
inline fun <reified T: Property<*, *>> PropertyRegistry.register(store: PropertyStore<T>) = register(T::class.java, store)
inline fun <reified T: Property<*, *>> PropertyRegistry.getStore(): PropertyStore<T>? = getStore(T::class.java).unwrap()
inline fun <reified T: H, I: ImmutableValueStore<I, H>, H: ValueContainer<*>> I.get(): T? = get(T::class.java).unwrap()
inline fun <reified T: H, I: ImmutableValueStore<I, H>, H: ValueContainer<*>> I.getOrCreate(): T? = getOrCreate(T::class.java).unwrap()
inline fun <I: ImmutableValueStore<I, H>, reified H: ValueContainer<*>> I.supports() = supports(H::class.java)
inline fun <I: ImmutableValueStore<I, H>, reified H: ValueContainer<*>> I.without(): I? = without(H::class.java).unwrap()
//todo data.mutable and what comes after

inline fun <reified T> ConfigurationOptions.acceptsType() = acceptsType(T::class.java)
inline fun <reified T> ObjectMapperFactory.getMapper() = getMapper(T::class.java)

inline fun <reified T> McModInfo.Builder.registerExtension(key: String): McModInfo.Builder = registerExtension(key, T::class.java)
inline fun <reified T> McModInfo.Builder.registerExtension(key: String, adapter: Any): McModInfo.Builder = registerExtension(key, T::class.java, adapter)

inline fun <reified T> ExclusionStrategy.shouldSkipClass() = shouldSkipClass(T::class.java)
inline fun <reified T: Annotation> FieldAttributes.getAnnotation(): T = getAnnotation(T::class.java)
inline fun <reified T> Gson.getAdapter(): TypeAdapter<T> = getAdapter(T::class.java)
inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, T::class.java)
inline fun <reified T> Gson.fromJson(json: Reader): T = fromJson(json, T::class.java)
inline fun <reified T> Gson.fromJson(json: JsonElement): T = fromJson(json, T::class.java)
@Deprecated(message = "this implementation may be inconsistent with javac for types with wildcards.")
inline fun <reified T> GsonTypeToken<*>.isAssignableFrom() = isAssignableFrom(T::class.java)
inline fun <reified T> ArrayTable<*, *, T>.toArray(): Array<Array<T>> = toArray(T::class.java)
inline fun <M, reified T: M> ClassToInstanceMap<M>.getInstance(): T? = getInstance(T::class.java)
inline fun <M, reified T: M> ClassToInstanceMap<M>.putInstance(t: T): T? = putInstance(T::class.java, t)
inline fun <reified T> FluentIterable<*>.filter(): FluentIterable<T> = filter(T::class.java)
inline fun <reified T> FluentIterable<T>.toArray(): Array<T> = toArray(T::class.java)
inline fun <M, reified T: M> ImmutableClassToInstanceMap.Builder<M>.put(t: T): ImmutableClassToInstanceMap.Builder<M> = put(T::class.java, t)
inline fun <K, reified V: Enum<V>> MultimapBuilder.MultimapBuilderWithKeys<K>.enumSetValues(): MultimapBuilder.SetMultimapBuilder<K, V> = enumSetValues(V::class.java)
inline fun <M, reified T: M> TypeToInstanceMap<M>.getInstance(): T? = getInstance(T::class.java)
inline fun <M, reified T: M> TypeToInstanceMap<M>.putInstance(t: T): T? = putInstance(T::class.java, t)
inline fun <T, reified X> TypeToken<T>.where(param: TypeParameter<X>): TypeToken<T> = where(param, X::class.java)
inline fun <reified X, T: X> TypeToken<T>.getSupertype(): TypeToken<in T> = getSupertype(X::class.java)
inline fun <reified X, T: X> TypeToken<T>.getSubtype(): TypeToken<out T> = getSubtype(X::class.java)
inline fun <reified T> TimeLimiter.newProxy(target: T, timeoutDuration: Long, timeoutUnit: TimeUnit): T = newProxy(target, T::class.java, timeoutDuration, timeoutUnit)
inline fun <reified T> ReflectionToStringBuilder.setUpToClass() { upToClass = T::class.java }
