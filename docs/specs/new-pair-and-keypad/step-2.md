---
idea: new-pair-and-keypad
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: the three answers applied; `CAP-app/new-pair` and the reopened keypad settled

## This step

The three answers close every question, each with its recommended option. `r-new-pair`
becomes `CAP-app/new-pair`, a New button at the end of the count row, tappable at any time,
landing in `app/SPEC.md`. The reopened `CAP-app/right-to-left-entry` now says its new text
and success criterion exactly. The answers also reopen `CAP-app/check-at-end` (New works
after the check) and `LIM-app/hidden-when-sideways` (New poses a pair). All are settled and
land in the next run; no answer quotes a standing authorization, so nothing lands here.
`status: refining → refining`, `remaining: 3q + 1r + 1i + 2f → 0q + 0r + 4i + 3f`.

## Changes

- **`q-validation`** — answered
  - **was:** "How will we validate that it works?", options (a) emulator screenshots
    through `adb`, (b) the same plus a JVM unit test
  - **now:** answer: (a): "Emulator screenshots (Recommended)" (2026-09-23, in the
    conversation). It yields `s-new-pair-and-keypad`, the success criterion of
    `CAP-app/new-pair`, and the success criterion added to the reopened
    `CAP-app/right-to-left-entry`.
  - **verdict:** discharged
- **`q-new-pair-button`** — answered
  - **was:** "Tapping the current count button (2 to 6) already poses a new `A × B`. What
    should the new button be?"
  - **now:** answer: (a): "New at top (Recommended)" (2026-09-23, in the conversation),
    option (a) "A "New" button at the end of the row of count buttons, at the top". It
    yields the place of `CAP-app/new-pair`, its landing in `app/SPEC.md`, and the reopened
    `LIM-app/hidden-when-sideways`.
  - **verdict:** discharged
- **`q-new-pair-when`** — answered
  - **was:** "When can the new button be tapped?"
  - **now:** answer: (a): "Always (Recommended)" (2026-09-23, in the conversation), option
    (a) "Always: while typing, and after the check". It yields "at any time, while typing
    or after the check" in `CAP-app/new-pair`, and the reopened `CAP-app/check-at-end`.
  - **verdict:** discharged
- **`r-new-pair`** — refined
  - **was:** "On the practice screen, a button lets the user easily get a new `A` and `B`."
  - **now:** `CAP-app/new-pair`, and the Requirements section says "Nothing left:
    `r-new-pair` is now `CAP-app/new-pair`."
  - **verdict:** discharged
- **To land section** — refined
  - **was:** "Nothing yet: `r-new-pair` has no landing place until `q-new-pair-button` is
    answered."
  - **now:** `CAP-app/new-pair`, planned
  - **verdict:** discharged
- **`CAP-app/right-to-left-entry`** (reopened) — refined
  - **was:** change: "the keypad starts with 1 at the top left; its digit rows per
    `a-phone-order`, its bottom row per `a-bottom-row-kept`."; authority: "the brief: "the
    digit pad starts with 1 at the top left""
  - **now:** change: the parenthesis becomes "(1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter)", the rest
    of the text unchanged; the success criterion gains "and a screenshot shows the keypad
    with 1 at the top left"; `a-phone-order` and `a-bottom-row-kept` land in its `assumes:`
    line. Authority adds the answer to `q-validation`, for the success criterion.
  - **verdict:** discharged
- **Success signal section** — refined
  - **was:** "Nothing yet: it waits on `q-validation`."
  - **now:** `s-new-pair-and-keypad`
  - **verdict:** discharged
- **`a-new-pair-same-count`** — kept
  - **was:** bears on: `r-new-pair`
  - **now:** bears on: `CAP-app/new-pair`, which `r-new-pair` became
  - **verdict:** discharged
- **`app/SPEC.md`** — kept
  - **was:** holds: `CAP-app/right-to-left-entry` (reopened) — planned
  - **now:** holds: `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`,
    `LIM-app/hidden-when-sideways` (reopened), `CAP-app/new-pair` — planned
  - **verdict:** discharged
- **`app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`** — kept
  - **was:** holds: `CAP-app/right-to-left-entry` (reopened) — planned
  - **now:** holds: `CAP-app/right-to-left-entry`, `CAP-app/check-at-end` (reopened),
    `CAP-app/new-pair` — planned
  - **verdict:** discharged

New in this step:

- **`CAP-app/new-pair`**
  - **justified by:** `r-new-pair`, placed by the answer to `q-new-pair-button`, enabled at
    any time by the answer to `q-new-pair-when`, its success criterion from the answer to
    `q-validation`; it lands with `a-new-pair-same-count` as its `assumes:` line
  - **verdict:** discharged
- **`CAP-app/check-at-end`** (reopened)
  - **justified by:** the answer to `q-new-pair-when`, (a): New can be tapped after the
    check, so its landed `assumes:` line ("until Try again or a count button is tapped")
    would become false. It is held in `PracticeScreen.kt` (New), and in `Practice.kt`,
    whose comment on `typeDigit` restates the `assumes:` line
  - **verdict:** discharged
- **`LIM-app/hidden-when-sideways`** (reopened)
  - **justified by:** the answer to `q-new-pair-button`, (a): New poses a pair, which the
    limit's list of what is posed would otherwise leave out
  - **verdict:** discharged
- **`app/src/main/kotlin/mentalarithmetic/app/Practice.kt`** — holds: `CAP-app/check-at-end`
  (reopened) — planned
  - **justified by:** the reopened `CAP-app/check-at-end`: its comment "After the check,
    digits and erase do nothing until Try again or a count is picked." restates the line
    being reopened
  - **verdict:** discharged
- **`s-new-pair-and-keypad`**
  - **justified by:** the answer to `q-validation`, option (a)'s text
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit.
- **rounds** — three.
  - round 1: `consistent` failed, and `coverage` through it: `CAP-app/new-pair`, tappable
    after the check, made `CAP-app/check-at-end`'s `assumes:` line false without reopening
    it. Fixed: `CAP-app/check-at-end` reopened; `LIM-app/hidden-when-sideways`, which the
    prover noted would be left incomplete, reopened with it.
  - round 2: every obligation discharged or n/a. The prover's note that `Practice.kt`
    restates the reopened `assumes:` line put that file in the Files list, and the
    reopened item's `held in:`.
  - round 3: every obligation discharged or n/a.
- **matched** — discharged; every change in the plan's diff has an entry in Changes or New, and there is no spec diff.
- **coverage** — discharged; every abstract item has one true fate, and the handle searches find no untouched claim made false once `CAP-app/check-at-end` is reopened.
- **no-widening** — discharged; no criterion is softened, and both new reopenings reach only as far as their answers.
- **no-narrowing** — discharged; New is tappable at any time on the one screen, with no added precondition.
- **answers-applied** — discharged; the three answers are the recommended options, quoted and dated, and what they produce says no more.
- **justified** — discharged; every new item and file names its answer or the item it serves.
- **consistent** — discharged (round 2); `CAP-app/new-pair` no longer contradicts `CAP-app/check-at-end`, now reopened.
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: nothing lands.
- **files** — discharged; three files, none in another chain in flight, none `to write`, none an open part's own file.
- **progress** — discharged; three questions closed, and `r-new-pair` became `CAP-app/new-pair`.
- **amendments** — n/a: none.
- **terminal** — n/a.
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split.
