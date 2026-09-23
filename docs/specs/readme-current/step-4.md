---
idea: readme-current
chain: trunk
step: 4
refines: step-3.md
---

# Step 4: apply the four answers: the limit says a theme change is never caught and how it is shown; the other two accepted as they are

## This step

`q-theme-change`'s answer rewords `LIM-root/screenshot-freshness`: a change of theme or
colour that touches none of the README's uses: is never caught, and the screenshot is then
retaken only by hand. `q-limit-shown`'s answer gives the limit a `shown by:` line.
`q-uses-duty` and `q-dependency-recorded` are accepted as they are and produce no item. The
limit is now settled. The prover's "Not my call" becomes `q-cap-reads-with-limit`, which the
reopened `CAP-root/readme` and the three files wait on. No answer quotes a standing
authorization, so nothing lands in this step.
`status: refining → refining`, `remaining: 4q + 0r + 2i + 3f → 1q + 0r + 2i + 3f`.

## Changes

- **`LIM-root/screenshot-freshness`** — refined
  - **was:** "A change to the app's screen brings the README's screenshot into review only
    when it touches one of the app capabilities the README cites as uses:; a change that
    touches none of them, such as a new element under a new capability or a change of theme
    or colour, does not take the screenshot again unless that new capability is added to the
    README's uses:." — decided by: `q-uses-gap`'s answer, "Record a LIM (Recommended)"
    (2026-09-23)
  - **now:** "A change to the app's screen brings the README's screenshot into review only
    when it touches one of the app capabilities the README cites as uses:; a change that
    touches none of them does not take the screenshot again. A new element under a new
    capability is caught only once that capability is added to the README's uses:; a change
    of theme or colour that touches none of them is never caught by the uses:, and the
    screenshot is then retaken only by hand." — decided by: adds `q-theme-change`'s and
    `q-limit-shown`'s answers, each dated (2026-09-23) — new line **shown by:** "review,
    reading the README's uses: against the app capabilities that shape the screen"
  - **verdict:** discharged
- **`q-uses-duty`** — answered
  - **was:** the open question whether adding a new app capability to the README's uses:
    should become a claim
  - **now:** answer (c): "Accept, the LIM is enough (Recommended)" (2026-09-23). No item:
    the limit states the gap in the open, and no duty is claimed
  - **verdict:** discharged
- **`q-theme-change`** — answered
  - **was:** the open question whether the limit should say how a change of theme or colour
    is ever caught, or that it never is
  - **now:** answer (a): "Say it's never caught (Recommended)" (2026-09-23). It yields the
    reworded `LIM-root/screenshot-freshness` above
  - **verdict:** discharged
- **`q-dependency-recorded`** — answered
  - **was:** the open question whether the decision that the README's uses: are not a
    dependency should also land in `SPEC.md`
  - **now:** answer (c): "Accept, the INV already says it (Recommended)" (2026-09-23). No
    item: `INV-root/module-dependency` speaks only of a module's `build.gradle.kts`; the
    `README.md` Files line keeps its clause, unchanged
  - **verdict:** discharged
- **`q-limit-shown`** — answered
  - **was:** the open question whether the limit should gain a line saying how it is shown
  - **now:** answer (a): "Add a shown-by line (Recommended)" (2026-09-23). It yields the
    limit's `shown by:` line above
  - **verdict:** discharged

New in this step:

- **`q-cap-reads-with-limit`**
  - **justified by:** `q-theme-change`'s answer, applied in this step; the refinement-prover's
    "Not my call" in this step
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

Not my call, from the refinement-prover in round 1, quoted:

> The reopened `CAP-root/readme` will-say reads as unconditional: "a change to how the app's screen looks takes the screenshot again". `LIM-root/screenshot-freshness` now says a theme or colour change "is never caught by the uses:, and the screenshot is then retaken only by hand". Should the capability's wording say it is kept by hand in that case, so the claim and its limit read together without the one appearing to contradict the other?

It became `q-cap-reads-with-limit`.

## Proof

- **re-proof of step-3** — skipped: only `answer:` lines changed; `git diff e60f9b9` on the
  plan showed the four `answer:` lines and nothing else, and no file of the Files list or
  spec changed
- **rounds** — two. Round 1 discharged every obligation and gave one "Not my call", which
  became `q-cap-reads-with-limit`; it also noted the limit's `decided by:` left
  `q-theme-change`'s answer undated, now dated. Round 2 discharged every obligation, with no
  "Not my call"
- **matched** — discharged; the LIM's reword, four questions removed and one added match
  Changes both ways, and no spec changed
- **coverage** — discharged; each changed item has its claimed fate, and the five untouched
  items stay true
- **no-widening** — discharged; the limit keeps every case it named and only sharpens one
- **no-narrowing** — discharged; no requirement or capability text changed
- **answers-applied** — discharged; the four answers quoted with their date, each yielding
  what its option said; they are on record only through this step, as the `answer:` lines
  were never committed
- **justified** — discharged; the `shown by:` line comes from `q-limit-shown`, the new
  question from the prover's line and `q-theme-change`'s answer
- **consistent** — discharged; the claim and limit relate as at step-3, and the open question
  leaves the wording to the user
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed, no file in
  the tree changed
- **files** — discharged; the list is unchanged, none `to write`, no other chain in flight
  lists them
- **progress** — discharged; four questions closed, and the new one names the decision that
  raised it
- **amendments** — discharged; none
- **terminal** — n/a; status is `refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; no split
