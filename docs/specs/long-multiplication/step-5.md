---
idea: long-multiplication
chain: trunk
step: 5
refines: step-4.md
---

# Step 5: land the Docker build, the module Contract, the multiplication and the app

## This step

No question was open and nothing changed since step-4's commit. Every item step-4 settled
lands: in `SPEC.md` the Docker build, its network need and its limit, and the module
Contract; in `multiplication/SPEC.md` the three arithmetic capabilities; in `app/SPEC.md`
the five screen capabilities, the portrait lock, the two requirements, the two non-goals and
the three limits. All 21 files are written and closed. Each assumption lands as an
`assumes:` or `why:` line, or is absorbed by the code that states it in full.
`r-modules-follow-contract` leaves on review's full-scope verdict. Nothing is settled under
standing authorization. `status: refining → done`, `remaining: 0q + 1r + 22i + 21f → 0q +
0r + 0i + 0f`.

## Changes

- **`r-modules-follow-contract`** — absorbed
  - **was:** "`multiplication/` and `app/` each follow the root `SPEC.md`'s Contract:
    `INV-root/module-recognized` and `INV-root/module-dependency`. It leaves the plan once
    both modules have landed and review has recorded that each follows the Contract."
  - **now:** by `INV-root/module-recognized` and `INV-root/module-dependency`, which bind
    every module on the root's path, and by review's full-scope verdict, recorded under
    Reviews, that both modules follow them
  - **verdict:** discharged
- **`CAP-root/docker-build`** — landed
  - **now:** into `SPEC.md`, as written, with an `assumes:` line from `a-toolchain`,
    `a-build-versions` ("no Gradle wrapper") and `a-apk-to-windows`; held in `Dockerfile`,
    `build.sh`, `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties`,
    `.gitignore`, `multiplication/build.gradle.kts`, `app/build.gradle.kts`
  - **verdict:** discharged
- **`REQ-root/docker`**, **`REQ-root/network`**, **`LIM-root/build-by-run`** — landed
  - **now:** into `SPEC.md`, as written
  - **verdict:** discharged
- **`INV-root/module-recognized`** — landed
  - **now:** into `SPEC.md`'s Contract, as written, held by review, with a `why:` line from
    `a-contract-by-review`. Its first clause is also the Contract's `addition:` line, "a
    module is a top-level directory holding a `build.gradle.kts` and a `SPEC.md`.", the
    line an open part's Contract gives to say how an addition is recognized
  - **verdict:** discharged
- **`INV-root/module-dependency`** — landed
  - **now:** into `SPEC.md`'s Contract, as written, held by review, with a `why:` line from
    `a-contract-by-review`
  - **verdict:** discharged
- **`CAP-multiplication/draw-operands`** — landed
  - **now:** into `multiplication/SPEC.md`, as written, with an `assumes:` line from
    `a-random-operands`; held in `Operands.kt`, shown by `OperandsTest.kt`
  - **verdict:** discharged
- **`CAP-multiplication/partial-products`** — landed
  - **now:** into `multiplication/SPEC.md`, as written; held in `PosedMultiplication.kt`,
    shown by `PosedMultiplicationTest.kt`
  - **verdict:** discharged
- **`CAP-multiplication/check-lines`** — landed
  - **now:** into `multiplication/SPEC.md`, as written, with an `assumes:` line from
    `a-line-length`; held in `Check.kt`, shown by `CheckTest.kt`
  - **verdict:** discharged
- **`CAP-app/pick-digit-count`** — landed
  - **now:** into `app/SPEC.md`, as written, its `assumes:` line included; held in
    `PracticeScreen.kt` (the buttons) and `Practice.kt` (the launch count and the new
    problem)
  - **verdict:** discharged
- **`CAP-app/posed-layout`** — landed
  - **now:** into `app/SPEC.md`, as written, with an `assumes:` line from `a-no-carries`;
    held in `AndroidManifest.xml`, `MainActivity.kt`, `PracticeScreen.kt`
  - **verdict:** discharged
- **`CAP-app/right-to-left-entry`** — landed
  - **now:** into `app/SPEC.md`, as written, with an `assumes:` line from `a-result-typed`,
    `a-onscreen-keypad`, `a-no-carries` and `a-line-length`; held in `PracticeScreen.kt`
    (the keypad and the cursor) and `Practice.kt` (the entry)
  - **verdict:** discharged
- **`CAP-app/check-at-end`** — landed
  - **now:** into `app/SPEC.md`, as written, with an `assumes:` line from
    `a-locked-after-check`; held in `Practice.kt` (the check and its marks) and
    `PracticeScreen.kt` (a wrong digit red, a missing column boxed in red, an extra digit
    struck through in red)
  - **verdict:** discharged
- **`CAP-app/try-again`** — landed
  - **now:** into `app/SPEC.md`, as written; held in `Practice.kt` (the reset) and
    `PracticeScreen.kt` (the button)
  - **verdict:** discharged
- **`INV-app/portrait-only`** — landed
  - **now:** into `app/SPEC.md`, as written, held by review over `AndroidManifest.xml`
    (`screenOrientation`, `configChanges`); the manifest's header names it
  - **verdict:** discharged
- **`REQ-app/arithmetic`**, **`REQ-app/emulator-adb`**, **`NOT-app/other-operations`**,
  **`NOT-app/check-while-typing`**, **`LIM-app/screens-by-manual-review`**,
  **`LIM-app/practice-lost-when-killed`**, **`LIM-app/hidden-when-sideways`** — landed
  - **now:** into `app/SPEC.md`, as written
  - **verdict:** discharged
- **`a-android`**, **`a-package-name`** — absorbed
  - **now:** by the code: `app/build.gradle.kts` builds an Android application with the
    Kotlin and Compose plugins, its `namespace` and `applicationId` are
    `mentalarithmetic.app`, and every source file's `package` line is
    `mentalarithmetic.multiplication` or `mentalarithmetic.app`
  - **verdict:** discharged
- **`a-build-versions`** — absorbed
  - **now:** by the code: `Dockerfile` (`eclipse-temurin:17-jdk`, Gradle 8.10.2, the
    command-line tools, the android-35 platform, build-tools 34.0.0), `build.gradle.kts`
    (AGP 8.7.3, Kotlin 2.1.0 and its Compose compiler plugin), `app/build.gradle.kts` (the
    Compose BOM 2024.12.01, `activity-compose` 1.9.3, compileSdk and targetSdk 35, minSdk
    26, JDK 17), `multiplication/build.gradle.kts` (JDK 17, JUnit 4.13.2); "no Gradle
    wrapper" is in `CAP-root/docker-build`'s `assumes:` line
  - **verdict:** discharged
- **`a-toolchain`**, **`a-apk-to-windows`** — landed
  - **now:** as the `assumes:` line of `CAP-root/docker-build`
  - **verdict:** discharged
- **`a-one-partial-per-digit`**, **`a-errors-per-digit`** — absorbed
  - **now:** by `CAP-multiplication/partial-products`, and by
    `CAP-multiplication/check-lines` with `CAP-app/check-at-end`, which say them in full
  - **verdict:** discharged
- **`a-no-carries`**, **`a-random-operands`**, **`a-result-typed`**, **`a-onscreen-keypad`**,
  **`a-line-length`**, **`a-locked-after-check`** — landed
  - **now:** as the `assumes:` lines named above
  - **verdict:** discharged
- **`a-contract-by-review`** — landed
  - **now:** as the `why:` lines of `INV-root/module-recognized` and
    `INV-root/module-dependency`
  - **verdict:** discharged
- **each spec's opening paragraph** — the one-to-three sentences a `SPEC.md` opens with to
  say what its part is for, each summing up the items that spec declares and claiming
  nothing further:
  - `SPEC.md`: "An Android app for practising mental arithmetic. The root holds the build,
    which runs in Docker, and accepts modules: each top-level directory recognized below is
    one." (`why`, `CAP-root/docker-build`, the Contract)
  - `multiplication/SPEC.md`: "The arithmetic of a multiplication posed as by hand: drawing
    `A` and `B`, the lines the user types, and checking what they typed." (its three
    capabilities)
  - `app/SPEC.md`: "The Android app: one screen where a multiplication is posed as by hand,
    and the user types each partial product and the result, right to left, then sees what
    they got wrong." (its five capabilities)
  - **verdict:** discharged
- **every file of the Files list (21)** — closed
  - **was:** each `— planned`
  - **now:** written in this step, everything it holds landed
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

- **`CAP-root/docker-build`** — "On this host, `./build.sh` writes the debug APK into
  `app/build/outputs/apk/debug/` and runs the JVM unit tests of every module, which pass."
  After removing `app/build`, `multiplication/build` and `build`, `./build.sh` on this host
  (log `s5/build.log` in the scratchpad): 62 tasks executed, `BUILD SUCCESSFUL`,
  `app/build/outputs/apk/debug/app-debug.apk` written; `:multiplication:test` ran 7
  tests, 0 failures, 0 errors; `:app:testDebugUnitTest` and `:app:testReleaseUnitTest`
  NO-SOURCE (the app has no JVM unit test). Shown by that run, as `LIM-root/build-by-run`
  says.
- **`CAP-multiplication/draw-operands`** — `OperandsTest`, 1 test, passed in that build: for
  each n from 2 to 6, 1000 draws, each `A` and `B` of exactly n digits.
- **`CAP-multiplication/partial-products`** — `PosedMultiplicationTest`, 2 tests, passed:
  1234 × 5078 gives 9872 (0 zeros), 8638 (1), 0 (2), 6170 (3), result 6266252; 47 × 36
  gives 282 (0), 141 (1), result 1692.
- **`CAP-multiplication/check-lines`** — `CheckTest`, 4 tests, passed: right lines carry no
  mark; a wrong digit marks its column wrong; a line too short marks its missing columns;
  a line too long marks its extra columns.
- **The app**, on the Android Studio emulator on Windows (`emulator-5554`, 1080×2400
  upright), through the Windows SDK's `adb.exe` run from WSL: that build's APK installed
  with `adb install -r`, launched with `am start -S`, keys tapped with `input tap`, screens
  captured with `exec-out screencap` (screenshots under `s5/` in the scratchpad).
  - **`CAP-app/pick-digit-count`** — at launch, count 2 filled and `28 × 41` posed. 2 (the
    current count), 3, 4, 5, 6 and 2 again tapped: each screenshot shows a new `A × B` with
    that many digits (63 × 29, 642 × 285, 2834 × 7125, 43257 × 49349, 875829 × 538731,
    41 × 58), the tapped count filled.
  - **`CAP-app/posed-layout`** — for each count, the screenshots show `A`, `× B` and a rule,
    one line per digit of `B` (2 to 6 lines), the k-th with k greyed zeros at the right,
    `+` on every line after the first, a rule, then the result line once typed (`92478`
    below); every digit in its column; the grid in the middle of the screen.
  - **`CAP-app/right-to-left-entry`** — on 41 × 58 (328, 205 shifted, 2378): 8, 2, 3 typed
    show `328`, rightmost first, from the column the cursor underlines; Enter puts the
    cursor on line 1, left of its greyed zero; ⌫ on that empty line puts it back after
    `328`; Enter, then 5, 0 show `05` left of the zero; Enter, then 8, 7, 4, 2, 9 show
    `92478` on the result line.
  - **`CAP-app/check-at-end`** — Enter on the result line: line 0 unmarked; line 1's missing
    hundreds column boxed in red; the result's `4` (expected 3) red, the extra `9` struck
    through in red, `2`, `7`, `8` unmarked. 5 and ⌫ tapped after the check change nothing;
    the keys are greyed.
  - **`CAP-app/try-again`** — Try again in Enter's place, tapped: the digits and marks are
    cleared, `41 × 58` unchanged, Enter back.
  - **`INV-app/portrait-only`** (held by review; shown here too) — with 6 typed on 41 × 58,
    the device rotated to landscape (`settings put system user_rotation 1`): the app stays
    upright, letterboxed, the multiplication hidden as `LIM-app/hidden-when-sideways` says;
    rotated back, `41 × 58` and the 6 unchanged.
- Tests of the changed modules: root build files changed, so every module's: `./build.sh`
  runs `gradle assembleDebug test` over both; 7 tests, 7 passed.

## Reviews

- **Scope `full`** (the chain goes to `done` and adds two modules). The git-log check found
  `a1fd1c0 method`, a commit no step accounts for (it edits only `.claude/`, `CLAUDE.md` and
  the plan), so every claim in the tree was walked: the 22 ids this step declares.
  - **Citation rules over every shipped file** (21 files): declaration, forward,
    demonstrated, backward, path, direction, kind, coverage, severance — all clean.
  - **The root Contract:** `multiplication/` and `app/` are each recognized as additions and
    each follow `INV-root/module-recognized` and `INV-root/module-dependency`; the plan
    carried `r-modules-follow-contract` while the chain was in flight. So
    `r-modules-follow-contract` leaves.
  - **Every claim landed without code holds of the tree:** `REQ-root/docker`,
    `REQ-root/network`, `LIM-root/build-by-run`, `INV-root/module-recognized`,
    `INV-root/module-dependency`, `INV-app/portrait-only`, `REQ-app/arithmetic`,
    `REQ-app/emulator-adb`, `NOT-app/other-operations`, `NOT-app/check-while-typing`,
    `LIM-app/screens-by-manual-review`, `LIM-app/practice-lost-when-killed`,
    `LIM-app/hidden-when-sideways`.
  - **Chains in flight:** one; no file listed twice.
  - **21 of 22 ids hold.** One `broken`, fixed: `CAP-root/docker-build` — `.gitignore`
    ignored `local.properties`, which only an IDE on the host writes, not the build; the
    line is removed.
  - **Not review's call, noted:** nothing limits how many digits a line takes; a long line
    widens the grid and shrinks every cell. No claim covers a limit either way.
- **The prover's first round** found `multiplication/SPEC.md`'s opening paragraph claiming
  "Plain Kotlin, with no Android dependency.", which no item makes; the sentence is
  removed.

## Proof

- **re-proof of step-4** — skipped: nothing changed since step-4's commit
- **rounds**
  - round 1: `matched` and `justified` failed on the three specs' opening paragraphs, not
    listed in Changes, and `multiplication/SPEC.md`'s "Plain Kotlin, with no Android
    dependency.", which no item makes; `coverage`, `landed`, `terminal` waited on review.
    Fixed: the sentence removed, the paragraphs listed, review recorded
  - round 2: passed
- **matched** — discharged; the plan's and the three specs' diffs agree with Changes both
  ways
- **coverage** — discharged; every abstract item has one true fate, every landed claim is
  in its spec
- **no-widening** — discharged; spec texts word for word; the code rules out what the items
  rule out
- **no-narrowing** — discharged; the code's `require`s match the capabilities' domains;
  Enter takes any line of at least one digit
- **answers-applied** — n/a; no question open or closed
- **justified** — discharged; the opening paragraphs sum up their specs' items; no code
  commits to anything new
- **consistent** — discharged; the limits, `INV-app/portrait-only` and the code agree
- **settled** — discharged; every landed item and file was final in step-4's plan
- **landed** — discharged; declarations, citations, the path rule, demonstrating tests or
  limits, headers and `assumes:` lines check out; review passed
- **demonstrated** — discharged; each criterion's evidence answers it; 7 of 7 tests passed
  on a clean build
- **tree-kept** — discharged; no landed claim before this step; every changed file in Files
- **files** — discharged; all 21 closed and present, no other chain
- **progress** — discharged; 22 items landed
- **amendments** — n/a
- **terminal** — discharged; only `why` and the success signals remain, each shown by
  capabilities landed in this chain; review records every claim without code as true
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; trunk, no split
