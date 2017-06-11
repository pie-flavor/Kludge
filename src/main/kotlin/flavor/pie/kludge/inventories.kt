package flavor.pie.kludge

import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryProperty
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.Slot
import org.spongepowered.api.item.inventory.property.SlotIndex
import org.spongepowered.api.item.inventory.property.SlotPos
import org.spongepowered.api.item.inventory.type.Inventory2D
import org.spongepowered.api.item.inventory.type.OrderedInventory
import org.spongepowered.api.text.translation.Translation
import kotlin.reflect.KClass

operator fun <T: InventoryProperty<*, *>> Inventory.get(property: KClass<T>, key: Any): T? = getProperty(property.java, key).unwrap()

operator fun <T: InventoryProperty<*, *>> Inventory.get(child: Inventory, property: KClass<T>, key: Any): T? = getProperty(child, property.java, key).unwrap()

operator fun Inventory.plusAssign(stack: ItemStack) {
    offer(stack)
}

operator fun <T: Inventory> Inventory.get(vararg types: KClass<*>): T = query(*types)

operator fun <T: Inventory> Inventory.get(type: KClass<T>): T = query(type)

operator fun Inventory.get(vararg types: ItemType): Inventory = query(*types)

operator fun Inventory.get(vararg types: ItemStack): Inventory = query(*types)

operator fun Inventory.get(vararg props: InventoryProperty<*, *>): Inventory = query(*props)

operator fun Inventory.get(vararg names: Translation): Inventory = query(*names)

operator fun Inventory.get(vararg names: String): Inventory = query(*names)

operator fun Inventory.get(vararg args: Any): Inventory = query(*args)

operator fun Inventory.invoke(vararg types: ItemStack): Inventory = queryAny(*types)

operator fun Inventory.invoke(): ItemStack? = peek().unwrap()

val Inventory.slots: Iterable<Slot> get() = slots()

operator fun Inventory.get(index: Int): Slot? = query(SlotIndex(index))

operator fun OrderedInventory.get(index: Int): Slot? = getSlot(SlotIndex(index)).unwrap()

operator fun OrderedInventory.invoke(index: Int): ItemStack? = peek(SlotIndex(index)).unwrap()

operator fun OrderedInventory.set(index: Int, stack: ItemStack) {
    set(SlotIndex(index), stack)
}

operator fun Inventory.get(x: Int, y: Int): Slot? = query(SlotPos(x, y))

operator fun Inventory2D.get(x: Int, y: Int): Slot? = getSlot(SlotPos(x, y)).unwrap()

operator fun Inventory2D.invoke(x: Int, y: Int): Slot? = getSlot(SlotPos(x, y)).unwrap()

operator fun Inventory2D.set(x: Int, y: Int, stack: ItemStack) {
    set(SlotPos(x, y), stack)
}
