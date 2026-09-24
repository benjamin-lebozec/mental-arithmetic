---
idea: no-zero-and-new
chain: trunk
step: 3
status: done
waits on: none
remaining: 0q + 0r + 0i + 0f
---

# No 0 digit in A and B, and New in place of Try again after a correct result

## Why

- **`why`** — Two changes to the practice: `A` and `B` should have no 0 digit, and at the
  end of a game whose result is correct, the button that takes Enter's place should pose a
  new multiplication rather than the same one again.

## Requirements

No requirements left.

## To land

Nothing left to land.

## Reopened

Nothing reopened.

## Success signal

- **`s-no-zero-and-new`** — The unit test shows, for each count from 2 to 6, 1000 draws of
  `A` and `B` with no 0 digit; and on the emulator, a game ended with every line right
  shows New in Enter's place, which poses a new `A × B`, while a game ended with an error
  still shows Try again.

## Assumptions

No assumptions left.

## Files

No files left.

## Open Questions

None.
