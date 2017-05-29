package flavor.pie.kludge

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.entity.living.player.User
import org.spongepowered.api.service.user.UserStorageService
import java.util.UUID

fun UUID.player(): Player? = !Server.getPlayer(this)
internal val service: UserStorageService? by Service
fun UUID.user(): User? = !service?.get(this)
