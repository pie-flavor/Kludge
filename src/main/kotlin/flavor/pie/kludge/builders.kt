@file:Suppress("UNCHECKED_CAST", "FunctionName")
package flavor.pie.kludge
import org.spongepowered.api.advancement.Advancement
import org.spongepowered.api.advancement.AdvancementTree
import org.spongepowered.api.advancement.DisplayInfo
import org.spongepowered.api.advancement.criteria.AdvancementCriterion
import org.spongepowered.api.advancement.criteria.ScoreAdvancementCriterion
import org.spongepowered.api.advancement.criteria.trigger.FilteredTrigger
import org.spongepowered.api.advancement.criteria.trigger.FilteredTriggerConfiguration
import org.spongepowered.api.advancement.criteria.trigger.Trigger
import org.spongepowered.api.block.BlockSnapshot
import org.spongepowered.api.block.BlockState
import org.spongepowered.api.block.tileentity.TileEntityArchetype
import org.spongepowered.api.boss.ServerBossBar
import org.spongepowered.api.command.args.CommandElement
import org.spongepowered.api.command.args.CommandFlags
import org.spongepowered.api.command.args.GenericArguments
import org.spongepowered.api.command.spec.CommandSpec
import org.spongepowered.api.data.DataRegistration
import org.spongepowered.api.data.key.Key
import org.spongepowered.api.data.manipulator.DataManipulator
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator
import org.spongepowered.api.data.meta.PatternLayer
import org.spongepowered.api.data.value.BaseValue
import org.spongepowered.api.effect.particle.ParticleEffect
import org.spongepowered.api.effect.potion.PotionEffect
import org.spongepowered.api.effect.sound.SoundType
import org.spongepowered.api.entity.EntityArchetype
import org.spongepowered.api.entity.EntitySnapshot
import org.spongepowered.api.entity.ai.task.builtin.LookIdleAITask
import org.spongepowered.api.entity.ai.task.builtin.SwimmingAITask
import org.spongepowered.api.entity.ai.task.builtin.WatchClosestAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.AttackLivingAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.AvoidEntityAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.RangeAgentAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.WanderAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.horse.RunAroundLikeCrazyAITask
import org.spongepowered.api.entity.ai.task.builtin.creature.target.FindNearestAttackableTargetAITask
import org.spongepowered.api.entity.living.Agent
import org.spongepowered.api.entity.living.Creature
import org.spongepowered.api.entity.living.Ranger
import org.spongepowered.api.entity.living.animal.RideableHorse
import org.spongepowered.api.entity.living.player.tab.TabListEntry
import org.spongepowered.api.event.cause.EventContextKey
import org.spongepowered.api.event.cause.entity.damage.source.BlockDamageSource
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource
import org.spongepowered.api.event.cause.entity.damage.source.IndirectEntityDamageSource
import org.spongepowered.api.event.cause.entity.health.source.BlockHealingSource
import org.spongepowered.api.event.cause.entity.health.source.EntityHealingSource
import org.spongepowered.api.event.cause.entity.health.source.HealingSource
import org.spongepowered.api.event.cause.entity.health.source.IndirectEntityHealingSource
import org.spongepowered.api.extra.fluid.FluidStack
import org.spongepowered.api.extra.fluid.FluidStackSnapshot
import org.spongepowered.api.item.FireworkEffect
import org.spongepowered.api.item.enchantment.Enchantment
import org.spongepowered.api.item.inventory.Inventory
import org.spongepowered.api.item.inventory.InventoryArchetype
import org.spongepowered.api.item.inventory.ItemStack
import org.spongepowered.api.item.inventory.ItemStackGenerator
import org.spongepowered.api.item.merchant.TradeOffer
import org.spongepowered.api.item.merchant.TradeOfferGenerator
import org.spongepowered.api.item.recipe.crafting.Ingredient
import org.spongepowered.api.plugin.PluginContainer
import org.spongepowered.api.scheduler.Task
import org.spongepowered.api.scoreboard.Scoreboard
import org.spongepowered.api.scoreboard.Team
import org.spongepowered.api.scoreboard.objective.Objective
import org.spongepowered.api.service.pagination.PaginationList
import org.spongepowered.api.text.selector.Selector
import org.spongepowered.api.util.ban.Ban
import org.spongepowered.api.world.ChunkPreGenerate
import org.spongepowered.api.world.LocatableBlock
import org.spongepowered.api.world.World
import org.spongepowered.api.world.WorldArchetype
import org.spongepowered.api.world.WorldBorder
import org.spongepowered.api.world.biome.BiomeGenerationSettings
import org.spongepowered.api.world.biome.VirtualBiomeType
import org.spongepowered.api.world.explosion.Explosion
import org.spongepowered.api.world.gen.populator.BigMushroom
import org.spongepowered.api.world.gen.populator.BlockBlob
import org.spongepowered.api.world.gen.populator.Cactus
import org.spongepowered.api.world.gen.populator.ChorusFlower
import org.spongepowered.api.world.gen.populator.DeadBush
import org.spongepowered.api.world.gen.populator.DesertWell
import org.spongepowered.api.world.gen.populator.DoublePlant
import org.spongepowered.api.world.gen.populator.Dungeon
import org.spongepowered.api.world.gen.populator.EndIsland
import org.spongepowered.api.world.gen.populator.Flower
import org.spongepowered.api.world.gen.populator.Forest
import org.spongepowered.api.world.gen.populator.Fossil
import org.spongepowered.api.world.gen.populator.Glowstone
import org.spongepowered.api.world.gen.populator.IcePath
import org.spongepowered.api.world.gen.populator.IceSpike
import org.spongepowered.api.world.gen.populator.Lake
import org.spongepowered.api.world.gen.populator.Melon
import org.spongepowered.api.world.gen.populator.Mushroom
import org.spongepowered.api.world.gen.populator.NetherFire
import org.spongepowered.api.world.gen.populator.Ore
import org.spongepowered.api.world.gen.populator.Pumpkin
import org.spongepowered.api.world.gen.populator.RandomBlock
import org.spongepowered.api.world.gen.populator.RandomObject
import org.spongepowered.api.world.gen.populator.Reed
import org.spongepowered.api.world.gen.populator.SeaFloor
import org.spongepowered.api.world.gen.populator.Shrub
import org.spongepowered.api.world.gen.populator.Vine
import org.spongepowered.api.world.gen.populator.WaterLily
import org.spongepowered.api.world.schematic.Schematic

inline fun Advancement(fn: Advancement.Builder.() -> Unit): Advancement = Advancement.builder().apply(fn).build()
inline fun AdvancementCriterion(fn: AdvancementCriterion.Builder.() -> Unit): AdvancementCriterion = AdvancementCriterion.builder().apply(fn).build()
inline fun AdvancementTree(fn: AdvancementTree.Builder.() -> Unit): AdvancementTree = AdvancementTree.builder().apply(fn).build()
inline fun AttackLivingAITask(owner: Creature, fn: AttackLivingAITask.Builder.() -> Unit): AttackLivingAITask = AttackLivingAITask.builder().apply(fn).build(owner)
inline fun AvoidEntityAITask(owner: Creature, fn: AvoidEntityAITask.Builder.() -> Unit): AvoidEntityAITask = AvoidEntityAITask.builder().apply(fn).build(owner)
inline fun Ban(fn: Ban.Builder.() -> Unit): Ban = Ban.builder().apply(fn).build()
inline fun BigMushroom(fn: BigMushroom.Builder.() -> Unit): BigMushroom = BigMushroom.builder().apply(fn).build()
inline fun BiomeGenerationSettings(fn: BiomeGenerationSettings.Builder.() -> Unit): BiomeGenerationSettings = BiomeGenerationSettings.builder().apply(fn).build()
inline fun BlockBlob(fn: BlockBlob.Builder.() -> Unit): BlockBlob = BlockBlob.builder().apply(fn).build()
inline fun BlockDamageSource(fn: BlockDamageSource.Builder.() -> Unit): BlockDamageSource = BlockDamageSource.builder().apply(fn).build()
inline fun BlockHealingSource(fn: BlockHealingSource.Builder.() -> Unit): BlockHealingSource = BlockHealingSource.builder().apply(fn).build()
inline fun BlockSnapshot(fn: BlockSnapshot.Builder.() -> Unit): BlockSnapshot = BlockSnapshot.builder().apply(fn).build()
inline fun BlockState(fn: BlockState.Builder.() -> Unit): BlockState = BlockState.builder().apply(fn).build()
inline fun Cactus(fn: Cactus.Builder.() -> Unit): Cactus = Cactus.builder().apply(fn).build()
inline fun ChorusFlower(fn: ChorusFlower.Builder.() -> Unit): ChorusFlower = ChorusFlower.builder().apply(fn).build()
inline fun WorldBorder.newChunkPreGenerate(world: World, fn: ChunkPreGenerate.Builder.() -> Unit): ChunkPreGenerate = this.newChunkPreGenerate(world).apply(fn).start()
inline fun CommandFlags(vararg args: CommandElement, fn: CommandFlags.Builder.() -> Unit): CommandElement = GenericArguments.flags().apply(fn).buildWith(GenericArguments.seq(*args))
inline fun CommandSpec(fn: CommandSpec.Builder.() -> Unit): CommandSpec = CommandSpec.builder().apply(fn).build()
inline fun DamageSource(fn: DamageSource.Builder.() -> Unit): DamageSource = DamageSource.builder().apply(fn).build()
inline fun <reified M: DataManipulator<M, I>, I: ImmutableDataManipulator<I, M>> DataRegistration(plugin: PluginContainer, fn: DataRegistration.Builder<M, I>.() -> Unit): DataRegistration<M, I> = (DataRegistration.builder() as DataRegistration.Builder<M, I>).apply(fn).buildAndRegister(plugin)
inline fun DeadBush(fn: DeadBush.Builder.() -> Unit): DeadBush = DeadBush.builder().apply(fn).build()
inline fun DesertWell(fn: DesertWell.Builder.() -> Unit): DesertWell = DesertWell.builder().apply(fn).build()
inline fun DisplayInfo(fn: DisplayInfo.Builder.() -> Unit): DisplayInfo = DisplayInfo.builder().apply(fn).build()
inline fun DoublePlant(fn: DoublePlant.Builder.() -> Unit): DoublePlant = DoublePlant.builder().apply(fn).build()
inline fun Dungeon(fn: Dungeon.Builder.() -> Unit): Dungeon = Dungeon.builder().apply(fn).build()
inline fun Enchantment(fn: Enchantment.Builder.() -> Unit): Enchantment = Enchantment.builder().apply(fn).build()
inline fun EndIsland(fn: EndIsland.Builder.() -> Unit): EndIsland = EndIsland.builder().apply(fn).build()
inline fun EntityArchetype(fn: EntityArchetype.Builder.() -> Unit): EntityArchetype = EntityArchetype.builder().apply(fn).build()
inline fun EntityDamageSource(fn: EntityDamageSource.Builder.() -> Unit): EntityDamageSource = EntityDamageSource.builder().apply(fn).build()
inline fun EntityHealingSource(fn: EntityHealingSource.Builder.() -> Unit): EntityHealingSource = EntityHealingSource.builder().apply(fn).build()
inline fun EntitySnapshot(fn: EntitySnapshot.Builder.() -> Unit): EntitySnapshot = EntitySnapshot.builder().apply(fn).build()
inline fun <reified T> EventContextKey(fn: EventContextKey.Builder<T>.() -> Unit): EventContextKey<T> = EventContextKey.builder(T::class.java).apply(fn).build()
inline fun Explosion(fn: Explosion.Builder.() -> Unit): Explosion = Explosion.builder().apply(fn).build()
inline fun FallingBlockDamageSource(fn: FallingBlockDamageSource.Builder.() -> Unit): FallingBlockDamageSource = FallingBlockDamageSource.builder().apply(fn).build()
inline fun <T: FilteredTriggerConfiguration> FilteredTrigger(fn: FilteredTrigger.Builder<T>.() -> Unit): FilteredTrigger<T> = (FilteredTrigger.builder() as FilteredTrigger.Builder<T>).apply(fn).build()
inline fun FindNearestAttackableTargetAITask(owner: Creature, fn: FindNearestAttackableTargetAITask.Builder.() -> Unit): FindNearestAttackableTargetAITask = FindNearestAttackableTargetAITask.builder().apply(fn).build(owner)
inline fun FireworkEffect(fn: FireworkEffect.Builder.() -> Unit): FireworkEffect = FireworkEffect.builder().apply(fn).build()
inline fun Flower(fn: Flower.Builder.() -> Unit): Flower = Flower.builder().apply(fn).build()
inline fun FluidStack(fn: FluidStack.Builder.() -> Unit): FluidStack = FluidStack.builder().apply(fn).build()
inline fun FluidStackSnapshot(fn: FluidStackSnapshot.Builder.() -> Unit): FluidStackSnapshot = FluidStackSnapshot.builder().apply(fn).build()
inline fun Forest(fn: Forest.Builder.() -> Unit): Forest = Forest.builder().apply(fn).build()
inline fun Fossil(fn: Fossil.Builder.() -> Unit): Fossil = Fossil.builder().apply(fn).build()
inline fun Glowstone(fn: Glowstone.Builder.() -> Unit): Glowstone = Glowstone.builder().apply(fn).build()
inline fun HealingSource(fn: HealingSource.Builder.() -> Unit): HealingSource = HealingSource.builder().apply(fn).build()
inline fun IcePath(fn: IcePath.Builder.() -> Unit): IcePath = IcePath.builder().apply(fn).build()
inline fun IceSpike(fn: IceSpike.Builder.() -> Unit): IceSpike = IceSpike.builder().apply(fn).build()
inline fun IndirectEntityDamageSource(fn: IndirectEntityDamageSource.Builder.() -> Unit): IndirectEntityDamageSource = IndirectEntityDamageSource.builder().apply(fn).build()
inline fun IndirectEntityHealingSource(fn: IndirectEntityHealingSource.Builder.() -> Unit): IndirectEntityHealingSource = IndirectEntityHealingSource.builder().apply(fn).build()
inline fun Ingredient(fn: Ingredient.Builder.() -> Unit): Ingredient = Ingredient.builder().apply(fn).build()
inline fun Inventory(plugin: Any, fn: Inventory.Builder.() -> Unit): Inventory = Inventory.builder().apply(fn).build(plugin)
inline fun InventoryArchetype(id: String, name: String, fn: InventoryArchetype.Builder.() -> Unit): InventoryArchetype = InventoryArchetype.builder().apply(fn).build(id, name)
inline fun ItemStack(fn: ItemStack.Builder.() -> Unit): ItemStack = ItemStack.builder().apply(fn).build()
inline fun ItemStackGenerator(fn: ItemStackGenerator.Builder.() -> Unit): ItemStackGenerator = ItemStackGenerator.builder().apply(fn).build()
inline fun <E, V: BaseValue<E>> Key(fn: Key.Builder<E, V>.() -> Unit): Key<V> = (Key.builder() as Key.Builder<E, V>).apply(fn).build()
inline fun Lake(fn: Lake.Builder.() -> Unit): Lake = Lake.builder().apply(fn).build()
inline fun LocatableBlock(fn: LocatableBlock.Builder.() -> Unit): LocatableBlock = LocatableBlock.builder().apply(fn).build()
inline fun LookIdleAITask(owner: Agent, fn: LookIdleAITask.Builder.() -> Unit): LookIdleAITask = LookIdleAITask.builder().apply(fn).build(owner)
inline fun Melon(fn: Melon.Builder.() -> Unit): Melon = Melon.builder().apply(fn).build()
inline fun Mushroom(fn: Mushroom.Builder.() -> Unit): Mushroom = Mushroom.builder().apply(fn).build()
inline fun NetherFire(fn: NetherFire.Builder.() -> Unit): NetherFire = NetherFire.builder().apply(fn).build()
inline fun Objective(fn: Objective.Builder.() -> Unit): Objective = Objective.builder().apply(fn).build()
inline fun Ore(fn: Ore.Builder.() -> Unit): Ore = Ore.builder().apply(fn).build()
inline fun PaginationList(fn: PaginationList.Builder.() -> Unit): PaginationList = PaginationList.builder().apply(fn).build()
inline fun ParticleEffect(fn: ParticleEffect.Builder.() -> Unit): ParticleEffect = ParticleEffect.builder().apply(fn).build()
inline fun PatternLayer(fn: PatternLayer.Builder.() -> Unit): PatternLayer = GameRegistry.createBuilder(PatternLayer.Builder::class.java).apply(fn).build()
inline fun PotionEffect(fn: PotionEffect.Builder.() -> Unit): PotionEffect = PotionEffect.builder().apply(fn).build()
inline fun Pumpkin(fn: Pumpkin.Builder.() -> Unit): Pumpkin = Pumpkin.builder().apply(fn).build()
inline fun RandomBlock(fn: RandomBlock.Builder.() -> Unit): RandomBlock = RandomBlock.builder().apply(fn).build()
inline fun RandomObject(fn: RandomObject.Builder.() -> Unit): RandomObject = RandomObject.builder().apply(fn).build()
inline fun RangeAgentAITask(owner: Ranger, fn: RangeAgentAITask.Builder.() -> Unit): RangeAgentAITask = RangeAgentAITask.builder().apply(fn).build(owner)
inline fun Reed(fn: Reed.Builder.() -> Unit): Reed = Reed.builder().apply(fn).build()
inline fun RunAroundLikeCrazyAITask(owner: RideableHorse, fn: RunAroundLikeCrazyAITask.Builder.() -> Unit): RunAroundLikeCrazyAITask = RunAroundLikeCrazyAITask.builder().apply(fn).build(owner)
inline fun Schematic(fn: Schematic.Builder.() -> Unit): Schematic = Schematic.builder().apply(fn).build()
inline fun ScoreAdvancementCriterion(fn: ScoreAdvancementCriterion.Builder.() -> Unit): ScoreAdvancementCriterion = ScoreAdvancementCriterion.builder().apply(fn).build()
inline fun Scoreboard(fn: Scoreboard.Builder.() -> Unit): Scoreboard = Scoreboard.builder().apply(fn).build()
inline fun SeaFloor(fn: SeaFloor.Builder.() -> Unit): SeaFloor = SeaFloor.builder().apply(fn).build()
inline fun Selector(fn: Selector.Builder.() -> Unit): Selector = Selector.builder().apply(fn).build()
inline fun ServerBossBar(fn: ServerBossBar.Builder.() -> Unit): ServerBossBar = ServerBossBar.builder().apply(fn).build()
inline fun Shrub(fn: Shrub.Builder.() -> Unit): Shrub = Shrub.builder().apply(fn).build()
inline fun SoundType(id: String, fn: SoundType.Builder.() -> Unit): SoundType = SoundType.builder().apply(fn).build(id)
inline fun SwimmingAITask(owner: Agent, fn: SwimmingAITask.Builder.() -> Unit): SwimmingAITask = SwimmingAITask.builder().apply(fn).build(owner)
inline fun TabListEntry(fn: TabListEntry.Builder.() -> Unit): TabListEntry = TabListEntry.builder().apply(fn).build()
inline fun Task(plugin: Any, fn: Task.Builder.() -> Unit): Task = Task.builder().apply(fn).submit(plugin)
inline fun Team(fn: Team.Builder.() -> Unit): Team = Team.builder().apply(fn).build()
inline fun TileEntityArchetype(fn: TileEntityArchetype.Builder.() -> Unit): TileEntityArchetype = TileEntityArchetype.builder().apply(fn).build()
inline fun TradeOffer(fn: TradeOffer.Builder.() -> Unit): TradeOffer = TradeOffer.builder().apply(fn).build()
inline fun TradeOfferGenerator(fn: TradeOfferGenerator.Builder.() -> Unit): TradeOfferGenerator = TradeOfferGenerator.builder().apply(fn).build()
inline fun <C: FilteredTriggerConfiguration> Trigger(fn: Trigger.Builder<C>.() -> Unit): Trigger<C> = (Trigger.builder() as Trigger.Builder<C>).apply(fn).build()
inline fun Vine(fn: Vine.Builder.() -> Unit): Vine = Vine.builder().apply(fn).build()
inline fun VirtualBiomeType(id: String, fn: VirtualBiomeType.Builder.() -> Unit): VirtualBiomeType = VirtualBiomeType.builder().apply(fn).build(id)
inline fun WanderAITask(owner: Creature, fn: WanderAITask.Builder.() -> Unit): WanderAITask = WanderAITask.builder().apply(fn).build(owner)
inline fun WatchClosestAITask(owner: Agent, fn: WatchClosestAITask.Builder.() -> Unit): WatchClosestAITask = WatchClosestAITask.builder().apply(fn).build(owner)
inline fun WaterLily(fn: WaterLily.Builder.() -> Unit): WaterLily = WaterLily.builder().apply(fn).build()
inline fun WorldArchetype(id: String, name: String, fn: WorldArchetype.Builder.() -> Unit): WorldArchetype = WorldArchetype.builder().apply(fn).build(id, name)
inline fun WorldBorder(fn: WorldBorder.Builder.() -> Unit): WorldBorder = WorldBorder.builder().apply(fn).build()
