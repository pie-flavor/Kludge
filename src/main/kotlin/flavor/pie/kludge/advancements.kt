package flavor.pie.kludge

import org.spongepowered.api.advancement.Advancement
import org.spongepowered.api.advancement.TreeLayout
import org.spongepowered.api.advancement.TreeLayoutElement
import org.spongepowered.api.advancement.criteria.AdvancementCriterion
import org.spongepowered.api.advancement.criteria.ScoreCriterionProgress
import org.spongepowered.api.text.Text
import java.time.Instant

val Advancement.toastText: List<Text> get() = toToastText()

operator fun TreeLayout.get(advancement: Advancement): TreeLayoutElement? = getElement(advancement).unwrap()

infix fun AdvancementCriterion.and(criterion: AdvancementCriterion): AdvancementCriterion = and(criterion)
infix fun AdvancementCriterion.and(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = and(criteria)
infix fun AdvancementCriterion.or(criterion: AdvancementCriterion): AdvancementCriterion = or(criterion)
infix fun AdvancementCriterion.or(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = or(criteria)

operator fun ScoreCriterionProgress.plusAssign(score: Int) { add(score) }
operator fun ScoreCriterionProgress.plus(score: Int): Instant? = add(score).unwrap()
operator fun ScoreCriterionProgress.minusAssign(score: Int) { remove(score) }
operator fun ScoreCriterionProgress.minus(score: Int): Instant? = remove(score).unwrap()
operator fun ScoreCriterionProgress.timesAssign(score: Int) { set(this.score * score) }
operator fun ScoreCriterionProgress.times(score: Int): Instant? = set(this.score * score).unwrap()
operator fun ScoreCriterionProgress.divAssign(score: Int) { set(this.score / score) }
operator fun ScoreCriterionProgress.div(score: Int): Instant? = set(this.score / score).unwrap()
operator fun ScoreCriterionProgress.inc(): ScoreCriterionProgress = apply { add(1) }
operator fun ScoreCriterionProgress.dec(): ScoreCriterionProgress = apply { remove(1) }
operator fun ScoreCriterionProgress.unaryPlus(): Int = +score
operator fun ScoreCriterionProgress.unaryMinus(): Int = -score
operator fun ScoreCriterionProgress.compareTo(i: Int): Int = score.compareTo(i)
operator fun ScoreCriterionProgress.compareTo(progress: ScoreCriterionProgress): Int = score.compareTo(progress.score)
