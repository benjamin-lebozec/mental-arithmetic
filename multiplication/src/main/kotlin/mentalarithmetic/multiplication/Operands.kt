// [provides: CAP-multiplication/draw-operands] the random draw of A and B, both with the
// same digit count, none of their digits a 0.
package mentalarithmetic.multiplication

import kotlin.random.Random

/** The digit counts a multiplication can be posed with. */
val DIGIT_COUNTS = 2..6

/** The two numbers multiplied: `a × b`. */
data class Operands(val a: Long, val b: Long)

/** Draws `a` and `b` at random, each with exactly `digits` digits, every one from 1 to 9. */
fun drawOperands(digits: Int, random: Random = Random.Default): Operands {
    require(digits in DIGIT_COUNTS) { "digit count must be in $DIGIT_COUNTS, was $digits" }
    return Operands(drawNumber(digits, random), drawNumber(digits, random))
}

private fun drawNumber(digits: Int, random: Random): Long {
    var n = 0L
    repeat(digits) { n = n * 10 + random.nextInt(1, 10) }
    return n
}
