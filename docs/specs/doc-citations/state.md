---
idea: doc-citations
chain: trunk
step: 3
status: done
waits on: none
remaining: 0q + 0r + 0i + 0f
---

# Docs that follow the features they show

## Why

- **`why`** — The README fell out of date when the keypad changed, and nothing caught it: it
  cited only `CAP-root/readme`, so a change to the app's capabilities never brought it into
  review. The only form that could link it to them was `uses:`, which means "depends on", and
  a README does not depend on the app: it shows it.

## Requirements

Nothing left.

## To land

Nothing to land yet.

## Reopened

Nothing left.

## Success signal

- **`s-doc-review`** — In a scratch copy of the tree, a change to the declaration of one
  capability the README cites with `doc:` (say `CAP-app/posed-layout`) is reviewed, and the
  review lists the README and judges whether it still matches that capability; and a search
  shows the README carries six `doc:` citations and no `uses:`.

## Assumptions

Nothing left.

## Files

No files left.

## Open Questions

Nothing left.
