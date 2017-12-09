package flavor.pie.kludge

import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.text.LiteralText
import org.spongepowered.api.text.ScoreText
import org.spongepowered.api.text.SelectorText
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextRepresentable
import org.spongepowered.api.text.TextTemplate
import org.spongepowered.api.text.TranslatableText
import org.spongepowered.api.text.action.ClickAction
import org.spongepowered.api.text.action.HoverAction
import org.spongepowered.api.text.action.ShiftClickAction
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextColors
import org.spongepowered.api.text.format.TextFormat
import org.spongepowered.api.text.format.TextStyle
import org.spongepowered.api.text.format.TextStyles
import org.spongepowered.api.text.selector.Selector
import org.spongepowered.api.text.serializer.TextSerializers
import org.spongepowered.api.text.translation.Translatable
import org.spongepowered.api.text.translation.Translation

operator fun TextRepresentable.not(): Text = this.toText()

operator fun Text.unaryPlus(): Text.Builder = this.toBuilder()

operator fun String.not(): LiteralText = Text.of(this)

fun String.color(color: TextColor): LiteralText = Text.builder(this).color(color).build()

fun String.format(format: TextFormat): LiteralText = Text.builder(this).format(format).build()

fun String.style(vararg style: TextStyle): LiteralText = Text.builder(this).style(*style).build()

fun String.bold(): LiteralText = Text.builder(this).style(TextStyles.BOLD).build()

fun String.italic(): LiteralText = Text.builder(this).style(TextStyles.ITALIC).build()

fun String.underline(): LiteralText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun String.strikethrough(): LiteralText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun String.obfuscated(): LiteralText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

fun String.aqua(): LiteralText = this.color(TextColors.AQUA)
fun String.black(): LiteralText = this.color(TextColors.BLACK)
fun String.blue(): LiteralText = this.color(TextColors.BLUE)
fun String.darkAqua(): LiteralText = this.color(TextColors.DARK_AQUA)
fun String.darkBlue(): LiteralText = this.color(TextColors.DARK_BLUE)
fun String.darkGray(): LiteralText = this.color(TextColors.DARK_GRAY)
fun String.darkGreen(): LiteralText = this.color(TextColors.DARK_GREEN)
fun String.darkPurple(): LiteralText = this.color(TextColors.DARK_PURPLE)
fun String.darkRed(): LiteralText = this.color(TextColors.DARK_RED)
fun String.gold(): LiteralText = this.color(TextColors.GOLD)
fun String.gray(): LiteralText = this.color(TextColors.GRAY)
fun String.green(): LiteralText = this.color(TextColors.GREEN)
fun String.lightPurple(): LiteralText = this.color(TextColors.LIGHT_PURPLE)
fun String.red(): LiteralText = this.color(TextColors.RED)
fun String.resetColor(): LiteralText = this.color(TextColors.RESET)
fun String.white(): LiteralText = this.color(TextColors.WHITE)
fun String.yellow(): LiteralText = this.color(TextColors.YELLOW)

fun String.onClick(clickAction: ClickAction<*>): LiteralText = Text.builder(this).onClick(clickAction).build()
fun String.onHover(hoverAction: HoverAction<*>): LiteralText = Text.builder(this).onHover(hoverAction).build()
fun String.onShiftClick(shiftClickAction: ShiftClickAction<*>): LiteralText = Text.builder(this).onShiftClick(shiftClickAction).build()

fun String.textByJson(): Text = TextSerializers.JSON.deserialize(this)
fun String.textByFormat(): Text = TextSerializers.FORMATTING_CODE.deserialize(this)
fun String.textByFormat(c: Char): Text = TextSerializers.formattingCode(c).deserialize(this)

operator fun Translatable.not(): TranslatableText = Text.of(this)

fun Translatable.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

fun Translatable.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

fun Translatable.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

fun Translatable.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

fun Translatable.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Translatable.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Translatable.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Translatable.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

fun Translatable.aqua(): TranslatableText = this.color(TextColors.AQUA)
fun Translatable.black(): TranslatableText = this.color(TextColors.BLACK)
fun Translatable.blue(): TranslatableText = this.color(TextColors.BLUE)
fun Translatable.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)
fun Translatable.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)
fun Translatable.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)
fun Translatable.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)
fun Translatable.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)
fun Translatable.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)
fun Translatable.gold(): TranslatableText = this.color(TextColors.GOLD)
fun Translatable.gray(): TranslatableText = this.color(TextColors.GRAY)
fun Translatable.green(): TranslatableText = this.color(TextColors.GREEN)
fun Translatable.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)
fun Translatable.red(): TranslatableText = this.color(TextColors.RED)
fun Translatable.resetColor(): TranslatableText = this.color(TextColors.RESET)
fun Translatable.white(): TranslatableText = this.color(TextColors.WHITE)
fun Translatable.yellow(): TranslatableText = this.color(TextColors.YELLOW)

fun Translatable.onClick(clickAction: ClickAction<*>): TranslatableText = Text.builder(this).onClick(clickAction).build()
fun Translatable.onHover(hoverAction: HoverAction<*>): TranslatableText = Text.builder(this).onHover(hoverAction).build()
fun Translatable.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = Text.builder(this).onShiftClick(shiftClickAction).build()

operator fun Translation.not(): TranslatableText = Text.of(this)

fun Translation.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

fun Translation.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

fun Translation.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

fun Translation.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

fun Translation.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Translation.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Translation.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Translation.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

fun Translation.aqua(): TranslatableText = this.color(TextColors.AQUA)
fun Translation.black(): TranslatableText = this.color(TextColors.BLACK)
fun Translation.blue(): TranslatableText = this.color(TextColors.BLUE)
fun Translation.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)
fun Translation.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)
fun Translation.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)
fun Translation.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)
fun Translation.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)
fun Translation.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)
fun Translation.gold(): TranslatableText = this.color(TextColors.GOLD)
fun Translation.gray(): TranslatableText = this.color(TextColors.GRAY)
fun Translation.green(): TranslatableText = this.color(TextColors.GREEN)
fun Translation.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)
fun Translation.red(): TranslatableText = this.color(TextColors.RED)
fun Translation.resetColor(): TranslatableText = this.color(TextColors.RESET)
fun Translation.white(): TranslatableText = this.color(TextColors.WHITE)
fun Translation.yellow(): TranslatableText = this.color(TextColors.YELLOW)

fun Translation.onClick(clickAction: ClickAction<*>): TranslatableText = Text.builder(this).onClick(clickAction).build()
fun Translation.onHover(hoverAction: HoverAction<*>): TranslatableText = Text.builder(this).onHover(hoverAction).build()
fun Translation.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = Text.builder(this).onShiftClick(shiftClickAction).build()

operator fun Score.not(): ScoreText = Text.of(this)

fun Score.color(color: TextColor): ScoreText = Text.builder(this).color(color).build()

fun Score.format(format: TextFormat): ScoreText = Text.builder(this).format(format).build()

fun Score.style(vararg style: TextStyle): ScoreText = Text.builder(this).style(*style).build()

fun Score.bold(): ScoreText = Text.builder(this).style(TextStyles.BOLD).build()

fun Score.italic(): ScoreText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Score.underline(): ScoreText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Score.strikethrough(): ScoreText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Score.obfuscated(): ScoreText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

fun Score.aqua(): ScoreText = this.color(TextColors.AQUA)
fun Score.black(): ScoreText = this.color(TextColors.BLACK)
fun Score.blue(): ScoreText = this.color(TextColors.BLUE)
fun Score.darkAqua(): ScoreText = this.color(TextColors.DARK_AQUA)
fun Score.darkBlue(): ScoreText = this.color(TextColors.DARK_BLUE)
fun Score.darkGray(): ScoreText = this.color(TextColors.DARK_GRAY)
fun Score.darkGreen(): ScoreText = this.color(TextColors.DARK_GREEN)
fun Score.darkPurple(): ScoreText = this.color(TextColors.DARK_PURPLE)
fun Score.darkRed(): ScoreText = this.color(TextColors.DARK_RED)
fun Score.gold(): ScoreText = this.color(TextColors.GOLD)
fun Score.gray(): ScoreText = this.color(TextColors.GRAY)
fun Score.green(): ScoreText = this.color(TextColors.GREEN)
fun Score.lightPurple(): ScoreText = this.color(TextColors.LIGHT_PURPLE)
fun Score.red(): ScoreText = this.color(TextColors.RED)
fun Score.resetColor(): ScoreText = this.color(TextColors.RESET)
fun Score.white(): ScoreText = this.color(TextColors.WHITE)
fun Score.yellow(): ScoreText = this.color(TextColors.YELLOW)

fun Score.onClick(clickAction: ClickAction<*>): ScoreText = Text.builder(this).onClick(clickAction).build()
fun Score.onHover(hoverAction: HoverAction<*>): ScoreText = Text.builder(this).onHover(hoverAction).build()
fun Score.onShiftClick(shiftClickAction: ShiftClickAction<*>): ScoreText = Text.builder(this).onShiftClick(shiftClickAction).build()

operator fun Selector.not(): SelectorText = Text.of(this)

fun Selector.color(color: TextColor): SelectorText = Text.builder(this).color(color).build()

fun Selector.format(format: TextFormat): SelectorText = Text.builder(this).format(format).build()

fun Selector.style(vararg style: TextStyle): SelectorText = Text.builder(this).style(*style).build()

fun Selector.bold(): SelectorText = Text.builder(this).style(TextStyles.BOLD).build()

fun Selector.italic(): SelectorText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Selector.underline(): SelectorText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Selector.strikethrough(): SelectorText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Selector.obfuscated(): SelectorText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

fun Selector.aqua(): SelectorText = this.color(TextColors.AQUA)
fun Selector.black(): SelectorText = this.color(TextColors.BLACK)
fun Selector.blue(): SelectorText = this.color(TextColors.BLUE)
fun Selector.darkAqua(): SelectorText = this.color(TextColors.DARK_AQUA)
fun Selector.darkBlue(): SelectorText = this.color(TextColors.DARK_BLUE)
fun Selector.darkGray(): SelectorText = this.color(TextColors.DARK_GRAY)
fun Selector.darkGreen(): SelectorText = this.color(TextColors.DARK_GREEN)
fun Selector.darkPurple(): SelectorText = this.color(TextColors.DARK_PURPLE)
fun Selector.darkRed(): SelectorText = this.color(TextColors.DARK_RED)
fun Selector.gold(): SelectorText = this.color(TextColors.GOLD)
fun Selector.gray(): SelectorText = this.color(TextColors.GRAY)
fun Selector.green(): SelectorText = this.color(TextColors.GREEN)
fun Selector.lightPurple(): SelectorText = this.color(TextColors.LIGHT_PURPLE)
fun Selector.red(): SelectorText = this.color(TextColors.RED)
fun Selector.resetColor(): SelectorText = this.color(TextColors.RESET)
fun Selector.white(): SelectorText = this.color(TextColors.WHITE)
fun Selector.yellow(): SelectorText = this.color(TextColors.YELLOW)

fun Selector.onClick(clickAction: ClickAction<*>): SelectorText = Text.builder(this).onClick(clickAction).build()
fun Selector.onHover(hoverAction: HoverAction<*>): SelectorText = Text.builder(this).onHover(hoverAction).build()
fun Selector.onShiftClick(shiftClickAction: ShiftClickAction<*>): SelectorText = Text.builder(this).onShiftClick(shiftClickAction).build()

operator fun Translation.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

operator fun Translatable.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

operator fun Text.plus(that: Text): Text = this.concat(that)

operator fun Text.plus(that: String): Text = this.concat(!that)

operator fun Text.plus(that: Selector): Text = this.concat(!that)

operator fun Text.plus(that: Translatable): Text = this.concat(!that)

operator fun Text.plus(that: Translation): Text = this.concat(!that)

operator fun Text.plus(that: Score): Text = this.concat(!that)

operator fun Text.plus(that: TextRepresentable): Text = this.concat(!that)

operator fun Text.Builder.plus(that: Text): Text.Builder = this.append(that)

operator fun Text.Builder.plus(that: Collection<Text>): Text.Builder = this.append(that)

operator fun Text.Builder.plus(that: Iterator<Text>): Text.Builder = this.append(that)

operator fun Text.Builder.plus(that: Iterable<Text>): Text.Builder = this.append(that)

operator fun Text.Builder.minus(that: Text): Text.Builder = this.remove(that)

operator fun Text.Builder.minus(that: Collection<Text>): Text.Builder = this.remove(that)

operator fun Text.Builder.minus(that: Iterator<Text>): Text.Builder = this.remove(that)

operator fun Text.Builder.minus(that: Iterable<Text>): Text.Builder = this.remove(that)

operator fun Text.plus(that: Text.Builder.() -> Unit): Text = this.toBuilder().apply(that).build()

operator fun LiteralText.plus(that: LiteralText.Builder.() -> Unit): LiteralText = this.toBuilder().apply(that).build()

operator fun TranslatableText.plus(that: TranslatableText.Builder.() -> Unit): TranslatableText = this.toBuilder().apply(that).build()

operator fun ScoreText.plus(that: ScoreText.Builder.() -> Unit): ScoreText = this.toBuilder().apply(that).build()

operator fun SelectorText.plus(that: SelectorText.Builder.() -> Unit): SelectorText = this.toBuilder().apply(that).build()

fun Text.color(color: TextColor): Text = this.toBuilder().color(color).build()

fun Text.format(format: TextFormat): Text = this.toBuilder().format(format).build()

fun Text.style(vararg style: TextStyle): Text = this.toBuilder().style(*style).build()

fun Text.bold(): Text = this.toBuilder().style(TextStyles.BOLD).build()

fun Text.italic(): Text = this.toBuilder().style(TextStyles.ITALIC).build()

fun Text.underline(): Text = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun Text.strikethrough(): Text = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun Text.obfuscated(): Text = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun Text.aqua(): Text = this.color(TextColors.AQUA)
fun Text.black(): Text = this.color(TextColors.BLACK)
fun Text.blue(): Text = this.color(TextColors.BLUE)
fun Text.darkAqua(): Text = this.color(TextColors.DARK_AQUA)
fun Text.darkBlue(): Text = this.color(TextColors.DARK_BLUE)
fun Text.darkGray(): Text = this.color(TextColors.DARK_GRAY)
fun Text.darkGreen(): Text = this.color(TextColors.DARK_GREEN)
fun Text.darkPurple(): Text = this.color(TextColors.DARK_PURPLE)
fun Text.darkRed(): Text = this.color(TextColors.DARK_RED)
fun Text.gold(): Text = this.color(TextColors.GOLD)
fun Text.gray(): Text = this.color(TextColors.GRAY)
fun Text.green(): Text = this.color(TextColors.GREEN)
fun Text.lightPurple(): Text = this.color(TextColors.LIGHT_PURPLE)
fun Text.red(): Text = this.color(TextColors.RED)
fun Text.resetColor(): Text = this.color(TextColors.RESET)
fun Text.white(): Text = this.color(TextColors.WHITE)
fun Text.yellow(): Text = this.color(TextColors.YELLOW)

fun Text.onClick(clickAction: ClickAction<*>): Text = toBuilder().onClick(clickAction).build()
fun Text.onHover(hoverAction: HoverAction<*>): Text = toBuilder().onHover(hoverAction).build()
fun Text.onShiftClick(shiftClickAction: ShiftClickAction<*>): Text = toBuilder().onShiftClick(shiftClickAction).build()

fun LiteralText.color(color: TextColor): LiteralText = this.toBuilder().color(color).build()

fun LiteralText.format(format: TextFormat): LiteralText = this.toBuilder().format(format).build()

fun LiteralText.style(vararg style: TextStyle): LiteralText = this.toBuilder().style(*style).build()

fun LiteralText.bold(): LiteralText = this.toBuilder().style(TextStyles.BOLD).build()

fun LiteralText.italic(): LiteralText = this.toBuilder().style(TextStyles.ITALIC).build()

fun LiteralText.underline(): LiteralText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun LiteralText.strikethrough(): LiteralText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun LiteralText.obfuscated(): LiteralText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun LiteralText.aqua(): LiteralText = this.color(TextColors.AQUA)
fun LiteralText.black(): LiteralText = this.color(TextColors.BLACK)
fun LiteralText.blue(): LiteralText = this.color(TextColors.BLUE)
fun LiteralText.darkAqua(): LiteralText = this.color(TextColors.DARK_AQUA)
fun LiteralText.darkBlue(): LiteralText = this.color(TextColors.DARK_BLUE)
fun LiteralText.darkGray(): LiteralText = this.color(TextColors.DARK_GRAY)
fun LiteralText.darkGreen(): LiteralText = this.color(TextColors.DARK_GREEN)
fun LiteralText.darkPurple(): LiteralText = this.color(TextColors.DARK_PURPLE)
fun LiteralText.darkRed(): LiteralText = this.color(TextColors.DARK_RED)
fun LiteralText.gold(): LiteralText = this.color(TextColors.GOLD)
fun LiteralText.gray(): LiteralText = this.color(TextColors.GRAY)
fun LiteralText.green(): LiteralText = this.color(TextColors.GREEN)
fun LiteralText.lightPurple(): LiteralText = this.color(TextColors.LIGHT_PURPLE)
fun LiteralText.red(): LiteralText = this.color(TextColors.RED)
fun LiteralText.resetColor(): LiteralText = this.color(TextColors.RESET)
fun LiteralText.white(): LiteralText = this.color(TextColors.WHITE)
fun LiteralText.yellow(): LiteralText = this.color(TextColors.YELLOW)

fun LiteralText.onClick(clickAction: ClickAction<*>): LiteralText = toBuilder().onClick(clickAction).build()
fun LiteralText.onHover(hoverAction: HoverAction<*>): LiteralText = toBuilder().onHover(hoverAction).build()
fun LiteralText.onShiftClick(shiftClickAction: ShiftClickAction<*>): LiteralText = toBuilder().onShiftClick(shiftClickAction).build()

fun TranslatableText.color(color: TextColor): TranslatableText = this.toBuilder().color(color).build()

fun TranslatableText.format(format: TextFormat): TranslatableText = this.toBuilder().format(format).build()

fun TranslatableText.style(vararg style: TextStyle): TranslatableText = this.toBuilder().style(*style).build()

fun TranslatableText.bold(): TranslatableText = this.toBuilder().style(TextStyles.BOLD).build()

fun TranslatableText.italic(): TranslatableText = this.toBuilder().style(TextStyles.ITALIC).build()

fun TranslatableText.underline(): TranslatableText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun TranslatableText.strikethrough(): TranslatableText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun TranslatableText.obfuscated(): TranslatableText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun TranslatableText.aqua(): TranslatableText = this.color(TextColors.AQUA)
fun TranslatableText.black(): TranslatableText = this.color(TextColors.BLACK)
fun TranslatableText.blue(): TranslatableText = this.color(TextColors.BLUE)
fun TranslatableText.darkAqua(): TranslatableText = this.color(TextColors.DARK_AQUA)
fun TranslatableText.darkBlue(): TranslatableText = this.color(TextColors.DARK_BLUE)
fun TranslatableText.darkGray(): TranslatableText = this.color(TextColors.DARK_GRAY)
fun TranslatableText.darkGreen(): TranslatableText = this.color(TextColors.DARK_GREEN)
fun TranslatableText.darkPurple(): TranslatableText = this.color(TextColors.DARK_PURPLE)
fun TranslatableText.darkRed(): TranslatableText = this.color(TextColors.DARK_RED)
fun TranslatableText.gold(): TranslatableText = this.color(TextColors.GOLD)
fun TranslatableText.gray(): TranslatableText = this.color(TextColors.GRAY)
fun TranslatableText.green(): TranslatableText = this.color(TextColors.GREEN)
fun TranslatableText.lightPurple(): TranslatableText = this.color(TextColors.LIGHT_PURPLE)
fun TranslatableText.red(): TranslatableText = this.color(TextColors.RED)
fun TranslatableText.resetColor(): TranslatableText = this.color(TextColors.RESET)
fun TranslatableText.white(): TranslatableText = this.color(TextColors.WHITE)
fun TranslatableText.yellow(): TranslatableText = this.color(TextColors.YELLOW)

fun TranslatableText.onClick(clickAction: ClickAction<*>): TranslatableText = toBuilder().onClick(clickAction).build()
fun TranslatableText.onHover(hoverAction: HoverAction<*>): TranslatableText = toBuilder().onHover(hoverAction).build()
fun TranslatableText.onShiftClick(shiftClickAction: ShiftClickAction<*>): TranslatableText = toBuilder().onShiftClick(shiftClickAction).build()

fun SelectorText.color(color: TextColor): SelectorText = this.toBuilder().color(color).build()

fun SelectorText.format(format: TextFormat): SelectorText = this.toBuilder().format(format).build()

fun SelectorText.style(vararg style: TextStyle): SelectorText = this.toBuilder().style(*style).build()

fun SelectorText.bold(): SelectorText = this.toBuilder().style(TextStyles.BOLD).build()

fun SelectorText.italic(): SelectorText = this.toBuilder().style(TextStyles.ITALIC).build()

fun SelectorText.underline(): SelectorText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun SelectorText.strikethrough(): SelectorText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun SelectorText.obfuscated(): SelectorText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun SelectorText.aqua(): SelectorText = this.color(TextColors.AQUA)
fun SelectorText.black(): SelectorText = this.color(TextColors.BLACK)
fun SelectorText.blue(): SelectorText = this.color(TextColors.BLUE)
fun SelectorText.darkAqua(): SelectorText = this.color(TextColors.DARK_AQUA)
fun SelectorText.darkBlue(): SelectorText = this.color(TextColors.DARK_BLUE)
fun SelectorText.darkGray(): SelectorText = this.color(TextColors.DARK_GRAY)
fun SelectorText.darkGreen(): SelectorText = this.color(TextColors.DARK_GREEN)
fun SelectorText.darkPurple(): SelectorText = this.color(TextColors.DARK_PURPLE)
fun SelectorText.darkRed(): SelectorText = this.color(TextColors.DARK_RED)
fun SelectorText.gold(): SelectorText = this.color(TextColors.GOLD)
fun SelectorText.gray(): SelectorText = this.color(TextColors.GRAY)
fun SelectorText.green(): SelectorText = this.color(TextColors.GREEN)
fun SelectorText.lightPurple(): SelectorText = this.color(TextColors.LIGHT_PURPLE)
fun SelectorText.red(): SelectorText = this.color(TextColors.RED)
fun SelectorText.resetColor(): SelectorText = this.color(TextColors.RESET)
fun SelectorText.white(): SelectorText = this.color(TextColors.WHITE)
fun SelectorText.yellow(): SelectorText = this.color(TextColors.YELLOW)

fun SelectorText.onClick(clickAction: ClickAction<*>): SelectorText = toBuilder().onClick(clickAction).build()
fun SelectorText.onHover(hoverAction: HoverAction<*>): SelectorText = toBuilder().onHover(hoverAction).build()
fun SelectorText.onShiftClick(shiftClickAction: ShiftClickAction<*>): SelectorText = toBuilder().onShiftClick(shiftClickAction).build()

fun ScoreText.color(color: TextColor): ScoreText = this.toBuilder().color(color).build()

fun ScoreText.format(format: TextFormat): ScoreText = this.toBuilder().format(format).build()

fun ScoreText.style(vararg style: TextStyle): ScoreText = this.toBuilder().style(*style).build()

fun ScoreText.bold(): ScoreText = this.toBuilder().style(TextStyles.BOLD).build()

fun ScoreText.italic(): ScoreText = this.toBuilder().style(TextStyles.ITALIC).build()

fun ScoreText.underline(): ScoreText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun ScoreText.strikethrough(): ScoreText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun ScoreText.obfuscated(): ScoreText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun ScoreText.aqua(): ScoreText = this.color(TextColors.AQUA)
fun ScoreText.black(): ScoreText = this.color(TextColors.BLACK)
fun ScoreText.blue(): ScoreText = this.color(TextColors.BLUE)
fun ScoreText.darkAqua(): ScoreText = this.color(TextColors.DARK_AQUA)
fun ScoreText.darkBlue(): ScoreText = this.color(TextColors.DARK_BLUE)
fun ScoreText.darkGray(): ScoreText = this.color(TextColors.DARK_GRAY)
fun ScoreText.darkGreen(): ScoreText = this.color(TextColors.DARK_GREEN)
fun ScoreText.darkPurple(): ScoreText = this.color(TextColors.DARK_PURPLE)
fun ScoreText.darkRed(): ScoreText = this.color(TextColors.DARK_RED)
fun ScoreText.gold(): ScoreText = this.color(TextColors.GOLD)
fun ScoreText.gray(): ScoreText = this.color(TextColors.GRAY)
fun ScoreText.green(): ScoreText = this.color(TextColors.GREEN)
fun ScoreText.lightPurple(): ScoreText = this.color(TextColors.LIGHT_PURPLE)
fun ScoreText.red(): ScoreText = this.color(TextColors.RED)
fun ScoreText.resetColor(): ScoreText = this.color(TextColors.RESET)
fun ScoreText.white(): ScoreText = this.color(TextColors.WHITE)
fun ScoreText.yellow(): ScoreText = this.color(TextColors.YELLOW)

fun ScoreText.onClick(clickAction: ClickAction<*>): ScoreText = toBuilder().onClick(clickAction).build()
fun ScoreText.onHover(hoverAction: HoverAction<*>): ScoreText = toBuilder().onHover(hoverAction).build()
fun ScoreText.onShiftClick(shiftClickAction: ShiftClickAction<*>): ScoreText = toBuilder().onShiftClick(shiftClickAction).build()

fun Text.replace(oldValue: String, newValue: Text, ignoreCase: Boolean = false): Text {
    val text = if (children.isEmpty()) this else {
        toBuilder().removeAll().append(children.map { it.replace(oldValue, newValue) }).build()
    }
    val plain = toPlainSingle()
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
    builder.append(!strs.last())
    builder.style(text.style).color(text.color).append(text.children)
    return builder.build()
}

fun Text.replaceCapturing(regex: Regex, newValue: Text, named: Boolean = false): Text {
    val text = if (children.isEmpty()) this else {
        toBuilder().removeAll().append(children.map { it.replaceCapturing(regex, newValue) }).build()
    }
    if (text is ScoreText || text is SelectorText || text is TranslatableText) return text
    val plain = toPlainSingle()
    if (!plain.contains(regex)) {
        return text
    }
    if (regex.matchEntire(plain) != null) {
        return newValue
    }
    val builder = Text.builder()
    val results = regex.findAll(plain).iterator()
    val strs = regex.split(plain)
    fun addNext() {
        val result = results.next()
        var toAdd = newValue
        for ((num, group) in result.groups.filterNotNull().withIndex()) {
            toAdd = toAdd.replace("$${num+1}", !group.value)
        }
        if (named) {
            val namedResults = namedGroupRegex.findAll(newValue.toPlain())
                    .map { it.groups[1] }.filterNotNull().map { it.value }.toSet()
            for (name in namedResults) {
                val replacementGroup = result.groups[name]
                if (replacementGroup != null) {
                    toAdd = toAdd.replace("$$name", !replacementGroup.value)
                }
            }
        }
        builder.append(toAdd)
    }
    for (str in strs.dropLast(1)) {
        builder.append(!str)
        addNext()
    }
    builder.append(!strs.last())
    if (results.hasNext()) {
        addNext()
    }
    builder.style(text.style).color(text.color).append(text.children)
    return builder.build()
}

internal val namedGroupRegex = """\$([a-zA-Z]\w*?)""".toRegex()