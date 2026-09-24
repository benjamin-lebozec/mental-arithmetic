---
idea: no-zero-and-new
chain: trunk
step: 2
status: refining
waits on: none
remaining: 0q + 0r + 1i + 7f
---

# No 0 digit in A and B, and New in place of Try again after a correct result

## Why

- **`why`** — Two changes to the practice: `A` and `B` should have no 0 digit, and at the
  end of a game whose result is correct, the button that takes Enter's place should pose a
  new multiplication rather than the same one again.

## Requirements

No requirements left.

## To land

- **`CAP-app/new-when-correct`** — After a check where no line carries a mark, a New
  button takes Enter's place; tapping it poses a new `A` and `B`.
  - **success:** On the Android Studio emulator on Windows, a game is played through `adb`
    to a check where no line carries a mark, and the screenshot shows New in Enter's place;
    New is tapped, and the screenshot shows a new `A × B`.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (whether no line
    carries a mark, and what New does), `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`
    (the key in Enter's place)
  - **status:** planned

## Reopened

- **`CAP-multiplication/draw-operands`** — in `multiplication/SPEC.md`
  - **now says:** "For a digit count n from 2 to 6, `A` and `B` are drawn at random, each
    with exactly n digits." with success "A JVM unit test, run in the Docker build, shows
    that for each n from 2 to 6, every one of 1000 draws gives `A` and `B` of exactly n
    digits." and assumes "exactly n digits means no leading zero."
  - **change:** the claim becomes "For a digit count n from 2 to 6, `A` and `B` are drawn
    at random, each with exactly n digits, none of them 0.", its success "A JVM unit test,
    run in the Docker build, shows that for each n from 2 to 6, every one of 1000 draws
    gives `A` and `B` of exactly n digits, none of them a 0.", and its assumes line goes,
    since a number with no 0 digit has no leading zero.
  - **authority:** the brief: "no "0" digit in A/B"; the success, the answer to
    `q-validation`
  - **held in:** `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt`
    (the draw)
  - **status:** planned
- **`CAP-app/try-again`** — in `app/SPEC.md`
  - **now says:** "After the check, a Try again button takes Enter's place; tapping it
    clears every digit the user typed and poses the same `A` and `B` again."
  - **change:** the claim becomes "After a check where some line carries a mark, a Try
    again button takes Enter's place; tapping it clears every digit the user typed and
    poses the same `A` and `B` again.", and its success "On the Android Studio emulator on
    Windows, after a check where some line carries a mark, Try again is tapped through
    `adb`, and the screenshot shows the typed digits cleared and `A` and `B` unchanged."
    After a check where no line carries a mark, New takes its place, per
    `CAP-app/new-when-correct`.
  - **authority:** the brief: "at the end of a game, if the result is correct, insteady of
    "try again" => "new""; "correct", the answer to `q-correct-means`; the success, the
    answer to `q-validation`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the key in
    Enter's place), `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (what Try
    again does)
  - **status:** planned
- **`LIM-app/hidden-when-sideways`** — in `app/SPEC.md`
  - **now says:** "Held sideways, the app is shown upright in a letterbox too short for the
    multiplication, which is hidden until the device is turned upright again, the practice
    kept: `CAP-app/posed-layout`, the lines typed under `CAP-app/right-to-left-entry`, the
    marks of `CAP-app/check-at-end`, and what `CAP-app/pick-digit-count`,
    `CAP-app/new-pair` and `CAP-app/try-again` pose hold only while it is upright."
  - **change:** `CAP-app/new-when-correct` is named beside `CAP-app/try-again`: "… and what
    `CAP-app/pick-digit-count`, `CAP-app/new-pair`, `CAP-app/try-again` and
    `CAP-app/new-when-correct` pose hold only while it is upright."
  - **authority:** the brief: "insteady of "try again" => "new"": the New in Enter's place
    is hidden sideways as Try again is
  - **held in:** no code: review
  - **status:** planned

## Success signal

- **`s-no-zero-and-new`** — The unit test shows, for each count from 2 to 6, 1000 draws of
  `A` and `B` with no 0 digit; and on the emulator, a game ended with every line right
  shows New in Enter's place, which poses a new `A × B`, while a game ended with an error
  still shows Try again.

## Assumptions

- **`a-new-as-new-pair`** — The New that takes Enter's place does what the New button at
  the top does (`CAP-app/new-pair`): it poses a new `A` and `B` of the digit count
  currently chosen.
  - **raised by:** the brief: "insteady of "try again" => "new""
  - **bears on:** `CAP-app/new-when-correct`, as its assumes line "the new `A` and `B` have
    the digit count currently chosen."

## Files

- `multiplication/SPEC.md` — holds: `CAP-multiplication/draw-operands` (reopened) —
  planned
- `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt` — holds:
  `CAP-multiplication/draw-operands` (reopened) — planned
- `multiplication/src/test/kotlin/mentalarithmetic/multiplication/OperandsTest.kt` —
  holds: `CAP-multiplication/draw-operands` (reopened, its demonstration) — planned
- `app/SPEC.md` — holds: `CAP-app/try-again` (reopened), `CAP-app/new-when-correct`,
  `LIM-app/hidden-when-sideways` (reopened) — planned
- `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` — holds: `CAP-app/try-again`
  (reopened), `CAP-app/new-when-correct` — planned
- `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` — holds:
  `CAP-app/try-again` (reopened), `CAP-app/new-when-correct` — planned
- `.github/screenshot.png` — holds: the README's screenshot under `CAP-root/readme`, kept,
  which shows `405 × 186`: once the reopened draw lands, `A` = 405 is a pair the app can no
  longer pose, so the screenshot is taken again — planned

## Open Questions

None.
