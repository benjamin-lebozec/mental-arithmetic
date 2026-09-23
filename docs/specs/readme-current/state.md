---
idea: readme-current
chain: trunk
step: 1
status: refining
waits on: none
remaining: 3q + 1r + 1i + 3f
---

# A README that shows the app as it is now

## Why

- **`why`** — The README's screenshot is out of date: it still shows the old keypad, 7 8 9
  on top, and no New button. A friend opening the repository sees an app that no longer
  exists.

## Requirements

- **`r-screenshot-current`** — The README's screenshot is taken again, so that it shows the
  app as it is now.

## To land

Nothing yet: every item here still waits on an open question.

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
  - **held in:** `README.md`, `.github/screenshot.png`
  - **status:** planned

## Success signal

Nothing yet: it waits on `q-validation`.

## Assumptions

- **`a-same-scene`** — The new screenshot shows the same scene as the one it replaces: a
  3-digit multiplication after the check, with wrong digits in red, taken on the emulator
  through `adb`. Only the app in it is current.
  - **raised by:** the brief: "update the screenshot so it does"
  - **bears on:** `r-screenshot-current`
- **`a-words-and-picture`** — "The README" covers both its words and its screenshot: both
  describe the app as it is now. The words are already true of the current app; only the
  picture and its alt text are stale.
  - **raised by:** the brief: "the README should reflect the current state of the app"
  - **bears on:** `CAP-root/readme`

## Files

- `SPEC.md` — holds: `CAP-root/readme` (reopened) — planned
- `README.md` — holds: `CAP-root/readme` (reopened) — planned
- `.github/screenshot.png` — holds: `r-screenshot-current` — planned

## Open Questions

- **`q-validation`** — How will we validate that it works?
  - **options:**
    - (a) a new screenshot is taken on the Android Studio emulator through `adb` and
      compared with the current app: 1 at the top left of the keypad, New in the count row;
      then you read the README on GitHub after the push
    - (b) the same, without reading it on GitHub: the local README and picture are checked
      only
  - **recommended:** (a), because the brief's first line names exactly what is stale (the
    keypad and the New button), and `CAP-root/readme` is judged "as GitHub shows it"
  - **unblocks:** `r-screenshot-current`, `CAP-root/readme`'s new success line, the
    success signal
  - **raised by:** step 1 always asks it; the brief's "it still shows the old keypad (7 8 9
    on top) and no New button"
  - **answer:**
- **`q-freshness-held`** — How is "the README reflects the current app" kept true by later
  changes? A capability's code is re-read in review only when a change touches it, and a
  change to the app's screen does not touch the README.
  - **options:**
    - (a) only in `CAP-root/readme`'s wording, as the brief says; a later change to the
      screen is caught only if someone notices
    - (b) the wording, and also a review-held invariant in `SPEC.md`, for instance
      `INV-root/readme-current`, which every full review walks, so a chain that changes the
      screen fails its last review until the screenshot is taken again
    - (c) the wording, and a `LIM-` in `SPEC.md` saying nothing checks the screenshot
      against later changes to the app
  - **recommended:** (b), because the freshness this brief restores was lost exactly
    because nothing walked the README when the screen changed
  - **unblocks:** `CAP-root/readme`'s new text, `SPEC.md`
  - **raised by:** the brief: "the README should reflect the current state of the app"
  - **answer:**
- **`q-alt-text`** — What does the README's alt text for the screenshot say? Today it names
  the operands of the old picture: "426 × 899 checked, with two wrong digits in red".
  - **options:**
    - (a) the scene without operands, for instance "a 3-digit multiplication after the
      check, wrong digits in red", so it stays true whichever pair the new picture shows
    - (b) the operands and errors of the new picture, as today
  - **recommended:** (a), because operands are one more detail that goes stale each time the
    picture is taken again
  - **unblocks:** `README.md`
  - **raised by:** the brief: "the README should reflect the current state of the app",
    through `a-words-and-picture`; the prover pointed it out under "Not my call" in step 1
  - **answer:**
