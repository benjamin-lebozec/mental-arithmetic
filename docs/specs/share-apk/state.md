---
idea: share-apk
chain: trunk
step: 1
status: refining
waits on: none
remaining: 5q + 4r + 2i + 3f
---

# Share the APK with friends through GitHub

## Why

- **`why`** — The app is not meant for an app store, only to be shared with friends. They
  should get it from GitHub: open the README, see what the app is, and download the latest
  APK from one link, with each new version installing over the last.

## Requirements

- **`r-release-on-push`** — On every push to `master`, the CI publishes a GitHub release
  with the APK attached as a plain `.apk` file, not zipped, and one fixed link always
  downloads the latest APK.
- **`r-same-key`** — Every build is signed with the same key, so a new version installs over
  the old one without uninstalling; no store-grade signing is needed.
- **`r-key-secret`** — The signing key is kept out of the public repository, in a GitHub
  secret.
- **`r-readme`** — A README says in a few words what the app is, shows a screenshot, links
  to the latest APK, and says how to install an APK from outside the Play Store.

## To land

Nothing left to land.

## Reopened

- **`REQ-ci/github-repository`** — in `.github/workflows/SPEC.md`
  - **now says:** "The repository is pushed to a private GitHub repository, its `origin`,
    where GitHub Actions runs the workflow on GitHub's hosted Ubuntu runner, which has
    Docker and reaches the internet, as `REQ-root/docker` and `REQ-root/network` ask of the
    host. — held by: demonstration: `git remote -v` names it, and `gh repo view` shows it
    private"
  - **change:** the repository is public, not private; `gh repo view` shows it public
  - **authority:** the brief: "the repository becomes public"
  - **held in:** no file; the repository's visibility on GitHub
  - **status:** planned
- **`LIM-ci/actions-minutes`** — in `.github/workflows/SPEC.md`
  - **now says:** "The repository is private, so its runs count against the account's
    metered GitHub Actions minutes; once they run out, pushes are no longer built until the
    quota renews. — held by: demonstration: `gh repo view` shows the repository private"
  - **change:** retired: a public repository's runs on GitHub's standard hosted runners are
    not metered, so the limit no longer holds
  - **authority:** the brief: "the repository becomes public"; retired rather than
    reworded under `a-public-minutes-free`
  - **held in:** no file
  - **status:** planned

## Success signal

Not yet: waits on `q-validation`.

## Assumptions

- **`a-key-through-build-sh`** — The CI hands the signing key to the build through
  `./build.sh`, so the workflow still builds only by running it, as `INV-ci/one-build-path`
  requires.
  - **raised by:** the brief: "every build must be signed with the same key … (github
    secret)", read against `INV-ci/one-build-path`
  - **bears on:** `r-same-key`, `r-key-secret`
- **`a-host-build-unchanged`** — Without the secret, as on this host, `./build.sh` builds
  as it does now, signed with Android's default debug key, so `CAP-root/docker-build` and
  the emulator checks are unchanged.
  - **raised by:** the brief: "every build must be signed with the same key", read against
    `CAP-root/docker-build`
  - **bears on:** `r-same-key`
- **`a-same-key-scope`** — "Every build" means every build the CI runs with the secret: a
  build without it, on this host or for a pull request from a fork (which GitHub runs
  without secrets), is signed with Android's default debug key.
  - **raised by:** the brief: "every build must be signed with the same key", read against
    `CAP-root/docker-build` and `INV-ci/triggers`
  - **bears on:** `r-same-key`
- **`a-public-minutes-free`** — A public repository's runs on GitHub's standard hosted
  runners are not metered, so `LIM-ci/actions-minutes` is retired rather than reworded.
  - **raised by:** the brief: "the repository becomes public", read against
    `LIM-ci/actions-minutes`
  - **bears on:** `LIM-ci/actions-minutes`
- **`a-release-only-master`** — A push to any other branch, and a pull request, still only
  builds and offers the APK from the run, as now; it publishes no release.
  - **raised by:** the brief: "on every push to master", read against `INV-ci/triggers`
  - **bears on:** `r-release-on-push`
- **`a-readme-english`** — The README is written in English, like the app's screen.
  - **raised by:** the brief: "add a README: a few words on what the app is"
  - **bears on:** `r-readme`

## Files

- `.github/workflows/build.yml` — holds: `r-release-on-push`, `r-same-key` — planned
- `.github/workflows/SPEC.md` — holds: `REQ-ci/github-repository`,
  `LIM-ci/actions-minutes`, the claims `r-release-on-push` and `r-same-key` become —
  planned
- `README.md` — holds: `r-readme` — planned

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) push a commit to `master`: its run ends green and publishes a release with the
      `.apk` attached; the fixed link downloads that `.apk`, which installs on the emulator
      through `adb`; then push a second commit and install its `.apk` over the first
      without uninstalling; and the README on GitHub shows the screenshot, and its link
      downloads the latest `.apk`
    - (b) as (a), but the install is done by hand on a real phone, from the README's link
    - (c) only check that the release and its `.apk` exist, without installing
  - **recommended:** (a), because it shows every part of the brief (plain `.apk`, fixed
    link, same key, README) on this host, through the emulator we already drive
  - **unblocks:** the success signal, and every capability's `success:`
  - **raised by:** step 1 always asks it
  - **answer:**
- **`q-release-naming`** — Every push to `master` makes a release: what does each one look
  like?
  - **options:**
    - (a) a new release per push, tagged `build-<run number>`, marked latest; older ones
      stay listed
    - (b) one rolling release whose tag is moved and whose `.apk` is replaced on each push,
      so only the latest exists
    - (c) as (a), but only the last few releases are kept, older ones deleted
  - **recommended:** (a), because it is the simplest workflow, each release names the
    commit it was built from, and GitHub's `releases/latest/download/<file>.apk` link
    always serves the newest
  - **unblocks:** `r-release-on-push`, `.github/workflows/build.yml`
  - **raised by:** the brief: "on every push to master, the ci publishes a github release"
  - **answer:**
- **`q-apk-variant`** — Which APK is published and signed with the fixed key?
  - **options:**
    - (a) the debug APK the build already makes, signed with a fixed debug keystore from
      the secret
    - (b) a release APK (optimized, not debuggable), signed with a key you create, from the
      secret; this adds a second build type and reopens the assumption of
      `CAP-ci/github-build` that the APK is the debug one
  - **recommended:** (a), because it changes least (one APK, the same build, the same
    emulator checks) and a debug APK runs fine for friends
  - **unblocks:** `r-same-key`, `r-key-secret`, `.github/workflows/build.yml`
  - **raised by:** the brief: "the apk needs no store-grade signing, but every build must
    be signed with the same key"
  - **answer:**
- **`q-make-public`** — Who makes the repository public, and when?
  - **options:**
    - (a) you, with `gh repo edit --visibility public
      --accept-visibility-change-consequences`, after checking the history holds nothing
      private, before the release lands
    - (b) the refine run, when it lands the release, after asking you
  - **recommended:** (a), because it cannot be undone (the history is public from then on)
    and it is yours to decide
  - **unblocks:** `REQ-ci/github-repository`, `LIM-ci/actions-minutes`
  - **raised by:** the brief: "the repository becomes public"
  - **answer:**
- **`q-screenshot`** — What does the README's screenshot show, and where is the image kept?
  - **options:**
    - (a) a multiplication after the check, errors marked, taken on the emulator through
      `adb`, kept at `.github/screenshot.png`
    - (b) the same, kept at `screenshot.png` beside the README
    - (c) a multiplication being typed, before the check, kept at `.github/screenshot.png`
  - **recommended:** (a), because the checked screen shows the whole app at once, and
    `.github/` keeps the root holding only the build and the modules
  - **unblocks:** `r-readme`, `README.md`, the screenshot's file
  - **raised by:** the brief: "a screenshot"
  - **answer:**
