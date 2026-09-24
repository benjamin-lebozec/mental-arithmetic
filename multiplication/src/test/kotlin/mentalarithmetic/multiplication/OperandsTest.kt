// [demonstrates: CAP-multiplication/draw-operands] every draw, for each digit count, gives A
// and B of exactly that many digits, none of them a 0.
package mentalarithmetic.multiplication

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class OperandsTest {
    @Test
    fun everyDrawHasExactlyTheChosenDigitCount() {
        for (digits in 2..6) {
            repeat(1000) {
                val (a, b) = drawOperands(digits)
                assertEquals("a = $a", digits, a.toString().length)
                assertEquals("b = $b", digits, b.toString().length)
                assertFalse("a = $a", '0' in a.toString())
                assertFalse("b = $b", '0' in b.toString())
            }
        }
    }
}
