---
idea: no-zero-and-new
chain: trunk
step: 3
refines: step-2.md
---

# Step 3: land the no-0 draw, New in Enter's place after a correct check, and the reopened Try again

## This step

Lands everything step 2 settled. The draw now gives `A` and `B` with no 0 digit
(`CAP-multiplication/draw-operands`, reopened, in `multiplication/SPEC.md`). After a check
where no line carries a mark, New takes Enter's place (`CAP-app/new-when-correct`, new in
`app/SPEC.md`, with `a-new-as-new-pair` as its assumes line). Try again now appears only
after a check where some line carries a mark (`CAP-app/try-again`, reopened), and
`LIM-app/hidden-when-sideways` names the new capability. The README's screenshot is taken
again with a pair the new draw can pose. Nothing is settled under standing authorization.
`status: refining → done`, `remaining: 0q + 0r + 1i + 7f → 0q + 0r + 0i + 0f`.

## Changes

- **`CAP-app/new-when-correct`** — landed
  - **was:** planned, in `app/SPEC.md`, held in `Practice.kt` and `PracticeScreen.kt`
  - **now:** into `app/SPEC.md`, as written, with its assumes line from
    `a-new-as-new-pair`; `app/src/main/kotlin/mentalarithmetic/app/Practice.kt`
    (`correct`, `newPair`) and `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`
    (the New branch of `EndKey`) cite it with `[provides:]`
  - **verdict:** discharged
- **`CAP-multiplication/draw-operands`** (reopened) — landed
  - **was:** planned, the change as the plan wrote it
  - **now:** into `multiplication/SPEC.md`: claim and success replaced as the change says,
    the assumes line removed; `Operands.kt` draws each digit from 1 to 9; `OperandsTest.kt`
    also asserts no 0 digit in `A` and `B`, and its header says so
  - **verdict:** discharged
- **`CAP-app/try-again`** (reopened) — landed
  - **was:** planned, the change as the plan wrote it
  - **now:** into `app/SPEC.md`: claim and success replaced as the change says;
    `PracticeScreen.kt` shows Try again only when checked and not correct, its citation
    reworded to "after a check where some line carries a mark"
  - **verdict:** discharged
- **`LIM-app/hidden-when-sideways`** (reopened) — landed
  - **was:** planned, the change as the plan wrote it
  - **now:** into `app/SPEC.md`, its last sentence naming `CAP-app/new-when-correct` as the
    change says; no code
  - **verdict:** discharged
- **`a-new-as-new-pair`** — landed
  - **was:** the assumption, bearing on `CAP-app/new-when-correct`
  - **now:** that capability's assumes line in `app/SPEC.md`, "the new `A` and `B` have the
    digit count currently chosen."; `newPair` poses with `digitCount`
  - **verdict:** discharged
- **`multiplication/SPEC.md`**, **`Operands.kt`**, **`OperandsTest.kt`**, **`app/SPEC.md`**,
  **`Practice.kt`**, **`PracticeScreen.kt`** — closed: everything they hold has landed
  - **verdict:** discharged
- **`.github/screenshot.png`** — closed: taken again, a 3-digit `354 × 329` after the check,
  one wrong digit in a partial product and one in the result, in red, Try again in Enter's
  place; the README's words and alt text still match it
  - **verdict:** discharged
- **Plan sections** — To land, Reopened, Assumptions and Files now say "Nothing left to
  land.", "Nothing reopened.", "No assumptions left." and "No files left."; front matter
  `step: 3`, `status: done`, `remaining: 0q + 0r + 0i + 0f`
  - **verdict:** discharged

New in this step: none.

## Amendments

None.

## Demonstrations

Built with `./build.sh` (`gradle assembleDebug test` in Docker): BUILD SUCCESSFUL, log
`build.log` in the scratchpad. `:multiplication:test` ran: `OperandsTest` 1 test,
`CheckTest` 4, `PosedMultiplicationTest` 2, 0 failures. `app` has no unit tests
(`LIM-app/screens-by-manual-review`). Installed on `emulator-5554` through `adb.exe`, driven
by `input tap` on the nodes of `uiautomator dump`, captured with `screencap`.

- **`CAP-multiplication/draw-operands`** — "A JVM unit test, run in the Docker build,
  shows that for each n from 2 to 6, every one of 1000 draws gives `A` and `B` of exactly
  n digits, none of them a 0." `OperandsTest.everyDrawHasExactlyTheChosenDigitCount`
  loops n over 2..6, 1000 draws each, and asserts length n and no `'0'` in each of `A` and
  `B`: passed in the build above.
- **`CAP-app/new-when-correct`** — "a game is played through `adb` to a check where no line
  carries a mark, and the screenshot shows New in Enter's place; New is tapped, and the
  screenshot shows a new `A × B`." On `44 × 28`: 352, Enter, 88, Enter, 1232, Enter →
  checked, no mark, New in Enter's place, digit and erase keys greyed (`c2.png`). New
  tapped → `45 × 89`, lines empty, Enter back, count 2 still chosen (`c3.png`).
- **`CAP-app/try-again`** — "after a check where some line carries a mark, Try again is
  tapped through `adb`, and the screenshot shows the typed digits cleared and `A` and `B`
  unchanged." On `45 × 89`: 405, 360, then 4006 for 4005 → the result's last digit red,
  Try again in Enter's place (`c4.png`). Try again tapped → `45 × 89` unchanged, every line
  empty, Enter back (`c5.png`).
- **`.github/screenshot.png`** — at count 3, `354 × 329`: 3186, 718 (for 708), 1062, 116476
  (for 116466) → the 1 of the second line and the 7 of the result red, Try again in
  Enter's place (`shot3.png`, copied to `.github/screenshot.png`).

## Reviews

The change since the last review, one round: 45 items, all hold, none broken, restating or
undecidable. `LIM-app/hidden-when-sideways`, held by no code, holds of the tree: the
portrait lock and the remembered practice keep the game, and the multiplication's weighted
box is what a sideways letterbox leaves too short; judged by reading the code, with no
sideways capture. The README and its retaken screenshot match `CAP-app/try-again` and the
reopened draw. Noted, not findings: New can draw the same `A × B` again (1 in 6561 at 2
digits), and `CAP-multiplication/partial-products`' 0-digit case of `B` still holds of the
code but no longer reaches the screen. `CAP-app/new-when-correct` is not among the README's
doc: citations, as `LIM-root/screenshot-freshness` admits. Nothing fixed.

## Proof

- **re-proof of step-2** — skipped: nothing changed since step-2's commit before this run
- **rounds** — passed first time
- **matched** — discharged; every plan and spec diff is listed in Changes, and each entry
  shows in the diffs
- **coverage** — discharged; each abstract item has one fate, `why` and
  `s-no-zero-and-new` kept; handle searches found no untouched claim made false
- **no-widening** — discharged; each digit is drawn from 1 to 9; New only when checked with
  no mark
- **no-narrowing** — discharged; Try again's new precondition is its reopening, on the
  brief and `q-correct-means`
- **answers-applied** — discharged; no question open or closed
- **justified** — discharged; no new item, spec line or file
- **consistent** — discharged; New (no mark) and Try again (some mark) are disjoint and
  cover every checked state
- **settled** — discharged; every landed item was settled in step 2, none under standing
  authorization
- **landed** — discharged; claims declared once in their specs, cited under their
  directories, draw-operands demonstrated by `OperandsTest`, the app capabilities under
  `LIM-app/screens-by-manual-review`; the review passed
- **demonstrated** — discharged; the build ran `:multiplication:test`, all passing, and
  the screenshots answer each criterion as written
- **tree-kept** — discharged; every changed spec line and file belongs to a landed item
- **files** — discharged; every file closed, none shared with `readme-current`
- **progress** — discharged; five items landed
- **amendments** — discharged; none, and the reopenings stay within their authority
- **terminal** — discharged; only Why and Success signal left, `s-no-zero-and-new` shown by
  the three landed capabilities, and `LIM-app/hidden-when-sideways` confirmed by the review
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split
