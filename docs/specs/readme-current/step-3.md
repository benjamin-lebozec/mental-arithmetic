---
idea: readme-current
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: apply the two answers: a limit on the screenshot's freshness, and the README's uses: judged no dependency

## This step

`q-uses-gap`'s answer yields `LIM-root/screenshot-freshness`, to land in `SPEC.md`: the
screenshot is brought into review only by a change touching a capability the README uses.
`q-root-uses-app`'s answer adds to the `README.md` Files line that its uses: are not a
module dependency, which the module-contract-reviewer confirms when the file is written.
The prover's four "Not my call" lines become `q-uses-duty`, `q-theme-change`,
`q-dependency-recorded` and `q-limit-shown`, which the limit, the reopened
`CAP-root/readme` and the three files now wait on. Nothing lands.
`status: refining → refining`, `remaining: 2q + 0r + 1i + 3f → 4q + 0r + 2i + 3f`.

## Changes

- **`q-uses-gap`** — answered
  - **was:** the question "The reopened claim says "a change to how the app's screen looks
    takes the screenshot again", but the README's uses: name six capabilities. A change to
    the screen that touches none of them (a new element under a new capability, or a theme
    or colour change) would not bring the README into review. What should the tree say?",
    with options (a) record the gap as a `LIM-root/…`, (b) narrow the claim's wording,
    (c) accept it, (d) leave it to a new idea; recommended (a)
  - **now:** answer "(a): "Record a LIM (Recommended)" (2026-09-23, in the conversation)";
    it produced `LIM-root/screenshot-freshness`
  - **verdict:** discharged
- **`q-root-uses-app`** — answered
  - **was:** the question "Does a uses: citation from the root's `README.md` onto app
    capabilities count as a dependency of the root on `app`, under
    `INV-root/module-dependency`?", with options (a) no, the invariant governs modules'
    `build.gradle.kts` only, and the module-contract-reviewer confirms it when the item
    lands, (b) yes, and the root contract is reopened, (c) take the uses: elsewhere,
    (d) leave it to a new idea; recommended (a)
  - **now:** answer "(a): "No, not a dependency (Recommended)" (2026-09-23, in the
    conversation)"; it produced the added clause of the `README.md` Files line
  - **verdict:** discharged
- **To land section** — refined
  - **was:** "Nothing new to land: the one item left is reopened below."
  - **now:** the item `LIM-root/screenshot-freshness`
  - **verdict:** discharged
- **Open Questions section** — refined
  - **was:** the two questions above
  - **now:** the four questions below, new in this step
  - **verdict:** discharged
- **`SPEC.md`** — refined
  - **was:** "holds: `CAP-root/readme` (reopened) — planned"
  - **now:** "holds: `CAP-root/readme` (reopened), `LIM-root/screenshot-freshness` —
    planned"
  - **verdict:** discharged
- **`README.md`** — refined
  - **was:** "…the screenshot's alt text names the scene without operands: "a 3-digit
    multiplication after the check, with wrong digits in red" — planned"
  - **now:** the same, then "; its uses: are not a dependency of the root on `app` under
    `INV-root/module-dependency`, which governs only modules' `build.gradle.kts`, and the
    module-contract-reviewer confirms it when the file is written — planned"
  - **verdict:** discharged

New in this step:

- **`LIM-root/screenshot-freshness`** — "A change to the app's screen brings the README's
  screenshot into review only when it touches one of the app capabilities the README cites
  as uses:; a change that touches none of them, such as a new element under a new
  capability or a change of theme or colour, does not take the screenshot again unless that
  new capability is added to the README's uses:." Lands in `SPEC.md`, planned.
  - **justified by:** `q-uses-gap`'s answer, (a), whose option text it follows
  - **verdict:** discharged
- **`q-uses-duty`**, **`q-theme-change`**, **`q-limit-shown`**
  - **justified by:** `q-uses-gap`'s answer, applied in this step; each is a "Not my call"
    line of the refinement-prover, quoted under Reviews
  - **verdict:** discharged
- **`q-dependency-recorded`**
  - **justified by:** `q-root-uses-app`'s answer, applied in this step; a "Not my call" line
    of the refinement-prover, quoted under Reviews
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

"Not my call" lines from the refinement-prover, round 1, each now an open question:

- "Answer (a) said "a new app capability must add itself to those uses: to be covered". The
  LIM turns that into a condition ("unless that new capability is added"), and no claim
  makes adding it a duty. Should that duty become a claim somewhere, or is the LIM enough?"
  — became `q-uses-duty`
- "For the theme or colour case, the LIM's "unless that new capability is added" has no new
  capability to refer to. Should the LIM say how a theme change is ever caught, or that it
  never is?" — became `q-theme-change`
- "The `q-root-uses-app` decision lives only in the `README.md` Files line and the
  reviewer's future verdict. It leaves the plan when the file lands. Should it also land in
  `SPEC.md`, so that later full-tree reviews can see it?" — became `q-dependency-recorded`
- "The step calls the new LIM "settled", but the `settled` definition asks a limit to say
  how it is held, and this LIM does not. The existing `LIM-root/*` lines do not either.
  Should the LIM gain a line saying how it is shown, before next run's `settled` check?" —
  became `q-limit-shown`

## Proof

- **re-proof of step-2** — skipped: only `answer:` lines changed; `git diff 68599b2` on the
  plan showed the two `answer:` lines and nothing else, and no file of the Files list or spec
  changed
- **rounds** — two. Round 1 discharged every obligation and gave four "Not my call" lines,
  which became the four new questions. Round 2 discharged every obligation, with no "Not my
  call"
- **matched** — discharged; the plan's five changes (To land, two Files lines, two questions
  removed, four added) match Changes both ways, and no spec changed
- **coverage** — discharged; each changed item has its claimed fate, and the untouched
  reopened `CAP-root/readme` keeps its text and now waits on `q-dependency-recorded`
- **no-widening** — discharged; the limit admits a gap, and no criterion is loosened
- **no-narrowing** — discharged; the reopened claim's will-say and success are unchanged
- **answers-applied** — discharged; both answers quoted with their date, as the options chosen
- **justified** — discharged; the limit, the Files clause and each question name their answer
- **consistent** — discharged; the limit records where the claim is not held, and the
  `README.md` clause agrees with `INV-root/module-dependency`
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed, no file in
  the tree changed
- **files** — discharged; two files refined and one kept, none new, none `to write`, no other
  chain in flight
- **progress** — discharged; two questions closed, and each new question names the decision
  in this step that raised it
- **amendments** — discharged; none
- **terminal** — n/a; status is `refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; no split
