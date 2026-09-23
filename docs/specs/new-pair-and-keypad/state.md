---
idea: new-pair-and-keypad
chain: trunk
step: 1
status: refining
waits on: none
remaining: 3q + 1r + 1i + 2f
---

# A new-pair button, and a keypad with 1 at the top left

## Why

- **`why`** — Two changes to the practice screen: a new `A × B` should be easy to get, and
  the keypad should start with 1 at the top left.

## Requirements

- **`r-new-pair`** — On the practice screen, a button lets the user easily get a new `A`
  and `B`.

## To land

Nothing yet: `r-new-pair` has no landing place until `q-new-pair-button` is answered.

## Reopened

- **`CAP-app/right-to-left-entry`** — in `app/SPEC.md`
  - **now says:** "On a keypad at the bottom of the screen (7 8 9 / 4 5 6 / 1 2 3 / ⌫ 0
    Enter), the user types each line right to left, digit after digit, starting at the
    first column left of its greyed zeros. Enter moves to the next line once the current
    one holds a digit. Erase removes the last digit typed, and on an empty line goes back
    to the end of the previous line."
  - **change:** the keypad starts with 1 at the top left; its digit rows per
    `a-phone-order`, its bottom row per `a-bottom-row-kept`.
  - **authority:** the brief: "the digit pad starts with 1 at the top left"
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the keypad)
  - **status:** planned

## Success signal

Nothing yet: it waits on `q-validation`.

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
  - **bears on:** `r-new-pair`

## Files

- `app/SPEC.md` — holds: `CAP-app/right-to-left-entry` (reopened) — planned
- `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` — holds:
  `CAP-app/right-to-left-entry` (reopened) — planned

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) On the Android Studio emulator on Windows, through `adb`: screenshots show the
      keypad with 1 at the top left, and tapping the new button shows a new `A × B` of the
      same digit count, as the app's screen is shown already
    - (b) The same, plus a JVM unit test that the new-pair action draws new operands and
      clears what was typed
  - **recommended:** (a), because every screen of the app is shown this way already, and
    both changes are about what the screen shows
  - **unblocks:** `r-new-pair`, `CAP-app/right-to-left-entry`, the Success signal
  - **raised by:** every brief is asked it
  - **answer:**
- **`q-new-pair-button`** — Tapping the current count button (2 to 6) already poses a new
  `A × B`. What should the new button be?
  - **options:**
    - (a) A "New" button at the end of the row of count buttons, at the top
    - (b) A "New" button beside Enter / Try again in the keypad's bottom row (this strikes
      `a-bottom-row-kept`)
    - (c) No new button: tapping the current count is enough (this amends the brief's "a
      button")
  - **recommended:** (a), because it sits beside the count buttons that already pose a new
    pair, and leaves the keypad's keys where the thumb expects them
  - **unblocks:** `r-new-pair`, its landing place and files
  - **raised by:** the brief: "a button to easily generate a new A/B", read against
    `CAP-app/pick-digit-count`
  - **answer:**
- **`q-new-pair-when`** — When can the new button be tapped?
  - **options:**
    - (a) Always: while typing, and after the check
    - (b) Only after the check (where it sits is still `q-new-pair-button`'s answer)
  - **recommended:** (a), because the count buttons can already be tapped at any time,
    and a pair the user does not want should be skippable
  - **unblocks:** `r-new-pair`
  - **raised by:** the brief: "a button to easily generate a new A/B"
  - **answer:**
