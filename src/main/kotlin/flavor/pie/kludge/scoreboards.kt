package flavor.pie.kludge

import org.spongepowered.api.scoreboard.Score
import org.spongepowered.api.scoreboard.Scoreboard
import org.spongepowered.api.scoreboard.Team
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot
import org.spongepowered.api.scoreboard.objective.Objective
import org.spongepowered.api.text.Text

/**
 * @see Scoreboard.addObjective
 */
operator fun Scoreboard.plusAssign(objective: Objective) = addObjective(objective)

/**
 * @see Scoreboard.removeObjective
 */
operator fun Scoreboard.minusAssign(objective: Objective) = removeObjective(objective)

/**
 * Checks if this scoreboard's objectives contain [objective].
 * @see Scoreboard.getObjectives
 */
operator fun Scoreboard.contains(objective: Objective): Boolean = objective in objectives

/**
 * @see Scoreboard.updateDisplaySlot
 */
operator fun Scoreboard.set(slot: DisplaySlot, objective: Objective) = updateDisplaySlot(objective, slot)

/**
 * @see Scoreboard.getObjective
 */
operator fun Scoreboard.get(slot: DisplaySlot): Objective? = getObjective(slot).unwrap()

/**
 * Adds one to this score.
 * @see Score.setScore
 */
operator fun Score.inc(): Score = apply { score += 1 }

/**
 * Subtracts one from this score.
 * @see Score.setScore
 */
operator fun Score.dec(): Score = apply { score -= 1 }

/**
 * Adds [i] to this score.
 * @see Score.setScore
 */
operator fun Score.plusAssign(i: Int) { score += i }

/**
 * Removes [i] from this score.
 * @see Score.setScore
 */
operator fun Score.minusAssign(i: Int) { score -= i }

/**
 * Multiplies this score by [i].
 * @see Score.setScore
 */
operator fun Score.timesAssign(i: Int) { score *= i }

/**
 * Divides this score by [i].
 * @see Score.setScore
 */
operator fun Score.divAssign(i: Int) { score /= i }

/**
 * Modulo's this score by [i].
 * @see Score.setScore
 */
operator fun Score.remAssign(i: Int) { score %= i }

/**
 * Gets this score plus [i].
 * @see Score.getScore
 */
operator fun Score.plus(i: Int): Int = score + i

/**
 * Gets this score minus [i].
 * @see Score.getScore
 */
operator fun Score.minus(i: Int): Int = score - i

/**
 * Gets this score times [i].
 * @see Score.getScore
 */
operator fun Score.times(i: Int): Int = score * i

/**
 * Gets this score divided by [i].
 * @see Score.getScore
 */
operator fun Score.div(i: Int): Int = score / i

/**
 * Gets the modulo of this score by [i].
 * @see Score.getScore
 */
operator fun Score.rem(i: Int): Int = score % i

/**
 * Compares this score to [i].
 * @see Score.getScore
 */
operator fun Score.compareTo(i: Int): Int = score.compareTo(i)

/**
 * Compares the two scores.
 * @see Score.getScore
 */
operator fun Score.compareTo(s: Score): Int = score.compareTo(s.score)

/**
 * Gets the score.
 * @see Score.getScore
 */
operator fun Score.unaryPlus(): Int = +score

/**
 * Gets the score multiplied by -1.
 * @see Score.getScore
 */
operator fun Score.unaryMinus(): Int = -score

/**
 * @see Team.addMember
 */
operator fun Team.plusAssign(member: Text) = addMember(member)

/**
 * @see Team.removeMember
 */
operator fun Team.minusAssign(member: Text) { removeMember(member) }

/**
 * @see Team.removeMember
 */
operator fun Team.minus(member: Text): Boolean = removeMember(member)

/**
 * Checks if this team's members contain [member].
 * @see Team.getMembers
 */
operator fun Team.contains(member: Text): Boolean = member in members

/**
 * @see Objective.addScore
 */
operator fun Objective.plusAssign(score: Score) = addScore(score)

/**
 * @see Objective.getScore
 */
operator fun Objective.get(name: Text): Score? = getScore(name).unwrap()

/**
 * @see Objective.getOrCreateScore
 */
operator fun Objective.invoke(name: Text): Score = getOrCreateScore(name)

/**
 * @see Objective.hasScore
 */
operator fun Objective.contains(name: Text): Boolean = hasScore(name)

/**
 * Checks if [score] is in [Objective.getScores].
 */
operator fun Objective.contains(score: Score): Boolean = score in scores.values

/**
 * @see Objective.removeScore
 */
operator fun Objective.minusAssign(score: Score) { removeScore(score) }

/**
 * @see Objective.removeScore
 */
operator fun Objective.minus(score: Score): Boolean = removeScore(score)

/**
 * @see Objective.removeScore
 */
operator fun Objective.minusAssign(name: Text) { removeScore(name) }

/**
 * @see Objective.removeScore
 */
operator fun Objective.minus(name: Text): Boolean = removeScore(name)
