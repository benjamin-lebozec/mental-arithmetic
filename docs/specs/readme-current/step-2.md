---
idea: readme-current
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the three answers: the reopened readme claim drafted, with its six uses: and a new screenshot; two questions from the proof

## This step

The three answers close the three questions. `q-freshness-held` and `q-validation` settle the
new text of the reopened `CAP-root/readme`: the README shows the app as it is now, a change
to the screen's look takes the screenshot again, and the README cites, as uses:, the six app
capabilities its screenshot shows. `q-alt-text` settles the alt text. `r-screenshot-current`
becomes part of the reopened claim, and `s-screenshot-current` is the success signal. The
prover's two "Not my call" lines become `q-uses-gap` and `q-root-uses-app`, which the
reopened claim and `README.md` now wait on. Nothing lands.
`status: refining → refining`, `remaining: 3q + 1r + 1i + 3f → 2q + 0r + 1i + 3f`.

## Changes

- **`q-validation`** — answered
  - **was:** "How will we validate that it works?", options (a) a new screenshot on the
    emulator, then reading the README on GitHub after the push, (b) the same without
    GitHub, recommended (a)
  - **now:** answer: "in the user's own words: "a graphical change of the main app should
    always trigger a new screenshot" (2026-09-23, in the conversation); asked whether the
    check is the emulator alone or also reading the README on GitHub, the user answered
    with a question on binding the README to capabilities, which `q-freshness-held`
    records". It yields: in `CAP-root/readme`'s will-say, "a change to how the app's screen
    looks takes the screenshot again" and a success that shows "a screenshot of the app's
    screen as it is now"; and `s-screenshot-current`. Where the screenshot is taken, "on the
    Android Studio emulator through `adb`", comes from `a-same-scene`, not from this answer,
    and goes into the will-say's `assumes:`. Reading the README "as GitHub shows it" is not added by this
    answer: it is kept from the landed success line.
  - **verdict:** discharged
- **`q-freshness-held`** — answered
  - **was:** "How is "the README reflects the current app" kept true by later changes?",
    options (a) wording only, (b) wording and a review-held invariant, (c) wording and a
    `LIM-`, recommended (b)
  - **now:** answer: "first (b): "Wording + review-held INV (Recommended)"; then, in the
    same conversation, replaced by: "uses: citations, no INV (Recommended)": the README
    cites `[uses:]` on the app capabilities it shows, so changing one brings the README
    into that step's review; and, asked which it shows: "All six (Recommended)":
    `CAP-app/pick-digit-count`, `CAP-app/new-pair`, `CAP-app/posed-layout`,
    `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`, `CAP-app/try-again`" (2026-09-23).
    It yields the will-say's `why:` line, the six uses: on `README.md`'s file line, and no
    `INV-`.
  - **verdict:** discharged
- **`q-alt-text`** — answered
  - **was:** "What does the README's alt text for the screenshot say?", options (a) the
    scene without operands, (b) the new picture's operands, recommended (a)
  - **now:** answer: "(a): "Scene, no operands (Recommended)" (2026-09-23, in the
    conversation)". It yields the alt text on `README.md`'s file line: "a 3-digit
    multiplication after the check, with wrong digits in red".
  - **verdict:** discharged
- **`r-screenshot-current`** — refined
  - **was:** "The README's screenshot is taken again, so that it shows the app as it is
    now."
  - **now:** the reopened `CAP-root/readme`'s will-say ("sees a screenshot of it … the
    words and the screenshot show the app as it is now"), held in `.github/screenshot.png`,
    and `s-screenshot-current`. The Requirements section now reads "Nothing left: the one
    requirement became the reopened `CAP-root/readme`."
  - **verdict:** discharged
- **`CAP-root/readme`** (reopened) — refined
  - **was:** the entry with `now:`, `change:`, `authority:`, `held in:` and `status:
    planned`, no new text
  - **now:** adds `will say:` with the claim's full new text, and `decided by:` quoting the
    three answers; everything else unchanged, `status: planned`
  - **verdict:** discharged
- **To land** section — kept, line changed
  - **was:** "Nothing yet: every item here still waits on an open question."
  - **now:** "Nothing new to land: the one item left is reopened below."
  - **verdict:** discharged
- **Success signal** — refined
  - **was:** "Nothing yet: it waits on `q-validation`."
  - **now:** `s-screenshot-current`
  - **verdict:** discharged
- **`a-same-scene`** — kept, `bears on:` changed
  - **was:** "**bears on:** `r-screenshot-current`"
  - **now:** "**bears on:** `CAP-root/readme`, as its `assumes:` line", since
    `r-screenshot-current` became that claim; the will-say's `assumes:` carries it: "the
    screenshot shows a 3-digit multiplication after the check, with wrong digits in red,
    taken on the Android Studio emulator through `adb`", and "only the app in it is current"
    is in the claim's "the screenshot show[s] the app as it is now"
  - **verdict:** discharged
- **`README.md`** — kept, line sharpened
  - **was:** "`README.md` — holds: `CAP-root/readme` (reopened) — planned"
  - **now:** adds the six uses: from `q-freshness-held` and the alt text from `q-alt-text`;
    planned; it waits on `q-root-uses-app`
  - **verdict:** discharged
- **`.github/screenshot.png`** — kept, `holds:` changed
  - **was:** "holds: `r-screenshot-current` — planned"
  - **now:** "holds: `CAP-root/readme` (reopened), its screenshot — planned", since the
    requirement became that claim
  - **verdict:** discharged
- **Open Questions** section — the three questions above closed; two new ones follow
  - **verdict:** discharged

New in this step:

- **`s-screenshot-current`**
  - **justified by:** `q-validation`'s answer, "a graphical change of the main app should
    always trigger a new screenshot", and `r-screenshot-current`, with the Why's "the old
    keypad, 7 8 9 on top, and no New button" as what the new picture shows instead
  - **verdict:** discharged
- **`q-uses-gap`**
  - **justified by:** `q-freshness-held`'s answer, applied in this step; the prover's "Not
    my call" (see Reviews)
  - **verdict:** discharged
- **`q-root-uses-app`**
  - **justified by:** `q-freshness-held`'s answer, applied in this step; the prover's "Not
    my call" (see Reviews)
  - **verdict:** discharged

## Amendments

None. The diff since step-1's commit shows only the three `answer:` lines.
`q-freshness-held`'s answer replaced its first choice within the same conversation, before
any step applied it, and both are quoted in its line.

## Demonstrations

None: nothing lands in this step.

## Reviews

None: nothing in the tree changed, so the module-contract-reviewer did not run.

"Not my call", from the `refinement-prover`:

- "The will-say's "a change to how the app's screen looks takes the screenshot again" is
  held only by the uses: on six named capabilities. A change to the screen that touches
  none of them would not bring the README into review. That could be a new element on the
  screen under a new CAP, or a theme or colour change. Should the claim be worded to match
  what the uses: actually catch, or should the gap be recorded as a `LIM-`?" — became
  `q-uses-gap`.
- "Should a uses: citation from the root's `README.md` onto app capabilities count as a
  dependency of the root on `app`? The `module-contract-reviewer` should weigh that against
  the root contract's dependency rule when this lands." — became `q-root-uses-app`.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit
- **rounds** — two
  - round 1: `answers-applied` failed: the success line and `s-screenshot-current` credited
    "taken on the Android Studio emulator through `adb`" to `q-validation`'s answer, which
    did not say it; fixed by moving it into the will-say's `assumes:`, credited to
    `a-same-scene`. The prover's two "Not my call" lines became `q-uses-gap` and
    `q-root-uses-app`, and `settled by:` became `decided by:`
  - round 2: all discharged
- **matched** — discharged; the plan's diff and Changes agree both ways; no spec changed
- **coverage** — discharged; every abstract item has one fate; `why`, `a-words-and-picture`
  and the `SPEC.md` Files line are untouched
- **no-widening** — discharged; the success line only sharpens "the screenshot"
- **no-narrowing** — discharged; the old claim's text and both its assumes are kept whole
- **answers-applied** — discharged; each closed question quotes its answer, and the items
  say no more than it; the emulator clause is credited to `a-same-scene`
- **justified** — discharged; every new item names an answer, `r-screenshot-current`, or
  a "Not my call" quoted in Reviews
- **consistent** — discharged; `LIM-root/shown-by-hand` stays true, since "as GitHub shows
  it" is kept; the gap between the rule and the six uses: is the open `q-uses-gap`
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: nothing lands, and only
  the plan changed
- **files** — discharged; all three kept, none `to write`, no other chain in flight
- **progress** — discharged; three questions closed; the two new ones name the decision
  that raised them
- **amendments** — discharged; none claimed, none needed
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
