package flavor.pie.kludge

import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.data.key.Keys
import org.spongepowered.api.entity.Entity
import org.spongepowered.api.entity.EntityType
import org.spongepowered.api.item.inventory.ItemStackSnapshot
import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.text.LiteralText
import org.spongepowered.api.text.ScoreText
import org.spongepowered.api.text.SelectorText
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextRepresentable
import org.spongepowered.api.text.TranslatableText
import org.spongepowered.api.text.action.ClickAction
import org.spongepowered.api.text.action.HoverAction
import org.spongepowered.api.text.action.ShiftClickAction
import org.spongepowered.api.text.action.TextActions
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextFormat
import org.spongepowered.api.text.format.TextStyle
import org.spongepowered.api.text.format.TextStyles
import org.spongepowered.api.text.selector.Selector
import org.spongepowered.api.text.serializer.TextSerializer
import org.spongepowered.api.text.serializer.TextSerializers
import org.spongepowered.api.text.translation.Translatable
import org.spongepowered.api.text.translation.Translation
import java.net.URL
import java.util.UUID
import java.util.function.Consumer

/**
 * @see TextRepresentable.toText
 */
operator fun TextRepresentable.not(): Text = this.toText()

/**
 * @see Text.of
 */
operator fun String.not(): LiteralText = Text.of(this)

/**
 * @see Text.of
 */
fun String.text(): LiteralText = Text.of(this)

/**
 * @see Text.builder
 */
fun String.textBuilder(): LiteralText.Builder = Text.builder(this)


/**
 * @see Text.Builder.color
 */
fun String.color(color: TextColor): LiteralText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun String.format(format: TextFormat): LiteralText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun String.style(vararg style: TextStyle): LiteralText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun String.bold(): LiteralText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun String.italic(): LiteralText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun String.underline(): LiteralText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun String.strikethrough(): LiteralText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun String.obfuscated(): LiteralText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun String.aqua(): LiteralText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun String.black(): LiteralText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun String.blue(): LiteralText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun String.darkAqua(): LiteralText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun String.darkBlue(): LiteralText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun String.darkGray(): LiteralText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun String.darkGreen(): LiteralText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun String.darkPurple(): LiteralText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun String.darkRed(): LiteralText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun String.gold(): LiteralText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun String.gray(): LiteralText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun String.green(): LiteralText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun String.lightPurple(): LiteralText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun String.red(): LiteralText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun String.resetColor(): LiteralText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun String.white(): LiteralText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun String.yellow(): LiteralText = this.color(TextColors.YELLOW)

/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun String.onClick(clickAction: ClickAction<*>): LiteralText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun String.onHover(hoverAction: HoverAction<*>): LiteralText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun String.onShiftClick(shiftClickAction: ShiftClickAction<*>): LiteralText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun String.onClick(url: URL): LiteralText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun String.onClick(command: String): LiteralText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun String.onClick(callback: Consumer<CommandSource>): LiteralText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun String.onClick(page: Int): LiteralText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun String.onHover(text: Text): LiteralText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun String.onHover(item: ItemStackSnapshot): LiteralText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun String.onHover(entity: Entity): LiteralText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun String.onHover(entity: Entity, name: String): LiteralText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun String.onHover(entity: UUID, name: String, type: EntityType?): LiteralText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun String.onHover(entity: HoverAction.ShowEntity.Ref): LiteralText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun String.onShiftClick(text: String): LiteralText = this.onShiftClick(TextActions.insertText(text))

/**
 * Deserializes this text using [TextSerializers.JSON].
 * @see TextSerializer.deserialize
 */
fun String.textByJson(): Text = TextSerializers.JSON.deserialize(this)

/**
 * Deserializes this text using [TextSerializers.FORMATTING_CODE].
 * @see TextSerializer.deserialize
 */
fun String.textByFormat(): Text = TextSerializers.FORMATTING_CODE.deserialize(this)

/**
 * Deserializes this text using [TextSerializers.formattingCode].
 * @see TextSerializer.deserialize
 */
fun String.textByFormat(c: Char): Text = TextSerializers.formattingCode(c).deserialize(this)

/**
 * @see Text.of
 */
operator fun Char.not(): LiteralText = Text.of(this)

/**
 * @see Text.of
 */
fun Char.text(): LiteralText = Text.of(this)
/**
 * @see Text.builder
 */
fun Char.textBuilder(): LiteralText.Builder = Text.builder(this)



/**
 * @see Text.Builder.color
 */
fun Char.color(color: TextColor): LiteralText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun Char.format(format: TextFormat): LiteralText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun Char.style(vararg style: TextStyle): LiteralText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Char.bold(): LiteralText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Char.italic(): LiteralText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Char.underline(): LiteralText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Char.obfuscated(): LiteralText = Text.builder(this).style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Char.aqua(): LiteralText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Char.black(): LiteralText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Char.blue(): LiteralText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Char.darkAqua(): LiteralText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Char.darkBlue(): LiteralText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Char.darkGray(): LiteralText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Char.darkGreen(): LiteralText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Char.darkPurple(): LiteralText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Char.darkRed(): LiteralText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Char.gold(): LiteralText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Char.gray(): LiteralText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Char.green(): LiteralText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Char.lightPurple(): LiteralText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Char.red(): LiteralText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Char.resetColor(): LiteralText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Char.white(): LiteralText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Char.yellow(): LiteralText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Char.onClick(clickAction: ClickAction<*>): LiteralText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Char.onHover(hoverAction: HoverAction<*>): LiteralText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Char.onShiftClick(shiftClickAction: ShiftClickAction<*>): LiteralText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Char.onClick(url: URL): LiteralText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Char.onClick(command: String): LiteralText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Char.onClick(callback: Consumer<CommandSource>): LiteralText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Char.onClick(page: Int): LiteralText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Char.onHover(text: Text): LiteralText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Char.onHover(item: ItemStackSnapshot): LiteralText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Char.onHover(entity: Entity): LiteralText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Char.onHover(entity: Entity, name: String): LiteralText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Char.onHover(entity: UUID, name: String, type: EntityType?): LiteralText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Char.onHover(entity: HoverAction.ShowEntity.Ref): LiteralText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Char.onShiftClick(text: String): LiteralText = this.onShiftClick(TextActions.insertText(text))

/**
 * @see Text.of
 */
operator fun Translatable.not(): TranslatableText = Text.of(this)

/**
 * @see Text.of
 */
fun Translatable.text(): TranslatableText = Text.of(this)

/**
 * @see Text.builder
 */
fun Translatable.textBuilder(): TranslatableText.Builder = Text.builder(this)



/**
 * @see Text.Builder.color
 */
fun Translatable.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun Translatable.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun Translatable.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Translatable.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Translatable.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Translatable.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Translatable.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun Translatable.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Translatable.aqua(): TranslatableText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Translatable.black(): TranslatableText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Translatable.blue(): TranslatableText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Translatable.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Translatable.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Translatable.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Translatable.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Translatable.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Translatable.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Translatable.gold(): TranslatableText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Translatable.gray(): TranslatableText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Translatable.green(): TranslatableText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Translatable.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Translatable.red(): TranslatableText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Translatable.resetColor(): TranslatableText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Translatable.white(): TranslatableText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Translatable.yellow(): TranslatableText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Translatable.onClick(clickAction: ClickAction<*>): TranslatableText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(hoverAction: HoverAction<*>): TranslatableText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Translatable.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Translatable.onClick(url: URL): TranslatableText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Translatable.onClick(command: String): TranslatableText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Translatable.onClick(callback: Consumer<CommandSource>): TranslatableText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Translatable.onClick(page: Int): TranslatableText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(text: Text): TranslatableText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(item: ItemStackSnapshot): TranslatableText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(entity: Entity): TranslatableText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(entity: Entity, name: String): TranslatableText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(entity: UUID, name: String, type: EntityType?): TranslatableText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translatable.onHover(entity: HoverAction.ShowEntity.Ref): TranslatableText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Translatable.onShiftClick(text: String): TranslatableText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.of
 */
operator fun Translation.not(): TranslatableText = Text.of(this)

/**
 * @see Text.of
 */
fun Translation.text(): TranslatableText = Text.of(this)

/**
 * @see Text.builder
 */
fun Translation.textBuilder(): TranslatableText.Builder = Text.builder(this)



/**
 * @see Text.Builder.color
 */
fun Translation.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun Translation.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun Translation.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Translation.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Translation.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Translation.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Translation.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun Translation.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Translation.aqua(): TranslatableText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Translation.black(): TranslatableText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Translation.blue(): TranslatableText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Translation.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Translation.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Translation.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Translation.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Translation.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Translation.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Translation.gold(): TranslatableText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Translation.gray(): TranslatableText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Translation.green(): TranslatableText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Translation.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Translation.red(): TranslatableText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Translation.resetColor(): TranslatableText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Translation.white(): TranslatableText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Translation.yellow(): TranslatableText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Translation.onClick(clickAction: ClickAction<*>): TranslatableText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Translation.onHover(hoverAction: HoverAction<*>): TranslatableText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Translation.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Translation.onClick(url: URL): TranslatableText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Translation.onClick(command: String): TranslatableText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Translation.onClick(callback: Consumer<CommandSource>): TranslatableText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Translation.onClick(page: Int): TranslatableText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(text: Text): TranslatableText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(item: ItemStackSnapshot): TranslatableText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(entity: Entity): TranslatableText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(entity: Entity, name: String): TranslatableText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(entity: UUID, name: String, type: EntityType?): TranslatableText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Translation.onHover(entity: HoverAction.ShowEntity.Ref): TranslatableText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Translation.onShiftClick(text: String): TranslatableText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.of
 */
operator fun Score.not(): ScoreText = Text.of(this)

/**
 * @see Text.of
 */
fun Score.text(): ScoreText = Text.of(this)

/**
 * @see Text.builder
 */
fun Score.textBuilder(): ScoreText.Builder = Text.builder(this)



/**
 * @see Text.Builder.color
 */
fun Score.color(color: TextColor): ScoreText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun Score.format(format: TextFormat): ScoreText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun Score.style(vararg style: TextStyle): ScoreText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Score.bold(): ScoreText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Score.italic(): ScoreText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Score.underline(): ScoreText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Score.strikethrough(): ScoreText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun Score.obfuscated(): ScoreText = Text.builder(this).style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Score.aqua(): ScoreText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Score.black(): ScoreText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Score.blue(): ScoreText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Score.darkAqua(): ScoreText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Score.darkBlue(): ScoreText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Score.darkGray(): ScoreText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Score.darkGreen(): ScoreText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Score.darkPurple(): ScoreText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Score.darkRed(): ScoreText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Score.gold(): ScoreText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Score.gray(): ScoreText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Score.green(): ScoreText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Score.lightPurple(): ScoreText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Score.red(): ScoreText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Score.resetColor(): ScoreText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Score.white(): ScoreText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Score.yellow(): ScoreText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Score.onClick(clickAction: ClickAction<*>): ScoreText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Score.onHover(hoverAction: HoverAction<*>): ScoreText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Score.onShiftClick(shiftClickAction: ShiftClickAction<*>): ScoreText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Score.onClick(url: URL): ScoreText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Score.onClick(command: String): ScoreText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Score.onClick(callback: Consumer<CommandSource>): ScoreText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Score.onClick(page: Int): ScoreText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Score.onHover(text: Text): ScoreText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Score.onHover(item: ItemStackSnapshot): ScoreText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Score.onHover(entity: Entity): ScoreText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Score.onHover(entity: Entity, name: String): ScoreText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Score.onHover(entity: UUID, name: String, type: EntityType?): ScoreText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Score.onHover(entity: HoverAction.ShowEntity.Ref): ScoreText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Score.onShiftClick(text: String): ScoreText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.of
 */
operator fun Selector.not(): SelectorText = Text.of(this)

/**
 * @see Text.of
 */
fun Selector.text(): SelectorText = Text.of(this)

/**
 * @see Text.builder
 */
fun Selector.textBuilder(): SelectorText.Builder = Text.builder(this)



/**
 * @see Text.Builder.color
 */
fun Selector.color(color: TextColor): SelectorText = Text.builder(this).color(color).build()

/**
 * @see Text.Builder.format
 */
fun Selector.format(format: TextFormat): SelectorText = Text.builder(this).format(format).build()

/**
 * @see Text.Builder.style
 */
fun Selector.style(vararg style: TextStyle): SelectorText = Text.builder(this).style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Selector.bold(): SelectorText = Text.builder(this).style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Selector.italic(): SelectorText = Text.builder(this).style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Selector.underline(): SelectorText = Text.builder(this).style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Selector.strikethrough(): SelectorText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun Selector.obfuscated(): SelectorText = Text.builder(this).style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Selector.aqua(): SelectorText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Selector.black(): SelectorText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Selector.blue(): SelectorText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Selector.darkAqua(): SelectorText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Selector.darkBlue(): SelectorText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Selector.darkGray(): SelectorText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Selector.darkGreen(): SelectorText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Selector.darkPurple(): SelectorText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Selector.darkRed(): SelectorText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Selector.gold(): SelectorText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Selector.gray(): SelectorText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Selector.green(): SelectorText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Selector.lightPurple(): SelectorText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Selector.red(): SelectorText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Selector.resetColor(): SelectorText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Selector.white(): SelectorText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Selector.yellow(): SelectorText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Selector.onClick(clickAction: ClickAction<*>): SelectorText = Text.builder(this).onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Selector.onHover(hoverAction: HoverAction<*>): SelectorText = Text.builder(this).onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Selector.onShiftClick(shiftClickAction: ShiftClickAction<*>): SelectorText = Text.builder(this).onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Selector.onClick(url: URL): SelectorText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Selector.onClick(command: String): SelectorText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Selector.onClick(callback: Consumer<CommandSource>): SelectorText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Selector.onClick(page: Int): SelectorText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(text: Text): SelectorText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(item: ItemStackSnapshot): SelectorText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(entity: Entity): SelectorText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(entity: Entity, name: String): SelectorText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(entity: UUID, name: String, type: EntityType?): SelectorText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Selector.onHover(entity: HoverAction.ShowEntity.Ref): SelectorText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Selector.onShiftClick(text: String): SelectorText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.of
 */
operator fun Translation.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

/**
 * @see Text.of
 */
operator fun Translatable.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

/**
 * @see Text.concat
 */
operator fun Text.plus(that: Text): Text = this.concat(that)

/**
 * @see Text.concat
 * @see String.text
 */
operator fun Text.plus(that: String): Text = this.concat(!that)

/**
 * @see Text.concat
 * @see Selector.text
 */
operator fun Text.plus(that: Selector): Text = this.concat(!that)

/**
 * @see Text.concat
 * @see Translatable.text
 */
operator fun Text.plus(that: Translatable): Text = this.concat(!that)

/**
 * @see Text.concat
 * @see Translation.text
 */
operator fun Text.plus(that: Translation): Text = this.concat(!that)

/**
 * @see Text.concat
 * @see Score.text
 */
operator fun Text.plus(that: Score): Text = this.concat(!that)

/**
 * @see Text.concat
 * @see TextRepresentable.toText
 */
operator fun Text.plus(that: TextRepresentable): Text = this.concat(!that)

/**
 * @see Text.Builder.append
 */
operator fun Text.Builder.plus(that: Text): Text.Builder = this.append(that)

/**
 * @see Text.Builder.append
 */
operator fun Text.Builder.plus(that: Collection<Text>): Text.Builder = this.append(that)

/**
 * @see Text.Builder.append
 */
operator fun Text.Builder.plus(that: Iterator<Text>): Text.Builder = this.append(that)

/**
 * @see Text.Builder.append
 */
operator fun Text.Builder.plus(that: Iterable<Text>): Text.Builder = this.append(that)

/**
 * @see Text.Builder.remove
 */
operator fun Text.Builder.minus(that: Text): Text.Builder = this.remove(that)

/**
 * @see Text.Builder.remove
 */
operator fun Text.Builder.minus(that: Collection<Text>): Text.Builder = this.remove(that)

/**
 * @see Text.Builder.remove
 */
operator fun Text.Builder.minus(that: Iterator<Text>): Text.Builder = this.remove(that)

/**
 * @see Text.Builder.remove
 */
operator fun Text.Builder.minus(that: Iterable<Text>): Text.Builder = this.remove(that)

/**
 * Rebuilds this text, applying [that].
 */
operator fun Text.plus(that: Text.Builder.() -> Unit): Text = this.toBuilder().apply(that).build()

/**
 * Rebuilds this text, applying [that].
 */
operator fun LiteralText.plus(that: LiteralText.Builder.() -> Unit): LiteralText = this.toBuilder().apply(that).build()

/**
 * Rebuilds this text, applying [that].
 */
operator fun TranslatableText.plus(that: TranslatableText.Builder.() -> Unit): TranslatableText = this.toBuilder().apply(that).build()

/**
 * Rebuilds this text, applying [that].
 */
operator fun ScoreText.plus(that: ScoreText.Builder.() -> Unit): ScoreText = this.toBuilder().apply(that).build()

/**
 * Rebuilds this text, applying [that].
 */
operator fun SelectorText.plus(that: SelectorText.Builder.() -> Unit): SelectorText = this.toBuilder().apply(that).build()


/**
 * @see Text.Builder.color
 */
fun Text.color(color: TextColor): Text = this.toBuilder().color(color).build()

/**
 * @see Text.Builder.format
 */
fun Text.format(format: TextFormat): Text = this.toBuilder().format(format).build()

/**
 * @see Text.Builder.style
 */
fun Text.style(vararg style: TextStyle): Text = this.toBuilder().style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun Text.bold(): Text = this.toBuilder().style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun Text.italic(): Text = this.toBuilder().style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun Text.underline(): Text = this.toBuilder().style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun Text.strikethrough(): Text = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun Text.obfuscated(): Text = this.toBuilder().style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun Text.aqua(): Text = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun Text.black(): Text = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun Text.blue(): Text = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun Text.darkAqua(): Text = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun Text.darkBlue(): Text = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun Text.darkGray(): Text = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun Text.darkGreen(): Text = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun Text.darkPurple(): Text = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun Text.darkRed(): Text = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun Text.gold(): Text = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun Text.gray(): Text = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun Text.green(): Text = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun Text.lightPurple(): Text = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun Text.red(): Text = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun Text.resetColor(): Text = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun Text.white(): Text = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun Text.yellow(): Text = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun Text.onClick(clickAction: ClickAction<*>): Text = toBuilder().onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun Text.onHover(hoverAction: HoverAction<*>): Text = toBuilder().onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun Text.onShiftClick(shiftClickAction: ShiftClickAction<*>): Text = toBuilder().onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun Text.onClick(url: URL): Text = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun Text.onClick(command: String): Text = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun Text.onClick(callback: Consumer<CommandSource>): Text = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun Text.onClick(page: Int): Text = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun Text.onHover(text: Text): Text = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun Text.onHover(item: ItemStackSnapshot): Text = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Text.onHover(entity: Entity): Text = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Text.onHover(entity: Entity, name: String): Text = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Text.onHover(entity: UUID, name: String, type: EntityType?): Text =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun Text.onHover(entity: HoverAction.ShowEntity.Ref): Text = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun Text.onShiftClick(text: String): Text = this.onShiftClick(TextActions.insertText(text))



/**
 * @see Text.Builder.color
 */
fun LiteralText.color(color: TextColor): LiteralText = this.toBuilder().color(color).build()

/**
 * @see Text.Builder.format
 */
fun LiteralText.format(format: TextFormat): LiteralText = this.toBuilder().format(format).build()

/**
 * @see Text.Builder.style
 */
fun LiteralText.style(vararg style: TextStyle): LiteralText = this.toBuilder().style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun LiteralText.bold(): LiteralText = this.toBuilder().style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun LiteralText.italic(): LiteralText = this.toBuilder().style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun LiteralText.underline(): LiteralText = this.toBuilder().style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun LiteralText.strikethrough(): LiteralText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun LiteralText.obfuscated(): LiteralText = this.toBuilder().style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun LiteralText.aqua(): LiteralText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun LiteralText.black(): LiteralText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun LiteralText.blue(): LiteralText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun LiteralText.darkAqua(): LiteralText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun LiteralText.darkBlue(): LiteralText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun LiteralText.darkGray(): LiteralText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun LiteralText.darkGreen(): LiteralText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun LiteralText.darkPurple(): LiteralText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun LiteralText.darkRed(): LiteralText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun LiteralText.gold(): LiteralText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun LiteralText.gray(): LiteralText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun LiteralText.green(): LiteralText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun LiteralText.lightPurple(): LiteralText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun LiteralText.red(): LiteralText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun LiteralText.resetColor(): LiteralText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun LiteralText.white(): LiteralText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun LiteralText.yellow(): LiteralText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun LiteralText.onClick(clickAction: ClickAction<*>): LiteralText = toBuilder().onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(hoverAction: HoverAction<*>): LiteralText = toBuilder().onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun LiteralText.onShiftClick(shiftClickAction: ShiftClickAction<*>): LiteralText = toBuilder().onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun LiteralText.onClick(url: URL): LiteralText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun LiteralText.onClick(command: String): LiteralText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun LiteralText.onClick(callback: Consumer<CommandSource>): LiteralText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun LiteralText.onClick(page: Int): LiteralText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(text: Text): LiteralText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(item: ItemStackSnapshot): LiteralText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(entity: Entity): LiteralText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(entity: Entity, name: String): LiteralText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(entity: UUID, name: String, type: EntityType?): LiteralText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun LiteralText.onHover(entity: HoverAction.ShowEntity.Ref): LiteralText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun LiteralText.onShiftClick(text: String): LiteralText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.Builder.color
 */
fun TranslatableText.color(color: TextColor): TranslatableText = this.toBuilder().color(color).build()

/**
 * @see Text.Builder.format
 */
fun TranslatableText.format(format: TextFormat): TranslatableText = this.toBuilder().format(format).build()

/**
 * @see Text.Builder.style
 */
fun TranslatableText.style(vararg style: TextStyle): TranslatableText = this.toBuilder().style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun TranslatableText.bold(): TranslatableText = this.toBuilder().style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun TranslatableText.italic(): TranslatableText = this.toBuilder().style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun TranslatableText.underline(): TranslatableText = this.toBuilder().style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun TranslatableText.strikethrough(): TranslatableText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun TranslatableText.obfuscated(): TranslatableText = this.toBuilder().style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun TranslatableText.aqua(): TranslatableText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun TranslatableText.black(): TranslatableText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun TranslatableText.blue(): TranslatableText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun TranslatableText.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun TranslatableText.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun TranslatableText.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun TranslatableText.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun TranslatableText.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun TranslatableText.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun TranslatableText.gold(): TranslatableText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun TranslatableText.gray(): TranslatableText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun TranslatableText.green(): TranslatableText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun TranslatableText.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun TranslatableText.red(): TranslatableText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun TranslatableText.resetColor(): TranslatableText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun TranslatableText.white(): TranslatableText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun TranslatableText.yellow(): TranslatableText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun TranslatableText.onClick(clickAction: ClickAction<*>): TranslatableText = toBuilder().onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(hoverAction: HoverAction<*>): TranslatableText = toBuilder().onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun TranslatableText.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = toBuilder().onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun TranslatableText.onClick(url: URL): TranslatableText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun TranslatableText.onClick(command: String): TranslatableText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun TranslatableText.onClick(callback: Consumer<CommandSource>): TranslatableText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun TranslatableText.onClick(page: Int): TranslatableText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(text: Text): TranslatableText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(item: ItemStackSnapshot): TranslatableText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(entity: Entity): TranslatableText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(entity: Entity, name: String): TranslatableText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(entity: UUID, name: String, type: EntityType?): TranslatableText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun TranslatableText.onHover(entity: HoverAction.ShowEntity.Ref): TranslatableText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun TranslatableText.onShiftClick(text: String): TranslatableText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.Builder.color
 */
fun SelectorText.color(color: TextColor): SelectorText = this.toBuilder().color(color).build()

/**
 * @see Text.Builder.format
 */
fun SelectorText.format(format: TextFormat): SelectorText = this.toBuilder().format(format).build()

/**
 * @see Text.Builder.style
 */
fun SelectorText.style(vararg style: TextStyle): SelectorText = this.toBuilder().style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun SelectorText.bold(): SelectorText = this.toBuilder().style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun SelectorText.italic(): SelectorText = this.toBuilder().style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun SelectorText.underline(): SelectorText = this.toBuilder().style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun SelectorText.strikethrough(): SelectorText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun SelectorText.obfuscated(): SelectorText = this.toBuilder().style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun SelectorText.aqua(): SelectorText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun SelectorText.black(): SelectorText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun SelectorText.blue(): SelectorText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun SelectorText.darkAqua(): SelectorText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun SelectorText.darkBlue(): SelectorText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun SelectorText.darkGray(): SelectorText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun SelectorText.darkGreen(): SelectorText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun SelectorText.darkPurple(): SelectorText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun SelectorText.darkRed(): SelectorText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun SelectorText.gold(): SelectorText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun SelectorText.gray(): SelectorText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun SelectorText.green(): SelectorText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun SelectorText.lightPurple(): SelectorText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun SelectorText.red(): SelectorText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun SelectorText.resetColor(): SelectorText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun SelectorText.white(): SelectorText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun SelectorText.yellow(): SelectorText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun SelectorText.onClick(clickAction: ClickAction<*>): SelectorText = toBuilder().onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(hoverAction: HoverAction<*>): SelectorText = toBuilder().onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun SelectorText.onShiftClick(shiftClickAction: ShiftClickAction<*>): SelectorText = toBuilder().onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun SelectorText.onClick(url: URL): SelectorText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun SelectorText.onClick(command: String): SelectorText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun SelectorText.onClick(callback: Consumer<CommandSource>): SelectorText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun SelectorText.onClick(page: Int): SelectorText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(text: Text): SelectorText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(item: ItemStackSnapshot): SelectorText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(entity: Entity): SelectorText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(entity: Entity, name: String): SelectorText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(entity: UUID, name: String, type: EntityType?): SelectorText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun SelectorText.onHover(entity: HoverAction.ShowEntity.Ref): SelectorText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun SelectorText.onShiftClick(text: String): SelectorText = this.onShiftClick(TextActions.insertText(text))


/**
 * @see Text.Builder.color
 */
fun ScoreText.color(color: TextColor): ScoreText = this.toBuilder().color(color).build()

/**
 * @see Text.Builder.format
 */
fun ScoreText.format(format: TextFormat): ScoreText = this.toBuilder().format(format).build()

/**
 * @see Text.Builder.style
 */
fun ScoreText.style(vararg style: TextStyle): ScoreText = this.toBuilder().style(*style).build()

/**
 * Styles this text [TextStyles.BOLD].
 * @see Text.Builder.style
 */
fun ScoreText.bold(): ScoreText = this.toBuilder().style(TextStyles.BOLD).build()

/**
 * Styles this text [TextStyles.ITALIC].
 * @see Text.Builder.style
 */
fun ScoreText.italic(): ScoreText = this.toBuilder().style(TextStyles.ITALIC).build()

/**
 * Styles this text [TextStyles.UNDERLINE].
 * @see Text.Builder.style
 */
fun ScoreText.underline(): ScoreText = this.toBuilder().style(TextStyles.UNDERLINE).build()

/**
 * Styles this text [TextStyles.STRIKETHROUGH].
 * @see Text.Builder.style
 */
fun ScoreText.strikethrough(): ScoreText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

/**
 * Styles this text [TextStyles.OBFUSCATED].
 * @see Text.Builder.style
 */
fun ScoreText.obfuscated(): ScoreText = this.toBuilder().style(TextStyles.OBFUSCATED).build()


/**
 * Colors this text [TextColors.AQUA].
 * @see Text.Builder.color
 */
fun ScoreText.aqua(): ScoreText = this.color(TextColors.AQUA)

/**
 * Colors this text [TextColors.BLACK].
 * @see Text.Builder.color
 */
fun ScoreText.black(): ScoreText = this.color(TextColors.BLACK)

/**
 * Colors this text [TextColors.BLUE].
 * @see Text.Builder.color
 */
fun ScoreText.blue(): ScoreText = this.color(TextColors.BLUE)

/**
 * Colors this text [TextColors.DARK_AQUA].
 * @see Text.Builder.color
 */
fun ScoreText.darkAqua(): ScoreText = this.color(TextColors.DARK_AQUA)

/**
 * Colors this text [TextColors.DARK_BLUE].
 * @see Text.Builder.color
 */
fun ScoreText.darkBlue(): ScoreText = this.color(TextColors.DARK_BLUE)

/**
 * Colors this text [TextColors.DARK_GRAY].
 * @see Text.Builder.color
 */
fun ScoreText.darkGray(): ScoreText = this.color(TextColors.DARK_GRAY)

/**
 * Colors this text [TextColors.DARK_GREEN].
 * @see Text.Builder.color
 */
fun ScoreText.darkGreen(): ScoreText = this.color(TextColors.DARK_GREEN)

/**
 * Colors this text [TextColors.DARK_PURPLE].
 * @see Text.Builder.color
 */
fun ScoreText.darkPurple(): ScoreText = this.color(TextColors.DARK_PURPLE)

/**
 * Colors this text [TextColors.DARK_RED].
 * @see Text.Builder.color
 */
fun ScoreText.darkRed(): ScoreText = this.color(TextColors.DARK_RED)

/**
 * Colors this text [TextColors.GOLD].
 * @see Text.Builder.color
 */
fun ScoreText.gold(): ScoreText = this.color(TextColors.GOLD)

/**
 * Colors this text [TextColors.GRAY].
 * @see Text.Builder.color
 */
fun ScoreText.gray(): ScoreText = this.color(TextColors.GRAY)

/**
 * Colors this text [TextColors.GREEN].
 * @see Text.Builder.color
 */
fun ScoreText.green(): ScoreText = this.color(TextColors.GREEN)

/**
 * Colors this text [TextColors.LIGHT_PURPLE].
 * @see Text.Builder.color
 */
fun ScoreText.lightPurple(): ScoreText = this.color(TextColors.LIGHT_PURPLE)

/**
 * Colors this text [TextColors.RED].
 * @see Text.Builder.color
 */
fun ScoreText.red(): ScoreText = this.color(TextColors.RED)

/**
 * Colors this text [TextColors.RESET].
 * @see Text.Builder.color
 */
fun ScoreText.resetColor(): ScoreText = this.color(TextColors.RESET)

/**
 * Colors this text [TextColors.WHITE].
 * @see Text.Builder.color
 */
fun ScoreText.white(): ScoreText = this.color(TextColors.WHITE)

/**
 * Colors this text [TextColors.YELLOW].
 * @see Text.Builder.color
 */
fun ScoreText.yellow(): ScoreText = this.color(TextColors.YELLOW)


/**
 * Sets the click action of this text.
 * @see Text.Builder.onClick
 */
fun ScoreText.onClick(clickAction: ClickAction<*>): ScoreText = toBuilder().onClick(clickAction).build()

/**
 * Sets the hover action of this text.
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(hoverAction: HoverAction<*>): ScoreText = toBuilder().onHover(hoverAction).build()

/**
 * Sets the shift-click action of this text.
 * @see Text.Builder.onShiftClick
 */
fun ScoreText.onShiftClick(shiftClickAction: ShiftClickAction<*>): ScoreText = toBuilder().onShiftClick(shiftClickAction).build()

/**
 * Sets the click action of this text to [TextActions.openUrl].
 * @see Text.Builder.onClick
 */
fun ScoreText.onClick(url: URL): ScoreText = this.onClick(TextActions.openUrl(url))

/**
 * Sets the click action of this text to [TextActions.runCommand].
 * @see Text.Builder.onClick
 */
fun ScoreText.onClick(command: String): ScoreText = this.onClick(TextActions.runCommand(command))

/**
 * Sets the click action of this text to [TextActions.executeCallback].
 * @see Text.Builder.onClick
 */
fun ScoreText.onClick(callback: Consumer<CommandSource>): ScoreText = this.onClick(TextActions.executeCallback(callback))

/**
 * Sets the click action of this text to [TextActions.changePage].
 * @see Text.Builder.onClick
 */
fun ScoreText.onClick(page: Int): ScoreText = this.onClick(TextActions.changePage(page))

/**
 * Sets the hover action of this text to [TextActions.showText].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(text: Text): ScoreText = this.onHover(TextActions.showText(text))

/**
 * Sets the hover action of this text to [TextActions.showItem].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(item: ItemStackSnapshot): ScoreText = this.onHover(TextActions.showItem(item))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(entity: Entity): ScoreText = this.onHover(TextActions.showEntity(entity,
        entity[Keys.DISPLAY_NAME].unwrap()?.toPlain() ?: entity.type.name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(entity: Entity, name: String): ScoreText = this.onHover(TextActions.showEntity(entity, name))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(entity: UUID, name: String, type: EntityType?): ScoreText =
        this.onHover(TextActions.showEntity(entity, name, type))

/**
 * Sets the hover action of this text to [TextActions.showEntity].
 * @see Text.Builder.onHover
 */
fun ScoreText.onHover(entity: HoverAction.ShowEntity.Ref): ScoreText = this.onHover(TextActions.showEntity(entity))

/**
 * Sets the hover action of this text to [TextActions.insertText].
 * @see Text.Builder.onShiftClick
 */
fun ScoreText.onShiftClick(text: String): ScoreText = this.onShiftClick(TextActions.insertText(text))


/**
 * Replaces [oldValue] with [newValue] in this text. If lossy mode is enabled,
 * this will replace across text component bounds, possibly removing
 * formatting; if it is not, this will not recognize the pattern across text
 * component bounds.
 *
 * @param oldValue The value to search for
 * @param newValue The value to replace [oldValue] with
 * @param ignoreCase Whether or not to ignore case when searching for
 *                   [oldValue]
 * @param lossy Whether or not to enable lossy mode
 * @return The resulting text
 */
fun Text.replace(oldValue: String, newValue: Text, ignoreCase: Boolean = false, lossy: Boolean = false): Text {
    val text = if (children.isEmpty()) this else {
        toBuilder().removeAll().append(children.map { it.replace(oldValue, newValue, ignoreCase, lossy) }).build()
    }
    val plain = if (lossy) toPlain() else toPlainSingle()
    if (!plain.contains(oldValue, ignoreCase)) {
        return text
    }
    if (plain.equals(oldValue, ignoreCase)) {
        return newValue
    }
    val builder = Text.builder()
    val strs = plain.split(oldValue, ignoreCase = ignoreCase)
    for (str in strs.dropLast(1)) {
        builder.append(!str)
        builder.append(newValue)
    }
    builder.append(!strs.last()).append(text.children).style(text.style)
    text.clickAction.ifPresent { builder.onClick(it) }
    text.hoverAction.ifPresent { builder.onHover(it) }
    text.shiftClickAction.ifPresent { builder.onShiftClick(it) }
    return builder.build()
}

/**
 * Replaces [oldValue] with [newValue] in this text. If lossy mode is enabled,
 * this will replace across text component bounds, possibly removing
 * formatting; if it is not, this will not recognize the pattern across text
 * component bounds.
 *
 * @param oldValue The pattern to search for
 * @param newValue The value to replace [oldValue] with
 * @param lossy Whether or not to enable lossy mode
 * @return The resulting text
 */
fun Text.replace(oldValue: Regex, newValue: Text, lossy: Boolean = false): Text {
    val text = if (children.isEmpty()) this else {
        toBuilder().removeAll().append(children.map { it.replace(oldValue, newValue, lossy) }).build()
    }
    val plain = if (lossy) toPlain() else toPlainSingle()
    if (oldValue in plain) {
        return text
    }
    if (oldValue.matchEntire(plain) != null) {
        return newValue
    }
    val builder = Text.builder()
    val strs = plain.split(oldValue)
    for (str in strs.dropLast(1)) {
        builder.append(!str)
        builder.append(newValue)
    }
    builder.append(!strs.last()).append(text.children).style(text.style)
    text.clickAction.ifPresent { builder.onClick(it) }
    text.hoverAction.ifPresent { builder.onHover(it) }
    text.shiftClickAction.ifPresent { builder.onShiftClick(it) }
    return builder.build()
}

//fun Text.replaceCapturing(regex: Regex, newValue: Text, named: Boolean = false): Text {
//    val text = if (children.isEmpty()) this else {
//        toBuilder().removeAll().append(children.map { it.replaceCapturing(regex, newValue) }).build()
//    }
//    if (text is ScoreText || text is SelectorText || text is TranslatableText) return text
//    val plain = toPlainSingle()
//    if (!plain.contains(regex)) {
//        return text
//    }
//    if (regex.matchEntire(plain) != null) {
//        return newValue
//    }
//    val builder = Text.builder()
//    val results = regex.findAll(plain).iterator()
//    val strs = regex.split(plain)
//    fun addNext() {
//        val result = results.next()
//        var toAdd = newValue
//        for ((num, group) in result.groups.filterNotNull().withIndex()) {
//            toAdd = toAdd.replace("$${num+1}", !group.value)
//        }
//        if (named) {
//            val namedResults = namedGroupRegex.findAll(newValue.toPlain())
//                    .map { it.groups[1] }.filterNotNull().map { it.value }.toSet()
//            for (name in namedResults) {
//                val replacementGroup = result.groups[name]
//                if (replacementGroup != null) {
//                    toAdd = toAdd.replace("$$name", !replacementGroup.value)
//                }
//            }
//        }
//        builder.append(toAdd)
//    }
//    for (str in strs.dropLast(1)) {
//        builder.append(!str)
//        addNext()
//    }
//    builder.append(!strs.last())
//    if (results.hasNext()) {
//        addNext()
//    }
//    builder.style(text.style).color(text.color).append(text.children)
//    return builder.build()
//}
//
//internal val namedGroupRegex = """\$([a-zA-Z]\w*?)""".toRegex()
