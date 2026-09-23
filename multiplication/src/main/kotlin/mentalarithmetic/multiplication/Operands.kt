// [provides: CAP-multiplication/draw-operands] the random draw of A and B, both with the
// same digit count.
package mentalarithmetic.multiplication

import kotlin.random.Random

/** The digit counts a multiplication can be posed with. */
val DIGIT_COUNTS = 2..6

/** The two numbers multiplied: `a × b`. */
data class Operands(val a: Long, val b: Long)

/** Draws `a` and `b` at random, each with exactly `digits` digits, so with no leading zero. */
fun drawOperands(digits: Int, random: Random = Random.Default): Operands {
    require(digits in DIGIT_COUNTS) { "digit count must be in $DIGIT_COUNTS, was $digits" }
    var low = 1L
    repeat(digits - 1) { low *= 10 }
    val high = low * 10
    return Operands(random.nextLong(low, high), random.nextLong(low, high))
}
