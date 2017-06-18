package flavor.pie.kludge

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.type.GridInventory
import org.spongepowered.api.item.inventory.entity.Hotbar

val Player.storageInventory
    get() = inventory.query<Inventory>(GridInventory::class.java, Hotbar::class.java)!!