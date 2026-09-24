---
idea: doc-citations
chain: trunk
step: 1
status: refining
waits on: none
remaining: 4q + 4r + 2i + 2f
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
  constrains nothing: the claim stays in its `SPEC.md`.
- **`r-doc-cite`** — A shipped file that shows or explains another part's behaviour (a
  README, a screenshot's alt text, a sample) cites with `doc:` each capability it shows.
- **`r-doc-review`** — When a change touches a capability, review reads every file that cites
  it with `doc:`, and asks whether that file still matches it: its words, pictures and
  samples.
- **`r-readme-doc`** — The README's six `uses:` citations become `doc:` citations.

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
  - **authority:** the brief: "a change that touches no cited capability (a theme, a colour)
    is still not caught; that stays a known limit"
  - **held in:** none (a limit, reviewed by demonstration)
  - **status:** planned

## Success signal

Nothing yet: it waits on `q-validation`.

## Assumptions

- **`a-doc-any-path`** — A `doc:` citation may name a `CAP-` declared in any `SPEC.md`, not
  only one on the citing file's path, as `uses:` may; since it is not a dependency, the
  no-cycle rule does not count it.
  - **raised by:** `r-doc-cite`, "shows or explains another part's behaviour"
  - **bears on:** `r-doc-form`
- **`a-readme-only`** — Today the README is the only shipped file that shows or explains
  another part's behaviour, so it is the only file that gains `doc:` citations.
  - **raised by:** `r-doc-cite`
  - **bears on:** `r-doc-cite`, `r-readme-doc`

## Files

- `README.md` — holds: `CAP-root/readme` (reopened), and the six `doc:` citations of
  `r-readme-doc` — planned
- `SPEC.md` — holds: `CAP-root/readme`, `LIM-root/screenshot-freshness` (reopened) — planned

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) A demonstration review: in a scratch copy of the tree, change the declaration of
      one capability the README cites with `doc:` (say `CAP-app/posed-layout`), run the
      review, and see it list the README and judge whether the README still matches; plus a
      search showing the README carries six `doc:` and no `uses:`.
    - (b) Only the search over the README's citations, and a reading of the new rule.
    - (c) Wait for the next real change to one of those capabilities, and see its review read
      the README.
  - **recommended:** (a), because it shows the brief's own claim ("review reads every file
    that cites it with `doc:`") happening, now, without waiting on a real change.
  - **unblocks:** the Success signal; the success criteria of every item to come
  - **raised by:** the brief, "when a change touches a capability, review reads every file
    that cites it with `doc:`"
  - **answer:**
- **`q-method-home`** — Where is the `doc:` form stated, and where is review told to read
  `doc:` files? The other four forms, and the review's checklist, live in the method, which
  this chain's plan and steps may not name.
  - **options:**
    - (a) In the method, as a direct edit outside this chain, reviewed like any change made
      outside refine; this chain then lands only the tree's side (the README and the root
      `SPEC.md`), and waits on that edit.
    - (b) In the tree too: the chain also lands a review-held claim in the root `SPEC.md`
      stating the `doc:` form and what review does with it, so the tree explains its own
      citations; the method is still edited to recognize it.
    - (c) Only in the tree, as in (b), with the method left as it is.
  - **recommended:** (a), because the four forms it joins live in the method, and a README
    carrying `doc:` would fail review until the method knows the form; (c) would leave the
    method saying "four forms and no others".
  - **unblocks:** `r-doc-form`, `r-doc-review`, and where they land
  - **raised by:** the brief, "add a fifth citation form", and "review reads every file that
    cites it with `doc:`"
  - **answer:**
- **`q-doc-mismatch`** — When review finds a `doc:` file that no longer matches the
  capability it cites, what does it do?
  - **options:**
    - (a) It is a finding that breaks the review, like a claim that does not hold: the change
      is not committed until the file is updated.
    - (b) It is recorded as a warning, and the change may be committed.
  - **recommended:** (a), because a warning is how the README fell out of date the first
    time: nothing made anyone update it.
  - **unblocks:** `r-doc-review`
  - **raised by:** the brief, "asks whether it still matches: words, pictures, samples"
  - **answer:**
- **`q-doc-header`** — Can a `doc:` citation be a file's header citation, the one that
  covers the whole file (for a shipped sample that provides nothing itself)?
  - **options:**
    - (a) No: a file's header still cites `provides:`, `enforces:`, `uses:` or
      `demonstrates:`; `doc:` sits beside it and covers no lines.
    - (b) Yes: a file that only shows another part's behaviour may carry `doc:` as its
      header citation.
  - **recommended:** (a), because `doc:` "constrains nothing", so a file covered only by it
    would answer to no claim of its own part.
  - **unblocks:** `r-doc-form`, `r-doc-cite`
  - **raised by:** the brief, "a sample", and "it constrains nothing"
  - **answer:**
