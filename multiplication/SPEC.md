---
namespace: multiplication
---

# Multiplication

The arithmetic of a multiplication posed as by hand: drawing `A` and `B`, the lines the
user types, and checking what they typed.

## Capabilities

- **`CAP-multiplication/draw-operands`** — For a digit count n from 2 to 6, `A` and `B`
  are drawn at random, each with exactly n digits, none of them 0.
  - **success:** A JVM unit test, run in the Docker build, shows that for each n from 2 to
    6, every one of 1000 draws gives `A` and `B` of exactly n digits, none of them a 0.
- **`CAP-multiplication/partial-products`** — For `A` and `B`, the lines of the posed
  multiplication are given: one partial product per digit of `B`, from its rightmost digit
  leftwards, the k-th (from 0) being the digits of `A` times that digit, to be typed, and
  k shifted zeros written in advance; then the result `A × B`, to be typed. A 0 digit of
  `B` gives a line whose typed part is the single digit 0.
  - **success:** A JVM unit test, run in the Docker build, shows for fixed `A` and `B`,
    one of them with a 0 digit in `B`, each partial product's typed digits and shifted
    zeros, and the result's digits.
- **`CAP-multiplication/check-lines`** — The lines typed for a posed multiplication are
  checked column by column against its lines, from the right of each typed part: a typed
  digit that differs from the expected one is marked wrong, a column expected but not
  typed is marked missing, and a column typed but not expected is marked extra.
  - **success:** A JVM unit test, run in the Docker build, shows that lines typed right
    carry no mark, a wrong digit marks its column wrong, a line too short marks its missing
    columns, and a line too long marks its extra columns.
  - **assumes:** each line is typed with as many digits as its value has, with no leading
    zero, so the user decides its length, and a line of the wrong length is wrong at the
    check.
