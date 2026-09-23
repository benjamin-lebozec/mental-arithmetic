---
idea: readme-current
chain: trunk
step: 6
status: refining
waits on: none
remaining: 10q + 0r + 0i + 0f
---

# A README that shows the app as it is now

## Why

- **`why`** — The README's screenshot is out of date: it still shows the old keypad, 7 8 9
  on top, and no New button. A friend opening the repository sees an app that no longer
  exists.

## Requirements

Nothing left: the one requirement became the reopened `CAP-root/readme`.

## To land

Nothing left to land.

## Reopened

Nothing reopened.

## Success signal

- **`s-screenshot-current`** — A new screenshot replaces the README's, and shows the app as
  it is now: 1 at the top left of the keypad, and New in the row of count buttons.

## Assumptions

None left.

## Files

No files left.

## Open Questions

- **`q-step1-status`** — Step 1's Reviews quote the prover's "Not my call": "step-1's This
  step says `status: (none) → refining`, but `state.md` on disk says `status: unproved`. The
  two should agree before the commit." It never became a question, so the chain cannot be
  `done` until it is answered.
  - **options:**
    - (a) take it into this chain: a later step records the drafting mark for step 1
    - (b) leave it to a new idea about how steps record status, whose brief you write
    - (c) accept it as it is: it is the same thing `q-status-recorded` asked about step 5,
      and the same answer holds, `unproved` being only the mark a plan carries until its
      proof is recorded
  - **recommended:** (c), because the committed plan and record agree
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's `terminal` failure in step 6
  - **answer:**
- **`q-why-restates`** — The module-contract-reviewer judges `CAP-root/readme`'s `why:` line a
  restatement: it names the same six app capabilities as `README.md`'s header `[uses:]`, and
  the two copies will drift when an app capability is added. The line is part of the text
  settled in step 5, so taking it out changes a claim you decided.
  - **options:**
    - (a) keep the line as it is: it gives the reason the capability can promise a retake,
      which the header alone does not state as a claim
    - (b) shorten it to the reason without the list: "the README cites, as uses:, the app
      capabilities its screenshot shows, so a change to any of them brings the README into
      that change's review"
    - (c) drop the `why:` line
  - **recommended:** (b), because it keeps the reason and leaves the list in one place, the
    README's header
  - **unblocks:** the chain's `done`; under (b) or (c), a reopening of `CAP-root/readme`
  - **raised by:** the module-contract-reviewer's `restates` verdict in step 6
  - **answer:**
- **`q-screenshot-overlay`** — The new screenshot has a light grey tab at the top centre of
  the status bar. It is not part of the app; it looks like an emulator overlay.
  - **options:**
    - (a) take it into this chain: retake the screenshot without the tab
    - (b) crop the status bar out of the screenshot
    - (c) accept it as it is: the app's screen is complete and unmarked below it
  - **recommended:** (a), because a clean picture is what a friend should see, and a retake
    costs one run
  - **unblocks:** the chain's `done`; under (a) or (b), `.github/screenshot.png` again
  - **raised by:** the module-contract-reviewer's "Not my call" in step 6
  - **answer:**
- **`q-retake-wording`** — `CAP-root/readme` says a change to how the screen looks "takes the
  screenshot again". Nothing does that on its own: it depends on review noticing a `uses:`
  match, as `LIM-root/screenshot-freshness` says.
  - **options:**
    - (a) take it into this chain: reword the claim to "brings the screenshot into review"
    - (b) leave it to a new idea that retakes the screenshot automatically
    - (c) accept it as it is: the limit beside it says where the promise is not held, as
      `q-cap-reads-with-limit` already accepted
  - **recommended:** (c), because that question already settled this pairing
  - **unblocks:** the chain's `done`
  - **raised by:** the module-contract-reviewer's "Not my call" in step 6
  - **answer:**
- **`q-demo-wording`** — Step 6's Demonstrations says "the 3 of 33400", but 33400 has two 3s;
  the red one is the second, in the hundreds place.
  - **options:**
    - (a) take it into this chain: a later step records the precise wording
    - (c) accept it as it is: the screenshot itself shows which digit is red
  - **recommended:** (c), because the picture is the evidence and a committed step is never
    edited
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's "Not my call" in step 6
  - **answer:**
- **`q-answers-in-step`** — The answers to `q-status-recorded`, `q-no-question-left` and
  `q-status-when-set` survive only in step 6's quotes: the plan dropped them with the
  questions, and step 5's commit has empty `answer:` lines.
  - **options:**
    - (a) take it into this chain: commit answers to the plan before the next step is drafted
    - (b) leave it to a new idea about how answers are recorded, whose brief you write
    - (c) accept it as it is: a closed question's answer is kept in the Changes of the step
      that closes it, and that step is committed
  - **recommended:** (c), because that is where the method keeps them
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's "Not my call" in step 6
  - **answer:**
- **`q-github-render`** — "As GitHub shows it" has not been looked at for this change, since
  nothing is pushed yet. `LIM-root/shown-by-hand` covers it, but nobody is named to check the
  rendered README after the push.
  - **options:**
    - (a) take it into this chain: after the push, the next run opens the README on GitHub and
      records what it shows
    - (b) you check it yourself after the push
    - (c) accept it as it is: `LIM-root/shown-by-hand` already says so
  - **recommended:** (a), because the next run is due anyway and can read the page
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's "Not my call" in step 6
  - **answer:**
- **`q-header-wording`** — `README.md`'s header also says "so a change to any of them retakes
  it", the wording `q-retake-wording` questions in the spec claim; that question's option (a)
  rewords only the claim, so the header would keep the old wording.
  - **options:**
    - (a) take it into this chain: whatever `q-retake-wording` decides for the claim, the
      header says the same
    - (c) accept it as it is: the header is a comment, and the limit in the spec says where
      the promise is not held
  - **recommended:** (a), because the header and the claim should not say different things
  - **unblocks:** the chain's `done`; under (a) with `q-retake-wording` (a), `README.md` again
  - **raised by:** the refinement-prover's "Not my call" in step 6, round 2
  - **answer:**
- **`q-demo-options`** — `q-demo-wording` lists options (a) and (c) with no (b).
  - **options:**
    - (a) take it into this chain: a later step records a (b), leaving it to a new idea
    - (c) accept it as it is: the lettering follows the (a) take it / (b) new idea / (c)
      accept pattern, and a new idea about a step's wording is not worth offering
  - **recommended:** (c), because the options offered are the ones that make sense
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's "Not my call" in step 6, round 2
  - **answer:**
- **`q-unblocks-done`** — `q-step1-status` and several other questions from step 6 give only
  "the chain's `done`" under `unblocks:`, not any plan item.
  - **options:**
    - (a) take it into this chain: a later step rewords those lines
    - (b) leave it to a new idea about what `unblocks:` may name, whose brief you write
    - (c) accept it as it is: with nothing left to land, the chain's `done` is the only thing
      they hold back
  - **recommended:** (c), because it is true: no item waits on them
  - **unblocks:** the chain's `done`
  - **raised by:** the refinement-prover's "Not my call" in step 6, round 2
  - **answer:**
