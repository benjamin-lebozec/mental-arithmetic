---
idea: share-apk
chain: trunk
step: 2
refines: step-1.md
---

# Step 2: apply the five answers; place the four requirements as eight items in the ci and root specs

## This step

Applies the five answers: validation by hand on a real phone, a new release per push, the
debug APK with a fixed key, the user making the repository public before the release lands,
and the checked screen kept at `.github/screenshot.png`. The four requirements become eight
items with final ids: four land in `.github/workflows/SPEC.md` and four in the root
`SPEC.md`. The two reopened ci claims are settled. Three new assumptions cover the manual
run, the APK's file name and where the key goes. One question is new, `q-signing-key`,
raised by the `q-apk-variant` answer. It blocks both capabilities that need the key.
Nothing lands, because no answer was given under standing authorization.
`status: refining → refining`, `remaining: 5q + 4r + 2i + 3f → 1q + 0r + 10i + 6f`.

## Changes

- **`q-validation`** — answered
  - **was:** the question, with options (a), (b) and (c) and recommended (a)
  - **now:** answer "(b): "By hand on a real phone" (2026-09-23, in the conversation)";
    that is option (b), "as (a), but the install is done by hand on a real phone, from the
    README's link". It gives `s-friend-install`, the `success:` lines of
    `CAP-ci/release-on-push`, `CAP-root/debug-key` and `CAP-root/readme`, and, because
    only a person installs, `LIM-ci/release-by-hand` and `LIM-root/shown-by-hand`
  - **verdict:** discharged
- **`q-release-naming`** — answered
  - **was:** the question, with options (a), (b) and (c) and recommended (a)
  - **now:** answer "(a): "New release per push (Recommended)" (2026-09-23, in the
    conversation)"; that is option (a), "a new release per push, tagged `build-<run
    number>`, marked latest; older ones stay listed". It gives the tagging and
    latest-link parts of `CAP-ci/release-on-push`'s success line. Assumptions
    `a-apk-name` and `a-manual-no-release` are raised by it
  - **verdict:** discharged
- **`q-apk-variant`** — answered
  - **was:** the question, with options (a) and (b) and recommended (a)
  - **now:** answer "(a): "Debug APK, fixed key (Recommended)" (2026-09-23, in the
    conversation)"; that is option (a), "the debug APK the build already makes, signed with
    a fixed debug keystore from the secret". It gives `CAP-root/debug-key`,
    `REQ-ci/debug-key-secret` and `a-key-as-default-keystore`
  - **raises:** `q-signing-key`
  - **verdict:** discharged
- **`q-make-public`** — answered
  - **was:** the question, with options (a) and (b) and recommended (a)
  - **now:** answer "(a): "You, before release lands (Recommended)" (2026-09-23, in the
    conversation)"; that is option (a). It settles the reopened `REQ-ci/github-repository`
    and `LIM-ci/actions-minutes`, whose `status:` lines now say so
  - **verdict:** discharged
- **`q-screenshot`** — answered
  - **was:** the question, with options (a), (b) and (c) and recommended (a)
  - **now:** answer "(a): "Checked screen, .github/ (Recommended)" (2026-09-23, in the
    conversation)"; that is option (a), "a multiplication after the check, errors marked,
    taken on the emulator through `adb`, kept at `.github/screenshot.png`". It gives
    `CAP-root/readme`'s `held in:` and the file `.github/screenshot.png`
  - **verdict:** discharged
- **`r-release-on-push`** — refined
  - **was:** "On every push to `master`, the CI publishes a GitHub release with the APK
    attached as a plain `.apk` file, not zipped, and one fixed link always downloads the
    latest APK."
  - **now:** `CAP-ci/release-on-push`, `INV-ci/release-only-master-push`,
    `LIM-ci/release-by-hand`
  - **verdict:** discharged
- **`r-same-key`** — refined
  - **was:** "Every build is signed with the same key, so a new version installs over the
    old one without uninstalling; no store-grade signing is needed."
  - **now:** `CAP-root/debug-key` (the build signs with the given keystore), the signing
    clause of `CAP-ci/release-on-push` (the CI gives it the secret's key), and
    `LIM-root/shown-by-hand`. "No store-grade signing" is the debug APK, from
    `q-apk-variant` (a)
  - **verdict:** discharged
- **`r-key-secret`** — refined
  - **was:** "The signing key is kept out of the public repository, in a GitHub secret."
  - **now:** `REQ-ci/debug-key-secret` (the secret exists) and
    `NOT-root/signing-key-in-repo` (no keystore is committed)
  - **verdict:** discharged
- **`r-readme`** — refined
  - **was:** "A README says in a few words what the app is, shows a screenshot, links to the
    latest APK, and says how to install an APK from outside the Play Store."
  - **now:** `CAP-root/readme`, `LIM-root/shown-by-hand`
  - **verdict:** discharged
- **Requirements section** — the line "Nothing left: each is now an item to land."
  replaces the four refined requirements
  - **verdict:** discharged
- **To land section** — the line "Nothing left to land." is replaced by the eight items
  below
  - **verdict:** discharged
- **`REQ-ci/github-repository`** — kept, its `status:` line changed
  - **was:** "planned"
  - **now:** "planned; settled by `q-make-public`: you make the repository public before the
    release lands, and it lands in that run once `gh repo view` shows it public"
  - **verdict:** discharged
- **`LIM-ci/actions-minutes`** — kept, its `status:` line changed
  - **was:** "planned"
  - **now:** "planned; settled by `q-make-public`, lands with `REQ-ci/github-repository`"
  - **verdict:** discharged
- **Success signal** — the line "Not yet: waits on `q-validation`." is replaced by
  `s-friend-install`
  - **verdict:** discharged
- **`a-key-through-build-sh`** — kept, its `bears on:` line changed
  - **was:** "`r-same-key`, `r-key-secret`"
  - **now:** "`CAP-root/debug-key`, `CAP-ci/release-on-push`", which are what those
    requirements' key-passing parts became
  - **verdict:** discharged
- **`a-host-build-unchanged`** — kept, its `bears on:` line changed
  - **was:** "`r-same-key`"
  - **now:** "`CAP-root/debug-key`"
  - **verdict:** discharged
- **`a-same-key-scope`** — kept, its `bears on:` line changed
  - **was:** "`r-same-key`"
  - **now:** "`CAP-root/debug-key`, `CAP-ci/release-on-push`"
  - **verdict:** discharged
- **`a-release-only-master`** — kept, its `bears on:` line changed
  - **was:** "`r-release-on-push`"
  - **now:** "`INV-ci/release-only-master-push`"
  - **verdict:** discharged
- **`a-readme-english`** — kept, its `bears on:` line changed
  - **was:** "`r-readme`"
  - **now:** "`CAP-root/readme`"
  - **verdict:** discharged
- **`.github/workflows/build.yml`** — kept
  - **was:** "holds: `r-release-on-push`, `r-same-key` — planned"
  - **now:** "holds: `CAP-ci/release-on-push`, `INV-ci/release-only-master-push` —
    planned". Its part of `r-same-key`, handing the secret to `./build.sh`, is in
    `CAP-ci/release-on-push`
  - **verdict:** discharged
- **`.github/workflows/SPEC.md`** — kept
  - **was:** "holds: `REQ-ci/github-repository`, `LIM-ci/actions-minutes`, the claims
    `r-release-on-push` and `r-same-key` become — planned"
  - **now:** "holds: `REQ-ci/github-repository`, `LIM-ci/actions-minutes`,
    `CAP-ci/release-on-push`, `INV-ci/release-only-master-push`, `REQ-ci/debug-key-secret`,
    `LIM-ci/release-by-hand` — planned". The claims `r-same-key` became that are not CI
    claims land in the root `SPEC.md`
  - **verdict:** discharged
- **`README.md`** — kept
  - **was:** "holds: `r-readme` — planned"
  - **now:** "holds: `CAP-root/readme` — planned"
  - **verdict:** discharged

New in this step:

- **`CAP-ci/release-on-push`**
  - **justified by:** `r-release-on-push`, with the `q-release-naming` (a) and
    `q-validation` (b) answers, and the CI's part of `r-same-key` and `a-key-through-build-sh`
  - **verdict:** discharged
- **`INV-ci/release-only-master-push`**
  - **justified by:** `r-release-on-push` ("on every push to `master`"), with
    `a-release-only-master` and `a-manual-no-release`
  - **verdict:** discharged
- **`REQ-ci/debug-key-secret`**
  - **justified by:** `r-key-secret` ("in a GitHub secret"), with `q-apk-variant` (a) and
    `a-key-as-default-keystore`
  - **verdict:** discharged
- **`LIM-ci/release-by-hand`**
  - **justified by:** `q-validation` (b): only a person installs on a phone, so no test
    shows `CAP-ci/release-on-push`
  - **verdict:** discharged
- **`CAP-root/debug-key`**
  - **justified by:** `r-same-key`, with `q-apk-variant` (a), `a-key-through-build-sh`,
    `a-host-build-unchanged` and `a-same-key-scope`. It lands in the root `SPEC.md` because
    `build.sh`, which holds it, sits at the root
  - **verdict:** discharged
- **`NOT-root/signing-key-in-repo`**
  - **justified by:** `r-key-secret` ("kept out of the public repository")
  - **verdict:** discharged
- **`CAP-root/readme`**
  - **justified by:** `r-readme`, with `q-screenshot` (a) and `q-validation` (b)
  - **verdict:** discharged
- **`LIM-root/shown-by-hand`**
  - **justified by:** `q-validation` (b): only a person installs over and reads the README,
    so no test shows `CAP-root/debug-key` or `CAP-root/readme`
  - **verdict:** discharged
- **`s-friend-install`**
  - **justified by:** `q-validation` (b) and `why`
  - **verdict:** discharged
- **`a-manual-no-release`**
  - **justified by:** the `q-release-naming` answer, read against `INV-ci/triggers`, which
    also runs the workflow by hand
  - **verdict:** discharged
- **`a-apk-name`**
  - **justified by:** the `q-release-naming` answer: the latest-download link names a fixed
    file
  - **verdict:** discharged
- **`a-key-as-default-keystore`**
  - **justified by:** `q-apk-variant` (a) with `a-key-through-build-sh`. The host's build
    already writes Android's default debug keystore to `.gradle/android-home/debug.keystore`
  - **verdict:** discharged
- **`q-signing-key`**
  - **justified by:** the answer to `q-apk-variant`: the fixed keystore has to be created
    and stored in the secret by someone
  - **verdict:** discharged
- **`build.sh`**, **`SPEC.md`**, **`.github/screenshot.png`**
  - **justified by:** `CAP-root/debug-key`; the four root items; `CAP-root/readme` with
    `q-screenshot` (a)
  - **open part:** `build.sh` and `SPEC.md` are the root's own files, and the root is open
    to modules. This chain is not an addition under the root's contract: it adds no module
    and creates no top-level directory. It adds claims of its own to the root, the four
    root items, which land in the root's `SPEC.md` because `build.sh` sits at the root.
    That is the path rule. No landed root claim changes: `CAP-root/docker-build` keeps its
    success line, because `a-host-build-unchanged` keeps the host's build as it is, and the
    Contract, `INV-root/module-recognized` and `INV-root/module-dependency` are untouched.
    Nothing is reopened, so the clause's aim, that no addition edits an open part behind
    its contract, is met
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-1** — skipped: only `answer:` lines changed; the diff since
  `dbaf9ab` shows the five `answer:` lines and nothing else
- **rounds** — two
  - round 1: `files` undecidable. `build.sh` and `SPEC.md` are the open root's own files,
    and the step did not say why listing them meets the clause. The "open part" line was
    added to their New entry
  - round 2: all discharged. `files` is read by the clause's aim: no addition edits an open
    part behind its contract, and this chain is not an addition and reopens nothing
- **matched** — discharged; every change in the plan's diff has a Changes entry, and no spec
  diff exists
- **coverage** — discharged; 5 questions answered, 4 requirements refined, 2 reopened items
  and 5 assumptions kept with only `status:` or `bears on:` changed; `why` and
  `a-public-minutes-free` untouched and still true
- **no-widening** — discharged; every requirement's clauses are in its items, the scope of
  "every build" is `a-same-key-scope`'s, and no criterion is easier than option (b)
- **no-narrowing** — discharged; every run still offers its APK (`CAP-ci/github-build`), and
  the manual-run exclusion is the strikeable `a-manual-no-release`
- **answers-applied** — discharged; each answer quoted with its option, and the items say
  that option and no more; `q-signing-key` stays open
- **justified** — discharged; every new item names its source
- **consistent** — discharged; `INV-ci/one-build-path`, `INV-ci/triggers` and
  `CAP-ci/github-build`'s debug-APK assumption hold; only the reopened
  `REQ-ci/github-repository` is contradicted
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed, and
  `git diff --name-only dbaf9ab` shows only the plan
- **files** — discharged in round 2; every file has a fate, the new ones are justified, none
  says `to write`, and no chain in flight lists them. `CAP-root/docker-build` staying intact
  is checked when `build.sh` changes
- **progress** — discharged; five questions closed and four requirements given final ids;
  `q-signing-key` follows from the `q-apk-variant` answer
- **amendments** — discharged; none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split
