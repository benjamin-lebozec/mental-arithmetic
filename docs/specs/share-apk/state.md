---
idea: share-apk
chain: trunk
step: 2
status: refining
waits on: none
remaining: 1q + 0r + 10i + 6f
---

# Share the APK with friends through GitHub

## Why

- **`why`** — The app is not meant for an app store, only to be shared with friends. They
  should get it from GitHub: open the README, see what the app is, and download the latest
  APK from one link, with each new version installing over the last.

## Requirements

Nothing left: each is now an item to land.

## To land

- **`CAP-ci/release-on-push`** — On every push to `master`, the CI publishes a new GitHub
  release with the APK attached as a plain `.apk` file, not zipped, signed with the key in
  the repository's secret, and one fixed link always downloads the latest APK.
  - **success:** A commit is pushed to `master`: its run ends green and publishes a new
    release, tagged `build-<run number>` and marked latest, older ones still listed, with
    `mental-arithmetic.apk` attached as a plain `.apk`; the fixed link
    `https://github.com/benjamin-lebozec/mental-arithmetic/releases/latest/download/mental-arithmetic.apk`
    downloads it, and it installs by hand on a real phone. After a second push, the fixed
    link downloads the second release's `.apk`.
  - **lands in:** `.github/workflows/SPEC.md`
  - **held in:** `.github/workflows/build.yml` (a release step after the build, and the
    secret handed to `./build.sh`)
  - **status:** planned
- **`INV-ci/release-only-master-push`** — The workflow publishes a release only for a push
  to `master`; every other run builds and offers the APK from the run, as now, and
  publishes none.
  - **held by:** review, over the release step's `if:` in `.github/workflows/build.yml`
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`REQ-ci/debug-key-secret`** — The repository has a GitHub Actions secret
  `DEBUG_KEYSTORE` holding, base64-encoded, a keystore made with Android's debug defaults
  (store and key password `android`, alias `androiddebugkey`); the keystore is kept nowhere
  in the repository.
  - **held by:** demonstration: `gh secret list` names `DEBUG_KEYSTORE`
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`LIM-ci/release-by-hand`** — `CAP-ci/release-on-push` is shown only by pushing to
  `master`, reading the release, and installing its `.apk` by hand on a real phone; no test
  runs the release.
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`CAP-root/debug-key`** — When `DEBUG_KEYSTORE` holds a base64-encoded keystore,
  `./build.sh` signs the debug APK with it, so every build given the same keystore installs
  over the last without uninstalling; when it is unset or empty, the APK is signed with
  Android's default debug key, as now.
  - **success:** The `.apk` of a second push's release installs by hand on a real phone over
    the first's, without uninstalling.
  - **lands in:** `SPEC.md`
  - **held in:** `build.sh` (writing the decoded keystore before the build)
  - **status:** planned
- **`NOT-root/signing-key-in-repo`** — No keystore is committed: the signing key lives only
  in the GitHub secret, and a build writes it under the gitignored `.gradle/`.
  - **held by:** absence: `git ls-files '*.keystore' '*.jks'` comes back empty
  - **lands in:** `SPEC.md`
  - **status:** planned
- **`CAP-root/readme`** — A friend opening the repository on GitHub reads in a few words
  what the app is, sees a screenshot, finds a link that downloads the latest APK, and reads
  how to install an APK from outside the Play Store.
  - **success:** The README, as GitHub shows it, says what the app is, shows the screenshot,
    and says how to install an APK from outside the Play Store; its link downloads the
    latest `.apk`, which installs by hand on a real phone.
  - **lands in:** `SPEC.md`
  - **held in:** `README.md`, `.github/screenshot.png` (a multiplication after the check,
    errors marked, taken on the emulator through `adb`)
  - **status:** planned
- **`LIM-root/shown-by-hand`** — `CAP-root/debug-key` and `CAP-root/readme` are shown only
  by hand: installing a release's `.apk` over the one before on a real phone, and reading
  the README on GitHub; no test runs them.
  - **lands in:** `SPEC.md`
  - **status:** planned

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
  - **status:** planned; settled by `q-make-public`: you make the repository public before
    the release lands, and it lands in that run once `gh repo view` shows it public
- **`LIM-ci/actions-minutes`** — in `.github/workflows/SPEC.md`
  - **now says:** "The repository is private, so its runs count against the account's
    metered GitHub Actions minutes; once they run out, pushes are no longer built until the
    quota renews. — held by: demonstration: `gh repo view` shows the repository private"
  - **change:** retired: a public repository's runs on GitHub's standard hosted runners are
    not metered, so the limit no longer holds
  - **authority:** the brief: "the repository becomes public"; retired rather than
    reworded under `a-public-minutes-free`
  - **held in:** no file
  - **status:** planned; settled by `q-make-public`, lands with `REQ-ci/github-repository`

## Success signal

- **`s-friend-install`** — A friend opens the README on GitHub, sees the screenshot,
  downloads the latest `.apk` from its link and installs it by hand on a real phone; after
  the next push to `master`, the new `.apk` installs over it without uninstalling.

## Assumptions

- **`a-key-through-build-sh`** — The CI hands the signing key to the build through
  `./build.sh`, so the workflow still builds only by running it, as `INV-ci/one-build-path`
  requires.
  - **raised by:** the brief: "every build must be signed with the same key … (github
    secret)", read against `INV-ci/one-build-path`
  - **bears on:** `CAP-root/debug-key`, `CAP-ci/release-on-push`
- **`a-host-build-unchanged`** — Without the secret, as on this host, `./build.sh` builds
  as it does now, signed with Android's default debug key, so `CAP-root/docker-build` and
  the emulator checks are unchanged.
  - **raised by:** the brief: "every build must be signed with the same key", read against
    `CAP-root/docker-build`
  - **bears on:** `CAP-root/debug-key`
- **`a-same-key-scope`** — "Every build" means every build the CI runs with the secret: a
  build without it, on this host or for a pull request from a fork (which GitHub runs
  without secrets), is signed with Android's default debug key.
  - **raised by:** the brief: "every build must be signed with the same key", read against
    `CAP-root/docker-build` and `INV-ci/triggers`
  - **bears on:** `CAP-root/debug-key`, `CAP-ci/release-on-push`
- **`a-public-minutes-free`** — A public repository's runs on GitHub's standard hosted
  runners are not metered, so `LIM-ci/actions-minutes` is retired rather than reworded.
  - **raised by:** the brief: "the repository becomes public", read against
    `LIM-ci/actions-minutes`
  - **bears on:** `LIM-ci/actions-minutes`
- **`a-release-only-master`** — A push to any other branch, and a pull request, still only
  builds and offers the APK from the run, as now; it publishes no release.
  - **raised by:** the brief: "on every push to master", read against `INV-ci/triggers`
  - **bears on:** `INV-ci/release-only-master-push`
- **`a-readme-english`** — The README is written in English, like the app's screen.
  - **raised by:** the brief: "add a README: a few words on what the app is"
  - **bears on:** `CAP-root/readme`
- **`a-manual-no-release`** — A run started by hand, even on `master`, publishes no
  release: the brief asks for one on every push, and a manual run is not a push.
  - **raised by:** the answer to `q-release-naming`, read against `INV-ci/triggers`
  - **bears on:** `INV-ci/release-only-master-push`
- **`a-apk-name`** — The release's `.apk` is attached as `mental-arithmetic.apk`, not as
  the build's `app-debug.apk`, so the file a friend downloads names the app, and the fixed
  link never changes.
  - **raised by:** the answer to `q-release-naming`: GitHub's latest-download link needs a
    fixed file name
  - **bears on:** `CAP-ci/release-on-push`, `CAP-root/readme`
- **`a-key-as-default-keystore`** — `./build.sh` writes the decoded keystore where Android's
  build looks for its default debug keystore (`debug.keystore` under the build's
  `ANDROID_USER_HOME`, `.gradle/android-home/`), so no Gradle file changes and the
  keystore must use Android's debug defaults.
  - **raised by:** the answer to `q-apk-variant`, read against `a-key-through-build-sh`
  - **bears on:** `CAP-root/debug-key`, `REQ-ci/debug-key-secret`

## Files

- `.github/workflows/build.yml` — holds: `CAP-ci/release-on-push`,
  `INV-ci/release-only-master-push` — planned
- `.github/workflows/SPEC.md` — holds: `REQ-ci/github-repository`,
  `LIM-ci/actions-minutes`, `CAP-ci/release-on-push`, `INV-ci/release-only-master-push`,
  `REQ-ci/debug-key-secret`, `LIM-ci/release-by-hand` — planned
- `build.sh` — holds: `CAP-root/debug-key` — planned
- `SPEC.md` — holds: `CAP-root/debug-key`, `NOT-root/signing-key-in-repo`,
  `CAP-root/readme`, `LIM-root/shown-by-hand` — planned
- `README.md` — holds: `CAP-root/readme` — planned
- `.github/screenshot.png` — holds: `CAP-root/readme` (an image, loaded by `README.md`) —
  planned

## Open Questions

- **`q-signing-key`** — Who creates the fixed debug keystore and its secret, and is a copy
  kept?
  - **options:**
    - (a) the next run creates it with `keytool` inside the build image, with Android's
      debug defaults, sets the `DEBUG_KEYSTORE` secret with `gh secret set`, and leaves the
      keystore in the scratchpad for you to keep outside the repository
    - (b) you create it and set the secret yourself, from commands the next run gives you
    - (c) as (a), but no copy is kept: if the secret is ever lost, friends uninstall once
  - **recommended:** (a), because it needs nothing from you but keeping a file, and the
    copy lets the key be restored if the secret is lost
  - **unblocks:** `REQ-ci/debug-key-secret`, `CAP-ci/release-on-push`, `CAP-root/debug-key`
  - **raised by:** the answer to `q-apk-variant`: a fixed debug keystore must exist and be
    put in the secret
  - **answer:**
