// [provides: CAP-multiplication/partial-products] the lines of a multiplication posed as by
// hand: one partial product per digit of B, then the result.
package mentalarithmetic.multiplication

/**
 * One line to type: `digits`, most significant first, followed by `shiftedZeros` zeros that
 * are written in advance and not typed.
 */
data class Line(val digits: List<Int>, val shiftedZeros: Int)

/** `a × b` posed as by hand. */
data class PosedMultiplication(
    val operands: Operands,
    /** One per digit of `b`, from its rightmost digit leftwards; the k-th has k shifted zeros. */
    val partialProducts: List<Line>,
    val result: Line,
) {
    /** Every line the user types, in order: the partial products, then the result. */
    val lines: List<Line> get() = partialProducts + result
}

fun pose(operands: Operands): PosedMultiplication {
    val (a, b) = operands
    val partialProducts = digitsOf(b).reversed().mapIndexed { k, digit ->
        Line(digitsOf(a * digit), shiftedZeros = k)
    }
    return PosedMultiplication(operands, partialProducts, Line(digitsOf(a * b), shiftedZeros = 0))
}

/** The decimal digits of `n`, most significant first; 0 gives the single digit 0. */
fun digitsOf(n: Long): List<Int> = n.toString().map { it - '0' }
