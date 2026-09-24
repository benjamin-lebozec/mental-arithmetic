---
idea: doc-citations
chain: trunk
step: 2
status: refining
waits on: the method stating `doc:`, a direct edit outside refine
remaining: 1q + 3r + 2i + 2f
---

# Docs that follow the features they show

## Why

- **`why`** — The README fell out of date when the keypad changed, and nothing caught it: it
  cited only `CAP-root/readme`, so a change to the app's capabilities never brought it into
  review. The only form that could link it to them was `uses:`, which means "depends on", and
  a README does not depend on the app: it shows it.

## Requirements

- **`r-doc-form`** — A fifth citation form, `[doc: CAP-<namespace>/<name>]`, says that the
  file citing it shows or explains that capability to a reader. It is not a dependency, and it
  constrains nothing: the claim stays in its `SPEC.md`. It is never a file's header citation
  and covers no lines: the header still cites `provides:`, `enforces:`, `uses:` or
  `demonstrates:`, and `doc:` sits beside it.
  - **delivered by:** the method, edited directly outside this chain; nothing lands in the
    tree for it
- **`r-doc-cite`** — A shipped file that shows or explains another part's behaviour (a
  README, a screenshot's alt text, a sample) cites with `doc:` each capability it shows.
  - **delivered by:** the method, edited directly outside this chain; in the tree, only the
    README's citations, under the reopened `CAP-root/readme`
- **`r-doc-review`** — When a change touches a capability, review reads every file that cites
  it with `doc:`, and asks whether that file still matches it: its words, pictures and
  samples. A file that no longer matches is a finding that breaks the review, like a claim
  that does not hold: the change is not committed until the file is updated.
  - **delivered by:** the method, edited directly outside this chain; nothing lands in the
    tree for it

## To land

Nothing to land yet.

## Reopened

- **`CAP-root/readme`** — in `SPEC.md`
  - **now says:** its **why:** line, "the README cites, as uses:, the six app capabilities
    its screenshot shows, `CAP-app/pick-digit-count`, `CAP-app/new-pair`,
    `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`, `CAP-app/check-at-end` and
    `CAP-app/try-again`, so a change to any of them brings the README into that change's
    review."
  - **change:** the README cites those six capabilities with `doc:`, not as uses:; the
    capability line and its success criterion are unchanged.
  - **new text:** its **why:** line becomes "the README cites, with doc:, the six app
    capabilities its screenshot shows, `CAP-app/pick-digit-count`, `CAP-app/new-pair`,
    `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`, `CAP-app/check-at-end` and
    `CAP-app/try-again`, so a change to any of them brings the README into that change's
    review."; the README's six `[uses: …]` become `[doc: …]` on the same ids, beside its
    `[provides: CAP-root/readme]` header
  - **waits on:** the method stating `doc:`, since a README citing `doc:` before the method
    knows the form fails review
  - **authority:** the brief: "the README's six `uses:` become `doc:`"
  - **held in:** `README.md`
  - **status:** planned
- **`LIM-root/screenshot-freshness`** — in `SPEC.md`
  - **now says:** "A change to the app's screen brings the README's screenshot into review
    only when it touches one of the app capabilities the README cites as uses:; a change that
    touches none of them does not take the screenshot again. A new element under a new
    capability is caught only once that capability is added to the README's uses:; a change
    of theme or colour that touches none of them is never caught by the uses:, and the
    screenshot is then retaken only by hand." with **shown by:** "review, reading the
    README's uses: against the app capabilities that shape the screen"
  - **change:** the limit is stated over the README's `doc:` citations instead of its uses:;
    what it admits is unchanged: a change that touches no cited capability, such as a theme
    or a colour, is still not caught.
  - **new text:** "A change to the app's screen brings the README's screenshot into review
    only when it touches one of the app capabilities the README cites with doc:; a change
    that touches none of them does not take the screenshot again. A new element under a new
    capability is caught only once that capability is added to the README's doc: citations;
    a change of theme or colour that touches none of them is never caught by the doc:
    citations, and the screenshot is then retaken only by hand." with **shown by:** "review,
    reading the README's doc: citations against the app capabilities that shape the screen"
  - **waits on:** the method stating `doc:`, landing with `CAP-root/readme`
  - **authority:** the brief: "a change that touches no cited capability (a theme, a colour)
    is still not caught; that stays a known limit"
  - **held in:** none (a limit, reviewed by demonstration)
  - **status:** planned

## Success signal

- **`s-doc-review`** — In a scratch copy of the tree, a change to the declaration of one
  capability the README cites with `doc:` (say `CAP-app/posed-layout`) is reviewed, and the
  review lists the README and judges whether it still matches that capability; and a search
  shows the README carries six `doc:` citations and no `uses:`.

## Assumptions

- **`a-doc-any-path`** — A `doc:` citation may name a `CAP-` declared in any `SPEC.md`, not
  only one on the citing file's path, as `uses:` may; since it is not a dependency, the
  no-cycle rule does not count it.
  - **raised by:** `r-doc-cite`, "shows or explains another part's behaviour"
  - **bears on:** `r-doc-form`
- **`a-readme-only`** — Today the README is the only shipped file that shows or explains
  another part's behaviour, so it is the only file that gains `doc:` citations.
  - **raised by:** `r-doc-cite`
  - **bears on:** `r-doc-cite`, `CAP-root/readme` (reopened)

## Files

- `README.md` — holds: `CAP-root/readme` (reopened), and its six `doc:` citations —
  planned
- `SPEC.md` — holds: `CAP-root/readme`, `LIM-root/screenshot-freshness` (reopened) — planned

## Open Questions

- **`q-method-close`** — Once the method states `doc:`, how do `r-doc-form`, `r-doc-cite`,
  `r-doc-review` and `a-doc-any-path` leave this plan? They are delivered outside the tree,
  so no landing takes them out, and the chain cannot be done while they stay.
  - **options:**
    - (a) The step after the method edit records them as amended: dropped from this chain,
      with the user's confirmation that the method now says each of them.
    - (b) The chain also lands a review-held claim in the root `SPEC.md` stating the form and
      what review does with it, and they land there (the tree-side route that `q-method-home`
      did not take).
  - **recommended:** (a), because it keeps the answer to `q-method-home`: the form lives in
    the method, and an amendment is the fate that records a decision the user confirms.
  - **unblocks:** `r-doc-form`, `r-doc-cite`, `r-doc-review`, `a-doc-any-path`, and the
    chain's `done`
  - **raised by:** the answer to `q-method-home`, (a), which delivers those requirements
    outside the tree
  - **answer:**
