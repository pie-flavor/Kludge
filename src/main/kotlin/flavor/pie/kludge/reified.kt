package flavor.pie.kludge

import com.flowpowered.math.vector.Vector3d
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
import com.google.inject.Binder
import com.google.inject.Binding
import com.google.inject.Injector
import com.google.inject.MembersInjector
import com.google.inject.PrivateBinder
import com.google.inject.Provider
import com.google.inject.Scope
import com.google.inject.TypeLiteral
import com.google.inject.binder.AnnotatedBindingBuilder
import com.google.inject.binder.AnnotatedConstantBindingBuilder
import com.google.inject.binder.AnnotatedElementBuilder
import com.google.inject.binder.ConstantBindingBuilder
import com.google.inject.binder.LinkedBindingBuilder
import com.google.inject.binder.ScopedBindingBuilder
import com.google.inject.internal.AbstractBindingBuilder
import com.google.inject.spi.BindingScopingVisitor
import com.google.inject.spi.TypeEncounter
import ninja.leaping.configurate.ConfigurationOptions
import ninja.leaping.configurate.objectmapping.ObjectMapper
import ninja.leaping.configurate.objectmapping.ObjectMapperFactory
import ninja.leaping.configurate.objectmapping.ObjectMappingException
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection
import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.spongepowered.api.CatalogType
import org.spongepowered.api.GameRegistry
import org.spongepowered.api.Platform
import org.spongepowered.api.advancement.criteria.trigger.FilteredTriggerConfiguration
import org.spongepowered.api.advancement.criteria.trigger.Trigger
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataManager
import org.spongepowered.api.data.DataQuery
import org.spongepowered.api.data.DataRegistration
import org.spongepowered.api.data.DataSerializable
import org.spongepowered.api.data.DataTransactionResult
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
import org.spongepowered.api.data.value.mutable.CompositeValueStore
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.ai.task.AITaskType
import org.spongepowered.api.entity.ai.task.AbstractAITask
import org.spongepowered.api.entity.ai.task.builtin.WatchClosestAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.target.FindNearestAttackableTargetAITask
import org.spongepowered.api.entity.living.Agent
import org.spongepowered.api.entity.living.Living
import org.spongepowered.api.entity.projectile.Projectile
import org.spongepowered.api.entity.projectile.source.ProjectileSource
import org.spongepowered.api.event.Event
import org.spongepowered.api.event.EventListener
import org.spongepowered.api.event.EventManager
import org.spongepowered.api.event.Order
import org.spongepowered.api.event.cause.Cause
import org.spongepowered.api.event.cause.EventContextKey
import org.spongepowered.api.event.data.ChangeDataHolderEvent
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent
import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.Carrier
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryArchetype
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.InventoryProperty
import org.spongepowered.api.network.ChannelBinding
import org.spongepowered.api.network.Message
import org.spongepowered.api.network.MessageHandler
import org.spongepowered.api.registry.CatalogRegistryModule
import org.spongepowered.api.registry.ExtraClassCatalogRegistryModule
import org.spongepowered.api.service.ProviderRegistration
import org.spongepowered.api.service.ProvisioningException
import org.spongepowered.api.service.ServiceManager
import org.spongepowered.api.text.TextRepresentable
import org.spongepowered.api.text.selector.SelectorFactory
import org.spongepowered.api.text.selector.ArgumentType
import org.spongepowered.api.text.selector.ArgumentTypes
import org.spongepowered.api.text.transform.TextFormatter
import org.spongepowered.api.util.Direction
import org.spongepowered.api.util.ResettableBuilder
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider
import org.spongepowered.api.util.generator.dummy.DummyClassGenerator
import org.spongepowered.api.util.generator.dummy.DummyClassGeneratorProvider
import org.spongepowered.api.world.biome.BiomeGenerationSettings
import org.spongepowered.api.world.extent.LocationCompositeValueStore
import org.spongepowered.api.world.gen.GenerationPopulator
import org.spongepowered.api.world.gen.Populator
import org.spongepowered.api.world.gen.WorldGenerator
import org.spongepowered.plugin.meta.McModInfo
import java.io.Reader
import java.util.concurrent.TimeUnit
import java.util.function.Consumer
import javax.lang.model.AnnotatedConstruct
import com.google.gson.reflect.TypeToken as GsonTypeToken
import com.google.inject.Key as GKey
import javax.inject.Provider as XProvider

// sponge types

/**
 * @see [GameRegistry.getType]
 */
inline fun <reified T : CatalogType> GameRegistry.getType(id: String): T? = getType(T::class.java, id).unwrap()

/**
 * @see [GameRegistry.getAllOf]
 */
inline fun <reified T : CatalogType> GameRegistry.getAllOf(): Collection<T> = getAllOf(T::class.java)

/**
 * @see [GameRegistry.getAllFor]
 */
inline fun <reified T : CatalogType> GameRegistry.getAllFor(pluginId: String): Collection<T> =
    getAllFor(pluginId, T::class.java)

/**
 * @see [GameRegistry.getAllForMinecraft]
 */
inline fun <reified T : CatalogType> GameRegistry.getAllForMinecraft(): Collection<T> =
    getAllForMinecraft(T::class.java)

/**
 * @see [GameRegistry.getAllForSponge]
 */
inline fun <reified T : CatalogType> GameRegistry.getAllForSponge(): Collection<T> = getAllForSponge(T::class.java)

/**
 * @see GameRegistry.registerTypedModule
 */
inline fun <reified T : CatalogType> GameRegistry.registerTypedModule(module: CatalogRegistryModule<T>): GameRegistry =
    registerModule(T::class.java, module)

/**
 * @see [GameRegistry.registerBuilderSupplier]
 */
inline fun <reified T> GameRegistry.registerBuilderSupplier(noinline supplier: () -> T): GameRegistry =
    registerBuilderSupplier(T::class.java) { supplier() }

/**
 * @see [GameRegistry.createBuilder]
 */
inline fun <reified T : ResettableBuilder<*, in T>> GameRegistry.createBuilder(): T = createBuilder(T::class.java)

/**
 * @see [GameRegistry.register]
 */
@Deprecated(message = "Scheduled to be removed in API 8, use GameRegistryEvent.Register")
@Suppress("DEPRECATION")
inline fun <reified T : CatalogType> GameRegistry.register(t: T): T = register(T::class.java, t)

/**
 * @see [GameRegistry.registerAITaskType]
 */
inline fun <reified T : AbstractAITask<out Agent>> GameRegistry.registerAITaskType(
    plugin: Any,
    id: String,
    name: String
): AITaskType = registerAITaskType(plugin, id, name, T::class.java)

/**
 * @see [Trigger.Builder<*>.dataSerializableConfig]
 */
inline fun <reified T> Trigger.Builder<*>.dataSerializableConfig(): Trigger.Builder<T> where T : FilteredTriggerConfiguration, T : DataSerializable =
    dataSerializableConfig(T::class.java)

/**
 * @see [Trigger.Builder<*>.typeSerializableConfig]
 */
inline fun <reified T : FilteredTriggerConfiguration> Trigger.Builder<*>.typeSerializableConfig(): Trigger.Builder<T> =
    typeSerializableConfig(T::class.java)

/**
 * @see [Trigger.Builder<*>.typeSerializableConfig]
 */
inline fun <reified T : FilteredTriggerConfiguration> Trigger.Builder<*>.typeSerializableConfig(collection: TypeSerializerCollection): Trigger.Builder<T> =
    typeSerializableConfig(T::class.java, collection)

/**
 * @see [Trigger.Builder<*>.jsonSerializableConfig]
 */
inline fun <reified T : FilteredTriggerConfiguration> Trigger.Builder<*>.jsonSerializableConfig(): Trigger.Builder<T> =
    jsonSerializableConfig(T::class.java)

/**
 * @see [Trigger.Builder<*>.jsonSerializableConfig]
 */
inline fun <reified T : FilteredTriggerConfiguration> Trigger.Builder<*>.jsonSerializableConfig(gson: Gson): Trigger.Builder<T> =
    jsonSerializableConfig(T::class.java, gson)

/**
 * @see [DataManager.registerBuilder]
 */
inline fun <reified T : DataSerializable> DataManager.registerBuilder(builder: DataBuilder<T>) =
    registerBuilder(T::class.java, builder)

/**
 * @see [DataManager.registerContentUpdater]
 */
inline fun <reified T : DataSerializable> DataManager.registerContentUpdater(updater: DataContentUpdater) =
    registerContentUpdater(T::class.java, updater)

/**
 * @see [DataManager.getWrappedContentUpdater]
 */
inline fun <reified T : DataSerializable> DataManager.getWrappedContentUpdater(
    fromVersion: Int,
    toVersion: Int
): DataContentUpdater? = getWrappedContentUpdater(T::class.java, fromVersion, toVersion).unwrap()

/**
 * @see [DataManager.getBuilder]
 */
inline fun <reified T : DataSerializable> DataManager.getBuilder(): DataBuilder<T>? = getBuilder(T::class.java).unwrap()

/**
 * @see [DataManager.deserialize]
 */
inline fun <reified T : DataSerializable> DataManager.deserialize(view: DataView): T? =
    deserialize(T::class.java, view).unwrap()

/**
 * @see [DataManager.register]
 */
inline fun <reified T : ImmutableDataHolder<T>, B : ImmutableDataBuilder<T, B>> DataManager.register(builder: B) =
    register(T::class.java, builder)

/**
 * @see [DataManager.getImmutableBuilder]
 */
inline fun <reified T : ImmutableDataHolder<T>, B : ImmutableDataBuilder<T, B>> DataManager.getImmutableBuilder(): B? =
    getImmutableBuilder<T, B>(T::class.java).unwrap()

/**
 * @see [DataManager.getManipulatorBuilder]
 */
inline fun <reified T : DataManipulator<T, I>, I : ImmutableDataManipulator<I, T>> DataManager.getManipulatorBuilder(): DataManipulatorBuilder<T, I>? =
    getManipulatorBuilder(T::class.java).unwrap()

/**
 * @see [DataManager.getImmutableManipulatorBuilder]
 */
inline fun <reified T : ImmutableDataManipulator<T, M>, M : DataManipulator<M, T>> DataManager.getImmutableManipulatorBuilder(): DataManipulatorBuilder<M, T>? =
    getImmutableManipulatorBuilder(T::class.java).unwrap()

/**
 * @see [DataManager.registerTranslator]
 */
inline fun <reified T> DataManager.registerTranslator(translator: DataTranslator<T>) =
    registerTranslator(T::class.java, translator)

/**
 * @see [DataManager.getTranslator]
 */
inline fun <reified T> DataManager.getTranslator(): DataTranslator<T>? = getTranslator(T::class.java).unwrap()

/**
 * @see [DataRegistration.Builder<M, I>.dataImplementation]
 */
inline fun <reified T : M, M : DataManipulator<M, I>, I : ImmutableDataManipulator<I, M>> DataRegistration.Builder<M, I>.dataImplementation(): DataRegistration.Builder<M, I> =
    dataImplementation(T::class.java)

/**
 * @see [DataRegistration.Builder<M, I>.immutableImplementation]
 */
inline fun <reified T : I, M : DataManipulator<M, I>, I : ImmutableDataManipulator<I, M>> DataRegistration.Builder<M, I>.immutableImplementation(): DataRegistration.Builder<M, I> =
    immutableImplementation(T::class.java)

/**
 * @see [DataView.getSerializable]
 */
inline fun <reified T : DataSerializable> DataView.getSerializable(query: DataQuery): T? =
    getSerializable(query, T::class.java).unwrap()

/**
 * @see [DataView.getSerializableList]
 */
inline fun <reified T : DataSerializable> DataView.getSerializableList(query: DataQuery): List<T>? =
    getSerializableList(query, T::class.java).unwrap()

/**
 * @see [DataView.getObject]
 */
inline fun <reified T> DataView.getObject(query: DataQuery): T? = getObject(query, T::class.java).unwrap()

/**
 * @see [DataView.getObjectList]
 */
inline fun <reified T> DataView.getObjectList(query: DataQuery): List<T>? = getObjectList(query, T::class.java).unwrap()

/**
 * @see [DataView.getCatalogType]
 */
inline fun <reified T : CatalogType> DataView.getCatalogType(query: DataQuery): T? =
    getCatalogType(query, T::class.java).unwrap()

/**
 * @see [DataView.getCatalogTypeList]
 */
inline fun <reified T : CatalogType> DataView.getCatalogTypeList(query: DataQuery): List<T>? =
    getCatalogTypeList(query, T::class.java).unwrap()

/**
 * @see [Key.registerEvent]
 */
inline fun <reified T : DataHolder> Key<*>.registerEvent(listener: EventListener<ChangeDataHolderEvent.ValueChange>) =
    registerEvent(T::class.java, listener)

/**
 * @see [DirectionRelativePropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> DirectionRelativePropertyHolder.getProperty(direction: Direction): T? =
    getProperty(direction, T::class.java).unwrap()

/**
 * @see [LocationBasePropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getProperty(coords: Vector3i): T? =
    getProperty(coords, T::class.java).unwrap()

/**
 * @see [LocationBasePropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getProperty(x: Int, y: Int, z: Int): T? =
    getProperty(x, y, z, T::class.java).unwrap()

/**
 * @see [LocationBasePropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getProperty(
    coords: Vector3i,
    direction: Direction
): T? = getProperty(coords, direction, T::class.java).unwrap()

/**
 * @see [LocationBasePropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getProperty(
    x: Int,
    y: Int,
    z: Int,
    direction: Direction
): T? = getProperty(x, y, z, direction, T::class.java).unwrap()

/**
 * @see [LocationBasePropertyHolder.getFacesWithProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getFacesWithProperty(coords: Vector3i): Collection<Direction> =
    getFacesWithProperty(coords, T::class.java)

/**
 * @see [LocationBasePropertyHolder.getFacesWithProperty]
 */
inline fun <reified T : Property<*, *>> LocationBasePropertyHolder.getFacesWithProperty(
    x: Int,
    y: Int,
    z: Int
): Collection<Direction> = getFacesWithProperty(x, y, z, T::class.java)

/**
 * @see [PropertyHolder.getProperty]
 */
inline fun <reified T : Property<*, *>> PropertyHolder.getProperty(): T? = getProperty(T::class.java).unwrap()

/**
 * @see [PropertyRegistry.register]
 */
inline fun <reified T : Property<*, *>> PropertyRegistry.register(store: PropertyStore<T>) =
    register(T::class.java, store)

/**
 * @see [PropertyRegistry.getStore]
 */
inline fun <reified T : Property<*, *>> PropertyRegistry.getStore(): PropertyStore<T>? =
    getStore(T::class.java).unwrap()

/**
 * @see [ImmutableValueStore.get]
 */
inline fun <reified T : H, I : ImmutableValueStore<I, H>, H : ValueContainer<*>> I.get(): T? =
    get(T::class.java).unwrap()

/**
 * @see [ImmutableValueStore.getOrCreate]
 */
inline fun <reified T : H, I : ImmutableValueStore<I, H>, H : ValueContainer<*>> I.getOrCreate(): T? =
    getOrCreate(T::class.java).unwrap()

/**
 * @see [ImmutableValueStore.supports]
 */
inline fun <I : ImmutableValueStore<I, H>, reified H : ValueContainer<*>> I.supports() = supports(H::class.java)

/**
 * @see [ImmutableValueStore.without]
 */
inline fun <I : ImmutableValueStore<I, H>, reified H : ValueContainer<*>> I.without(): I? =
    without(H::class.java).unwrap()

/**
 * @see [CompositeValueStore.get]
 */
inline fun <S : CompositeValueStore<S, H>, H : ValueContainer<*>, reified T : H> S.get(): T? =
    get(T::class.java).unwrap()

/**
 * @see [CompositeValueStore.require]
 */
inline fun <S : CompositeValueStore<S, H>, H : ValueContainer<*>, reified T : H> S.require(): T = require(T::class.java)

/**
 * @see [CompositeValueStore.getOrCreate]
 */
inline fun <S : CompositeValueStore<S, H>, H : ValueContainer<*>, reified T : H> S.getOrCreate(): T? =
    getOrCreate(T::class.java).unwrap()

/**
 * @see [CompositeValueStore.supports]
 */
inline fun <S : CompositeValueStore<S, H>, H : ValueContainer<*>, reified T : H> S.supports(): Boolean =
    supports(T::class.java)

/**
 * @see [CompositeValueStore.remove]
 */
inline fun <S : CompositeValueStore<S, H>, H : ValueContainer<*>, reified T : H> S.remove(): DataTransactionResult =
    remove(T::class.java)

/**
 * @see [WatchClosestAITask.setWatchedClass]
 */
inline fun <reified T : Entity> WatchClosestAITask.setWatchedClass(): WatchClosestAITask =
    setWatchedClass(T::class.java)

/**
 * @see [WatchClosestAITask.Builder.watch]
 */
inline fun <reified T : Entity> WatchClosestAITask.Builder.watch(): WatchClosestAITask.Builder = watch(T::class.java)

/**
 * @see [FindNearestAttackableTargetAITask.setTargetClass]
 */
inline fun <reified T : Living> FindNearestAttackableTargetAITask.setTargetClass(): FindNearestAttackableTargetAITask =
    setTargetClass(T::class.java)

/**
 * @see [FindNearestAttackableTargetAITask.Builder.target]
 */
inline fun <reified T : Living> FindNearestAttackableTargetAITask.Builder.target(): FindNearestAttackableTargetAITask.Builder =
    target(T::class.java)

/**
 * @see [ProjectileSource.launchProjectile]
 */
inline fun <reified T : Projectile> ProjectileSource.launchProjectile(): T? = launchProjectile(T::class.java).unwrap()

/**
 * @see [ProjectileSource.launchProjectile]
 */
inline fun <reified T : Projectile> ProjectileSource.launchProjectile(velocity: Vector3d): T? =
    launchProjectile(T::class.java, velocity).unwrap()

/**
 * @see [Cause.first]
 */
inline fun <reified T> Cause.first(): T? = first(T::class.java).unwrap()

/**
 * @see [Cause.last]
 */
inline fun <reified T> Cause.last(): T? = last(T::class.java).unwrap()

/**
 * @see [Cause.before]
 */
inline fun <reified T> Cause.before(): Any? = before(T::class.java).unwrap()

/**
 * @see [Cause.after]
 */
inline fun <reified T> Cause.after(): Any? = after(T::class.java).unwrap()

/**
 * @see [Cause.containsType]
 */
inline fun <reified T> Cause.containsType(): Boolean = containsType(T::class.java)

/**
 * @see [Cause.noneOf]
 */
inline fun <reified T> Cause.noneOf(): List<Any> = noneOf(T::class.java)

/**
 * @see [EventContextKey.Builder<T>.type]
 */
inline fun <reified T> EventContextKey.Builder<T>.type(): EventContextKey.Builder<T> = type(T::class.java)

/**
 * @see [ItemType.getDefaultProperty]
 */
inline fun <reified T : Property<*, *>> ItemType.getDefaultProperty(): T? = getDefaultProperty(T::class.java).unwrap()

/**
 * @see [Inventory.getProperties]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getProperties(child: Inventory): Collection<T> =
    getProperties(child, T::class.java)

/**
 * @see [Inventory.getProperties]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getProperties(): Collection<T> = getProperties(T::class.java)

/**
 * @see [Inventory.getProperty]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getProperty(child: Inventory, key: Any): T? =
    getProperty(child, T::class.java, key).unwrap()

/**
 * @see [Inventory.getProperty]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getProperty(key: Any): T? =
    getProperty(T::class.java, key).unwrap()

/**
 * @see [Inventory.getInventoryProperty]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getInventoryProperty(child: Inventory): T? =
    getInventoryProperty(child, T::class.java).unwrap()

/**
 * @see [Inventory.getInventoryProprety]
 */
inline fun <reified T : InventoryProperty<*, *>> Inventory.getInventoryProprety(): T? =
    getInventoryProperty(T::class.java).unwrap()

/**
 * @see [Inventory.Builder.listener]
 */
inline fun <reified E : InteractInventoryEvent> Inventory.Builder.listener(listener: Consumer<E>): Inventory.Builder =
    listener(E::class.java, listener)

/**
 * @see [Inventory.Builder.forCarrier]
 */
inline fun <reified T : Carrier> Inventory.Builder.forCarrier(): Inventory.Builder = forCarrier(T::class.java)

/**
 * @see [InventoryArchetype.getProperty]
 */
inline fun <reified T : InventoryProperty<String, *>> InventoryArchetype.getProperty(): T? =
    getProperty(T::class.java).unwrap()

/**
 * @see [InventoryArchetype.getProperty]
 */
inline fun <reified T : InventoryProperty<String, *>> InventoryArchetype.getPropertyT(key: String): T? =
    getProperty(T::class.java, key).unwrap()

/**
 * @see [ItemStack.Builder.remove]
 */
inline fun <reified T : DataManipulator<*, *>> ItemStack.Builder.remove(): ItemStack.Builder = remove(T::class.java)

/**
 * @see [ChannelBinding.IndexedMessageChannel.registerMessage]
 */
inline fun <reified M : Message> ChannelBinding.IndexedMessageChannel.registerMessage(messageId: Int) =
    registerMessage(M::class.java, messageId)

/**
 * @see [ChannelBinding.IndexedMessageChannel.registerMessage]
 */
inline fun <reified M : Message> ChannelBinding.IndexedMessageChannel.registerMessage(
    messageId: Int,
    handler: MessageHandler<M>
) = registerMessage(M::class.java, messageId, handler)

/**
 * @see [ChannelBinding.IndexedMessageChannel.registerMessage]
 */
inline fun <reified M : Message> ChannelBinding.IndexedMessageChannel.registerMessage(
    messageId: Int,
    side: Platform.Type,
    handler: MessageHandler<M>
) = registerMessage(M::class.java, messageId, side, handler)

/**
 * @see [ChannelBinding.IndexedMessageChannel.addHandler]
 */
inline fun <reified M : Message> ChannelBinding.IndexedMessageChannel.addHandler(
    side: Platform.Type,
    handler: MessageHandler<M>
) = addHandler(M::class.java, side, handler)

/**
 * @see [ChannelBinding.IndexedMessageChannel.addHandler]
 */
inline fun <reified M : Message> ChannelBinding.IndexedMessageChannel.addHandler(handler: MessageHandler<M>) =
    addHandler(M::class.java, handler)

/**
 * @see [ExtraClassCatalogRegistryModule.hasRegistrationFor]
 */
inline fun <TExtra, reified C : TExtra> ExtraClassCatalogRegistryModule<*, TExtra>.hasRegistrationFor(): Boolean =
    hasRegistrationFor(C::class.java)

/**
 * @see [ExtraClassCatalogRegistryModule.getForClass]
 */
inline fun <TExtra, T : CatalogType, reified C : TExtra> ExtraClassCatalogRegistryModule<T, TExtra>.getForClass(): T =
    getForClass(C::class.java)

/**
 * @see [ProvisioningException]
 */
inline fun <reified T> provisioningExceptionOf(): ProvisioningException = ProvisioningException(T::class.java)

/**
 * @see [ProvisioningException]
 */
inline fun <reified T> provisioningExceptionOf(message: String): ProvisioningException =
    ProvisioningException(message, T::class.java)

/**
 * @see [ProvisioningException]
 */
inline fun <reified T> provisioningExceptionOf(message: String, cause: Throwable): ProvisioningException =
    ProvisioningException(message, cause, T::class.java)

/**
 * @see [ProvisioningException]
 */
inline fun <reified T> provisioningExceptionOf(cause: Throwable): ProvisioningException =
    ProvisioningException(cause, T::class.java)

/**
 * @see [ServiceManager.setProvider]
 */
inline fun <reified T, P : T> ServiceManager.setProvider(plugin: Any, provider: P) =
    setProvider(plugin, T::class.java, provider)

/**
 * @see [ServiceManager.provide]
 */
inline fun <reified T> ServiceManager.provide(): T? = provide(T::class.java).unwrap()

/**
 * @see [ServiceManager.getRegistration]
 */
inline fun <reified T> ServiceManager.getRegistration(): ProviderRegistration<T>? =
    getRegistration(T::class.java).unwrap()

/**
 * @see [ServiceManager.isRegistered]
 */
inline fun <reified T> ServiceManager.isRegistered(): Boolean = isRegistered(T::class.java)

/**
 * @see [ServiceManager.provideUnchecked]
 */
@Throws(ProvisioningException::class)
inline fun <reified T> ServiceManager.provideUnchecked(): T = provideUnchecked(T::class.java)

/**
 * @see [ArgumentTypes.create]
 */
inline fun <reified T> createArgumentType(key: String): ArgumentType<T> = ArgumentTypes.create(key, T::class.java)

/**
 * @see [SelectorFactory.createArgumentType]
 */
inline fun <reified T> SelectorFactory.createArgumentTypeT(key: String): ArgumentType<T> =
    createArgumentType(key, T::class.java)

/**
 * @see [TextFormatter.firstAfter]
 */
inline fun <reified T : TextRepresentable> TextFormatter<*>.firstAfter(index: Int): T? =
    firstAfter(index, T::class.java).unwrap()

/**
 * @see [TextFormatter.first]
 */
inline fun <reified T : TextRepresentable> TextFormatter<*>.first(): T? = first(T::class.java).unwrap()

/**
 * @see [TextFormatter.forEachAfter]
 */
inline fun <reified T : TextRepresentable> TextFormatter<*>.forEachAfter(index: Int, consumer: Consumer<T>) =
    forEachAfter(index, T::class.java, consumer)

/**
 * @see [TextFormatter.forEach]
 */
inline fun <reified T : TextRepresentable> TextFormatter<*>.forEach(consumer: Consumer<T>) =
    forEach(T::class.java, consumer)

/**
 * @see [DummyClassGenerator.create]
 */
inline fun <reified T, reified E> DummyClassGenerator.create(name: String): ByteArray =
    createClass(T::class.java, name, E::class.java)

/**
 * @see [DummyClassGeneratorProvider.create]
 */
inline fun <reified T, reified E : Throwable> DummyClassGeneratorProvider.create(): Class<T> =
    create(T::class.java, E::class.java)

/**
 * @see [DummyObjectProvider.createFor]
 */
inline fun <reified T> createDummyObjectFor(fieldName: String): T =
    DummyObjectProvider.createFor(T::class.java, fieldName)

/**
 * @see [DummyObjectProvider.createExtendedFor]
 */
inline fun <reified T, I : T> createExtendedDummyObjectFor(fieldName: String): I =
    DummyObjectProvider.createExtendedFor(T::class.java, fieldName)

/**
 * @see [BiomeGenerationSettings.getGenerationPopulators]
 */
inline fun <reified T : GenerationPopulator> BiomeGenerationSettings.getGenerationPopulatorsT(): List<GenerationPopulator> =
    getGenerationPopulators(T::class.java)

/**
 * @see [BiomeGenerationSettings.getPopulators]
 */
inline fun <reified T : Populator> BiomeGenerationSettings.getPopulatorsT(): List<T> = getPopulators(T::class.java)

/**
 * @see [LocationCompositeValueStore.get]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.get(coordinates: Vector3i): T? =
    get(coordinates, T::class.java).unwrap()

/**
 * @see [LocationCompositeValueStore.get]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.get(x: Int, y: Int, z: Int): T? =
    get(x, y, z, T::class.java).unwrap()

/**
 * @see [LocationCompositeValueStore.getOrCreate]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.getOrCreate(coordinates: Vector3i): T? =
    getOrCreate(coordinates, T::class.java).unwrap()

/**
 * @see [LocationCompositeValueStore.getOrCreate]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.getOrCreate(x: Int, y: Int, z: Int): T? =
    getOrCreate(x, y, z, T::class.java).unwrap()

/**
 * @see [LocationCompositeValueStore.supports]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.supports(coordinates: Vector3i): Boolean =
    supports(coordinates, T::class.java)

/**
 * @see [LocationCompositeValueStore.supports]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.supports(x: Int, y: Int, z: Int): Boolean =
    supports(x, y, z, T::class.java)

/**
 * @see [LocationCompositeValueStore.remove]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.remove(coordinates: Vector3i): DataTransactionResult =
    remove(coordinates, T::class.java)

/**
 * @see [LocationCompositeValueStore.remove]
 */
inline fun <reified T : DataManipulator<*, *>> LocationCompositeValueStore.remove(
    x: Int,
    y: Int,
    z: Int
): DataTransactionResult = remove(x, y, z, T::class.java)

/**
 * @see [WorldGenerator.getGenerationPopulators]
 */
inline fun <reified T : GenerationPopulator> WorldGenerator.getGenerationPopulatorsT(): List<GenerationPopulator> =
    getGenerationPopulators(T::class.java)

/**
 * @see [WorldGenerator.getPopulators]
 */
inline fun <reified T : Populator> WorldGenerator.getPopulatorsT(): List<Populator> = getPopulators(T::class.java)

// end sponge types

// configurate types

/**
 * @see [ConfigurationOptions.acceptsType]
 */
inline fun <reified T> ConfigurationOptions.acceptsType() = acceptsType(T::class.java)

/**
 * @see [ObjectMapperFactory.getMapper]
 */
inline fun <reified T> ObjectMapperFactory.getMapper() = getMapper(T::class.java)

/**
 * @see [ObjectMapper.forClass]
 */
@Throws(ObjectMappingException::class)
inline fun <reified T> objectMapperForClass(): ObjectMapper<T> = ObjectMapper.forClass(T::class.java)

// end configurate types

// sponge meta types

/**
 * @see [McModInfo.Builder.registerExtension]
 */
inline fun <reified T> McModInfo.Builder.registerExtension(key: String): McModInfo.Builder =
    registerExtension(key, T::class.java)

/**
 * @see [McModInfo.Builder.registerExtension]
 */
inline fun <reified T> McModInfo.Builder.registerExtension(key: String, adapter: Any): McModInfo.Builder =
    registerExtension(key, T::class.java, adapter)

// end sponge meta types

// gson types

/**
 * @see [ExclusionStrategy.shouldSkipClass]
 */
inline fun <reified T> ExclusionStrategy.shouldSkipClass() = shouldSkipClass(T::class.java)

/**
 * @see [FieldAttributes.getAnnotation]
 */
inline fun <reified T : Annotation> FieldAttributes.getAnnotation(): T = getAnnotation(T::class.java)

/**
 * @see [Gson.getAdapter]
 */
inline fun <reified T> Gson.getAdapter(): TypeAdapter<T> = getAdapter(T::class.java)

/**
 * @see [Gson.fromJson]
 */
inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, T::class.java)

/**
 * @see [Gson.fromJson]
 */
inline fun <reified T> Gson.fromJson(json: Reader): T = fromJson(json, T::class.java)

/**
 * @see [Gson.fromJson]
 */
inline fun <reified T> Gson.fromJson(json: JsonElement): T = fromJson(json, T::class.java)

/**
 * @see [GsonTypeToken.isAssignableFrom]
 */
@Suppress("DEPRECATION")
@Deprecated(message = "this implementation may be inconsistent with javac for types with wildcards.")
inline fun <reified T> GsonTypeToken<*>.isAssignableFrom() = isAssignableFrom(T::class.java)

// end gson types

// guava types

/**
 * @see [ArrayTable.toArray]
 */
inline fun <reified T> ArrayTable<*, *, T>.toArray(): Array<Array<T>> = toArray(T::class.java)

/**
 * @see [ClassToInstanceMap.getInstance]
 */
inline fun <M, reified T : M> ClassToInstanceMap<M>.getInstance(): T? = getInstance(T::class.java)

/**
 * @see [ClassToInstanceMap.putInstance]
 */
inline fun <M, reified T : M> ClassToInstanceMap<M>.putInstance(t: T): T? = putInstance(T::class.java, t)

/**
 * @see [FluentIterable.filter]
 */
inline fun <reified T> FluentIterable<*>.filter(): FluentIterable<T> = filter(T::class.java)

/**
 * @see [FluentIterable.toArray]
 */
inline fun <reified T> FluentIterable<T>.toArray(): Array<T> = toArray(T::class.java)

/**
 * @see [ImmutableClassToInstanceMap.Builder<M>.put]
 */
inline fun <M, reified T : M> ImmutableClassToInstanceMap.Builder<M>.put(t: T): ImmutableClassToInstanceMap.Builder<M> =
    put(T::class.java, t)

/**
 * @see [MultimapBuilder.MultimapBuilderWithKeys<K>.enumSetValues]
 */
inline fun <K, reified V : Enum<V>> MultimapBuilder.MultimapBuilderWithKeys<K>.enumSetValues(): MultimapBuilder.SetMultimapBuilder<K, V> =
    enumSetValues(V::class.java)

/**
 * @see [TypeToken.getSupertype]
 */
inline fun <reified X, T : X> TypeToken<T>.getSupertype(): TypeToken<in T> = getSupertype(X::class.java)

/**
 * @see [TypeToken.getSubtype]
 */
inline fun <reified X, T : X> TypeToken<T>.getSubtype(): TypeToken<out T> = getSubtype(X::class.java)

/**
 * @see [TimeLimiter.newProxy]
 */
inline fun <reified T> TimeLimiter.newProxy(target: T, timeoutDuration: Long, timeoutUnit: TimeUnit): T =
    newProxy(target, T::class.java, timeoutDuration, timeoutUnit)

// end guava types

// apache types

/**
 * @see [ReflectionToStringBuilder.setUpToClass]
 */
inline fun <reified T> ReflectionToStringBuilder.setUpToClass() {
    upToClass = T::class.java
}

// end apache types

// guice types


/**
 * @see [Binder.bindScope]
 */
inline fun <reified T : Annotation> Binder.bindScope(scope: Scope) = bindScope(T::class.java, scope)

/**
 * @see [Binder.bind]
 */
inline fun <reified T> Binder.bind(): AnnotatedBindingBuilder<T> = bind(T::class.java)

/**
 * @see [Binder.requestStaticInjection]
 */
inline fun <reified T> Binder.requestStaticInjection() = requestStaticInjection(T::class.java)

/**
 * @see [Binder.getProvider]
 */
inline fun <reified T> Binder.getProvider(): Provider<T> = getProvider(T::class.java)

/**
 * @see [Binder.getMembersInjector]
 */
inline fun <reified T> Binder.getMembersInjector(): MembersInjector<T> = getMembersInjector(T::class.java)

/**
 * @see [Binder.skipSources]
 */
inline fun <reified T> Binder.skipSources(): Binder = skipSources(T::class.java)

/**
 * @see [Injector.getMembersInjector]
 */
inline fun <reified T> Injector.getMembersInjector(): MembersInjector<T> = getMembersInjector(T::class.java)

/**
 * @see [Injector.getBinding]
 */
inline fun <reified T> Injector.getBinding(): Binding<T> = getBinding(T::class.java)

/**
 * @see [Injector.getProvider]
 */
inline fun <reified T> Injector.getProvider(): Provider<T> = getProvider(T::class.java)

/**
 * @see [Injector.getInstance]
 */
inline fun <reified T> Injector.getInstance(): T = getInstance(T::class.java)

/**
 * @see [GKey.ofType]
 */
inline fun <reified T> GKey<*>.ofType(): GKey<T> = ofType(T::class.java)

/**
 * @see [PrivateBinder.expose]
 */
inline fun <reified T> PrivateBinder.expose(): AnnotatedElementBuilder = expose(T::class.java)

/**
 * @see [PrivateBinder.skipSources]
 */
inline fun <reified T> PrivateBinder.skipSources(): PrivateBinder = skipSources(T::class.java)

/**
 * @see [TypeLiteral.getSupertype]
 */
inline fun <reified T> TypeLiteral<*>.getSupertype(): TypeLiteral<*> = getSupertype(T::class.java)

/**
 * @see [AnnotatedBindingBuilder.annotatedWith]
 */
inline fun <reified A : Annotation, T> AnnotatedBindingBuilder<T>.annotatedWith(): LinkedBindingBuilder<T> =
    annotatedWith(A::class.java)

/**
 * @see [AnnotatedConstantBindingBuilder.annotatedWith]
 */
inline fun <reified T : Annotation> AnnotatedConstantBindingBuilder.annotatedWith(): ConstantBindingBuilder =
    annotatedWith(T::class.java)

/**
 * @see [AnnotatedElementBuilder.annotatedWith]
 */
inline fun <reified T : Annotation> AnnotatedElementBuilder.annotatedWith() = annotatedWith(T::class.java)

/**
 * @see [ConstantBindingBuilder.to]
 */
inline fun <reified T> ConstantBindingBuilder.to() = to(T::class.java)

/**
 * @see [LinkedBindingBuilder.to]
 */
inline fun <reified T> LinkedBindingBuilder<in T>.to(): ScopedBindingBuilder = to(T::class.java)

/**
 * @see [LinkedBindingBuilder.toProvider]
 */
inline fun <reified P : XProvider<T>, T> LinkedBindingBuilder<T>.toProvider(): ScopedBindingBuilder =
    toProvider(P::class.java)

/**
 * @see [ScopedBindingBuilder.`in`]
 */
inline fun <reified T : Annotation> ScopedBindingBuilder.`in`() = `in`(T::class.java)

/**
 * @see [AbstractBindingBuilder.`in`]
 */
inline fun <reified T : Annotation> AbstractBindingBuilder<*>.`in`() = `in`(T::class.java)

/**
 * @see [BindingScopingVisitor.visitScopeAnnotation]
 */
inline fun <reified T : Annotation, V> BindingScopingVisitor<V>.visitScopeAnnotation(): V =
    visitScopeAnnotation(T::class.java)

/**
 * @see [TypeEncounter.getProvider]
 */
inline fun <reified T> TypeEncounter<*>.getProvider(): Provider<T> = getProvider(T::class.java)

/**
 * @see [TypeEncounter.getMembersInjector]
 */
inline fun <reified T> TypeEncounter<*>.getMembersInjector(): MembersInjector<T> = getMembersInjector(T::class.java)

// end guice types
