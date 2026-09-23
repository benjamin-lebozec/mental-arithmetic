---
idea: github-ci
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: Land the workflow and the `ci` spec; review raises two limits for the user

## This step

Lands the six items step-2 settled, all into a new `.github/workflows/SPEC.md` (namespace
`ci`), and writes `.github/workflows/build.yml`. The private repository `REQ-ci/github-repository`
needs was created before the demonstration. The user ran the planned command themselves,
because the permission check blocked it for Claude (see Amendments). A pushed commit carrying
the workflow got a green run, and its debug APK was downloaded. The two assumptions landed as
`CAP-ci/github-build`'s `assumes:` line. Nothing was settled under standing authorization.
Review found two limits no claim stated. They go back into the plan as `planned` items
under the new `q-ci-limits`, and do not land here.
`status: refining → unproved`, `remaining: 0q + 0r + 6i + 2f → 1q + 0r + 2i + 1f`.

## Changes

- **`CAP-ci/github-build`** — landed
  - **now:** into `.github/workflows/SPEC.md`, as written; `[provides:]` in
    `.github/workflows/build.yml` (header, and the upload step), which `[uses:
    CAP-root/docker-build]` on the build step
  - **verdict:** discharged
- **`INV-ci/one-build-path`** — landed
  - **now:** into `.github/workflows/SPEC.md`, as written; held by review over
    `.github/workflows/build.yml`
  - **verdict:** discharged
- **`INV-ci/fails-on-failure`** — landed
  - **now:** into `.github/workflows/SPEC.md`, as written; held by review
  - **verdict:** discharged
- **`INV-ci/triggers`** — landed
  - **now:** into `.github/workflows/SPEC.md`, reworded in its **held by:** line only. The
    plan's "review: the `on:` of `.github/workflows/build.yml` lists `push` and
    `pull_request` with no branch filter, and `workflow_dispatch`" became "review, over the
    `on:` of `.github/workflows/build.yml`". The review found that the old line only copied
    the file, and the rule itself already states what the `on:` must list.
  - **verdict:** discharged
- **`REQ-ci/github-repository`** — landed
  - **now:** into `.github/workflows/SPEC.md`: its claim and its **held by:** line as
    written. The **made by:** line, "the landing run, with `gh repo create --private
    --source . --push`, before it demonstrates `CAP-ci/github-build`, without waiting on
    anyone (`q-repository` (b))", said who does it in this run and when, and it was done in
    this run before the demonstration. It is not a claim about the tree, so it does not go
    into the spec. The repository was created by the user rather than by the run (see
    Amendments). It carries no `assumes:` line, although `a-github-actions` bore on it.
    Its own claim states that assumption outright, as a requirement: "GitHub Actions runs
    the workflow on GitHub's hosted Ubuntu runner". A second copy of the CAP's `assumes:`
    line would only restate it, which review found in round 2.
  - **verdict:** discharged
- **`LIM-ci/build-by-run`** — landed
  - **now:** into `.github/workflows/SPEC.md`, as written
  - **verdict:** discharged
- **`a-github-actions`** — landed
  - **was:** "\"a ci (github)\" means GitHub Actions: a workflow file under
    `.github/workflows/`, run on GitHub's hosted runners."
  - **now:** the first half of `CAP-ci/github-build`'s `assumes:` line;
    `REQ-ci/github-repository` states it outright (see its entry)
  - **verdict:** discharged
- **`a-debug-apk`** — landed
  - **was:** "\"the apk\" is the debug APK, the one `CAP-root/docker-build` builds. A
    release APK would need a signing key, which the brief does not mention."
  - **now:** the second half of `CAP-ci/github-build`'s `assumes:` line
  - **verdict:** discharged
- **To land section** — the six items above left it; it now holds the two new limits below
- **Assumptions section** — now "No assumptions left: both landed as the `assumes:` line of
  `CAP-ci/github-build`."
- **`.github/workflows/SPEC.md`** — kept, written
  - **was:** "holds: `CAP-ci/github-build`, `INV-ci/one-build-path`,
    `INV-ci/fails-on-failure`, `INV-ci/triggers`, `REQ-ci/github-repository`,
    `LIM-ci/build-by-run`; declares the namespace `ci` — planned"
  - **now:** "holds: `LIM-ci/artifact-retention`, `LIM-ci/actions-minutes` — written in
    step-3, open for: `LIM-ci/artifact-retention`, `LIM-ci/actions-minutes`". The six ids
    it held landed.
  - **verdict:** discharged
- **`.github/workflows/build.yml`** — closed
  - **was:** "holds: `CAP-ci/github-build` (`[provides:]`, and `[uses: CAP-root/docker-build]`
    on the build step); read by review for `INV-ci/one-build-path`,
    `INV-ci/fails-on-failure`, `INV-ci/triggers` — planned"
  - **now:** written in step-3, and closed
  - **verdict:** discharged

New in this step:

- **`LIM-ci/artifact-retention`** — planned in `.github/workflows/SPEC.md`, as quoted in the
  plan
  - **justified by:** `CAP-ci/github-build`'s "offers the APK for download". Review found
    that the run's artifact expires (`expires=2026-12-22`), and that no claim said so.
  - **verdict:** discharged
- **`LIM-ci/actions-minutes`** — planned in `.github/workflows/SPEC.md`, as quoted in the
  plan
  - **justified by:** `REQ-ci/github-repository`'s "private", together with
    `CAP-ci/github-build`'s "every change pushed" and `INV-ci/triggers`' "every push".
    Review found this unstated limit.
  - **verdict:** discharged
- **`q-ci-limits`** — how the two limits are handled
  - **justified by:** this step's landing. Review found the limits. Admitting one qualifies
    "every push" and "offers the APK", which is the user's call, not the drafter's, so
    neither lands in this step.
  - **verdict:** discharged

## Amendments

- **Who created the repository.** `REQ-ci/github-repository`'s **made by:** line said the
  landing run makes it. The Claude Code permission check refused the run's `gh repo create`
  (a new remote). Asked how to go on, the user chose "I'll run it (Recommended)" and then
  said "next time i'll give you permission to do it yourself. For this one, i did it"
  (2026-09-23, in the conversation). The repository and the commands are the same, and it
  was made before the demonstration, so nothing about the tree changes.

## Demonstrations

- **`CAP-ci/github-build`** — "The commit is pushed to GitHub, the workflow run for it ends
  green, having built the debug APK and run the JVM unit tests of every module, and the
  debug APK can be downloaded from the run."
  - The step's commit can only exist after review. So commit `85f3b34` was pushed instead.
    It is this step's parent plus `.github/`. Its `build.yml` is byte-identical to the one
    written here. Its `SPEC.md` differs in one line, `INV-ci/triggers`' held by line,
    shortened afterwards; the run does not read that file. It was pushed on a
    scratch branch `ci-demo`, and triggered the workflow by `push`.
  - Run 35833511121
    (https://github.com/benjamin-lebozec/mental-arithmetic/actions/runs/35833511121):
    `status: completed`, `conclusion: success`, `headSha` `85f3b34…`, in 4m1s. Every
    step passed: checkout, `./build.sh`, upload-artifact.
  - The log shows `Task :app:assembleDebug` and `Task :multiplication:test`
    (`app:testDebugUnitTest NO-SOURCE`: the app has no JVM tests), then `BUILD SUCCESSFUL`.
    The artifact `app-debug` was uploaded (ID 10737524558, 8323095 bytes).
  - `gh run download 35833511121 -n app-debug` downloaded `app-debug.apk` (8723035 bytes)
    into the scratchpad.
  - Log saved as `run.log` in the scratchpad.
- **`REQ-ci/github-repository`** — `git remote -v` names
  `https://github.com/benjamin-lebozec/mental-arithmetic.git` as `origin`, and
  `gh repo view` shows `"visibility":"PRIVATE"`.
- **Module tests** — no Gradle module changed. The CI run above ran every module's JVM
  unit tests, and they passed.

## Reviews

Scope: full. No commits outside a step since the last full review, so the narrowed walk
applied: every touched id, and every `NOT-`, review-held `INV-`, `REQ-` and `LIM-` in the
tree. The citation rules held over all 23 shipped files.

- **Round 1**
  - **Unadmitted limits:** broken. The APK expires after 90 days, and a private repository's
    Actions minutes are metered. The two `LIM-`s were drafted into the spec. The prover then
    failed them under `settled` and `no-narrowing`, so they moved into the plan under
    `q-ci-limits`. This finding stands against this step's tree until they land.
  - **`INV-ci/triggers`'s held by line:** restates `build.yml`'s `on:`. Fixed by
    shortening it.
- **Round 2**
  - **`REQ-ci/github-repository`'s added `assumes:` line:** restates the CAP's. Removed,
    and the reason is recorded in the REQ's Changes entry.
  - The `INV-ci/triggers` fix: resolved. The two drafted `LIM-`s also resolved, but they
    were then withdrawn to the plan (see Round 1).
- **Still undecidable:** `REQ-app/emulator-adb`, because it needs the Windows emulator. This
  change does not touch it.
- **Holds:** every other claim, including the three review-held `INV-ci/*`,
  `REQ-ci/github-repository` and `LIM-ci/build-by-run`.
- **Not a finding:** actions are pinned by `@v7` tag, not by commit SHA.

## Proof

- **re-proof of step-2** — skipped: nothing changed since step-2's commit (`git status`
  was clean)
- **rounds**
  - round 1: `landed` failed, because `a-github-actions` was not on
    `REQ-ci/github-repository`. An `assumes:` line was added. The review found unadmitted
    limits and a restating held by line. Two `LIM-`s were drafted, and the line was
    shortened.
  - round 2: `settled` and `no-narrowing` failed on the two `LIM-`s, which were decided and
    landed in one step and qualify "every push". They moved to the plan under
    `q-ci-limits`. The review found that the REQ's `assumes:` line restated the CAP's. It
    was removed, and the reason recorded.
  - round 3: `demonstrated` failed on the record ("exactly as written here"), which is now
    fixed. `landed` stays undecidable: the review has not passed, because its
    unadmitted-limits finding stands until `q-ci-limits` is answered and the limits land.
- **matched** — discharged; both diffs agree with Changes
- **coverage** — discharged; all eight items and both files have their true fate
- **no-widening** — discharged; the landed spec text is word for word, except for the
  loss-free held by rewording
- **no-narrowing** — discharged; the limits are only planned, behind an unanswered question
- **answers-applied** — discharged, vacuously
- **justified** — discharged; the two `LIM-`s and `q-ci-limits` name what raised them
- **consistent** — discharged
- **settled** — discharged; only step-2's settled items landed
- **landed** — undecidable (reads as failed); everything holds except that the review has
  not passed
- **demonstrated** — discharged after the round-3 record fix; run 35833511121 green on
  85f3b34, whose `build.yml` is this one
- **tree-kept** — discharged
- **files** — discharged
- **progress** — discharged; six items landed
- **amendments** — discharged; "Who created the repository" is quoted with the user's words
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
