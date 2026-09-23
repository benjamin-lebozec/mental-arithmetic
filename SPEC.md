---
namespace: root
---

# mental-arithmetic

An Android app for practising mental arithmetic. The root holds the build, which runs in
Docker, and accepts modules: each top-level directory recognized below is one.

## Capabilities

- **`CAP-root/docker-build`** — On a host with nothing installed but Docker, the APK is
  built, and the JVM unit tests of every module run, in a Docker container.
  - **success:** On this host, `./build.sh` writes the debug APK into
    `app/build/outputs/apk/debug/` and runs the JVM unit tests of every module, which pass.
  - **assumes:** the host has no JDK and no Android SDK, and none is installed on it; the
    image carries both, and Gradle, so there is no Gradle wrapper. The APK is installed on
    the Android Studio emulator on Windows through `adb`.
- **`CAP-root/debug-key`** — When `DEBUG_KEYSTORE` holds a base64-encoded keystore,
  `./build.sh` signs the debug APK with it, so every build given the same keystore installs
  over the last without uninstalling; when it is unset or empty, the APK is signed with
  Android's default debug key, as now.
  - **success:** The `.apk` of a second push's release installs by hand on a real phone over
    the first's, without uninstalling.
  - **assumes:** the key reaches the build only through `./build.sh`; without it, as on
    this host or for a pull request from a fork, the build is what it was, signed with
    Android's default debug key; the keystore is written as Android's default debug
    keystore, `debug.keystore` under the build's `ANDROID_USER_HOME`
    (`.gradle/android-home/`), so no Gradle file changes and the keystore uses Android's
    debug defaults.
- **`CAP-root/readme`** — A friend opening the repository on GitHub reads in a few words
  what the app is, sees a screenshot of it, finds a link that downloads the latest APK, and
  reads how to install an APK from outside the Play Store; the words and the screenshot show
  the app as it is now, and a change to how the app's screen looks takes the screenshot
  again.
  - **success:** The README, as GitHub shows it, says what the app is, shows a screenshot of
    the app's screen as it is now, and says how to install an APK from outside the Play
    Store; its link downloads the latest `.apk`, which installs by hand on a real phone.
  - **why:** the README cites, as uses:, the six app capabilities its screenshot shows,
    `CAP-app/pick-digit-count`, `CAP-app/new-pair`, `CAP-app/posed-layout`,
    `CAP-app/right-to-left-entry`, `CAP-app/check-at-end` and `CAP-app/try-again`, so a
    change to any of them brings the README into that change's review.
  - **assumes:** the README is written in English, like the app's screen; the link names
    the release's `mental-arithmetic.apk`; the screenshot shows a 3-digit multiplication
    after the check, with wrong digits in red, taken on the Android Studio emulator through
    `adb`.

## Contract

- **addition:** a module is a top-level directory holding a `build.gradle.kts` and a
  `SPEC.md`.
- **`INV-root/module-recognized`** — A module is a top-level directory holding a
  `build.gradle.kts` and a `SPEC.md`; `settings.gradle.kts` includes every such directory
  it finds on disk, and names none.
  - **held by:** review: `settings.gradle.kts` names no module, and the build's project
    list matches the top-level directories holding both files
  - **why:** a settings script has no JVM unit test to show it
- **`INV-root/module-dependency`** — A module depends on another only through a
  `project(":<name>")` dependency in its `build.gradle.kts`, and the dependencies form no
  cycle.
  - **held by:** review, over every module's `build.gradle.kts`
  - **why:** a set of build files has no JVM unit test to show it

## Non-goals

- **`NOT-root/signing-key-in-repo`** — No keystore is committed: the signing key lives only
  in the GitHub secret, and a build writes it under the gitignored `.gradle/`.

## Requires

- **`REQ-root/docker`** — The host has Docker (28.5 is the version the build is run with),
  and needs no JDK and no Android SDK.
- **`REQ-root/network`** — The host reaches the internet while it builds: the image
  downloads Gradle and the Android SDK, and Gradle downloads the plugins and libraries.

## Known limits

- **`LIM-root/build-by-run`** — `CAP-root/docker-build` is shown only by running
  `./build.sh` on the host and reading its result; no test runs the build.
- **`LIM-root/shown-by-hand`** — `CAP-root/debug-key` and `CAP-root/readme` are shown only
  by hand: installing a release's `.apk` over the one before on a real phone, and reading
  the README on GitHub; no test runs them.
- **`LIM-root/screenshot-freshness`** — A change to the app's screen brings the README's
  screenshot into review only when it touches one of the app capabilities the README cites
  as uses:; a change that touches none of them does not take the screenshot again. A new
  element under a new capability is caught only once that capability is added to the
  README's uses:; a change of theme or colour that touches none of them is never caught by
  the uses:, and the screenshot is then retaken only by hand.
  - **shown by:** review, reading the README's uses: against the app capabilities that shape
    the screen
