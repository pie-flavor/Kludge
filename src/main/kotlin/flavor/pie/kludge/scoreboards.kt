package flavor.pie.kludge

import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.scoreboard.Scoreboard
import org.spongepowered.api.scoreboard.Team
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot
import org.spongepowered.api.scoreboard.objective.Objective
import org.spongepowered.api.text.Text

operator fun Scoreboard.plusAssign(objective: Objective) = addObjective(objective)
operator fun Scoreboard.minusAssign(objective: Objective) = removeObjective(objective)
operator fun Scoreboard.contains(objective: Objective): Boolean = objective in objectives
operator fun Scoreboard.set(slot: DisplaySlot, objective: Objective) = updateDisplaySlot(objective, slot)
operator fun Scoreboard.get(slot: DisplaySlot): Objective? = getObjective(slot).unwrap()

operator fun Score.inc(): Score = apply { score += 1 }
operator fun Score.dec(): Score = apply { score -= 1 }
operator fun Score.plusAssign(i: Int) { score += i }
operator fun Score.minusAssign(i: Int) { score -= i }
operator fun Score.timesAssign(i: Int) { score *= i }
operator fun Score.divAssign(i: Int) { score /= i }
operator fun Score.remAssign(i: Int) { score %= i }
operator fun Score.plus(i: Int): Int = score + i
operator fun Score.minus(i: Int): Int = score - i
operator fun Score.times(i: Int): Int = score * i
operator fun Score.div(i: Int): Int = score / i
operator fun Score.rem(i: Int): Int = score % i
operator fun Score.compareTo(i: Int): Int = score.compareTo(i)
operator fun Score.compareTo(s: Score): Int = score.compareTo(s.score)
operator fun Score.unaryPlus(): Int = +score
operator fun Score.unaryMinus(): Int = -score

operator fun Team.plusAssign(member: Text) = addMember(member)
operator fun Team.minusAssign(member: Text) { removeMember(member) }
operator fun Team.minus(member: Text): Boolean = removeMember(member)
operator fun Team.contains(member: Text): Boolean = member in members

operator fun Objective.plusAssign(score: Score) = addScore(score)
operator fun Objective.get(name: Text): Score? = getScore(name).unwrap()
operator fun Objective.invoke(name: Text): Score = getOrCreateScore(name)
operator fun Objective.contains(name: Text): Boolean = hasScore(name)
operator fun Objective.contains(score: Score): Boolean = score in scores.values
operator fun Objective.minusAssign(score: Score) { removeScore(score) }
operator fun Objective.minus(score: Score): Boolean = removeScore(score)
operator fun Objective.minusAssign(name: Text) { removeScore(name) }
operator fun Objective.minus(name: Text): Boolean = removeScore(name)
