package flavor.pie.kludge

import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryProperty
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.Slot
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.item.inventory.property.SlotPos
import org.spongepowered.api.item.inventory.query.QueryOperation
import org.spongepowered.api.item.inventory.query.QueryOperationType
import org.spongepowered.api.item.inventory.query.QueryOperationTypes
import org.spongepowered.api.item.inventory.type.Inventory2D
import org.spongepowered.api.item.inventory.type.OrderedInventory
import org.spongepowered.api.text.translation.Translation
import java.util.function.Predicate
import kotlin.reflect.KClass

/**
 * @see Inventory.getProperty
 */
operator fun <T: InventoryProperty<*, *>> Inventory.get(property: KClass<T>, key: Any): T? =
        getProperty(property.java, key).unwrap()

/**
 * @see Inventory.getProperty
 */
operator fun <T: InventoryProperty<*, *>> Inventory.get(child: Inventory, property: KClass<T>, key: Any): T? =
        getProperty(child, property.java, key).unwrap()

/**
 * @see Inventory.offer
 */
operator fun Inventory.plusAssign(stack: ItemStack) {
    offer(stack)
}

/**
 * Queries the inventory for [QueryOperationTypes.INVENTORY_TYPE].
 * @see Inventory.query
 */
operator fun <T: Inventory> Inventory.get(vararg types: KClass<out Inventory>): T =
        query(*types.map { QueryOperationTypes.INVENTORY_TYPE.of(it.java) }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.INVENTORY_TYPE].
 * @see Inventory.query
 */
operator fun <T: Inventory> Inventory.get(type: KClass<T>): T =
        query(QueryOperationTypes.INVENTORY_TYPE.of(type.java))

/**
 * Queries the inventory for [QueryOperationTypes.ITEM_TYPE].
 * @see Inventory.query
 */
operator fun Inventory.get(vararg types: ItemType): Inventory =
        query(*types.map { QueryOperationTypes.ITEM_TYPE.of(it) }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY].
 * @see Inventory.query
 */
operator fun Inventory.get(vararg types: ItemStack): Inventory =
        query(*types.map { QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(it) }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.INVENTORY_PROPERTY].
 * @see Inventory.query
 */
operator fun Inventory.get(vararg props: InventoryProperty<*, *>): Inventory =
        query(*props.map { QueryOperationTypes.INVENTORY_PROPERTY.of(it) }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.INVENTORY_TRANSLATION].
 * @see Inventory.query
 */
operator fun Inventory.get(vararg names: Translation): Inventory =
        query(*names.map { QueryOperationTypes.INVENTORY_TRANSLATION.of(it) }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.ITEM_STACK_CUSTOM].
 * @see Inventory.query
 */
operator fun Inventory.get(vararg predicates: (ItemStack) -> Boolean): Inventory =
        query(*predicates.map { QueryOperationTypes.ITEM_STACK_CUSTOM.of(Predicate(it)) }.toTypedArray())

/**
 * @see Inventory.query
 */
operator fun Inventory.get(vararg queries: QueryOperation<*>): Inventory =
        query(*queries)

/**
 * For each argument in [args], determines what [QueryOperationType] to use.
 *
 * If the argument is an [ItemStack],
 * [QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY] is used.
 */
@Suppress("UNCHECKED_CAST")
operator fun Inventory.get(vararg args: Any): Inventory =
        query(*args.map { when (it) {
            is KClass<*> -> QueryOperationTypes.INVENTORY_TYPE.of((it as KClass<out Inventory>).java)
            is ItemType -> QueryOperationTypes.ITEM_TYPE.of(it)
            is ItemStack -> QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(it)
            is InventoryProperty<*, *> -> QueryOperationTypes.INVENTORY_PROPERTY.of(it)
            is Translation -> QueryOperationTypes.INVENTORY_TRANSLATION.of(it)
            is Function1<*, *> -> QueryOperationTypes.ITEM_STACK_CUSTOM.of(Predicate(it as (ItemStack) -> Boolean))
            else -> throw IllegalArgumentException("args is not one of: KClass, ItemType, ItemStack, InventoryProperty, Translation, Function1")
        } }.toTypedArray())

/**
 * Queries the inventory for [QueryOperationTypes.ITEM_STACK_EXACT].
 * @see Inventory.query
 */
operator fun Inventory.invoke(vararg stacks: ItemStack): Inventory =
        query(*stacks.map { QueryOperationTypes.ITEM_STACK_EXACT.of(it) }.toTypedArray())

/**
 * @see Inventory.peek
 */
operator fun Inventory.invoke(): ItemStack? = peek().unwrap()

/**
 * @see Inventory.slots
 */
val Inventory.slots: Iterable<Slot> get() = slots()

/**
 * Queries the inventory for a [SlotIndex] with the matching [index].
 * @see Inventory.query
 * @see QueryOperationTypes.INVENTORY_PROPERTY
 */
operator fun Inventory.get(index: Int): Slot? = this[SlotIndex.of(index)].let { it as? Slot ?: it.slots.firstOrNull() }

/**
 * @see OrderedInventory.getSlot
 */
operator fun OrderedInventory.get(index: Int): Slot? = getSlot(SlotIndex.of(index)).unwrap()

/**
 * @see OrderedInventory.peek
 */
operator fun OrderedInventory.invoke(index: Int): ItemStack? = peek(SlotIndex.of(index)).unwrap()

/**
 * @see OrderedInventory.set
 */
operator fun OrderedInventory.set(index: Int, stack: ItemStack) {
    set(SlotIndex.of(index), stack)
}

/**
 * Queries the inventory for a [SlotPos] with the matching [x] and [y].
 * @see Inventory.query
 * @see QueryOperationTypes.INVENTORY_PROPERTY
 */
operator fun Inventory.get(x: Int, y: Int): Slot? = this[SlotPos.of(x, y)].let { it as? Slot ?: it.slots.firstOrNull() }

/**
 * @see Inventory2D.getSlot
 */
operator fun Inventory2D.get(x: Int, y: Int): Slot? = getSlot(SlotPos.of(x, y)).unwrap()

/**
 * @see Inventory2D.peek
 */
operator fun Inventory2D.invoke(x: Int, y: Int): ItemStack? = peek(SlotPos.of(x, y)).unwrap()

/**
 * @see Inventory2D.set
 */
operator fun Inventory2D.set(x: Int, y: Int, stack: ItemStack) {
    set(SlotPos.of(x, y), stack)
}

/**
 * Gets the slot at the [x] and [y] coordinates, and sets it to [stack].
 * @see Inventory.set
 * @see Inventory.get
 */
operator fun Inventory.set(x: Int, y: Int, stack: ItemStack) {
    (this[x, y] ?: throw IllegalArgumentException("Invalid position")).set(stack)
}

/**
 * Gets the slot at index [index], and sets it to [stack].
 * @see Inventory.get
 * @see Inventory.set
 */
operator fun Inventory.set(index: Int, stack: ItemStack) {
    (this[index] ?: throw IllegalArgumentException("Invalid index")).set(stack)
}

/**
 * Gets the slot at index [index], and peeks at the result.
 * @see Inventory.get
 * @see Inventory.peek
 */
operator fun Inventory.invoke(index: Int): ItemStack? = get(index)?.peek().unwrap()

/**
 * Gets the slot the [x] and [y] coordinates, and peeks at the result.
 * @see Inventory.get
 * @see Inventory.peek
 */
operator fun Inventory.invoke(x: Int, y: Int): ItemStack? = get(x, y)?.peek().unwrap()
