package flavor.pie.kludge

import org.spongepowered.api.advancement.Advancement
import org.spongepowered.api.advancement.TreeLayout
import org.spongepowered.api.advancement.TreeLayoutElement
import org.spongepowered.api.advancement.criteria.AdvancementCriterion
import org.spongepowered.api.advancement.criteria.ScoreCriterionProgress
import org.spongepowered.api.text.Text
import java.time.Instant

/**
 * @see Advancement.toToastText
 */
val Advancement.toastText: List<Text> get() = toToastText()

/**
 * @see TreeLayout.getElement
 */
operator fun TreeLayout.get(advancement: Advancement): TreeLayoutElement? = getElement(advancement).unwrap()

/**
 * @see AdvancementCriterion.and
 */
infix fun AdvancementCriterion.and(criterion: AdvancementCriterion): AdvancementCriterion = and(criterion)

/**
 * @see AdvancementCriterion.and
 */
infix fun AdvancementCriterion.and(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = and(criteria)

/**
 * @see AdvancementCriterion.or
 */
infix fun AdvancementCriterion.or(criterion: AdvancementCriterion): AdvancementCriterion = or(criterion)

/**
 * @see AdvancementCriterion.or
 */
infix fun AdvancementCriterion.or(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = or(criteria)

/**
 * @see ScoreCriterionProgress.add
 */
operator fun ScoreCriterionProgress.plusAssign(score: Int) { add(score) }

/**
 * @see ScoreCriterionProgress.add
 */
operator fun ScoreCriterionProgress.plus(score: Int): Instant? = add(score).unwrap()

/**
 * @see ScoreCriterionProgress.remove
 */
operator fun ScoreCriterionProgress.minusAssign(score: Int) { remove(score) }

/**
 * @see ScoreCriterionProgress.remove
 */
operator fun ScoreCriterionProgress.minus(score: Int): Instant? = remove(score).unwrap()

/**
 * Multiplies the score by [score].
 * @see ScoreCriterionProgress.set
 */
operator fun ScoreCriterionProgress.timesAssign(score: Int) { set(this.score * score) }

/**
 * Multiplies the score by [score].
 * @see ScoreCriterionProgress.set
 */
operator fun ScoreCriterionProgress.times(score: Int): Instant? = set(this.score * score).unwrap()

/**
 * Divides the score by [score].
 * @see ScoreCriterionProgress.set
 */
operator fun ScoreCriterionProgress.divAssign(score: Int) { set(this.score / score) }

/**
 * Divides the score by [score].
 * @see ScoreCriterionProgress.set
 */
operator fun ScoreCriterionProgress.div(score: Int): Instant? = set(this.score / score).unwrap()

/**
 * Adds 1 to the score.
 * @see ScoreCriterionProgress.add
 */
operator fun ScoreCriterionProgress.inc(): ScoreCriterionProgress = apply { add(1) }

/**
 * Subtracts 1 from the score.
 * @see ScoreCriterionProgress.remove
 */
operator fun ScoreCriterionProgress.dec(): ScoreCriterionProgress = apply { remove(1) }

/**
 * @see ScoreCriterionProgress.getScore
 */
operator fun ScoreCriterionProgress.unaryPlus(): Int = +score

/**
 * Gets the score multiplied by -1.
 * @see ScoreCriterionProgress.getScore
 */
operator fun ScoreCriterionProgress.unaryMinus(): Int = -score

/**
 * Compares the score to [i].
 * @see ScoreCriterionProgress.getScore
 */
operator fun ScoreCriterionProgress.compareTo(i: Int): Int = score.compareTo(i)

/**
 * Compares the scores of both progresses.
 * @see ScoreCriterionProgress.getScore
 */
operator fun ScoreCriterionProgress.compareTo(progress: ScoreCriterionProgress): Int = score.compareTo(progress.score)
