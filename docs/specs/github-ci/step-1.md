---
idea: github-ci
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into one requirement, two assumptions and five questions

## This step

Formalizes the brief, read against the root spec (`CAP-root/docker-build`, its Contract,
`REQ-root/docker`, `REQ-root/network`, `LIM-root/build-by-run`) and the app spec
(`REQ-app/emulator-adb`, `LIM-app/screens-by-manual-review`). It lands nothing. It writes the
plan for the first time: the Why, one requirement, two assumptions and five open questions,
`q-validation` among them. No file is placed. `status: — → refining`,
`remaining: — → 5q + 1r + 0i + 0f`.

## Changes

- **"add a ci (github)"** — refined
  - **was:** the brief's statement
  - **now:** `why`, `r-ci-builds-apk`, `a-github-actions`
  - **raises:** `q-trigger`, `q-repository`
  - **verdict:** discharged
- **"to build the apk"** — refined
  - **was:** the brief's statement
  - **now:** `why`, `r-ci-builds-apk`, `a-debug-apk`
  - **raises:** `q-validation`, `q-build-path`, `q-tests`
  - **verdict:** discharged

New in this step:

- **`why`**
  - **justified by:** the whole brief, read against `CAP-root/docker-build`, which builds
    the APK only when `./build.sh` is run on a host with Docker
  - **verdict:** discharged
- **`r-ci-builds-apk`**
  - **justified by:** "add a ci (github) to build the apk"
  - **verdict:** discharged
- **`a-github-actions`**
  - **justified by:** "add a ci (github)": GitHub's CI is not named further
  - **verdict:** discharged
- **`a-debug-apk`**
  - **justified by:** "to build the apk": which APK is not said; the tree builds the debug
    one
  - **verdict:** discharged
- **`q-validation`**
  - **justified by:** asked in every step 1; raised by "to build the apk"
  - **verdict:** discharged
- **`q-build-path`**
  - **justified by:** "to build the apk", read against `CAP-root/docker-build`
  - **verdict:** discharged
- **`q-tests`**
  - **justified by:** "to build the apk": the brief names the APK only, and the tree's build
    also runs the unit tests
  - **verdict:** discharged
- **`q-trigger`**
  - **justified by:** "add a ci (github)": when it runs is not said
  - **verdict:** discharged
- **`q-repository`**
  - **justified by:** "add a ci (github)", read against the tree: the repository has no
    remote
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — n/a: step-0 is the brief
- **rounds** —
  - round 1: `consistent` failed: the Why credited `CAP-root/docker-build` with "only on
    this host", a limit the claim does not make. The Why was reworded. `q-tests` option
    (b) now says it conflicts with `q-build-path` (a) as `./build.sh` stands.
  - round 2: `consistent` failed on this step's own `justified by:` line for `why`, which
    repeated "on this host only". It was reworded the same way.
  - round 3: every obligation that applies discharged
- **matched** — discharged; the plan is new whole; its 9 items are all in Changes; no spec diff
- **coverage** — discharged; the brief's one statement, quoted in two fragments, each refined
- **no-widening** — discharged; every inference (Actions, hosted runners, debug APK) is an assumption or a question
- **no-narrowing** — discharged; `r-ci-builds-apk` keeps "the APK" unqualified; the debug narrowing is only the assumption `a-debug-apk`
- **answers-applied** — discharged; no answers yet; `q-validation` is asked, the brief's hint as its recommended option
- **justified** — discharged; every assumption and question names its brief fragment
- **consistent** — discharged; no claim of the root or app spec is contradicted, after rounds 1 and 2
- **files** — discharged; the list is empty; the brief places no file; no other chain is in flight
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a in step 1
- **progress** — n/a in step 1
- **amendments** — n/a: none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
