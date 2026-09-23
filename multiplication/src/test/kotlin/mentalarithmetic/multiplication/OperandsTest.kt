// [demonstrates: CAP-multiplication/draw-operands] every draw, for each digit count, gives A
// and B of exactly that many digits.
package mentalarithmetic.multiplication

import org.junit.Assert.assertEquals
import org.junit.Test

class OperandsTest {
    @Test
    fun everyDrawHasExactlyTheChosenDigitCount() {
        for (digits in 2..6) {
            repeat(1000) {
                val (a, b) = drawOperands(digits)
                assertEquals("a = $a", digits, a.toString().length)
                assertEquals("b = $b", digits, b.toString().length)
            }
        }
    }
}
