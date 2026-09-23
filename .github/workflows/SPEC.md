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
- **`CAP-ci/release-on-push`** — On every push to `master`, the CI publishes a new GitHub
  release with the APK attached as a plain `.apk` file, not zipped, signed with the key in
  the repository's secret, and one fixed link always downloads the latest APK.
  - **success:** A commit is pushed to `master`: its run ends green and publishes a new
    release, tagged `build-<run number>` and marked latest, older ones still listed, with
    `mental-arithmetic.apk` attached as a plain `.apk`; the fixed link
    `https://github.com/benjamin-lebozec/mental-arithmetic/releases/latest/download/mental-arithmetic.apk`
    downloads it, and it installs by hand on a real phone. After a second push, the fixed
    link downloads the second release's `.apk`.
  - **assumes:** the CI hands the signing key to the build through `./build.sh`, so the
    workflow still builds only by running it; "every build" signed with the same key means
    every build the CI runs with the secret, and a build without it (on the host, or a pull
    request from a fork, which GitHub runs without secrets) is signed with Android's
    default debug key; the `.apk` is attached as `mental-arithmetic.apk`, not as the
    build's `app-debug.apk`, so the file names the app and the fixed link never changes.

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
- **`INV-ci/release-only-master-push`** — The workflow publishes a release only for a push
  to `master`; every other run builds and offers the APK from the run, as now, and
  publishes none.
  - **held by:** review, over the release step's `if:` in `.github/workflows/build.yml`
  - **assumes:** a push to any other branch, and a pull request, still only builds and
    offers the APK from the run; a run started by hand, even on `master`, publishes no
    release, since a manual run is not a push.

## Requires

- **`REQ-ci/github-repository`** — The repository is pushed to a public GitHub repository,
  its `origin`, where GitHub Actions runs the workflow on GitHub's hosted Ubuntu runner,
  which has Docker and reaches the internet, as `REQ-root/docker` and `REQ-root/network`
  ask of the host.
  - **held by:** demonstration: `git remote -v` names it, and `gh repo view` shows it
    public
  - **assumes:** a public repository's runs on GitHub's standard hosted runners are not
    metered, so no quota of Actions minutes limits the builds.
- **`REQ-ci/debug-key-secret`** — The repository has a GitHub Actions secret
  `DEBUG_KEYSTORE` holding, base64-encoded, a keystore made with Android's debug defaults
  (store and key password `android`, alias `androiddebugkey`); the keystore is kept nowhere
  in the repository.
  - **held by:** demonstration: `gh secret list` names `DEBUG_KEYSTORE`
  - **assumes:** `./build.sh` writes the decoded keystore where Android's build looks for
    its default debug keystore, so no Gradle file changes and the keystore must use
    Android's debug defaults.

## Known limits

- **`LIM-ci/build-by-run`** — `CAP-ci/github-build` is shown only by pushing a commit and
  reading its run and the APK it offers; no test runs the workflow.
- **`LIM-ci/artifact-retention`** — A run offers its APK for GitHub's default artifact
  retention, 90 days; after that the run no longer offers it, and a fresh one is had by
  starting the workflow by hand.
  - **held by:** demonstration: `gh api` lists the run's artifact with an `expires_at` 90
    days after the run started
- **`LIM-ci/release-by-hand`** — `CAP-ci/release-on-push` is shown only by pushing to
  `master`, reading the release, and installing its `.apk` by hand on a real phone; no test
  runs the release.
