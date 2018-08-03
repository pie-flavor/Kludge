package flavor.pie.kludge

import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.EntityTypes
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.ItemStackSnapshot
import org.spongepowered.api.item.inventory.entity.MainPlayerInventory
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextElement
import org.spongepowered.api.text.TextTemplate
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver
import org.spongepowered.api.text.channel.MessageReceiver
import org.spongepowered.api.text.chat.ChatType

val Player.storageInventory
    get() = inventory[MainPlayerInventory::class]

fun MessageReceiver.sendMessage(type: ChatType, message: Text): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, message)
            true
        } else {
            sendMessage(message)
            false
        }

fun MessageReceiver.sendMessage(type: ChatType, template: TextTemplate): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, template)
            true
        } else {
            sendMessage(template)
            false
        }

fun MessageReceiver.sendMessage(type: ChatType, template: TextTemplate, parameters: Map<String, TextElement>): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessage(type, template, parameters)
            true
        } else {
            sendMessage(template, parameters)
            false
        }
fun MessageReceiver.sendMessages(type: ChatType, messages: Iterable<Text>): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessages(type, messages)
            true
        } else {
            sendMessages(messages)
            false
        }

fun MessageReceiver.sendMessage(type: ChatType, vararg messages: Text): Boolean =
        if (this is ChatTypeMessageReceiver) {
            sendMessages(type, *messages)
            true
        } else {
            sendMessages(*messages)
            false
        }

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
