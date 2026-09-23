---
idea: github-ci
chain: trunk
step: 4
refines: step-3.md
---

# Step 4: Admit both CI limits; they are settled and land next run

## This step

Applies the answer to `q-ci-limits`, (a): both limits are admitted as drafted. Each limit
gains a **held by:** line naming its demonstration, which makes it settled. The user chose
the option, so this was not a standing authorization. Both limits wait one run and land in
step-5, into `.github/workflows/SPEC.md`. Nothing in the tree changes.
`status: unproved → refining`, `remaining: 1q + 0r + 2i + 1f → 0q + 0r + 2i + 1f`.

## Changes

- **`q-ci-limits`** — answered
  - **was:** "The CI has two limits nobody decided: a run's APK can be downloaded for 90
    days only, and a private repository's Actions minutes are metered, so pushes stop being
    built once they run out. How are they handled?" Options (a) "Admit both as limits, as
    drafted", (b) "Make the repository public: …"; recommended (a).
  - **now:** answer "(a): \"Admit both (Recommended)\" (2026-09-23, in the conversation)".
    It keeps `LIM-ci/artifact-retention` and `LIM-ci/actions-minutes` as drafted, and
    reopens nothing. The Open Questions section now reads "No open questions:
    `q-ci-limits` was answered in step-4."
  - **verdict:** discharged
- **`LIM-ci/artifact-retention`** — kept, one line added
  - **was:** no **held by:** line
  - **now:** "**held by:** demonstration: `gh api` lists the run's artifact with an
    `expires_at` 90 days after its `created_at`". The claim, its `raised by:`, `lands in:`
    and `status: planned` are unchanged. It is now settled.
  - **verdict:** discharged
- **`LIM-ci/actions-minutes`** — kept, one line added
  - **was:** no **held by:** line
  - **now:** "**held by:** demonstration: `gh repo view` shows the repository private". The
    claim, its `raised by:`, `lands in:` and `status: planned` are unchanged. It is now
    settled.
  - **verdict:** discharged

New in this step: nothing.

## Amendments

None.

## Demonstrations

None.

## Reviews

None: nothing in the tree changed.

## Proof

- **re-proof of step-3** — skipped: only `q-ci-limits`' `answer:` line changed since
  step-3's commit
- **rounds** — passed first time
- **matched** — discharged; the plan's diff shows exactly the three Changes entries, and no spec changed
- **coverage** — discharged; the question is answered, both limits kept with their claims unchanged, the rest untouched
- **no-widening** — discharged; no claim text changed and nothing landed
- **no-narrowing** — discharged; admitting the limits rests on answer (a), and they are only planned
- **answers-applied** — discharged; (a) quoted, and it keeps both limits as drafted and reopens nothing
- **justified** — discharged; no new items; the `held by:` lines make the limits settled after (a)
- **consistent** — discharged; both demonstrations agree with `REQ-ci/github-repository` and `INV-ci/triggers`
- **settled** — n/a; nothing landed. Both limits are now settled for step-5
- **landed** — n/a; nothing landed. Step-3's open review finding carries to step-5, which must run the review and record that it passed
- **demonstrated** — n/a; nothing landed and no module changed
- **tree-kept** — n/a; nothing in the tree changed
- **files** — discharged; `.github/workflows/SPEC.md` kept, its open-for marks true, listed by no other chain in flight
- **progress** — discharged; `q-ci-limits` closed, no new question
- **amendments** — discharged; none made or claimed
- **terminal** — n/a
- **partition**, **independent**, **shared**, **cross-chain changes** — n/a

Not the prover's call, left for step-5's review: `LIM-ci/actions-minutes`' demonstration shows
the premise (the repository is private), not the metering itself.
