---
idea: readme-current
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into one requirement, one reopened claim, two assumptions and three questions

## This step

The brief's first line becomes the Why. Amending the readme capability reopens
`CAP-root/readme`, and taking the screenshot again becomes `r-screenshot-current`. Two
assumptions say what the new picture shows and what "the README" covers. Two questions ask
how it is validated and how its freshness is held afterwards; a third, from the prover's
"Not my call", asks what the alt text says. Nothing lands.
`status: (none) → refining`, `remaining: (none) → 3q + 1r + 1i + 3f`.

## Changes

- **"the README's screenshot is out of date: it still shows the old keypad (7 8 9 on top)
  and no New button"** — refined
  - **now:** `why`
  - **raises:** `q-validation` (recommended option)
  - **verdict:** discharged
- **"amend the readme capability to add that the README should reflect the current state
  of the app"** — refined
  - **now:** `CAP-root/readme` (Reopened), `a-words-and-picture`
  - **raises:** `q-freshness-held`, `q-alt-text`
  - **verdict:** discharged
- **"update the screenshot so it does"** — refined
  - **now:** `r-screenshot-current`, `a-same-scene`
  - **verdict:** discharged

New in this step:

- **`q-validation`**
  - **justified by:** step 1 always asks it; the brief's first line is its recommended
    option
  - **verdict:** discharged
- **`SPEC.md`, `README.md`, `.github/screenshot.png`** (Files)
  - **justified by:** the brief places them: "amend the readme capability" (declared in
    `SPEC.md`), "the README should reflect the current state of the app" (`README.md`,
    whose picture's alt text describes the old screenshot) and "update the screenshot" (the
    README's `.github/screenshot.png`)
  - **verdict:** discharged
- **`q-freshness-held`**
  - **justified by:** the brief: "the README should reflect the current state of the app"
  - **verdict:** discharged
- **`q-alt-text`**
  - **justified by:** the brief: "the README should reflect the current state of the app",
    through `a-words-and-picture`; the prover's "Not my call" line, quoted in Reviews
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed, so the module-contract-reviewer did not run.

"Not my call", from the `refinement-prover`:

- "step-1's This step says `status: (none) → refining`, but `state.md` on disk says
  `status: unproved`. The two should agree before the commit." — put to the user at the
  review before the commit; the plan says `unproved` while a step is being proved, and is
  set once the proof is recorded.
- "Under `q-freshness-held`, option (b) would add a review-held `INV-root/readme-current`.
  That would make every chain that changes the screen retake the screenshot. Whether that
  cost is wanted is a question for the user." — became no new question: it is
  `q-freshness-held`, already asked.
- "`a-words-and-picture` says the alt text is stale, while `a-same-scene` keeps the same
  kind of scene. Whether the alt text should name specific operands (currently
  "426 × 899") at all is a wording choice for the user." — became `q-alt-text`.

## Proof

- **re-proof of step-0** — n/a: step-0 is the brief
- **rounds** — three
  - round 1: all discharged; its three "Not my call" lines are recorded in Reviews, one as
    the new `q-alt-text`
  - round 2: `justified` failed on `q-alt-text`, whose `raised by:` named no brief
    statement; fixed by tracing it to the brief through `a-words-and-picture`, and adding
    it to that statement's `raises:`; all else discharged
  - round 3: all discharged
- **matched** — discharged; every plan item and file is listed in Changes, and every entry
  is in the plan
- **coverage** — discharged; each of the three brief statements is quoted with one fate
- **no-widening** — discharged; the commitments say what the brief says, the rest are
  assumptions or questions
- **no-narrowing** — discharged; the reopened claim keeps its whole text and adds to it
- **answers-applied** — discharged; no answers yet, `q-validation` is asked
- **justified** — discharged; every assumption, question and file names the statement
  that raised it
- **consistent** — discharged; `CAP-root/readme`, `LIM-root/shown-by-hand`,
  `CAP-app/new-pair` and `CAP-app/right-to-left-entry` read, only `CAP-root/readme`
  changes and it is reopened
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: step 1 lands nothing
- **files** — discharged; only what the brief places, no other chain in flight
- **progress** — n/a: step 1
- **amendments** — n/a
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
