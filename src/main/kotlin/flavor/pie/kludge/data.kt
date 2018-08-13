@file:Suppress("UNCHECKED_CAST")

package flavor.pie.kludge

import org.spongepowered.api.data.DataContainer
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.DataTransactionResult
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.manipulator.DataManipulator
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator
import org.spongepowered.api.data.manipulator.mutable.block.PlantData
import org.spongepowered.api.data.value.BaseValue
import org.spongepowered.api.data.value.ValueContainer
import org.spongepowered.api.data.value.immutable.ImmutableValue
import org.spongepowered.api.data.value.mutable.CompositeValueStore
import org.spongepowered.api.data.value.mutable.Value
import kotlin.reflect.KClass

/**
 * Checks if a [Key] is in this container's keys.
 * @see ValueContainer.getKeys
 */
operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(key: Key<*>) = key in keys

/**
 * Checks if a [Value] is in this container's values.
 * @see ValueContainer.getValues
 */
operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(value: Value<*>) = value.asImmutable() in values

/**
 * Checks if an [ImmutableValue] is in this container's values.
 * @see ValueContainer.getValues
 */
operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(value: ImmutableValue<*>) = value in values

/**
 * @see CompositeValueStore.offer
 */
operator fun <E> CompositeValueStore<*, *>.set(key: Key<out BaseValue<E>>, value: E): DataTransactionResult = offer(key, value)

/**
 * @see CompositeValueStore.offer
 */
operator fun <E> CompositeValueStore<*, *>.plusAssign(value: BaseValue<E>) { offer(value) }

/**
 * @see CompositeValueStore.offer
 */
operator fun <E> CompositeValueStore<*, *>.plus(value: BaseValue<E>): DataTransactionResult = offer(value)

/**
 * @see CompositeValueStore.offer
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plusAssign(valueContainer: H) { offer(valueContainer) }

/**
 * @see CompositeValueStore.offer
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plus(valueContainer: H): DataTransactionResult = offer(valueContainer)

/**
 * @see CompositeValueStore.offer
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plusAssign(valueContainers: Iterable<H>) { offer(valueContainers) }

/**
 * @see CompositeValueStore.offer
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plus(valueContainers: Iterable<H>): DataTransactionResult = offer(valueContainers)

/**
 * @see CompositeValueStore.remove
 */
operator fun CompositeValueStore<*, *>.minusAssign(value: BaseValue<*>) { remove(value) }

/**
 * @see CompositeValueStore.remove
 */
operator fun CompositeValueStore<*, *>.minus(value: BaseValue<*>): DataTransactionResult = remove(value)

/**
 * @see CompositeValueStore.remove
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.minusAssign(containerClass: KClass<out H>) { remove(containerClass.java) }

/**
 * @see CompositeValueStore.remove
 */
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.minus(containerClass: KClass<out H>): DataTransactionResult = remove(containerClass.java)

/**
 * @see CompositeValueStore.remove
 */
operator fun CompositeValueStore<*, *>.minusAssign(key: Key<*>) { remove(key) }

/**
 * @see CompositeValueStore.remove
 */
operator fun CompositeValueStore<*, *>.minus(key: Key<*>): DataTransactionResult = remove(key)

/**
 * @see CompositeValueStore.copyFrom
 */
operator fun <S: CompositeValueStore<S, *>> CompositeValueStore<S, *>.remAssign(that: S) { copyFrom(that) }

/**
 * @see CompositeValueStore.copyFrom
 */
operator fun <S: CompositeValueStore<S, *>> CompositeValueStore<S, *>.rem(that: S): DataTransactionResult = copyFrom(that)

/**
 * @see CompositeValueStore.undo
 */
operator fun CompositeValueStore<*, *>.minusAssign(result: DataTransactionResult) { undo(result) }

/**
 * @see CompositeValueStore.undo
 */
operator fun CompositeValueStore<*, *>.minus(result: DataTransactionResult): DataTransactionResult = undo(result)

/**
 * @see DataHolder.setRawData
 */
operator fun DataHolder.remAssign(container: DataContainer) = setRawData(container)

/**
 * @see DataHolder.validateRawData
 */
operator fun DataHolder.rem(container: DataContainer) = validateRawData(container)

/**
 * @see DataManipulator.set
 */
operator fun DataManipulator<*, *>.plusAssign(value: BaseValue<*>) { set(value) }

/**
 * @see DataManipulator.set
 */
operator fun DataManipulator<*, *>.plusAssign(values: Iterable<BaseValue<*>>) { set(values) }

/**
 * @see DataManipulator.fill
 */
operator fun DataManipulator<*, *>.remAssign(dataHolder: DataHolder) { fill(dataHolder) }

/**
 * @see DataManipulator.fill
 */
operator fun <T: DataManipulator<*, *>> T?.rem(dataHolder: DataHolder): T? = this?.fill(dataHolder).unwrap() as T?

/**
 * @see DataManipulator.from
 */
operator fun DataManipulator<*, *>.remAssign(dataContainer: DataContainer) { from(dataContainer) }

/**
 * @see DataManipulator.from
 */
operator fun <T: DataManipulator<*, *>> T?.rem(dataContainer: DataContainer): T? = this?.from(dataContainer).unwrap() as T?

/**
 * @see ImmutableDataManipulator.with
 */
operator fun <T: ImmutableDataManipulator<*, *>> T?.plus(value: BaseValue<*>): T? = this?.with(value).unwrap() as T?
