---
idea: github-ci
chain: trunk
step: 5
status: done
waits on: none
remaining: 0q + 0r + 0i + 0f
---

# A CI on GitHub that builds the APK

## Why

- **`why`** — The APK is built only when someone runs `./build.sh` on a host with Docker
  (`CAP-root/docker-build`); nothing builds it on GitHub. The brief asks for a CI on GitHub
  that builds it.

## Requirements

Nothing left to refine: `r-ci-builds-apk` became `CAP-ci/github-build`.

## To land

Nothing left to land: `LIM-ci/artifact-retention` and `LIM-ci/actions-minutes` landed in
step-5.

## Reopened

Nothing reopened.

## Success signal

- **`s-green-run-with-apk`** — A commit pushed to GitHub gets a workflow run that ends
  green, and the debug APK can be downloaded from that run.

## Assumptions

No assumptions left: both landed as the `assumes:` line of `CAP-ci/github-build`.

## Files

No files left: `.github/workflows/SPEC.md` closed in step-5.

## Open Questions

No open questions: `q-ci-limits` was answered in step-4.
