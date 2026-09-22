# Splitting a chain

Read this when a split is possible, proposed or confirmed. The obligations a split step discharges are in `obligations.md`, under Splitting.

A chain that carries several independent pieces of work drags all of them through every
step, proof and review. Splitting ends that. Each piece becomes a chain of its own, small
enough to draft, prove and review quickly, and able to run alongside the others.

**The line is not a module line.** A branch is any part of the remaining work that meets
`partition` and `independent` in `obligations.md`:

- **It writes its own files**, specs included. No file is listed by two branches.
- **It is provable on its own.** Its items land in specs it lists and are held by files it
  lists. Its success criteria are demonstrable with its files and the tree. Every fact it
  shares with another branch is either already landed, or a shared commitment with one
  named lander.
- Work that needs several branches' code together (integration, an end-to-end
  demonstration) stays in the trunk, which `waits on:` those branches.

**Land shared claims before splitting.** A rule over every branch, or a fact two branches
meet at, is best landed in a spec on every branch's path. It can land in the step before the
split, or in the split step itself when it needs no code. The branches then read it from the
tree, and nothing is copied.

- **When to propose one.** At the end of any run where a partition like that exists and is
  worth it: at least two groups, each with its own files and something to land, that would
  otherwise wait on each other's review. Propose it in the conversation. For each branch,
  give its name, its files, its items and what it relies on. Say what the trunk keeps. Split
  only when the user confirms, because a split decides how they review from then on. Record
  the confirmation as an answer.
- **The split run.** The run after the confirmation writes, all at once:
  - for each branch, `docs/specs/<idea>/<branch>/state.md`, its plan, with the items and
    files it carries, and `docs/specs/<idea>/<branch>/step-N+1.md`, with
    `refines: ../step-N.md`;
  - the trunk's plan, rewritten with whatever stays and `waits on:`, and its `step-N+1.md`,
    whose Split section says what went where;
  - any settled shared claim that needs no code, landed in its spec.

  Numbering carries on, so a step's number says how far the idea has come. The split run
  applies no other answers and writes no code. Prove it with the `refinement-prover` in
  `split` mode, record, stop for the user's review, and commit all the new files in one
  commit.
- **After the split,** each branch is refined and landed as any chain is. It never writes a
  file or decides an item another chain carries. A branch that needs to records an open
  question about the line. The answer lands as an amendment in every chain it touches,
  applied in one run.
- A branch may split again under the same rules. The trunk moves again when the branches
  it waits on have landed what it needs. It is `done` only once every branch is.
- If the user decides a split was premature, they revert the split commit and the branch
  commits after it.
