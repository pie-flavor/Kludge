package flavor.pie.kludge

import org.spongepowered.api.block.BlockSnapshot
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.item.ItemType
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.text.Text
import org.spongepowered.api.world.Location

/**
 * Creates a new [ItemStack] with quantity 1 and this item type.
 * @see ItemStack.of
 */
fun ItemType.toStack(): ItemStack = ItemStack.of(this, 1)

/**
 * Creates a new [ItemStack] with this item type.
 * @see itemStackOf
 * @see ItemStack.Builder.itemType
 */
inline fun ItemType.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().itemType(this).apply(fn).build()

/**
 * Creates a new [ItemStack] with this item type and quantity [quantity].
 * @see ItemStack.of
 */
fun ItemType.toStack(quantity: Int): ItemStack = ItemStack.of(this, quantity)

/**
 * Creates a new [ItemStack] with this item type and quantity [quantity].
 * @see itemStackOf
 * @see ItemStack.Builder.itemType
 * @see ItemStack.Builder.quantity
 */
inline fun ItemType.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().itemType(this).quantity(quantity).apply(fn).build()

/**
 * Creates a new [ItemStack] from this block type with quantity 1.
 * @see BlockType.getItem
 * @see ItemStack.of
 */
fun BlockType.toStack(): ItemStack? = item.unwrap()?.let { ItemStack.of(it, 1) }

/**
 * Creates a new [ItemStack] from this block type.
 * @see BlockType.getItem
 * @see itemStackOf
 * @see ItemStack.Builder.itemType
 */
inline fun BlockType.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack? =
        item.unwrap()?.let { ItemStack.builder().itemType(it).apply(fn).build() }

/**
 * Creates a new [ItemStack] from this block type with quantity [quantity].
 * @see BlockType.getItem
 * @see ItemStack.of
 */
fun BlockType.toStack(quantity: Int): ItemStack? = item.unwrap()?.let { ItemStack.of(it, quantity) }

/**
 * Creates a new [ItemStack] from this block type with quantity [quantity].
 * @see BlockType.getItem
 * @see itemStackOf
 * @see ItemStack.Builder.itemType
 * @see ItemStack.Builder.quantity
 */
inline fun BlockType.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack? =
        item.unwrap()?.let { ItemStack.builder().itemType(it).quantity(quantity).apply(fn).build() }

/**
 * Creates a new [ItemStack] from this block state.
 * @see ItemStack.Builder.fromBlockState
 */
fun BlockState.toStack(): ItemStack = ItemStack.builder().fromBlockState(this).build()

/**
 * Creates a new [ItemStack] from this block state.
 * @see itemStackOf
 * @see ItemStack.Builder.fromBlockState
 */
inline fun BlockState.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockState(this).apply(fn).build()

/**
 * Creates a new [ItemStack] from this block state and quantity [quantity].
 * @see ItemStack.Builder.quantity
 * @see ItemStack.Builder.fromBlockState
 */
fun BlockState.toStack(quantity: Int): ItemStack = ItemStack.builder().fromBlockState(this).quantity(quantity).build()

/**
 * Creates a new [ItemStack] from this block state and quantity [quantity].
 * @see itemStackOf
 * @see ItemStack.Builder.quantity
 * @see ItemStack.Builder.fromBlockState
 */
inline fun BlockState.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockState(this).quantity(quantity).apply(fn).build()

/**
 * Creates a new [ItemStack] from this block snapshot.
 * @see ItemStack.Builder.fromBlockSnapshot
 */
fun BlockSnapshot.toStack(): ItemStack = ItemStack.builder().fromBlockSnapshot(this).build()

/**
 * Creates a new [ItemStack] from this block snapshot.
 * @see itemStackOf
 * @see ItemStack.Builder.fromBlockSnapshot
 */
inline fun BlockSnapshot.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).apply(fn).build()

/**
 * Creates a new [ItemStack] from this block snapshot with quantity [quantity].
 * @see ItemStack.Builder.fromBlockSnapshot
 * @see ItemStack.Builder.quantity
 */
fun BlockSnapshot.toStack(quantity: Int): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).quantity(quantity).build()

/**
 * Creates a new [ItemStack] from this block snapshot with quantity [quantity].
 * @see ItemStack.Builder.fromBlockSnapshot
 * @see ItemStack.Builder.quantity
 * @see itemStackOf
 */
inline fun BlockSnapshot.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        ItemStack.builder().fromBlockSnapshot(this).quantity(quantity).apply(fn).build()

/**
 * Creates a new [ItemStack] from the block at this [Location].
 * @see Location.createSnapshot
 * @see BlockSnapshot.toStack
 */
fun Location<*>.toStack(): ItemStack = createSnapshot().toStack()

/**
 * Creates a new [ItemStack] from the block at this [Location].
 * @see Location.createSnapshot
 * @see BlockSnapshot.toStack
 */
inline fun Location<*>.toStack(fn: ItemStack.Builder.() -> Unit): ItemStack = createSnapshot().toStack(fn)

/**
 * Creates a new [ItemStack] from the block at this [Location] with quantity
 * [quantity].
 * @see Location.createSnapshot
 * @see BlockSnapshot.toStack
 */
fun Location<*>.toStack(quantity: Int): ItemStack = createSnapshot().toStack(quantity)

/**
 * Creates a new [ItemStack] from the block at this [Location] with quantity
 * [quantity].
 * @see Location.createSnapshot
 * @see BlockSnapshot.toStack
 */
inline fun Location<*>.toStack(quantity: Int, fn: ItemStack.Builder.() -> Unit): ItemStack =
        createSnapshot().toStack(quantity, fn)

/**
 * Shorthand for assigning [Keys.DISPLAY_NAME].
 * @see ItemStack.Builder.add
 */
fun ItemStack.Builder.displayName(name: Text): ItemStack.Builder = add(Keys.DISPLAY_NAME, name)

/**
 * Shorthand for assigning [Keys.ITEM_LORE].
 * @see ItemStack.Builder.add
 */
fun ItemStack.Builder.lore(lore: List<Text>): ItemStack.Builder = add(Keys.ITEM_LORE, lore)