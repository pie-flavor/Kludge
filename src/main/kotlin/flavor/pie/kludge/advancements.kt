package flavor.pie.kludge

import org.spongepowered.api.advancement.Advancement
import org.spongepowered.api.advancement.TreeLayout
import org.spongepowered.api.advancement.TreeLayoutElement
import org.spongepowered.api.advancement.criteria.AdvancementCriterion
import org.spongepowered.api.advancement.criteria.ScoreCriterionProgress
import org.spongepowered.api.text.Text

val Advancement.toastText: List<Text> get() = toToastText()
operator fun TreeLayout.get(advancement: Advancement): TreeLayoutElement? = getElement(advancement).unwrap()
infix fun AdvancementCriterion.and(criterion: AdvancementCriterion): AdvancementCriterion = and(criterion)
infix fun AdvancementCriterion.and(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = and(criteria)
infix fun AdvancementCriterion.or(criterion: AdvancementCriterion): AdvancementCriterion = or(criterion)
infix fun AdvancementCriterion.or(criteria: Iterable<AdvancementCriterion>): AdvancementCriterion = or(criteria)
operator fun ScoreCriterionProgress.plusAssign(score: Int) { add(score) }
operator fun ScoreCriterionProgress.minusAssign(score: Int) { remove(score) }
@Suppress("ConflictingExtensionProperty")
var ScoreCriterionProgress.score
get() = score
    set(value) { set(value) }
