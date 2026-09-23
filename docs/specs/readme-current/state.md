---
idea: readme-current
chain: trunk
step: 3
status: refining
waits on: none
remaining: 4q + 0r + 2i + 3f
---

# A README that shows the app as it is now

## Why

- **`why`** — The README's screenshot is out of date: it still shows the old keypad, 7 8 9
  on top, and no New button. A friend opening the repository sees an app that no longer
  exists.

## Requirements

Nothing left: the one requirement became the reopened `CAP-root/readme`.

## To land

- **`LIM-root/screenshot-freshness`** — A change to the app's screen brings the README's
  screenshot into review only when it touches one of the app capabilities the README cites
  as uses:; a change that touches none of them, such as a new element under a new
  capability or a change of theme or colour, does not take the screenshot again unless that
  new capability is added to the README's uses:.
  - **decided by:** `q-uses-gap`'s answer, "Record a LIM (Recommended)" (2026-09-23)
  - **lands in:** `SPEC.md`
  - **status:** planned

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

- `SPEC.md` — holds: `CAP-root/readme` (reopened), `LIM-root/screenshot-freshness` — planned
- `README.md` — holds: `CAP-root/readme` (reopened); its header also cites, as uses:, the
  six app capabilities the screenshot shows; the screenshot's alt text names the scene
  without operands: "a 3-digit multiplication after the check, with wrong digits in red";
  its uses: are not a dependency of the root on `app` under `INV-root/module-dependency`,
  which governs only modules' `build.gradle.kts`, and the module-contract-reviewer confirms
  it when the file is written — planned
- `.github/screenshot.png` — holds: `CAP-root/readme` (reopened), its screenshot — planned

## Open Questions

- **`q-uses-duty`** — `q-uses-gap`'s answer said "a new app capability must add itself to
  those uses: to be covered". `LIM-root/screenshot-freshness` states it as a condition
  ("unless that new capability is added"), and no claim makes adding it a duty. Should that
  duty become a claim?
  - **options:**
    - (a) take it into this chain: a new review-held `INV-root/…` in `SPEC.md`, "every app
      capability that shapes how the screen looks is cited as uses: in `README.md`"
    - (b) leave it to a new idea, whose brief you write
    - (c) accept it as it is: the limit states the gap in the open, and that is enough
  - **recommended:** (c), because `q-freshness-held` was answered "uses: citations, no INV",
    and a duty held by review would be that invariant under another name
  - **unblocks:** `LIM-root/screenshot-freshness`, `SPEC.md`
  - **raised by:** `q-uses-gap`'s answer, applied in step 3; the refinement-prover's "Not my
    call" in step 3
  - **answer:**
- **`q-theme-change`** — For a change of theme or colour, the limit's "unless that new
  capability is added to the README's uses:" has no new capability to refer to. Should the
  limit say how such a change is ever caught, or that it never is?
  - **options:**
    - (a) take it into this chain: reword `LIM-root/screenshot-freshness` so it says that a
      change of theme or colour that touches none of the six capabilities is never caught
      by the uses:, and the screenshot is then retaken only by hand
    - (b) leave it to a new idea, whose brief you write
    - (c) accept it as it is, and say why
  - **recommended:** (a), because it makes the limit true of every case it names, at the
    cost of one clause
  - **unblocks:** `LIM-root/screenshot-freshness`, `SPEC.md`
  - **raised by:** `q-uses-gap`'s answer, applied in step 3; the refinement-prover's "Not my
    call" in step 3
  - **answer:**
- **`q-dependency-recorded`** — `q-root-uses-app`'s decision, that the README's uses: are
  not a dependency under `INV-root/module-dependency`, lives only in the `README.md` Files
  line and the reviewer's verdict when the file is written, and leaves the plan when it
  lands. Should it also land in `SPEC.md`, so later reviews over the whole tree see it?
  - **options:**
    - (a) take it into this chain: add it to the reopened `CAP-root/readme`'s why: in
      `SPEC.md`
    - (b) leave it to a new idea, whose brief you write
    - (c) accept it as it is: `INV-root/module-dependency` already speaks only of a
      module's `build.gradle.kts`, so a later review reads the same answer from it
  - **recommended:** (c), because a second line saying what the invariant's own text says
    would only repeat the tree
  - **unblocks:** `CAP-root/readme` (reopened), `README.md`, `SPEC.md`
  - **raised by:** `q-root-uses-app`'s answer, applied in step 3; the refinement-prover's
    "Not my call" in step 3
  - **answer:**
- **`q-limit-shown`** — A limit is settled once it says how it is held, and
  `LIM-root/screenshot-freshness` does not; neither do the `LIM-root/…` lines already in
  `SPEC.md`. Should it gain a line saying how it is shown?
  - **options:**
    - (a) take it into this chain: add "shown by: review, reading the README's uses: against
      the app capabilities that shape the screen" to the limit
    - (b) leave it to a new idea, whose brief you write
    - (c) accept it as it is: every `LIM-` is reviewed by demonstration by its kind, as the
      limits already in `SPEC.md` are
  - **recommended:** (a), because it costs one line and lets the limit meet `settled` as
    written, rather than by an exception
  - **unblocks:** `LIM-root/screenshot-freshness`, `SPEC.md`
  - **raised by:** `q-uses-gap`'s answer, applied in step 3; the refinement-prover's "Not my
    call" in step 3
  - **answer:**
