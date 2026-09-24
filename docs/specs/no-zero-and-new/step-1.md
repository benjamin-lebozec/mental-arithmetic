---
idea: no-zero-and-new
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief: two reopened claims, one requirement, two questions

## This step

Formalizes the brief against `multiplication/SPEC.md` and `app/SPEC.md`. "No 0 digit"
reopens `CAP-multiplication/draw-operands`. "New instead of Try again" reopens
`CAP-app/try-again` and adds `r-new-when-correct`. It asks `q-validation` and
`q-correct-means`. Nothing lands.
`status: (none) → refining`, `remaining: (none) → 2q + 1r + 0i + 7f`.

## Changes

The plan is new whole. Every statement of the brief, and every item and file of the plan:

- **brief: "no "0" digit in A/B"** — refined
  - **now:** reopened `CAP-multiplication/draw-operands`: neither `A` nor `B` has a 0
    digit, in any position; files `multiplication/SPEC.md`, `Operands.kt` and
    `OperandsTest.kt`, and `.github/screenshot.png`, whose `A` = 405 the draw can no
    longer pose
  - **raises:** `q-validation` (its new success criterion)
  - **verdict:** discharged
- **brief: "at the end of a game, if the result is correct, insteady of "try again" =>
  "new""** — refined
  - **now:** `r-new-when-correct`; reopened `CAP-app/try-again` (Try again only after a
    check where the result is not correct); assumption `a-new-as-new-pair`; files
    `app/SPEC.md`, `PracticeScreen.kt` and `Practice.kt`
  - **raises:** `q-correct-means`, `q-validation`
  - **verdict:** discharged

New in this step:

- **`why`**
  - **justified by:** the brief's two statements
  - **verdict:** discharged
- **`r-new-when-correct`**
  - **justified by:** the brief: "if the result is correct, insteady of "try again" =>
    "new""
  - **verdict:** discharged
- **`CAP-multiplication/draw-operands`** (reopened)
  - **justified by:** the brief: "no "0" digit in A/B"
  - **verdict:** discharged
- **`CAP-app/try-again`** (reopened)
  - **justified by:** the brief: "insteady of "try again" => "new""
  - **verdict:** discharged
- **`a-new-as-new-pair`**
  - **justified by:** the brief's "new", read against `CAP-app/new-pair`
  - **verdict:** discharged
- **`q-validation`**
  - **justified by:** asked of every brief
  - **verdict:** discharged
- **`q-correct-means`**
  - **justified by:** the brief: "if the result is correct", read against
    `CAP-multiplication/check-lines`, which marks every line
  - **verdict:** discharged
- **`multiplication/SPEC.md`**, **`Operands.kt`**, **`OperandsTest.kt`**,
  **`app/SPEC.md`**, **`PracticeScreen.kt`**, **`Practice.kt`**
  - **justified by:** the landing specs, `held in:` files and demonstrating test of the two
    reopened claims, placed by the claims the brief changes
  - **verdict:** discharged
- **`.github/screenshot.png`**
  - **justified by:** the brief's "no "0" digit in A/B", read against `CAP-root/readme`
    ("the words and the screenshot show the app as it is now"): the screenshot shows
    `405 × 186`
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — n/a: step-0 is the brief
- **rounds** — two
  - round 1: `consistent` failed: the README screenshot shows `405 × 186`, a pair the
    reopened draw can no longer pose, and the plan neither listed it nor asked. Fixed by
    listing `.github/screenshot.png` to be taken again. Also, on the prover's note,
    `Practice.kt` added to `CAP-app/try-again`'s held-in, and `OperandsTest.kt` listed
  - round 2: every obligation that applies discharged
- **matched** — discharged; the plan is new, and every item and file in it is listed above
- **coverage** — discharged; both brief statements have a fate. The reading of "A/B" as
  both `A` and `B` is the brief's own
- **no-widening** — discharged; the plan commits to nothing the brief does not say. "New"
  is read plainly as a new `A` and `B`, against Try again's same pair; its digit count is
  an assumption, and "correct" is a question
- **no-narrowing** — discharged; nothing the brief allows is taken away
- **answers-applied** — n/a: no answers yet; `q-validation` is asked
- **justified** — discharged; each assumption and question names its brief statement
- **consistent** — discharged; read against every claim the items bear on:
  `CAP-multiplication/partial-products` (a 0 digit of `B` still yields the single digit 0;
  that stays true of the function, and the draw only stops producing such a `B`),
  `CAP-app/check-at-end`'s assumption (the keys stay dead until Try again, a count or New
  is tapped; New is already named), `CAP-app/new-pair`, `LIM-app/hidden-when-sideways`
  (names `CAP-app/try-again`, unchanged in its scope), and `CAP-root/readme`, whose
  README cites `CAP-app/try-again` with doc: and whose screenshot shows a check with wrong
  digits, where Try again still stands, but whose `A` = 405 has a 0 digit, so the
  screenshot is listed to be taken again, keeping that claim
- **files** — discharged; the list holds only the landing specs, `held in:` files and test
  of the two claims the brief reopens, and the screenshot that `CAP-root/readme` requires
  to be taken again; no chain in flight lists any of them
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a in step 1
- **progress** — n/a in step 1
- **amendments** — n/a: none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
