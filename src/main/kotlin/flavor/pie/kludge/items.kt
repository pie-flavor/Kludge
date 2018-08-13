package flavor.pie.kludge

import org.spongepowered.api.block.BlockSnapshot
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.text.Text
import org.spongepowered.api.world.Location

fun ItemType.toStack(): ItemStack = ItemStack.of(this, 1)
inline fun ItemType.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().itemType(this).apply(fn).build()
fun ItemType.toStack(quantity: Int): ItemStack = ItemStack.of(this, quantity)
inline fun ItemType.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().itemType(this).quantity(quantity).apply(fn).build()

fun BlockType.toStack(): ItemStack? = item.unwrap()?.let { ItemStack.of(it, 1) }
inline fun BlockType.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack? =
        item.unwrap()?.let { ItemStack.builder().itemType(it).apply(fn).build() }
fun BlockType.toStack(quantity: Int): ItemStack? = item.unwrap()?.let { ItemStack.of(it, quantity) }
inline fun BlockType.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack? =
        item.unwrap()?.let { ItemStack.builder().itemType(it).quantity(quantity).apply(fn).build() }

fun BlockState.toStack(): ItemStack = ItemStack.builder().fromBlockState(this).build()
inline fun BlockState.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockState(this).apply(fn).build()
fun BlockState.toStack(quantity: Int): ItemStack = ItemStack.builder().fromBlockState(this).quantity(quantity).build()
inline fun BlockState.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockState(this).quantity(quantity).apply(fn).build()

fun BlockSnapshot.toStack(): ItemStack = ItemStack.builder().fromBlockSnapshot(this).build()
inline fun BlockSnapshot.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).apply(fn).build()
fun BlockSnapshot.toStack(quantity: Int): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).quantity(quantity).build()
inline fun BlockSnapshot.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).quantity(quantity).apply(fn).build()

fun Location<*>.toStack(): ItemStack = createSnapshot().toStack()
inline fun Location<*>.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack = createSnapshot().toStack(fn)
fun Location<*>.toStack(quantity: Int): ItemStack = createSnapshot().toStack(quantity)
inline fun Location<*>.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        createSnapshot().toStack(quantity, fn)

fun ItemStack.Builder.displayName(name: Text): ItemStack.Builder = add(Keys.DISPLAY_NAME, name)
fun ItemStack.Builder.lore(lore: List<Text>): ItemStack.Builder = add(Keys.ITEM_LORE, lore)