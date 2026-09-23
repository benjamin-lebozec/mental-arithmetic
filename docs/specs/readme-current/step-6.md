---
idea: readme-current
chain: trunk
step: 6
refines: step-5.md
---

# Step 6: land the reopened `CAP-root/readme`, `LIM-root/screenshot-freshness` and a new screenshot; seven questions from review and proof

## This step

`q-status-recorded`, `q-no-question-left` and `q-status-when-set` are answered (c), accept as
is; they produce no item. The reopened `CAP-root/readme` and `LIM-root/screenshot-freshness`,
settled in step 5, land in `SPEC.md`, held in `README.md` and a new
`.github/screenshot.png`; both assumptions land with the capability. Nothing is settled and
landed under standing authorization. Nothing is left to land, but review and proof raised
ten questions (`q-step1-status`, `q-why-restates`, `q-screenshot-overlay`,
`q-retake-wording`, `q-demo-wording`, `q-answers-in-step`, `q-github-render`,
`q-header-wording`, `q-demo-options`, `q-unblocks-done`), so the chain is not yet `done`.
`status: refining → refining`, `remaining: 3q + 0r + 2i + 3f → 10q + 0r + 0i + 0f`.

## Changes

- **`q-status-recorded`** — answered
  - **was:** the question as step 5 left it, with an empty `answer:`
  - **now:** "(c): "Accept as is (Recommended)" (2026-09-23, in the conversation)"; no item
  - **verdict:** discharged
- **`q-no-question-left`** — answered
  - **was:** the question as step 5 left it, with an empty `answer:`
  - **now:** "(c): "Accept as is (Recommended)" (2026-09-23, in the conversation)"; no item
  - **verdict:** discharged
- **`q-status-when-set`** — answered
  - **was:** the question as step 5 left it, with an empty `answer:`
  - **now:** "(c): "Accept as is (Recommended)" (2026-09-23, in the conversation)"; no item
  - **verdict:** discharged
- **`LIM-root/screenshot-freshness`** — landed
  - **now:** into `SPEC.md`, under Known limits, as written, with its `shown by:` line as
    the limit's own `shown by:`; its `decided by:` and `lands in:` lines stay in the record
  - **verdict:** discharged
- **`CAP-root/readme`** (reopened) — landed
  - **now:** into `SPEC.md`, replacing the old text with the will-say as written, split into
    the claim, `success:`, `why:` and `assumes:` lines; held in `README.md` (its header adds
    the six `[uses:]` citations, and the screenshot's alt text becomes "A 3-digit
    multiplication after the check, with wrong digits in red") and `.github/screenshot.png`
    (retaken)
  - **verdict:** discharged
- **`a-same-scene`** — landed
  - **was:** "The new screenshot shows the same scene as the one it replaces: a 3-digit
    multiplication after the check, with wrong digits in red, taken on the emulator through
    `adb`. Only the app in it is current."
  - **now:** into `SPEC.md`, as `CAP-root/readme`'s `assumes:` ("the screenshot shows a
    3-digit multiplication after the check, with wrong digits in red, taken on the Android
    Studio emulator through `adb`"); the screenshot shows that scene
  - **verdict:** discharged
- **`a-words-and-picture`** — landed
  - **was:** "\"The README\" covers both its words and its screenshot: both describe the app
    as it is now. The words are already true of the current app; only the picture and its
    alt text are stale."
  - **now:** into `SPEC.md`, in `CAP-root/readme`'s claim: "the words and the screenshot
    show the app as it is now"; the words are unchanged, the picture and alt text replaced
  - **verdict:** discharged
- **`SPEC.md`** — closed
  - **was:** "holds: `CAP-root/readme` (reopened), `LIM-root/screenshot-freshness` — planned"
  - **verdict:** discharged
- **`README.md`** — closed
  - **was:** "holds: `CAP-root/readme` (reopened); its header also cites, as uses:, the six
    app capabilities the screenshot shows; the screenshot's alt text names the scene without
    operands: …; its uses: are not a dependency of the root on `app` under
    `INV-root/module-dependency`, which governs only modules' `build.gradle.kts`, and the
    module-contract-reviewer confirms it when the file is written — planned"
  - **verdict:** discharged
- **`.github/screenshot.png`** — closed
  - **was:** "holds: `CAP-root/readme` (reopened), its screenshot — planned"
  - **verdict:** discharged
- **Section placeholders** — kept: To land, Reopened, Assumptions and Files each say in one
  line that nothing is left.

New in this step:

- **`q-step1-status`**
  - **justified by:** the refinement-prover's `terminal` failure in step 6: step 1's quoted
    "Not my call" line never became a question
  - **verdict:** discharged
- **`q-why-restates`**
  - **justified by:** the module-contract-reviewer's `restates` verdict on
    `CAP-root/readme`'s `why:` line, disputed (see Reviews) and put to the user
  - **verdict:** discharged
- **`q-screenshot-overlay`**, **`q-retake-wording`**
  - **justified by:** the module-contract-reviewer's two "Not my call" lines in step 6
  - **verdict:** discharged
- **`q-demo-wording`**, **`q-answers-in-step`**, **`q-github-render`**
  - **justified by:** the refinement-prover's three "Not my call" lines in step 6
  - **verdict:** discharged
- **`q-header-wording`**, **`q-demo-options`**, **`q-unblocks-done`**
  - **justified by:** the refinement-prover's three "Not my call" lines in step 6, round 2
  - **verdict:** discharged

## Amendments

The reopened `CAP-root/readme`: its authority is the brief, "amend the readme capability to
add that the README should reflect the current state of the app", and the answers its
`decided by:` line quoted. No user edit since step 5's commit other than `answer:` lines.

## Demonstrations

- **`CAP-root/readme`** — success: "The README, as GitHub shows it, says what the app is,
  shows a screenshot of the app's screen as it is now, and says how to install an APK from
  outside the Play Store; its link downloads the latest `.apk`, which installs by hand on a
  real phone."
  - `./build.sh` rebuilt the debug APK from the tree (62 tasks up to date, BUILD SUCCESSFUL;
    log `build.log` in the scratchpad). It was installed on the Android Studio emulator
    through `adb`, 3 digits picked, and 405 × 186 entered with 3340 for the second partial
    product and 75320 for the result, then checked. `adb exec-out screencap` took the
    screenshot now at `.github/screenshot.png`. Looking at it: count buttons 2 to 6 and New
    in one row, 3 selected; the multiplication posed with its shift zeros in grey; the 3 of
    33400 and the 2 of 75320 in red; the keypad reads 1 2 3 on top, Try again in Enter's
    place. The scene is the one `assumes:` names, and it shows `s-screenshot-current`.
  - The README's words are unchanged and still true of the app; the alt text now names the
    scene without operands. The link, the install steps and a real-phone install are
    unchanged since the capability last landed; the whole criterion, read on GitHub, is
    shown only by hand, as `LIM-root/shown-by-hand` already says.
- No Gradle module changed and no root build file, so no module's tests are required; the
  build above ran every module's JVM unit tests anyway, all up to date and passing.

## Reviews

- **module-contract-reviewer**, scope full (the chain was headed for `done`). No commit
  touching a shipped file since the last full review. Every rule of the mechanical pass
  holds. Every claim walked holds, `CAP-root/readme` and `LIM-root/screenshot-freshness`
  included. It confirms the README's `[uses:]` are no dependency under
  `INV-root/module-dependency`, which governs only modules' `build.gradle.kts`. It also
  confirms that the six `[uses:]` are exactly `app`'s capabilities and cover every file that
  shapes the screen.
  - **`CAP-root/readme` `why:` line: `restates`.** It repeats the six `[uses:]` in
    `README.md`'s header. Disputed: the line is part of the will-say settled in step 5 under
    `q-freshness-held`, and taking it out would change a claim the user decided. Put to the
    user as `q-why-restates`.
  - "Not my call" (module-contract-reviewer): "The screenshot has a light grey rectangle at the top centre of the status bar, over the clock area and roughly 340-560 px wide in the displayed image. It is not part of the app, and looks like an emulator overlay." → `q-screenshot-overlay`
  - "Not my call" (module-contract-reviewer): "`CAP-root/readme` says a change to how the screen looks "takes the screenshot again". Nothing in the tree does that on its own: it depends on review noticing a `uses:` match, as the limit says." → `q-retake-wording`
- **refinement-prover**, round 1: every Changes entry and file discharged. `landed` was
  undecidable until the review was recorded. `terminal` failed on step 1's "Not my call"
  line, which never became a question; it is now `q-step1-status`, and the plan is no
  longer `done`.
  - "Not my call" (refinement-prover): "Step-6's Demonstrations says "the 3 of 33400", but 33400 has two 3s. The red one is the second (hundreds place)." → `q-demo-wording`
  - "Not my call" (refinement-prover): "The three answers now survive only in step-6's quotes. The plan dropped them with the questions, and the committed abstract plan has empty `answer:` lines." → `q-answers-in-step`
  - "Not my call" (refinement-prover): ""As GitHub shows it" has not been looked at for this change, since nothing is pushed yet. `LIM-root/shown-by-hand` covers this, but nobody is named to check the rendered README after the push." → `q-github-render`
- **refinement-prover**, round 2: every entry discharged; `landed` undecidable until
  `q-why-restates` is answered (see Proof).
  - "Not my call" (refinement-prover): "The `README.md` header also says "so a change to any of them retakes it". That is the same wording `q-retake-wording` questions in the spec claim, and option (a) there rewords only the claim, so the header would keep the old wording." → `q-header-wording`
  - "Not my call" (refinement-prover): "`q-demo-wording` lists options (a) and (c) with no (b)." → `q-demo-options`
  - "Not my call" (refinement-prover): "`q-step1-status` and several other new questions give only "the chain's `done`" under `unblocks:`, not any plan item." → `q-unblocks-done`

## Proof

- **re-proof of step-5** — skipped: only `answer:` lines changed since step 5's commit
- **rounds** — three
  - round 1: `landed` undecidable (review not yet recorded); `terminal` failed on step 1's
    unanswered "Not my call" line. Fixed by recording the review and turning every "Not my
    call" line, and that failure, into a question; the plan stays `refining`.
  - round 2: `landed` undecidable on the review's `restates` finding; three "Not my call"
    lines became questions.
  - round 3: no new finding.
- **matched** — discharged; the plan's diff (answered and landed items out, ten questions in)
  and `SPEC.md`'s diff each match a Changes entry, both ways
- **coverage** — discharged; every abstract item and file has its true fate
- **no-widening** — discharged; both landed spec texts are word for word as planned
- **no-narrowing** — discharged; the README's words, link and install steps are unchanged
- **answers-applied** — discharged; three questions closed with (c), no item; the drafter
  closes none of the ten new ones
- **justified** — discharged; each new question names the finding that raised it
- **consistent** — discharged; the claim and the limit read together as step 5 accepted
- **settled** — discharged; everything landed was settled in step 5, no standing
  authorization used
- **landed** — undecidable; every part holds and the review is recorded, but its `restates`
  verdict on `CAP-root/readme`'s `why:` line waits on `q-why-restates`
- **demonstrated** — discharged; the build, the emulator run and the screenshot answer the
  criterion; no Gradle module or root build file changed
- **tree-kept** — discharged; only lines of the landed items changed
- **files** — discharged; all three closed, none listed by another chain
- **progress** — discharged; three questions closed, four items landed
- **amendments** — discharged; no amended item, the user edited only `answer:` lines
- **terminal** — n/a; the plan says `refining`
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a; no split
