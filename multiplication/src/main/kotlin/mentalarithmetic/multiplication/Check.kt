// [provides: CAP-multiplication/check-lines] the check of the typed lines against the posed
// ones, column by column from the right.
package mentalarithmetic.multiplication

enum class Mark { WRONG, MISSING, EXTRA }

/** A mark on a column, counted from 0 at the rightmost column of a line's typed part. */
data class ColumnMark(val column: Int, val mark: Mark)

/**
 * Checks one typed line against `expected`. `typed` lists the digits in the order they were
 * typed, so rightmost first. No mark means the line is right.
 */
fun checkLine(expected: Line, typed: List<Int>): List<ColumnMark> {
    val expectedFromRight = expected.digits.reversed()
    return (0 until maxOf(expectedFromRight.size, typed.size)).mapNotNull { column ->
        val want = expectedFromRight.getOrNull(column)
        val got = typed.getOrNull(column)
        when {
            want == null -> ColumnMark(column, Mark.EXTRA)
            got == null -> ColumnMark(column, Mark.MISSING)
            want != got -> ColumnMark(column, Mark.WRONG)
            else -> null
        }
    }
}

/** Checks every typed line, in the order of `PosedMultiplication.lines`. */
fun check(posed: PosedMultiplication, typed: List<List<Int>>): List<List<ColumnMark>> {
    require(typed.size == posed.lines.size) { "expected ${posed.lines.size} typed lines, got ${typed.size}" }
    return posed.lines.zip(typed) { line, digits -> checkLine(line, digits) }
}
