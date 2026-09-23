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

## Requires

- **`REQ-root/docker`** — The host has Docker (28.5 is the version the build is run with),
  and needs no JDK and no Android SDK.
- **`REQ-root/network`** — The host reaches the internet while it builds: the image
  downloads Gradle and the Android SDK, and Gradle downloads the plugins and libraries.

## Known limits

- **`LIM-root/build-by-run`** — `CAP-root/docker-build` is shown only by running
  `./build.sh` on the host and reading its result; no test runs the build.
