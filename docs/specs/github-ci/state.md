---
idea: github-ci
chain: trunk
step: 4
status: refining
waits on: none
remaining: 0q + 0r + 2i + 1f
---

# A CI on GitHub that builds the APK

## Why

- **`why`** — The APK is built only when someone runs `./build.sh` on a host with Docker
  (`CAP-root/docker-build`); nothing builds it on GitHub. The brief asks for a CI on GitHub
  that builds it.

## Requirements

Nothing left to refine: `r-ci-builds-apk` became `CAP-ci/github-build`.

## To land

- **`LIM-ci/artifact-retention`** — A run offers its APK for GitHub's default artifact
  retention, 90 days; after that the run no longer offers it, and a fresh one is had by
  starting the workflow by hand.
  - **raised by:** review found the run's artifact expires (`expires=2026-12-22`), bounding
    `CAP-ci/github-build`'s "offers the APK for download", and no claim said so
  - **held by:** demonstration: `gh api` lists the run's artifact with an `expires_at` 90
    days after its `created_at`
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned
- **`LIM-ci/actions-minutes`** — The repository is private, so its runs count against the
  account's metered GitHub Actions minutes; once they run out, pushes are no longer built
  until the quota renews.
  - **raised by:** review found this bounds `CAP-ci/github-build`'s "every change pushed"
    and `INV-ci/triggers`' "every push", given `REQ-ci/github-repository`'s "private", and
    no claim said so
  - **held by:** demonstration: `gh repo view` shows the repository private
  - **lands in:** `.github/workflows/SPEC.md`
  - **status:** planned

## Reopened

Nothing reopened.

## Success signal

- **`s-green-run-with-apk`** — A commit pushed to GitHub gets a workflow run that ends
  green, and the debug APK can be downloaded from that run.

## Assumptions

No assumptions left: both landed as the `assumes:` line of `CAP-ci/github-build`.

## Files

- `.github/workflows/SPEC.md` — holds: `LIM-ci/artifact-retention`, `LIM-ci/actions-minutes`
  — written in step-3, open for: `LIM-ci/artifact-retention`, `LIM-ci/actions-minutes`

## Open Questions

No open questions: `q-ci-limits` was answered in step-4.
