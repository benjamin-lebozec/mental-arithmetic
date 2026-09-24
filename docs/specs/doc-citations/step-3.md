---
idea: doc-citations
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: the method states `doc:`, so its requirements are amended out and the README's citations land

## This step

Applies `q-method-close`, (a): the method now states `doc:` (the commit before this step), so
`r-doc-form`, `r-doc-cite`, `r-doc-review` and `a-doc-any-path` leave the plan as amended,
with the user's confirmation; `a-readme-only` is amended out with them. The wait on the method
is over, so the two reopened items settled in step-2, `CAP-root/readme` and
`LIM-root/screenshot-freshness`, land in `SPEC.md`, and the README's six `uses:` become
`doc:`. `s-doc-review` is demonstrated in a scratch copy.
`status: refining → done`, `remaining: 1q + 3r + 2i + 2f → 0q + 0r + 0i + 0f`.

## Changes

- **`q-method-close`** — answered
  - **was:** "Once the method states `doc:`, how do `r-doc-form`, `r-doc-cite`,
    `r-doc-review` and `a-doc-any-path` leave this plan? …", options (a) the step after the
    method edit records them as amended, with the user's confirmation that the method now
    says each of them, (b) the chain also lands a review-held claim in the root `SPEC.md`
  - **now:** answer "(a): "Amend them out (Recommended)" (2026-09-24, in the conversation)";
    produced the amended fates of `r-doc-form`, `r-doc-cite`, `r-doc-review` and
    `a-doc-any-path` below
  - **verdict:** discharged
- **`r-doc-form`** — amended (dropped)
  - **was:** "A fifth citation form, `[doc: CAP-<namespace>/<name>]`, says that the file
    citing it shows or explains that capability to a reader. It is not a dependency, and it
    constrains nothing: the claim stays in its `SPEC.md`. It is never a file's header citation
    and covers no lines: the header still cites `provides:`, `enforces:`, `uses:` or
    `demonstrates:`, and `doc:` sits beside it." with **delivered by:** "the method, edited
    directly outside this chain; nothing lands in the tree for it"
  - **now:** removed from the plan; the method states it
  - **verdict:** discharged
- **`r-doc-cite`** — amended (dropped)
  - **was:** "A shipped file that shows or explains another part's behaviour (a README, a
    screenshot's alt text, a sample) cites with `doc:` each capability it shows." with
    **delivered by:** "the method, edited directly outside this chain; in the tree, only the
    README's citations, under the reopened `CAP-root/readme`"
  - **now:** removed from the plan; the method states it, and the README's citations land
    with the reopened `CAP-root/readme`
  - **verdict:** discharged
- **`r-doc-review`** — amended (dropped)
  - **was:** "When a change touches a capability, review reads every file that cites it with
    `doc:`, and asks whether that file still matches it: its words, pictures and samples. A
    file that no longer matches is a finding that breaks the review, like a claim that does
    not hold: the change is not committed until the file is updated." with **delivered by:**
    "the method, edited directly outside this chain; nothing lands in the tree for it"
  - **now:** removed from the plan; the method states it
  - **verdict:** discharged
- **`a-doc-any-path`** — amended (dropped)
  - **was:** "A `doc:` citation may name a `CAP-` declared in any `SPEC.md`, not only one on
    the citing file's path, as `uses:` may; since it is not a dependency, the no-cycle rule
    does not count it." (raised by `r-doc-cite`, bears on `r-doc-form`)
  - **now:** removed from the plan; the method states it
  - **verdict:** discharged
- **`a-readme-only`** — amended (dropped)
  - **was:** "Today the README is the only shipped file that shows or explains another
    part's behaviour, so it is the only file that gains `doc:` citations." (raised by
    `r-doc-cite`, bears on `r-doc-cite`, `CAP-root/readme` (reopened))
  - **now:** removed from the plan, not landed as an `assumes:` line; which files must cite
    `doc:` is now the method's rule, held by review
  - **verdict:** discharged
- **`CAP-root/readme`** (reopened) — landed
  - **was:** status planned, waiting on the method stating `doc:`
  - **now:** into `SPEC.md`, its **why:** line as the plan's **new text:** gives it; held in
    `README.md`, whose six `[uses: …]` are now `[doc: …]` on the same ids beside its
    `[provides: CAP-root/readme]` header
  - **verdict:** discharged
- **`LIM-root/screenshot-freshness`** (reopened) — landed
  - **was:** status planned, waiting on the method stating `doc:`
  - **now:** into `SPEC.md`, as the plan's **new text:** gives it, with its **shown by:**
  - **verdict:** discharged
- **`README.md`** — closed
  - **was:** "holds: `CAP-root/readme` (reopened), and its six `doc:` citations — planned"
  - **now:** written in this step; nothing more is planned for it
  - **verdict:** discharged
- **`SPEC.md`** — closed
  - **was:** "holds: `CAP-root/readme`, `LIM-root/screenshot-freshness` (reopened) — planned"
  - **now:** written in this step; nothing more is planned for it
  - **verdict:** discharged
- **plan sections** — Requirements, Assumptions and Open Questions each now say "Nothing
  left.", having lost every item above
  - **verdict:** discharged

## Amendments

- **`r-doc-form`, `r-doc-cite`, `r-doc-review`, `a-doc-any-path`** — from the answer to
  `q-method-close`, (a), which drops them once the user confirms the method says each. The
  user confirmed it: "Confirm (Recommended)" (2026-09-24, in the conversation), to "Confirm
  that the method now says r-doc-form, r-doc-cite, r-doc-review and a-doc-any-path, so this
  step drops them from the plan as amended?"
- **`a-readme-only`** — from the conversation: "Amend it out too (Recommended)"
  (2026-09-24), to "What happens to a-readme-only …?", over the alternative of landing it as
  an `assumes:` line on `CAP-root/readme`.

## Demonstrations

- **`s-doc-review`** — "In a scratch copy of the tree, a change to the declaration of one
  capability the README cites with `doc:` (say `CAP-app/posed-layout`) is reviewed, and the
  review lists the README and judges whether it still matches that capability; and a search
  shows the README carries six `doc:` citations and no `uses:`."
  - Scratch copy: a detached `git worktree` of this step's tree, with a stand-in review
    report committed as the review base. The one change after it is `CAP-app/posed-layout`'s
    anchor line, "the shifted zeros written in advance and greyed" becoming "the shifted
    places left blank, no zeros written".
  - The review of that change listed `README.md` as an item because it cites
    `CAP-app/posed-layout` with `doc:`, and judged it. It found the words still match,
    since they don't describe the shifted places, but the screenshot shows the shifted
    zeros in grey. So the README no longer matches, and the review broke on it ("the
    screenshot has to be retaken before this change is committed"). It also broke on the
    code and on the capability's unchanged `success:` line, which the scratch edit left
    stale on purpose.
  - Search on this step's tree: `grep -o "\[doc: CAP-app/[a-z-]*\]" README.md | wc -l`
    gives 6, and `grep -c "\[uses:" README.md` gives 0.
- **`CAP-root/readme`** — "The README, as GitHub shows it, says what the app is, shows a
  screenshot of the app's screen as it is now, and says how to install an APK from outside
  the Play Store; its link downloads the latest `.apk`, which installs by hand on a real
  phone."
  - `git diff -- README.md` changes only lines 4-5, which sit inside the opening `<!-- … -->`
    comment that GitHub does not render. So the README as GitHub shows it is unchanged: its
    words, its screenshot, its link and its install steps are those already shown by hand,
    as `LIM-root/shown-by-hand` says. The review read the screenshot against the six app
    capabilities and found it matches each.
- No Gradle module changed (only `README.md` and `SPEC.md`), so no unit tests ran.

## Reviews

- Scope: the whole tree, since no review had been committed yet (bootstrap). One round.
- 62 items hold. 1 `restates`: the **why:** line of `CAP-root/readme` names the same six
  app capabilities as the README's `doc:` citations, so the two lists can drift. The line's
  text is what step-2 settled as the reopened item's **new text:**, and it restated the
  README's `uses:` in the same way before this step. Whether to take it out is the user's
  call, and another chain's open question already asks it, so it is not fixed here. Put to
  the user, who answered "Accept, non-blocking (Recommended)" (2026-09-24, in the
  conversation): the settled text lands as is, and the line is left to that question.
- The six README `doc:` items hold: the review read the screenshot against each app
  capability as its code builds it.

## Proof

- **re-proof of step-2** — skipped: only `q-method-close`'s `answer:` line changed since
  step-2's commit, and the method commit in between touched no file of the chain
- **rounds** — two
  - round 1: `demonstrated` failed, with no evidence recorded for `CAP-root/readme`'s
    criterion, and `landed` was undecidable on the review's `restates` finding. Fixed by
    recording the evidence and the user's answer, and by correcting This step's count
  - round 2: every obligation discharged
- **matched** — discharged; every change in the plan's, `SPEC.md`'s and `README.md`'s diffs
  has its entry, and every entry shows in them
- **coverage** — discharged; 11 abstract items and 2 files, one true fate each, and `why`
  and `s-doc-review` untouched and still true
- **no-widening** — discharged; both landed texts equal their settled **new text:**
- **no-narrowing** — discharged; the capability and success lines are unchanged, and so is
  the README as rendered
- **answers-applied** — discharged; `q-method-close`, (a), quoted, gave the four amended
  items, with the confirmation it required
- **justified** — discharged; nothing new
- **consistent** — discharged; the README's `doc:` use agrees with the method's rule
- **settled** — discharged; both reopened items were settled in step-2, and their one wait,
  the method stating `doc:`, was met by the method commit
- **landed** — discharged; each id is declared once in `root`, the `provides:` header is on
  its path, and the review's one `restates` was accepted by the user as non-blocking
- **demonstrated** — discharged; `CAP-root/readme` is unchanged as rendered, `s-doc-review`
  was shown in a scratch copy, and no Gradle module changed
- **tree-kept** — discharged; only `README.md` and `SPEC.md` changed, both for the reopened
  items
- **files** — discharged; both closed, neither listed by another chain
- **progress** — discharged; closes `q-method-close` and lands two items
- **amendments** — discharged; five amended items, each with its old text, its new text,
  and the user's word and date
- **terminal** — discharged; only Why and Success signal are left, `s-doc-review` is shown
  through the landed `CAP-root/readme`, and the reviewer holds `LIM-root/screenshot-freshness`
  true
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
