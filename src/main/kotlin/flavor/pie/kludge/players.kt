package flavor.pie.kludge

import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.ItemStackSnapshot
import org.spongepowered.api.item.inventory.entity.MainPlayerInventory
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextElement
import org.spongepowered.api.text.TextTemplate
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver
import org.spongepowered.api.text.channel.MessageReceiver
import org.spongepowered.api.text.chat.ChatType

/**
 * Shorthand for querying for [MainPlayerInventory].
 */
val Player.storageInventory
    get() = inventory[MainPlayerInventory::class]

/**
 * If this message receiver is a [ChatTypeMessageReceiver], calls
 * [ChatTypeMessageReceiver.sendMessage]. Otherwise, calls
 * [MessageReceiver.sendMessage].
 */
fun MessageReceiver.sendMessage(type: ChatType, message: Text): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, message)
            true
        } else {
            sendMessage(message)
            false
        }

/**
 * If this message receiver is a [ChatTypeMessageReceiver], calls
 * [ChatTypeMessageReceiver.sendMessage]. Otherwise, calls
 * [MessageReceiver.sendMessage].
 */
fun MessageReceiver.sendMessage(type: ChatType, template: TextTemplate): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, template)
            true
        } else {
            sendMessage(template)
            false
        }

/**
 * If this message receiver is a [ChatTypeMessageReceiver], calls
 * [ChatTypeMessageReceiver.sendMessage]. Otherwise, calls
 * [MessageReceiver.sendMessage].
 */
fun MessageReceiver.sendMessage(type: ChatType, template: TextTemplate, parameters: Map<String, TextElement>): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, template, parameters)
            true
        } else {
            sendMessage(template, parameters)
            false
        }

/**
 * If this message receiver is a [ChatTypeMessageReceiver], calls
 * [ChatTypeMessageReceiver.sendMessage]. Otherwise, calls
 * [MessageReceiver.sendMessage].
 */
fun MessageReceiver.sendMessages(type: ChatType, messages: Iterable<Text>): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessages(type, messages)
            true
        } else {
            sendMessages(messages)
            false
        }

/**
 * If this message receiver is a [ChatTypeMessageReceiver], calls
 * [ChatTypeMessageReceiver.sendMessage]. Otherwise, calls
 * [MessageReceiver.sendMessage].
 */
fun MessageReceiver.sendMessage(type: ChatType, vararg messages: Text): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessages(type, *messages)
            true
        } else {
            sendMessages(*messages)
            false
        }

/**
 * Attempts to [offer][Inventory.offer] [item] to the player's
 * [MainPlayerInventory]. If this fails, attempts to drop the item at the
 * player's location.
 * @return A list of rejected items
 */
fun Player.give(item: ItemStack): List<ItemStackSnapshot> {
    val res = storageInventory.offer(item)
    val ret = mutableListOf<ItemStackSnapshot>()
    for (rejected in res.rejectedItems) {
        try {
            val entity = world.createEntity(EntityTypes.ITEM, location.position)
            entity[Keys.REPRESENTED_ITEM] = rejected
            if (!world.spawnEntity(entity)) {
                ret += rejected
            }
        } catch (e: Exception) {
            ret += rejected
        }
    }
    return ret
}
