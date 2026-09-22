---
idea: long-multiplication
chain: trunk
step: 1
refines: step-0.md
---

# Step 1: formalize the brief into four requirements, eight assumptions and five questions

## This step

Formalizes the brief. The tree is empty (no commit, no `SPEC.md`, no code), so nothing is
absorbed or reopened. Every statement of the brief becomes the Why, a requirement, an
assumption or a question. Nothing lands. The host has no JDK and no Android SDK, recorded as
`a-toolchain`.
`status: none → refining`, `remaining: none → 5q + 4r + 0i + 0f`.

## Changes

Each statement of the brief, quoted:

- **"i want a simple app to do mental arithmetic"** — refined
  - **now:** `why`, `r-practise-multiplication`
  - **raises:** `a-android`, `a-toolchain`
  - **verdict:** discharged
- **"mainly \"mutliplications\" at first"** — refined
  - **now:** `why`, `r-practise-multiplication`
  - **raises:** `q-other-operations`
  - **verdict:** discharged
- **"What special about the app is that : je vux que la multiplication soit posées comme
  lorsqu'on le fait à la main : AAAA x BBBB / CCCCCC + DDDDDD0 + EEEE00 / RESULT"** — refined
  - **now:** `why`, `r-posed-layout`
  - **raises:** `a-one-partial-per-digit`, `a-no-carries`, `q-shift-zeros`
  - **verdict:** discharged
- **"sur plusieurs lignes, avec les chiffres bien alignés les uns aux autres"** — refined
  - **now:** `why`, `r-posed-layout`
  - **verdict:** discharged
- **"Je veux pouvoi sélectinnr facilement la compléxité selon le nombre de chiffre de A et
  B (même valeur pour A et B)"** — refined
  - **now:** `r-choose-digit-count`
  - **raises:** `a-random-operands`, `q-digit-range`
  - **verdict:** discharged
- **"And i want to type the intermediate computes right to left, digit after digit,
  [enter] for next line"** — refined
  - **now:** `why`, `r-right-to-left-entry`
  - **raises:** `a-result-typed`, `a-onscreen-keypad`, `q-error-feedback`
  - **verdict:** discharged
- **"We can clarify few things, then build a mockup, then we'll refine"** — refined
  - **now:** `a-mockup-before-layout`; the clarifying is this step's questions
  - **verdict:** discharged

New in this step:

- **`q-validation`**
  - **justified by:** asked in every first step
  - **verdict:** discharged

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-0** — n/a; step-0 is the brief
- **rounds** — passed first time
- **matched** — discharged; all 18 plan items (Why, 4 r-, 8 a-, 5 q-) are in Changes and every Changes entry shows in the plan; no spec exists
- **coverage** — discharged; all 7 brief statements are quoted with a fate; the tree is empty, so nothing is absorbed or reopened
- **no-widening** — discharged; every inference (Kotlin/Compose, carries, partial count, random operands, keypad, typed result) is an assumption or a question
- **no-narrowing** — discharged; "easily", "mainly … at first", "same for both" and "[enter] for next line" are kept, and the digit range stays open
- **answers-applied** — discharged; no answers yet, `q-validation` asked with a recommended option
- **justified** — discharged; every assumption and question quotes the statement that raised it
- **consistent** — discharged; the tree holds no claims, and the items do not contradict each other
- **files** — discharged; the brief places no file, and the list is empty
- **settled**, **landed**, **demonstrated**, **tree-kept** — n/a in step 1
- **progress** — n/a in step 1
- **amendments** — n/a: none
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a: no split
