---
idea: readme-current
chain: trunk
step: 2
status: refining
waits on: none
remaining: 2q + 0r + 1i + 3f
---

# A README that shows the app as it is now

## Why

- **`why`** — The README's screenshot is out of date: it still shows the old keypad, 7 8 9
  on top, and no New button. A friend opening the repository sees an app that no longer
  exists.

## Requirements

Nothing left: the one requirement became the reopened `CAP-root/readme`.

## To land

Nothing new to land: the one item left is reopened below.

## Reopened

- **`CAP-root/readme`** — in `SPEC.md`
  - **now says:** "A friend opening the repository on GitHub reads in a few words what the
    app is, sees a screenshot, finds a link that downloads the latest APK, and reads how to
    install an APK from outside the Play Store. — success: The README, as GitHub shows it,
    says what the app is, shows the screenshot, and says how to install an APK from outside
    the Play Store; its link downloads the latest `.apk`, which installs by hand on a real
    phone."
  - **change:** the claim adds that what the README says and shows is the app as it is now,
    not as it was
  - **authority:** the brief: "amend the readme capability to add that the README should
    reflect the current state of the app"
  - **will say:** "A friend opening the repository on GitHub reads in a few words what the
    app is, sees a screenshot of it, finds a link that downloads the latest APK, and reads
    how to install an APK from outside the Play Store; the words and the screenshot show
    the app as it is now, and a change to how the app's screen looks takes the screenshot
    again. — success: The README, as GitHub shows it, says what the app is, shows a
    screenshot of the app's screen as it is now, and says how to install an APK from outside
    the Play Store; its link downloads the latest `.apk`, which installs by hand on a real
    phone. — why: the README
    cites, as uses:, the six app capabilities its screenshot shows, `CAP-app/pick-digit-count`,
    `CAP-app/new-pair`, `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`,
    `CAP-app/check-at-end` and `CAP-app/try-again`, so a change to any of them brings the
    README into that change's review. — assumes: the README is written in English, like the
    app's screen; the link names the release's `mental-arithmetic.apk`; the screenshot shows
    a 3-digit multiplication after the check, with wrong digits in red, taken on the Android
    Studio emulator through `adb`."
  - **decided by:** `q-validation`'s answer, "a graphical change of the main app should
    always trigger a new screenshot"; `q-freshness-held`'s answer, "uses: citations, no
    INV (Recommended)", "All six (Recommended)"; `q-alt-text`'s answer, "Scene, no operands
    (Recommended)" (2026-09-23)
  - **held in:** `README.md`, `.github/screenshot.png`
  - **status:** planned

## Success signal

- **`s-screenshot-current`** — A new screenshot replaces the README's, and shows the app as
  it is now: 1 at the top left of the keypad, and New in the row of count buttons.

## Assumptions

- **`a-same-scene`** — The new screenshot shows the same scene as the one it replaces: a
  3-digit multiplication after the check, with wrong digits in red, taken on the emulator
  through `adb`. Only the app in it is current.
  - **raised by:** the brief: "update the screenshot so it does"
  - **bears on:** `CAP-root/readme`, as its `assumes:` line
- **`a-words-and-picture`** — "The README" covers both its words and its screenshot: both
  describe the app as it is now. The words are already true of the current app; only the
  picture and its alt text are stale.
  - **raised by:** the brief: "the README should reflect the current state of the app"
  - **bears on:** `CAP-root/readme`

## Files

- `SPEC.md` — holds: `CAP-root/readme` (reopened) — planned
- `README.md` — holds: `CAP-root/readme` (reopened); its header also cites, as uses:, the
  six app capabilities the screenshot shows; the screenshot's alt text names the scene
  without operands: "a 3-digit multiplication after the check, with wrong digits in red"
  — planned
- `.github/screenshot.png` — holds: `CAP-root/readme` (reopened), its screenshot — planned

## Open Questions

- **`q-uses-gap`** — The reopened claim says "a change to how the app's screen looks takes
  the screenshot again", but the README's uses: name six capabilities. A change to the
  screen that touches none of them (a new element under a new capability, or a theme or
  colour change) would not bring the README into review. What should the tree say?
  - **options:**
    - (a) record the gap as a `LIM-root/…` in `SPEC.md`: the screenshot is re-checked only
      when a change touches a capability the README uses, and a new app capability must add
      itself to those uses: to be covered
    - (b) narrow the claim's wording to what the uses: catch: a change to any of the six
      capabilities takes the screenshot again
    - (c) accept it as it is, and say why
    - (d) leave it to a new idea, whose brief you write
  - **recommended:** (a), because it keeps your rule "a graphical change of the main app
    should always trigger a new screenshot" as the claim, and admits in the open where
    nothing holds it
  - **unblocks:** `CAP-root/readme` (reopened), `SPEC.md`
  - **raised by:** `q-freshness-held`'s answer, applied in step 2; the refinement-prover's
    "Not my call" in step 2
  - **answer:**
- **`q-root-uses-app`** — Does a uses: citation from the root's `README.md` onto app
  capabilities count as a dependency of the root on `app`, under
  `INV-root/module-dependency`?
  - **options:**
    - (a) no: `INV-root/module-dependency` governs modules' `build.gradle.kts` only, and the
      README is prose about the app, not a module; the module-contract-reviewer confirms it
      when the item lands
    - (b) yes, and the root contract is reopened to allow it
    - (c) take the uses: to another place than the README
    - (d) leave it to a new idea, whose brief you write
  - **recommended:** (a), because the invariant speaks only of `project(":<name>")`
    dependencies between modules, and the root builds nothing from the README
  - **unblocks:** `README.md`
  - **raised by:** `q-freshness-held`'s answer, applied in step 2; the refinement-prover's
    "Not my call" in step 2
  - **answer:**
