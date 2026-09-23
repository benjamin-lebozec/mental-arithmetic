// [provides: CAP-app/posed-layout] the one screen: the count buttons on top, the
// multiplication posed as by hand in the middle, the keypad at the bottom.
package mentalarithmetic.app

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mentalarithmetic.multiplication.DIGIT_COUNTS
import mentalarithmetic.multiplication.Mark
import mentalarithmetic.multiplication.digitsOf

private val ErrorRed = Color(0xFFD32F2F)
private val ZeroGrey = Color(0xFFB0B0B0)

@Composable
fun PracticeScreen() {
    val practice = remember { Practice() }
    Surface(Modifier.fillMaxSize()) {
        Column(Modifier.safeDrawingPadding().padding(16.dp)) {
            CountButtons(practice)
            Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                PosedGrid(practice)
            }
            Keypad(practice)
        }
    }
}

// [provides: CAP-app/pick-digit-count] one button per digit count; the current one is filled.
@Composable
private fun CountButtons(practice: Practice) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        for (digits in DIGIT_COUNTS) {
            val modifier = Modifier.weight(1f)
            val onClick = { practice.pickDigitCount(digits) }
            if (digits == practice.digitCount) {
                Button(onClick, modifier) { Text("$digits") }
            } else {
                OutlinedButton(onClick, modifier) { Text("$digits") }
            }
        }
        NewButton(practice, Modifier.weight(1f))
    }
}

// [provides: CAP-app/new-pair] at the end of the count row, New poses a new A × B with the
// current digit count, at any time, while typing or after the check.
// [uses: CAP-app/pick-digit-count]
@Composable
private fun NewButton(practice: Practice, modifier: Modifier) {
    OutlinedButton(
        { practice.pickDigitCount(practice.digitCount) },
        modifier,
        contentPadding = PaddingValues(horizontal = 4.dp),
    ) {
        Text("New", maxLines = 1, softWrap = false)
    }
}

// [provides: CAP-app/posed-layout] what one column of a row shows.
private data class Cell(
    val text: String,
    val color: Color = Color.Unspecified,
    val struck: Boolean = false,
    val boxed: Boolean = false,
    val underlined: Boolean = false,
)

// [provides: CAP-app/posed-layout] A, × B, the lines added up and the result, each digit in
// its column counted from the right; the shifted zeros are greyed.
@Composable
private fun PosedGrid(practice: Practice) {
    val posed = practice.posed
    val lines = posed.lines
    val rows = lines.indices.map { lineCells(practice, it) }
    // Room for the longest expected line (2 × the digit count) and anything typed beyond it.
    val columns = maxOf(2 * practice.digitCount, rows.maxOf { it.keys.maxOrNull()?.plus(1) ?: 0 })

    BoxWithConstraints(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        val cellWidth = minOf(maxWidth / (columns + 1), 36.dp)
        Column(horizontalAlignment = Alignment.End) {
            GridRow(null, givenCells(digitsOf(posed.operands.a)), columns, cellWidth)
            GridRow(Cell("×"), givenCells(digitsOf(posed.operands.b)), columns, cellWidth)
            HorizontalDivider(Modifier.width(cellWidth * (columns + 1)))
            for (i in posed.partialProducts.indices) {
                GridRow(if (i > 0) Cell("+") else null, rows[i], columns, cellWidth)
            }
            HorizontalDivider(Modifier.width(cellWidth * (columns + 1)))
            GridRow(null, rows[lines.lastIndex], columns, cellWidth)
        }
    }
}

private fun givenCells(digits: List<Int>): Map<Int, Cell> =
    digits.reversed().withIndex().associate { (column, digit) -> column to Cell("$digit") }

/**
 * The cells of line `index`, keyed by column from the right of the whole line: its greyed
 * zeros, the digits typed, the cursor on the line being typed, and, after the check, the marks.
 */
private fun lineCells(practice: Practice, index: Int): Map<Int, Cell> {
    val line = practice.posed.lines[index]
    val typed = practice.typed.getOrNull(index).orEmpty()
    val cells = mutableMapOf<Int, Cell>()
    for (column in 0 until line.shiftedZeros) cells[column] = Cell("0", ZeroGrey)
    for ((column, digit) in typed.withIndex()) cells[line.shiftedZeros + column] = Cell("$digit")
    cursorCell(practice, index, line.shiftedZeros + typed.size, cells)
    markCells(practice, index, line.shiftedZeros, typed, cells)
    return cells
}

// [provides: CAP-app/right-to-left-entry] on the line being typed, the column the next digit
// goes in is underlined.
private fun cursorCell(practice: Practice, index: Int, column: Int, cells: MutableMap<Int, Cell>) {
    if (!practice.checked && index == practice.typed.lastIndex) cells[column] = Cell("", underlined = true)
}

// [provides: CAP-app/check-at-end] a wrong digit in red, a missing column boxed in red, an
// extra digit struck through in red.
private fun markCells(practice: Practice, index: Int, shift: Int, typed: List<Int>, cells: MutableMap<Int, Cell>) {
    val marks = practice.marks?.get(index) ?: return
    for ((column, mark) in marks) {
        cells[shift + column] = when (mark) {
            Mark.WRONG -> Cell("${typed[column]}", ErrorRed)
            Mark.EXTRA -> Cell("${typed[column]}", ErrorRed, struck = true)
            Mark.MISSING -> Cell("", boxed = true)
        }
    }
}

// [provides: CAP-app/posed-layout] one row: a sign column, then the digit columns, leftmost first.
@Composable
private fun GridRow(sign: Cell?, cells: Map<Int, Cell>, columns: Int, cellWidth: Dp) {
    Row {
        GridCell(sign, cellWidth)
        for (column in columns - 1 downTo 0) GridCell(cells[column], cellWidth)
    }
}

@Composable
private fun GridCell(cell: Cell?, width: Dp) {
    var modifier = Modifier.size(width, width * 1.4f).padding(1.dp)
    if (cell?.boxed == true) modifier = modifier.border(2.dp, ErrorRed)
    Box(modifier, contentAlignment = Alignment.Center) {
        if (cell == null) return@Box
        if (cell.underlined) {
            HorizontalDivider(
                Modifier.align(Alignment.BottomCenter).padding(horizontal = 2.dp),
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary,
            )
        }
        val fontSize = with(LocalDensity.current) { (width * 0.95f).toSp() }
        Text(
            cell.text,
            color = cell.color,
            fontSize = fontSize,
            fontFamily = FontFamily.Monospace,
            textDecoration = if (cell.struck) TextDecoration.LineThrough else null,
        )
    }
}

// [provides: CAP-app/right-to-left-entry] the keypad: 1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter.
@Composable
private fun Keypad(practice: Practice) {
    val typing = !practice.checked
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (row in listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                for (digit in row) Key("$digit", typing, Modifier.weight(1f)) { practice.typeDigit(digit) }
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Key("⌫", typing, Modifier.weight(1f)) { practice.erase() }
            Key("0", typing, Modifier.weight(1f)) { practice.typeDigit(0) }
            EndKey(practice, Modifier.weight(1f))
        }
        Spacer(Modifier.height(8.dp))
    }
}

// [provides: CAP-app/try-again] after the check, Try again takes Enter's place.
@Composable
private fun EndKey(practice: Practice, modifier: Modifier) {
    if (practice.checked) {
        Key("Try again", true, modifier) { practice.tryAgain() }
    } else {
        Key("Enter", true, modifier) { practice.enter() }
    }
}

// [provides: CAP-app/right-to-left-entry] one key of the keypad.
@Composable
private fun Key(label: String, enabled: Boolean, modifier: Modifier, onClick: () -> Unit) {
    OutlinedButton(
        onClick,
        modifier.height(56.dp),
        enabled = enabled,
        contentPadding = PaddingValues(horizontal = 4.dp),
    ) {
        Text(label, fontSize = 20.sp, maxLines = 1, softWrap = false)
    }
}
