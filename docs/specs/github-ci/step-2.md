---
idea: github-ci
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the five answers, place six items in a new `ci` spec beside the workflow

## This step

Applies the five answers, each the recommended option chosen by the user (not under
standing authorization, so nothing lands in this step). `r-ci-builds-apk` becomes
`CAP-ci/github-build`, with its success criterion from `q-validation` and `q-tests`. The
answers yield three review-held invariants (`q-build-path`, `q-tests`, `q-trigger`), a
requirement (`q-repository`) and a limit. All are placed in a new `.github/workflows/SPEC.md`
(namespace `ci`), the deepest directory holding the one file that holds them, and all are
settled for the next run to land. `status: refining → refining`,
`remaining: 5q + 1r + 0i + 0f → 0q + 0r + 6i + 2f`.

## Changes

- **`r-ci-builds-apk`** — refined
  - **was:** "A CI on GitHub builds the APK from the repository, without anyone running a
    build on their own machine."
  - **now:** `CAP-ci/github-build`, with `INV-ci/one-build-path`, `INV-ci/fails-on-failure`,
    `INV-ci/triggers`, `REQ-ci/github-repository`, `LIM-ci/build-by-run`; the Requirements
    section now says "Nothing left to refine: `r-ci-builds-apk` became
    `CAP-ci/github-build`."
  - **verdict:** discharged
- **`q-validation`** — answered
  - **was:** "How will we validate that it works?"
  - **now:** (a): "Green run + APK (Recommended)" (2026-09-23, in the conversation); yields
    the success criterion of `CAP-ci/github-build`, `s-green-run-with-apk`, and
    `LIM-ci/build-by-run`
  - **verdict:** discharged
- **`q-build-path`** — answered
  - **was:** "How does the workflow build?"
  - **now:** (a): "Run ./build.sh (Recommended)" (2026-09-23, in the conversation); yields
    `INV-ci/one-build-path`, the `held in:` of `CAP-ci/github-build`, and leaves
    `CAP-root/docker-build`'s claims untouched (the workflow `[uses:]` it)
  - **verdict:** discharged
- **`q-tests`** — answered
  - **was:** "Does the CI also run the JVM unit tests of every module, failing the run when
    one fails?"
  - **now:** (a): "Yes (Recommended)" (2026-09-23, in the conversation); yields the tests in
    `CAP-ci/github-build`'s intent and success, and `INV-ci/fails-on-failure`
  - **verdict:** discharged
- **`q-trigger`** — answered
  - **was:** "When does the workflow run?"
  - **now:** (a): "Push, PR, by hand (Recommended)" (2026-09-23, in the conversation);
    yields `INV-ci/triggers`
  - **verdict:** discharged
- **`q-repository`** — answered
  - **was:** "The repository has no GitHub remote yet, and the CI can only run once it is
    pushed there. Who creates it?"
  - **now:** (b): "Claude, private (Recommended)" (2026-09-23, in the conversation); yields
    `REQ-ci/github-repository`, whose **made by:** line carries who creates the repository
    and when: "the landing run, with `gh repo create --private --source . --push`, before it
    demonstrates `CAP-ci/github-build`, without waiting on anyone (`q-repository` (b))"
  - **verdict:** discharged
- **`a-github-actions`** — kept, `bears on:` updated
  - **was:** "**bears on:** `r-ci-builds-apk`"
  - **now:** "**bears on:** `CAP-ci/github-build`, `REQ-ci/github-repository`"
  - **verdict:** discharged
- **`a-debug-apk`** — kept, `bears on:` updated
  - **was:** "**bears on:** `r-ci-builds-apk`"
  - **now:** "**bears on:** `CAP-ci/github-build`"
  - **verdict:** discharged
- **To land section** — "Nothing to land yet." replaced by the six items below
  - **verdict:** discharged
- **Success signal section** — "No success signal yet: it waits on `q-validation`."
  replaced by `s-green-run-with-apk`
  - **verdict:** discharged
- **Files section** — "No file placed yet." replaced by the two files below
  - **verdict:** discharged
- **Open Questions section** — every question closed; now "No open questions."
  - **verdict:** discharged

New in this step:

- **`CAP-ci/github-build`**
  - **justified by:** `r-ci-builds-apk`, sharpened by `q-validation` (a), `q-tests` (a) and
    `a-debug-apk`; landing place is the deepest directory holding `build.yml`
  - **verdict:** discharged
- **`INV-ci/one-build-path`**
  - **justified by:** `q-build-path` (a)
  - **verdict:** discharged
- **`INV-ci/fails-on-failure`**
  - **justified by:** `q-tests` (a), "failing the run when one fails"
  - **verdict:** discharged
- **`INV-ci/triggers`**
  - **justified by:** `q-trigger` (a)
  - **verdict:** discharged
- **`REQ-ci/github-repository`**
  - **justified by:** `q-repository` (b), and `a-github-actions` (hosted runners); the
    runner stands in for the host of `REQ-root/docker` and `REQ-root/network`; it is an
    Ubuntu runner because `./build.sh` needs a Linux Docker host
  - **verdict:** discharged
- **`LIM-ci/build-by-run`**
  - **justified by:** `q-validation` (a): the criterion is shown by a run on GitHub, which
    no test can carry out
  - **verdict:** discharged
- **`s-green-run-with-apk`**
  - **justified by:** `q-validation` (a)
  - **verdict:** discharged
- **`.github/workflows/SPEC.md`**
  - **justified by:** the six items above; namespace `ci`, new in the tree
  - **verdict:** discharged
- **`.github/workflows/build.yml`**
  - **justified by:** `a-github-actions` and `CAP-ci/github-build`
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed since step-1's commit
- **rounds**
  - round 1: `answers-applied` failed: `q-repository`'s who and when survived only in the
    step; a **made by:** line under `REQ-ci/github-repository` now carries them
  - round 2: passed
- **matched** — discharged; the plan's diff and Changes agree both ways, the specs' diff is
  empty
- **coverage** — discharged; `why` kept, `r-ci-builds-apk` refined, five `q-` answered, two
  `a-` kept; no untouched item made false
- **no-widening** — discharged; the CAP says at least what `r-ci-builds-apk` said, and the
  invariants only add constraints
- **no-narrowing** — discharged; every push, pull request and manual start is built without
  anyone building on their own machine
- **answers-applied** — discharged (round 2); all five answers applied as quoted, and
  `q-repository` (b)'s who and when are carried by the **made by:** line
- **justified** — discharged; every new item names its answer or abstract item
- **consistent** — discharged; the `ci` items contradict neither each other nor any root
  claim, and `ci` is a new namespace
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed and no
  file in the tree changed
- **files** — discharged; two new `planned` files under `.github/workflows/`, listed by no
  other chain, not an open part's own files
- **progress** — discharged; five questions closed, one requirement given final ids, two
  files named
- **amendments** — discharged; none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
