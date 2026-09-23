---
idea: long-multiplication
chain: trunk
step: 5
status: done
waits on: none
remaining: 0q + 0r + 0i + 0f
---

# Long multiplication, posed as by hand

## Why

- **`why`** — The user wants a simple app to practise mental arithmetic, multiplication
  first. What sets it apart: the multiplication is posed as it is done by hand, on several
  lines with every digit aligned, and the user types each intermediate line in turn.

## Requirements

No requirement left.

## To land

Nothing left to land.

## Reopened

Nothing reopened.

## Success signal

- **`s-practised-on-emulator`** — On the Android Studio emulator on Windows, the APK the
  Docker build produced is installed through `adb`, a digit count from 2 to 6 is picked,
  and `A × B` is shown posed by hand, every digit aligned and the shifted zeros greyed. Each
  partial product and the result are typed right to left, with Enter after each line, the
  end shows which digits are wrong, and Try again clears the digits and keeps `A` and `B`.
  Claude drives the app through `adb` and judges each screen from its screenshots, so every
  screen criterion lands with a limit saying it is shown only by that review.
- **`s-unit-tests-in-docker`** — The JVM unit tests of every module pass when run in the
  Docker build.

## Assumptions

No assumption left.

## Files

No file left.

## Open Questions

None open.
