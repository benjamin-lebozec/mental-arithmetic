---
idea: doc-citations
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the four answers; the form and its review go to the method, the tree side waits on it

## This step

Applies the four answers. `q-validation` gives the Success signal `s-doc-review`.
`q-method-home` sends `r-doc-form`, `r-doc-cite` and `r-doc-review` to the method, edited
directly outside this chain, and the chain waits on that edit. `q-doc-mismatch` and
`q-doc-header` sharpen `r-doc-review` and `r-doc-form`. `r-readme-doc` is absorbed by the
reopened `CAP-root/readme`, and both reopened items now carry their exact new text. They are
settled, but wait on the method. Asks how the requirements delivered by the method leave
the plan (`q-method-close`). Nothing lands.
`status: refining → refining`, `remaining: 4q + 4r + 2i + 2f → 1q + 3r + 2i + 2f`.

## Changes

- **`q-validation`** — answered
  - **was:** "How will we validate that it works?", options (a) a demonstration review in a
    scratch copy, (b) only the search and a reading, (c) wait for the next real change
  - **now:** answer "(a): "Demo review (Recommended)" (2026-09-24, in the conversation)";
    produced `s-doc-review`
  - **verdict:** discharged
- **`q-method-home`** — answered
  - **was:** "Where is the `doc:` form stated, and where is review told to read `doc:`
    files? …", options (a) in the method, edited directly outside this chain, (b) in the
    tree too, (c) only in the tree
  - **now:** answer "(a): "Method, edited directly (Recommended)" (2026-09-24, in the
    conversation)"; produced the `delivered by:` lines of `r-doc-form`, `r-doc-cite` and
    `r-doc-review`, the `waits on:` lines of both reopened items, and the plan's `waits on`
  - **verdict:** discharged
- **`q-doc-mismatch`** — answered
  - **was:** "When review finds a `doc:` file that no longer matches the capability it
    cites, what does it do?", options (a) a finding that breaks the review, (b) a warning
  - **now:** answer "(a): "Breaks the review (Recommended)" (2026-09-24, in the
    conversation)"; produced the last sentence of `r-doc-review`
  - **verdict:** discharged
- **`q-doc-header`** — answered
  - **was:** "Can a `doc:` citation be a file's header citation, the one that covers the
    whole file (for a shipped sample that provides nothing itself)?", options (a) no, (b) yes
  - **now:** answer "(a): "No (Recommended)" (2026-09-24, in the conversation)"; produced
    the last sentence of `r-doc-form`
  - **verdict:** discharged
- **`r-doc-form`** — refined
  - **was:** "A fifth citation form, `[doc: CAP-<namespace>/<name>]`, says that the file
    citing it shows or explains that capability to a reader. It is not a dependency, and it
    constrains nothing: the claim stays in its `SPEC.md`."
  - **now:** the same, plus "It is never a file's header citation and covers no lines: the
    header still cites `provides:`, `enforces:`, `uses:` or `demonstrates:`, and `doc:` sits
    beside it.", and **delivered by:** "the method, edited directly outside this chain;
    nothing lands in the tree for it"
  - **verdict:** discharged
- **`r-doc-cite`** — refined
  - **was:** "A shipped file that shows or explains another part's behaviour (a README, a
    screenshot's alt text, a sample) cites with `doc:` each capability it shows."
  - **now:** the same, plus **delivered by:** "the method, edited directly outside this
    chain; in the tree, only the README's citations, under the reopened `CAP-root/readme`"
  - **verdict:** discharged
- **`r-doc-review`** — refined
  - **was:** "When a change touches a capability, review reads every file that cites it with
    `doc:`, and asks whether that file still matches it: its words, pictures and samples."
  - **now:** the same, plus "A file that no longer matches is a finding that breaks the
    review, like a claim that does not hold: the change is not committed until the file is
    updated.", and **delivered by:** "the method, edited directly outside this chain;
    nothing lands in the tree for it"
  - **verdict:** discharged
- **`r-readme-doc`** — absorbed
  - **was:** "The README's six `uses:` citations become `doc:` citations."
  - **now:** absorbed by the reopened `CAP-root/readme`, whose **change:** already says it
    and whose **new text:** now says it per citation
  - **verdict:** discharged
- **`CAP-root/readme`** (reopened) — refined
  - **was:** the entry without a new text or a wait
  - **now:** adds **new text:** (the why line with "with doc:" for "as uses:", and the
    README's six `[uses: …]` becoming `[doc: …]` beside its `[provides: CAP-root/readme]`
    header) and **waits on:** "the method stating `doc:`, since a README citing `doc:`
    before the method knows the form fails review"; status stays planned
  - **verdict:** discharged
- **`LIM-root/screenshot-freshness`** (reopened) — refined
  - **was:** the entry without a new text or a wait
  - **now:** adds **new text:** (the limit and its shown by, with "cites with doc:",
    "doc: citations" for "cites as uses:", "uses:") and **waits on:** "the method stating
    `doc:`, landing with `CAP-root/readme`"; status stays planned
  - **verdict:** discharged
- **`a-readme-only`** — kept, one line changed
  - **was:** "**bears on:** `r-doc-cite`, `r-readme-doc`"
  - **now:** "**bears on:** `r-doc-cite`, `CAP-root/readme` (reopened)", since
    `r-readme-doc` was absorbed there
  - **verdict:** discharged
- **`README.md`** — kept, holds line reworded
  - **was:** "holds: `CAP-root/readme` (reopened), and the six `doc:` citations of
    `r-readme-doc` — planned"
  - **now:** "holds: `CAP-root/readme` (reopened), and its six `doc:` citations — planned"
  - **verdict:** discharged

New in this step:

- **`s-doc-review`**
  - **justified by:** the answer to `q-validation`, (a); it replaces "Nothing yet: it waits
    on `q-validation`."
  - **verdict:** discharged
- **`q-method-close`**
  - **justified by:** the answer to `q-method-home`, (a): it delivers `r-doc-form`,
    `r-doc-cite` and `r-doc-review` outside the tree, so how they leave the plan is a new
    question that this decision raises
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit
- **rounds** — two. Round 1 failed nothing, but noted that the requirements delivered by
  the method had no fate that could take them out of the plan; `q-method-close` was added,
  and round 2 discharged it
- **matched** — discharged; every change in the plan's diff has its Changes entry, and there
  is no spec diff
- **coverage** — discharged; 4 questions answered, 3 requirements and 2 reopened items
  refined, `r-readme-doc` absorbed, `a-readme-only` kept with one line retargeted, the rest
  untouched and still true
- **no-widening** — discharged; requirement texts kept word for word and only sharpened by
  answers; the new texts admit exactly what each `change:` said
- **no-narrowing** — discharged; the only restrictions added come from the answers to
  `q-doc-header` and `q-doc-mismatch`
- **answers-applied** — discharged; each answer is quoted, and its items say that option and
  no more
- **justified** — discharged; `s-doc-review`, the `delivered by:`, `waits on:` and
  `new text:` lines, and `q-method-close` each trace to an answer or make a `change:` exact
- **consistent** — discharged; `LIM-root/shown-by-hand` and `CAP-root/readme`'s success
  criterion stay true
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed and no
  file in the tree changed
- **files** — discharged; both files planned, listed by no other chain in flight
- **progress** — discharged; four questions closed; the one new question follows from the
  answer to `q-method-home`
- **amendments** — discharged; none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
