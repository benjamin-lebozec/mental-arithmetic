---
idea: long-multiplication
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: apply four answers, place every requirement in three specs, name the files

## This step

This step applies the answers to `q-modules`, `q-screen-layout`, `q-back-to-line` and
`q-zero-digit`. With two modules chosen, every requirement is placed: the Docker build and
the module Contract in the root `SPEC.md` (namespace `root`), the arithmetic in
`multiplication/SPEC.md` (namespace `multiplication`), the screen in `app/SPEC.md`
(namespace `app`). Each item gets its final id, its success criterion from the two success
signals, and its files. Four assumptions are new. Nothing lands: step-2 settled nothing, and
no answer was given under a standing authorization. Every item and file is now settled, for
the next run to land; `r-modules-follow-contract` leaves the plan once both modules have
landed and review has recorded that each follows the Contract.
`status: refining → refining`, `remaining: 4q + 7r + 0i + 0f → 0q + 1r + 16i + 21f`.

## Changes

- **`q-modules`** — answered
  - **was:** "How is the code split into modules?", options (a) two: `multiplication/`
    and `app/`, (b) one: `app/`, (c) three: `multiplication/`, `practice/`, `app/`;
    recommended (a), stating that in every option the root `SPEC.md` states the module
    contract: a module is a top-level directory holding a `build.gradle.kts` and a
    `SPEC.md`, and `settings.gradle.kts` includes every such directory it finds on disk.
  - **now:** answer: (a): "multiplication + app (Recommended)" (2026-09-22, in the
    conversation). It produced `INV-root/module-recognized`, `INV-root/module-dependency`,
    `r-modules-follow-contract`, `REQ-app/arithmetic`, the three namespaces and the landing
    place of every item, and the assumptions `a-contract-by-review`, `a-build-versions`,
    `a-package-name`.
  - **verdict:** discharged
- **`q-screen-layout`** — answered
  - **was:** "How are the screens laid out?", options (a) one screen, (b) two screens;
    recommended (a).
  - **now:** answer: (a): "One screen (Recommended)", chosen on a drawing of a 3-digit
    problem: count buttons [2]–[6] on top, the posed multiplication with greyed pre-filled
    zeros in the middle, the keypad [7 8 9 / 4 5 6 / 1 2 3 / ⌫ 0 Enter] at the bottom
    (2026-09-22, in the conversation). It produced the layout in `CAP-app/pick-digit-count`,
    `CAP-app/posed-layout`, `CAP-app/right-to-left-entry` and `CAP-app/try-again` (Try again
    replaces Enter), and the assumption `a-locked-after-check`.
  - **verdict:** discharged
- **`q-back-to-line`** — answered
  - **was:** "Can the user go back to a line they already ended with Enter?", options (a)
    erase on an empty line goes back, (b) no, (c) tapping a line; recommended (a).
  - **now:** answer: (a): "Erase goes back (Recommended)" (2026-09-22, in the
    conversation). It produced the erase rule in `CAP-app/right-to-left-entry`.
  - **verdict:** discharged
- **`q-zero-digit`** — answered
  - **was:** "When a digit of `B` is 0, its partial product is 0. What happens to its
    line?", options (a) shown, a single 0 typed left of its greyed zeros, (b) left out, (c)
    written greyed by the app; recommended (a).
  - **now:** answer: (a): "Type a single 0 (Recommended)" (2026-09-22, in the
    conversation). It produced the last sentence of `CAP-multiplication/partial-products`;
    the entry start "left of its greyed zeros" in `CAP-app/right-to-left-entry` covers the
    typing. `a-one-partial-per-digit` and `a-line-length` stand unchanged in text.
  - **verdict:** discharged
- **`r-practise-multiplication`** — refined
  - **was:** "A user can practise long multiplication in the app. This version poses no
    other operation; other operations are later ideas."
  - **now:** the app capabilities `CAP-app/pick-digit-count`, `CAP-app/posed-layout`,
    `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`, `CAP-app/try-again`, and
    `NOT-app/other-operations`.
  - **verdict:** discharged
- **`r-posed-layout`** — refined
  - **was:** "A multiplication is shown posed as it is done by hand, on several lines:
    `A`, `× B`, the partial products added up (`CCCCCC + DDDDDD0 + EEEE00`), then the
    result, with every digit aligned in its column. The trailing zeros of each shifted
    partial product are written by the app in advance, greyed."
  - **now:** `CAP-multiplication/partial-products` (the lines, their typed digits and
    their shifted zeros) and `CAP-app/posed-layout` (shown aligned, zeros greyed).
  - **verdict:** discharged
- **`r-choose-digit-count`** — refined
  - **was:** "A user can easily choose the difficulty, as the number of digits of `A` and
    `B`, which is the same for both, from 2 to 6."
  - **now:** `CAP-multiplication/draw-operands` and `CAP-app/pick-digit-count`.
  - **verdict:** discharged
- **`r-right-to-left-entry`** — refined
  - **was:** "A user types each intermediate line right to left, digit after digit, and
    presses Enter to move to the next line. On a shifted line, typing starts at the first
    column left of the greyed zeros. No digit is checked while the lines are typed."
  - **now:** `CAP-app/right-to-left-entry` and `NOT-app/check-while-typing`.
  - **verdict:** discharged
- **`r-check-at-end`** — refined
  - **was:** "Once the result line is entered, every typed digit is checked, and the errors
    are shown."
  - **now:** `CAP-multiplication/check-lines` and `CAP-app/check-at-end`.
  - **verdict:** discharged
- **`r-try-again`** — refined
  - **was:** "After the check, a Try again button clears every digit the user typed and
    poses the same `A` and `B` again."
  - **now:** `CAP-app/try-again`.
  - **verdict:** discharged
- **`r-docker-build`** — refined
  - **was:** "The APK is built, and the JVM unit tests run, in a Docker container, with
    nothing installed on the host but Docker."
  - **now:** `CAP-root/docker-build` and `REQ-root/docker`.
  - **verdict:** discharged
- **`a-mockup-before-layout`** — absorbed
  - **was:** "The screen layout is settled only after the user has seen a drawing of it."
    (bears on `r-posed-layout`, `r-choose-digit-count`, `r-right-to-left-entry`)
  - **now:** absorbed by the answer to `q-screen-layout`, chosen on a drawing the user was
    shown; the layout it settled is in `CAP-app/pick-digit-count`, `CAP-app/posed-layout`
    and `CAP-app/right-to-left-entry`.
  - **verdict:** discharged
- **`a-android`**, **`a-toolchain`**, **`a-one-partial-per-digit`**, **`a-no-carries`**,
  **`a-random-operands`**, **`a-result-typed`**, **`a-onscreen-keypad`**,
  **`a-errors-per-digit`**, **`a-line-length`**, **`a-apk-to-windows`** — kept; only the
  `bears on:` line changed, from the requirements it named to the items that refined them
  - **was:** `a-android`: "every requirement"; `a-toolchain`: "`r-docker-build`, every
    requirement"; `a-one-partial-per-digit`: "`r-posed-layout`, `r-right-to-left-entry`";
    `a-no-carries`: "`r-posed-layout`, `r-right-to-left-entry`"; `a-random-operands`:
    "`r-choose-digit-count`"; `a-result-typed`: "`r-right-to-left-entry`";
    `a-onscreen-keypad`: "`r-right-to-left-entry`"; `a-errors-per-digit`:
    "`r-check-at-end`"; `a-line-length`: "`r-right-to-left-entry`, `r-check-at-end`";
    `a-apk-to-windows`: "`r-docker-build`, `s-practised-on-emulator`"
  - **now:** `a-android`: "every item and file"; `a-toolchain`: "`CAP-root/docker-build`,
    `REQ-root/docker`"; `a-one-partial-per-digit`: "`CAP-multiplication/partial-products`,
    `CAP-app/posed-layout`"; `a-no-carries`: "`CAP-app/posed-layout`,
    `CAP-app/right-to-left-entry`"; `a-random-operands`:
    "`CAP-multiplication/draw-operands`"; `a-result-typed`: "`CAP-app/right-to-left-entry`";
    `a-onscreen-keypad`: "`CAP-app/right-to-left-entry`"; `a-errors-per-digit`:
    "`CAP-multiplication/check-lines`, `CAP-app/check-at-end`"; `a-line-length`:
    "`CAP-app/right-to-left-entry`, `CAP-multiplication/check-lines`";
    `a-apk-to-windows`: "`CAP-root/docker-build`, `s-practised-on-emulator`"
  - **verdict:** discharged
- **Files: "Nothing placed yet."** — refined
  - **was:** "Nothing placed yet."
  - **now:** the 21 files of the Files list, all `planned`: 7 at the root, 8 under
    `multiplication/`, 6 under `app/`.
  - **verdict:** discharged

New in this step:

- **`CAP-root/docker-build`**, **`REQ-root/docker`**
  - **justified by:** `r-docker-build`, which they refine; the success criterion traces to
    `s-unit-tests-in-docker` and `a-apk-to-windows` (the APK in the repository's build
    output), and the landing place to the answer to `q-modules`
  - **verdict:** discharged
- **`INV-root/module-recognized`**, **`INV-root/module-dependency`**,
  **`r-modules-follow-contract`**
  - **justified by:** the answer to `q-modules`: two modules make the root an open part,
    whose `SPEC.md` states the module contract as the recommended option said; `app/`
    depends on `multiplication/`, so what counts as a dependency is stated there too
  - **verdict:** discharged
- **`CAP-multiplication/draw-operands`**, **`CAP-multiplication/partial-products`**,
  **`CAP-multiplication/check-lines`**
  - **justified by:** `r-choose-digit-count`, `r-posed-layout`, `r-check-at-end`, placed
    by the answer to `q-modules` ("the arithmetic (drawing `A` and `B`, the partial
    products, checking the typed lines)"); the zero-digit rule by the answer to
    `q-zero-digit`; success criteria trace to `s-unit-tests-in-docker`
  - **verdict:** discharged
- **`CAP-app/pick-digit-count`**, **`CAP-app/posed-layout`**,
  **`CAP-app/right-to-left-entry`**, **`CAP-app/check-at-end`**, **`CAP-app/try-again`**,
  **`REQ-app/arithmetic`**, **`NOT-app/other-operations`**,
  **`NOT-app/check-while-typing`**, **`LIM-app/screens-by-manual-review`**
  - **justified by:** the requirements they refine, placed by the answer to `q-modules`
    ("the Android app (screens, keypad, entry), which depends on it"), laid out by the
    answer to `q-screen-layout`, the erase rule by the answer to `q-back-to-line`; success
    criteria and the limit trace to `s-practised-on-emulator` ("every screen criterion
    lands with a limit saying it is shown only by manual review")
  - **verdict:** discharged
- **`a-contract-by-review`**, **`a-build-versions`**, **`a-package-name`**,
  **`a-locked-after-check`**
  - **justified by:** the answer to `q-modules` (the first three) and to `q-screen-layout`
    (the last), each as its `raised by:` line says
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-2** — skipped: only `answer:` lines changed since step-2's commit
- **rounds** — one fix after the first round, proved again: the prover noted that `r-modules-follow-contract` did not say how it leaves the plan, while This step called every item settled; the requirement and This step now say it leaves once both modules land and review records they follow the Contract
- **matched** — discharged; the plan's diff and Changes agree both ways; no `SPEC.md` exists or changed
- **coverage** — discharged; every abstract item has one true fate; no stale `r-*` or `a-mockup-before-layout` handle remains
- **no-widening** — discharged; `NOT-app/other-operations` keeps the non-goal, `NOT-app/check-while-typing` keeps "no digit is checked", no criterion softened
- **no-narrowing** — discharged; the Enter-needs-a-digit rule was already committed by `a-line-length`; count buttons stay usable after the check
- **answers-applied** — discharged; all four answers quoted as recorded, each the recommended option; `a-locked-after-check` is an assumption, not attributed to the user
- **justified** — discharged; every new item and assumption names the answer or requirement that made it necessary
- **consistent** — discharged; `a-locked-after-check` vs `CAP-app/pick-digit-count`, `REQ-app/arithmetic` vs `INV-root/module-dependency`, and the untested app capabilities vs `LIM-app/screens-by-manual-review` checked; the tree has no claims
- **settled** — n/a; nothing landed
- **landed** — n/a
- **demonstrated** — n/a
- **tree-kept** — n/a; no shipped file changed
- **files** — discharged; 21 planned files, each justified by its `holds:` ids and under the directory of the spec it cites; no other chain in flight
- **progress** — discharged; four questions closed, every requirement but one given final ids
- **amendments** — discharged; none
- **terminal** — n/a; status is `refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; trunk step, no split
