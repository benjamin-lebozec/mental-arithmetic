---
idea: github-ci
chain: trunk
step: 5
refines: step-4.md
---

# Step 5: land both CI limits into the ci spec; chain done

## This step

Lands the two limits step-4 settled, `LIM-ci/artifact-retention` and
`LIM-ci/actions-minutes`, into `.github/workflows/SPEC.md`, which then closes. No answers
to apply and no amendments. Nothing was settled under standing authorization. The plan then
holds only its Why and Success signal, so the chain is done.
`status: refining → done`, `remaining: 0q + 0r + 2i + 1f → 0q + 0r + 0i + 0f`.

## Changes

- **`LIM-ci/artifact-retention`** — landed
  - **was:** "A run offers its APK for GitHub's default artifact retention, 90 days; after
    that the run no longer offers it, and a fresh one is had by starting the workflow by
    hand." (raised by: review found the run's artifact expires (`expires=2026-12-22`),
    bounding `CAP-ci/github-build`'s "offers the APK for download", and no claim said so;
    held by: demonstration: `gh api` lists the run's artifact with an `expires_at` 90 days
    after its `created_at`; lands in: `.github/workflows/SPEC.md`; status: planned)
  - **now:** into `.github/workflows/SPEC.md`, Known limits. The claim as written. Its
    **held by:** is reworded to "`gh api` lists the run's artifact with an `expires_at` 90
    days after the run started", because GitHub counts retention from the run's start, not
    the artifact's `created_at` (see Demonstrations): the same demonstration, stated
    exactly. The `raised by:` line stays in this record only.
  - **verdict:** discharged
- **`LIM-ci/actions-minutes`** — landed
  - **was:** "The repository is private, so its runs count against the account's metered
    GitHub Actions minutes; once they run out, pushes are no longer built until the quota
    renews." (raised by: review found this bounds `CAP-ci/github-build`'s "every change
    pushed" and `INV-ci/triggers`' "every push", given `REQ-ci/github-repository`'s
    "private", and no claim said so; held by: demonstration: `gh repo view` shows the
    repository private; lands in: `.github/workflows/SPEC.md`; status: planned)
  - **now:** into `.github/workflows/SPEC.md`, Known limits, as written, with its **held
    by:** line. The `raised by:` line stays in this record only.
  - **verdict:** discharged
- **To land section** — refined
  - **was:** the two limits above
  - **now:** "Nothing left to land: `LIM-ci/artifact-retention` and
    `LIM-ci/actions-minutes` landed in step-5."
  - **verdict:** discharged
- **`.github/workflows/SPEC.md`** — closed
  - **was:** "`.github/workflows/SPEC.md` — holds: `LIM-ci/artifact-retention`,
    `LIM-ci/actions-minutes` — written in step-3, open for: `LIM-ci/artifact-retention`,
    `LIM-ci/actions-minutes`"
  - **now:** "No files left: `.github/workflows/SPEC.md` closed in step-5."
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

- **`LIM-ci/artifact-retention`** — `gh api repos/benjamin-lebozec/mental-arithmetic/actions/artifacts`
  lists `app-debug` of run 35837993757 (commit 703d94d, success) with `created_at`
  2026-09-23T08:39:46Z and `expires_at` 2026-12-22T08:35:33Z. The run's `run_started_at`
  is 2026-09-23T08:35:32Z, so the artifact expires 90 days after the run started. Run
  35833511121 shows the same (started 07:46, expires 2026-12-22T07:46:45Z).
  `gh api …/actions/permissions/artifact-and-log-retention` reads `{"days":90}`.
- **`LIM-ci/actions-minutes`** — `gh repo view --json visibility` shows
  `benjamin-lebozec/mental-arithmetic` `PRIVATE`.
- No capability or code-held invariant lands, and no Gradle module changed, so no tests
  were run.

## Reviews

`module-contract-reviewer`, scope full (the chain reaches `done`). Every citation rule
holds over all 23 shipped files. No commit is unaccounted for since the last full review:
only 703d94d (step-3) touches shipped files, and 85f3b34, a throwaway commit pushed only to
run the workflow, is on no branch. Every claim it walked holds: the two new limits, and
every `NOT-`, review-held `INV-`, `REQ-` and `LIM-` in the tree, including this chain's
`INV-ci/one-build-path`, `INV-ci/fails-on-failure`, `INV-ci/triggers`,
`REQ-ci/github-repository` and `LIM-ci/build-by-run`. One note, not a failure: for
`LIM-ci/actions-minutes`, it confirmed that the repository is private, but not that pushes
stop being built rather than billed once the minutes run out. That depends on the
account's billing settings, which the token cannot read (`user` scope missing). Nothing
fixed.

## Proof

- **re-proof of step-4** — skipped: nothing changed since step-4's commit (empty diff).
- **rounds** — passed first time. The prover left `landed` and `terminal` waiting only on
  the review being recorded as passed and on the plan saying `done`. Both are now done.
- **matched** — discharged; the plan's and the spec's diffs match the four Changes entries.
- **coverage** — discharged; four changed items and files have their true fates, and the
  two untouched items are kept.
- **no-widening** — discharged; both claims landed as written, and the reworded `held by:`
  is more exact.
- **no-narrowing** — discharged; neither claim gained a precondition.
- **answers-applied** — discharged; no question closed in this step.
- **justified** — discharged; nothing new.
- **consistent** — discharged; the limits bound `CAP-ci/github-build` and `INV-ci/triggers`
  without contradicting them.
- **settled** — discharged; both limits were settled in step-4.
- **landed** — discharged; each id is declared once in `.github/workflows/SPEC.md`, none is
  cited, and the review passed.
- **demonstrated** — discharged; both demonstrations are recorded, and no module's tests
  were due.
- **tree-kept** — discharged; the only change to the tree is the two limits.
- **files** — discharged; the one file is closed, and the other chain is done.
- **progress** — discharged; two items land.
- **amendments** — discharged; none.
- **terminal** — discharged; only Why and Success signal are left.
  `s-green-run-with-apk` is shown by `CAP-ci/github-build`, and the review records every
  claim this chain landed without code as true of the tree.
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a.
