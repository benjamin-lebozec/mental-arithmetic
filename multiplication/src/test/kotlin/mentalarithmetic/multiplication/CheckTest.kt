// [demonstrates: CAP-multiplication/check-lines] right lines carry no mark; a wrong digit, a
// line too short and a line too long are marked by column.
package mentalarithmetic.multiplication

import org.junit.Assert.assertEquals
import org.junit.Test

class CheckTest {
    // 47 × 36: partial products 282 and 141(0), result 1692. Typed digits are rightmost first.
    private val posed = pose(Operands(47, 36))

    @Test
    fun linesTypedRightCarryNoMark() {
        val marks = check(posed, listOf(listOf(2, 8, 2), listOf(1, 4, 1), listOf(2, 9, 6, 1)))
        assertEquals(listOf(emptyList<ColumnMark>(), emptyList(), emptyList()), marks)
    }

    @Test
    fun aWrongDigitMarksItsColumnWrong() {
        assertEquals(listOf(ColumnMark(1, Mark.WRONG)), checkLine(posed.result, listOf(2, 8, 6, 1)))
    }

    @Test
    fun aLineTooShortMarksItsMissingColumns() {
        assertEquals(
            listOf(ColumnMark(2, Mark.MISSING), ColumnMark(3, Mark.MISSING)),
            checkLine(posed.result, listOf(2, 9)),
        )
    }

    @Test
    fun aLineTooLongMarksItsExtraColumns() {
        assertEquals(
            listOf(ColumnMark(3, Mark.EXTRA), ColumnMark(4, Mark.EXTRA)),
            checkLine(posed.partialProducts[0], listOf(2, 8, 2, 0, 5)),
        )
    }
}
