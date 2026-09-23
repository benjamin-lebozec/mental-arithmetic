#!/bin/sh
# [provides: CAP-root/docker-build] the one command a host with only Docker runs: it builds
# the image, then builds the debug APK and runs every module's JVM unit tests in it.
set -eu
cd "$(dirname "$0")"

docker build -t mental-arithmetic-build .

# [provides: CAP-root/debug-key] a keystore given base64-encoded in DEBUG_KEYSTORE is put
# where Android's build looks for its debug keystore, so the APK is signed with it; unset or
# empty, Android's default debug key signs the APK. The default key is set aside and put
# back on exit, even an interrupted one, so a later build without the variable is signed
# with it again. A default key a killed build left set aside is put back first.
keystore=.gradle/android-home/debug.keystore
if [ -e "$keystore.default" ]; then
  mv -f "$keystore.default" "$keystore"
fi
if [ -n "${DEBUG_KEYSTORE:-}" ]; then
  mkdir -p .gradle/android-home
  if [ -e "$keystore" ]; then
    mv "$keystore" "$keystore.default"
    trap 'mv -f "$keystore.default" "$keystore"' EXIT
  else
    trap 'rm -f "$keystore"' EXIT
  fi
  trap 'exit 130' INT TERM
  printf '%s' "$DEBUG_KEYSTORE" | base64 -d > "$keystore"
fi

# [provides: CAP-root/docker-build] the container runs as the host user, so the APK it
# writes belongs to them. Gradle's and Android's caches live under the gitignored .gradle/,
# so later builds reuse them.
docker run --rm \
  -u "$(id -u):$(id -g)" \
  -v "$PWD":/project \
  -e GRADLE_USER_HOME=/project/.gradle/gradle-home \
  -e ANDROID_USER_HOME=/project/.gradle/android-home \
  mental-arithmetic-build \
  gradle --no-daemon assembleDebug test
