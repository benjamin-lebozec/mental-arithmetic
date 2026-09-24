---
idea: no-zero-and-new
chain: trunk
step: 1
status: refining
waits on: none
remaining: 2q + 1r + 0i + 7f
---

# No 0 digit in A and B, and New in place of Try again after a correct result

## Why

- **`why`** — Two changes to the practice: `A` and `B` should have no 0 digit, and at the
  end of a game whose result is correct, the button that takes Enter's place should pose a
  new multiplication rather than the same one again.

## Requirements

- **`r-new-when-correct`** — At the end of a game, if the result is correct, a New button
  stands where Try again stands now, and poses a new `A` and `B`.

## To land

Nothing yet: `r-new-when-correct` has no success criterion until `q-validation` is
answered, and its meaning of "correct" waits on `q-correct-means`.

## Reopened

- **`CAP-multiplication/draw-operands`** — in `multiplication/SPEC.md`
  - **now says:** "For a digit count n from 2 to 6, `A` and `B` are drawn at random, each
    with exactly n digits." with success "A JVM unit test, run in the Docker build, shows
    that for each n from 2 to 6, every one of 1000 draws gives `A` and `B` of exactly n
    digits." and assumes "exactly n digits means no leading zero."
  - **change:** neither `A` nor `B` has a 0 digit, in any position; its success criterion
    waits on `q-validation`.
  - **authority:** the brief: "no "0" digit in A/B"
  - **held in:** `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt`
    (the draw)
  - **status:** planned
- **`CAP-app/try-again`** — in `app/SPEC.md`
  - **now says:** "After the check, a Try again button takes Enter's place; tapping it
    clears every digit the user typed and poses the same `A` and `B` again."
  - **change:** Try again takes Enter's place only after a check where the result is not
    correct; after a correct one, New takes it, per `r-new-when-correct`.
  - **authority:** the brief: "at the end of a game, if the result is correct, insteady of
    "try again" => "new""
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the key in
    Enter's place), `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (what Try
    again does)
  - **status:** planned

## Success signal

Nothing yet: it waits on `q-validation`.

## Assumptions

- **`a-new-as-new-pair`** — The New that takes Enter's place does what the New button at
  the top does (`CAP-app/new-pair`): it poses a new `A` and `B` of the digit count
  currently chosen.
  - **raised by:** the brief: "insteady of "try again" => "new""
  - **bears on:** `r-new-when-correct`

## Files

- `multiplication/SPEC.md` — holds: `CAP-multiplication/draw-operands` (reopened) —
  planned
- `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt` — holds:
  `CAP-multiplication/draw-operands` (reopened) — planned
- `multiplication/src/test/kotlin/mentalarithmetic/multiplication/OperandsTest.kt` —
  holds: `CAP-multiplication/draw-operands` (reopened, its demonstration) — planned
- `app/SPEC.md` — holds: `CAP-app/try-again` (reopened) — planned
- `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` — holds: `CAP-app/try-again`
  (reopened) — planned
- `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` — holds:
  `CAP-app/try-again` (reopened) — planned
- `.github/screenshot.png` — holds: the README's screenshot under `CAP-root/readme`, kept,
  which shows `405 × 186`: once the reopened draw lands, `A` = 405 is a pair the app can no
  longer pose, so the screenshot is taken again — planned

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) A JVM unit test, run in the Docker build, shows that for each n from 2 to 6,
      every one of 1000 draws gives `A` and `B` of exactly n digits, none of them a 0; and on
      the Android Studio emulator on Windows, through `adb`, a game is played to a correct
      result and the screenshot shows New in Enter's place, tapping it shows a new `A × B`,
      and a game ended with an error still shows Try again
    - (b) The same, without the emulator: only the unit test, and the app's change judged
      by reading the code
  - **recommended:** (a), because the draw is already shown by a unit test, and every
    screen of the app is shown on the emulator already
  - **unblocks:** `CAP-multiplication/draw-operands` (reopened), `r-new-when-correct`,
    `CAP-app/try-again` (reopened), the Success signal
  - **raised by:** every brief is asked it
  - **answer:**
- **`q-correct-means`** — "If the result is correct": which lines must be right for New to
  replace Try again?
  - **options:**
    - (a) Only the result line: it carries no mark, even if a partial product is wrong
    - (b) Every line: no partial product and not the result carries any mark
  - **recommended:** (a), because it is what the brief says, and a user who reached the
    right result by keeping part of it in their head has done the mental arithmetic
  - **unblocks:** `r-new-when-correct`, `CAP-app/try-again` (reopened)
  - **raised by:** the brief: "if the result is correct", read against
    `CAP-multiplication/check-lines`, which marks every typed line
  - **answer:**
