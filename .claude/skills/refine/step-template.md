---
idea: {idea}
chain: {trunk | <branch>, or <branch>/<sub-branch>}
step: {N}
refines: {step-{N-1}.md; for a branch's first step, ../step-{N-1}.md}
---

<!--
FORMAT RULES

- A step records one refinement: what it changed in the chain's plan (`state.md`, beside
  it), what it landed in the tree, and how that was proved. It lists only what changed.
  Every item and file it does not name is kept unchanged, which the diffs show.
- The abstract side is `state.md` and the tree as they stood at step-{N-1}'s commit.
- No tables anywhere: it is read as raw Markdown. Use bullets and nested bullets.
- Quote old plan text in full wherever the step changes it. A landed item's text is in its
  `SPEC.md` diff: quote it only if it landed reworded.
- Once committed, a step is never edited again. Answers and user edits go into the plan.
- Nothing here names the scaffolding (.claude/, CLAUDE.md, flat specs).
- Delete these comments when filling the template in.
-->

# Step {N}: {one line, what this step decided or landed}

## This step

{Two to five lines: the answers applied, the amendments carried, the layer made concrete,
the items landed and where. Name any item or file settled and landed in this step under
standing authorization, with the answers it rests on. Then: `status: {before} → {after}`,
`remaining: {before} → {after}`.}

## Changes

<!-- One bullet per abstract item or file whose fate is anything but "kept, text
unchanged", and one per new item or file. Everything not listed here is kept unchanged. The
plan's diff and the diff of every `SPEC.md` the step touched must show exactly the listed
changes. In step 1, every statement of the brief is listed. -->

- **`{handle}`** — {kept | refined | answered | absorbed | amended | landed}
  - **was:** {the abstract text quoted, or the line that changed}
  - **now:** {the concrete handles or text; for `answered`, the answer quoted; for `landed`,
    `into {dir/SPEC.md}`, the files that hold it, and "as written" or the reworded text}
  - **raises:** {`q-…`, only if any}
  - **verdict:** {discharged | failed | undecidable}
- **`{abstract file}`** — {kept | refined | absorbed | amended | closed}
  - **was:** / **now:** {as above; `closed` when everything it holds has landed}
  - **verdict:** {discharged | failed | undecidable}

New in this step:

- **`{handle or path}`**
  - **justified by:** {the answer, the brief statement, or the abstract item it makes
    concrete}
  - **verdict:** {discharged | failed | undecidable}

## Amendments

{For each amended or reopened item, and each file the user edited: where it came from (a
user edit since step-{N-1}'s commit, an answer, the brief, or the conversation), and the
user's confirmation quoted with its date. Otherwise: "None."}

## Split

{Only in a trunk step that splits; otherwise leave the section out.}

- **{branch}** — `docs/specs/{idea}/{branch}/state.md` and `step-{N}.md`
  - **files:** {the files it lists}
  - **items:** {the handles it carries}
- **trunk** — {what stays, and what it waits on}
- **shared:** {each shared commitment, the chain that lands it, and the chains that rely on
  it}

## Demonstrations

{For each capability landed in this step: its id, its success criterion quoted, what was
run or observed, and what it showed. For each invariant held by code landed or reopened:
its unit test, its run on the tree (passed), how the guard was broken in a scratch copy,
and its run there (failed). Then the tests of the modules this step changed: the command,
and the counts. Otherwise: "None."}

## Reviews

{The module-contract-reviewer's scope (the change, or the whole tree), its verdicts that
are not `holds`, the number that are, and what was fixed before proving. Otherwise: "None:
nothing in the tree changed."}

## Proof

<!-- One bullet per obligation, every one present: the obligation in bold, its verdict, and
its evidence in one or two lines. Obligations that share a verdict and evidence (typically
n/a) may be grouped in one bullet. -->

- **re-proof of step-{N-1}** — {clean | skipped: only `answer:` lines changed | the
  amendments it surfaced}; {what changed since step-{N-1}'s commit}
- **rounds** — {"passed first time", or one sub-bullet per failed round: the obligations
  that failed and what was changed}
- **matched** — {verdict}; {the plan's and the specs' diffs against Changes}
- **coverage** — …
- **no-widening** — …
- **no-narrowing** — …
- **answers-applied** — …
- **justified** — …
- **consistent** — …
- **settled** — …
- **landed** — …
- **demonstrated** — …
- **tree-kept** — …
- **files** — …
- **progress** — …
- **amendments** — …
- **terminal** — {n/a unless the plan says `done`}
- **partition**, **independent**, **shared**, **cross-chain changes** — {n/a unless this
  step splits; `cross-chain changes` also applies to every branch step}
