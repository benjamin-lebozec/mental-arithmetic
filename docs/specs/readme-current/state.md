---
idea: readme-current
chain: trunk
step: 5
status: refining
waits on: none
remaining: 3q + 0r + 2i + 3f
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
  as uses:; a change that touches none of them does not take the screenshot again. A new
  element under a new capability is caught only once that capability is added to the
  README's uses:; a change of theme or colour that touches none of them is never caught by
  the uses:, and the screenshot is then retaken only by hand.
  - **decided by:** `q-uses-gap`'s answer, "Record a LIM (Recommended)" (2026-09-23);
    `q-theme-change`'s answer, "Say it's never caught (Recommended)" (2026-09-23);
    `q-limit-shown`'s answer, "Add a shown-by line (Recommended)" (2026-09-23)
  - **shown by:** review, reading the README's uses: against the app capabilities that shape
    the screen
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

- **`q-status-recorded`** — While step 5 was being proved, its record said
  `status: refining → refining` and the plan on disk still said `unproved`, the mark a plan
  carries until its proof is recorded. The plan now says `refining`, as the record does. Is
  anything more to be done about it?
  - **options:**
    - (a) take it into this chain: a later step records the drafting mark as well, for example
      `refining → unproved → refining`
    - (b) leave it to a new idea about how steps record status, whose brief you write
    - (c) accept it as it is: `unproved` is only the mark a run carries until its proof is
      recorded, and the plan and the record agree once it is
  - **recommended:** (c), because the two now agree, and the front matter is outside what the
    prover matches
  - **unblocks:** nothing in the plan: it concerns only step 5's record
  - **raised by:** the refinement-prover's "Not my call" in step 5
  - **answer:**
- **`q-no-question-left`** — Step 5's record says "With no question left, the reopened
  `CAP-root/readme`, the limit and the three files … are settled", but `q-status-recorded` is
  open. The conclusion holds, since that question unblocks nothing; the sentence is loose.
  - **options:**
    - (a) take it into this chain: a later step records that the sentence should have read
      "with no question left that they wait on"
    - (b) leave it to a new idea, whose brief you write
    - (c) accept it as it is: a committed step is never edited, and the plan, where no open
      question lists those items, already says they are settled
  - **recommended:** (c), because the plan is what the next run reads, and it is right
  - **unblocks:** nothing in the plan: it concerns only step 5's record
  - **raised by:** the refinement-prover's "Not my call" in step 5, round 2
  - **answer:**
- **`q-status-when-set`** — Step 5's Reviews and `q-status-recorded` say the plan's status
  was set to `refining` "as the proof was recorded", but the Proof section was still empty
  when it was set, so the order they describe is not the order it happened in.
  - **options:**
    - (a) take it into this chain: a later step records the order as it was
    - (b) leave it to a new idea about when a run sets the plan's status, whose brief you write
    - (c) accept it as it is: the status and the proof are committed together, so no committed
      state ever shows one without the other
  - **recommended:** (c), because only the committed state is ever read
  - **unblocks:** nothing in the plan: it concerns only step 5's record
  - **raised by:** the refinement-prover's "Not my call" in step 5, round 2
  - **answer:**
