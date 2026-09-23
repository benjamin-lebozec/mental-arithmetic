---
idea: new-pair-and-keypad
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: land CAP-app/new-pair, the 1-at-top-left keypad, and the check-at-end and sideways-limit updates; chain done

## This step

Lands everything step-2 settled; no question, answer or amendment is new. `CAP-app/new-pair`
lands in `app/SPEC.md`, held by a New button at the end of the count row in
`PracticeScreen.kt`, with `a-new-pair-same-count` as its `assumes:` line. The reopened
`CAP-app/right-to-left-entry` lands with the keypad reordered 1 2 3 / 4 5 6 / 7 8 9, its
success criterion extended, and `a-phone-order` in its `assumes:` line;
`a-bottom-row-kept` is absorbed by its parenthesis. The reopened `CAP-app/check-at-end` and
`LIM-app/hidden-when-sideways` land as step-2 worded them. Nothing was settled under
standing authorization.
`status: refining → done`, `remaining: 0q + 0r + 4i + 3f → 0q + 0r + 0i + 0f`.

## Changes

- **`CAP-app/new-pair`** — landed
  - **now:** into `app/SPEC.md`, as written, with the `assumes:` line "the new `A` and `B`
    have the digit count currently chosen."; held by `NewButton` in
    `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`, which
    `[provides: CAP-app/new-pair]` and `[uses: CAP-app/pick-digit-count]`, and is placed at
    the end of the `CountButtons` row
  - **verdict:** discharged
- **`CAP-app/right-to-left-entry`** (reopened) — landed
  - **now:** in `app/SPEC.md`, the parenthesis reads "(1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter)";
    the success criterion ends "…and the screenshots show each digit where it was typed;
    and a screenshot shows the keypad with 1 at the top left."; the `assumes:` line opens
    "the digit rows are ordered as on a phone; " before its unchanged text (rewrapped). In
    `PracticeScreen.kt`, `Keypad`'s rows and its header comment read 1 2 3 / 4 5 6 / 7 8 9
  - **verdict:** discharged
- **`CAP-app/check-at-end`** (reopened) — landed
  - **now:** in `app/SPEC.md`, its `assumes:` line reads "after the check, the digit and
    erase keys do nothing until Try again, a count button or New is tapped."; the comment
    on `typeDigit` in `Practice.kt` reads "…until Try again, a count or New is tapped."
    New clears the check through `pickDigitCount`, which clears the typed digits and marks.
  - **verdict:** discharged
- **`LIM-app/hidden-when-sideways`** (reopened) — landed
  - **now:** in `app/SPEC.md`, its list reads "what `CAP-app/pick-digit-count`,
    `CAP-app/new-pair` and `CAP-app/try-again` pose hold only while it is upright." (rewrapped)
  - **verdict:** discharged
- **`a-phone-order`** — landed, reworded, in the `assumes:` line of
  `CAP-app/right-to-left-entry`: "the digit rows are ordered as on a phone"; the row order
  itself is in the anchor's parenthesis
  - **verdict:** discharged
- **`a-bottom-row-kept`** — absorbed by the landed anchor of `CAP-app/right-to-left-entry`,
  whose parenthesis ends "/ ⌫ 0 Enter)"; an `assumes:` clause would only repeat it
  - **verdict:** discharged
- **`a-new-pair-same-count`** — landed, as the `assumes:` line of `CAP-app/new-pair`
  - **verdict:** discharged
- **`app/SPEC.md`**, **`app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`**,
  **`app/src/main/kotlin/mentalarithmetic/app/Practice.kt`** — closed: everything they
  hold has landed
  - **verdict:** discharged
- Plan sections To land, Reopened, Assumptions and Files now say they are empty; front
  matter `step: 3`, `status: done`, `remaining: 0q + 0r + 0i + 0f`.

## Amendments

None.

## Demonstrations

APK built with `./build.sh` (`gradle assembleDebug test` in Docker): BUILD SUCCESSFUL, log
`build.log` in the scratchpad. `app` has no unit tests (every app capability is shown by
manual review, `LIM-app/screens-by-manual-review`); `multiplication` is unchanged. Installed
on `emulator-5554` through `adb.exe`, driven by `input tap`, read with `uiautomator dump`
and `screencap`.

- **`CAP-app/new-pair`** — "New is tapped through `adb`, once while a line is being typed
  and once after the check, and the screenshot after each tap shows a new `A × B` of the
  same digit count."
  - while typing: count 2, `25 × 29` with lines typed and "72" on the result line; New →
    `81 × 62`, lines empty, count 2 still filled (`s4.png`). Again at count 4: `× 8016`
    with a digit typed; New → `× 4976`, four digits (`s10.png`).
  - after the check: `81 × 62` checked, Try again shown (`s8.png`); New → `31 × 58`, lines
    empty, Enter back in Try again's place, count 2 filled (`s9.png`).
- **`CAP-app/right-to-left-entry`** — "each partial product and the result are typed …
  right to left with Enter after each, and erased back across a line already ended, and
  the screenshots show each digit where it was typed; and a screenshot shows the keypad
  with 1 at the top left."
  - on `81 × 62`: 162, Enter, 486 → lines `162` and `4860` with the 0 grey (`s5.png`);
    four erases → line 2 empty, cursor back on line 1 (`s6.png`), a 9 then lands left of
    `162`; erased, Enter, 486, Enter, 5022 → `162`, `4860`, `5022` each digit in its column
    (`s7.png`); Enter → checked, no mark, every line right (`s8.png`).
  - `s8.png` and `s9.png` show the keypad as 1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0 Enter, 1 at the top
    left, and New at the end of the count row.
- **`CAP-app/check-at-end`** (reopened `assumes:`) — in `s8.png`, after the check, the digit
  and erase keys are greyed; New then gives a typeable line (`s9.png`).

## Reviews

`module-contract-reviewer`, scope `full`, base a332b4d. Git has no commit since the last
full review that a step does not account for. First pass (declaration, forward,
demonstrated, backward, path, direction, kind, coverage, severance, files): clean. Every
claim walked holds: the four ids this step touched, every `NOT-`, review-held `INV-`,
`REQ-` and `LIM-`. That includes `LIM-app/hidden-when-sideways` as reworded (portrait lock
and one-column layout unchanged, New in the count row), and
`LIM-app/screens-by-manual-review`, which covers `CAP-app/new-pair` having no test. Not `holds`:

- **restates:** the new `assumes:` clause of `CAP-app/right-to-left-entry` repeated the
  anchor's parenthesis ("1 2 3 / 4 5 6 / 7 8 9 … bottom row stays ⌫ 0 Enter"). Fixed
  before the second proof: the clause now reads "the digit rows are ordered as on a
  phone", and `a-bottom-row-kept` is absorbed by the anchor. The reviewer re-checked the
  reworded clause: it holds, no longer restates, and no other verdict changes.
- **undecidable:** `REQ-ci/github-repository`, `REQ-ci/debug-key-secret`; `gh` was not
  run. This change touches neither.
- **not a claim:** `.github/screenshot.png`, shown by the README, still has the old keypad
  and no New button. `CAP-root/readme` asks only for a screenshot, so it holds; the
  picture is stale, and it is outside this chain's files.

## Proof

- **re-proof of step-2** — skipped: nothing changed since step-2's commit (a332b4d); the
  diff was empty and no `answer:` line was written
- **rounds** — two
  - round 1: all discharged, except `landed` and `terminal`, undecidable while Reviews was
    empty; the reviewer's "restates" finding was fixed (the `assumes:` clause reworded,
    `a-bottom-row-kept` absorbed)
  - round 2: all discharged; the prover asked that the reviewer's pass on the reworded
    clause be recorded, which Reviews now does
- **matched** — discharged; the plan's and `app/SPEC.md`'s diffs show exactly the Changes
- **coverage** — discharged; every abstract item landed, absorbed or closed, `why` and
  `s-new-pair-and-keypad` kept untouched
- **no-widening** — discharged; spec texts are step-2's, New only poses a pair, the keypad
  only reorders its digit rows
- **no-narrowing** — discharged; New has no guard, Try again and the counts still clear
  the check, every key is kept
- **answers-applied** — discharged; no question closed in this step
- **justified** — discharged; no new item or spec line, no unaccounted code
- **consistent** — discharged; the reopened `assumes:` of `CAP-app/check-at-end` admits
  New, and `NOT-app/check-while-typing` is untouched
- **settled** — discharged; everything landed was settled in step-2, none under standing
  authorization
- **landed** — discharged; each id is declared once in `app/SPEC.md`, the citations sit
  under `app/`, `LIM-app/screens-by-manual-review` covers `CAP-app/new-pair`, and the
  review is recorded as passing
- **demonstrated** — discharged; screenshots s4, s8, s9 and s10 checked against both
  criteria; `./build.sh` passed, and `:app:testDebugUnitTest` has no source
- **tree-kept** — discharged; `CAP-app/pick-digit-count` and `CAP-app/posed-layout` still
  hold
- **files** — discharged; all three files closed, no other chain in flight
- **progress** — discharged; four items and three assumptions landed or absorbed
- **amendments** — discharged; none
- **terminal** — discharged; only `why` and `s-new-pair-and-keypad` are left, shown by
  `CAP-app/new-pair` and `CAP-app/right-to-left-entry`; the reviewer records
  `LIM-app/hidden-when-sideways` as true of the tree
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a
