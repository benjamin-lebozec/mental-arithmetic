---
idea: doc-citations
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into four requirements, two reopened root claims and four questions

## This step

Formalizes the brief against the root `SPEC.md` and the README. Four requirements, two
reopened claims of the root (`CAP-root/readme`'s why line and `LIM-root/screenshot-freshness`,
which both speak of the README's uses:), two assumptions and two planned files. Nothing lands.
Asks `q-validation`, where the form and its review rule live (`q-method-home`), what a
mismatch does (`q-doc-mismatch`), and whether `doc:` can be a header citation (`q-doc-header`).
`status: (none) → refining`, `remaining: (none) → 4q + 4r + 2i + 2f`.

## Changes

Every statement of the brief, in order:

- **"The README fell out of date when the keypad changed, and nothing caught it. It cited
  only `CAP-root/readme`, so a change to the app's capabilities never brought it into review.
  The only citation form that could link it to them was `uses:`, which means "depends on",
  and a README does not depend on the app: it shows it."**
  - **now:** `why`
  - **verdict:** discharged
- **"add a fifth citation form, `[doc: CAP-<namespace>/<name>]`: this file shows or explains
  that capability to a reader. It is not a dependency, and it constrains nothing: the claim
  stays in the `SPEC.md`"**
  - **now:** `r-doc-form`
  - **raises:** `q-method-home`, `q-doc-header`
  - **verdict:** discharged
- **"a shipped file that shows or explains another part's behaviour (a README, a
  screenshot's alt text, a sample) cites with `doc:` each capability it shows"**
  - **now:** `r-doc-cite`
  - **raises:** `a-doc-any-path`, `a-readme-only`, `q-doc-header`
  - **verdict:** discharged
- **"when a change touches a capability, review reads every file that cites it with `doc:`,
  and asks whether it still matches: words, pictures, samples"**
  - **now:** `r-doc-review`
  - **raises:** `q-validation`, `q-doc-mismatch`, `q-method-home`
  - **verdict:** discharged
- **"the README's six `uses:` become `doc:`"**
  - **now:** `r-readme-doc`; reopened `CAP-root/readme`, whose why line says the README
    cites them "as uses:"; the file `README.md`
  - **verdict:** discharged
- **"and the argument that they are not a module dependency goes away"**
  - **now:** absorbed by `r-doc-form` ("It is not a dependency"): once the six citations are
    `doc:`, nothing is left to argue. The tree states no such argument today (no `SPEC.md`
    says the README's uses: are not a dependency), so nothing in it is removed.
  - **verdict:** discharged
- **"a change that touches no cited capability (a theme, a colour) is still not caught; that
  stays a known limit"**
  - **now:** reopened `LIM-root/screenshot-freshness`, restated over `doc:` with what it
    admits unchanged
  - **verdict:** discharged

New in this step:

- **`a-doc-any-path`**
  - **justified by:** `r-doc-cite`, "another part's behaviour": the capability shown is
    declared outside the citing file's path, as the README's six are
  - **verdict:** discharged
- **`a-readme-only`**
  - **justified by:** `r-doc-cite`; the README is the only shipped file found that shows
    another part's behaviour
  - **verdict:** discharged
- **`README.md`**, **`SPEC.md`** (Files)
  - **justified by:** the brief places the README ("the README's six `uses:`"); the root
    `SPEC.md` holds the two reopened claims
  - **verdict:** discharged
- **`q-validation`**, **`q-method-home`**, **`q-doc-mismatch`**, **`q-doc-header`**
  - **justified by:** the brief statements each names under **raised by:**
  - **verdict:** discharged
- **Success signal** — left empty, waiting on `q-validation`
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — n/a: step-0 is the brief
- **rounds** — two: round 1 discharged everything and noted that `q-method-home`'s
  **raised by:** named only "add a fifth citation form", though Changes also lists it under
  the review statement; the plan now names both, and round 2 discharged
- **matched** — discharged; the plan is new whole and all 16 of its items and files are in
  Changes; no spec changed
- **coverage** — discharged; all seven brief statements quoted, each with one fate
- **no-widening** — discharged; inferences are assumptions or questions; the reopenings
  keep the capability line, its success criterion and what the limit admits
- **no-narrowing** — discharged; `r-doc-cite` keeps the README, alt text and sample;
  `a-readme-only` is about today's tree, not a limit on the requirement
- **answers-applied** — discharged; no answers yet, `q-validation` asked with a
  recommendation
- **justified** — discharged; every assumption and question names its brief statement
- **consistent** — discharged; the only root claims speaking of the README's uses: are
  reopened; `INV-root/module-dependency` is untouched, since `doc:` is not a dependency
- **files** — discharged; `README.md` and the root `SPEC.md`, listed by no other chain in
  flight; the plan reopens root items
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: step 1 lands nothing
- **progress** — n/a: step 1 is the first formalization
- **amendments** — n/a: none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split
