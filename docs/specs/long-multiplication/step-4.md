---
idea: long-multiplication
chain: trunk
step: 4
refines: step-3.md
---

# Step 4: carry the conversation's decisions into the plan, so step 5 lands them all

## This step

No question was open and nothing changed since step-3's commit. A trial landing of every
settled item, with its review and its run on the emulator, surfaced decisions the user then
made in the conversation: an amendment moving the app's demonstrations to Claude, through
`adb`; a portrait lock, which narrows the app's capabilities to the upright device; the
launch count; and six claims the landed code needs. `CAP-root/docker-build` cannot land
without `LIM-root/build-by-run`, and every build file cites it, so nothing lands in this
step. The trial's files are out of the tree; the next run lands every item, each now
settled. `status: refining → refining`, `remaining: 0q + 1r + 16i + 21f → 0q + 1r + 22i +
21f`.

## Changes

- **`CAP-app/pick-digit-count`** — amended
  - **was:** "  - **success:** On the Android Studio emulator on Windows, the user taps each count
    from 2 to 6, the current one too, and each tap poses a new `A × B` with that many
    digits."
  - **now:** "  - **success:** On the Android Studio emulator on Windows, each count from 2 to 6
    is tapped through `adb`, the current one too, and the screenshot after each tap shows
    a new `A × B` with that many digits." and a new line "  - **assumes:** at launch, the
    count is 2, as if it had been tapped."
  - **verdict:** discharged
- **`CAP-app/posed-layout`** — amended
  - **was:** "  - **success:** On the Android Studio emulator on Windows, for each count from 2 to
    6, the user sees `A`, `× B`, one line per digit of `B` and the result line, every digit
    in its column and the shifted zeros greyed."
  - **now:** "  - **success:** On the Android Studio emulator on Windows, for each count from 2 to
    6, the screenshots taken through `adb` show `A`, `× B`, one line per digit of `B` and
    the result line, every digit in its column and the shifted zeros greyed." Its intent is
    unchanged; `LIM-app/hidden-when-sideways` names it among the capabilities that hold
    only while the device is upright
  - **verdict:** discharged
- **`CAP-app/right-to-left-entry`** — amended
  - **was:** "  - **success:** On the Android Studio emulator on Windows, the user types each
    partial product and the result right to left with Enter after each, and erases back
    across a line they already ended."
  - **now:** "  - **success:** On the Android Studio emulator on Windows, each partial product
    and the result are typed through `adb`, right to left with Enter after each, and erased
    back across a line already ended, and the screenshots show each digit where it was
    typed."
  - **verdict:** discharged
- **`CAP-app/check-at-end`** — amended
  - **was:** "  - **success:** On the Android Studio emulator on Windows, the user ends the
    result line and is shown which digits are wrong, missing or extra."
  - **now:** "  - **success:** On the Android Studio emulator on Windows, the result line is
    ended through `adb`, and the screenshot shows which digits are wrong, missing or
    extra."
  - **verdict:** discharged
- **`CAP-app/try-again`** — amended
  - **was:** "  - **success:** On the Android Studio emulator on Windows, after the check, the
    user taps Try again, their digits are cleared, and `A` and `B` are unchanged."
  - **now:** "  - **success:** On the Android Studio emulator on Windows, after the check, Try
    again is tapped through `adb`, and the screenshot shows the typed digits cleared and
    `A` and `B` unchanged."
  - **verdict:** discharged
- **`LIM-app/screens-by-manual-review`** — amended
  - **was:** "Every capability of the app is shown only by the user's review on the Android
    Studio emulator on Windows; no test drives the screen."
  - **now:** "Every capability of the app is shown only by a review of the running app on the
    Android Studio emulator on Windows: the APK is installed, the screen tapped and
    captured through that emulator's `adb`, and the screenshots judged. No test drives the
    screen, and nobody but the reviewer of those screenshots judges it."
  - **verdict:** discharged
- **`s-practised-on-emulator`** — amended
  - **was:** "On the Android Studio emulator on Windows, the user installs the APK the Docker
    build produced, picks a digit count from 2 to 6, and is shown `A × B` posed by hand,
    every digit aligned and the shifted zeros greyed. They type each partial product and
    the result right to left, with Enter after each line, are shown at the end which digits
    are wrong, and Try again clears their digits and keeps `A` and `B`. The user judges each
    screen there, so every screen criterion lands with a limit saying it is shown only by
    manual review."
  - **now:** "On the Android Studio emulator on Windows, the APK the Docker build produced is
    installed through `adb`, a digit count from 2 to 6 is picked, and `A × B` is shown posed
    by hand, every digit aligned and the shifted zeros greyed. Each partial product and the
    result are typed right to left, with Enter after each line, the end shows which digits
    are wrong, and Try again clears the digits and keeps `A` and `B`. Claude drives the app
    through `adb` and judges each screen from its screenshots, so every screen criterion
    lands with a limit saying it is shown only by that review."
  - **verdict:** discharged
- **`a-apk-to-windows`** — amended
  - **was:** "The Docker build writes the APK into the repository's build output, which the
    user reaches from Windows through `\\wsl$` and installs by dragging it onto the
    emulator."
  - **now:** "The Docker build writes the APK into the repository's build output, from which
    it is installed on the Android Studio emulator on Windows through `adb`."
  - **verdict:** discharged
- **`a-build-versions`** — refined
  - **was:** "…and JUnit 4.13.2 for the JVM tests. There is no Gradle wrapper: the image
    carries Gradle."
  - **now:** "…and JUnit 4.13.2 for the JVM tests. The image installs build-tools 34.0.0, the
    version Android Gradle Plugin 8.7.3 asks for, and the app hosts Compose with
    `activity-compose` 1.9.3. There is no Gradle wrapper: the image carries Gradle."
  - **verdict:** discharged
- **`SPEC.md`** (file) — refined
  - **was:** "holds: `CAP-root/docker-build`, `REQ-root/docker`, `INV-root/module-recognized`,
    `INV-root/module-dependency` — planned"
  - **now:** also holds `REQ-root/network` and `LIM-root/build-by-run`
  - **verdict:** discharged
- **`app/SPEC.md`** (file) — refined
  - **was:** "holds: `CAP-app/pick-digit-count`, `CAP-app/posed-layout`,
    `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`, `CAP-app/try-again`,
    `REQ-app/arithmetic`, `NOT-app/other-operations`, `NOT-app/check-while-typing`,
    `LIM-app/screens-by-manual-review` — planned"
  - **now:** also holds `INV-app/portrait-only`, `REQ-app/emulator-adb`,
    `LIM-app/practice-lost-when-killed` and `LIM-app/hidden-when-sideways`
  - **verdict:** discharged
- **`app/src/main/AndroidManifest.xml`** (file) — refined
  - **was:** "holds: `CAP-app/posed-layout` — planned"
  - **now:** "holds: `CAP-app/posed-layout`, `INV-app/portrait-only` (held by review) —
    planned"
  - **verdict:** discharged

New in this step:

- **`REQ-root/network`** — lands in `SPEC.md`
  - **justified by:** `CAP-root/docker-build`: its build downloads Gradle and the Android
    SDK when the image is built, and the plugins and libraries when Gradle runs, which
    `REQ-root/docker` does not say. Review of the trial landing found it.
  - **verdict:** discharged
- **`LIM-root/build-by-run`** — lands in `SPEC.md`
  - **justified by:** `CAP-root/docker-build`: a capability lands with a test that
    demonstrates it or a limit saying how it is shown, and no test runs the build. Review
    of the trial landing found it.
  - **verdict:** discharged
- **`INV-app/portrait-only`** — lands in `app/SPEC.md`, held by review over
  `AndroidManifest.xml`
  - **justified by:** the user's answer to review's finding that a rotation lost the
    practice: "Actually lock in portrait. No need to keep state if Android kills thé app"
    (2026-09-23, in the conversation). The trial showed that on this emulator Android
    letterboxes a portrait-locked app instead of turning it, and still recreated the
    activity until it declared that it handles size changes itself; the holding line says
    both.
  - **verdict:** discharged
- **`LIM-app/practice-lost-when-killed`** — lands in `app/SPEC.md`
  - **justified by:** the same answer, "No need to keep state if Android kills thé app".
    Review of the trial found that a change other than a rotation (dark mode, language,
    font size) also recreates the screen and loses the practice; the limit says so too.
  - **verdict:** discharged
- **`LIM-app/hidden-when-sideways`** — lands in `app/SPEC.md`: "Held sideways, the app
  is shown upright in a letterbox too short for the multiplication, which is hidden until
  the device is turned upright again, the practice kept: `CAP-app/posed-layout`, the lines
  typed under `CAP-app/right-to-left-entry`, the marks of `CAP-app/check-at-end`, and what
  `CAP-app/pick-digit-count` and `CAP-app/try-again` pose hold only while it is upright."
  - **justified by:** the user's answer "Admit it as a LIM (Recommended)" (2026-09-23, in
    the conversation), when the trial showed the upright letterbox, held sideways, too
    short for the multiplication.
  - **verdict:** discharged
- **`REQ-app/emulator-adb`** — lands in `app/SPEC.md`
  - **justified by:** the amendment below, whose confirmed wording included it: the app's
    demonstrations reach the emulator through `adb`.
  - **verdict:** discharged

## Amendments

- **The app's demonstrations are Claude's** — the five `CAP-app/*` success lines,
  `LIM-app/screens-by-manual-review` and `s-practised-on-emulator`, and the new
  `REQ-app/emulator-adb`; `a-apk-to-windows` follows the confirmed "installed through
  `adb`", which it otherwise contradicted. From the conversation, the user's words: "since you're able to
  tak screenshots and check by yourself, amend the item saying that this is my
  responsability". The old and new texts were put to the user and confirmed: "Confirm as
  worded (Recommended)" (2026-09-23, in the conversation).
- **The launch count** — `CAP-app/pick-digit-count`'s `assumes:` line. Review of the trial
  found that at launch a 2-digit `A × B` is posed, and no claim said so. The user's answer:
  "Claim it: starts at 2 (Recommended)" (2026-09-23, in the conversation).
- **The app's capabilities, narrowed by the portrait lock** — `CAP-app/posed-layout`,
  `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`, `CAP-app/pick-digit-count` and
  `CAP-app/try-again` hold only while the device is upright: held sideways, the whole
  multiplication, with the lines typed and the marks, is hidden. Their texts are unchanged;
  `LIM-app/hidden-when-sideways` names them. The user's words: "Actually lock
  in portrait. No need to keep state if Android kills thé app", then, shown the hidden
  multiplication, "Admit it as a LIM (Recommended)" (2026-09-23, in the conversation). The
  user first answered the rotation question "Fix it now", and changed it before anything
  was written.
- **This step's shape** — the prover of the trial found that the decisions above were not
  settled in a committed plan, so could not land in the step that made them. The user
  chose "Restructure into two steps" (2026-09-23, in the conversation).

## Demonstrations

None: nothing landed. The trial landing's runs (the Docker build, 7 of 7 unit tests passed,
and every app criterion on the emulator through `adb`) are not evidence for any step; the
next run demonstrates every criterion again on what it lands.

## Reviews

None: nothing in the tree changed. The trial landing's two full reviews found what the
new items and amendments above answer.

## Proof

- **re-proof of step-3** — skipped: nothing changed since step-3's commit
- **rounds**
  - round 1 (on the trial landing, before the restructure): `settled` failed, since the
    trial landed decisions made in the conversation; the user chose to restructure into
    two steps
  - round 2: `matched`, `coverage`, `no-narrowing`, `consistent` failed: `a-apk-to-windows`
    still said the APK is dragged onto the emulator; Changes paraphrased a scope for
    `CAP-app/posed-layout` found in no plan line; the portrait lock's reach over the other
    four app capabilities was unrecorded. Fixed: `a-apk-to-windows` amended,
    `LIM-app/hidden-when-sideways` names the five capabilities it bounds, Changes quotes
    only plan text
  - round 3: passed
- **matched** — discharged; all 18 changes in the plan's diff are in Changes with exact
  quotes, and every entry shows in the diff; no spec exists
- **coverage** — discharged; each changed item has one true fate; handle searches found no
  untouched item made false, wider or narrower
- **no-widening** — discharged; the rewritten criteria check at least what they replaced
- **no-narrowing** — discharged; the portrait lock and the `adb` demonstrations narrow only
  under amendments quoting the user
- **answers-applied** — discharged; no question was open, none closed
- **justified** — discharged; each of the six new items names its answer or the item that
  needs it
- **consistent** — discharged; `INV-app/portrait-only` with both new app limits,
  `REQ-app/emulator-adb` with `a-toolchain`, `a-apk-to-windows` with
  `s-practised-on-emulator`
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a; nothing landed, no file in
  the tree changed
- **files** — discharged; 18 kept, 3 refined, none `to write`, no other chain
- **progress** — discharged; six new items with final ids and landing places
- **amendments** — discharged; each quotes old and new text and where the user decided it
- **terminal** — n/a; status is `refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; trunk, no split
- **not the prover's call, for the next run's review:** whether the manifest attributes
  holding `INV-app/portrait-only`, under the manifest's `CAP-app/posed-layout` header, meet
  coverage; and the launch count, which the user said to "Claim", lands as an `assumes:`
  line of `CAP-app/pick-digit-count`
