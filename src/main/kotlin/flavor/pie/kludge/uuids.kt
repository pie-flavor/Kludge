package flavor.pie.kludge

import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.entity.living.player.User
import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.profile.GameProfileManager
import org.spongepowered.api.service.user.UserStorageService
import org.spongepowered.api.Server
import java.util.UUID
import java.util.concurrent.CompletableFuture

/**
 * Returns the [Player] with this [UUID], or null if there is none.
 * @see Server.getPlayer
 */
fun UUID.player(): Player? = !Server.getPlayer(this)
internal val service: UserStorageService? by Service

/**
 * Returns the [User] with this [UUID], or null if there is none.
 * @see UserStorageService.get
 */
fun UUID.user(): User? = !service?.get(this)

/**
 * Returns the [GameProfile] with this [UUID], or null if there is none.
 * @see GameProfileManager.get
 */
fun UUID.profile(): CompletableFuture<GameProfile> = GameProfileManager.get(this)

/**
 * Turns this string into a [UUID].
 * @see UUID.fromString
 */
fun String.toUUID(): UUID = UUID.fromString(this)
