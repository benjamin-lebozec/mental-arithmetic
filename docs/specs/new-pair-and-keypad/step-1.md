---
idea: new-pair-and-keypad
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into one requirement, one reopened claim, three assumptions and three questions

## This step

The brief is read against `app/SPEC.md`. Its keypad statement reopens
`CAP-app/right-to-left-entry`, whose landed text names the 7 8 9 / 4 5 6 / 1 2 3 order. Its
button statement becomes `r-new-pair`; the tree already poses a new pair when the current
count is tapped (`CAP-app/pick-digit-count`), so what the button is, and when it can be
tapped, are asked. Nothing lands.
`status: (none) → refining`, `remaining: (none) → 3q + 1r + 1i + 2f`.

## Changes

- **"two changes to the practice screen"** — refined
  - **now:** `why`
  - **verdict:** discharged
- **"a button to easily generate a new A/B"** — refined
  - **now:** `r-new-pair`
  - **raises:** `q-new-pair-button`, `q-new-pair-when`, `a-new-pair-same-count`
  - **verdict:** discharged
- **"the digit pad starts with 1 at the top left"** — refined
  - **now:** reopened `CAP-app/right-to-left-entry`, with the files that hold it:
    `app/SPEC.md`, `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`
  - **raises:** `a-phone-order`, `a-bottom-row-kept`
  - **verdict:** discharged

New in this step:

- **`q-validation`**
  - **justified by:** asked of every brief
  - **verdict:** discharged
- **`q-new-pair-button`**
  - **justified by:** "a button to easily generate a new A/B", read against
    `CAP-app/pick-digit-count`, which already poses a new pair on the current count
  - **verdict:** discharged
- **`q-new-pair-when`**
  - **justified by:** "a button to easily generate a new A/B": the brief does not say
    whether it works while typing, after the check, or both
  - **verdict:** discharged
- **`a-new-pair-same-count`**
  - **justified by:** "a button to easily generate a new A/B" names no digit count
  - **verdict:** discharged
- **`a-phone-order`**
  - **justified by:** "the digit pad starts with 1 at the top left" fixes only where 1 is,
    not the order of the other digits
  - **verdict:** discharged
- **`a-bottom-row-kept`**
  - **justified by:** "the digit pad starts with 1 at the top left" says nothing of the
    bottom row
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — skipped: step-0 is the brief.
- **rounds** — two, and one wording fix after them.
  - round 1: `no-widening` failed. The Why added a motive ("like a phone's", "easy to
    find"). The reopened item committed to the full 1 2 3 / 4 5 6 / 7 8 9 order and to the
    bottom row. Fixed: the Why uses the brief's words, the change says only "1 at the top
    left", and the order and bottom row became `a-phone-order` and `a-bottom-row-kept`.
    Options (b) and (c) of `q-new-pair-button` now say what they strike or amend.
  - round 2: every obligation discharged or n/a.
  - after round 2: `q-new-pair-when` (b) read "beside Try again", which put a key in the
    bottom row without saying so (the prover's note). It now leaves the place to
    `q-new-pair-button`. This is question wording only, and commits to nothing.
- **matched** — discharged; the plan is new whole, and every item and file is in Changes.
- **coverage** — discharged; each of the three brief statements, quoted, has one fate.
- **no-widening** — discharged (round 2); the inferences are assumptions or questions.
- **no-narrowing** — discharged; `r-new-pair` keeps "a button" and "easily".
- **answers-applied** — discharged; there are no answers yet, and `q-validation` is asked.
- **justified** — discharged; every assumption and question names its brief statement.
- **consistent** — discharged; the claims read are all of `app/SPEC.md` and
  `CAP-multiplication/draw-operands`, and the reopened claim changes only the key order.
- **files** — discharged; both files follow from the reopened item, and no chain in flight
  lists files.
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: step 1 lands nothing.
- **progress** — n/a: step 1 is the first formalization.
- **amendments** — n/a: none.
- **terminal** — n/a.
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split.
