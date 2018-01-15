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

inline val AssetManager: AssetManager get() = Sponge.getAssetManager()
inline val ChannelRegistrar: ChannelRegistrar get() = Sponge.getChannelRegistrar()
inline val CommandManager: CommandManager get() = Sponge.getCommandManager()
inline val ConfigManager: ConfigManager get() = Sponge.getConfigManager()
inline val DataManager: DataManager get() = Sponge.getDataManager()
inline val GameDictionary: GameDictionary? get() = !Sponge.getDictionary()
inline val EventManager: EventManager get() = Sponge.getEventManager()
inline val Game: Game get() = Sponge.getGame()
inline val Platform: Platform get() = Sponge.getPlatform()
inline val PluginManager: PluginManager get() = Sponge.getPluginManager()
inline val PropertyRegistry: PropertyRegistry get() = Sponge.getPropertyRegistry()
inline val GameRegistry: GameRegistry get() = Sponge.getRegistry()
inline val Scheduler: Scheduler get() = Sponge.getScheduler()
inline val Server: Server get() = Sponge.getServer()
inline val ServiceManager: ServiceManager get() = Sponge.getServiceManager()
inline val TeleportHelper: TeleportHelper get() = Sponge.getTeleportHelper()
inline val GameProfileManager: GameProfileManager get() = Sponge.getServer().gameProfileManager
inline val CauseStackManager: CauseStackManager get() = Sponge.getCauseStackManager()
inline val ValueFactory: ValueFactory get() = Sponge.getRegistry().valueFactory
inline val CraftingRecipeRegistry: CraftingRecipeRegistry get() = Sponge.getRegistry().craftingRecipeRegistry
inline val SmeltingRecipeRegistry: SmeltingRecipeRegistry get() = Sponge.getRegistry().smeltingRecipeRegistry