package flavor.pie.kludge

import com.flowpowered.math.vector.Vector3d
import com.flowpowered.math.vector.Vector3i
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.BlockType
import org.spongepowered.api.block.tileentity.Banner
import org.spongepowered.api.block.tileentity.Bed
import org.spongepowered.api.block.tileentity.Comparator
import org.spongepowered.api.block.tileentity.DaylightDetector
import org.spongepowered.api.block.tileentity.EndGateway
import org.spongepowered.api.block.tileentity.FlowerPot
import org.spongepowered.api.block.tileentity.Jukebox
import org.spongepowered.api.block.tileentity.MobSpawner
import org.spongepowered.api.block.tileentity.Note
import org.spongepowered.api.block.tileentity.Sign
import org.spongepowered.api.block.tileentity.Skull
import org.spongepowered.api.block.tileentity.Structure
import org.spongepowered.api.block.tileentity.carrier.Beacon
import org.spongepowered.api.block.tileentity.carrier.BrewingStand
import org.spongepowered.api.block.tileentity.carrier.Furnace
import org.spongepowered.api.block.tileentity.carrier.Hopper
import org.spongepowered.api.block.tileentity.carrier.TileEntityCarrier
import org.spongepowered.api.command.source.CommandBlockSource
import org.spongepowered.api.data.DataHolder
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.data.manipulator.mutable.item.InventoryItemData
import org.spongepowered.api.data.meta.PatternLayer
import org.spongepowered.api.data.type.Art
import org.spongepowered.api.data.type.BigMushroomType
import org.spongepowered.api.data.type.BrickType
import org.spongepowered.api.data.type.Career
import org.spongepowered.api.data.type.CoalType
import org.spongepowered.api.data.type.ComparatorType
import org.spongepowered.api.data.type.CookedFish
import org.spongepowered.api.data.type.DirtType
import org.spongepowered.api.data.type.DisguisedBlockType
import org.spongepowered.api.data.type.DoublePlantType
import org.spongepowered.api.data.type.DyeColor
import org.spongepowered.api.data.type.Fish
import org.spongepowered.api.data.type.GoldenApple
import org.spongepowered.api.data.type.HandPreference
import org.spongepowered.api.data.type.HandPreferences
import org.spongepowered.api.data.type.HandType
import org.spongepowered.api.data.type.Hinge
import org.spongepowered.api.data.type.HorseColor
import org.spongepowered.api.data.type.HorseStyle
import org.spongepowered.api.data.type.LlamaVariant
import org.spongepowered.api.data.type.LogAxis
import org.spongepowered.api.data.type.NotePitch
import org.spongepowered.api.data.type.OcelotType
import org.spongepowered.api.data.type.ParrotVariant
import org.spongepowered.api.data.type.PickupRule
import org.spongepowered.api.data.type.PistonType
import org.spongepowered.api.data.type.PlantType
import org.spongepowered.api.data.type.PortionType
import org.spongepowered.api.data.type.PrismarineType
import org.spongepowered.api.data.type.QuartzType
import org.spongepowered.api.data.type.RabbitType
import org.spongepowered.api.data.type.RailDirection
import org.spongepowered.api.data.type.SandType
import org.spongepowered.api.data.type.SandstoneType
import org.spongepowered.api.data.type.ShrubType
import org.spongepowered.api.data.type.SkullType
import org.spongepowered.api.data.type.SlabType
import org.spongepowered.api.data.type.StairShape
import org.spongepowered.api.data.type.StoneType
import org.spongepowered.api.data.type.StructureMode
import org.spongepowered.api.data.type.TreeType
import org.spongepowered.api.data.type.WallType
import org.spongepowered.api.data.type.WireAttachmentType
import org.spongepowered.api.data.value.mutable.CompositeValueStore
import org.spongepowered.api.data.value.mutable.Value
import org.spongepowered.api.effect.particle.ParticleType
import org.spongepowered.api.effect.potion.PotionEffect
import org.spongepowered.api.effect.potion.PotionEffectType
import org.spongepowered.api.entity.AreaEffectCloud
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.EntityArchetype
import org.spongepowered.api.entity.EntitySnapshot
import org.spongepowered.api.entity.EntityType
import org.spongepowered.api.entity.ExperienceOrb
import org.spongepowered.api.entity.FallingBlock
import org.spongepowered.api.entity.Item
import org.spongepowered.api.entity.explosive.Explosive
import org.spongepowered.api.entity.explosive.FusedExplosive
import org.spongepowered.api.entity.hanging.Hanging
import org.spongepowered.api.entity.hanging.ItemFrame
import org.spongepowered.api.entity.hanging.Painting
import org.spongepowered.api.entity.living.Ageable
import org.spongepowered.api.entity.living.Agent
import org.spongepowered.api.entity.living.ArmorStand
import org.spongepowered.api.entity.living.Bat
import org.spongepowered.api.entity.living.Humanoid
import org.spongepowered.api.entity.living.Living
import org.spongepowered.api.entity.living.Villager
import org.spongepowered.api.entity.living.animal.Animal
import org.spongepowered.api.entity.living.animal.Donkey
import org.spongepowered.api.entity.living.animal.Horse
import org.spongepowered.api.entity.living.animal.Llama
import org.spongepowered.api.entity.living.animal.Mule
import org.spongepowered.api.entity.living.animal.Ocelot
import org.spongepowered.api.entity.living.animal.Parrot
import org.spongepowered.api.entity.living.animal.Pig
import org.spongepowered.api.entity.living.animal.Rabbit
import org.spongepowered.api.entity.living.animal.RideableHorse
import org.spongepowered.api.entity.living.animal.Sheep
import org.spongepowered.api.entity.living.animal.SkeletonHorse
import org.spongepowered.api.entity.living.animal.Wolf
import org.spongepowered.api.entity.living.animal.ZombieHorse
import org.spongepowered.api.entity.living.golem.IronGolem
import org.spongepowered.api.entity.living.monster.Blaze
import org.spongepowered.api.entity.living.monster.Creeper
import org.spongepowered.api.entity.living.monster.Enderman
import org.spongepowered.api.entity.living.monster.Endermite
import org.spongepowered.api.entity.living.monster.Slime
import org.spongepowered.api.entity.living.monster.Vindicator
import org.spongepowered.api.entity.living.monster.ZombiePigman
import org.spongepowered.api.entity.living.player.Player
import org.spongepowered.api.entity.living.player.User
import org.spongepowered.api.entity.living.player.gamemode.GameMode
import org.spongepowered.api.entity.projectile.DamagingProjectile
import org.spongepowered.api.entity.projectile.EyeOfEnder
import org.spongepowered.api.entity.projectile.Firework
import org.spongepowered.api.entity.projectile.ThrownPotion
import org.spongepowered.api.entity.projectile.arrow.Arrow
import org.spongepowered.api.entity.projectile.arrow.TippedArrow
import org.spongepowered.api.entity.projectile.explosive.WitherSkull
import org.spongepowered.api.entity.projectile.explosive.fireball.LargeFireball
import org.spongepowered.api.entity.projectile.explosive.fireball.SmallFireball
import org.spongepowered.api.entity.vehicle.minecart.HopperMinecart
import org.spongepowered.api.entity.vehicle.minecart.Minecart
import org.spongepowered.api.entity.vehicle.minecart.MobSpawnerMinecart
import org.spongepowered.api.entity.weather.WeatherEffect
import org.spongepowered.api.extra.fluid.FluidStackSnapshot
import org.spongepowered.api.item.FireworkEffect
import org.spongepowered.api.item.enchantment.Enchantment
import org.spongepowered.api.item.inventory.Carrier
import org.spongepowered.api.item.inventory.ItemStackSnapshot
import org.spongepowered.api.item.merchant.Merchant
import org.spongepowered.api.item.merchant.TradeOffer
import org.spongepowered.api.profile.GameProfile
import org.spongepowered.api.statistic.Statistic
import org.spongepowered.api.text.Text
import org.spongepowered.api.util.Axis
import org.spongepowered.api.util.Color
import org.spongepowered.api.util.Direction
import org.spongepowered.api.util.RespawnLocation
import org.spongepowered.api.util.weighted.WeightedSerializableObject
import org.spongepowered.api.util.weighted.WeightedTable
import java.time.Instant
import java.util.UUID
import kotlin.reflect.KProperty

operator fun <T> Value<T>.getValue(thisRef: Any?, property: KProperty<*>): T = this.get()
operator fun <T> Value<T>.setValue(thisRef: Any?, property: KProperty<*>, value: T) {
    this.set(value)
}

inline var Ageable.isAdult: Boolean
    get() = this[Keys.IS_ADULT].get()
    set(value) { this[Keys.IS_ADULT] = value }

inline var CompositeValueStore<*, *>.isAdult: Boolean?
    get() = this[Keys.IS_ADULT].unwrap()
    set(value) { value?.let { this[Keys.IS_ADULT] = it } ?: remove(Keys.IS_ADULT) }

inline var Ageable.age: Int
    get() = this[Keys.AGE].get()
    set(value) { this[Keys.AGE] = value }

inline var CompositeValueStore<*, *>.age: Int?
    get() = this[Keys.AGE].unwrap()
    set(value) { value?.let { this[Keys.AGE] = it } ?: remove(Keys.AGE) }

inline var Agent.isAiEnabled: Boolean
    get() = this[Keys.AI_ENABLED].get()
    set(value) { this[Keys.AI_ENABLED] = value }

inline var CompositeValueStore<*, *>.isAiEnabled: Boolean?
    get() = this[Keys.AI_ENABLED].unwrap()
    set(value) { value?.let { this[Keys.AI_ENABLED] = it } ?: remove(Keys.AI_ENABLED) }

inline var AreaEffectCloud.age: Int
    get() = this[Keys.AREA_EFFECT_CLOUD_AGE].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_AGE] = value }

inline var CompositeValueStore<*, *>.cloudAge: Int?
    get() = this[Keys.AREA_EFFECT_CLOUD_AGE].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_AGE] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_AGE) }

inline var AreaEffectCloud.reapplicationDelay: Int
    get() = this[Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY] = value }

inline var CompositeValueStore<*, *>.reapplicationDelay: Int?
    get() = this[Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_REAPPLICATION_DELAY) }

inline var AreaEffectCloud.color: Color
    get() = this[Keys.AREA_EFFECT_CLOUD_COLOR].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_COLOR] = value }

inline var CompositeValueStore<*, *>.cloudColor: Color?
    get() = this[Keys.AREA_EFFECT_CLOUD_COLOR].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_COLOR] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_COLOR) }

inline var AreaEffectCloud.duration: Int
    get() = this[Keys.AREA_EFFECT_CLOUD_DURATION].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_DURATION] = value }

inline var CompositeValueStore<*, *>.cloudDuration: Int?
    get() = this[Keys.AREA_EFFECT_CLOUD_DURATION].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_DURATION] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_DURATION) }

inline var AreaEffectCloud.durationOnUse: Int
    get() = this[Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE] = value }

inline var CompositeValueStore<*, *>.durationOnUse: Int?
    get() = this[Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_DURATION_ON_USE) }

inline var AreaEffectCloud.effects: List<PotionEffect>
    get() = this[Keys.POTION_EFFECTS].get()
    set(value) { this[Keys.POTION_EFFECTS] = value }

inline var CompositeValueStore<*, *>.effects: List<PotionEffect>?
    get() = this[Keys.POTION_EFFECTS].unwrap()
    set(value) { value?.let { this[Keys.POTION_EFFECTS] = it } ?: remove(Keys.POTION_EFFECTS) }

inline var AreaEffectCloud.particleType: ParticleType
    get() = this[Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE] = value }

inline var CompositeValueStore<*, *>.particleType: ParticleType?
    get() = this[Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_PARTICLE_TYPE) }

inline var AreaEffectCloud.radius: Double
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_RADIUS] = value }

inline var CompositeValueStore<*, *>.cloudRadius: Double?
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_RADIUS] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_RADIUS) }

inline var AreaEffectCloud.radiusOnUse: Double
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE] = value }

inline var CompositeValueStore<*, *>.cloudRadiusOnUse: Double?
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_RADIUS_ON_USE) }

inline var AreaEffectCloud.radiusPerTick: Double
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK] = value }

inline var CompositeValueStore<*, *>.cloudRadiusPerTick: Double?
    get() = this[Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_RADIUS_PER_TICK) }

inline var AreaEffectCloud.waitTime: Int
    get() = this[Keys.AREA_EFFECT_CLOUD_WAIT_TIME].get()
    set(value) { this[Keys.AREA_EFFECT_CLOUD_WAIT_TIME] = value }

inline var CompositeValueStore<*, *>.waitTime: Int?
    get() = this[Keys.AREA_EFFECT_CLOUD_WAIT_TIME].unwrap()
    set(value) { value?.let { this[Keys.AREA_EFFECT_CLOUD_WAIT_TIME] = it } ?: remove(Keys.AREA_EFFECT_CLOUD_WAIT_TIME) }

inline var ArmorStand.hasArms: Boolean
    get() = this[Keys.ARMOR_STAND_HAS_ARMS].get()
    set(value) { this[Keys.ARMOR_STAND_HAS_ARMS] = value }

inline var CompositeValueStore<*, *>.hasArms: Boolean?
    get() = this[Keys.ARMOR_STAND_HAS_ARMS].unwrap()
    set(value) { value?.let { this[Keys.ARMOR_STAND_HAS_ARMS] = it } ?: remove(Keys.ARMOR_STAND_HAS_ARMS) }

inline var ArmorStand.hasBasePlate: Boolean
    get() = this[Keys.ARMOR_STAND_HAS_BASE_PLATE].get()
    set(value) { this[Keys.ARMOR_STAND_HAS_BASE_PLATE] = value }

inline var CompositeValueStore<*, *>.hasBasePlate: Boolean?
    get() = this[Keys.ARMOR_STAND_HAS_BASE_PLATE].unwrap()
    set(value) { value?.let { this[Keys.ARMOR_STAND_HAS_BASE_PLATE] = it } ?: remove(Keys.ARMOR_STAND_HAS_BASE_PLATE) }

inline var ArmorStand.isMarker: Boolean
    get() = this[Keys.ARMOR_STAND_MARKER].get()
    set(value) { this[Keys.ARMOR_STAND_MARKER] = value }

inline var CompositeValueStore<*, *>.isMarker: Boolean?
    get() = this[Keys.ARMOR_STAND_MARKER].unwrap()
    set(value) { value?.let { this[Keys.ARMOR_STAND_MARKER] = it } ?: remove(Keys.ARMOR_STAND_MARKER) }

inline var ArmorStand.isSmall: Boolean
    get() = this[Keys.ARMOR_STAND_IS_SMALL].get()
    set(value) { this[Keys.ARMOR_STAND_IS_SMALL] = value }

inline var CompositeValueStore<*, *>.isSmall: Boolean?
    get() = this[Keys.ARMOR_STAND_IS_SMALL].unwrap()
    set(value) { value?.let { this[Keys.ARMOR_STAND_IS_SMALL] = it } ?: remove(Keys.ARMOR_STAND_IS_SMALL) }

inline var ArmorStand.bodyRotation: Vector3d
    get() = this[Keys.CHEST_ROTATION].get()
    set(value) { this[Keys.CHEST_ROTATION] = value }

inline var CompositeValueStore<*, *>.bodyRotation: Vector3d?
    get() = this[Keys.CHEST_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.CHEST_ROTATION] = it } ?: remove(Keys.CHEST_ROTATION) }

inline var CompositeValueStore<*, *>.headRotation: Vector3d?
    get() = this[Keys.HEAD_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.HEAD_ROTATION] = it } ?: remove(Keys.HEAD_ROTATION) }

inline var ArmorStand.leftArmRotation: Vector3d
    get() = this[Keys.LEFT_ARM_ROTATION].get()
    set(value) { this[Keys.LEFT_ARM_ROTATION] = value }

inline var CompositeValueStore<*, *>.leftArmRotation: Vector3d?
    get() = this[Keys.LEFT_ARM_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.LEFT_ARM_ROTATION] = it } ?: remove(Keys.LEFT_ARM_ROTATION) }

inline var ArmorStand.leftLegRotation: Vector3d
    get() = this[Keys.LEFT_LEG_ROTATION].get()
    set(value) { this[Keys.LEFT_LEG_ROTATION] = value }

inline var CompositeValueStore<*, *>.leftLegRotation: Vector3d?
    get() = this[Keys.LEFT_LEG_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.LEFT_LEG_ROTATION] = it } ?: remove(Keys.LEFT_LEG_ROTATION) }

inline var ArmorStand.rightArmRotation: Vector3d
    get() = this[Keys.RIGHT_ARM_ROTATION].get()
    set(value) { this[Keys.RIGHT_ARM_ROTATION] = value }

inline var CompositeValueStore<*, *>.rightArmRotation: Vector3d?
    get() = this[Keys.RIGHT_ARM_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.RIGHT_ARM_ROTATION] = it } ?: remove(Keys.RIGHT_ARM_ROTATION) }

inline var ArmorStand.rightLegRotation: Vector3d
    get() = this[Keys.RIGHT_LEG_ROTATION].get()
    set(value) { this[Keys.RIGHT_LEG_ROTATION] = value }

inline var CompositeValueStore<*, *>.rightLegRotation: Vector3d?
    get() = this[Keys.RIGHT_LEG_ROTATION].unwrap()
    set(value) { value?.let { this[Keys.RIGHT_LEG_ROTATION] = it } ?: remove(Keys.RIGHT_LEG_ROTATION) }

inline var Arrow.knockbackStrength: Int
    get() = this[Keys.KNOCKBACK_STRENGTH].get()
    set(value) { this[Keys.KNOCKBACK_STRENGTH] = value }

inline var CompositeValueStore<*, *>.knockbackStrength: Int?
    get() = this[Keys.KNOCKBACK_STRENGTH].unwrap()
    set(value) { value?.let { this[Keys.KNOCKBACK_STRENGTH] = it } ?: remove(Keys.KNOCKBACK_STRENGTH) }

inline var Banner.baseColor: DyeColor
    get() = this[Keys.BANNER_BASE_COLOR].get()
    set(value) { this[Keys.BANNER_BASE_COLOR] = value }

inline var CompositeValueStore<*, *>.baseColor: DyeColor?
    get() = this[Keys.BANNER_BASE_COLOR].unwrap()
    set(value) { value?.let { this[Keys.BANNER_BASE_COLOR] = it } ?: remove(Keys.BANNER_BASE_COLOR) }

inline var Banner.patternsList: List<PatternLayer>
    get() = this[Keys.BANNER_PATTERNS].get()
    set(value) { this[Keys.BANNER_PATTERNS] = value }

inline var CompositeValueStore<*, *>.patternsList: List<PatternLayer>?
    get() = this[Keys.BANNER_PATTERNS].unwrap()
    set(value) { value?.let { this[Keys.BANNER_PATTERNS] = it } ?: remove(Keys.BANNER_PATTERNS) }

inline var Beacon.primaryEffect: PotionEffectType?
    get() = this[Keys.BEACON_PRIMARY_EFFECT].get().unwrap()
    set(value) { this[Keys.BEACON_PRIMARY_EFFECT] = value.optional() }

inline var CompositeValueStore<*, *>.primaryEffect: PotionEffectType?
    get() = this[Keys.BEACON_PRIMARY_EFFECT].unwrap().unwrap()
    set(value) { this[Keys.BEACON_PRIMARY_EFFECT] = value.optional() }

inline var Beacon.secondaryEffect: PotionEffectType?
    get() = this[Keys.BEACON_SECONDARY_EFFECT].get().unwrap()
    set(value) { this[Keys.BEACON_SECONDARY_EFFECT] = value.optional() }

inline var CompositeValueStore<*, *>.secondaryEffect: PotionEffectType?
    get() = this[Keys.BEACON_SECONDARY_EFFECT].unwrap().unwrap()
    set(value) { this[Keys.BEACON_SECONDARY_EFFECT] = value.optional() }

fun Beacon.clearEffects() { beaconData.clearEffects() }

inline var Bed.color: DyeColor
    get() = this[Keys.DYE_COLOR].get()
    set(value) { this[Keys.DYE_COLOR] = value }

inline var CompositeValueStore<*, *>.dyeColor: DyeColor?
    get() = this[Keys.DYE_COLOR].unwrap()
    set(value) { value?.let { this[Keys.DYE_COLOR] = it } ?: remove(Keys.DYE_COLOR) }

inline var Blaze.isAflame: Boolean
    get() = this[Keys.IS_AFLAME].get()
    set(value) { this[Keys.IS_AFLAME] = value }

inline var CompositeValueStore<*, *>.isAflame: Boolean?
    get() = this[Keys.IS_AFLAME].unwrap()
    set(value) { value?.let { this[Keys.IS_AFLAME] = it } ?: remove(Keys.IS_AFLAME) }

inline var CommandBlockSource.doesTrackOutput: Boolean
    get() = this[Keys.TRACKS_OUTPUT].get()
    set(value) { this[Keys.TRACKS_OUTPUT] = value }

inline var CompositeValueStore<*, *>.doesTrackOutput: Boolean?
    get() = this[Keys.TRACKS_OUTPUT].unwrap()
    set(value) { value?.let { this[Keys.TRACKS_OUTPUT] = it } ?: remove(Keys.TRACKS_OUTPUT) }

inline var CommandBlockSource.lastOutput: Text?
    get() = this[Keys.LAST_COMMAND_OUTPUT].get().unwrap()
    set(value) { this[Keys.LAST_COMMAND_OUTPUT] = value.optional() }

inline var CompositeValueStore<*, *>.lastOutput: Text?
    get() = this[Keys.LAST_COMMAND_OUTPUT].unwrap().unwrap()
    set(value) { this[Keys.LAST_COMMAND_OUTPUT] = value.optional() }

inline var CommandBlockSource.storedCommand: String
    get() = this[Keys.COMMAND].get()
    set(value) { this[Keys.COMMAND] = value }

inline var CompositeValueStore<*, *>.storedCommand: String?
    get() = this[Keys.COMMAND].unwrap()
    set(value) { value?.let { this[Keys.COMMAND] = it } ?: remove(Keys.COMMAND) }

inline var CommandBlockSource.successCount: Int
    get() = this[Keys.SUCCESS_COUNT].get()
    set(value) { this[Keys.SUCCESS_COUNT] = value }

inline var CompositeValueStore<*, *>.successCount: Int?
    get() = this[Keys.SUCCESS_COUNT].unwrap()
    set(value) { value?.let { this[Keys.SUCCESS_COUNT] = it } ?: remove(Keys.SUCCESS_COUNT) }

inline var Comparator.comparatorType: ComparatorType
    get() = this[Keys.COMPARATOR_TYPE].get()
    set(value) { this[Keys.COMPARATOR_TYPE] = value }

inline var CompositeValueStore<*, *>.comparatorType: ComparatorType?
    get() = this[Keys.COMPARATOR_TYPE].unwrap()
    set(value) { value?.let { this[Keys.COMPARATOR_TYPE] = it } ?: remove(Keys.COMPARATOR_TYPE) }

inline var Creeper.isCharged: Boolean
    get() = this[Keys.CREEPER_CHARGED].get()
    set(value) { this[Keys.CREEPER_CHARGED] = value }

inline var CompositeValueStore<*, *>.isChargedCreeper: Boolean?
    get() = this[Keys.CREEPER_CHARGED].unwrap()
    set(value) { value?.let { this[Keys.CREEPER_CHARGED] = it } ?: remove(Keys.CREEPER_CHARGED) }

inline var DamagingProjectile.damage: Double
    get() = this[Keys.ATTACK_DAMAGE].get()
    set(value) { this[Keys.ATTACK_DAMAGE] = value }

inline var CompositeValueStore<*, *>.damage: Double?
    get() = this[Keys.ATTACK_DAMAGE].unwrap()
    set(value) { value?.let { this[Keys.ATTACK_DAMAGE] = it } ?: remove(Keys.ATTACK_DAMAGE) }

inline var DamagingProjectile.damageForEntity: Map<EntityType, Double>
    get() = this[Keys.DAMAGE_ENTITY_MAP].get()
    set(value) { this[Keys.DAMAGE_ENTITY_MAP] = value }

inline var CompositeValueStore<*, *>.damageForEntity: Map<EntityType, Double>?
    get() = this[Keys.DAMAGE_ENTITY_MAP].unwrap()
    set(value) { value?.let { this[Keys.DAMAGE_ENTITY_MAP] = it } ?: remove(Keys.DAMAGE_ENTITY_MAP) }

inline var Endermite.expireTicks: Int
    get() = this[Keys.EXPIRATION_TICKS].get()
    set(value) { this[Keys.EXPIRATION_TICKS] = value }

inline var CompositeValueStore<*, *>.expireTicks: Int?
    get() = this[Keys.EXPIRATION_TICKS].unwrap()
    set(value) { value?.let { this[Keys.EXPIRATION_TICKS] = it } ?: remove(Keys.EXPIRATION_TICKS) }

inline var EndGateway.age: Long
    get() = this[Keys.END_GATEWAY_AGE].get()
    set(value) { this[Keys.END_GATEWAY_AGE] = value }

inline var CompositeValueStore<*, *>.gatewayAge: Long?
    get() = this[Keys.END_GATEWAY_AGE].unwrap()
    set(value) { value?.let { this[Keys.END_GATEWAY_AGE] = it } ?: remove(Keys.END_GATEWAY_AGE) }

inline var EndGateway.isExactTeleport: Boolean
    get() = this[Keys.EXACT_TELEPORT].get()
    set(value) { this[Keys.EXACT_TELEPORT] = value }

inline var CompositeValueStore<*, *>.isExactTeleport: Boolean?
    get() = this[Keys.EXACT_TELEPORT].unwrap()
    set(value) { value?.let { this[Keys.EXACT_TELEPORT] = it } ?: remove(Keys.EXACT_TELEPORT) }

inline var EndGateway.exitPosition: Vector3i
    get() = this[Keys.EXIT_POSITION].get()
    set(value) { this[Keys.EXIT_POSITION] = value }

inline var CompositeValueStore<*, *>.exitPosition: Vector3i?
    get() = this[Keys.EXIT_POSITION].unwrap()
    set(value) { value?.let { this[Keys.EXIT_POSITION] = it } ?: remove(Keys.EXIT_POSITION) }

inline var EndGateway.teleportCooldown: Int
    get() = this[Keys.END_GATEWAY_TELEPORT_COOLDOWN].get()
    set(value) { this[Keys.END_GATEWAY_TELEPORT_COOLDOWN] = value }

inline var CompositeValueStore<*, *>.teleportCooldown: Int?
    get() = this[Keys.END_GATEWAY_TELEPORT_COOLDOWN].unwrap()
    set(value) { value?.let { this[Keys.END_GATEWAY_TELEPORT_COOLDOWN] = it } ?: remove(Keys.END_GATEWAY_TELEPORT_COOLDOWN) }

inline var ExperienceOrb.experience: Int
    get() = this[Keys.CONTAINED_EXPERIENCE].get()
    set(value) { this[Keys.CONTAINED_EXPERIENCE] = value }

inline var CompositeValueStore<*, *>.containedExperience: Int?
    get() = this[Keys.CONTAINED_EXPERIENCE].unwrap()
    set(value) { value?.let { this[Keys.CONTAINED_EXPERIENCE] = it } ?: remove(Keys.CONTAINED_EXPERIENCE) }

inline var Explosive.explosionRadius: Int?
    get() = this[Keys.EXPLOSION_RADIUS].get().unwrap()
    set(value) { this[Keys.EXPLOSION_RADIUS] = value.optional() }

inline var CompositeValueStore<*, *>.explosionRadius: Int?
    get() = this[Keys.EXPLOSION_RADIUS].unwrap().unwrap()
    set(value) { this[Keys.EXPLOSION_RADIUS] = value.optional() }

inline var EyeOfEnder.target: Vector3d
    get() = this[Keys.TARGETED_LOCATION].get()
    set(value) { this[Keys.TARGETED_LOCATION] = value }

inline var CompositeValueStore<*, *>.targetedLocation: Vector3d?
    get() = this[Keys.TARGETED_LOCATION].unwrap()
    set(value) { value?.let { this[Keys.TARGETED_LOCATION] = it } ?: remove(Keys.TARGETED_LOCATION) }

inline var FallingBlock.blockState: BlockState
    get() = this[Keys.FALLING_BLOCK_STATE].get()
    set(value) { this[Keys.FALLING_BLOCK_STATE] = value }

inline var CompositeValueStore<*, *>.fallingBlockState: BlockState?
    get() = this[Keys.FALLING_BLOCK_STATE].unwrap()
    set(value) { value?.let { this[Keys.FALLING_BLOCK_STATE] = it } ?: remove(Keys.FALLING_BLOCK_STATE) }

inline var FallingBlock.canDropAsItem: Boolean
    get() = this[Keys.CAN_DROP_AS_ITEM].get()
    set(value) { this[Keys.CAN_DROP_AS_ITEM] = value }

inline var CompositeValueStore<*, *>.canDropAsItem: Boolean?
    get() = this[Keys.CAN_DROP_AS_ITEM].unwrap()
    set(value) { value?.let { this[Keys.CAN_DROP_AS_ITEM] = it } ?: remove(Keys.CAN_DROP_AS_ITEM) }

inline var FallingBlock.canHurtEntities: Boolean
    get() = this[Keys.FALLING_BLOCK_CAN_HURT_ENTITIES].get()
    set(value) { this[Keys.FALLING_BLOCK_CAN_HURT_ENTITIES] = value }

inline var CompositeValueStore<*, *>.fallingBlockCanHurtEntities: Boolean?
    get() = this[Keys.FALLING_BLOCK_CAN_HURT_ENTITIES].unwrap()
    set(value) { value?.let { this[Keys.FALLING_BLOCK_CAN_HURT_ENTITIES] = it } ?: remove(Keys.FALLING_BLOCK_CAN_HURT_ENTITIES) }

inline var FallingBlock.canPlaceAsBlock: Boolean
    get() = this[Keys.CAN_PLACE_AS_BLOCK].get()
    set(value) { this[Keys.CAN_PLACE_AS_BLOCK] = value }

inline var CompositeValueStore<*, *>.canPlaceAsBlock: Boolean?
    get() = this[Keys.CAN_PLACE_AS_BLOCK].unwrap()
    set(value) { value?.let { this[Keys.CAN_PLACE_AS_BLOCK] = it } ?: remove(Keys.CAN_PLACE_AS_BLOCK) }

inline var FallingBlock.fallDamagePerBlock: Double
    get() = this[Keys.FALL_DAMAGE_PER_BLOCK].get()
    set(value) { this[Keys.FALL_DAMAGE_PER_BLOCK] = value }

inline var CompositeValueStore<*, *>.fallDamagePerBlock: Double?
    get() = this[Keys.FALL_DAMAGE_PER_BLOCK].unwrap()
    set(value) { value?.let { this[Keys.FALL_DAMAGE_PER_BLOCK] = it } ?: remove(Keys.FALL_DAMAGE_PER_BLOCK) }

inline var FallingBlock.fallTime: Int
    get() = this[Keys.FALL_TIME].get()
    set(value) { this[Keys.FALL_TIME] = value }

inline var CompositeValueStore<*, *>.fallTime: Int?
    get() = this[Keys.FALL_TIME].unwrap()
    set(value) { value?.let { this[Keys.FALL_TIME] = it } ?: remove(Keys.FALL_TIME) }

inline var FallingBlock.maxFallDamage: Double
    get() = this[Keys.MAX_FALL_DAMAGE].get()
    set(value) { this[Keys.MAX_FALL_DAMAGE] = value }

inline var CompositeValueStore<*, *>.maxFallDamage: Double?
    get() = this[Keys.MAX_FALL_DAMAGE].unwrap()
    set(value) { value?.let { this[Keys.MAX_FALL_DAMAGE] = it } ?: remove(Keys.MAX_FALL_DAMAGE) }

inline var Firework.effects: List<FireworkEffect>
    get() = this[Keys.FIREWORK_EFFECTS].get()
    set(value) { this[Keys.FIREWORK_EFFECTS] = value }

inline var Firework.flightModifier: Int
    get() = this[Keys.FIREWORK_FLIGHT_MODIFIER].get()
    set(value) { this[Keys.FIREWORK_FLIGHT_MODIFIER] = value }

inline var CompositeValueStore<*, *>.flightModifier: Int?
    get() = this[Keys.FIREWORK_FLIGHT_MODIFIER].unwrap()
    set(value) { value?.let { this[Keys.FIREWORK_FLIGHT_MODIFIER] = it } ?: remove(Keys.FIREWORK_FLIGHT_MODIFIER) }

inline var CompositeValueStore<*, *>.fireworkEffects: List<FireworkEffect>?
    get() = this[Keys.FIREWORK_EFFECTS].unwrap()
    set(value) { value?.let { this[Keys.FIREWORK_EFFECTS] = it } ?: remove(Keys.FIREWORK_EFFECTS) }

inline var FlowerPot.item: ItemStackSnapshot
    get() = this[Keys.REPRESENTED_ITEM].get()
    set(value) { this[Keys.REPRESENTED_ITEM] = value }

inline var CompositeValueStore<*, *>.representedItem: ItemStackSnapshot?
    get() = this[Keys.REPRESENTED_ITEM].unwrap()
    set(value) { value?.let { this[Keys.REPRESENTED_ITEM] = it } ?: remove(Keys.REPRESENTED_ITEM) }

inline var Furnace.maxBurnTime: Int
    get() = this[Keys.MAX_BURN_TIME].get()
    set(value) { this[Keys.MAX_BURN_TIME] = value }

inline var CompositeValueStore<*, *>.maxBurnTime: Int?
    get() = this[Keys.MAX_BURN_TIME].unwrap()
    set(value) { value?.let { this[Keys.MAX_BURN_TIME] = it } ?: remove(Keys.MAX_BURN_TIME) }

inline var Furnace.maxCookTime: Int
    get() = this[Keys.MAX_COOK_TIME].get()
    set(value) { this[Keys.MAX_COOK_TIME] = value }

inline var CompositeValueStore<*, *>.maxCookTime: Int?
    get() = this[Keys.MAX_COOK_TIME].unwrap()
    set(value) { value?.let { this[Keys.MAX_COOK_TIME] = it } ?: remove(Keys.MAX_COOK_TIME) }

inline var Furnace.passedBurnTime: Int
    get() = this[Keys.PASSED_BURN_TIME].get()
    set(value) { this[Keys.PASSED_BURN_TIME] = value }

inline var CompositeValueStore<*, *>.passedBurnTime: Int?
    get() = this[Keys.PASSED_BURN_TIME].unwrap()
    set(value) { value?.let { this[Keys.PASSED_BURN_TIME] = it } ?: remove(Keys.PASSED_BURN_TIME) }

inline var Furnace.passedCookTime: Int
    get() = this[Keys.PASSED_COOK_TIME].get()
    set(value) { this[Keys.PASSED_COOK_TIME] = value }

inline var CompositeValueStore<*, *>.passedCookTime: Int?
    get() = this[Keys.PASSED_COOK_TIME].unwrap()
    set(value) { value?.let { this[Keys.PASSED_COOK_TIME] = it } ?: remove(Keys.PASSED_COOK_TIME) }

inline var FusedExplosive.fuseDuration: Int
    get() = this[Keys.FUSE_DURATION].get()
    set(value) { this[Keys.FUSE_DURATION] = value }

inline var CompositeValueStore<*, *>.fuseDuration: Int?
    get() = this[Keys.FUSE_DURATION].unwrap()
    set(value) { value?.let { this[Keys.FUSE_DURATION] = it } ?: remove(Keys.FUSE_DURATION) }

inline var FusedExplosive.ticksRemaining: Int
    get() = this[Keys.TICKS_REMAINING].get()
    set(value) { this[Keys.TICKS_REMAINING] = value }

inline var CompositeValueStore<*, *>.fuseTicksRemaining: Int?
    get() = this[Keys.TICKS_REMAINING].unwrap()
    set(value) { value?.let { this[Keys.TICKS_REMAINING] = it } ?: remove(Keys.TICKS_REMAINING) }

inline var Hanging.direction: Direction
    get() = this[Keys.DIRECTION].get()
    set(value) { this[Keys.DIRECTION] = value }

inline var CompositeValueStore<*, *>.direction: Direction?
    get() = this[Keys.DIRECTION].unwrap()
    set(value) { value?.let { this[Keys.DIRECTION] = it } ?: remove(Keys.DIRECTION) }

inline var Hopper.cooldown: Int
    get() = this[Keys.COOLDOWN].get()
    set(value) { this[Keys.COOLDOWN] = value }

inline var CompositeValueStore<*, *>.cooldown: Int?
    get() = this[Keys.COOLDOWN].unwrap()
    set(value) { value?.let { this[Keys.COOLDOWN] = it } ?: remove(Keys.COOLDOWN) }

inline var HopperMinecart.cooldown: Int
    get() = this[Keys.COOLDOWN].get()
    set(value) { this[Keys.COOLDOWN] = value }

inline var Humanoid.exhaustion: Double
    get() = this[Keys.EXHAUSTION].get()
    set(value) { this[Keys.EXHAUSTION] = value }

inline var CompositeValueStore<*, *>.exhaustion: Double?
    get() = this[Keys.EXHAUSTION].unwrap()
    set(value) { value?.let { this[Keys.EXHAUSTION] = it } ?: remove(Keys.EXHAUSTION) }

inline var Humanoid.foodLevel: Int
    get() = this[Keys.FOOD_LEVEL].get()
    set(value) { this[Keys.FOOD_LEVEL] = value }

inline var CompositeValueStore<*, *>.foodLevel: Int?
    get() = this[Keys.FOOD_LEVEL].unwrap()
    set(value) { value?.let { this[Keys.FOOD_LEVEL] = it } ?: remove(Keys.FOOD_LEVEL) }

inline var Humanoid.saturation: Double
    get() = this[Keys.SATURATION].get()
    set(value) { this[Keys.SATURATION] = value }

inline var CompositeValueStore<*, *>.saturation: Double?
    get() = this[Keys.SATURATION].unwrap()
    set(value) { value?.let { this[Keys.SATURATION] = it } ?: remove(Keys.SATURATION) }

inline var IronGolem.isPlayerCreated: Boolean
    get() = this[Keys.PLAYER_CREATED].get()
    set(value) { this[Keys.PLAYER_CREATED] = value }

inline var CompositeValueStore<*, *>.isPlayerCreated: Boolean?
    get() = this[Keys.PLAYER_CREATED].unwrap()
    set(value) { value?.let { this[Keys.PLAYER_CREATED] = it } ?: remove(Keys.PLAYER_CREATED) }

inline var Item.item: ItemStackSnapshot
    get() = this[Keys.REPRESENTED_ITEM].get()
    set(value) { this[Keys.REPRESENTED_ITEM] = value }

inline var ItemFrame.direction: Direction
    get() = this[Keys.DIRECTION].get()
    set(value) { this[Keys.DIRECTION] = value }

inline var ItemFrame.item: ItemStackSnapshot
    get() = this[Keys.REPRESENTED_ITEM].get()
    set(value) { this[Keys.REPRESENTED_ITEM] = value }

inline var Jukebox.record: ItemStackSnapshot
    get() = this[Keys.REPRESENTED_ITEM].get()
    set(value) { this[Keys.REPRESENTED_ITEM] = value }

inline var Living.health: Double
    get() = this[Keys.HEALTH].get()
    set(value) { this[Keys.HEALTH] = value }

inline var CompositeValueStore<*, *>.health: Double?
    get() = this[Keys.HEALTH].unwrap()
    set(value) { value?.let { this[Keys.HEALTH] = it } ?: remove(Keys.HEALTH) }

inline var Living.lastAttacker: EntitySnapshot?
    get() = this[Keys.LAST_ATTACKER].get().unwrap()
    set(value) { this[Keys.LAST_ATTACKER] = value.optional() }

inline var CompositeValueStore<*, *>.lastAttacker: EntitySnapshot?
    get() = this[Keys.LAST_ATTACKER].unwrap().unwrap()
    set(value) { this[Keys.LAST_ATTACKER] = value.optional() }

inline var Living.lastDamage: Double?
    get() = this[Keys.LAST_DAMAGE].get().unwrap()
    set(value) { this[Keys.LAST_DAMAGE] = value.optional() }

inline var CompositeValueStore<*, *>.lastDamage: Double?
    get() = this[Keys.LAST_DAMAGE].unwrap().unwrap()
    set(value) { this[Keys.LAST_DAMAGE] = value.optional() }

inline var Living.maxHealth: Double
    get() = this[Keys.MAX_HEALTH].get()
    set(value) { this[Keys.MAX_HEALTH] = value }

inline var CompositeValueStore<*, *>.maxHealth: Double?
    get() = this[Keys.MAX_HEALTH].unwrap()
    set(value) { value?.let { this[Keys.MAX_HEALTH] = it } ?: remove(Keys.MAX_HEALTH) }

inline var Llama.variant: LlamaVariant
    get() = this[Keys.LLAMA_VARIANT].get()
    set(value) { this[Keys.LLAMA_VARIANT] = value }

inline var CompositeValueStore<*, *>.llamaVariant: LlamaVariant?
    get() = this[Keys.LLAMA_VARIANT].unwrap()
    set(value) { value?.let { this[Keys.LLAMA_VARIANT] = it } ?: remove(Keys.LLAMA_VARIANT) }

inline var Llama.strength: Int
    get() = this[Keys.LLAMA_STRENGTH].get()
    set(value) { this[Keys.LLAMA_STRENGTH] = value }

inline var CompositeValueStore<*, *>.llamaStrength: Int?
    get() = this[Keys.LLAMA_STRENGTH].unwrap()
    set(value) { value?.let { this[Keys.LLAMA_STRENGTH] = it } ?: remove(Keys.LLAMA_STRENGTH) }

inline var Merchant.tradeOffers: List<TradeOffer>
    get() = this[Keys.TRADE_OFFERS].get()
    set(value) { this[Keys.TRADE_OFFERS] = value }

inline var CompositeValueStore<*, *>.tradeOffers: List<TradeOffer>?
    get() = this[Keys.TRADE_OFFERS].unwrap()
    set(value) { value?.let { this[Keys.TRADE_OFFERS] = it } ?: remove(Keys.TRADE_OFFERS) }

inline var MobSpawner.maxNearbyEntities: Short
    get() = this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES].get()
    set(value) { this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES] = value }

inline var CompositeValueStore<*, *>.maxNearbyEntities: Short?
    get() = this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES] = it } ?: remove(Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES) }

inline var MobSpawner.maxSpawnDelay: Short
    get() = this[Keys.SPAWNER_MAXIMUM_DELAY].get()
    set(value) { this[Keys.SPAWNER_MAXIMUM_DELAY] = value }

inline var CompositeValueStore<*, *>.maxSpawnDelay: Short?
    get() = this[Keys.SPAWNER_MAXIMUM_DELAY].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_MAXIMUM_DELAY] = it } ?: remove(Keys.SPAWNER_MAXIMUM_DELAY) }

inline var MobSpawner.minSpawnDelay: Short
    get() = this[Keys.SPAWNER_MINIMUM_DELAY].get()
    set(value) { this[Keys.SPAWNER_MINIMUM_DELAY] = value }

inline var CompositeValueStore<*, *>.minSpawnDelay: Short?
    get() = this[Keys.SPAWNER_MINIMUM_DELAY].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_MINIMUM_DELAY] = it } ?: remove(Keys.SPAWNER_MINIMUM_DELAY) }

inline var MobSpawner.nextEntityToSpawn: WeightedSerializableObject<EntityArchetype>
    get() = this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN].get()
    set(value) { this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN] = value }

inline var CompositeValueStore<*, *>.nextEntityToSpawn: WeightedSerializableObject<EntityArchetype>?
    get() = this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN] = it } ?: remove(Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN) }

inline var MobSpawner.possibleEntitiesToSpawn: WeightedTable<EntityArchetype>
    get() = this[Keys.SPAWNER_ENTITIES].get()
    set(value) { this[Keys.SPAWNER_ENTITIES] = value }

inline var CompositeValueStore<*, *>.possibleEntitiesToSpawn: WeightedTable<EntityArchetype>?
    get() = this[Keys.SPAWNER_ENTITIES].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_ENTITIES] = it } ?: remove(Keys.SPAWNER_ENTITIES) }

inline var MobSpawner.remainingDelay: Short
    get() = this[Keys.SPAWNER_REMAINING_DELAY].get()
    set(value) { this[Keys.SPAWNER_REMAINING_DELAY] = value }

inline var CompositeValueStore<*, *>.spawnerRemainingDelay: Short?
    get() = this[Keys.SPAWNER_REMAINING_DELAY].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_REMAINING_DELAY] = it } ?: remove(Keys.SPAWNER_REMAINING_DELAY) }

inline var MobSpawner.requiredPlayerRange: Short
    get() = this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE].get()
    set(value) { this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE] = value }

inline var CompositeValueStore<*, *>.spawnerRequiredPlayerRange: Short?
    get() = this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE] = it } ?: remove(Keys.SPAWNER_REQUIRED_PLAYER_RANGE) }

inline var MobSpawner.spawnCount: Short
    get() = this[Keys.SPAWNER_SPAWN_COUNT].get()
    set(value) { this[Keys.SPAWNER_SPAWN_COUNT] = value }

inline var CompositeValueStore<*, *>.spawnCount: Short?
    get() = this[Keys.SPAWNER_SPAWN_COUNT].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_SPAWN_COUNT] = it } ?: remove(Keys.SPAWNER_SPAWN_COUNT) }

inline var MobSpawner.spawnRange: Short
    get() = this[Keys.SPAWNER_SPAWN_RANGE].get()
    set(value) { this[Keys.SPAWNER_SPAWN_RANGE] = value }

inline var CompositeValueStore<*, *>.spawnRange: Short?
    get() = this[Keys.SPAWNER_SPAWN_RANGE].unwrap()
    set(value) { value?.let { this[Keys.SPAWNER_SPAWN_RANGE] = it } ?: remove(Keys.SPAWNER_SPAWN_RANGE) }

inline var MobSpawnerMinecart.maxNearbyEntities: Short
    get() = this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES].get()
    set(value) { this[Keys.SPAWNER_MAXIMUM_NEARBY_ENTITIES] = value }

inline var MobSpawnerMinecart.maxSpawnDelay: Short
    get() = this[Keys.SPAWNER_MAXIMUM_DELAY].get()
    set(value) { this[Keys.SPAWNER_MAXIMUM_DELAY] = value }

inline var MobSpawnerMinecart.minSpawnDelay: Short
    get() = this[Keys.SPAWNER_MINIMUM_DELAY].get()
    set(value) { this[Keys.SPAWNER_MINIMUM_DELAY] = value }

inline var MobSpawnerMinecart.nextEntityToSpawn: WeightedSerializableObject<EntityArchetype>
    get() = this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN].get()
    set(value) { this[Keys.SPAWNER_NEXT_ENTITY_TO_SPAWN] = value }

inline var MobSpawnerMinecart.possibleEntitiesToSpawn: WeightedTable<EntityArchetype>
    get() = this[Keys.SPAWNER_ENTITIES].get()
    set(value) { this[Keys.SPAWNER_ENTITIES] = value }

inline var MobSpawnerMinecart.remainingDelay: Short
    get() = this[Keys.SPAWNER_REMAINING_DELAY].get()
    set(value) { this[Keys.SPAWNER_REMAINING_DELAY] = value }

inline var MobSpawnerMinecart.requiredPlayerRange: Short
    get() = this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE].get()
    set(value) { this[Keys.SPAWNER_REQUIRED_PLAYER_RANGE] = value }

inline var MobSpawnerMinecart.spawnCount: Short
    get() = this[Keys.SPAWNER_SPAWN_COUNT].get()
    set(value) { this[Keys.SPAWNER_SPAWN_COUNT] = value }

inline var MobSpawnerMinecart.spawnRange: Short
    get() = this[Keys.SPAWNER_SPAWN_RANGE].get()
    set(value) { this[Keys.SPAWNER_SPAWN_RANGE] = value }

inline var Note.notePitch: NotePitch
    get() = this[Keys.NOTE_PITCH].get()
    set(value) { this[Keys.NOTE_PITCH] = value }

inline var CompositeValueStore<*, *>.notePitch: NotePitch?
    get() = this[Keys.NOTE_PITCH].unwrap()
    set(value) { value?.let { this[Keys.NOTE_PITCH] = it } ?: remove(Keys.NOTE_PITCH) }

inline var Ocelot.ocelotType: OcelotType
    get() = this[Keys.OCELOT_TYPE].get()
    set(value) { this[Keys.OCELOT_TYPE] = value }

inline var CompositeValueStore<*, *>.ocelotType: OcelotType?
    get() = this[Keys.OCELOT_TYPE].unwrap()
    set(value) { value?.let { this[Keys.OCELOT_TYPE] = it } ?: remove(Keys.OCELOT_TYPE) }

inline var Painting.art: Art
    get() = this[Keys.ART].get()
    set(value) { this[Keys.ART] = value }

inline var CompositeValueStore<*, *>.art: Art?
    get() = this[Keys.ART].unwrap()
    set(value) { value?.let { this[Keys.ART] = it } ?: remove(Keys.ART) }

inline var Parrot.variant: ParrotVariant
    get() = this[Keys.PARROT_VARIANT].get()
    set(value) { this[Keys.PARROT_VARIANT] = value }

inline var CompositeValueStore<*, *>.parrotVariant: ParrotVariant?
    get() = this[Keys.PARROT_VARIANT].unwrap()
    set(value) { value?.let { this[Keys.PARROT_VARIANT] = it } ?: remove(Keys.PARROT_VARIANT) }

inline var Pig.isSaddled: Boolean
    get() = this[Keys.PIG_SADDLE].get()
    set(value) { this[Keys.PIG_SADDLE] = value }

inline var CompositeValueStore<*, *>.pigIsSaddled: Boolean?
    get() = this[Keys.PIG_SADDLE].unwrap()
    set(value) { value?.let { this[Keys.PIG_SADDLE] = it } ?: remove(Keys.PIG_SADDLE) }

inline var Player.firstPlayed: Instant
    get() = this[Keys.FIRST_DATE_PLAYED].get()
    set(value) { this[Keys.FIRST_DATE_PLAYED] = value }

inline var CompositeValueStore<*, *>.firstPlayed: Instant?
    get() = this[Keys.FIRST_DATE_PLAYED].unwrap()
    set(value) { value?.let { this[Keys.FIRST_DATE_PLAYED] = it } ?: remove(Keys.FIRST_DATE_PLAYED) }

inline var Player.gameMode: GameMode
    get() = this[Keys.GAME_MODE].get()
    set(value) { this[Keys.GAME_MODE] = value }

inline var CompositeValueStore<*, *>.gameMode: GameMode?
    get() = this[Keys.GAME_MODE].unwrap()
    set(value) { value?.let { this[Keys.GAME_MODE] = it } ?: remove(Keys.GAME_MODE) }

inline var Player.lastPlayed: Instant
    get() = this[Keys.LAST_DATE_PLAYED].get()
    set(value) { this[Keys.LAST_DATE_PLAYED] = value }

inline var CompositeValueStore<*, *>.lastPlayed: Instant?
    get() = this[Keys.LAST_DATE_PLAYED].unwrap()
    set(value) { value?.let { this[Keys.LAST_DATE_PLAYED] = it } ?: remove(Keys.LAST_DATE_PLAYED) }

inline var Player.displayName: Text
    get() = this[Keys.DISPLAY_NAME].get()
    set(value) { this[Keys.DISPLAY_NAME] = value }

inline var CompositeValueStore<*, *>.displayName: Text?
    get() = this[Keys.DISPLAY_NAME].unwrap()
    set(value) { value?.let { this[Keys.DISPLAY_NAME] = it } ?: remove(Keys.DISPLAY_NAME) }

inline var Rabbit.rabbitType: RabbitType
    get() = this[Keys.RABBIT_TYPE].get()
    set(value) { this[Keys.RABBIT_TYPE] = value }

inline var CompositeValueStore<*, *>.rabbitType: RabbitType?
    get() = this[Keys.RABBIT_TYPE].unwrap()
    set(value) { value?.let { this[Keys.RABBIT_TYPE] = it } ?: remove(Keys.RABBIT_TYPE) }

inline var RideableHorse.color: HorseColor
    get() = this[Keys.HORSE_COLOR].get()
    set(value) { this[Keys.HORSE_COLOR] = value }

inline var CompositeValueStore<*, *>.horseColor: HorseColor?
    get() = this[Keys.HORSE_COLOR].unwrap()
    set(value) { value?.let { this[Keys.HORSE_COLOR] = it } ?: remove(Keys.HORSE_COLOR) }

inline var RideableHorse.style: HorseStyle
    get() = this[Keys.HORSE_STYLE].get()
    set(value) { this[Keys.HORSE_STYLE] = value }

inline var CompositeValueStore<*, *>.horseStyle: HorseStyle?
    get() = this[Keys.HORSE_STYLE].unwrap()
    set(value) { value?.let { this[Keys.HORSE_STYLE] = it } ?: remove(Keys.HORSE_STYLE) }

inline var Sheep.color: DyeColor
    get() = this[Keys.DYE_COLOR].get()
    set(value) { this[Keys.DYE_COLOR] = value }

inline var Sign.lines: List<Text>
    get() = this[Keys.SIGN_LINES].get()
    set(value) { this[Keys.SIGN_LINES] = value }

inline var CompositeValueStore<*, *>.signLines: List<Text>?
    get() = this[Keys.SIGN_LINES].unwrap()
    set(value) { value?.let { this[Keys.SIGN_LINES] = it } ?: remove(Keys.SIGN_LINES) }

inline var Skull.skullType: SkullType
    get() = this[Keys.SKULL_TYPE].get()
    set(value) { this[Keys.SKULL_TYPE] = value }

inline var CompositeValueStore<*, *>.skullType: SkullType?
    get() = this[Keys.SKULL_TYPE].unwrap()
    set(value) { value?.let { this[Keys.SKULL_TYPE] = it } ?: remove(Keys.SKULL_TYPE) }

inline var Slime.size: Int
    get() = this[Keys.SLIME_SIZE].get()
    set(value) { this[Keys.SLIME_SIZE] = value }

inline var CompositeValueStore<*, *>.slimeSize: Int?
    get() = this[Keys.SLIME_SIZE].unwrap()
    set(value) { value?.let { this[Keys.SLIME_SIZE] = it } ?: remove(Keys.SLIME_SIZE) }

inline var Structure.author: String
    get() = this[Keys.STRUCTURE_AUTHOR].get()
    set(value) { this[Keys.STRUCTURE_AUTHOR] = value }

inline var CompositeValueStore<*, *>.structureAuthor: String?
    get() = this[Keys.STRUCTURE_AUTHOR].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_AUTHOR] = it } ?: remove(Keys.STRUCTURE_AUTHOR) }

inline var Structure.doesIgnoreEntities: Boolean
    get() = this[Keys.STRUCTURE_IGNORE_ENTITIES].get()
    set(value) { this[Keys.STRUCTURE_IGNORE_ENTITIES] = value }

inline var CompositeValueStore<*, *>.structureDoesIgnoreEntities: Boolean?
    get() = this[Keys.STRUCTURE_IGNORE_ENTITIES].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_IGNORE_ENTITIES] = it } ?: remove(Keys.STRUCTURE_IGNORE_ENTITIES) }

inline var Structure.integrity: Float
    get() = this[Keys.STRUCTURE_INTEGRITY].get()
    set(value) { this[Keys.STRUCTURE_INTEGRITY] = value }

inline var CompositeValueStore<*, *>.structureIntegrity: Float?
    get() = this[Keys.STRUCTURE_INTEGRITY].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_INTEGRITY] = it } ?: remove(Keys.STRUCTURE_INTEGRITY) }

inline var Structure.mode: StructureMode
    get() = this[Keys.STRUCTURE_MODE].get()
    set(value) { this[Keys.STRUCTURE_MODE] = value }

inline var CompositeValueStore<*, *>.structureMode: StructureMode?
    get() = this[Keys.STRUCTURE_MODE].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_MODE] = it } ?: remove(Keys.STRUCTURE_MODE) }

inline var Structure.position: Vector3i
    get() = this[Keys.STRUCTURE_POSITION].get()
    set(value) { this[Keys.STRUCTURE_POSITION] = value }

inline var CompositeValueStore<*, *>.structurePosition: Vector3i?
    get() = this[Keys.STRUCTURE_POSITION].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_POSITION] = it } ?: remove(Keys.STRUCTURE_POSITION) }

inline var Structure.powered: Boolean
    get() = this[Keys.STRUCTURE_POWERED].get()
    set(value) { this[Keys.STRUCTURE_POWERED] = value }

inline var CompositeValueStore<*, *>.structurePowered: Boolean?
    get() = this[Keys.STRUCTURE_POWERED].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_POWERED] = it } ?: remove(Keys.STRUCTURE_POWERED) }

inline var Structure.seed: Long
    get() = this[Keys.STRUCTURE_SEED].get()
    set(value) { this[Keys.STRUCTURE_SEED] = value }

inline var CompositeValueStore<*, *>.structureSeed: Long?
    get() = this[Keys.STRUCTURE_SEED].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_SEED] = it } ?: remove(Keys.STRUCTURE_SEED) }

inline var Structure.shouldShowAir: Boolean
    get() = this[Keys.STRUCTURE_SHOW_AIR].get()
    set(value) { this[Keys.STRUCTURE_SHOW_AIR] = value }

inline var CompositeValueStore<*, *>.structureShouldShowAir: Boolean?
    get() = this[Keys.STRUCTURE_SHOW_AIR].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_SHOW_AIR] = it } ?: remove(Keys.STRUCTURE_SHOW_AIR) }

inline var Structure.shouldShowBoundingBox: Boolean
    get() = this[Keys.STRUCTURE_SHOW_BOUNDING_BOX].get()
    set(value) { this[Keys.STRUCTURE_SHOW_BOUNDING_BOX] = value }

inline var CompositeValueStore<*, *>.structureShouldShowBoundingBox: Boolean?
    get() = this[Keys.STRUCTURE_SHOW_BOUNDING_BOX].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_SHOW_BOUNDING_BOX] = it } ?: remove(Keys.STRUCTURE_SHOW_BOUNDING_BOX) }

inline var Structure.size: Vector3i
    get() = this[Keys.STRUCTURE_SIZE].get()
    set(value) { this[Keys.STRUCTURE_SIZE] = value }

inline var CompositeValueStore<*, *>.structureSize: Vector3i?
    get() = this[Keys.STRUCTURE_SIZE].unwrap()
    set(value) { value?.let { this[Keys.STRUCTURE_SIZE] = it } ?: remove(Keys.STRUCTURE_SIZE) }

inline var ThrownPotion.item: ItemStackSnapshot
    get() = this[Keys.REPRESENTED_ITEM].get()
    set(value) { this[Keys.REPRESENTED_ITEM] = value }

inline var TippedArrow.effects: List<PotionEffect>
    get() = this[Keys.POTION_EFFECTS].get()
    set(value) { this[Keys.POTION_EFFECTS] = value }

inline var CompositeValueStore<*, *>.potionEffects: List<PotionEffect>?
    get() = this[Keys.POTION_EFFECTS].unwrap()
    set(value) { value?.let { this[Keys.POTION_EFFECTS] = it } ?: remove(Keys.POTION_EFFECTS) }

inline var User.statistics: Map<Statistic, Long>
    get() = this[Keys.STATISTICS].get()
    set(value) { this[Keys.STATISTICS] = value }

inline var CompositeValueStore<*, *>.statistics: Map<Statistic, Long>?
    get() = this[Keys.STATISTICS].unwrap()
    set(value) { value?.let { this[Keys.STATISTICS] = it } ?: remove(Keys.STATISTICS) }

inline var Villager.career: Career
    get() = this[Keys.CAREER].get()
    set(value) { this[Keys.CAREER] = value }

inline var CompositeValueStore<*, *>.career: Career?
    get() = this[Keys.CAREER].unwrap()
    set(value) { value?.let { this[Keys.CAREER] = it } ?: remove(Keys.CAREER) }

inline var Vindicator.isJohnny: Boolean
    get() = this[Keys.IS_JOHNNY].get()
    set(value) { this[Keys.IS_JOHNNY] = value }

inline var CompositeValueStore<*, *>.isJohnny: Boolean?
    get() = this[Keys.IS_JOHNNY].unwrap()
    set(value) { value?.let { this[Keys.IS_JOHNNY] = it } ?: remove(Keys.IS_JOHNNY) }

inline var WeatherEffect.expireTicks: Int
    get() = this[Keys.EXPIRATION_TICKS].get()
    set(value) { this[Keys.EXPIRATION_TICKS] = value }

inline var Wolf.isWet: Boolean
    get() = this[Keys.IS_WET].get()
    set(value) { this[Keys.IS_WET] = value }

inline var CompositeValueStore<*, *>.isWet: Boolean?
    get() = this[Keys.IS_WET].unwrap()
    set(value) { value?.let { this[Keys.IS_WET] = it } ?: remove(Keys.IS_WET) }

inline var Wolf.color: DyeColor
    get() = this[Keys.DYE_COLOR].get()
    set(value) { this[Keys.DYE_COLOR] = value }

inline var Wolf.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var CompositeValueStore<*, *>.tamedOwner: UUID?
    get() = this[Keys.TAMED_OWNER].unwrap().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var Ocelot.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var ZombiePigman.angerLevel: Int
    get() = this[Keys.ANGER].get()
    set(value) { this[Keys.ANGER] = value }

inline var CompositeValueStore<*, *>.pigmanAngerLevel: Int?
    get() = this[Keys.ANGER].unwrap()
    set(value) { value?.let { this[Keys.ANGER] = it } ?: remove(Keys.ANGER) }

inline var CompositeValueStore<*, *>.color: Color?
    get() = this[Keys.COLOR].unwrap()
    set(value) { value?.let { this[Keys.COLOR] = it } ?: remove(Keys.COLOR) }

inline var CompositeValueStore<*, *>.representedPlayer: GameProfile?
    get() = this[Keys.REPRESENTED_PLAYER].unwrap()
    set(value) { value?.let { this[Keys.REPRESENTED_PLAYER] = it } ?: remove(Keys.REPRESENTED_PLAYER) }

inline var CompositeValueStore<*, *>.isAttached: Boolean?
    get() = this[Keys.ATTACHED].unwrap()
    set(value) { value?.let { this[Keys.ATTACHED] = it } ?: remove(Keys.ATTACHED) }

inline var CompositeValueStore<*, *>.connectedDirections: Set<Direction>?
    get() = this[Keys.CONNECTED_DIRECTIONS].unwrap()
    set(value) { value?.let { this[Keys.CONNECTED_DIRECTIONS] = it } ?: remove(Keys.CONNECTED_DIRECTIONS) }

inline var CompositeValueStore<*, *>.connectedNorth: Boolean?
    get() = this[Keys.CONNECTED_NORTH].unwrap()
    set(value) { value?.let { this[Keys.CONNECTED_NORTH] = it } ?: remove(Keys.CONNECTED_NORTH) }

inline var CompositeValueStore<*, *>.connectedEast: Boolean?
    get() = this[Keys.CONNECTED_EAST].unwrap()
    set(value) { value?.let { this[Keys.CONNECTED_EAST] = it } ?: remove(Keys.CONNECTED_EAST) }

inline var CompositeValueStore<*, *>.connectedSouth: Boolean?
    get() = this[Keys.CONNECTED_SOUTH].unwrap()
    set(value) { value?.let { this[Keys.CONNECTED_SOUTH] = it } ?: remove(Keys.CONNECTED_SOUTH) }

inline var CompositeValueStore<*, *>.connectedWest: Boolean?
    get() = this[Keys.CONNECTED_WEST].unwrap()
    set(value) { value?.let { this[Keys.CONNECTED_WEST] = it } ?: remove(Keys.CONNECTED_WEST) }

inline var CompositeValueStore<*, *>.isDecayable: Boolean?
    get() = this[Keys.DECAYABLE].unwrap()
    set(value) { value?.let { this[Keys.DECAYABLE] = it } ?: remove(Keys.DECAYABLE) }

inline var CompositeValueStore<*, *>.delay: Int?
    get() = this[Keys.DELAY].unwrap()
    set(value) { value?.let { this[Keys.DELAY] = it } ?: remove(Keys.DELAY) }

inline var CompositeValueStore<*, *>.isDisarmed: Boolean?
    get() = this[Keys.DISARMED].unwrap()
    set(value) { value?.let { this[Keys.DISARMED] = it } ?: remove(Keys.DISARMED) }

inline var CompositeValueStore<*, *>.willDrop: Boolean?
    get() = this[Keys.SHOULD_DROP].unwrap()
    set(value) { value?.let { this[Keys.SHOULD_DROP] = it } ?: remove(Keys.SHOULD_DROP) }

inline var CompositeValueStore<*, *>.isExtended: Boolean?
    get() = this[Keys.EXTENDED].unwrap()
    set(value) { value?.let { this[Keys.EXTENDED] = it } ?: remove(Keys.EXTENDED) }

inline var CompositeValueStore<*, *>.isFilled: Boolean?
    get() = this[Keys.FILLED].unwrap()
    set(value) { value?.let { this[Keys.FILLED] = it } ?: remove(Keys.FILLED) }

inline var CompositeValueStore<*, *>.fluidLevel: Int?
    get() = this[Keys.FLUID_LEVEL].unwrap()
    set(value) { value?.let { this[Keys.FLUID_LEVEL] = it } ?: remove(Keys.FLUID_LEVEL) }

inline var CompositeValueStore<*, *>.growthStage: Int?
    get() = this[Keys.GROWTH_STAGE].unwrap()
    set(value) { value?.let { this[Keys.GROWTH_STAGE] = it } ?: remove(Keys.GROWTH_STAGE) }

inline var CompositeValueStore<*, *>.isInWall: Boolean?
    get() = this[Keys.IN_WALL].unwrap()
    set(value) { value?.let { this[Keys.IN_WALL] = it } ?: remove(Keys.IN_WALL) }

inline var CompositeValueStore<*, *>.layer: Int?
    get() = this[Keys.LAYER].unwrap()
    set(value) { value?.let { this[Keys.LAYER] = it } ?: remove(Keys.LAYER) }

inline var CompositeValueStore<*, *>.moisture: Int?
    get() = this[Keys.MOISTURE].unwrap()
    set(value) { value?.let { this[Keys.MOISTURE] = it } ?: remove(Keys.MOISTURE) }

inline var Bed.isOccupied: Boolean
    get() = this[Keys.OCCUPIED].get()
    set(value) { this[Keys.OCCUPIED] = value }

inline var CompositeValueStore<*, *>.isOccupied: Boolean?
    get() = this[Keys.OCCUPIED].unwrap()
    set(value) { value?.let { this[Keys.OCCUPIED] = it } ?: remove(Keys.OCCUPIED) }

inline var CompositeValueStore<*, *>.isOpen: Boolean?
    get() = this[Keys.OPEN].unwrap()
    set(value) { value?.let { this[Keys.OPEN] = it } ?: remove(Keys.OPEN) }

inline var CompositeValueStore<*, *>.isPowered: Boolean?
    get() = this[Keys.POWERED].unwrap()
    set(value) { value?.let { this[Keys.POWERED] = it } ?: remove(Keys.POWERED) }

inline var DaylightDetector.redstonePower: Int
    get() = this[Keys.POWER].get()
    set(value) { this[Keys.POWER] = value }

inline var CompositeValueStore<*, *>.redstonePower: Int?
    get() = this[Keys.POWER].unwrap()
    set(value) { value?.let { this[Keys.POWER] = it } ?: remove(Keys.POWER) }

inline var CompositeValueStore<*, *>.isSeamless: Boolean?
    get() = this[Keys.SEAMLESS].unwrap()
    set(value) { value?.let { this[Keys.SEAMLESS] = it } ?: remove(Keys.SEAMLESS) }

inline var CompositeValueStore<*, *>.hasSnow: Boolean?
    get() = this[Keys.SNOWED].unwrap()
    set(value) { value?.let { this[Keys.SNOWED] = it } ?: remove(Keys.SNOWED) }

inline var CompositeValueStore<*, *>.wireAttachments: Map<Direction, WireAttachmentType>?
    get() = this[Keys.WIRE_ATTACHMENTS].unwrap()
    set(value) { value?.let { this[Keys.WIRE_ATTACHMENTS] = it } ?: remove(Keys.WIRE_ATTACHMENTS) }

inline var CompositeValueStore<*, *>.wireAttachmentNorth: WireAttachmentType?
    get() = this[Keys.WIRE_ATTACHMENT_NORTH].unwrap()
    set(value) { value?.let { this[Keys.WIRE_ATTACHMENT_NORTH] = it } ?: remove(Keys.WIRE_ATTACHMENT_NORTH) }

inline var CompositeValueStore<*, *>.wireAttachmentSouth: WireAttachmentType?
    get() = this[Keys.WIRE_ATTACHMENT_SOUTH].unwrap()
    set(value) { value?.let { this[Keys.WIRE_ATTACHMENT_SOUTH] = it } ?: remove(Keys.WIRE_ATTACHMENT_SOUTH) }

inline var CompositeValueStore<*, *>.wireAttachmentEast: WireAttachmentType?
    get() = this[Keys.WIRE_ATTACHMENT_EAST].unwrap()
    set(value) { value?.let { this[Keys.WIRE_ATTACHMENT_EAST] = it } ?: remove(Keys.WIRE_ATTACHMENT_EAST) }

inline var CompositeValueStore<*, *>.wireAttachmentWest: WireAttachmentType?
    get() = this[Keys.WIRE_ATTACHMENT_WEST].unwrap()
    set(value) { value?.let { this[Keys.WIRE_ATTACHMENT_WEST] = it } ?: remove(Keys.WIRE_ATTACHMENT_WEST) }

inline var Living.absorption: Double
    get() = this[Keys.ABSORPTION].get()
    set(value) { this[Keys.ABSORPTION] = value }

inline var CompositeValueStore<*, *>.absorption: Double?
    get() = this[Keys.ABSORPTION].unwrap()
    set(value) { value?.let { this[Keys.ABSORPTION] = it } ?: remove(Keys.ABSORPTION) }

inline var Player.doesAffectSpawning: Boolean
    get() = this[Keys.AFFECTS_SPAWNING].get()
    set(value) { this[Keys.AFFECTS_SPAWNING] = value }

inline var CompositeValueStore<*, *>.doesAffectSpawning: Boolean?
    get() = this[Keys.AFFECTS_SPAWNING].unwrap()
    set(value) { value?.let { this[Keys.AFFECTS_SPAWNING] = it } ?: remove(Keys.AFFECTS_SPAWNING) }

inline var Wolf.isAngry: Boolean
    get() = this[Keys.ANGRY].get()
    set(value) { this[Keys.ANGRY] = value }

inline var CompositeValueStore<*, *>.isAngry: Boolean?
    get() = this[Keys.ANGRY].unwrap()
    set(value) { value?.let { this[Keys.ANGRY] = it } ?: remove(Keys.ANGRY) }

inline var CompositeValueStore<*, *>.remainingAir: Int?
    get() = this[Keys.REMAINING_AIR].unwrap()
    set(value) { value?.let { this[Keys.REMAINING_AIR] = it } ?: remove(Keys.REMAINING_AIR) }

inline var CompositeValueStore<*, *>.maxAir: Int?
    get() = this[Keys.MAX_AIR].unwrap()
    set(value) { value?.let { this[Keys.MAX_AIR] = it } ?: remove(Keys.MAX_AIR) }

inline var Animal.isBreedable: Boolean
    get() = this[Keys.CAN_BREED].get()
    set(value) { this[Keys.CAN_BREED] = value }

inline var CompositeValueStore<*, *>.isBreedable: Boolean?
    get() = this[Keys.CAN_BREED].unwrap()
    set(value) { value?.let { this[Keys.CAN_BREED] = it } ?: remove(Keys.CAN_BREED) }

inline var Arrow.isCritical: Boolean
    get() = this[Keys.CRITICAL_HIT].get()
    set(value) { this[Keys.CRITICAL_HIT] = value }

inline var CompositeValueStore<*, *>.isCritical: Boolean?
    get() = this[Keys.CRITICAL_HIT].unwrap()
    set(value) { value?.let { this[Keys.CRITICAL_HIT] = it } ?: remove(Keys.CRITICAL_HIT) }

inline var Entity.isCustomNameVisible: Boolean
    get() = this[Keys.CUSTOM_NAME_VISIBLE].get()
    set(value) { this[Keys.CUSTOM_NAME_VISIBLE] = value }

inline var CompositeValueStore<*, *>.isCustomNameVisible: Boolean?
    get() = this[Keys.CUSTOM_NAME_VISIBLE].unwrap()
    set(value) { value?.let { this[Keys.CUSTOM_NAME_VISIBLE] = it } ?: remove(Keys.CUSTOM_NAME_VISIBLE) }

inline var Entity.displayName: Text?
    get() = this[Keys.DISPLAY_NAME].unwrap()
    set(value) { value?.let { this[Keys.DISPLAY_NAME] = it } ?: remove(Keys.DISPLAY_NAME) }

inline var Entity.lastAttacker: EntitySnapshot?
    get() = this[Keys.LAST_ATTACKER].get().unwrap()
    set(value) { this[Keys.LAST_ATTACKER] = value.optional() }

inline var Entity.lastDamage: Double?
    get() = this[Keys.LAST_DAMAGE].get().unwrap()
    set(value) { this[Keys.LAST_DAMAGE] = value.optional() }

inline var Item.despawnDelay: Int
    get() = this[Keys.DESPAWN_DELAY].get()
    set(value) { this[Keys.DESPAWN_DELAY] = value }

inline var CompositeValueStore<*, *>.despawnDelay: Int?
    get() = this[Keys.DESPAWN_DELAY].unwrap()
    set(value) { value?.let { this[Keys.DESPAWN_DELAY] = it } ?: remove(Keys.DESPAWN_DELAY) }

inline var Item.isInfiniteDespawnDelay: Boolean
    get() = this[Keys.INFINITE_DESPAWN_DELAY].get()
    set(value) { this[Keys.INFINITE_DESPAWN_DELAY] = value }

inline var CompositeValueStore<*, *>.isInfiniteDespawnDelay: Boolean?
    get() = this[Keys.INFINITE_DESPAWN_DELAY].unwrap()
    set(value) { value?.let { this[Keys.INFINITE_DESPAWN_DELAY] = it } ?: remove(Keys.INFINITE_DESPAWN_DELAY) }

inline var Player.isElytraFlying: Boolean
    get() = this[Keys.IS_ELYTRA_FLYING].get()
    set(value) { this[Keys.IS_ELYTRA_FLYING] = value }

inline var CompositeValueStore<*, *>.isElytraFlying: Boolean?
    get() = this[Keys.IS_ELYTRA_FLYING].unwrap()
    set(value) { value?.let { this[Keys.IS_ELYTRA_FLYING] = it } ?: remove(Keys.IS_ELYTRA_FLYING) }

inline var Humanoid.totalExperience: Int
    get() = this[Keys.TOTAL_EXPERIENCE].get()
    set(value) { this[Keys.TOTAL_EXPERIENCE] = value }

inline var CompositeValueStore<*, *>.totalExperience: Int?
    get() = this[Keys.TOTAL_EXPERIENCE].unwrap()
    set(value) { value?.let { this[Keys.TOTAL_EXPERIENCE] = it } ?: remove(Keys.TOTAL_EXPERIENCE) }

inline var Humanoid.levels: Int
    get() = this[Keys.EXPERIENCE_LEVEL].get()
    set(value) { this[Keys.EXPERIENCE_LEVEL] = value }

inline var CompositeValueStore<*, *>.levels: Int?
    get() = this[Keys.EXPERIENCE_LEVEL].unwrap()
    set(value) { value?.let { this[Keys.EXPERIENCE_LEVEL] = it } ?: remove(Keys.EXPERIENCE_LEVEL) }

inline var Humanoid.experienceSinceLevel: Int
    get() = this[Keys.EXPERIENCE_SINCE_LEVEL].get()
    set(value) { this[Keys.EXPERIENCE_SINCE_LEVEL] = value }

inline var CompositeValueStore<*, *>.experienceSinceLevel: Int?
    get() = this[Keys.EXPERIENCE_SINCE_LEVEL].unwrap()
    set(value) { value?.let { this[Keys.EXPERIENCE_SINCE_LEVEL] = it } ?: remove(Keys.EXPERIENCE_SINCE_LEVEL) }

inline val Humanoid.experienceBetweenLevels: Int
    get() = this[Keys.EXPERIENCE_FROM_START_OF_LEVEL].get()

inline val CompositeValueStore<*, *>.experienceBetweenLevels: Int?
    get() = this[Keys.EXPERIENCE_FROM_START_OF_LEVEL].unwrap()

inline var Entity.fallDistance: Float
    get() = this[Keys.FALL_DISTANCE].get()
    set(value) { this[Keys.FALL_DISTANCE] = value }

inline var CompositeValueStore<*, *>.fallDistance: Float?
    get() = this[Keys.FALL_DISTANCE].unwrap()
    set(value) { value?.let { this[Keys.FALL_DISTANCE] = it } ?: remove(Keys.FALL_DISTANCE) }

inline var Humanoid.canFly: Boolean
    get() = this[Keys.CAN_FLY].get()
    set(value) { this[Keys.CAN_FLY] = value }

inline var CompositeValueStore<*, *>.canFly: Boolean?
    get() = this[Keys.CAN_FLY].unwrap()
    set(value) { value?.let { this[Keys.CAN_FLY] = it } ?: remove(Keys.CAN_FLY) }

inline var Humanoid.isFlying: Boolean
    get() = this[Keys.IS_FLYING].get()
    set(value) { this[Keys.IS_FLYING] = value }

inline var CompositeValueStore<*, *>.isFlying: Boolean?
    get() = this[Keys.IS_FLYING].unwrap()
    set(value) { value?.let { this[Keys.IS_FLYING] = it } ?: remove(Keys.IS_FLYING) }

inline var Entity.isGlowing: Boolean
    get() = this[Keys.GLOWING].get()
    set(value) { this[Keys.GLOWING] = value }

inline var CompositeValueStore<*, *>.isGlowing: Boolean?
    get() = this[Keys.GLOWING].unwrap()
    set(value) { value?.let { this[Keys.GLOWING] = it } ?: remove(Keys.GLOWING) }

inline var Entity.hasGravity: Boolean
    get() = this[Keys.HAS_GRAVITY].get()
    set(value) { this[Keys.HAS_GRAVITY] = value }

inline var CompositeValueStore<*, *>.hasGravity: Boolean?
    get() = this[Keys.HAS_GRAVITY].unwrap()
    set(value) { value?.let { this[Keys.HAS_GRAVITY] = it } ?: remove(Keys.HAS_GRAVITY) }

inline var Living.canGrief: Boolean
    get() = this[Keys.CAN_GRIEF].get()
    set(value) { this[Keys.CAN_GRIEF] = value }

inline var CompositeValueStore<*, *>.canGrief: Boolean?
    get() = this[Keys.CAN_GRIEF].unwrap()
    set(value) { value?.let { this[Keys.CAN_GRIEF] = it } ?: remove(Keys.CAN_GRIEF) }

inline var SmallFireball.canGrief: Boolean
    get() = this[Keys.CAN_GRIEF].get()
    set(value) { this[Keys.CAN_GRIEF] = value }

inline var LargeFireball.canGrief: Boolean
    get() = this[Keys.CAN_GRIEF].get()
    set(value) { this[Keys.CAN_GRIEF] = value }

inline var WitherSkull.canGrief: Boolean
    get() = this[Keys.CAN_GRIEF].get()
    set(value) { this[Keys.CAN_GRIEF] = value }

inline var Player.healthScale: Double
    get() = this[Keys.HEALTH_SCALE].get()
    set(value) { this[Keys.HEALTH_SCALE] = value }

inline var CompositeValueStore<*, *>.healthScale: Double?
    get() = this[Keys.HEALTH_SCALE].unwrap()
    set(value) { value?.let { this[Keys.HEALTH_SCALE] = it } ?: remove(Keys.HEALTH_SCALE) }

inline var Entity.fireTicks: Int?
    get() = this[Keys.FIRE_TICKS].unwrap()
    set(value) { value?.let { this[Keys.FIRE_TICKS] = it } ?: this.remove(Keys.FIRE_TICKS) }

inline var CompositeValueStore<*, *>.fireTicks: Int?
    get() = this[Keys.FIRE_TICKS].unwrap()
    set(value) { value?.let { this[Keys.FIRE_TICKS] = it } ?: remove(Keys.FIRE_TICKS) }

inline var Entity.fireDelay: Int?
    get() = this[Keys.FIRE_DAMAGE_DELAY].unwrap()
    set(value) { value?.let { this[Keys.FIRE_DAMAGE_DELAY] = it } ?: remove(Keys.FIRE_DAMAGE_DELAY) }

inline var CompositeValueStore<*, *>.fireDelay: Int?
    get() = this[Keys.FIRE_DAMAGE_DELAY].unwrap()
    set(value) { value?.let { this[Keys.FIRE_DAMAGE_DELAY] = it } ?: remove(Keys.FIRE_DAMAGE_DELAY) }

inline var Entity.isInvisible: Boolean
    get() = this[Keys.INVISIBLE].get()
    set(value) { this[Keys.INVISIBLE] = value }

inline var CompositeValueStore<*, *>.isInvisible: Boolean?
    get() = this[Keys.INVISIBLE].unwrap()
    set(value) { value?.let { this[Keys.INVISIBLE] = it } ?: remove(Keys.INVISIBLE) }

inline var Entity.isVanished: Boolean
    get() = this[Keys.VANISH].get()
    set(value) { this[Keys.VANISH] = value }

inline var CompositeValueStore<*, *>.isVanished: Boolean?
    get() = this[Keys.VANISH].unwrap()
    set(value) { value?.let { this[Keys.VANISH] = it } ?: remove(Keys.VANISH) }

inline var Entity.vanishIgnoresCollision: Boolean
    get() = this[Keys.VANISH_IGNORES_COLLISION].get()
    set(value) { this[Keys.VANISH_IGNORES_COLLISION] = value }

inline var CompositeValueStore<*, *>.vanishIgnoresCollision: Boolean?
    get() = this[Keys.VANISH_IGNORES_COLLISION].unwrap()
    set(value) { value?.let { this[Keys.VANISH_IGNORES_COLLISION] = it } ?: remove(Keys.VANISH_IGNORES_COLLISION) }

inline var Entity.vanishPreventsTargeting: Boolean
    get() = this[Keys.VANISH_PREVENTS_TARGETING].get()
    set(value) { this[Keys.VANISH_PREVENTS_TARGETING] = value }

inline var CompositeValueStore<*, *>.vanishPreventsTargeting: Boolean?
    get() = this[Keys.VANISH_PREVENTS_TARGETING].unwrap()
    set(value) { value?.let { this[Keys.VANISH_PREVENTS_TARGETING] = it } ?: remove(Keys.VANISH_PREVENTS_TARGETING) }

inline var Entity.isInvulnerable: Boolean
    get() = this[Keys.INVULNERABLE].get()
    set(value) { this[Keys.INVULNERABLE] = value }

inline var CompositeValueStore<*, *>.isInvulnerable: Boolean?
    get() = this[Keys.INVULNERABLE].unwrap()
    set(value) { value?.let { this[Keys.INVULNERABLE] = it } ?: remove(Keys.INVULNERABLE) }

inline var Entity.invulnerabilityTicks: Int
    get() = this[Keys.INVULNERABILITY_TICKS].get()
    set(value) { this[Keys.INVULNERABILITY_TICKS] = value }

inline var CompositeValueStore<*, *>.invulnerabilityTicks: Int?
    get() = this[Keys.INVULNERABILITY_TICKS].unwrap()
    set(value) { value?.let { this[Keys.INVULNERABILITY_TICKS] = it } ?: remove(Keys.INVULNERABILITY_TICKS) }

inline var Minecart.block: BlockState?
    get() = this[Keys.REPRESENTED_BLOCK].unwrap()
    set(value) { value?.let { this[Keys.REPRESENTED_BLOCK] = it } ?: this.remove(Keys.REPRESENTED_BLOCK) }

inline var CompositeValueStore<*, *>.representedBlock: BlockState?
    get() = this[Keys.REPRESENTED_BLOCK].unwrap()
    set(value) { value?.let { this[Keys.REPRESENTED_BLOCK] = it } ?: remove(Keys.REPRESENTED_BLOCK) }

inline var Player.walkSpeed: Double
    get() = this[Keys.WALKING_SPEED].get()
    set(value) { this[Keys.WALKING_SPEED] = value }

inline var CompositeValueStore<*, *>.walkSpeed: Double?
    get() = this[Keys.WALKING_SPEED].unwrap()
    set(value) { value?.let { this[Keys.WALKING_SPEED] = it } ?: remove(Keys.WALKING_SPEED) }

inline var Player.flySpeed: Double
    get() = this[Keys.FLYING_SPEED].get()
    set(value) { this[Keys.FLYING_SPEED] = value }

inline var CompositeValueStore<*, *>.flySpeed: Double?
    get() = this[Keys.FLYING_SPEED].unwrap()
    set(value) { value?.let { this[Keys.FLYING_SPEED] = it } ?: remove(Keys.FLYING_SPEED) }

inline var Entity.shouldPersist: Boolean
    get() = this[Keys.PERSISTS].get()
    set(value) { this[Keys.PERSISTS] = value }

inline var CompositeValueStore<*, *>.shouldPersist: Boolean?
    get() = this[Keys.PERSISTS].unwrap()
    set(value) { value?.let { this[Keys.PERSISTS] = it } ?: remove(Keys.PERSISTS) }

inline var Item.pickupDelay: Int
    get() = this[Keys.PICKUP_DELAY].get()
    set(value) { this[Keys.PICKUP_DELAY] = value }

inline var CompositeValueStore<*, *>.pickupDelay: Int?
    get() = this[Keys.PICKUP_DELAY].unwrap()
    set(value) { value?.let { this[Keys.PICKUP_DELAY] = it } ?: remove(Keys.PICKUP_DELAY) }

inline var Item.isInfinitePickupDelay: Boolean
    get() = this[Keys.INFINITE_PICKUP_DELAY].get()
    set(value) { this[Keys.INFINITE_PICKUP_DELAY] = value }

inline var CompositeValueStore<*, *>.isInfinitePickupDelay: Boolean?
    get() = this[Keys.INFINITE_PICKUP_DELAY].unwrap()
    set(value) { value?.let { this[Keys.INFINITE_PICKUP_DELAY] = it } ?: remove(Keys.INFINITE_PICKUP_DELAY) }

inline var Villager.isPlaying: Boolean
    get() = this[Keys.IS_PLAYING].get()
    set(value) { this[Keys.IS_PLAYING] = value }

inline var CompositeValueStore<*, *>.isPlaying: Boolean?
    get() = this[Keys.IS_PLAYING].unwrap()
    set(value) { value?.let { this[Keys.IS_PLAYING] = it } ?: remove(Keys.IS_PLAYING) }

inline var Enderman.isScreaming: Boolean
    get() = this[Keys.IS_SCREAMING].get()
    set(value) { this[Keys.IS_SCREAMING] = value }

inline var CompositeValueStore<*, *>.isScreaming: Boolean?
    get() = this[Keys.IS_SCREAMING].unwrap()
    set(value) { value?.let { this[Keys.IS_SCREAMING] = it } ?: remove(Keys.IS_SCREAMING) }

inline var EyeOfEnder.willShatter: Boolean
    get() = this[Keys.WILL_SHATTER].get()
    set(value) { this[Keys.WILL_SHATTER] = value }

inline var CompositeValueStore<*, *>.willShatter: Boolean?
    get() = this[Keys.WILL_SHATTER].unwrap()
    set(value) { value?.let { this[Keys.WILL_SHATTER] = it } ?: remove(Keys.WILL_SHATTER) }

inline var Sheep.isSheared: Boolean
    get() = this[Keys.IS_SHEARED].get()
    set(value) { this[Keys.IS_SHEARED] = value }

inline var CompositeValueStore<*, *>.isSheared: Boolean?
    get() = this[Keys.IS_SHEARED].unwrap()
    set(value) { value?.let { this[Keys.IS_SHEARED] = it } ?: remove(Keys.IS_SHEARED) }

inline var Entity.isSilent: Boolean
    get() = this[Keys.IS_SILENT].get()
    set(value) { this[Keys.IS_SILENT] = value }

inline var CompositeValueStore<*, *>.isSilent: Boolean?
    get() = this[Keys.IS_SILENT].unwrap()
    set(value) { value?.let { this[Keys.IS_SILENT] = it } ?: remove(Keys.IS_SILENT) }

inline var Wolf.isSitting: Boolean
    get() = this[Keys.IS_SITTING].get()
    set(value) { this[Keys.IS_SITTING] = value }

inline var CompositeValueStore<*, *>.isSitting: Boolean?
    get() = this[Keys.IS_SITTING].unwrap()
    set(value) { value?.let { this[Keys.IS_SITTING] = it } ?: remove(Keys.IS_SITTING) }

inline var Ocelot.isSitting: Boolean
    get() = this[Keys.IS_SITTING].get()
    set(value) { this[Keys.IS_SITTING] = value }

inline var Humanoid.skinId: UUID
    get() = this[Keys.SKIN_UNIQUE_ID].get()
    set(value) { this[Keys.SKIN_UNIQUE_ID] = value }

inline var CompositeValueStore<*, *>.skinId: UUID?
    get() = this[Keys.SKIN_UNIQUE_ID].unwrap()
    set(value) { value?.let { this[Keys.SKIN_UNIQUE_ID] = it } ?: remove(Keys.SKIN_UNIQUE_ID) }

inline var Entity.baseSize: Float
    get() = this[Keys.BASE_SIZE].get()
    set(value) { this[Keys.BASE_SIZE] = value }

inline var CompositeValueStore<*, *>.baseSize: Float?
    get() = this[Keys.BASE_SIZE].unwrap()
    set(value) { value?.let { this[Keys.BASE_SIZE] = it } ?: remove(Keys.BASE_SIZE) }

inline var Entity.height: Float
    get() = this[Keys.HEIGHT].get()
    set(value) { this[Keys.HEIGHT] = value }

inline var CompositeValueStore<*, *>.height: Float?
    get() = this[Keys.HEIGHT].unwrap()
    set(value) { value?.let { this[Keys.HEIGHT] = it } ?: remove(Keys.HEIGHT) }

inline var Entity.entityScale: Float
    get() = this[Keys.SCALE].get()
    set(value) { this[Keys.SCALE] = value }

inline var CompositeValueStore<*, *>.entityScale: Float?
    get() = this[Keys.SCALE].unwrap()
    set(value) { value?.let { this[Keys.SCALE] = it } ?: remove(Keys.SCALE) }

inline var Player.isSleeping: Boolean
    get() = this[Keys.IS_SLEEPING].get()
    set(value) { this[Keys.IS_SLEEPING] = value }

inline var CompositeValueStore<*, *>.isSleeping: Boolean?
    get() = this[Keys.IS_SLEEPING].unwrap()
    set(value) { value?.let { this[Keys.IS_SLEEPING] = it } ?: remove(Keys.IS_SLEEPING) }

inline var Bat.isSleeping: Boolean
    get() = this[Keys.IS_SLEEPING].get()
    set(value) { this[Keys.IS_SLEEPING] = value }

inline var Entity.isSneaking: Boolean
    get() = this[Keys.IS_SNEAKING].get()
    set(value) { this[Keys.IS_SNEAKING] = value }

inline var CompositeValueStore<*, *>.isSneaking: Boolean?
    get() = this[Keys.IS_SNEAKING].unwrap()
    set(value) { value?.let { this[Keys.IS_SNEAKING] = it } ?: remove(Keys.IS_SNEAKING) }

inline var Entity.isSprinting: Boolean
    get() = this[Keys.IS_SPRINTING].get()
    set(value) { this[Keys.IS_SPRINTING] = value }

inline var CompositeValueStore<*, *>.isSprinting: Boolean?
    get() = this[Keys.IS_SPRINTING].unwrap()
    set(value) { value?.let { this[Keys.IS_SPRINTING] = it } ?: remove(Keys.IS_SPRINTING) }

inline var Living.stuckArrows: Int
    get() = this[Keys.STUCK_ARROWS].get()
    set(value) { this[Keys.STUCK_ARROWS] = value }

inline var CompositeValueStore<*, *>.stuckArrows: Int?
    get() = this[Keys.STUCK_ARROWS].unwrap()
    set(value) { value?.let { this[Keys.STUCK_ARROWS] = it } ?: remove(Keys.STUCK_ARROWS) }

inline var Horse.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var ZombieHorse.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var SkeletonHorse.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var Llama.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var Mule.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var Parrot.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var Donkey.owner: UUID?
    get() = this[Keys.TAMED_OWNER].get().unwrap()
    set(value) { this[Keys.TAMED_OWNER] = value.optional() }

inline var CompositeValueStore<*, *>.bookAuthor: Text?
    get() = this[Keys.BOOK_AUTHOR].unwrap()
    set(value) { value?.let { this[Keys.BOOK_AUTHOR] = it } ?: remove(Keys.BOOK_AUTHOR) }

inline var CompositeValueStore<*, *>.blockItem: BlockState?
    get() = this[Keys.ITEM_BLOCKSTATE].unwrap()
    set(value) { value?.let { this[Keys.ITEM_BLOCKSTATE] = it } ?: remove(Keys.ITEM_BLOCKSTATE) }

inline var CompositeValueStore<*, *>.breakableBlocks: Set<BlockType>?
    get() = this[Keys.BREAKABLE_BLOCK_TYPES].unwrap()
    set(value) { value?.let { this[Keys.BREAKABLE_BLOCK_TYPES] = it } ?: remove(Keys.BREAKABLE_BLOCK_TYPES) }

inline var CompositeValueStore<*, *>.durability: Int?
    get() = this[Keys.ITEM_DURABILITY].unwrap()
    set(value) { value?.let { this[Keys.ITEM_DURABILITY] = it } ?: remove(Keys.ITEM_DURABILITY) }

inline var CompositeValueStore<*, *>.isUnbreakable: Boolean?
    get() = this[Keys.UNBREAKABLE].unwrap()
    set(value) { value?.let { this[Keys.UNBREAKABLE] = it } ?: remove(Keys.UNBREAKABLE) }

inline var CompositeValueStore<*, *>.bookGeneration: Int?
    get() = this[Keys.GENERATION].unwrap()
    set(value) { value?.let { this[Keys.GENERATION] = it } ?: remove(Keys.GENERATION) }

inline var CompositeValueStore<*, *>.shouldHideEnchantments: Boolean?
    get() = this[Keys.HIDE_ENCHANTMENTS].unwrap()
    set(value) { value?.let { this[Keys.HIDE_ENCHANTMENTS] = it } ?: remove(Keys.HIDE_ENCHANTMENTS) }

inline var CompositeValueStore<*, *>.shouldHideAttributes: Boolean?
    get() = this[Keys.HIDE_ATTRIBUTES].unwrap()
    set(value) { value?.let { this[Keys.HIDE_ATTRIBUTES] = it } ?: remove(Keys.HIDE_ATTRIBUTES) }

inline var CompositeValueStore<*, *>.shouldHideUnbreakable: Boolean?
    get() = this[Keys.HIDE_UNBREAKABLE].unwrap()
    set(value) { value?.let { this[Keys.HIDE_UNBREAKABLE] = it } ?: remove(Keys.HIDE_UNBREAKABLE) }

inline var CompositeValueStore<*, *>.shouldHideBreakableBlocks: Boolean?
    get() = this[Keys.HIDE_CAN_DESTROY].unwrap()
    set(value) { value?.let { this[Keys.HIDE_CAN_DESTROY] = it } ?: remove(Keys.HIDE_CAN_DESTROY) }

inline var CompositeValueStore<*, *>.shouldHidePlaceableBlocks: Boolean?
    get() = this[Keys.HIDE_CAN_PLACE].unwrap()
    set(value) { value?.let { this[Keys.HIDE_CAN_PLACE] = it } ?: remove(Keys.HIDE_CAN_PLACE) }

inline var CompositeValueStore<*, *>.shouldHideMiscellaneous: Boolean?
    get() = this[Keys.HIDE_MISCELLANEOUS].unwrap()
    set(value) { value?.let { this[Keys.HIDE_MISCELLANEOUS] = it } ?: remove(Keys.HIDE_MISCELLANEOUS) }

inline val DataHolder.carrier: Carrier?
    get() = this.get(InventoryItemData::class.java).unwrap()

inline var CompositeValueStore<*, *>.placeableBlocks: Set<BlockType>?
    get() = this[Keys.PLACEABLE_BLOCKS].unwrap()
    set(value) { value?.let { this[Keys.PLACEABLE_BLOCKS] = it } ?: remove(Keys.PLACEABLE_BLOCKS) }

inline var TileEntityCarrier.lockToken: String?
    get() = this[Keys.LOCK_TOKEN].unwrap()
    set(value) { value?.let { this[Keys.LOCK_TOKEN] = it } ?: remove(Keys.LOCK_TOKEN) }

inline var CompositeValueStore<*, *>.lockToken: String?
    get() = this[Keys.LOCK_TOKEN].unwrap()
    set(value) { value?.let { this[Keys.LOCK_TOKEN] = it } ?: remove(Keys.LOCK_TOKEN) }

inline var CompositeValueStore<*, *>.fluidStack: FluidStackSnapshot?
    get() = this[Keys.FLUID_ITEM_STACK].unwrap()
    set(value) { value?.let { this[Keys.FLUID_ITEM_STACK] = it } ?: remove(Keys.FLUID_ITEM_STACK) }

inline var CompositeValueStore<*, *>.axis: Axis?
    get() = this[Keys.AXIS].unwrap()
    set(value) { value?.let { this[Keys.AXIS] = it } ?: remove(Keys.AXIS) }

inline var CompositeValueStore<*, *>.bigMushroomType: BigMushroomType?
    get() = this[Keys.BIG_MUSHROOM_TYPE].unwrap()
    set(value) { value?.let { this[Keys.BIG_MUSHROOM_TYPE] = it } ?: remove(Keys.BIG_MUSHROOM_TYPE) }

inline var CompositeValueStore<*, *>.bookPages: List<Text>?
    get() = this[Keys.BOOK_PAGES].unwrap()
    set(value) { value?.let { this[Keys.BOOK_PAGES] = it } ?: remove(Keys.BOOK_PAGES) }

inline var CompositeValueStore<*, *>.brickType: BrickType?
    get() = this[Keys.BRICK_TYPE].unwrap()
    set(value) { value?.let { this[Keys.BRICK_TYPE] = it } ?: remove(Keys.BRICK_TYPE) }

inline var CompositeValueStore<*, *>.coalType: CoalType?
    get() = this[Keys.COAL_TYPE].unwrap()
    set(value) { value?.let { this[Keys.COAL_TYPE] = it } ?: remove(Keys.COAL_TYPE) }

inline var CompositeValueStore<*, *>.cookedFishType: CookedFish?
    get() = this[Keys.COOKED_FISH].unwrap()
    set(value) { value?.let { this[Keys.COOKED_FISH] = it } ?: remove(Keys.COOKED_FISH) }

inline var CompositeValueStore<*, *>.dirtType: DirtType?
    get() = this[Keys.DIRT_TYPE].unwrap()
    set(value) { value?.let { this[Keys.DIRT_TYPE] = it } ?: remove(Keys.DIRT_TYPE) }

inline var CompositeValueStore<*, *>.disguisedBlockType: DisguisedBlockType?
    get() = this[Keys.DISGUISED_BLOCK_TYPE].unwrap()
    set(value) { value?.let { this[Keys.DISGUISED_BLOCK_TYPE] = it } ?: remove(Keys.DISGUISED_BLOCK_TYPE) }

inline var Humanoid.dominantHand: HandPreference
    get() = this[Keys.DOMINANT_HAND].get()
    set(value) { this[Keys.DOMINANT_HAND] = value }

inline var CompositeValueStore<*, *>.dominantHand: HandPreference?
    get() = this[Keys.DOMINANT_HAND].unwrap()
    set(value) { value?.let { this[Keys.DOMINANT_HAND] = it } ?: remove(Keys.DOMINANT_HAND) }

inline var CompositeValueStore<*, *>.doublePlantType: DoublePlantType?
    get() = this[Keys.DOUBLE_PLANT_TYPE].unwrap()
    set(value) { value?.let { this[Keys.DOUBLE_PLANT_TYPE] = it } ?: remove(Keys.DOUBLE_PLANT_TYPE) }

inline var CompositeValueStore<*, *>.fishType: Fish?
    get() = this[Keys.FISH_TYPE].unwrap()
    set(value) { value?.let { this[Keys.FISH_TYPE] = it } ?: remove(Keys.FISH_TYPE) }

inline var CompositeValueStore<*, *>.fluidTankContents: Map<Direction, List<FluidStackSnapshot>>?
    get() = this[Keys.FLUID_TANK_CONTENTS].unwrap()
    set(value) { value?.let { this[Keys.FLUID_TANK_CONTENTS] = it } ?: remove(Keys.FLUID_TANK_CONTENTS) }

inline var CompositeValueStore<*, *>.goldenAppleType: GoldenApple?
    get() = this[Keys.GOLDEN_APPLE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.GOLDEN_APPLE_TYPE] = it } ?: remove(Keys.GOLDEN_APPLE_TYPE) }

inline var CompositeValueStore<*, *>.hingePosition: Hinge?
    get() = this[Keys.HINGE_POSITION].unwrap()
    set(value) { value?.let { this[Keys.HINGE_POSITION] = it } ?: remove(Keys.HINGE_POSITION) }

inline var CompositeValueStore<*, *>.enchantments: List<Enchantment>?
    get() = this[Keys.ITEM_ENCHANTMENTS].unwrap()
    set(value) { value?.let { this[Keys.ITEM_ENCHANTMENTS] = it } ?: remove(Keys.ITEM_ENCHANTMENTS) }

inline var CompositeValueStore<*, *>.logAxis: LogAxis?
    get() = this[Keys.LOG_AXIS].unwrap()
    set(value) { value?.let { this[Keys.LOG_AXIS] = it } ?: remove(Keys.LOG_AXIS) }

inline var Minecart.offset: Int?
    get() = this[Keys.OFFSET].unwrap()
    set(value) { value?.let { this[Keys.OFFSET] = it } ?: remove(Keys.OFFSET) }

inline var CompositeValueStore<*, *>.offset: Int?
    get() = this[Keys.OFFSET].unwrap()
    set(value) { value?.let { this[Keys.OFFSET] = it } ?: remove(Keys.OFFSET) }

inline var Arrow.pickupRule: PickupRule
    get() = this[Keys.PICKUP_RULE].get()
    set(value) { this[Keys.PICKUP_RULE] = value }

inline var CompositeValueStore<*, *>.pickupRule: PickupRule?
    get() = this[Keys.PICKUP_RULE].unwrap()
    set(value) { value?.let { this[Keys.PICKUP_RULE] = it } ?: remove(Keys.PICKUP_RULE) }

inline var CompositeValueStore<*, *>.pistonType: PistonType?
    get() = this[Keys.PISTON_TYPE].unwrap()
    set(value) { value?.let { this[Keys.PISTON_TYPE] = it } ?: remove(Keys.PISTON_TYPE) }

inline var CompositeValueStore<*, *>.plantType: PlantType?
    get() = this[Keys.PLANT_TYPE].unwrap()
    set(value) { value?.let { this[Keys.PLANT_TYPE] = it } ?: remove(Keys.PLANT_TYPE) }

inline var CompositeValueStore<*, *>.portionType: PortionType?
    get() = this[Keys.PORTION_TYPE].unwrap()
    set(value) { value?.let { this[Keys.PORTION_TYPE] = it } ?: remove(Keys.PORTION_TYPE) }

inline var CompositeValueStore<*, *>.prismarineType: PrismarineType?
    get() = this[Keys.PRISMARINE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.PRISMARINE_TYPE] = it } ?: remove(Keys.PRISMARINE_TYPE) }

inline var CompositeValueStore<*, *>.quartzType: QuartzType?
    get() = this[Keys.QUARTZ_TYPE].unwrap()
    set(value) { value?.let { this[Keys.QUARTZ_TYPE] = it } ?: remove(Keys.QUARTZ_TYPE) }

inline var CompositeValueStore<*, *>.railDirection: RailDirection?
    get() = this[Keys.RAIL_DIRECTION].unwrap()
    set(value) { value?.let { this[Keys.RAIL_DIRECTION] = it } ?: remove(Keys.RAIL_DIRECTION) }

inline var BrewingStand.remainingBrewTime: Int
    get() = this[Keys.REMAINING_BREW_TIME].get()
    set(value) { this[Keys.REMAINING_BREW_TIME] = value }

inline var CompositeValueStore<*, *>.remainingBrewTime: Int?
    get() = this[Keys.REMAINING_BREW_TIME].unwrap()
    set(value) { value?.let { this[Keys.REMAINING_BREW_TIME] = it } ?: remove(Keys.REMAINING_BREW_TIME) }

inline var Player.respawnLocations: Map<UUID, RespawnLocation>
    get() = this[Keys.RESPAWN_LOCATIONS].get()
    set(value) { this[Keys.RESPAWN_LOCATIONS] = value }

inline var CompositeValueStore<*, *>.respawnLocations: Map<UUID, RespawnLocation>?
    get() = this[Keys.RESPAWN_LOCATIONS].unwrap()
    set(value) { value?.let { this[Keys.RESPAWN_LOCATIONS] = it } ?: remove(Keys.RESPAWN_LOCATIONS) }

inline var CompositeValueStore<*, *>.sandType: SandType?
    get() = this[Keys.SAND_TYPE].unwrap()
    set(value) { value?.let { this[Keys.SAND_TYPE] = it } ?: remove(Keys.SAND_TYPE) }

inline var CompositeValueStore<*, *>.sandstoneType: SandstoneType?
    get() = this[Keys.SANDSTONE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.SANDSTONE_TYPE] = it } ?: remove(Keys.SANDSTONE_TYPE) }

inline var CompositeValueStore<*, *>.shrubType: ShrubType?
    get() = this[Keys.SHRUB_TYPE].unwrap()
    set(value) { value?.let { this[Keys.SHRUB_TYPE] = it } ?: remove(Keys.SHRUB_TYPE) }

inline var CompositeValueStore<*, *>.slabType: SlabType?
    get() = this[Keys.SLAB_TYPE].unwrap()
    set(value) { value?.let { this[Keys.SLAB_TYPE] = it } ?: remove(Keys.SLAB_TYPE) }

inline var CompositeValueStore<*, *>.stairShape: StairShape?
    get() = this[Keys.STAIR_SHAPE].unwrap()
    set(value) { value?.let { this[Keys.STAIR_SHAPE] = it } ?: remove(Keys.STAIR_SHAPE) }

inline var CompositeValueStore<*, *>.stoneType: StoneType?
    get() = this[Keys.STONE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.STONE_TYPE] = it } ?: remove(Keys.STONE_TYPE) }

inline var CompositeValueStore<*, *>.storedEnchantments: List<Enchantment>?
    get() = this[Keys.STORED_ENCHANTMENTS].unwrap()
    set(value) { value?.let { this[Keys.STORED_ENCHANTMENTS] = it } ?: remove(Keys.STORED_ENCHANTMENTS) }

inline var CompositeValueStore<*, *>.isSuspended: Boolean?
    get() = this[Keys.SUSPENDED].unwrap()
    set(value) { value?.let { this[Keys.SUSPENDED] = it } ?: remove(Keys.SUSPENDED) }

inline var CompositeValueStore<*, *>.treeType: TreeType?
    get() = this[Keys.TREE_TYPE].unwrap()
    set(value) { value?.let { this[Keys.TREE_TYPE] = it } ?: remove(Keys.TREE_TYPE) }

inline var CompositeValueStore<*, *>.wallType: WallType?
    get() = this[Keys.WALL_TYPE].unwrap()
    set(value) { value?.let { this[Keys.WALL_TYPE] = it } ?: remove(Keys.WALL_TYPE) }
