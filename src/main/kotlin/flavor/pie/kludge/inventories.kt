package flavor.pie.kludge

import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryProperty
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.Slot
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.item.inventory.property.SlotPos
import org.spongepowered.api.item.inventory.query.QueryOperationTypes
import org.spongepowered.api.item.inventory.type.Inventory2D
import org.spongepowered.api.item.inventory.type.OrderedInventory
import org.spongepowered.api.text.translation.Translation
import java.util.function.Predicate
import kotlin.reflect.KClass

operator fun <T: InventoryProperty<*, *>> Inventory.get(property: KClass<T>, key: Any): T? = getProperty(property.java, key).unwrap()

operator fun <T: InventoryProperty<*, *>> Inventory.get(child: Inventory, property: KClass<T>, key: Any): T? = getProperty(child, property.java, key).unwrap()

operator fun Inventory.plusAssign(stack: ItemStack) {
    offer(stack)
}

operator fun <T: Inventory> Inventory.get(vararg types: KClass<out Inventory>): T =
        query(*types.map { QueryOperationTypes.INVENTORY_TYPE.of(it.java) }.toTypedArray())

operator fun <T: Inventory> Inventory.get(type: KClass<T>): T =
        query(QueryOperationTypes.INVENTORY_TYPE.of(type.java))

operator fun Inventory.get(vararg types: ItemType): Inventory =
        query(*types.map { QueryOperationTypes.ITEM_TYPE.of(it) }.toTypedArray())

operator fun Inventory.get(vararg types: ItemStack): Inventory =
        query(*types.map { QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(it) }.toTypedArray())

operator fun Inventory.get(vararg props: InventoryProperty<*, *>): Inventory =
        query(*props.map { QueryOperationTypes.INVENTORY_PROPERTY.of(it) }.toTypedArray())

operator fun Inventory.get(vararg names: Translation): Inventory =
        query(*names.map { QueryOperationTypes.INVENTORY_TRANSLATION.of(it) }.toTypedArray())

operator fun Inventory.get(vararg predicates: (ItemStack) -> Boolean): Inventory =
        query(*predicates.map { QueryOperationTypes.ITEM_STACK_CUSTOM.of(Predicate(it)) }.toTypedArray())

@Suppress("UNCHECKED_CAST")
operator fun Inventory.get(vararg args: Any): Inventory =
        query(*args.map { when (it) {
            is KClass<*> -> QueryOperationTypes.INVENTORY_TYPE.of((it as KClass<out Inventory>).java)
            is ItemType -> QueryOperationTypes.ITEM_TYPE.of(it)
            is ItemStack -> QueryOperationTypes.ITEM_STACK_IGNORE_QUANTITY.of(it)
            is InventoryProperty<*, *> -> QueryOperationTypes.INVENTORY_PROPERTY.of(it)
            is Translation -> QueryOperationTypes.INVENTORY_TRANSLATION.of(it)
            is Function1<*, *> -> QueryOperationTypes.ITEM_STACK_CUSTOM.of(Predicate(it as (ItemStack) -> Boolean))
            else -> throw IllegalArgumentException()
        } }.toTypedArray())

operator fun Inventory.invoke(vararg stacks: ItemStack): Inventory =
        query(*stacks.map { QueryOperationTypes.ITEM_STACK_EXACT.of(it) }.toTypedArray())

operator fun Inventory.invoke(): ItemStack? = peek().unwrap()

val Inventory.slots: Iterable<Slot> get() = slots()

operator fun Inventory.get(index: Int): Slot? = this[SlotIndex(index)] as? Slot

operator fun OrderedInventory.get(index: Int): Slot? = getSlot(SlotIndex(index)).unwrap()

operator fun OrderedInventory.invoke(index: Int): ItemStack? = peek(SlotIndex(index)).unwrap()

operator fun OrderedInventory.set(index: Int, stack: ItemStack) {
    set(SlotIndex(index), stack)
}

operator fun Inventory.get(x: Int, y: Int): Slot? = this[SlotPos(x, y)] as? Slot

operator fun Inventory2D.get(x: Int, y: Int): Slot? = getSlot(SlotPos(x, y)).unwrap()

operator fun Inventory2D.invoke(x: Int, y: Int): Slot? = getSlot(SlotPos(x, y)).unwrap()

operator fun Inventory2D.set(x: Int, y: Int, stack: ItemStack) {
    set(SlotPos(x, y), stack)
}

operator fun Inventory.set(x: Int, y: Int, stack: ItemStack) {
    (this[x, y] ?: throw IllegalArgumentException()).offer(stack)
}
