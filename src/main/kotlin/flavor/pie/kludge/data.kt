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

operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(key: Key<*>) = key in keys
operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(value: Value<*>) = value.asImmutable() in values
operator fun <C: ValueContainer<C>> ValueContainer<C>.contains(value: ImmutableValue<*>) = value in values

operator fun <E> CompositeValueStore<*, *>.set(key: Key<out BaseValue<E>>, value: E): DataTransactionResult = offer(key, value)

operator fun <E> CompositeValueStore<*, *>.plusAssign(value: BaseValue<E>) { offer(value) }
operator fun <E> CompositeValueStore<*, *>.plus(value: BaseValue<E>): DataTransactionResult = offer(value)
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plusAssign(valueContainer: H) { offer(valueContainer) }
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plus(valueContainer: H): DataTransactionResult = offer(valueContainer)
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plusAssign(valueContainers: Iterable<H>) { offer(valueContainers) }
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.plus(valueContainers: Iterable<H>): DataTransactionResult = offer(valueContainers)

operator fun CompositeValueStore<*, *>.minusAssign(value: BaseValue<*>) { remove(value) }
operator fun CompositeValueStore<*, *>.minus(value: BaseValue<*>): DataTransactionResult = remove(value)
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.minusAssign(containerClass: KClass<out H>) { remove(containerClass.java) }
operator fun <H: ValueContainer<*>> CompositeValueStore<*, H>.minus(containerClass: KClass<out H>): DataTransactionResult = remove(containerClass.java)
operator fun CompositeValueStore<*, *>.minusAssign(key: Key<*>) { remove(key) }
operator fun CompositeValueStore<*, *>.minus(key: Key<*>): DataTransactionResult = remove(key)
operator fun <S: CompositeValueStore<S, *>> CompositeValueStore<S, *>.remAssign(that: S) { copyFrom(that) }
operator fun <S: CompositeValueStore<S, *>> CompositeValueStore<S, *>.rem(that: S): DataTransactionResult = copyFrom(that)

operator fun CompositeValueStore<*, *>.minusAssign(result: DataTransactionResult) { undo(result) }
operator fun CompositeValueStore<*, *>.minus(result: DataTransactionResult): DataTransactionResult = undo(result)

operator fun DataHolder.remAssign(container: DataContainer) = setRawData(container)
operator fun DataHolder.rem(container: DataContainer) = validateRawData(container)

operator fun DataManipulator<*, *>.plusAssign(value: BaseValue<*>) { set(value) }
operator fun DataManipulator<*, *>.plusAssign(values: Iterable<BaseValue<*>>) { set(values) }
operator fun DataManipulator<*, *>.remAssign(dataHolder: DataHolder) { fill(dataHolder) }
operator fun <T: DataManipulator<*, *>> T?.rem(dataHolder: DataHolder): T? = this?.fill(dataHolder).unwrap() as T?
operator fun DataManipulator<*, *>.remAssign(dataContainer: DataContainer) { from(dataContainer) }
operator fun <T: DataManipulator<*, *>> T?.rem(dataContainer: DataContainer): T? = this?.from(dataContainer).unwrap() as T?

operator fun <T: ImmutableDataManipulator<*, *>> T?.plus(value: BaseValue<*>): T? = this?.with(value).unwrap() as T?
