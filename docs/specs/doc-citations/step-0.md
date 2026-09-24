# Docs that follow the features they show

The README fell out of date when the keypad changed, and nothing caught it. It cited only
`CAP-root/readme`, so a change to the app's capabilities never brought it into review. The
only citation form that could link it to them was `uses:`, which means "depends on", and a
README does not depend on the app: it shows it.

- add a fifth citation form, `[doc: CAP-<namespace>/<name>]`: this file shows or explains
  that capability to a reader. It is not a dependency, and it constrains nothing: the claim
  stays in the `SPEC.md`
- a shipped file that shows or explains another part's behaviour (a README, a screenshot's
  alt text, a sample) cites with `doc:` each capability it shows
- when a change touches a capability, review reads every file that cites it with `doc:`,
  and asks whether it still matches: words, pictures, samples
- the README's six `uses:` become `doc:`, and the argument that they are not a module
  dependency goes away
- a change that touches no cited capability (a theme, a colour) is still not caught; that
  stays a known limit
