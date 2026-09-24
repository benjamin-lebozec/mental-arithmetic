---
label: no-zero-and-new step-3
scope: change (base is the last committed review)
base: ec76249fe8704a75c727a3b321420d2b9a26f985
fingerprint: d0e2bd252c3444a9
items: 45
result: clean
---

## Scope

- Scope `change`. Base `ec76249` (refine(doc-citations) step-3), found by
  `git log -1 --diff-filter=A --format=%H -- docs/reviews/`. Fingerprint `d0e2bd252c3444a9`.
- Changed shipped files (7): `.github/screenshot.png`, `app/SPEC.md`,
  `app/src/main/kotlin/mentalarithmetic/app/Practice.kt`,
  `app/src/main/kotlin/mentalarithmetic/app/PracticeScreen.kt`, `multiplication/SPEC.md`,
  `multiplication/src/main/kotlin/mentalarithmetic/multiplication/Operands.kt`,
  `multiplication/src/test/kotlin/mentalarithmetic/multiplication/OperandsTest.kt`. No
  untracked shipped files.
- Changed scaffolding and records (named, not reviewed): `.claude/agents/module-contract-reviewer.md`,
  `.claude/skills/refine/SKILL.md`, `docs/specs/no-zero-and-new/{state,step-0,step-1,step-2}.md`,
  untracked `docs/specs/no-zero-and-new/step-3.md`. `CLAUDE.md` is unchanged since the base,
  so no rule is widened.
- Touched ids:
  - declarations changed by the spec diffs: `CAP-multiplication/draw-operands` (claim and
    success altered, assumes removed), `CAP-app/try-again` (altered), `CAP-app/new-when-correct`
    (added), `LIM-app/hidden-when-sideways` (altered);
  - named by the prompt: the same four;
  - cited by changed files: Practice.kt (`CAP-app/right-to-left-entry` header,
    `CAP-app/pick-digit-count`, `CAP-app/check-at-end`, `CAP-app/try-again`,
    `CAP-app/new-when-correct`, uses of `CAP-multiplication/draw-operands`,
    `CAP-multiplication/partial-products`, `CAP-multiplication/check-lines`);
    PracticeScreen.kt (`CAP-app/posed-layout` header, `CAP-app/pick-digit-count`,
    `CAP-app/new-pair`, `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`,
    `CAP-app/try-again`, `CAP-app/new-when-correct`); Operands.kt and OperandsTest.kt
    (`CAP-multiplication/draw-operands`); `.github/screenshot.png`, an exempt asset, answers
    through the README line that loads it, so `CAP-root/readme`;
  - no id retired.
- Reviewed files (M-items 5 to 10): the 7 changed files, plus every file citing a touched id:
  `README.md`, `app/src/main/AndroidManifest.xml`, `MainActivity.kt`, `Check.kt`,
  `PosedMultiplication.kt`, `CheckTest.kt`, `PosedMultiplicationTest.kt`. No spec was added,
  moved or removed.
- Additions: none. No new module or file; the change only edits existing files, so there
  are no A-items.

## Checklist

### M

1. M declarations: collect namespaces and declared ids from the 4 SPEC.md files, and ids
   named in every `docs/specs/*/state.md`. — **holds**: namespaces root, app, multiplication,
   ci, distinct; every declared id's namespace matches its spec's (search per spec for ids
   outside its namespace: empty); `uniq -d` on the declarations: empty; the only plan-only
   id is `LIM-ci/actions-minutes` (github-ci plan, done), cited by no shipped file.
2. M files: the Files sections of every plan. — **holds**: every plan is `done` except
   readme-current (`refining`), whose Files list is "No files left"; no file is listed twice.
3. M forward: every CAP- has a provides; every code-held INV- has an enforces. — **holds**:
   the new `CAP-app/new-when-correct` is provided at Practice.kt:78, :81 and
   PracticeScreen.kt:217; every other CAP- keeps its provides (full citation grep); no INV-
   in the tree is held by code (all four root/app INV- and the ci ones are held by review).
4. M demonstrated: the added or altered CAP-s. — **holds**: `CAP-multiplication/draw-operands`
   is demonstrated by OperandsTest.kt:1, under multiplication/; `CAP-app/try-again` and
   `CAP-app/new-when-correct` have no demonstrates, and `LIM-app/screens-by-manual-review`
   says every app capability is shown only by manual review; `app/src` holds only `main`.
5. M backward: every cited id in the shipped tree against the declarations. — **holds**:
   `comm -23` of cited ids against declared ids: empty.
6. M path: provides/demonstrates in the reviewed files. — **holds**: app/ files cite only
   `CAP-app/*` (app/SPEC.md on their path), multiplication/ files only
   `CAP-multiplication/*`, README.md only `CAP-root/readme` (root SPEC.md).
7. M direction: uses/doc. — **holds**: uses name declared CAP-s: app → multiplication
   (Practice.kt:3-4), within app (PracticeScreen.kt:77), ci → root (build.yml:20, :23);
   multiplication uses nothing, so no cycle. README's six doc: name declared app CAP-s and
   are not counted.
8. M kind: — **holds**: provides/uses/doc name only CAP-; demonstrates only in the three
   multiplication test files; no test added (OperandsTest.kt is modified, cites no
   provides); grep for `[...: REQ-|NOT-|LIM-`: empty; README's header is `provides:`, its
   doc: sits beside it.
9. M coverage: headers of the reviewed files; the exempt asset. — **holds**: each reviewed
   code file's first line is a provides or demonstrates; the manifest's header is line 2
   after the XML prolog; README.md and the SPEC.md files are exempt. `.github/screenshot.png`
   is a PNG (1080 × 2400, RGBA), a format with no comment syntax; the line loading it,
   README.md:12, is covered by the header `CAP-root/readme`; it is image data only.
10. M severance: grep `\.claude|docs/|CLAUDE\.md|step-[0-9]|state\.md|reviews` over every
    shipped file. — **holds**: empty.

### D

11. D `CAP-app/pick-digit-count` over README.md and the screenshot. — **holds**: README
    says "Pick how many digits the numbers have"; the screenshot shows count buttons 2 to 6
    on top, 3 filled, and a 3-digit `354 × 329`.
12. D `CAP-app/new-pair` over README.md and the screenshot. — **holds**: the screenshot
    shows New at the end of the count row; the README's words do not describe it and say
    nothing contrary.
13. D `CAP-app/posed-layout` over README.md and the screenshot. — **holds**: `354`, `× 329`,
    three partial products 3186, 718(0), 1062(00) with the shifted zeros greyed, then the
    result, every digit in its column.
14. D `CAP-app/right-to-left-entry` over README.md and the screenshot. — **holds**: README
    "type each partial product and the result right to left"; the keypad reads 1 2 3 / 4 5 6
    / 7 8 9 / ⌫ 0 and the end key.
15. D `CAP-app/check-at-end` over README.md and the screenshot. — **holds**: README "wrong
    digits in red, missing or extra ones marked"; alt text "A 3-digit multiplication after
    the check, with wrong digits in red". Checked arithmetic: 354 × 2 = 708, typed 718 with
    the 1 in red; 354 × 329 = 116466, typed 116476 with the 7 in red; 3186 and 1062 right
    and unmarked. Digit and erase keys are shown greyed, as after the check.
16. D `CAP-app/try-again` over README.md and the screenshot. — **holds**: the claim is now
    Try again in Enter's place after a check where some line carries a mark; the screenshot
    shows exactly that, two lines marked and Try again in the end key's place. The digits
    of A and B carry no 0, as `CAP-multiplication/draw-operands` now draws them.

### C

17. C `CAP-root/readme`: README.md and `.github/screenshot.png`, reach 2. — **holds**: the
    screenshot is of the app as it now is (retaken; items 11 to 16); its assumes (a 3-digit
    multiplication after the check, wrong digits in red) match; the "why" lists the same six
    capabilities README.md:4-5 cites with doc:; the download link and install steps are
    unchanged.
18. C `INV-root/module-recognized` (review), against the changed files. — **holds**: no
    changed file is a settings or build file, and no module directory was added; the module
    list is unchanged.
19. C `INV-root/module-dependency` (review), against the changed files. — **holds**: the
    changed Kotlin files import only `mentalarithmetic.multiplication` (Practice.kt:10-14,
    PracticeScreen.kt:37-39), reached through `project(":multiplication")` in
    app/build.gradle.kts:34; multiplication imports nothing of app.
20. C `NOT-root/signing-key-in-repo`, against the changed files. — **holds**:
    `git ls-files | grep -iE '\.(jks|keystore)$'`: empty; no changed file is a keystore.
21. C `REQ-root/docker`, against the changed files. — **holds**: the change adds no host
    need; the build is unchanged.
22. C `REQ-root/network`, against the changed files. — **holds**: no new dependency or
    plugin in the change.
23. C `LIM-root/build-by-run`, against the changed files. — **holds**: the change adds no
    test of the build; the limit stands.
24. C `LIM-root/shown-by-hand`, against the changed files. — **holds**: the README and its
    screenshot are still checked only by reading; no test added for them.
25. C `LIM-root/screenshot-freshness`, against the changed files. — **holds**, and the
    change is an instance of it: `CAP-app/new-when-correct` puts New in Enter's place, and
    it is not among README's doc: citations, so the README would not be brought into review
    by a later change to it alone; the limit says exactly this ("a new element under a new
    capability is caught only once that capability is added"). The current screenshot shows
    the marked case, which the new capability does not alter.
26. C `CAP-app/pick-digit-count`: Practice.kt:18-19, :40-45; PracticeScreen.kt:58-73, reach
    2. — **holds**: each count button calls `pickDigitCount(digits)`, which draws and poses a
    new pair and clears the typing; at launch the count is 2.
27. C `CAP-app/new-pair`: PracticeScreen.kt:75-87, reach 1. — **holds**: New sits last in
    the count row and calls `pickDigitCount(practice.digitCount)` at any time; unchanged.
28. C `CAP-app/posed-layout`: AndroidManifest.xml, MainActivity.kt, PracticeScreen.kt
    header, :89-191, reach 3. — **holds**: the grid shows A, × B, the partial products and
    the result by column with greyed shifted zeros. Unchanged by the diff, whose only edit in
    this file is EndKey, which its own citations reclaim.
29. C `CAP-app/right-to-left-entry`: Practice.kt header, :25-31, :47-71, :91-95;
    PracticeScreen.kt:141-145, :193-210, :226-237, reach 2. — **holds**: digits append to the
    current line, Enter needs a digit, erase goes back across lines; the else branch of
    EndKey still shows Enter before the check. Practice.kt's header covers the new `newPair`
    and `correct` only where their own citations do not reclaim them, and they do.
30. C `CAP-app/check-at-end`: Practice.kt:33-38, :73-76; PracticeScreen.kt:147-158, reach
    2. — **holds**: the check runs only in `endResultLine`; marks shown red, boxed, struck.
    The assumes ("the digit and erase keys do nothing until Try again, a count button or New
    is tapped") still holds: `typeDigit`/`erase` return when checked, and the keys are
    disabled (PracticeScreen.kt:196); the end-key New also clears the check through
    `pickDigitCount`.
31. C `CAP-app/try-again`: Practice.kt:86-89; PracticeScreen.kt:212-224, reach 2. —
    **holds**: EndKey's `when` tests `correct` first, so Try again (line 221) shows only when
    checked and `marks` has some non-empty line, i.e. some line carries a mark; `tryAgain`
    clears typed and marks and leaves `posed`, so A and B are kept.
32. C `CAP-app/new-when-correct`: Practice.kt:78-84; PracticeScreen.kt:217-219, reach 2. —
    **holds**: `correct` is true only when marks is non-null and every line's mark list is
    empty (checked, no mark); New then takes the end key's place and calls `newPair`, which
    draws a new pair with the current `digitCount` (its assumes). Nothing under these
    citations serves another purpose.
33. C `INV-app/portrait-only` (review), against the changed app files. — **holds**: the
    manifest is unchanged (portrait, configChanges); nothing in Practice.kt or
    PracticeScreen.kt touches orientation or recreates the activity.
34. C `NOT-app/other-operations`, against the changed files. — **holds**: grep for other
    operations (`Addition|Subtract|Divis|minus|"÷"|"−"`) in app/src: empty (the one hit,
    `?.plus(1)` at PracticeScreen.kt:106, is a column count); the new code poses only
    multiplications.
35. C `NOT-app/check-while-typing`, against the changed files. — **holds**: `check(` occurs
    once, Practice.kt:75, in `endResultLine`; the new `correct` reads `marks`, null until
    then, so New cannot appear before the result line is ended.
36. C `REQ-app/arithmetic`, against the changed files. — **holds**: the changed files use
    `drawOperands`, `pose`/`digitsOf` and `check`/`Mark`, the three listed capabilities,
    and need nothing else of another module.
37. C `REQ-app/emulator-adb`, against the changed files. — **holds**: the new capability's
    success criterion is shown on the emulator through `adb`, as the requirement states; the
    retaken screenshot (1080 × 2400) is such a capture.
38. C `LIM-app/screens-by-manual-review`, against the changed files. — **holds**: no test
    drives the screen (app/src holds only main); the new `CAP-app/new-when-correct` is also
    shown only by review.
39. C `LIM-app/practice-lost-when-killed`, against the changed files. — **holds**: the
    practice is still held by `remember { Practice() }` (PracticeScreen.kt:46), not saved
    state.
40. C `LIM-app/hidden-when-sideways`: manifest, MainActivity.kt, Practice.kt,
    PracticeScreen.kt, app/build.gradle.kts, reach 5. — **holds**: the activity is locked to
    portrait and handles size changes itself (manifest:12-13), so held sideways it is
    letterboxed upright and not recreated, the `remember`ed practice kept. The screen is a
    Column of the count row, a `weight(1f)` box holding the multiplication, and a keypad of
    four 56 dp rows (PracticeScreen.kt:48-54, :195-209, :231), so a letterbox as short as a
    sideways phone leaves the weighted box too little height and the multiplication is what
    is lost. The list now names `CAP-app/new-when-correct`, whose New lives in the keypad's
    end key, shown only upright like the rest. Judged by reading; the sideways capture itself
    was not re-run here.
41. C `CAP-multiplication/draw-operands`: Operands.kt, OperandsTest.kt, Practice.kt (uses),
    reach 3. — **holds**: `drawNumber` builds n digits each from `nextInt(1, 10)`, so exactly
    n digits (the first is never 0) and none is 0; `require` keeps n in 2..6. OperandsTest
    asserts, for n in 2..6 and 1000 draws each, the length of A and B and that neither
    contains '0': the claim itself. Practice.kt draws through it at :22 and :43.
42. C `CAP-multiplication/partial-products`: PosedMultiplication.kt, its test, Practice.kt,
    PracticeScreen.kt (`digitsOf`), reach 4. — **holds**: `pose` gives one line per digit of
    B right to left with k shifted zeros, then the result; a 0 digit gives `[0]`, shown by
    the test with 5078. The claim is about `pose` for any A and B; that the app's draw no
    longer yields a 0 digit does not make it false.
43. C `CAP-multiplication/check-lines`: Check.kt, CheckTest.kt, Practice.kt,
    PracticeScreen.kt (`Mark`), reach 4. — **holds**: column by column from the right,
    WRONG, MISSING, EXTRA; a right line gives an empty list, which `correct` relies on.

### S

44. S app/SPEC.md changed lines. — **holds**: the try-again and new-when-correct lines are
    capability anchors and success criteria; the new-when-correct assumes records a decision
    (the digit count kept), not a file's content; the LIM line adds the new capability to a
    limit. None restates code.
45. S multiplication/SPEC.md changed lines. — **holds**: the anchor and success line of
    `CAP-multiplication/draw-operands`; the removed assumes is not an addition.

## Summary

- Counts: 45 items; holds 45, broken 0, restates 0, undecidable 0. Result `clean`.
- The fingerprint, run again at close, is `d0e2bd252c3444a9`, as at the start.
- Cost: 17 files read (the 7 changed, README.md, the manifest, MainActivity.kt, the two
  build files and settings.gradle.kts, Check.kt, PosedMultiplication.kt, CheckTest.kt,
  PosedMultiplicationTest.kt), and the screenshot viewed; 27 ids walked (12 touched ids
  over their whole reach, items 17, 26 to 32 and 40 to 43; 15 on the changed files' paths
  judged against those files only, items 18 to 25 and 33 to 39). No C-item's reach exceeds ten
  files; the widest is `LIM-app/hidden-when-sideways` at 5.
- No rule widened: `CLAUDE.md` is unchanged since the base.
- Not my call:
  - `newPair` (and the top New) can draw the same `A × B` again, since the draw is uniform
    and does not exclude the current pair; rare at 2 digits (1 in 6561) but possible.
  - `CAP-multiplication/partial-products` keeps its 0-digit case, which the app can no longer
    reach through `drawOperands`; still true of `pose`, but no longer seen on screen.
