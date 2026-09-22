---
idea: long-multiplication
chain: trunk
step: 3
status: refining
waits on: none
remaining: 0q + 1r + 16i + 21f
---

# Long multiplication, posed as by hand

## Why

- **`why`** — The user wants a simple app to practise mental arithmetic, multiplication
  first. What sets it apart: the multiplication is posed as it is done by hand, on several
  lines with every digit aligned, and the user types each intermediate line in turn.

## Requirements

- **`r-modules-follow-contract`** — `multiplication/` and `app/` each follow the root
  `SPEC.md`'s Contract: `INV-root/module-recognized` and `INV-root/module-dependency`.
  It leaves the plan once both modules have landed and review has recorded that each
  follows the Contract.

## To land

- **`CAP-root/docker-build`** — On a host with nothing installed but Docker, the APK is
  built, and the JVM unit tests of every module run, in a Docker container.
  - **success:** On this host, `./build.sh` writes the debug APK into
    `app/build/outputs/apk/debug/` and runs the JVM unit tests of every module, which pass.
  - **lands in:** `SPEC.md`
  - **held in:** `Dockerfile`, `build.sh` (the container and the command run in it),
    `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`, `.gitignore` (the root
    build), `multiplication/build.gradle.kts`, `app/build.gradle.kts` (each module's build)
  - **status:** planned
- **`REQ-root/docker`** — The host has Docker (28.5 is the version the build is run with),
  and needs no JDK and no Android SDK.
  - **lands in:** `SPEC.md`
  - **status:** planned
- **`INV-root/module-recognized`** — A module is a top-level directory holding a
  `build.gradle.kts` and a `SPEC.md`; `settings.gradle.kts` includes every such directory
  it finds on disk, and names none.
  - **held by:** review: `settings.gradle.kts` names no module, and the build's project
    list matches the top-level directories holding both files
  - **lands in:** `SPEC.md`, in its Contract
  - **status:** planned
- **`INV-root/module-dependency`** — A module depends on another only through a
  `project(":<name>")` dependency in its `build.gradle.kts`, and the dependencies form no
  cycle.
  - **held by:** review, over every module's `build.gradle.kts`
  - **lands in:** `SPEC.md`, in its Contract
  - **status:** planned
- **`CAP-multiplication/draw-operands`** — For a digit count n from 2 to 6, `A` and `B`
  are drawn at random, each with exactly n digits.
  - **success:** A JVM unit test, run in the Docker build, shows that for each n from 2 to
    6, every one of 1000 draws gives `A` and `B` of exactly n digits.
  - **lands in:** `multiplication/SPEC.md`
  - **held in:** `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt`
  - **status:** planned
- **`CAP-multiplication/partial-products`** — For `A` and `B`, the lines of the posed
  multiplication are given: one partial product per digit of `B`, from its rightmost digit
  leftwards, the k-th (from 0) being the digits of `A` times that digit, to be typed, and
  k shifted zeros written in advance; then the result `A × B`, to be typed. A 0 digit of
  `B` gives a line whose typed part is the single digit 0.
  - **success:** A JVM unit test, run in the Docker build, shows for fixed `A` and `B`,
    one of them with a 0 digit in `B`, each partial product's typed digits and shifted
    zeros, and the result's digits.
  - **lands in:** `multiplication/SPEC.md`
  - **held in:** `multiplication/src/main/kotlin/mentalarithmetic/multiplication/PosedMultiplication.kt`
  - **status:** planned
- **`CAP-multiplication/check-lines`** — The lines typed for a posed multiplication are
  checked column by column against its lines, from the right of each typed part: a typed
  digit that differs from the expected one is marked wrong, a column expected but not
  typed is marked missing, and a column typed but not expected is marked extra.
  - **success:** A JVM unit test, run in the Docker build, shows that lines typed right
    carry no mark, a wrong digit marks its column wrong, a line too short marks its missing
    columns, and a line too long marks its extra columns.
  - **lands in:** `multiplication/SPEC.md`
  - **held in:** `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Check.kt`
  - **status:** planned
- **`CAP-app/pick-digit-count`** — On the one screen, count buttons 2 to 6 sit on top;
  tapping a count, even the current one, poses a new `A` and `B` with that many digits.
  - **success:** On the Android Studio emulator on Windows, the user taps each count from
    2 to 6, the current one too, and each tap poses a new `A × B` with that many digits.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the
    buttons), `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (the new problem)
  - **status:** planned
- **`CAP-app/posed-layout`** — In the middle of the screen, the multiplication is shown
  posed as by hand: `A`, `× B`, the partial products added up, then the result, every
  digit aligned in its column, the shifted zeros written in advance and greyed.
  - **success:** On the Android Studio emulator on Windows, for each count from 2 to 6, the
    user sees `A`, `× B`, one line per digit of `B` and the result line, every digit in its
    column and the shifted zeros greyed.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/AndroidManifest.xml`,
    `app/src/main/kotlin/mentalarithmetic/app/MainActivity.kt` (the screen shown at
    launch), `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the layout)
  - **status:** planned
- **`CAP-app/right-to-left-entry`** — On a keypad at the bottom of the screen (7 8 9 /
  4 5 6 / 1 2 3 / ⌫ 0 Enter), the user types each line right to left, digit after digit,
  starting at the first column left of its greyed zeros. Enter moves to the next line once
  the current one holds a digit. Erase removes the last digit typed, and on an empty line
  goes back to the end of the previous line.
  - **success:** On the Android Studio emulator on Windows, the user types each partial
    product and the result right to left with Enter after each, and erases back across a
    line they already ended.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the
    keypad), `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (the entry)
  - **status:** planned
- **`CAP-app/check-at-end`** — Once Enter ends the result line, every typed line is
  checked, and the errors are shown: a wrong digit in red, a missing or extra column
  marked.
  - **success:** On the Android Studio emulator on Windows, the user ends the result line
    and is shown which digits are wrong, missing or extra.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (the check),
    `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the marks)
  - **status:** planned
- **`CAP-app/try-again`** — After the check, a Try again button takes Enter's place;
  tapping it clears every digit the user typed and poses the same `A` and `B` again.
  - **success:** On the Android Studio emulator on Windows, after the check, the user taps
    Try again, their digits are cleared, and `A` and `B` are unchanged.
  - **lands in:** `app/SPEC.md`
  - **held in:** `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` (the reset),
    `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` (the button)
  - **status:** planned
- **`REQ-app/arithmetic`** — The app needs `CAP-multiplication/draw-operands`,
  `CAP-multiplication/partial-products` and `CAP-multiplication/check-lines`, through a
  project dependency on `multiplication`.
  - **lands in:** `app/SPEC.md`
  - **status:** planned
- **`NOT-app/other-operations`** — The app poses no operation but multiplication; other
  operations are later ideas.
  - **lands in:** `app/SPEC.md`
  - **status:** planned
- **`NOT-app/check-while-typing`** — No digit is checked, and no error is shown, before
  Enter ends the result line.
  - **lands in:** `app/SPEC.md`
  - **status:** planned
- **`LIM-app/screens-by-manual-review`** — Every capability of the app is shown only by the
  user's review on the Android Studio emulator on Windows; no test drives the screen.
  - **lands in:** `app/SPEC.md`
  - **status:** planned

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
  - **bears on:** every item and file
- **`a-toolchain`** — This host has no JDK and no Android SDK, and none is installed on it:
  the APK build and the JVM unit tests run in a Docker container that carries both (Docker
  28.5 is already on the host). The APK is then installed on the Android Studio emulator on
  Windows.
  - **raised by:** "i want a simple app"; amended by the answer to `q-validation`
  - **bears on:** `CAP-root/docker-build`, `REQ-root/docker`
- **`a-one-partial-per-digit`** — There is one partial product per digit of `B`, taken from
  its rightmost digit leftwards. The k-th (counting from 0) is `A` times that digit,
  shifted k columns to the left.
  - **raised by:** "AAAA x BBBB / CCCCCC + DDDDDD0 + EEEE00 / RESULT"
  - **bears on:** `CAP-multiplication/partial-products`, `CAP-app/posed-layout`
- **`a-no-carries`** — Carries are neither shown nor typed; the user keeps them in their
  head.
  - **raised by:** "comme lorsqu'on le fait à la main"
  - **bears on:** `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`
- **`a-random-operands`** — For a chosen digit count n, `A` and `B` are drawn at random
  with exactly n digits each (no leading zero).
  - **raised by:** "sélectinnr facilement la compléxité selon le nombre de chiffre de A et
    B (même valeur pour A et B)"
  - **bears on:** `CAP-multiplication/draw-operands`
- **`a-result-typed`** — The result line is typed the same way as the partial products:
  right to left, digit after digit, ended by Enter.
  - **raised by:** "type the intermediate computes right to left, digit after digit,
    [enter] for next line"
  - **bears on:** `CAP-app/right-to-left-entry`
- **`a-onscreen-keypad`** — Digits and Enter are typed on a keypad drawn by the app (0–9,
  erase, Enter), not on the system keyboard.
  - **raised by:** "type the intermediate computes right to left, digit after digit,
    [enter] for next line"
  - **bears on:** `CAP-app/right-to-left-entry`
- **`a-errors-per-digit`** — At the check, each typed digit that differs from the expected
  digit in its column is shown in red, and each column where a digit is missing or extra is
  marked too.
  - **raised by:** the answer to `q-error-feedback`, "at the end"
  - **bears on:** `CAP-multiplication/check-lines`, `CAP-app/check-at-end`
- **`a-line-length`** — Each line is typed with as many digits as its value has, with no
  leading zero, so the user decides its length. Enter is accepted on a line of any length
  of at least one digit; a line of the wrong length is wrong at the check.
  - **raised by:** the answer to `q-error-feedback`, "at the end": nothing is checked
    before the end, so Enter cannot refuse a line for its length
  - **bears on:** `CAP-app/right-to-left-entry`, `CAP-multiplication/check-lines`
- **`a-apk-to-windows`** — The Docker build writes the APK into the repository's build
  output, which the user reaches from Windows through `\\wsl$` and installs by dragging it
  onto the emulator.
  - **raised by:** the answer to `q-validation`
  - **bears on:** `CAP-root/docker-build`, `s-practised-on-emulator`
- **`a-contract-by-review`** — The root Contract's rules are held by review, not by a
  test: a settings script and a set of build files have no JVM unit test to show them.
  - **raised by:** the answer to `q-modules`, "the root `SPEC.md` states the module
    contract"
  - **bears on:** `INV-root/module-recognized`, `INV-root/module-dependency`
- **`a-build-versions`** — The build runs on JDK 17 in an `eclipse-temurin:17-jdk` image
  with the Android command-line tools and Gradle 8.10.2 installed at image build, with
  Android Gradle Plugin 8.7.3, Kotlin 2.1.0 and its Compose compiler plugin, the Compose
  BOM 2024.12.01, compileSdk and targetSdk 35, minSdk 26, and JUnit 4.13.2 for the JVM
  tests. There is no Gradle wrapper: the image carries Gradle.
  - **raised by:** the answer to `q-modules` (a Gradle build of two modules) and
    `a-toolchain`
  - **bears on:** `CAP-root/docker-build`
- **`a-package-name`** — The Kotlin packages are `mentalarithmetic.multiplication` and
  `mentalarithmetic.app`, and the application id is `mentalarithmetic.app`.
  - **raised by:** the answer to `q-modules` (the two modules' names)
  - **bears on:** every file under `multiplication/` and `app/`
- **`a-locked-after-check`** — After the check, the digit and erase keys do nothing until
  Try again or a count button is tapped.
  - **raised by:** the answer to `q-screen-layout`, "After the check, Try again replaces
    Enter"
  - **bears on:** `CAP-app/check-at-end`, `CAP-app/try-again`

## Files

- `SPEC.md` — holds: `CAP-root/docker-build`, `REQ-root/docker`,
  `INV-root/module-recognized`, `INV-root/module-dependency` — planned
- `Dockerfile` — holds: `CAP-root/docker-build` — planned
- `build.sh` — holds: `CAP-root/docker-build` — planned
- `settings.gradle.kts` — holds: `CAP-root/docker-build` — planned
- `build.gradle.kts` — holds: `CAP-root/docker-build` — planned
- `gradle.properties` — holds: `CAP-root/docker-build` — planned
- `.gitignore` — holds: `CAP-root/docker-build` — planned
- `multiplication/SPEC.md` — holds: `CAP-multiplication/draw-operands`,
  `CAP-multiplication/partial-products`, `CAP-multiplication/check-lines` — planned
- `multiplication/build.gradle.kts` — holds: `CAP-root/docker-build` — planned
- `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt` — holds:
  `CAP-multiplication/draw-operands` — planned
- `multiplication/src/main/kotlin/mentalarithmetic/multiplication/PosedMultiplication.kt` —
  holds: `CAP-multiplication/partial-products` — planned
- `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Check.kt` — holds:
  `CAP-multiplication/check-lines` — planned
- `multiplication/src/test/kotlin/mentalarithmetic/multiplication/OperandsTest.kt` — holds:
  `CAP-multiplication/draw-operands` (demonstrates) — planned
- `multiplication/src/test/kotlin/mentalarithmetic/multiplication/PosedMultiplicationTest.kt`
  — holds: `CAP-multiplication/partial-products` (demonstrates) — planned
- `multiplication/src/test/kotlin/mentalarithmetic/multiplication/CheckTest.kt` — holds:
  `CAP-multiplication/check-lines` (demonstrates) — planned
- `app/SPEC.md` — holds: `CAP-app/pick-digit-count`, `CAP-app/posed-layout`,
  `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`, `CAP-app/try-again`,
  `REQ-app/arithmetic`, `NOT-app/other-operations`, `NOT-app/check-while-typing`,
  `LIM-app/screens-by-manual-review` — planned
- `app/build.gradle.kts` — holds: `CAP-root/docker-build` — planned
- `app/src/main/AndroidManifest.xml` — holds: `CAP-app/posed-layout` — planned
- `app/src/main/kotlin/mentalarithmetic/app/MainActivity.kt` — holds:
  `CAP-app/posed-layout` — planned
- `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt` — holds:
  `CAP-app/pick-digit-count`, `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`,
  `CAP-app/check-at-end`, `CAP-app/try-again` — planned
- `app/src/main/kotlin/mentalarithmetic/app/Practice.kt` — holds:
  `CAP-app/pick-digit-count`, `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`,
  `CAP-app/try-again` — planned

## Open Questions

None open.
