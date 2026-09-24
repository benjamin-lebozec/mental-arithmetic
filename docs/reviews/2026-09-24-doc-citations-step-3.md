---
label: doc-citations step-3
scope: full (bootstrap: no review report has ever been committed on master, so there is no base)
base: none (bootstrap)
fingerprint: ea2cbd5f5eab4e21
items: 63
result: 1 not holds
---

## Checklist

### Scope facts

- Scope: `full`. `git log -1 --diff-filter=A --format=%H -- docs/reviews/` returns nothing
  on master, and `docs/reviews/` does not exist in the working tree. (A commit `da254e9 demo
  base` touching `docs/reviews/` exists in `--all`, outside master's history; it is not a
  base for this tree.) So every shipped file and every id is reviewed.
- Base: none. Fingerprint computed with the empty tree (`4b825dc…`) standing for `<base>`:
  `ea2cbd5f5eab4e21`. (Against HEAD, 8eef9e2, the same recipe gives `65256b11a9722cb6`.)
- Changed shipped files since HEAD (the step's own change): `README.md` (six `[uses:]` to
  `[doc:]`), `SPEC.md` (`CAP-root/readme` why: line; `LIM-root/screenshot-freshness` text
  and shown by:). In full scope, all 25 shipped files are reviewed.
- Changed scaffolding (named, not reviewed): `docs/specs/doc-citations/state.md` (modified),
  `docs/specs/doc-citations/step-3.md` (untracked). CLAUDE.md is unchanged since HEAD; it
  gained the `doc:` form in 8eef9e2, and in full scope every rule, `doc:` included, runs
  over every shipped file anyway.
- Shipped files (25): `.github/screenshot.png`, `.github/workflows/SPEC.md`,
  `.github/workflows/build.yml`, `.gitignore`, `Dockerfile`, `README.md`, `SPEC.md`,
  `app/SPEC.md`, `app/build.gradle.kts`, `app/src/main/AndroidManifest.xml`,
  `app/src/main/kotlin/mentalarithmetic/app/{MainActivity,Practice,PracticeScreen}.kt`,
  `build.gradle.kts`, `build.sh`, `gradle.properties`, `multiplication/SPEC.md`,
  `multiplication/build.gradle.kts`, `multiplication/src/main/.../{Check,Operands,PosedMultiplication}.kt`,
  `multiplication/src/test/.../{CheckTest,OperandsTest,PosedMultiplicationTest}.kt`,
  `settings.gradle.kts`.

### Touched ids

- Named by the prompt and altered by the SPEC.md diff: `CAP-root/readme` (why: line),
  `LIM-root/screenshot-freshness` (text and shown by:).
- Cited with `doc:` by the changed README: `CAP-app/pick-digit-count`, `CAP-app/new-pair`,
  `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`, `CAP-app/check-at-end`,
  `CAP-app/try-again`.
- Full scope walks every id in the tree regardless (38 ids, 4 specs).

### Items

M-items (every shipped file, every spec, every plan; `git grep` over the shipped pathspec):

1. M declarations: namespaces unique, id namespaces match, no duplicate, no plan-only id
   cited. Grep of `**\`ID\`**` in the four specs, front matter, cited ids.
2. M forward: every `CAP-` has `provides:`; every code-held `INV-` has `enforces:`.
3. M demonstrated: every altered `CAP-`/code-held `INV-` has a `demonstrates:` or a
   manual-review `LIM-`. Only `CAP-root/readme` is altered.
4. M backward: every cited id declared.
5. M path: `provides:`/`enforces:`/`demonstrates:` name only ids on the file's path.
6. M direction: `uses:` names declared `CAP-`s; module dependencies form no cycle; `doc:`
   not counted.
7. M kind: form/kind pairing; no `REQ-`/`NOT-`/`LIM-` cited; `demonstrates:` only in tests;
   `doc:` never a header citation.
8. M coverage: every shipped file has a header citation; exempt assets checked.
9. M severance: no shipped file names `.claude/`, `docs/`, `CLAUDE.md`, a step or plan.
10. M files: no file in two in-flight plans' Files lists (`docs/specs/*/state.md`).

D-items (README.md, text, header and `.github/screenshot.png` viewed):

11. D `CAP-app/pick-digit-count` over README.md.
12. D `CAP-app/new-pair` over README.md.
13. D `CAP-app/posed-layout` over README.md.
14. D `CAP-app/right-to-left-entry` over README.md.
15. D `CAP-app/check-at-end` over README.md.
16. D `CAP-app/try-again` over README.md.

C-items, root `SPEC.md` (reach = files judged):

17. C `CAP-root/docker-build`: citing files, reach 9 (8 providers + build.yml uses).
18. C `CAP-root/debug-key`: build.sh lines 9-28 and build.yml use, reach 2.
19. C `CAP-root/readme` (touched): README.md and the screenshot, reach 2.
20. C `INV-root/module-recognized` (review): settings.gradle.kts and top-level dirs, reach 3.
21. C `INV-root/module-dependency` (review): every module's build.gradle.kts, reach 2.
22. C `NOT-root/signing-key-in-repo`: search over every non-spec shipped file, reach 21.
23. C `REQ-root/docker`: host fact plus build files, reach 21.
24. C `REQ-root/network`: Dockerfile, settings.gradle.kts, reach 21.
25. C `LIM-root/build-by-run`: reach 9.
26. C `LIM-root/shown-by-hand`: reach 4 (build.sh, build.yml, README, screenshot).
27. C `LIM-root/screenshot-freshness` (touched): README header against app capabilities and
    the app files that shape the screen, reach 7.

C-items, `app/SPEC.md`:

28. C `CAP-app/pick-digit-count` (touched): Practice.kt, PracticeScreen.kt, reach 2.
29. C `CAP-app/new-pair` (touched): PracticeScreen.kt, reach 1.
30. C `CAP-app/posed-layout` (touched): MainActivity.kt, PracticeScreen.kt, manifest, reach 3.
31. C `CAP-app/right-to-left-entry` (touched): Practice.kt, PracticeScreen.kt, reach 2.
32. C `CAP-app/check-at-end` (touched): Practice.kt, PracticeScreen.kt, reach 2.
33. C `CAP-app/try-again` (touched): Practice.kt, PracticeScreen.kt, reach 2.
34. C `INV-app/portrait-only` (review): manifest, PracticeScreen.kt, reach 5 (app files).
35. C `NOT-app/other-operations`: search over app and multiplication, reach 11.
36. C `NOT-app/check-while-typing`: search over app/src, reach 3.
37. C `REQ-app/arithmetic`: app/build.gradle.kts, Practice.kt imports, reach 5.
38. C `REQ-app/emulator-adb`: host fact, reach 5.
39. C `LIM-app/screens-by-manual-review`: search for app tests, reach 5.
40. C `LIM-app/practice-lost-when-killed`: PracticeScreen.kt state holder, manifest, reach 5.
41. C `LIM-app/hidden-when-sideways`: PracticeScreen.kt layout, manifest, reach 5.

C-items, `multiplication/SPEC.md`:

42. C `CAP-multiplication/draw-operands`: Operands.kt, OperandsTest.kt, reach 2.
43. C `CAP-multiplication/partial-products`: PosedMultiplication.kt and its test, reach 2.
44. C `CAP-multiplication/check-lines`: Check.kt, CheckTest.kt, reach 2.

C-items, `.github/workflows/SPEC.md`:

45. C `CAP-ci/github-build`: build.yml, reach 1.
46. C `CAP-ci/release-on-push`: build.yml, reach 1.
47. C `INV-ci/one-build-path` (review): build.yml, reach 1.
48. C `INV-ci/fails-on-failure` (review): build.yml, build.sh, reach 2.
49. C `INV-ci/triggers` (review): build.yml `on:`, reach 1.
50. C `INV-ci/release-only-master-push` (review): build.yml release `if:`, reach 1.
51. C `REQ-ci/github-repository`: `git remote -v`, `gh repo view`, reach 1.
52. C `REQ-ci/debug-key-secret`: `gh secret list`, reach 1.
53. C `LIM-ci/build-by-run`: reach 1.
54. C `LIM-ci/artifact-retention`: build.yml upload step, reach 1.
55. C `LIM-ci/release-by-hand`: reach 1.

A-items, additions to the root's open part (modules `app/`, `multiplication/`):

56. A `app/` against the addition rule and `INV-root/module-recognized`.
57. A `app/` against `INV-root/module-dependency`.
58. A `app/`: spec or in-flight plan carries a `REQ-` naming the contract, if built as an
    addition.
59. A `multiplication/` against the addition rule and `INV-root/module-recognized`.
60. A `multiplication/` against `INV-root/module-dependency`.
61. A `multiplication/`: `REQ-` naming the contract, if built as an addition.

S-items, the one changed spec (`SPEC.md`), its changed lines:

62. S `CAP-root/readme` why: line 39 (and the list it introduces, 40-42).
63. S `LIM-root/screenshot-freshness` lines 85-90.

## Checks

- 1 holds: namespaces `root`, `app`, `multiplication`, `ci`, one per spec; each of the 38
  declared ids carries its spec's namespace; no id declared twice; all 41 cited ids
  (`git grep -noE '\[(provides|uses|enforces|demonstrates|doc): …\]'`) are declared in a
  spec; the two in-flight plans (doc-citations, readme-current) declare no new id.
- 2 holds: every one of the 14 `CAP-`s has at least one `provides:` (list above); all six
  `INV-`s are held by review, so none needs `enforces:`.
- 3 holds: the only altered `CAP-`/`INV-` is `CAP-root/readme`; it has no test, and
  `LIM-root/shown-by-hand` says it is shown only by hand (reading the README on GitHub).
- 4 holds: every cited id is among the 38 declared.
- 5 holds: root-level files provide `CAP-root/*`; `app/build.gradle.kts` and
  `multiplication/build.gradle.kts` provide `CAP-root/docker-build` (root is a parent);
  `.github/workflows/build.yml` provides `CAP-ci/*` (spec in its directory); app and
  multiplication files provide/demonstrate their own namespace.
- 6 holds: `uses:` targets are all declared `CAP-`s. Module edges: app -> multiplication
  (Practice.kt; `project(":multiplication")`), ci -> root (build.yml), app -> app internal
  (NewButton uses pick-digit-count). No cycle. README's six `doc:` edges to app are not
  counted.
- 7 holds: `provides:`/`uses:`/`doc:` name only `CAP-`; no `enforces:` exists; the three
  `demonstrates:` are in `multiplication/src/test/` and name `CAP-`s; no `REQ-`/`NOT-`/`LIM-`
  is bracketed (bare mentions of `INV-root/module-recognized` in settings.gradle.kts:22 and
  `INV-app/portrait-only` in the manifest are prose). README's header citation is
  `[provides: CAP-root/readme]`; its six `[doc:]` sit beside it.
- 8 holds: all 21 non-spec shipped files carry a header citation (first line, or second
  after `#!/bin/sh` / `<?xml ?>`). `.github/screenshot.png` is an image asset, loaded by
  README.md line 8, which the README's `provides: CAP-root/readme` header covers; it is a
  plain 1080x2400 PNG, nothing executable.
- 9 holds: `git grep -nE '\.claude|docs/|CLAUDE\.md|step-[0-9]|state\.md|\bplan\b'` over the
  shipped pathspec returns nothing. "review" in SPEC.md shown by:/held by: lines names the
  role, not a document.
- 10 holds: the two plans not `done` (doc-citations `unproved`, readme-current `refining`)
  both say "No files left".
- 11 holds: the screenshot shows the count buttons 2-6 on top, 3 filled, over a 3-digit
  `405 × 186`; README's words ("Pick how many digits the numbers have") match.
- 12 holds: New sits at the end of the count row in the screenshot.
- 13 holds: `405`, `× 186`, three partial products with `+`, a rule, the result, digits in
  columns, shifted zeros greyed (one in the second line, two in the third).
- 14 holds: keypad 1 2 3 / 4 5 6 / 7 8 9 / ⌫ 0, 1 at top left; README says "type each
  partial product and the result right to left". Digit and erase keys are shown disabled,
  as after the check.
- 15 holds: 405x8 = 3240 typed as 3340 with the wrong 3 red; 405x186 = 75330 typed as 75320
  with the wrong 2 red; README: "wrong digits in red, missing or extra ones marked".
- 16 holds: Try again takes Enter's place in the screenshot.
- 17 holds: build.sh builds the image and runs `gradle --no-daemon assembleDebug test` in
  it; Dockerfile carries JDK 17, Gradle 8.10.2, SDK 35; the Gradle files, .gitignore,
  gradle.properties serve that build and nothing else.
- 18 holds: build.sh 14-28 decodes `DEBUG_KEYSTORE` into
  `.gradle/android-home/debug.keystore`, sets the default aside and restores it; unset or
  empty leaves the default key. build.yml passes the secret only to `./build.sh`.
- 19 holds: README says what the app is, shows the screenshot, links
  `releases/latest/download/mental-arithmetic.apk` (the name build.yml publishes), and gives
  install steps from outside the Play Store. The screenshot is current (item 11-16). "As
  GitHub shows it" and "takes the screenshot again" are carried by `LIM-root/shown-by-hand`
  and `LIM-root/screenshot-freshness`, which say where they are not held by the tree.
- 20 holds: settings.gradle.kts 23-26 includes every top-level directory with both
  `build.gradle.kts` and `SPEC.md` and names none; on disk those are `app/` and
  `multiplication/` (loop over top-level dirs).
- 21 holds: `git grep 'project('` finds only `app/build.gradle.kts:36`
  `project(":multiplication")`; multiplication has no project dependency; no cycle.
- 22 holds: `git ls-files | grep -iE '\.(jks|keystore|p12)$'` and the untracked equivalent
  are empty; `.gradle/` is in .gitignore.
- 23 holds: `docker --version` gives 28.5.1; build.sh needs only Docker, sh, `id` and
  `base64` from the host (the last only with the secret), no JDK or SDK.
- 24 holds: Dockerfile `wget`s Gradle and the SDK; settings.gradle.kts resolves from
  google()/mavenCentral()/gradlePluginPortal().
- 25 holds: no test runs build.sh (only three JVM tests in multiplication).
- 26 holds: no test covers the key or the README.
- 27 holds: the README carries exactly the six `doc:` citations the new text names; the
  review rule brings the README in only when one of them is touched, as the limit says.
  A change of theme outside those capabilities' files (none exists today: the theme lives
  in MainActivity.kt and the manifest, both citing `CAP-app/posed-layout`) would not be
  caught, as it says.
- 28 holds: `CountButtons` iterates `DIGIT_COUNTS` (2..6) at the top; `pickDigitCount`
  always draws a new pair, even for the current count; `digitCount` starts at 2.
- 29 holds: `NewButton` ends the count row and calls `pickDigitCount(digitCount)`, not gated
  by `checked`.
- 30 holds: `PosedGrid` draws A, × B, rule, partial products with `+`, rule, result, each
  keyed by column from the right; `lineCells` greys shifted zeros; no carries drawn.
  MainActivity and the manifest only launch that screen.
- 31 holds: `Keypad` rows as claimed; `typeDigit` appends (drawn at `shiftedZeros + i`, so
  right to left); `enter` refuses an empty line; `erase` drops the last digit, or on an
  empty line drops it and returns to the previous line's end; cursor underlined.
- 32 holds: `enter` on the last line calls `endResultLine` -> `check`; `markCells` draws
  WRONG red, EXTRA red struck, MISSING boxed red; digit and erase keys disabled and
  no-op after the check.
- 33 holds: `EndKey` swaps Enter for Try again when checked; `tryAgain` clears typed and
  marks, keeps `posed`.
- 34 holds: manifest `screenOrientation="portrait"` and
  `configChanges="orientation|screenSize|screenLayout|smallestScreenSize"`.
- 35 holds: `git grep -nE 'divi|subtract|minus|addition|Operation|plus\('` over app and
  multiplication finds only `?.plus(1)` in a column count (PracticeScreen.kt:106), no
  operation.
- 36 holds: `check(` is called only at Practice.kt:75 in `endResultLine`; marks are drawn
  only when non-null (PracticeScreen.kt:150).
- 37 holds: app imports `drawOperands`, `pose`, `check` from multiplication through
  `project(":multiplication")`; the rest it needs is Compose/AndroidX libraries under the
  docker-build REQs.
- 38 holds: `/mnt/c/Users/Benjamin/AppData/Local/Android/Sdk/platform-tools/adb.exe`
  exists.
- 39 holds: no `app/src/test` or `app/src/androidTest` sources.
- 40 holds: `remember { Practice() }`, not `rememberSaveable`; configChanges does not cover
  uiMode, locale or fontScale.
- 41 holds: the grid sits in a `weight(1f)` box between the count row and a fixed-height
  keypad, so a short letterbox leaves it no height; state survives (item 34).
- 42 holds: `drawOperands` draws in `[10^(n-1), 10^n)`; OperandsTest asserts exactly n
  digits over 1000 draws for each n.
- 43 holds: `pose` maps B's digits right to left with k shifted zeros, `digitsOf(0)` is
  `[0]`; PosedMultiplicationTest checks 1234 × 5078 (0 digit) and 47 × 36.
- 44 holds: `checkLine` compares from the right, WRONG/MISSING/EXTRA as claimed; CheckTest
  asserts each of the four success cases.
- 45 holds: build.yml checks out, runs `./build.sh`, uploads
  `app/build/outputs/apk/debug/*.apk` with `if-no-files-found: error`.
- 46 holds: release step copies `app-debug.apk` to `mental-arithmetic.apk`,
  `gh release create build-$GITHUB_RUN_NUMBER … --latest`; `contents: write` serves it.
- 47 holds: `grep -nE 'setup-java|gradle|sdk' build.yml` is empty.
- 48 holds: the build step is `./build.sh` (`set -eu`, last command `docker run`), whose
  exit status the EXIT trap does not replace.
- 49 holds: `on: push, pull_request, workflow_dispatch`, no filters.
- 50 holds: `if: github.event_name == 'push' && github.ref == 'refs/heads/master'`.
- 51 holds: `origin` is github.com/benjamin-lebozec/mental-arithmetic; `gh repo view`
  gives `PUBLIC`.
- 52 holds: `gh secret list` names `DEBUG_KEYSTORE`.
- 53 holds: no test runs the workflow.
- 54 holds: the upload step sets no `retention-days`, so the default applies (the `gh api`
  expiry was not re-read in this review).
- 55 holds: no test runs the release.
- 56 holds: `app/` holds `build.gradle.kts` and `SPEC.md` and is included by the settings
  loop.
- 57 holds: its only project dependency is `project(":multiplication")`; no cycle.
- 58 holds: `app/` was landed in the same chain and step (b5ed1e1) that declared the root
  contract, so it was refined with the contract, not added under it; the rule does not
  apply. (`REQ-app/arithmetic` does name the project dependency.)
- 59 holds: `multiplication/` holds both files and is included.
- 60 holds: no project dependency.
- 61 holds: as 58, landed with the contract in b5ed1e1.
- 62 restates: the changed why: line reads "the README cites, with doc:, the six app
  capabilities its screenshot shows", followed by the six ids. The list is a second copy of
  README.md's header citations, and "so a change to any of them brings the README into that
  change's review" now repeats what the method's `doc:` form does. The step changed the
  word but kept the copy; readme-current's open `q-why-restates` already asks about it.
- 63 holds: the limit's new wording states what the tree cannot promise (theme changes
  outside the cited capabilities, new capabilities not yet cited); it restates no file.

## Summary

- Counts: 62 holds, 1 restates, 0 broken, 0 undecidable.
- Item 62, `restates`: `SPEC.md` line 39-42, `CAP-root/readme` why: "the README cites,
  with doc:, the six app capabilities its screenshot shows, `CAP-app/pick-digit-count`,
  `CAP-app/new-pair`, `CAP-app/posed-layout`, `CAP-app/right-to-left-entry`,
  `CAP-app/check-at-end` and `CAP-app/try-again`, so a change to any of them brings the
  README into that change's review." The tree states the same list in README.md lines 4-5
  (`[doc: …]` × 6), and the review consequence is the `doc:` form's own rule. The two lists
  will drift when an app capability is added to the README. Looked at: `git diff HEAD --
  SPEC.md`, README.md lines 1-5.
- Cost: 25 shipped files read (all; the screenshot viewed), 38 ids walked, 4 specs.
  C-items with reach over ten files, widest first: `NOT-root/signing-key-in-repo` 21,
  `REQ-root/docker` 21, `REQ-root/network` 21, `NOT-app/other-operations` 11. The three
  root ones sit at the root because they are about the whole build; the app `NOT-` reaches
  into multiplication only because the search was run there too.
- Rules widened: none separately. The scope is full (bootstrap), so every rule, including
  the `doc:` form added to CLAUDE.md in 8eef9e2, ran over every shipped file.
- Not my call:
  - The screenshot still carries a grey tab at the top centre of the status bar, likely an
    emulator overlay (already readme-current's `q-screenshot-overlay`).
  - build.yml uses `actions/checkout@v7` and `actions/upload-artifact@v7`; whether those
    major versions exist was not checked here.
  - No review report has been committed on master yet, so this one will be the first base.
