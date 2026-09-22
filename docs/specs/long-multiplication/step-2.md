---
idea: long-multiplication
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the five answers, amend `a-toolchain` for Docker, write the success signals

## This step

This step applies the answers to all five questions and carries one confirmed amendment
(`a-toolchain`, now a Docker build). The requirements are sharpened: multiplication only,
digit counts 2 to 6, greyed shifted zeros, and a check at the end with Try again. Two
success signals follow from `q-validation`. The step raises four questions: module layout,
screen layout, going back to a line, and a zero digit of `B`. The tree is still empty, so
nothing lands and nothing is settled under standing authorization.
`status: refining → refining`, `remaining: 5q + 4r + 0i + 0f → 4q + 7r + 0i + 0f`.

## Changes

- **`q-validation`** — answered
  - **was:** "How will we validate that it works?" (options (a) emulator screenshots here,
    (b) APK on your phone, (c) JVM unit tests only)
  - **now:** "i have android studio on my windows ; for the build, i suggest using dockr to
    avoid overloading the WSL hos" (2026-09-22, in the conversation); follow-up "Who then
    checks the screens?", answered with the option "You, on Windows emulator": "Docker
    builds the APK and runs the JVM unit tests; you install it on the Android Studio
    emulator on Windows and check each screen. Screen criteria land as manual-review
    limits." (2026-09-22, in the conversation). It produces `r-docker-build`,
    `s-practised-on-emulator`, `s-unit-tests-in-docker`, `a-apk-to-windows`, and the
    amendment of `a-toolchain`.
  - **verdict:** discharged
- **`q-digit-range`** — answered
  - **was:** "Which digit counts can be chosen?"
  - **now:** "2 to 6" (2026-09-22, in the conversation). It refines `r-choose-digit-count`.
  - **verdict:** discharged
- **`q-error-feedback`** — answered
  - **was:** "When does the app tell the user a digit is wrong?"
  - **now:** "at the end, with a try again buton that keeps A and B but clears the rest"
    (2026-09-22, in the conversation). It refines `r-right-to-left-entry` (no check while
    typing) and produces `r-check-at-end`, `r-try-again`, `a-errors-per-digit` and
    `a-line-length`.
  - **verdict:** discharged
- **`q-shift-zeros`** — answered
  - **was:** "The trailing zeros of the shifted partial products (`DDDDDD0`, `EEEE00`): who
    writes them?"
  - **now:** (a): "App pre-fills, greyed (Recommended)" (2026-09-22, in the conversation).
    It refines `r-posed-layout` and `r-right-to-left-entry`.
  - **verdict:** discharged
- **`q-other-operations`** — answered
  - **was:** "\"mainly multiplications at first\": does this first version contain anything
    besides multiplication?"
  - **now:** (a): "Multiplication only (Recommended)" (2026-09-22, in the conversation). It
    refines `r-practise-multiplication`.
  - **verdict:** discharged
- **`r-practise-multiplication`** — refined
  - **was:** "A user can practise mental arithmetic in the app, mainly multiplication at
    first."
  - **now:** "A user can practise long multiplication in the app. This version poses no
    other operation; other operations are later ideas."
  - **verdict:** discharged
- **`r-posed-layout`** — refined
  - **was:** "… then the result, with every digit aligned in its column."
  - **now:** the same text, followed by "The trailing zeros of each shifted partial product
    are written by the app in advance, greyed."
  - **verdict:** discharged
- **`r-choose-digit-count`** — refined
  - **was:** "A user can easily choose the difficulty, as the number of digits of `A` and
    `B`, which is the same for both."
  - **now:** the same text, ending "which is the same for both, from 2 to 6."
  - **verdict:** discharged
- **`r-right-to-left-entry`** — refined
  - **was:** "A user types each intermediate line right to left, digit after digit, and
    presses Enter to move to the next line."
  - **now:** the same text, followed by "On a shifted line, typing starts at the first
    column left of the greyed zeros. No digit is checked while the lines are typed."
  - **verdict:** discharged
- **`a-toolchain`** — amended
  - **was:** "This host has no JDK and no Android SDK today; both must be installed before
    the first build." raised by: "i want a simple app"; bears on: `q-validation`, every
    requirement
  - **now:** "This host has no JDK and no Android SDK, and none is installed on it: the APK
    build and the JVM unit tests run in a Docker container that carries both (Docker 28.5
    is already on the host). The APK is then installed on the Android Studio emulator on
    Windows." raised by: "i want a simple app"; amended by the answer to `q-validation`;
    bears on: `r-docker-build`, every requirement
  - **verdict:** discharged
- **Success signal section** — refined
  - **was:** "Nothing yet: waits on `q-validation`."
  - **now:** `s-practised-on-emulator`, `s-unit-tests-in-docker`
  - **verdict:** discharged

New in this step:

- **`r-check-at-end`**
  - **justified by:** the answer to `q-error-feedback`, "at the end"
  - **verdict:** discharged
- **`r-try-again`**
  - **justified by:** the answer to `q-error-feedback`, "with a try again buton that keeps A
    and B but clears the rest"
  - **verdict:** discharged
- **`r-docker-build`**
  - **justified by:** the answer to `q-validation`, "for the build, i suggest using dockr"
    and "Docker builds the APK and runs the JVM unit tests"; "with nothing installed on the
    host but Docker" comes from the amended `a-toolchain`, "none is installed on it"
  - **verdict:** discharged
- **`s-practised-on-emulator`**
  - **justified by:** the answer to `q-validation` ("you install it on the Android Studio
    emulator on Windows and check each screen. Screen criteria land as manual-review
    limits."), over `r-practise-multiplication`, `r-posed-layout`, `r-choose-digit-count`,
    `r-right-to-left-entry`, `r-check-at-end` and `r-try-again`
  - **verdict:** discharged
- **`s-unit-tests-in-docker`**
  - **justified by:** the answer to `q-validation`, "Docker builds the APK and runs the JVM
    unit tests"
  - **verdict:** discharged
- **`a-errors-per-digit`**
  - **justified by:** `r-check-at-end`, "the errors are shown", which does not say how
  - **verdict:** discharged
- **`a-line-length`**
  - **justified by:** the answer to `q-error-feedback`: with nothing checked before the end,
    Enter cannot refuse a line for its length
  - **verdict:** discharged
- **`a-apk-to-windows`**
  - **justified by:** the answer to `q-validation`, where Docker in WSL builds the APK and
    the emulator runs on Windows
  - **verdict:** discharged
- **`q-modules`**
  - **justified by:** the answers to `q-validation` and `q-other-operations`; no item has a
    landing place until the modules are chosen
  - **verdict:** discharged
- **`q-screen-layout`**
  - **justified by:** the answers to `q-digit-range` and `q-error-feedback`, and
    `a-mockup-before-layout`
  - **verdict:** discharged
- **`q-back-to-line`**
  - **justified by:** the answer to `q-error-feedback`
  - **verdict:** discharged
- **`q-zero-digit`**
  - **justified by:** the answer to `q-shift-zeros`
  - **verdict:** discharged

## Amendments

- **`a-toolchain`** — from an answer that contradicts it: the answer to `q-validation`
  moves the JDK and the Android SDK into Docker. The user confirmed it with "Amend as
  proposed (Recommended)" (2026-09-22, in the conversation).

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit
  (`git diff 2b61f7c -- docs/specs/long-multiplication/`)
- **rounds** — passed first time. Two things were then added on the prover's notes and
  checked against the diff: `a-toolchain` cited in `r-docker-build`'s justification, and
  `a-line-length` added to `q-zero-digit`'s `unblocks:`
- **matched** — discharged; the plan's diff shows exactly the listed changes, and no spec
  changed
- **coverage** — discharged; every abstract item has one fate, and the 8 untouched items
  still hold
- **no-widening** — discharged; every sharpening adds a constraint, and the one loosening,
  `a-toolchain`, is amended
- **no-narrowing** — discharged; the narrowings (multiplication only, 2 to 6 digits, no
  check while typing) are the answers'
- **answers-applied** — discharged; five answers quoted and applied, none delegates
- **justified** — discharged; every new item names its answer or the item it makes concrete
- **consistent** — discharged; the tree holds no claims yet
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed and no
  shipped file or spec changed
- **files** — discharged; the Files list is empty on both sides, and there is no other chain
- **progress** — discharged; 5 questions closed, and each of the 4 new ones names the
  decision that raised it
- **amendments** — discharged; `a-toolchain` quoted old and new, confirmed by the user
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; no split
