---
idea: long-multiplication
chain: trunk
step: 1
status: refining
waits on: none
remaining: 5q + 4r + 0i + 0f
---

# Long multiplication, posed as by hand

## Why

- **`why`** — The user wants a simple app to practise mental arithmetic, multiplication
  first. What sets it apart: the multiplication is posed as it is done by hand, on several
  lines with every digit aligned, and the user types each intermediate line in turn.

## Requirements

- **`r-practise-multiplication`** — A user can practise mental arithmetic in the app,
  mainly multiplication at first.
- **`r-posed-layout`** — A multiplication is shown posed as it is done by hand, on several
  lines: `A`, `× B`, the partial products added up (`CCCCCC + DDDDDD0 + EEEE00`), then the
  result, with every digit aligned in its column.
- **`r-choose-digit-count`** — A user can easily choose the difficulty, as the number of
  digits of `A` and `B`, which is the same for both.
- **`r-right-to-left-entry`** — A user types each intermediate line right to left, digit
  after digit, and presses Enter to move to the next line.

## To land

Nothing left to land.

## Reopened

Nothing reopened.

## Success signal

Nothing yet: waits on `q-validation`.

## Assumptions

- **`a-android`** — The app is an Android app, written in Kotlin with Jetpack Compose.
  - **raised by:** "i want a simple app"
  - **bears on:** every requirement
- **`a-toolchain`** — This host has no JDK and no Android SDK today; both must be installed
  before the first build.
  - **raised by:** "i want a simple app"
  - **bears on:** `q-validation`, every requirement
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

## Files

Nothing placed yet.

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) JVM unit tests for the arithmetic and the entry rules, plus screenshots of the
      app on an emulator on this host, which you review
    - (b) JVM unit tests, plus the APK installed on your phone, where you check it by hand
    - (c) JVM unit tests only
  - **recommended:** (a), because screenshots let each step show its screens without you
    in the loop; it needs a JDK, the Android SDK and an emulator here (`a-toolchain`), and
    under WSL2 the emulator needs KVM. (b) is the fallback if the emulator won't run.
  - **unblocks:** every success signal and every `success:` line
  - **raised by:** always asked in step 1
  - **answer:**
- **`q-digit-range`** — Which digit counts can be chosen?
  - **options:**
    - (a) 1 to 5
    - (b) 2 to 4
    - (c) 1 to 9
  - **recommended:** (a), because 5 × 5 digits gives a 10-digit result plus its sign
    column, which still fits a phone held upright with readable digits.
  - **unblocks:** `r-choose-digit-count`, `r-posed-layout`
  - **raised by:** "sélectinnr facilement la compléxité selon le nombre de chiffre de A et
    B"
  - **answer:**
- **`q-error-feedback`** — When does the app tell the user a digit is wrong?
  - **options:**
    - (a) At once: each digit is checked as it is typed, a wrong one is shown in red and
      must be retyped
    - (b) On Enter: the line is checked when Enter is pressed; a wrong line is flagged and
      the user corrects it before moving on
    - (c) At the end: everything is checked once the result is entered, and the errors are
      shown
  - **recommended:** (b), because it keeps the digit-by-digit flow without giving away each
    digit, and still stops an error from spreading to the next lines.
  - **unblocks:** `r-right-to-left-entry`
  - **raised by:** "type the intermediate computes right to left, digit after digit,
    [enter] for next line"
  - **answer:**
- **`q-shift-zeros`** — The trailing zeros of the shifted partial products (`DDDDDD0`,
  `EEEE00`): who writes them?
  - **options:**
    - (a) The app writes them in advance, greyed; the user starts typing at the first
      column left of them
    - (b) The user types them like any other digit
    - (c) They are not written; the shifted columns stay blank
  - **recommended:** (a), because the brief writes them out, and they are layout, not
    arithmetic.
  - **unblocks:** `r-posed-layout`, `r-right-to-left-entry`
  - **raised by:** "CCCCCC + DDDDDD0 + EEEE00"
  - **answer:**
- **`q-other-operations`** — "mainly multiplications at first": does this first version
  contain anything besides multiplication?
  - **options:**
    - (a) Multiplication only; other operations are later ideas
    - (b) Addition and subtraction too, posed the same way
  - **recommended:** (a), because the brief says "at first", and the posed layout and
    entry are what make the app; they are worth getting right on one operation.
  - **unblocks:** `r-practise-multiplication`
  - **raised by:** "mainly \"mutliplications\" at first"
  - **answer:**
