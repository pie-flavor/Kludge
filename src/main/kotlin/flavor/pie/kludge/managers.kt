@file:Suppress("PropertyName")

package flavor.pie.kludge

import org.spongepowered.api.Game
import org.spongepowered.api.GameDictionary
import org.spongepowered.api.GameRegistry
import org.spongepowered.api.Platform
import org.spongepowered.api.Server
import org.spongepowered.api.Sponge
import org.spongepowered.api.asset.AssetManager
import org.spongepowered.api.command.CommandManager
import org.spongepowered.api.config.ConfigManager
import org.spongepowered.api.data.DataManager
import org.spongepowered.api.data.property.PropertyRegistry
import org.spongepowered.api.data.value.ValueFactory
import org.spongepowered.api.event.CauseStackManager
import org.spongepowered.api.event.EventManager
import org.spongepowered.api.item.recipe.crafting.CraftingRecipeRegistry
import org.spongepowered.api.item.recipe.smelting.SmeltingRecipeRegistry
import org.spongepowered.api.network.ChannelRegistrar
import org.spongepowered.api.plugin.PluginManager
import org.spongepowered.api.profile.GameProfileManager
import org.spongepowered.api.scheduler.Scheduler
import org.spongepowered.api.service.ServiceManager
import org.spongepowered.api.world.TeleportHelper

/**
 * Shorthand for [Sponge.getAssetManager].
 */
inline val AssetManager: AssetManager get() = Sponge.getAssetManager()
/**
 * Shorthand for [Sponge.getChannelRegistrar].
 */
inline val ChannelRegistrar: ChannelRegistrar get() = Sponge.getChannelRegistrar()
/**
 * Shorthand for [Sponge.getCommandManager].
 */
inline val CommandManager: CommandManager get() = Sponge.getCommandManager()
/**
 * Shorthand for [Sponge.getConfigManager].
 */
inline val ConfigManager: ConfigManager get() = Sponge.getConfigManager()
/**
 * Shorthand for [Sponge.getDataManager].
 */
inline val DataManager: DataManager get() = Sponge.getDataManager()
/**
 * Shorthand for [Sponge.getDictionary].
 */
inline val GameDictionary: GameDictionary? get() = !Sponge.getDictionary()
/**
 * Shorthand for [Sponge.getEventManager].
 */
inline val EventManager: EventManager get() = Sponge.getEventManager()
/**
 * Shorthand for [Sponge.getGame].
 */
inline val Game: Game get() = Sponge.getGame()
/**
 * Shorthand for [Sponge.getPlatform].
 */
inline val Platform: Platform get() = Sponge.getPlatform()
/**
 * Shorthand for [Sponge.getPluginManager].
 */
inline val PluginManager: PluginManager get() = Sponge.getPluginManager()
/**
 * Shorthand for [Sponge.getPropertyRegistry].
 */
inline val PropertyRegistry: PropertyRegistry get() = Sponge.getPropertyRegistry()
/**
 * Shorthand for [Sponge.getRegistry].
 */
inline val GameRegistry: GameRegistry get() = Sponge.getRegistry()
/**
 * Shorthand for [Sponge.getScheduler].
 */
inline val Scheduler: Scheduler get() = Sponge.getScheduler()
/**
 * Shorthand for [Sponge.getScheduler].
 */
inline val Server: Server get() = Sponge.getServer()
/**
 * Shorthand for [Sponge.getServiceManager].
 */
inline val ServiceManager: ServiceManager get() = Sponge.getServiceManager()
/**
 * Shorthand for [Sponge.getTeleportHelper].
 */
inline val TeleportHelper: TeleportHelper get() = Sponge.getTeleportHelper()
/**
 * Shorthand for [Server.getGameProfileManager].
 */
inline val GameProfileManager: GameProfileManager get() = Sponge.getServer().gameProfileManager
/**
 * Shorthand for [Sponge.getCauseStackManager].
 */
inline val CauseStackManager: CauseStackManager get() = Sponge.getCauseStackManager()
/**
 * Shorthand for [GameRegistry.getValueFactory].
 */
inline val ValueFactory: ValueFactory get() = Sponge.getRegistry().valueFactory
/**
 * Shorthand for [GameRegistry.getCraftingRecipeRegistry].
 */
inline val CraftingRecipeRegistry: CraftingRecipeRegistry get() = Sponge.getRegistry().craftingRecipeRegistry
/**
 * Shorthand for [GameRegistry.getSmeltingRecipeRegistry].
 */
inline val SmeltingRecipeRegistry: SmeltingRecipeRegistry get() = Sponge.getRegistry().smeltingRecipeRegistry
