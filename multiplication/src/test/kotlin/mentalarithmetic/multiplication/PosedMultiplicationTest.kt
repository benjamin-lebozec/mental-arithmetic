// [demonstrates: CAP-multiplication/partial-products] the lines posed for fixed A and B, one
// of them with a 0 digit in B.
package mentalarithmetic.multiplication

import org.junit.Assert.assertEquals
import org.junit.Test

class PosedMultiplicationTest {
    @Test
    fun onePartialProductPerDigitOfBFromTheRight() {
        val posed = pose(Operands(1234, 5078))
        assertEquals(
            listOf(
                Line(listOf(9, 8, 7, 2), 0), // 1234 × 8
                Line(listOf(8, 6, 3, 8), 1), // 1234 × 7
                Line(listOf(0), 2), //          1234 × 0
                Line(listOf(6, 1, 7, 0), 3), // 1234 × 5
            ),
            posed.partialProducts,
        )
        assertEquals(Line(listOf(6, 2, 6, 6, 2, 5, 2), 0), posed.result)
    }

    @Test
    fun twoDigitOperands() {
        val posed = pose(Operands(47, 36))
        assertEquals(listOf(Line(listOf(2, 8, 2), 0), Line(listOf(1, 4, 1), 1)), posed.partialProducts)
        assertEquals(Line(listOf(1, 6, 9, 2), 0), posed.result)
    }
}
