---
namespace: app
---

# App

The Android app: one screen where a multiplication is posed as by hand, and the user types
each partial product and the result, right to left, then sees what they got wrong.

## Capabilities

- **`CAP-app/pick-digit-count`** — On the one screen, count buttons 2 to 6 sit on top;
  tapping a count, even the current one, poses a new `A` and `B` with that many digits.
  - **success:** On the Android Studio emulator on Windows, each count from 2 to 6 is
    tapped through `adb`, the current one too, and the screenshot after each tap shows a
    new `A × B` with that many digits.
  - **assumes:** at launch, the count is 2, as if it had been tapped.
- **`CAP-app/new-pair`** — On the one screen, a New button sits at the end of the row of
  count buttons, on top; tapping it at any time, while typing or after the check, poses a
  new `A` and `B`.
  - **success:** On the Android Studio emulator on Windows, New is tapped through `adb`,
    once while a line is being typed and once after the check, and the screenshot after
    each tap shows a new `A × B` of the same digit count.
  - **assumes:** the new `A` and `B` have the digit count currently chosen.
- **`CAP-app/posed-layout`** — In the middle of the screen, the multiplication is shown
  posed as by hand: `A`, `× B`, the partial products added up, then the result, every
  digit aligned in its column, the shifted zeros written in advance and greyed.
  - **success:** On the Android Studio emulator on Windows, for each count from 2 to 6, the
    screenshots taken through `adb` show `A`, `× B`, one line per digit of `B` and the
    result line, every digit in its column and the shifted zeros greyed.
  - **assumes:** carries are neither shown nor typed; the user keeps them in their head.
- **`CAP-app/right-to-left-entry`** — On a keypad at the bottom of the screen (1 2 3 /
  4 5 6 / 7 8 9 / ⌫ 0 Enter), the user types each line right to left, digit after digit,
  starting at the first column left of its greyed zeros. Enter moves to the next line once
  the current one holds a digit. Erase removes the last digit typed, and on an empty line
  goes back to the end of the previous line.
  - **success:** On the Android Studio emulator on Windows, each partial product and the
    result are typed through `adb`, right to left with Enter after each, and erased back
    across a line already ended, and the screenshots show each digit where it was typed;
    and a screenshot shows the keypad with 1 at the top left.
  - **assumes:** the digit rows are ordered as on a phone; the result line is typed like the
    partial products; the keypad is drawn by the app, not the system keyboard; carries are
    not typed; Enter is accepted on a line of any length of at least one digit, since its
    length is judged only at the check.
- **`CAP-app/check-at-end`** — Once Enter ends the result line, every typed line is
  checked, and the errors are shown: a wrong digit in red, a missing or extra column
  marked.
  - **success:** On the Android Studio emulator on Windows, the result line is ended through
    `adb`, and the screenshot shows which digits are wrong, missing or extra.
  - **assumes:** after the check, the digit and erase keys do nothing until Try again, a
    count button or New is tapped.
- **`CAP-app/try-again`** — After a check where some line carries a mark, a Try again
  button takes Enter's place; tapping it clears every digit the user typed and poses the
  same `A` and `B` again.
  - **success:** On the Android Studio emulator on Windows, after a check where some line
    carries a mark, Try again is tapped through `adb`, and the screenshot shows the typed
    digits cleared and `A` and `B` unchanged.
- **`CAP-app/new-when-correct`** — After a check where no line carries a mark, a New
  button takes Enter's place; tapping it poses a new `A` and `B`.
  - **success:** On the Android Studio emulator on Windows, a game is played through `adb`
    to a check where no line carries a mark, and the screenshot shows New in Enter's place;
    New is tapped, and the screenshot shows a new `A × B`.
  - **assumes:** the new `A` and `B` have the digit count currently chosen.

## Invariants

- **`INV-app/portrait-only`** — The screen stays upright: rotating the device neither turns
  it nor loses the practice in progress.
  - **held by:** review: the manifest locks the activity to portrait, and declares that it
    handles size changes itself, so a rotation, even letterboxed, does not recreate it

## Non-goals

- **`NOT-app/other-operations`** — The app poses no operation but multiplication; other
  operations are later ideas.
- **`NOT-app/check-while-typing`** — No digit is checked, and no error is shown, before
  Enter ends the result line.

## Requires

- **`REQ-app/arithmetic`** — The app needs `CAP-multiplication/draw-operands`,
  `CAP-multiplication/partial-products` and `CAP-multiplication/check-lines`, through a
  project dependency on `multiplication`.
- **`REQ-app/emulator-adb`** — This host reaches the Android Studio emulator on Windows
  through the Windows SDK's `adb.exe`, run from WSL.

## Known limits

- **`LIM-app/screens-by-manual-review`** — Every capability of the app is shown only by a
  review of the running app on the Android Studio emulator on Windows: the APK is
  installed, the screen tapped and captured through that emulator's `adb`, and the
  screenshots judged. No test drives the screen, and nobody but the reviewer of those
  screenshots judges it.
- **`LIM-app/practice-lost-when-killed`** — If Android ends the app, or recreates its
  screen for a change other than a rotation (dark mode, language, font size), the practice
  in progress is lost, and a new `A × B` is posed.
- **`LIM-app/hidden-when-sideways`** — Held sideways, the app is shown upright in a
  letterbox too short for the multiplication, which is hidden until the device is turned
  upright again, the practice kept: `CAP-app/posed-layout`, the lines typed under
  `CAP-app/right-to-left-entry`, the marks of `CAP-app/check-at-end`, and what
  `CAP-app/pick-digit-count`, `CAP-app/new-pair`, `CAP-app/try-again` and
  `CAP-app/new-when-correct` pose hold only while it is upright.
