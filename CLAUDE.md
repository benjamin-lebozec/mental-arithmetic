# mental-arithmetic

An Android app for practising mental arithmetic, with a modular structure.

## Method

Plain Claude Code. No framework scaffolding, no agent-role ceremony. The four rules below
are the whole method. Each rule gives its reason, because people work around a rule the
first time it gets in the way if they don't know why it exists.

## 1. Ideas are refined into code and specs

New work is built by **refinement**: items are translated into more concrete items, one
proved step at a time, until each item has become one of two things:

- **code**, which says what it can;
- a claim in a **`SPEC.md`**, which says what the code can't.

That pair, code and specs, is the only thing the work leaves that anyone reads later. It
must explain itself on its own.

An idea starts as a brief in `docs/specs/<idea>/step-0.md`, and the `refine` skill takes it
forward one step at a time (`step-1.md`, `step-2.md`, …). Beside its steps, each chain keeps
one **plan**, `state.md`, holding **only what has not landed yet**: open questions,
requirements, assumptions, items still being made concrete, and the files still to write.
Each step records what it changed and how that was proved.

An item **lands** when its code is written and cited, and its claim is written into the
`SPEC.md` it belongs to. It then leaves the plan. **Landing happens throughout the chain,
not in one final implementation step**, so the plan gets smaller as the chain moves forward,
and no file grows large before it is used. A chain is **done** when its plan has nothing
left to land.

A **chain** is the sequence of steps for one idea, or for one branch of an idea after a
split. Its plan carries a **Files** list: the files it will still write or change. **Two
chains in flight never list the same file.** A done chain lists nothing and owns nothing.

- **A new idea starts from the tree, never from steps.** Its brief is read against the code
  and the `SPEC.md` files. No chain ever reads another chain's steps or plan to learn what
  the tree is. If something matters later, it has to land in a `SPEC.md`.
- **Any chain may change landed code or claims.** It does so by **reopening** the items
  concerned, with the user's decision as its authority, and landing them again. A direct
  edit outside refine is not forbidden either. The reviewer then holds the tree against its
  specs.
- The reason: the steps prove that the tree refines the brief. Once an item has landed, the
  tree is the only thing that states it, so the tree must stand without the steps.

The steps and plans are kept in `docs/specs/` for now. Whether they can be deleted without
consequence is an open experiment: the rule above is meant to make it safe by design.

**Scaffolding** is how the work gets done, not a record of what was decided. It covers
everything under `.claude/`, the flat specs directly in `docs/specs/`
(`docs/specs/*.md`), everything under `docs/mockups/` and `docs/reviews/`, this file, session planning files
(not a chain's `state.md`) and session notes. The steps and plans under
`docs/specs/<idea>/` are **not** scaffolding. They are the record, but no code and no
`SPEC.md` depends on them.

A **mockup** under `docs/mockups/` is a drawing used to decide what to build, never a
source the code is generated from and never a thing the code answers to. Whatever a mockup
settles is settled again, in words, in the step that takes it up.

**Shipped files never cite the scaffolding or the steps.** Shipped files are the code,
config, tests, README, and `SPEC.md` files. None of them contains a path, a filename or a
"see the spec" comment pointing at those documents. Such a pointer is a dependency just as
much as an import is. A step or plan may cite the tree, never the scaffolding.

Naming the **role** that held a rule is not such a pointer. A step may record that review,
the reviewer or the prover found something, because what it records is what was found, not
where a tool lives.

The test: delete `.claude/`, `docs/`, and this file. The project must still build, run, and
explain itself through its code and its `SPEC.md` files.

## 2. Parts are specified where they live

A **`SPEC.md`** can sit in any directory. It holds the claims about the files under that
directory, and it declares one **namespace**, named in its front matter and unique in the
tree. It is committed with the code and ships with it.

A **module** is a directory that owns what it needs to do its job. Modules are
**discovered on disk**, never listed in a registry. Adding one edits no existing module's
files. A module may depend on other modules, when it needs them to do its job, but the
dependencies never form a cycle. Removing a module leaves working every module that does
not depend on it. Needing to edit another module's files to add yours means the boundary is
wrong. Fix the boundary, not the diff.

A part is **open** when it accepts additions nobody refined with it. The root accepts new
modules, for example. No proof covers additions that do not exist yet, so an open part's
`SPEC.md` has a **Contract** section:

- how an addition is recognized;
- the claims every addition is held to.

Review checks each addition against that contract when it arrives. The chain that builds an
addition carries the contract ids it is subject to as requirements, so both its proof and
the review can see them. How a module is recognized, and what counts as a dependency, is
stated once, in the root `SPEC.md`'s contract.

## 3. `SPEC.md` says what the code can't

A `SPEC.md` holds every claim declared for the files under it, and nothing that only
repeats the code or a step. That means:

- each capability and invariant the code there answers to, in one line, with a capability's
  success criterion;
- the rules an addition follows, for an open part;
- the reasons behind a claim, where they are not obvious;
- the facts about the world around the part that the code cannot state, such as host setup
  and requirements;
- what the part deliberately does not do, and what is untested or known to be broken.

A line that only restates what a file does is a second copy that will drift from the first.
A capability's line is an anchor for the code's citations: its id, one sentence, and its
success criterion. Nothing more.

**Every verifiable claim carries an id.** The id shape is **`<KIND>-<namespace>/<name>`**,
lowercase kebab-case on both sides, and the namespace is that of the `SPEC.md` declaring
it. A plan uses an item's final id as soon as the `SPEC.md` it will land in is known. Each
id is declared in exactly one `SPEC.md`. There are five kinds:

- **`CAP-`** — what someone can now do. Code holds it and cites it.
- **`INV-`** — a rule held. Either code holds it and cites it, or review holds it, and the
  claim says which.
- **`REQ-`** — what must exist for the part to work: another part's capability, an open
  contract followed, a host fact, a variable. Reviewed by demonstration.
- **`NOT-`** — what is deliberately not done. Reviewed by absence: a search that must come
  back empty.
- **`LIM-`** — what is untested, approximate, or broken. Reviewed by demonstration.

The namespace **is** the ownership claim, which is why no central registry is needed. Ids
are never numbered, are stable, and are never reused after retirement. Give a claim an id
because the claim is worth making. **Never invent an id just so a line has something to
cite.**

## 4. Every line of code answers to a claim on its path

In the comment that explains the code, four forms and no others:

    [provides:     CAP-<namespace>/<name>]   this code is how that capability is kept
    [uses:         CAP-<namespace>/<name>]   this code depends on another part's capability
    [enforces:     INV-<namespace>/<name>]   this code is how that invariant is held
    [demonstrates: CAP-|INV-<namespace>/<name>]   this test is how that claim is shown

**The path rule.** A file may `provide:`, `enforce:` or `demonstrate:` only an id declared
in a `SPEC.md` on its own path: in its directory or in a parent directory. What a file *is*
must be stated above it. `uses:` may name any declared `CAP-` anywhere, because a
dependency can point anywhere, and the no-cycle rule holds it instead.

**`demonstrates:` is for tests only**: a test file, or a stand-in or fixture that only a
test loads. A test does not hold a rule; it shows the rule is held. Deleting the guard
breaks the rule, deleting the test only stops us knowing, so the two never share a form.
Tests written before this form cite `provides:`; they stay as they are, and every test
written since cites `demonstrates:`.

- Every `CAP-` is cited by at least one `provides:`.
- Every `INV-` held by code is cited by at least one `enforces:`.
- Every `CAP-` and every `INV-` held by code that a step lands or reopens is cited by at
  least one `demonstrates:`, or, for a `CAP-` whose success criterion only a person can
  judge (a screenshot review), carries a `LIM-` saying it is shown only by manual review.
  Items landed before this rule are not back-filled.
- Every cited id is declared in a `SPEC.md`, never only in a plan.
- No `REQ-`, `NOT-` or `LIM-` is ever cited.
- Brackets are reserved for citations. Prose, error messages and docs write the bare id.

**Coverage: every shipped file carries a citation in its header, and that citation covers
the whole file.** A citation on a block inside the file reassigns that block's lines. So
every line has exactly one id answering for it. A file with nothing worth citing has no
reason to exist. `SPEC.md` and `README.md` are exempt, because they are prose about the
code. So is an **asset** whose format has no comment syntax, or whose text must stay exactly
as published: a font, an image, a licence text. The line that loads the asset is cited
instead. The exemption is for the file's format, never for its content. A script or a
stylesheet is not exempt, whatever it is named.

The reason: a diff carries comments and nothing else. A reviewer handed changed lines can
tell whether the code is wrong, but not whether it is wrong about the right thing, unless
the lines say what they are for.

## Review holds the rules

There is **no contract-check script, deliberately.** Do not write one. Two agents hold the
rules by reading:

- The **`refinement-prover`** holds each chain. For every step, it decides whether:
  - the plan the step leaves,
  - what it landed in the tree,
  - and the changes it records

  together refine the plan before.
- The **`module-contract-reviewer`** holds the tree, over **the change since the last
  review**:
  - the citation rules (declaration, forward, demonstrated, backward, path, direction, kind,
    coverage, severance), over the changed files and every file citing an id the change
    touches;
  - every `SPEC.md` claim the change can reach: each id the change touches, judged over its
    whole reach in the tree; and, for each changed file, each `NOT-`, `INV-` held by review,
    `REQ-` and `LIM-` on its path, judged against that file;
  - every addition to an open part against that part's contract;
  - that no two chains in flight list the same file.

  It first lists what it will check, then checks each item, then files a report under
  `docs/reviews/`. The last committed report marks what has been reviewed: the next review
  starts from its commit, so a change nobody reviewed is part of the next review, never
  skipped. Refine commits each report only with the exact tree it saw.

The reason for reviewing only the change: an unchanged file cannot newly break a claim, and
a review whose cost grows with the tree ends up skipped. The whole tree is walked only when
there is no report yet (the first review, or after `docs/` was deleted), or when asked for
an audit of claims about the world outside the tree. A changed citation rule is run over
every shipped file, alone.

So the cost of a change to a `SPEC.md` is the reach of the ids it touches, and a claim
declared high in the tree reaches everything under it. That is one more reason a claim lands
in the lowest directory it governs, and why a feature lives in its own module with its own
`SPEC.md`. Each report lists the widest reaches it walked.

The cost is stated: nothing holds these rules between reviews. That is why refine runs both
agents in every step, and why a change made outside refine gets a review too.

## Working rules

- **Planning.** Write the brief to `docs/specs/<idea>/step-0.md` and run the `refine`
  skill. A run can start from a clean context: the tree, the plan, the latest step and git
  hold all the state it needs. Questions between steps are asked in the conversation, and
  their answers are recorded in the plan.
- **Architecture.** A decision the code must keep honouring lands as an id in the `SPEC.md`
  above the code it governs, in the **lowest** directory that holds all of that code.
  Choosing that directory is part of making the decision. A claim held by review high in
  the tree is re-judged whenever anything under it changes, so it needs a reason to sit
  there.
- **Testing.** Rules for tests written from now on; existing tests are not changed to
  follow them.
  - **A test of an `INV-` held by code is a unit test, and it is quick.** It is a JVM test
    under the module's `src/test/`, run with JUnit. It calls the code that `enforces:` the
    rule and replaces what that code depends on with fakes or MockK: no emulator, no
    device, no instrumentation, no database, no network. A slow test ends up skipped, and a
    skipped test holds nothing. Instrumented tests (`src/androidTest/`) are for
    capabilities that only a device can show, never for an invariant.
  - **It must be able to fail.** Its demonstration breaks the guard in a scratch copy of
    the tree and shows the test fails, then shows it passes on the tree as it is.
  - **A step runs the tests of the modules it changed**, not the whole suite: the JVM unit
    tests of each Gradle module the step touched (`./gradlew :<module>:testDebugUnitTest`,
    or `:<module>:test` for a plain Kotlin module), and every module's when it touched a
    root build file (`settings.gradle.kts`, `build.gradle.kts`, `gradle/`). A failure blocks the commit. The whole suite is left to a CI
    run on push, once the project has one.
- **Splitting.** A chain splits into branches when some of its remaining work can be
  proved on its own. The line is not a module line. Branches list disjoint files, and each
  can be proved without the others. Refine proposes a split when one is possible, and the
  user decides.
- **Building.** Only through a refine step, and every step ends with a commit. An item is
  not landed until its code cites it, its `SPEC.md` declares it, and the step is proved.
- **Reviewing.** Refine runs both agents in every step. Run the
  `module-contract-reviewer` yourself on any change made outside refine, and always on one
  that adds a module, touches an open part, or touches a `SPEC.md`. Commit its report with
  the change it reviewed, and only if nothing shipped changed since the review. No shipped
  file, step or plan cites a report.
