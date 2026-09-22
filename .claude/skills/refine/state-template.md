---
idea: {idea}
chain: {trunk | <branch>, or <branch>/<sub-branch>}
step: {N, the step that last wrote this plan}
status: {unproved | refining | split | done}
waits on: {none | the chains whose landing this chain's remaining items need}
remaining: {open questions}q + {requirements}r + {items not landed}i + {files not closed}f
---

<!--
FORMAT RULES

- This is the chain's plan: `docs/specs/<idea>/state.md` for a trunk,
  `docs/specs/<idea>/<branch>/state.md` for a branch. There is one per chain. Every step
  rewrites it in place, and git keeps what it said at each step's commit.
- It holds only what has NOT landed. An item that lands leaves this file in the step that
  lands it, and from then on its text lives in its `SPEC.md`. At `done`, only the Why and
  the Success signal are left.
- It is complete together with the tree: whoever reads it, plus the `SPEC.md` files its
  items name, needs no step to know what the chain still has to do.
- No tables anywhere: it is read as raw Markdown. Use bullets and nested bullets.
- Every bullet that is an item opens with its handle in bold code. An item whose landing
  place is known uses its final id as its handle (CAP-, INV-, NOT-, REQ-, LIM-, in the
  namespace of the `SPEC.md` it lands in). Every other handle is kebab-case, prefixed:
  `why`, `r-` requirement, `s-` success signal, `a-` assumption, `q-` question. Handles
  are unique within the idea across all its chains and steps, and never reused.
- An item's text changes only when a step records the change. A step leaves every line it
  does not change byte for byte as it was, so the plan's diff shows exactly what the step
  changed.
- A section with nothing in it says so in one line ("Nothing left to land.") rather than
  being left out.
- In a branch, an item kept in the trunk that this branch relies on is named under
  `relies on:` in its Why, never copied.
- Nothing here names the scaffolding (.claude/, CLAUDE.md, flat specs).
- Delete these comments when filling the template in.
-->

# {Idea title}

## Why

- **`why`** — {Two or three sentences: the problem, and who has it. Why now.}

## Requirements

<!-- What someone can do, before it is concrete enough to be a capability: no success
criterion yet, or no landing place. A requirement becomes one or more items. -->

- **`r-{name}`** — {What a user or system can do, and to what end. WHAT, never HOW.}

## To land

<!-- Items with a final id, waiting to land. `planned` means not yet settled, or settled
and waiting for the next run. `to land` marks what this run is landing: it appears only in
an `unproved` plan, and the item leaves the plan once it lands. -->

- **`CAP-{namespace}/{name}`** — {intent: what a user or system can now do, and to what end.}
  - **success:** {A criterion a demonstration decides. Only once it traces to the answer to
    `q-validation`.}
  - **lands in:** {`dir/SPEC.md`}
  - **held in:** {`path` (which part), … — every path under the directory of `lands in`}
  - **status:** {planned | to land}
- **`INV-{namespace}/{name}`** — {The rule held.}
  - **held by:** {code, in `path` (which part) | review: what a reviewer checks, over which
    files}
  - **shown in:** {held by code only: the unit test's `path`, under the directory of
    `lands in`; it `[demonstrates:]` the id, with fakes or MockK over what the guard depends on}
  - **lands in:** / **status:** {as above}
- **`NOT-…` / `REQ-…` / `LIM-…`** — {the claim}
  - **lands in:** / **status:** {as above}

## Reopened

<!-- Landed items this chain changes. Each stays declared in its `SPEC.md`, unchanged, until
the step that lands its new version. -->

- **`{id}`** — in `{dir/SPEC.md}`
  - **now says:** {the landed text, quoted}
  - **change:** {what will change}
  - **authority:** {the brief statement quoted, or the answer, that decided it}
  - **held in:** {the files whose code changes with it}
  - **status:** {planned | to land}

## Success signal

- **`s-{name}`** — {The observable outcome that says the idea works, traced to the answer to
  `q-validation`.}

## Assumptions

- **`a-{name}`** — {What is taken as true without being decided by the user.}
  - **raised by:** {the item, answer, or quoted brief statement that raised it}
  - **bears on:** {the items it bears on; it lands with them as their `assumes:` line}

## Files

<!-- Every file this chain still writes or changes, `SPEC.md` files included. No other
chain in flight lists any of them. A file leaves this list once every item it holds has
landed and nothing more is planned for it.

A file line says what it will hold and where it stands:
- `planned`: named, not written by this run;
- `to write`: settled in the plan before, and written by this run;
- `written in step-K, open for: {items}`: partly written, with items still to land. -->

- `{path}` — holds: {ids} — {planned | to write | written in step-K, open for: …}

## Open Questions

<!-- The choices not yet made. The refine run asks them in the conversation, then writes
the user's answer here, quoted, with the date. An empty answer keeps the question open, and
the next run asks it again. A question the next step closes leaves this section; its answer
is kept in that step's Changes. -->

- **`q-{name}`** — {The question, phrased so a person can answer it.}
  - **options:**
    - (a) {…}
    - (b) {…}
  - **recommended:** ({x}), because {…}
  - **unblocks:** {the items and files waiting on it}
  - **raised by:** {the decision that raised it; in step 1, the quoted brief statement}
  - **answer:** {empty, or "(b): <the user's words, quoted>" (YYYY-MM-DD, in the conversation)}
