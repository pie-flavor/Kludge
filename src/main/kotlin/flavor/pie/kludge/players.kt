package flavor.pie.kludge

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.type.GridInventory
import org.spongepowered.api.item.inventory.entity.Hotbar
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextElement
import org.spongepowered.api.text.TextTemplate
import org.spongepowered.api.text.channel.ChatTypeMessageReceiver
import org.spongepowered.api.text.channel.MessageReceiver
import org.spongepowered.api.text.chat.ChatType

val Player.storageInventory
    get() = inventory.query<Inventory>(GridInventory::class.java, Hotbar::class.java)!!

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
