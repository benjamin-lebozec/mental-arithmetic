#!/bin/sh
# [provides: CAP-root/docker-build] the one command a host with only Docker runs: it builds
# the image, then builds the debug APK and runs every module's JVM unit tests in it.
set -eu
cd "$(dirname "$0")"

docker build -t mental-arithmetic-build .

# The container runs as the host user, so the APK it writes belongs to them. Gradle's and
# Android's caches live under the gitignored .gradle/, so later builds reuse them.
docker run --rm \
  -u "$(id -u):$(id -g)" \
  -v "$PWD":/project \
  -e GRADLE_USER_HOME=/project/.gradle/gradle-home \
  -e ANDROID_USER_HOME=/project/.gradle/android-home \
  mental-arithmetic-build \
  gradle --no-daemon assembleDebug test
