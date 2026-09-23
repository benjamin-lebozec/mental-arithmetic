---
namespace: ci
---

# Continuous integration

The GitHub Actions workflow that builds every change pushed to GitHub, the same way the host
builds it, so the APK never has to be built on someone's own machine.

## Capabilities

- **`CAP-ci/github-build`** — Every change pushed to GitHub is built there by a GitHub
  Actions run, without anyone building on their own machine: the run builds the debug APK,
  runs the JVM unit tests of every module, and offers the APK for download.
  - **success:** The commit is pushed to GitHub, the workflow run for it ends green, having
    built the debug APK and run the JVM unit tests of every module, and the debug APK can be
    downloaded from the run.
  - **assumes:** "a CI on GitHub" means GitHub Actions, a workflow under
    `.github/workflows/` run on GitHub's hosted runners; "the APK" is the debug APK, the one
    `CAP-root/docker-build` builds, since a release APK would need a signing key.

## Invariants

- **`INV-ci/one-build-path`** — The workflow builds only by running `./build.sh`, so the CI
  builds exactly what the host builds: it sets up no JDK, Gradle or Android SDK on the
  runner, and runs no Gradle command of its own.
  - **held by:** review, over `.github/workflows/build.yml`
  - **why:** there stays one way to build, and it cannot drift from the Dockerfile
- **`INV-ci/fails-on-failure`** — A run fails when the image, the APK or any module's JVM
  unit test fails to build or pass.
  - **held by:** review: the build step of `.github/workflows/build.yml` is `./build.sh`,
    which exits with Docker's status, which is Gradle's
- **`INV-ci/triggers`** — The workflow runs on every push to any branch, on every pull
  request, and when started by hand.
  - **held by:** review, over the `on:` of `.github/workflows/build.yml`
  - **why:** every change is built before it is merged, and a fresh APK can be had by hand

## Requires

- **`REQ-ci/github-repository`** — The repository is pushed to a private GitHub repository,
  its `origin`, where GitHub Actions runs the workflow on GitHub's hosted Ubuntu runner,
  which has Docker and reaches the internet, as `REQ-root/docker` and `REQ-root/network`
  ask of the host.
  - **held by:** demonstration: `git remote -v` names it, and `gh repo view` shows it
    private

## Known limits

- **`LIM-ci/build-by-run`** — `CAP-ci/github-build` is shown only by pushing a commit and
  reading its run and the APK it offers; no test runs the workflow.
