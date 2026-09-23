---
idea: readme-current
chain: trunk
step: 5
refines: step-4.md
---

# Step 5: accept the capability and its limit as they read; everything left is settled

## This step

`q-cap-reads-with-limit` is answered (c): the reopened `CAP-root/readme` keeps its will-say,
and `LIM-root/screenshot-freshness` beside it says where it is not held. The answer produces
no item. With no question left, the reopened `CAP-root/readme`, the limit and the three files
(`SPEC.md`, `README.md`, `.github/screenshot.png`) are settled, and the next run lands them
together. The answer quotes no standing authorization, so nothing lands in this step. The
prover's three "Not my call" lines become `q-status-recorded`, `q-no-question-left` and
`q-status-when-set`, which no item waits on.
`status: refining → refining`, `remaining: 1q + 0r + 2i + 3f → 3q + 0r + 2i + 3f`.

## Changes

- **`q-cap-reads-with-limit`** — answered
  - **was:** "The reopened `CAP-root/readme`'s will-say reads as unconditional: "a change to
    how the app's screen looks takes the screenshot again". `LIM-root/screenshot-freshness`
    now says a change of theme or colour is never caught by the uses:, and the screenshot is
    then retaken only by hand. Should the capability's wording say so, so that the claim and
    its limit read together?" — options (a) take it into this chain, (b) leave it to a new
    idea, (c) accept it as it is; recommended (c); unblocks `CAP-root/readme` (reopened),
    `SPEC.md`, `README.md`, `.github/screenshot.png`; raised by `q-theme-change`'s answer,
    applied in step 4, and the refinement-prover's "Not my call" in step 4
  - **now:** answer "(c): "Accept as is (Recommended)" (2026-09-23, in the conversation)". It
    produces no item: the reopened `CAP-root/readme`'s will-say and
    `LIM-root/screenshot-freshness` stay as written.
  - **verdict:** discharged

New in this step:

- **`q-status-recorded`**
  - **justified by:** the refinement-prover's "Not my call" in this step, routed to the user
    as a question
  - **verdict:** discharged
- **`q-no-question-left`**
  - **justified by:** the refinement-prover's "Not my call" in this step, round 2, routed to
    the user as a question
  - **verdict:** discharged
- **`q-status-when-set`**
  - **justified by:** the refinement-prover's "Not my call" in this step, round 2, routed to
    the user as a question
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

The refinement-prover, round 1, under "Not my call":

> The step's This step section records `status: refining → refining`, but the plan on disk says `status: unproved`. The front matter is outside `matched`, but the recorded transition and the plan should agree once the proof is filled in.

It became `q-status-recorded`. The plan's status was then set to `refining` as the proof was
recorded, as every run does; the question asks whether anything more is wanted.

The refinement-prover, round 2, under "Not my call":

> Step-5's This step section still says "With no question left, the reopened `CAP-root/readme`, the limit and the three files … are settled". Now that `q-status-recorded` is open, "no question left" is false. The conclusion still holds, because the question unblocks nothing, but the sentence could say "with no question left that they wait on".

It became `q-no-question-left`.

> Reviews says the status "was then set to `refining` as the proof was recorded". So does `q-status-recorded` in state.md, which says "The plan now says `refining`, as the record does". But the Proof section of step-5 is still empty, so no proof had been recorded when the status changed.

It became `q-status-when-set`.

## Proof

- **re-proof of step-4** — skipped: only `answer:` lines changed; the diff since step-4's
  commit touches only `q-cap-reads-with-limit`'s `answer:` line
- **rounds** — three rounds; no obligation failed in any
  - round 1: one "Not my call", which became `q-status-recorded`
  - round 2: two "Not my call" lines, which became `q-no-question-left` and
    `q-status-when-set`
  - round 3: clean, no "Not my call"
- **matched** — discharged; four question changes in the plan's diff, four Changes entries,
  no spec diff
- **coverage** — discharged; one item answered, seven kept untouched, the three Files lines
  untouched
- **no-widening**, **no-narrowing** — discharged; no commitment changed
- **answers-applied** — discharged; (c) closes `q-cap-reads-with-limit` and produces no item
- **justified** — discharged; each new question names the prover's finding that raised it
- **consistent** — discharged; the new questions unblock nothing and contradict nothing
- **settled** — n/a; nothing landed. No open question lists `CAP-root/readme`,
  `LIM-root/screenshot-freshness` or the three files, so they are settled for the next run
- **landed**, **demonstrated**, **tree-kept** — n/a; no tree file changed
- **files** — discharged; Files list unchanged, nothing `to write`, no other chain in flight
- **progress** — discharged; `q-cap-reads-with-limit` closed; the three new questions come
  from the prover's "Not my call" lines and block nothing
- **amendments** — discharged; none
- **terminal** — n/a; `status: refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; trunk step, no
  split
