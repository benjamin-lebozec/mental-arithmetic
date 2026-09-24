---
idea: no-zero-and-new
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the two answers: every item settled, New in Enter's place becomes CAP-app/new-when-correct

## This step

Applies `q-validation` (a) and `q-correct-means` (b). `r-new-when-correct` becomes
`CAP-app/new-when-correct` in `app/SPEC.md`, "correct" meaning no line carries a mark. The
two reopened claims get their final text and success criteria, and
`LIM-app/hidden-when-sideways` is reopened to name the new capability. The success signal is
written. Every item and file is now settled, to land in the next run. Nothing lands: both
answers were the user's own choice, not taken under standing authorization.
`status: refining → refining`, `remaining: 2q + 1r + 0i + 7f → 0q + 0r + 1i + 7f`.

## Changes

- **`q-validation`** — answered
  - **was:** "How will we validate that it works?", options (a) unit test and emulator, (b)
    unit test only
  - **now:** answer "(a): "Unit test + emulator (Recommended)" (2026-09-24, in the
    conversation)". It yields the success criteria of `CAP-multiplication/draw-operands`
    (reopened), `CAP-app/try-again` (reopened) and `CAP-app/new-when-correct`, and
    `s-no-zero-and-new`
  - **verdict:** discharged
- **`q-correct-means`** — answered
  - **was:** "If the result is correct": which lines must be right for New to replace Try
    again?, options (a) only the result line, (b) every line
  - **now:** answer "(b): "Every line" (2026-09-24, in the conversation)". It yields "a check
    where no line carries a mark" in `CAP-app/new-when-correct`, and "a check where some line
    carries a mark" in reopened `CAP-app/try-again`
  - **verdict:** discharged
- **`r-new-when-correct`** — refined
  - **was:** "At the end of a game, if the result is correct, a New button stands where Try
    again stands now, and poses a new `A` and `B`."
  - **now:** `CAP-app/new-when-correct`, lands in `app/SPEC.md`, held in `Practice.kt` and
    `PracticeScreen.kt`; the Requirements section says "No requirements left."
  - **verdict:** discharged
- **To land's "Nothing yet" line** — refined
  - **was:** "Nothing yet: `r-new-when-correct` has no success criterion until
    `q-validation` is answered, and its meaning of "correct" waits on `q-correct-means`."
  - **now:** the entry `CAP-app/new-when-correct`, planned
  - **verdict:** discharged
- **`CAP-multiplication/draw-operands`** (reopened) — refined
  - **was:** change "neither `A` nor `B` has a 0 digit, in any position; its success
    criterion waits on `q-validation`."; authority "the brief: "no "0" digit in A/B""
  - **now:** change gives the final claim "… each with exactly n digits, none of them 0.",
    the success "… every one of 1000 draws gives `A` and `B` of exactly n digits, none of
    them a 0.", and drops the assumes line, which the new claim implies; authority adds the
    answer to `q-validation`
  - **verdict:** discharged
- **`CAP-app/try-again`** (reopened) — refined
  - **was:** change "Try again takes Enter's place only after a check where the result is
    not correct; after a correct one, New takes it, per `r-new-when-correct`."; authority
    the brief's "insteady of "try again" => "new"" statement
  - **now:** change gives the final claim "After a check where some line carries a mark, a
    Try again button takes Enter's place; …" and its success, New taking its place per
    `CAP-app/new-when-correct`; authority adds the answers to `q-correct-means` and
    `q-validation`. Its held-in lines are unchanged
  - **verdict:** discharged
- **Success signal's "Nothing yet" line** — refined
  - **was:** "Nothing yet: it waits on `q-validation`."
  - **now:** `s-no-zero-and-new`
  - **verdict:** discharged
- **`a-new-as-new-pair`** — kept
  - **was:** bears on "`r-new-when-correct`"
  - **now:** bears on "`CAP-app/new-when-correct`, as its assumes line "the new `A` and `B`
    have the digit count currently chosen."", the item it was refined into
  - **verdict:** discharged
- **`app/SPEC.md`** — kept
  - **was:** holds "`CAP-app/try-again` (reopened)"
  - **now:** also holds `CAP-app/new-when-correct` and `LIM-app/hidden-when-sideways`
    (reopened)
  - **verdict:** discharged
- **`Practice.kt`**, **`PracticeScreen.kt`** — kept
  - **was:** holds "`CAP-app/try-again` (reopened)"
  - **now:** also holds `CAP-app/new-when-correct`
  - **verdict:** discharged
- **Open Questions** — both closed; the section says "None."
  - **verdict:** discharged

New in this step:

- **`CAP-app/new-when-correct`**
  - **justified by:** `r-new-when-correct`, with the answers to `q-correct-means` and
    `q-validation`; `a-new-as-new-pair` lands with it as its assumes line. It is shown by
    review of the running app, as `LIM-app/screens-by-manual-review` says of every app
    capability
  - **verdict:** discharged
- **`LIM-app/hidden-when-sideways`** (reopened)
  - **justified by:** `CAP-app/new-when-correct`: the limit lists what each app capability
    poses as holding only while upright, and the New in Enter's place is hidden sideways as
    Try again is, so it is named beside it
  - **verdict:** discharged
- **`s-no-zero-and-new`**
  - **justified by:** the answer to `q-validation`: the unit test of the draw and the
    emulator game ended right, then with an error
  - **verdict:** discharged

## Amendments

None. The user edits since step-1's commit are the two `answer:` lines only.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit
- **rounds** — passed first time
- **matched** — discharged; every hunk of the plan's diff has a Changes entry, and no spec
  changed
- **coverage** — discharged; every abstract item has one fate, and the searches for
  `r-new-when-correct`, both questions and both reopened claims leave no untouched item
  made false, wider or narrower
- **no-widening** — discharged; each success criterion is the answer to `q-validation` or
  stricter; the draw's dropped assumes line is implied by "none of them 0"
- **no-narrowing** — discharged; Try again's new precondition is the abstract reopen's,
  made precise by the answer to `q-correct-means`
- **answers-applied** — discharged; both answers quoted with date, and the items say no
  more than them
- **justified** — discharged; `CAP-app/new-when-correct` refines `r-new-when-correct`, the
  reopened limit and the success signal each name what made them necessary
- **consistent** — discharged; read against `CAP-app/check-at-end`'s assumes line, which
  still holds after a correct check, and `CAP-multiplication/partial-products`, whose 0
  digit case stays true of any `B`
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: nothing landed, and no
  file in the tree changed
- **files** — discharged; paths unchanged, no file says `to write`, no other chain in
  flight lists any of them
- **progress** — discharged; two questions closed, and a requirement given its final id
- **amendments** — discharged; none, the only user edits are the `answer:` lines
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
