---
idea: github-ci
chain: trunk
step: 1
status: refining
waits on: none
remaining: 5q + 1r + 0i + 0f
---

# A CI on GitHub that builds the APK

## Why

- **`why`** — The APK is built only when someone runs `./build.sh` on a host with Docker
  (`CAP-root/docker-build`); nothing builds it on GitHub. The brief asks for a CI on GitHub
  that builds it.

## Requirements

- **`r-ci-builds-apk`** — A CI on GitHub builds the APK from the repository, without anyone
  running a build on their own machine.

## To land

Nothing to land yet.

## Reopened

Nothing reopened.

## Success signal

No success signal yet: it waits on `q-validation`.

## Assumptions

- **`a-github-actions`** — "a ci (github)" means GitHub Actions: a workflow file under
  `.github/workflows/`, run on GitHub's hosted runners.
  - **raised by:** "add a ci (github)"
  - **bears on:** `r-ci-builds-apk`
- **`a-debug-apk`** — "the apk" is the debug APK, the one `CAP-root/docker-build` builds.
  A release APK would need a signing key, which the brief does not mention.
  - **raised by:** "to build the apk"
  - **bears on:** `r-ci-builds-apk`

## Files

No file placed yet.

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) The commit is pushed to GitHub, the workflow run ends green, and the debug APK
      can be downloaded from the run
    - (b) The workflow run ends green; nothing is downloaded
    - (c) As (a), and the downloaded APK is also installed and launched on the emulator
      through `adb`
  - **recommended:** (a), because "to build the apk" is only shown by an APK coming out of
    the run; (c) repeats what the app's screens are already reviewed on
  - **unblocks:** every success criterion, `s-` signal and `CAP-` of this chain
  - **raised by:** "to build the apk"
  - **answer:**
- **`q-build-path`** — How does the workflow build?
  - **options:**
    - (a) It runs `./build.sh`, the same Docker image and command as on this host
    - (b) It installs a JDK, Gradle and the Android SDK on the runner with setup actions,
      and runs Gradle directly
  - **recommended:** (a), because there stays one way to build, and the CI proves the very
    build the host runs; (b) is faster with caching but is a second build path that can
    drift from the Dockerfile
  - **unblocks:** the workflow's steps, and whether `CAP-root/docker-build`'s claims are
    touched
  - **raised by:** "to build the apk", read against `CAP-root/docker-build`
  - **answer:**
- **`q-tests`** — Does the CI also run the JVM unit tests of every module, failing the run
  when one fails?
  - **options:**
    - (a) Yes: build the APK and run every module's unit tests
    - (b) No: build the APK only; with `q-build-path` (a) this needs a change to how
      `./build.sh` is called, since it always runs the tests
  - **recommended:** (a), because the tests are cheap next to the build, and a CI is the
    natural place to run the whole suite; with `q-build-path` (a), `./build.sh` already
    runs them
  - **unblocks:** the workflow's command, and the capability's success criterion
  - **raised by:** "to build the apk": the brief names the APK only
  - **answer:**
- **`q-trigger`** — When does the workflow run?
  - **options:**
    - (a) On every push to any branch, on every pull request, and by hand
    - (b) On pushes to the default branch only
    - (c) By hand only
  - **recommended:** (a), because every change then gets built before it is merged, and a
    run can be started by hand to get a fresh APK
  - **unblocks:** the workflow's triggers
  - **raised by:** "add a ci (github)"
  - **answer:**
- **`q-repository`** — The repository has no GitHub remote yet, and the CI can only run once
  it is pushed there. Who creates it?
  - **options:**
    - (a) You create the GitHub repository, add it as `origin` and push; the run that
      demonstrates the CI waits for it
    - (b) I create a private repository with `gh repo create --private --source . --push`
      (you are logged in to `gh`), when the run that demonstrates the CI comes
    - (c) As (b), but public
  - **recommended:** (b), because the run can then demonstrate the CI end to end without
    waiting; private keeps the code unpublished until you decide otherwise
  - **unblocks:** the demonstration of the CI, and a `REQ-` naming the repository
  - **raised by:** "add a ci (github)", read against the tree: `git remote` is empty
  - **answer:**
