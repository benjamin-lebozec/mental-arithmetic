// [provides: CAP-app/right-to-left-entry] the state of one practice: the posed
// multiplication, the digits typed on each line, and, once checked, the marks.
// [uses: CAP-multiplication/draw-operands] [uses: CAP-multiplication/partial-products]
// [uses: CAP-multiplication/check-lines]
package mentalarithmetic.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import mentalarithmetic.multiplication.ColumnMark
import mentalarithmetic.multiplication.PosedMultiplication
import mentalarithmetic.multiplication.check
import mentalarithmetic.multiplication.drawOperands
import mentalarithmetic.multiplication.pose
import kotlin.random.Random

class Practice(private val random: Random = Random.Default) {
    // [provides: CAP-app/pick-digit-count] at launch, the count is 2, as if it had been tapped.
    var digitCount by mutableStateOf(2)
        private set

    var posed: PosedMultiplication by mutableStateOf(pose(drawOperands(digitCount, random)))
        private set

    // [provides: CAP-app/right-to-left-entry]
    /**
     * The digits typed on each line reached so far, in the order typed (rightmost first).
     * The last one is the line being typed.
     */
    var typed: List<List<Int>> by mutableStateOf(listOf(emptyList()))
        private set

    // [provides: CAP-app/check-at-end] one list of marks per line once the result line is
    // ended; null before.
    var marks: List<List<ColumnMark>>? by mutableStateOf(null)
        private set

    val checked: Boolean get() = marks != null

    // [provides: CAP-app/pick-digit-count] any count, the current one too, poses a new A × B.
    fun pickDigitCount(digits: Int) {
        digitCount = digits
        posed = pose(drawOperands(digits, random))
        clearTyped()
    }

    // [provides: CAP-app/right-to-left-entry] each line is typed rightmost digit first; Enter
    // needs a digit on the line; erase on an empty line goes back to the previous one. After
    // the check, digits and erase do nothing until Try again, a count or New is tapped.
    fun typeDigit(digit: Int) {
        if (checked) return
        typed = typed.dropLast(1) + listOf(typed.last() + digit)
    }

    fun erase() {
        if (checked) return
        typed = when {
            typed.last().isNotEmpty() -> typed.dropLast(1) + listOf(typed.last().dropLast(1))
            typed.size > 1 -> typed.dropLast(1)
            else -> typed
        }
    }

    fun enter() {
        if (checked || typed.last().isEmpty()) return
        if (typed.size < posed.lines.size) {
            typed = typed + listOf(emptyList())
        } else {
            endResultLine()
        }
    }

    // [provides: CAP-app/check-at-end] ending the result line checks every typed line.
    private fun endResultLine() {
        marks = check(posed, typed)
    }

    // [provides: CAP-app/try-again] clears the typed digits and keeps A and B.
    fun tryAgain() {
        clearTyped()
    }

    // [provides: CAP-app/right-to-left-entry] every line empty, typing back on the first one.
    private fun clearTyped() {
        typed = listOf(emptyList())
        marks = null
    }
}
