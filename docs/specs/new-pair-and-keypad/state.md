---
idea: new-pair-and-keypad
chain: trunk
step: 2
status: refining
waits on: none
remaining: 0q + 0r + 4i + 3f
---

# A new-pair button, and a keypad with 1 at the top left

## Why

- **`why`** — Two changes to the practice screen: a new `A × B` should be easy to get, and
  the keypad should start with 1 at the top left.

## Requirements

Nothing left: `r-new-pair` is now `CAP-app/new-pair`.

## To land

- **`CAP-app/new-pair`** — On the one screen, a New button sits at the end of the row of
  count buttons, on top; tapping it at any time, while typing or after the check, poses a
  new `A` and `B`.
  - **success:** On the Android Studio emulator on Windows, New is tapped through `adb`,
    once while a line is being typed and once after the check, and the screenshot after
    each tap shows a new `A × B` of the same digit count.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the row of
    count buttons)
  - **status:** planned

## Reopened

- **`CAP-app/right-to-left-entry`** — in `app/SPEC.md`
  - **now says:** "On a keypad at the bottom of the screen (7 8 9 / 4 5 6 / 1 2 3 / ⌫ 0
    Enter), the user types each line right to left, digit after digit, starting at the
    first column left of its greyed zeros. Enter moves to the next line once the current
    one holds a digit. Erase removes the last digit typed, and on an empty line goes back
    to the end of the previous line."
  - **change:** the keypad reads 1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter, 1 at the top left: the
    parenthesis of its text becomes "(1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter)", and the rest of
    its text is unchanged. Its success criterion gains: "and a screenshot shows the keypad
    with 1 at the top left". `a-phone-order` and `a-bottom-row-kept` land in its
    `assumes:` line.
  - **authority:** the brief: "the digit pad starts with 1 at the top left"; the answer to
    `q-validation`, for the success criterion
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the keypad)
  - **status:** planned
- **`CAP-app/check-at-end`** — in `app/SPEC.md`
  - **now says:** "**assumes:** after the check, the digit and erase keys do nothing until
    Try again or a count button is tapped."
  - **change:** its `assumes:` line reads "after the check, the digit and erase keys do
    nothing until Try again, a count button or New is tapped."; the rest of its text is
    unchanged.
  - **authority:** the answer to `q-new-pair-when`: (a) "Always: while typing, and after
    the check"
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (New, through
    the pair it poses); `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (the comment
    on `typeDigit` that restates the `assumes:` line)
  - **status:** planned
- **`LIM-app/hidden-when-sideways`** — in `app/SPEC.md`
  - **now says:** "… and what `CAP-app/pick-digit-count` and `CAP-app/try-again` pose hold
    only while it is upright."
  - **change:** that list reads "and what `CAP-app/pick-digit-count`, `CAP-app/new-pair`
    and `CAP-app/try-again` pose"; the rest of its text is unchanged.
  - **authority:** the answer to `q-new-pair-button`: (a) "New at top", which adds a
    button that poses a pair
  - **held in:** no code: a limit is not cited
  - **status:** planned

## Success signal

- **`s-new-pair-and-keypad`** — On the Android Studio emulator on Windows, through `adb`,
  screenshots show the keypad with 1 at the top left, and tapping the new button shows a
  new `A × B` of the same digit count.

## Assumptions

- **`a-bottom-row-kept`** — The keypad's bottom row stays ⌫ 0 Enter; only the three digit
  rows change order.
  - **raised by:** the brief: "the digit pad starts with 1 at the top left"
  - **bears on:** `CAP-app/right-to-left-entry`
- **`a-phone-order`** — The digit rows read 1 2 3 / 4 5 6 / 7 8 9, as on a phone.
  - **raised by:** the brief: "the digit pad starts with 1 at the top left"
  - **bears on:** `CAP-app/right-to-left-entry`
- **`a-new-pair-same-count`** — The new `A` and `B` have the digit count currently chosen.
  - **raised by:** the brief: "a button to easily generate a new A/B"
  - **bears on:** `CAP-app/new-pair`

## Files

- `app/SPEC.md` — holds: `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`,
  `LIM-app/hidden-when-sideways` (reopened), `CAP-app/new-pair` — planned
- `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` — holds:
  `CAP-app/right-to-left-entry`, `CAP-app/check-at-end` (reopened), `CAP-app/new-pair` —
  planned

- `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` — holds: `CAP-app/check-at-end`
  (reopened) — planned

## Open Questions

None.
