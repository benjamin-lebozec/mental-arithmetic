---
idea: github-ci
chain: trunk
step: 2
status: refining
waits on: none
remaining: 0q + 0r + 6i + 2f
---

# A CI on GitHub that builds the APK

## Why

- **`why`** — The APK is built only when someone runs `./build.sh` on a host with Docker
  (`CAP-root/docker-build`); nothing builds it on GitHub. The brief asks for a CI on GitHub
  that builds it.

## Requirements

Nothing left to refine: `r-ci-builds-apk` became `CAP-ci/github-build`.

## To land

- **`CAP-ci/github-build`** — Every change pushed to GitHub is built there by a GitHub
  Actions run, without anyone building on their own machine: the run builds the debug APK,
  runs the JVM unit tests of every module, and offers the APK for download.
  - **success:** The commit is pushed to GitHub, the workflow run for it ends green, having
    built the debug APK and run the JVM unit tests of every module, and the debug APK can be
    downloaded from the run.
  - **lands in:** `.github/workflows/SPEC.md`
  - **held in:** `.github/workflows/build.yml` (the job: check out, run `./build.sh`, upload
    the debug APK as the run's artifact)
  - **status:** planned
- **`INV-ci/one-build-path`** — The workflow builds only by running `./build.sh`, so the CI
  builds exactly what the host builds: it sets up no JDK, Gradle or Android SDK on the
  runner, and runs no Gradle command of its own.
  - **held by:** review, over `.github/workflows/build.yml`
  - **why:** there stays one way to build, and it cannot drift from the Dockerfile
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`INV-ci/fails-on-failure`** — A run fails when the image, the APK or any module's JVM
  unit test fails to build or pass.
  - **held by:** review: the build step of `.github/workflows/build.yml` is `./build.sh`,
    which exits with Docker's status, which is Gradle's
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`INV-ci/triggers`** — The workflow runs on every push to any branch, on every pull
  request, and when started by hand.
  - **held by:** review: the `on:` of `.github/workflows/build.yml` lists `push` and
    `pull_request` with no branch filter, and `workflow_dispatch`
  - **why:** every change is built before it is merged, and a fresh APK can be had by hand
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`REQ-ci/github-repository`** — The repository is pushed to a private GitHub repository,
  its `origin`, where GitHub Actions runs the workflow on GitHub's hosted Ubuntu runner,
  which has Docker and reaches the internet, as `REQ-root/docker` and `REQ-root/network`
  ask of the host.
  - **held by:** demonstration: `git remote -v` names it, and `gh repo view` shows it
    private
  - **made by:** the landing run, with `gh repo create --private --source . --push`, before
    it demonstrates `CAP-ci/github-build`, without waiting on anyone (`q-repository` (b))
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`LIM-ci/build-by-run`** — `CAP-ci/github-build` is shown only by pushing a commit and
  reading its run and the APK it offers; no test runs the workflow.
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned

## Reopened

Nothing reopened.

## Success signal

- **`s-green-run-with-apk`** — A commit pushed to GitHub gets a workflow run that ends
  green, and the debug APK can be downloaded from that run.

## Assumptions

- **`a-github-actions`** — "a ci (github)" means GitHub Actions: a workflow file under
  `.github/workflows/`, run on GitHub's hosted runners.
  - **raised by:** "add a ci (github)"
  - **bears on:** `CAP-ci/github-build`, `REQ-ci/github-repository`
- **`a-debug-apk`** — "the apk" is the debug APK, the one `CAP-root/docker-build` builds.
  A release APK would need a signing key, which the brief does not mention.
  - **raised by:** "to build the apk"
  - **bears on:** `CAP-ci/github-build`

## Files

- `.github/workflows/SPEC.md` — holds: `CAP-ci/github-build`, `INV-ci/one-build-path`,
  `INV-ci/fails-on-failure`, `INV-ci/triggers`, `REQ-ci/github-repository`,
  `LIM-ci/build-by-run`; declares the namespace `ci` — planned
- `.github/workflows/build.yml` — holds: `CAP-ci/github-build` (`[provides:]`, and
  `[uses: CAP-root/docker-build]` on the build step); read by review for
  `INV-ci/one-build-path`, `INV-ci/fails-on-failure`, `INV-ci/triggers` — planned

## Open Questions

No open questions.
