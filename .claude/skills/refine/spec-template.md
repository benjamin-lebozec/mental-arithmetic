---
namespace: {the <namespace> of every id declared here; unique in the tree}
---

<!--
FORMAT RULES

- A `SPEC.md` holds the claims about the files under its directory: what the code there
  answers to, and what the code cannot say. It ships with the code. It is the only document
  a later idea reads to learn what this part is.
- Code may `provides:`, `enforces:` or `demonstrates:` an id declared here only from a file
  under this directory. `uses:` may reach it from anywhere.
- No line restates what a file does. A capability is an anchor: its id, one sentence, and
  its success criterion.
- Every verifiable claim carries an id in this file's namespace. Declared once, never
  reused.
- No tables: it is read as raw Markdown. Use bullets and nested bullets.
- Nothing here names the scaffolding or the steps (`.claude/`, `docs/`, `CLAUDE.md`, a
  step, a plan).
- A section with nothing in it is left out.
- Delete these comments when filling the template in.
-->

# {Part title}

{One to three sentences: what this part is for, and who relies on it.}

## Capabilities

- **`CAP-{namespace}/{name}`** — {what a user or system can do, and to what end.}
  - **success:** {the criterion a demonstration decides}
  - **why:** {only if the reason is not obvious}
  - **assumes:** {only if a standing assumption bears on it}

## Invariants

- **`INV-{namespace}/{name}`** — {the rule held.}
  - **held by:** {code | review: what a reviewer checks, over which files}
  - **why:** {only if the reason is not obvious}

## Contract

<!-- Only in an open part: a part that accepts additions nobody refined with it. -->

- **addition:** {how an addition is recognized, e.g. "a Gradle module under `feature/`"}
- **`INV-{namespace}/{name}`** — {a rule every addition is held to.}
  - **held by:** {review: what is checked over each addition | code, in the addition}

## Non-goals

- **`NOT-{namespace}/{name}`** — {what is deliberately not done, and where it belongs
  instead, if anywhere.}

## Requires

- **`REQ-{namespace}/{name}`** — {what must exist for this part to work, and which id
  provides it if one does: another part's capability, a contract followed, a host fact, a
  variable.}

## Known limits

- **`LIM-{namespace}/{name}`** — {what is untested, approximate, or broken, stated plainly.}
