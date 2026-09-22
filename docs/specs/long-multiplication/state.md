---
idea: long-multiplication
chain: trunk
step: 2
status: refining
waits on: none
remaining: 4q + 7r + 0i + 0f
---

# Long multiplication, posed as by hand

## Why

- **`why`** — The user wants a simple app to practise mental arithmetic, multiplication
  first. What sets it apart: the multiplication is posed as it is done by hand, on several
  lines with every digit aligned, and the user types each intermediate line in turn.

## Requirements

- **`r-practise-multiplication`** — A user can practise long multiplication in the app.
  This version poses no other operation; other operations are later ideas.
- **`r-posed-layout`** — A multiplication is shown posed as it is done by hand, on several
  lines: `A`, `× B`, the partial products added up (`CCCCCC + DDDDDD0 + EEEE00`), then the
  result, with every digit aligned in its column. The trailing zeros of each shifted
  partial product are written by the app in advance, greyed.
- **`r-choose-digit-count`** — A user can easily choose the difficulty, as the number of
  digits of `A` and `B`, which is the same for both, from 2 to 6.
- **`r-right-to-left-entry`** — A user types each intermediate line right to left, digit
  after digit, and presses Enter to move to the next line. On a shifted line, typing
  starts at the first column left of the greyed zeros. No digit is checked while the lines
  are typed.
- **`r-check-at-end`** — Once the result line is entered, every typed digit is checked, and
  the errors are shown.
- **`r-try-again`** — After the check, a Try again button clears every digit the user typed
  and poses the same `A` and `B` again.
- **`r-docker-build`** — The APK is built, and the JVM unit tests run, in a Docker
  container, with nothing installed on the host but Docker.

## To land

Nothing left to land.

## Reopened

Nothing reopened.

## Success signal

- **`s-practised-on-emulator`** — On the Android Studio emulator on Windows, the user
  installs the APK the Docker build produced, picks a digit count from 2 to 6, and is shown
  `A × B` posed by hand, every digit aligned and the shifted zeros greyed. They type each
  partial product and the result right to left, with Enter after each line, are shown at
  the end which digits are wrong, and Try again clears their digits and keeps `A` and `B`.
  The user judges each screen there, so every screen criterion lands with a limit saying it
  is shown only by manual review.
- **`s-unit-tests-in-docker`** — The JVM unit tests of every module pass when run in the
  Docker build.

## Assumptions

- **`a-android`** — The app is an Android app, written in Kotlin with Jetpack Compose.
  - **raised by:** "i want a simple app"
  - **bears on:** every requirement
- **`a-toolchain`** — This host has no JDK and no Android SDK, and none is installed on it:
  the APK build and the JVM unit tests run in a Docker container that carries both (Docker
  28.5 is already on the host). The APK is then installed on the Android Studio emulator on
  Windows.
  - **raised by:** "i want a simple app"; amended by the answer to `q-validation`
  - **bears on:** `r-docker-build`, every requirement
- **`a-one-partial-per-digit`** — There is one partial product per digit of `B`, taken from
  its rightmost digit leftwards. The k-th (counting from 0) is `A` times that digit,
  shifted k columns to the left.
  - **raised by:** "AAAA x BBBB / CCCCCC + DDDDDD0 + EEEE00 / RESULT"
  - **bears on:** `r-posed-layout`, `r-right-to-left-entry`
- **`a-no-carries`** — Carries are neither shown nor typed; the user keeps them in their
  head.
  - **raised by:** "comme lorsqu'on le fait à la main"
  - **bears on:** `r-posed-layout`, `r-right-to-left-entry`
- **`a-random-operands`** — For a chosen digit count n, `A` and `B` are drawn at random
  with exactly n digits each (no leading zero).
  - **raised by:** "sélectinnr facilement la compléxité selon le nombre de chiffre de A et
    B (même valeur pour A et B)"
  - **bears on:** `r-choose-digit-count`
- **`a-result-typed`** — The result line is typed the same way as the partial products:
  right to left, digit after digit, ended by Enter.
  - **raised by:** "type the intermediate computes right to left, digit after digit,
    [enter] for next line"
  - **bears on:** `r-right-to-left-entry`
- **`a-onscreen-keypad`** — Digits and Enter are typed on a keypad drawn by the app (0–9,
  erase, Enter), not on the system keyboard.
  - **raised by:** "type the intermediate computes right to left, digit after digit,
    [enter] for next line"
  - **bears on:** `r-right-to-left-entry`
- **`a-mockup-before-layout`** — The screen layout is settled only after the user has seen
  a drawing of it.
  - **raised by:** "We can clarify few things, then build a mockup, then we'll refine"
  - **bears on:** `r-posed-layout`, `r-choose-digit-count`, `r-right-to-left-entry`
- **`a-errors-per-digit`** — At the check, each typed digit that differs from the expected
  digit in its column is shown in red, and each column where a digit is missing or extra is
  marked too.
  - **raised by:** the answer to `q-error-feedback`, "at the end"
  - **bears on:** `r-check-at-end`
- **`a-line-length`** — Each line is typed with as many digits as its value has, with no
  leading zero, so the user decides its length. Enter is accepted on a line of any length
  of at least one digit; a line of the wrong length is wrong at the check.
  - **raised by:** the answer to `q-error-feedback`, "at the end": nothing is checked
    before the end, so Enter cannot refuse a line for its length
  - **bears on:** `r-right-to-left-entry`, `r-check-at-end`
- **`a-apk-to-windows`** — The Docker build writes the APK into the repository's build
  output, which the user reaches from Windows through `\\wsl$` and installs by dragging it
  onto the emulator.
  - **raised by:** the answer to `q-validation`
  - **bears on:** `r-docker-build`, `s-practised-on-emulator`

## Files

Nothing placed yet.

## Open Questions

- **`q-modules`** — How is the code split into modules?
  - **options:**
    - (a) Two: `multiplication/`, a plain Kotlin module holding the arithmetic (drawing
      `A` and `B`, the partial products, checking the typed lines), and `app/`, the Android
      app (screens, keypad, entry), which depends on it
    - (b) One: `app/` holds everything
    - (c) Three: `multiplication/` (the arithmetic), `practice/` (plain Kotlin: the entry
      and check rules of one problem), and `app/` (screens and keypad)
  - **recommended:** (a), because the arithmetic gets quick JVM tests with no Android in
    them, and the entry rules can still be unit-tested in `app/`. In every option the root
    `SPEC.md` states the module contract: a module is a top-level directory holding a
    `build.gradle.kts` and a `SPEC.md`, and `settings.gradle.kts` includes every such
    directory it finds on disk.
  - **unblocks:** the landing place of every requirement, the root `SPEC.md`,
    `settings.gradle.kts`, `r-docker-build`
  - **raised by:** the answer to `q-validation` (the JVM unit tests run per module) and the
    answer to `q-other-operations` (one operation, one arithmetic)
  - **answer:**
- **`q-screen-layout`** — How are the screens laid out? (Drawings shown in the
  conversation.)
  - **options:**
    - (a) One screen: digit-count buttons 2 to 6 on top, where tapping a count, even the
      current one, draws a new `A` and `B`; the posed multiplication in the middle; the
      keypad (0–9, erase, Enter) at the bottom. After the check, Try again replaces Enter.
    - (b) Two screens: a start screen to pick the digit count, then a practice screen with
      the posed multiplication and the keypad, and a back arrow to change the count
  - **recommended:** (a), because the difficulty is one tap from the problem, which is what
    "easily" asks, and a 6-digit problem (a 12-digit result, 14 columns with the signs)
    still fits a phone held upright.
  - **unblocks:** `r-posed-layout`, `r-choose-digit-count`, `r-right-to-left-entry`,
    `r-check-at-end`, `r-try-again`, `a-mockup-before-layout`
  - **raised by:** the answer to `q-digit-range` (6 digits sets the widest layout), the
    answer to `q-error-feedback` (the Try again button needs a place), and
    `a-mockup-before-layout`
  - **answer:**
- **`q-back-to-line`** — Can the user go back to a line they already ended with Enter?
  - **options:**
    - (a) Yes: erase on an empty line goes back to the end of the previous line
    - (b) No: erase works only within the current line; Try again is the way to start over
    - (c) Yes: tapping any line puts the entry back on it
  - **recommended:** (a), because nothing is checked before the end, so a slip on an
    earlier line should be fixable, and this needs no extra control.
  - **unblocks:** `r-right-to-left-entry`
  - **raised by:** the answer to `q-error-feedback`, "at the end"
  - **answer:**
- **`q-zero-digit`** — When a digit of `B` is 0, its partial product is 0. What happens to
  its line?
  - **options:**
    - (a) The line is shown, and the user types a single 0 left of its greyed zeros
    - (b) The line is left out; the next line keeps its own shift
    - (c) The app writes the whole line, greyed, like the shifted zeros
  - **recommended:** (a), because it keeps one line per digit of `B`
    (`a-one-partial-per-digit`) and the user still has to notice the zero.
  - **unblocks:** `r-posed-layout`, `r-right-to-left-entry`, `a-one-partial-per-digit`,
    `a-line-length`
  - **raised by:** the answer to `q-shift-zeros` (the app pre-fills the shifted zeros,
    which leaves a zero line almost all written)
  - **answer:**
