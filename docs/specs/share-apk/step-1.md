---
idea: share-apk
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into four requirements, two reopened ci claims, six assumptions and five questions

## This step

Formalizes the brief against the tree (the root, `app` and `ci` specs). The repository
going public reopens `REQ-ci/github-repository` and `LIM-ci/actions-minutes`. Release,
signing, key and README become four requirements. Six assumptions state what the brief
implies against `INV-ci/one-build-path`, `CAP-root/docker-build`, `INV-ci/triggers` and
`LIM-ci/actions-minutes`.
Five questions ask for validation, release naming, the APK variant, who makes the
repository public, and the screenshot. Nothing lands.
`status: — → refining`, `remaining: — → 5q + 4r + 2i + 3f`.

## Changes

- **"share the app with friends through github, not through an app store"** — refined
  - **now:** `why`
  - **verdict:** discharged
- **"the repository becomes public"** — refined
  - **now:** reopened `REQ-ci/github-repository` (private → public) and
    `LIM-ci/actions-minutes` (retired, under `a-public-minutes-free`),
    `a-public-minutes-free`; raises `q-make-public`
  - **verdict:** discharged
- **"on every push to master, the ci publishes a github release with the apk attached as a
  plain .apk file (no zip), and a fixed link always downloads the latest one"** — refined
  - **now:** `r-release-on-push`, `a-release-only-master`
  - **raises:** `q-release-naming`
  - **verdict:** discharged
- **"the apk needs no store-grade signing, but every build must be signed with the same
  key, so a new version installs over the old one without uninstalling. keep that key out
  of the public repository (github secret)"** — refined
  - **now:** `r-same-key` (worded as the brief), `r-key-secret`, `a-key-through-build-sh`,
    `a-host-build-unchanged`, `a-same-key-scope`
  - **raises:** `q-apk-variant`
  - **verdict:** discharged
- **"add a README: a few words on what the app is, a screenshot, the link to the latest
  apk, and how to install an apk from outside the play store"** — refined
  - **now:** `r-readme`, `a-readme-english`
  - **raises:** `q-screenshot`
  - **verdict:** discharged

New in this step:

- **`q-validation`**
  - **justified by:** step 1 always asks it; the brief's "a new version installs over the
    old one" and "a fixed link always downloads the latest one" are its recommended option
  - **verdict:** discharged
- **`.github/workflows/build.yml`, `.github/workflows/SPEC.md`, `README.md`** (Files)
  - **justified by:** the brief places them: "the ci publishes" (the one workflow and its
    spec, which declares both reopened claims) and "add a README"
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — n/a: step 1
- **rounds** —
  - round 1: coverage and no-widening failed: `r-same-key` narrowed "every build" to the
    published APKs, and the `LIM-ci/actions-minutes` retirement rested on an unrecorded
    billing fact. `r-same-key` now words the brief, and `a-same-key-scope` and
    `a-public-minutes-free` record both readings
  - round 2: every obligation discharged
- **matched** — discharged; the plan is new whole, and every item and file in it is listed in Changes
- **coverage** — discharged; all five brief statements have a true fate, `r-same-key` words the brief
- **no-widening** — discharged; every inference is an assumption or a question
- **no-narrowing** — discharged; public repo, release, fixed link, install over, README all carried
- **answers-applied** — discharged; no answers yet, `q-validation` asked with the brief's hint recommended
- **justified** — discharged; every assumption and question names the statement that raised it
- **consistent** — discharged; root, `app` and `ci` specs read; the two claims saying "private" are
  reopened, and the assumptions keep `INV-ci/one-build-path`, `INV-ci/triggers` and
  `CAP-root/docker-build`
- **files** — discharged; only files the brief places; no other chain in flight
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a: step 1 lands nothing
- **progress** — n/a: step 1
- **amendments** — n/a: none
- **terminal** — n/a: not `done`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split
