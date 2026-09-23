---
idea: share-apk
chain: trunk
step: 4
refines: step-3.md
---

# Step 4: land the release on push, the fixed signing key and the README; chain done

## This step

Lands all ten items step-3 settled, and closes its six files. Into
`.github/workflows/SPEC.md`: `CAP-ci/release-on-push`, `INV-ci/release-only-master-push`,
`REQ-ci/debug-key-secret` and `LIM-ci/release-by-hand`. The reopened
`REQ-ci/github-repository` now says public, and `LIM-ci/actions-minutes` is retired. Into
`SPEC.md`: `CAP-root/debug-key`, `CAP-root/readme`, `NOT-root/signing-key-in-repo` and
`LIM-root/shown-by-hand`. Each of the nine assumptions lands as the `assumes:` line of the
claims it bears on. The capabilities' criteria need two pushes to `master` before the step
commit. So, at the user's word ("alright", 2026-09-23, after being told why two builds),
two demo commits were pushed. The step accounts for both: `998c228` holds this step's tree
changes as they stood before review, and `9952c07` is empty. Review's two fixes, to
`build.sh` and `README.md`, came after them and are committed with the step. No item is settled under standing
authorization. `status: refining → done`,
`remaining: 0q + 0r + 10i + 6f → 0q + 0r + 0i + 0f`.

## Changes

- **`CAP-ci/release-on-push`** — landed
  - **now:** into `.github/workflows/SPEC.md` as written, with an `assumes:` line from
    `a-key-through-build-sh`, `a-same-key-scope` and `a-apk-name`; held in
    `.github/workflows/build.yml` (the job's `permissions:`, and the release step)
  - **verdict:** discharged
- **`INV-ci/release-only-master-push`** — landed
  - **now:** into `.github/workflows/SPEC.md` as written, with an `assumes:` line from
    `a-release-only-master` and `a-manual-no-release`; held by review, over the release
    step's `if:`
  - **verdict:** discharged
- **`REQ-ci/debug-key-secret`** — landed
  - **now:** into `.github/workflows/SPEC.md` as written, with an `assumes:` line from
    `a-key-as-default-keystore`
  - **verdict:** discharged
- **`LIM-ci/release-by-hand`** — landed
  - **now:** into `.github/workflows/SPEC.md` as written, replacing the retired
    `LIM-ci/actions-minutes` under Known limits
  - **verdict:** discharged
- **`CAP-root/debug-key`** — landed
  - **now:** into `SPEC.md` as written, with an `assumes:` line from
    `a-key-through-build-sh`, `a-host-build-unchanged`, `a-same-key-scope` and
    `a-key-as-default-keystore`; held in `build.sh` (the block writing the decoded
    keystore, which sets aside a default debug keystore already there and puts it back on
    exit, interrupt included, and first puts back a default a killed build left set aside),
    and used by the build step's `env:` in `.github/workflows/build.yml`
  - **verdict:** discharged
- **`NOT-root/signing-key-in-repo`** — landed
  - **now:** into `SPEC.md` as written, under a new Non-goals section
  - **verdict:** discharged
- **`CAP-root/readme`** — landed
  - **now:** into `SPEC.md` as written, with an `assumes:` line from `a-readme-english` and
    `a-apk-name`; held in `README.md` (its opening comment cites it) and
    `.github/screenshot.png` (426 × 899 after the
    check, two wrong digits in red, taken on the emulator through `adb`)
  - **verdict:** discharged
- **`LIM-root/shown-by-hand`** — landed
  - **now:** into `SPEC.md` as written
  - **verdict:** discharged
- **`REQ-ci/github-repository`** (reopened) — landed
  - **now:** its text in `.github/workflows/SPEC.md` says "public" for "private", and its
    held-by line "shows it public"; it gains an `assumes:` line from
    `a-public-minutes-free`, the reason the minutes limit no longer holds
  - **verdict:** discharged
- **`LIM-ci/actions-minutes`** (reopened) — landed: retired, its declaration removed from
  `.github/workflows/SPEC.md`; the id is never reused
  - **verdict:** discharged
- **`a-key-through-build-sh`**, **`a-host-build-unchanged`**, **`a-same-key-scope`**,
  **`a-public-minutes-free`**, **`a-release-only-master`**, **`a-readme-english`**,
  **`a-manual-no-release`**, **`a-apk-name`**, **`a-key-as-default-keystore`** — landed,
  each as the `assumes:` line of the claims its `bears on:` names, as listed above; the
  Assumptions section now says "Nothing left: each landed with the items it bears on."
  - **verdict:** discharged
- **To land**, **Reopened** — both sections now say "Nothing left to land."
  - **verdict:** discharged
- **`.github/workflows/build.yml`**, **`.github/workflows/SPEC.md`**, **`build.sh`**,
  **`SPEC.md`**, **`README.md`**, **`.github/screenshot.png`** — closed; the Files section
  now says "Nothing left to write."
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

- **Demo pushes.** The step's commit can only exist after review, so two commits were
  pushed to `master` first. `998c228` is step-3's commit plus this step's tree changes
  as they stood before review: the six files above, the docs left out. `9952c07` is empty. Run 35846685401
  (`998c228`, push) ended `success`: every step passed, the release step included. Run
  35847006257 (`9952c07`, push) ended `success` too.
- **`CAP-ci/release-on-push`** — "A commit is pushed to `master`: its run ends green and
  publishes a new release, tagged `build-<run number>` and marked latest, older ones still
  listed, with `mental-arithmetic.apk` attached as a plain `.apk`; the fixed link […]
  downloads it, and it installs by hand on a real phone. After a second push, the fixed
  link downloads the second release's `.apk`."
  - After the first push, `gh release list` showed `build 3  Latest  build-3`. The fixed
    link returned 200, `application/vnd.android.package-archive`, 8723035 bytes, and
    `file` read it as an Android package, not a zip of one.
  - After the second push, `gh release list` showed `build-4` as Latest and `build-3`
    still listed. `gh api …/releases` gives each release one asset,
    `mental-arithmetic.apk`, of type `application/vnd.android.package-archive`, targeting
    `9952c07` and `998c228`. The fixed link redirects to
    `…/releases/download/build-4/mental-arithmetic.apk`, and what it downloads is
    byte-identical to `build-4`'s asset.
  - The user was asked three things:
    - read the README on GitHub;
    - install `build-3` from its own release link;
    - once `build-4` was out, install the latest from the README's link over it, without
      uninstalling.

    They answered: "everything went fine on my side" (2026-09-23). So `build-3` installed
    by hand on their phone.
- **`CAP-root/debug-key`** — "The `.apk` of a second push's release installs by hand on a
  real phone over the first's, without uninstalling."
  - The user installed `build-4` from the README's link over `build-3` on their phone,
    without uninstalling ("everything went fine on my side", 2026-09-23).
  - Supporting checks with `apksigner verify --print-certs`, run in the build image:
    - both releases' `.apk` are signed by certificate SHA-256 `8f69163d…b4fefc`. That is
      the keystore's own fingerprint by `keytool -list`: the keystore the secret was set
      from.
    - A build of the pre-review `build.sh`, run in a scratch worktree with `DEBUG_KEYSTORE`
      set from that keystore, wrote it byte for byte to `.gradle/android-home/debug.keystore`
      (`cmp`) and produced an `.apk` signed by `8f69…fefc`.
    - The host's build without the variable (`env -u DEBUG_KEYSTORE ./build.sh`) passed
      and kept its default debug key, `553bae58…b4031b`. This shows
      `a-host-build-unchanged`.
- **`CAP-root/readme`** — "The README, as GitHub shows it, says what the app is, shows the
  screenshot, and says how to install an APK from outside the Play Store; its link
  downloads the latest `.apk`, which installs by hand on a real phone."
  - The user read the README on GitHub, and downloaded and installed the latest `.apk` from
    its link on their phone ("everything went fine on my side", 2026-09-23). The link is
    the fixed link shown above to redirect to `build-4`.
  - The screenshot was taken through `adb` on the emulator: 3 digits, 426 × 899, lines
    typed 3834, 38840 (one wrong digit), 340800 and 382964 (one wrong digit). It shows both
    wrong digits in red after the check.
- **`REQ-ci/debug-key-secret`** — `gh secret list` names `DEBUG_KEYSTORE`
  (2026-09-23T09:42:34Z).
- **`REQ-ci/github-repository`** — `git remote -v` names
  `github.com/benjamin-lebozec/mental-arithmetic`; `gh repo view --json visibility` gives
  `PUBLIC`.
- **`NOT-root/signing-key-in-repo`** — `git ls-files '*.keystore' '*.jks'` comes back
  empty.
- **After review's fixes.**
  - `998c228`, which the CI ran, predates the fixes. The README's added line is an HTML
    comment, which GitHub does not display.
  - The `build.sh` fixes change nothing on the CI. A fresh checkout has no default keystore
    to set aside and nothing left set aside, so the key is written and used as before, then
    removed on exit.
  - Real builds of the fixed `build.sh` ran in a scratch worktree seeded with the host's
    default debug keystore. The worktree's copy was taken before the last fix, the recovery
    of a key left set aside, which does not fire when nothing is set aside.
    - Keyed with `DEBUG_KEYSTORE`: `BUILD SUCCESSFUL`, 62 tasks executed, the unit tests
      included. The `.apk` is signed by `8f69…fefc`. Afterwards `debug.keystore` is
      byte-identical to the host's default (`cmp`), and no `.default` is left.
    - Then unkeyed: `BUILD SUCCESSFUL`, and the `.apk` is signed by the default
      `553bae58…b4031b`.
    - Logs: `b2-keyed.log` and `b2-plain.log` in the session scratchpad.
  - Scratch copies of the final `build.sh`, with `docker` stubbed to record the keystore the
    build would see:
    - With a default keystore present, the build saw the secret's keystore (`5a09e290…`),
      and afterwards the default was back and nothing else was left.
    - With none present, it saw the secret's keystore, and afterwards none was left.
    - Unset, it saw the default, untouched.
    - With the build failing, it exited 1 and the default was back.
    - Killed with SIGINT and with SIGTERM mid-build, it exited 130 and the default was
      back.
    - After a simulated SIGKILL left the secret in place and the default set aside, an
      unkeyed build saw the default (`01666ec0…`). A keyed build saw the secret, and the
      default was left in place with no `.default` over it.
- **Tests.** No Gradle module and no root build file changed. `./build.sh` (with
  `assembleDebug test`) passed both in the scratch worktree with the key (62 tasks
  executed, `BUILD SUCCESSFUL`, the unit test tasks of each module included) and on the
  host without it (`BUILD SUCCESSFUL`, 62 up-to-date). Logs: `build-key.log` and
  `build-host.log` in the session scratchpad.

## Reviews

Scope: full, over the 25 shipped files. Git accounting found no commit unaccounted for:
`998c228` and `9952c07` are this step's demo commits. Two findings failed, and both were
fixed before proving:
- **forward / coverage** — `CAP-root/readme` had no `[provides:]`, and the line that
  loads the exempt `.github/screenshot.png` (`README.md`'s `<img>`) was uncited. Fixed: an
  HTML comment opening `README.md` provides `CAP-root/readme` and covers the file.
- **`CAP-root/debug-key`** — "unset or empty, the APK is signed with Android's default
  debug key" broke on a host. A build with the variable overwrote the persistent
  `.gradle/android-home/debug.keystore`, so later builds without it kept the secret's key.
  Fixed: `build.sh` sets the default keystore aside and puts it back on exit, or removes
  the written one if there was none. Shown in Demonstrations.

Round 2, over `git diff 9952c07 -- README.md build.sh`:
- forward, coverage and path hold.
- `CAP-root/debug-key`, `CAP-root/docker-build` and `NOT-root/signing-key-in-repo` hold
  against the new code, checked under dash and bash.
- The six claims landed without code hold of the tree: `NOT-root/signing-key-in-repo`,
  `REQ-ci/debug-key-secret`, `REQ-ci/github-repository`, `INV-ci/release-only-master-push`,
  `LIM-ci/release-by-hand`, `LIM-root/shown-by-hand`.
- It raised one case: a keyed build killed by SIGKILL skips the traps, and the next keyed
  build would then overwrite the set-aside default. Fixed: the script first puts back any
  default left set aside. Shown in Demonstrations.

Round 3, over the final `build.sh` (whole file), after the recovery fix:
- coverage and path hold;
- `CAP-root/debug-key`, `CAP-root/docker-build`, `NOT-root/signing-key-in-repo` and
  `INV-ci/fails-on-failure` hold.

Noted, not changed:
- The reviewer flagged that the location clause of `CAP-root/debug-key`'s and
  `REQ-ci/debug-key-secret`'s `assumes:` lines restates `build.sh`. It is kept, because
  it is `a-key-as-default-keystore` landed as settled, and the reason clause depends on
  it.
- Outside the claims: re-running a master push's run reuses its run number, so
  `gh release create build-N` fails on the existing tag, and the re-run goes red. That is
  put to the user.
- One narrow case, raised by both agents: a keyed build killed by SIGKILL, on a tree that
  had no default keystore, leaves the secret key as `debug.keystore`. Later builds without
  the variable are then signed with it. This cannot happen on the CI, whose checkout is
  fresh. On this host, `.gradle/android-home/` holds a default keystore. Put to the user.

Every other rule and claim holds: 9 citation rules; the ci, root, app and multiplication
claims; the root contract.

## Proof

- **re-proof of step-3** — skipped: nothing changed since step-3's commit (`git status`
  was clean at the start of the run)
- **rounds**
  - round 1: `matched` and `demonstrated` failed, and `landed` and `terminal` were
    undecidable. Review's two fixes, the README's citation and the default key's restore,
    had landed on disk unrecorded, and nothing had run the fixed `build.sh`. The step now
    records both fixes, real keyed-then-unkeyed builds of the fixed script, the stubbed
    checks, and both review rounds.
  - round 2: `landed` was undecidable. No reviewer pass was recorded over the recovery
    block added after review round 2. Review round 3 passed over the final `build.sh`. Two
    stale sentences were reworded ("as they stood before review", "the pre-review
    `build.sh`").
  - round 3: every obligation discharged; the list below is its verdicts.
- **matched** — discharged; Changes lists every plan and spec change, and both review fixes
- **coverage** — discharged; each abstract item has one fate, and `why` and
  `s-friend-install` are kept untouched
- **no-widening** — discharged; after review's fixes, an unkeyed build is signed with the
  default key after a normal, failed, interrupted or killed keyed build (the killed case
  when a default key existed)
- **no-narrowing** — discharged; a keyed build signs with the secret, and non-master runs
  build and upload as before
- **answers-applied** — discharged; no question is closed
- **justified** — discharged; the restore, the recovery and the README comment serve
  `CAP-root/debug-key` and `CAP-root/readme`
- **consistent** — discharged; `INV-ci/one-build-path`, `INV-ci/triggers` and
  `INV-ci/fails-on-failure` still hold
- **settled** — discharged; all ten items and six files were settled in step-3
- **landed** — discharged; each claim is declared once in its spec, provided or held as its
  kind requires, and review rounds 2 and 3 pass over the final tree
- **demonstrated** — discharged; both CI runs, both releases, the fixed link and the user's
  phone installs are recorded, as are real builds and stubbed checks of the fixed
  `build.sh`
- **tree-kept** — discharged; every changed file is in the abstract Files list
- **files** — discharged; the six files are closed, and no other chain is in flight
- **progress** — discharged; ten items land
- **amendments** — discharged; none
- **terminal** — discharged; only `why` and `s-friend-install` are left, three landed
  capabilities show `s-friend-install`, and review round 2 records the six claims landed
  without code as holding
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
