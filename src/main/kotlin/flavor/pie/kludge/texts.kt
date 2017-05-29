package flavor.pie.kludge

import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.text.LiteralText
import org.spongepowered.api.text.ScoreText
import org.spongepowered.api.text.SelectorText
import org.spongepowered.api.text.Text
import org.spongepowered.api.text.TextRepresentable
import org.spongepowered.api.text.TranslatableText
import org.spongepowered.api.text.format.TextColor
import org.spongepowered.api.text.format.TextFormat
import org.spongepowered.api.text.format.TextStyle
import org.spongepowered.api.text.format.TextStyles
import org.spongepowered.api.text.selector.Selector
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

operator fun Translatable.not(): TranslatableText = Text.of(this)

fun Translatable.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

fun Translatable.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

fun Translatable.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

fun Translatable.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

fun Translatable.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Translatable.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Translatable.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Translatable.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

operator fun Translation.not(): TranslatableText = Text.of(this)

fun Translation.color(color: TextColor): TranslatableText = Text.builder(this).color(color).build()

fun Translation.format(format: TextFormat): TranslatableText = Text.builder(this).format(format).build()

fun Translation.style(vararg style: TextStyle): TranslatableText = Text.builder(this).style(*style).build()

fun Translation.bold(): TranslatableText = Text.builder(this).style(TextStyles.BOLD).build()

fun Translation.italic(): TranslatableText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Translation.underline(): TranslatableText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Translation.strikethrough(): TranslatableText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Translation.obfuscated(): TranslatableText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

operator fun Score.not(): ScoreText = Text.of(this)

fun Score.color(color: TextColor): ScoreText = Text.builder(this).color(color).build()

fun Score.format(format: TextFormat): ScoreText = Text.builder(this).format(format).build()

fun Score.style(vararg style: TextStyle): ScoreText = Text.builder(this).style(*style).build()

fun Score.bold(): ScoreText = Text.builder(this).style(TextStyles.BOLD).build()

fun Score.italic(): ScoreText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Score.underline(): ScoreText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Score.strikethrough(): ScoreText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Score.obfuscated(): ScoreText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

operator fun Selector.not(): SelectorText = Text.of(this)

fun Selector.color(color: TextColor): SelectorText = Text.builder(this).color(color).build()

fun Selector.format(format: TextFormat): SelectorText = Text.builder(this).format(format).build()

fun Selector.style(vararg style: TextStyle): SelectorText = Text.builder(this).style(*style).build()

fun Selector.bold(): SelectorText = Text.builder(this).style(TextStyles.BOLD).build()

fun Selector.italic(): SelectorText = Text.builder(this).style(TextStyles.ITALIC).build()

fun Selector.underline(): SelectorText = Text.builder(this).style(TextStyles.UNDERLINE).build()

fun Selector.strikethrough(): SelectorText = Text.builder(this).style(TextStyles.STRIKETHROUGH).build()

fun Selector.obfuscated(): SelectorText = Text.builder(this).style(TextStyles.OBFUSCATED).build()

operator fun Translation.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

operator fun Translatable.invoke(vararg args: Any): TranslatableText = Text.of(this, *args)

operator fun Text.plus(that: Text): Text = this.concat(that)

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

fun LiteralText.color(color: TextColor): LiteralText = this.toBuilder().color(color).build()

fun LiteralText.format(format: TextFormat): LiteralText = this.toBuilder().format(format).build()

fun LiteralText.style(vararg style: TextStyle): LiteralText = this.toBuilder().style(*style).build()

fun LiteralText.bold(): LiteralText = this.toBuilder().style(TextStyles.BOLD).build()

fun LiteralText.italic(): LiteralText = this.toBuilder().style(TextStyles.ITALIC).build()

fun LiteralText.underline(): LiteralText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun LiteralText.strikethrough(): LiteralText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun LiteralText.obfuscated(): LiteralText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun TranslatableText.color(color: TextColor): TranslatableText = this.toBuilder().color(color).build()

fun TranslatableText.format(format: TextFormat): TranslatableText = this.toBuilder().format(format).build()

fun TranslatableText.style(vararg style: TextStyle): TranslatableText = this.toBuilder().style(*style).build()

fun TranslatableText.bold(): TranslatableText = this.toBuilder().style(TextStyles.BOLD).build()

fun TranslatableText.italic(): TranslatableText = this.toBuilder().style(TextStyles.ITALIC).build()

fun TranslatableText.underline(): TranslatableText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun TranslatableText.strikethrough(): TranslatableText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun TranslatableText.obfuscated(): TranslatableText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun SelectorText.color(color: TextColor): SelectorText = this.toBuilder().color(color).build()

fun SelectorText.format(format: TextFormat): SelectorText = this.toBuilder().format(format).build()

fun SelectorText.style(vararg style: TextStyle): SelectorText = this.toBuilder().style(*style).build()

fun SelectorText.bold(): SelectorText = this.toBuilder().style(TextStyles.BOLD).build()

fun SelectorText.italic(): SelectorText = this.toBuilder().style(TextStyles.ITALIC).build()

fun SelectorText.underline(): SelectorText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun SelectorText.strikethrough(): SelectorText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun SelectorText.obfuscated(): SelectorText = this.toBuilder().style(TextStyles.OBFUSCATED).build()

fun ScoreText.color(color: TextColor): ScoreText = this.toBuilder().color(color).build()

fun ScoreText.format(format: TextFormat): ScoreText = this.toBuilder().format(format).build()

fun ScoreText.style(vararg style: TextStyle): ScoreText = this.toBuilder().style(*style).build()

fun ScoreText.bold(): ScoreText = this.toBuilder().style(TextStyles.BOLD).build()

fun ScoreText.italic(): ScoreText = this.toBuilder().style(TextStyles.ITALIC).build()

fun ScoreText.underline(): ScoreText = this.toBuilder().style(TextStyles.UNDERLINE).build()

fun ScoreText.strikethrough(): ScoreText = this.toBuilder().style(TextStyles.STRIKETHROUGH).build()

fun ScoreText.obfuscated(): ScoreText = this.toBuilder().style(TextStyles.OBFUSCATED).build()
