# Refinement proof obligations

A step refines the one before it when every obligation below is discharged. These are the
B-Method's refinement obligations restated for documents and code.

Refinement translates items into more concrete items until each has become code, or a claim
in a `SPEC.md`, or both. A chain's **plan**, `state.md`, holds only what has not landed yet.
When an item **lands**, its code is written and cited, its claim is written into its
`SPEC.md`, and it leaves the plan.

So a step has two concrete halves:

- the plan it rewrites;
- the tree it changes: the code, and the `SPEC.md` files.

Here are the two sides every obligation compares:

- **The abstract side** is the plan and the tree as they stood at step-N's commit.
- **The concrete side** is the plan on disk, the tree on disk, and step-N+1's record of its
  changes.

Wherever the obligations say "the abstract step" or "the concrete step", they mean those.

Each obligation is decidable by reading these things and nothing else:

- the abstract plan, `git show <step-N commit>:<chain dir>/state.md`, and the concrete plan
  on disk;
- step-N+1, the record of the changes;
- the `SPEC.md` files the plans name (under `lands in:` and in Reopened), at both commits;
- the files the plans' Files lists and `held in:` lines name;
- git, for what changed since step-N's commit.

No other chain's steps, and no earlier step of this chain, are read. What the tree says is
read from the tree.

Refinement is transitive, so a step is only ever proved against the step directly before
it. A chain of proved steps proves that what landed refines the brief.

The drafter reads this file to write a step that will discharge. The `refinement-prover`
reads it to judge one. Neither has a private version.

## Terms

- **Plan** — the chain's `state.md`: every item and file the chain has not yet landed or
  closed.
- **Step** — `step-N.md`: the record of one refinement, its changes, and their proof. Once
  committed, a step is never edited.
- **Spec** — a `SPEC.md`: the claims about the files under its directory, in one namespace.
- **Item** — any handled bullet in a plan: the Why, each requirement, each item to land,
  each reopened item, each success signal, assumption and open question. In step-0, which
  is prose, the items are the brief's statements.
- **File** — a line in a plan's Files list. Files are not items. They have their own
  obligation, `files`.
- **Commitment** — an item that rules something in or out, which is every item except an
  open question. An assumption is a commitment for as long as it stands. The user can
  strike it on review, and that is an amendment like any other.
- **Open question** — a choice not yet made. It commits to nothing. Answering it is what
  narrows the idea, and narrowing is what refinement is.
- **Settled** — an item or file in the abstract plan that has nothing left to choose. No
  open question lists it under `unblocks:`, and it is in its final form:
  - a capability has its final `CAP-` id, an intent, a success criterion that traces to
    the answer to `q-validation`, its `lands in:`, and `held in:` files under that
    directory;
  - an invariant, non-goal, requirement or limit has its final id, its `lands in:`, and
    says how it is held; an invariant held by code also names its unit test under
    `shown in:`, under that directory;
  - a reopened item says exactly what changes, and names its authority;
  - a file has its final path, and every item it will hold is settled.

  Only what is settled may land, or what `settled` below admits as settled under standing
  authorization.
- **To land / to write** — an item or file this run is landing or writing and has not yet
  checked off. It is a mark of progress, not a claim, and may appear only in an `unproved`
  plan.
- **Reopened** — a landed item a chain changes. The authority is a brief statement or an
  answer. The item stays declared, unchanged, in its spec until the step that lands its
  new version.
- **Fate** — what became of an abstract item or file in the concrete step. Exactly one of:
  - **kept** — carried over, meaning the same thing. Wording may change; the commitment may
    not. A kept item whose lines are unchanged is not listed in the step. Any other fate,
    and any change to a kept item's lines, is listed.
  - **refined** — replaced by one or more concrete items or files that together say
    everything it said, more precisely. A refined item may keep its handle when it is the
    same claim sharpened.
  - **answered** — an open question closed by the user's answer, quoted. It lists the items
    the answer produced.
  - **absorbed** — its whole content is already said by another concrete item, by a claim
    already in the tree, or by code already in the tree (a fact the code states in full,
    such as a function's signature). Whichever it is, it is named.
  - **landed** — it left the plan. Its claim is in its spec, and its code is written and
    cited. A reopened item that lands replaces its old spec text.
  - **closed** — for a file only: everything it holds has landed, and nothing more is
    planned for it.
  - **amended** — changed or dropped by a decision the user confirmed. **This is the one fate
    that is not a refinement**, so it is recorded with the old text, the new text, and where
    the user decided it.

## The obligations

### matched
The step's Changes and the diffs since the abstract commit say the same thing. There are two
diffs:

- the plan's diff;
- the diff of every spec the step touched.

Every item or file either diff adds, removes or alters is listed in Changes. Every entry in
Changes shows in the diffs as it describes. The plan's front matter is outside this check.

A change the diffs show and Changes does not list fails, however small, because no fate was
claimed for it.

### coverage
Every abstract item has exactly one fate, and it is the true one: `kept` for an item the
diff leaves untouched, otherwise the fate its Changes entry claims. *(B: the gluing
invariant is total.)*

These fail:
- an item the diff touches with no Changes entry (which also fails `matched`);
- an item marked `kept` whose text changed what it commits to;
- an item marked `landed` whose claim is not in its spec at the concrete commit;
- an untouched item that a changed item makes false, narrower or wider without saying so.
  Every changed item's handle is searched for in both plans and in the specs they name, and
  each item or claim that names it is judged against the change.

### no-widening
The concrete step allows nothing the abstract one ruled out. Every constraint, non-goal and
success criterion still holds, as written or sharpened. A refined item says at least what
it replaced.

For a landed item, both of these say at least what the abstract item said:
- its spec text;
- the code in its `held in:` files.

A success criterion is not made easier to meet, and a non-goal is not crossed. *(B: the
concrete invariant, through the gluing, implies the abstract one.)* Softening a criterion,
giving a non-goal a loophole, or qualifying an invariant fails, in the plan, the spec or
the code.

### no-narrowing
Whatever the abstract step let someone do, the concrete one still lets them do, in every
situation the abstract allowed it. So does the code of a landed item. A requirement may be
split, sharpened, made an item, or landed. It may not quietly acquire a precondition, a
smaller audience or a smaller scope, in the plan, the spec or the code. *(B: a concrete
operation is enabled wherever its abstract one was.)*

### answers-applied
Every question the concrete step closes, it closes with the user's answer as recorded in
the abstract plan, quoted in the step's Changes. The items that answer produced say what it
said and no more. The drafter closes no question. An answer that delegates ("your call")
closes the question as an assumption, which the user can still strike, never as a
commitment attributed to the user. An unanswered question stays open.

### justified
Every concrete item that is not the fate of some abstract item is new, and it names what
made it necessary: an answer, or the abstract item it makes concrete. An item nothing in
the abstract step needs is scope creep and fails, however sensible it is. New items leave
every abstract commitment as it was. *(Event-B: a new event refines skip.)*

The tree is held to the same rule. Each of these is scope creep and fails:
- code, in a file this step wrote, that serves no item the step lands or reopens;
- a spec line the step wrote that no such item makes;
- a claim a citation makes that no such item makes.

### consistent
No two concrete items contradict each other, or contradict a claim in the tree they do not
reopen. No constraint makes a requirement or capability impossible to deliver. *(B: the
machine has a model.)* An item that the tree as it stands already contradicts fails, unless
it reopens what it contradicts.

### settled
Everything landed in this step, and every file written in it, was settled in the abstract
plan, or is **settled under standing authorization**. An item or file is settled under
standing authorization when all of the following hold:
- every question that listed it under `unblocks:` in the abstract plan is closed in this
  step by an answer that is the question's recommended option, taken under a standing
  authorization the user gave. The `answer:` line quotes that authorization and its date;
- no other decision is left open: its concrete form follows from the abstract plan, those
  answers and the tree. It rests on no assumption new in this step and on no amendment, and
  no open question in the concrete plan lists it, its `lands in:` spec or its files;
- the step's This step section names it as settled and landed in this step.

Anything else that the concrete step decides and lands in the same step fails, because the
user never saw the decision the code was written from. Under standing authorization, the
user has delegated that decision, and reviews it once, before the commit. *(B: only an
implementation-level component is implemented.)*

### landed
Every item landed in this step is where its fate says, in full:
- its claim is declared in the spec its `lands in:` named, once, in that spec's namespace,
  and nowhere else in the tree;
- for a capability, code in its `held in:` files `[provides:]` its id. For a code-held
  invariant, code there `[enforces:]` it. Every such file sits under the spec's directory
  (the path rule);
- a test under the spec's directory `[demonstrates:]` each capability and each code-held
  invariant landed or reopened in this step. A capability without one carries a `LIM-`
  saying it is shown only by manual review. A test file this step created cites no
  `[provides:]`;
- every file written or changed in this step carries its header citation per `CLAUDE.md`,
  and every id it cites is declared in a spec;
- no file or spec the step touched names the scaffolding, a step or a plan;
- an assumption the item rests on landed with it, as its `assumes:` line;
- a reopened item's spec text is replaced, and every file that cited its old meaning still
  says what the new text says.

The prover checks that the code and the spec say what the item says. Whether an addition
follows an open part's contract, and whether a non-cited claim holds, are the
`module-contract-reviewer`'s judgment. The step records its verdict, and the prover checks
that the review was recorded and passed.

### demonstrated
Every capability landed in this step has had its success criterion carried out, and the
step records the evidence: what was run or observed, and what it showed. Each of these
fails:
- evidence that does not answer the criterion as written;
- a criterion recorded as not yet demonstrated.

Every invariant held by code landed or reopened in this step has had its unit test run
twice, and the step records both: it passes on the tree, and it fails on a scratch copy
whose guard was broken, with how it was broken. A test that starts a server, opens a
database, builds the application or reaches the network fails this obligation.

The tests of every module the step changed, and the root's `tests/` if it changed a root
file, were run, and the step records the command and that they passed. A failing or
unrecorded run fails this obligation.

A criterion that cannot be demonstrated on this host means the capability does not land. It
becomes a known limit, and making it one is the user's call.

### tree-kept
Since the abstract commit, the step changed nothing in the tree it had no claim to. Every
spec line it changed belongs to an item it landed or reopened. Every file it changed is in
its Files list, and the change serves an item it landed or reopened. Every landed claim it
did not reopen still holds in the code it changed.

A change the user made is judged the same way, and is exempt only once it is recorded as an
amendment.

### files
The concrete Files list refines the abstract one:
- Every abstract file has a fate: kept, refined (one planned file becomes several), closed,
  or amended.
- Every concrete file that is new is justified by the items it holds.
- No file says `to write` in a step whose status is not `unproved`.
- Every file marked written exists on disk. It holds what its `holds:` line names, judged
  under `landed` and `justified`.
- Every file in the tree that the chain changed since the abstract commit is in the
  abstract or concrete Files list.
- A file marked `closed` holds no item still in the plan.
- **No file in the list is listed in any other chain's plan.**
- No file in the list is an open part's own file, unless the plan reopens that part's
  items or the part's contract lets additions create that file.

### progress
The concrete step does at least one of these:
- closes at least one open question;
- turns at least one requirement into an item with a final id;
- names at least one file or landing place more concretely;
- lands at least one item.

A new open question is allowed only as a consequence of a decision taken in this step, and
says which. *(B: the variant decreases, loosened.)* This guarantees that every step decides
or lands something, not that the chain ends. A chain whose count keeps growing is asking
the wrong questions, and that is the user's to see in review.

### amendments
An item whose fate is `amended`, and a reopened item as far as its authority reaches, are
exempt from `no-widening`, `no-narrowing` and `tree-kept`, and only from those. Each quotes
the old text and the new text, and names where the user decided it. The same holds for a
file the user edited. A change to a commitment, a claim or a file that is neither amended
nor reopened gets no exemption, and fails whichever obligation it breaks.

### terminal
Applies only when the concrete plan says `status: done`. The plan has only its Why and
Success signal left:
- no open questions, requirements, assumptions, items to land or reopened items;
- no files;
- every success signal is shown by a capability landed in this chain;
- every claim this chain landed without code (non-goals, requirements, limits, review-held
  invariants) is recorded as true of the tree by the `module-contract-reviewer`, in the
  step that landed it or in this one.

For a trunk that split, every branch's plan is also `done`. *(B: the implementation is the
last refinement.)*

## Splitting

A chain may **split** once part of what remains can be refined, landed and proved without
the rest. The line is not a module line. It is drawn by two rules:

- **Branches list disjoint files**, `SPEC.md` files included.
- **Each branch is provable on its own.**

A **branch** lives in `docs/specs/<idea>/<branch>/` and is from then on a chain of its own.
The trunk keeps what is not handed off: typically the items that need several branches'
code together. It may split again, and so may a branch.

The split is a step like any other, proved against the plan before it. Its concrete side is
several plans at once:
- the trunk's rewritten plan;
- a new plan for each new branch, each with its step.

A split step writes no code and closes no question. It may land settled claims that need no
code (a shared non-goal, a shared limit, a review-held invariant) in a spec on every
branch's path. Landing a shared claim once, before the branches start, is better than
copying it into each.

The obligations above apply to each new plan against the abstract plan, restricted to what
that plan carries. A branch's first plan is new whole, so `matched` holds it against the
Split section of the trunk's step rather than against a diff. `progress` does not apply,
because the split is the progress. These obligations are added:

### partition
Every abstract item has its fate in exactly one of the new plans, or lands in the split
step. So does every file. Coverage is judged over the new plans together. An item or file
carried nowhere fails, and so does one carried twice. **A file is never shared.**

### independent
Each new chain can be proved and demonstrated without the others. That means all of the
following hold:
- Every item a branch carries lands in a spec it lists, and is held only by files it lists.
- Every fact a branch relies on from another chain is either already in the tree, or a
  shared commitment fixed by this split.
- No open question lists items of two chains under `unblocks:`.
- Every success criterion a branch carries can be demonstrated with only its own files and
  what is already in the tree.
- The only items the trunk carries that need a branch's code are those whose chains it
  lists under `waits on:`.

A split that fails here is too early. Keep refining the trunk until the line settles.

### shared
A commitment that bears on more than one chain, and could not land at the split, is carried
once. The split names the one chain that lands it, and that chain lists its spec. Every
other chain names it under `relies on:` and never copies it. A chain whose code must cite it
`waits on:` the chain that lands it. Only commitments are shared, never an open question and
never a file.

### cross-chain changes
After a split, a chain never lists a file another chain lists, never writes to such a file,
and never decides something another chain carries. A step that finds it needs to records an
open question about the line, and the answer lands as an amendment in every chain it
touches.

## Step 1, against the brief and the tree

step-0 is prose written by the user, not a step, so step-1 formalizes it rather than
refining it. It reads the brief and the specs of the parts the brief touches, never another
chain's steps or plan. The obligations read this way:

- **coverage** — every statement in the brief, quoted, has a fate in step-1's Changes.
  Statements of motive land in the Why. A statement the tree already says is `absorbed`,
  naming the claim. A statement that changes a landed claim makes a reopened item, with the
  statement as its authority. None is dropped as unimportant.
- **no-widening** — step-1 commits to nothing the brief does not say. Anything the drafter
  inferred is an assumption or an open question, never an item to land.
- **no-narrowing** — as for any step.
- **answers-applied** — there are no answers yet. step-1 asks `q-validation`, "How will we
  validate that it works?", whatever the brief says. A hint in the brief becomes the
  question's recommended option, not an answer.
- **justified** — every assumption and open question names the statement in the brief that
  raised it.
- **matched** — the plan is new whole, and every item in it is listed in step-1's Changes.
- **consistent** — every claim of the tree the brief's items bear on was read, and none is
  contradicted without being reopened.
- **files** — the Files list names only what the brief itself places. It may be empty.
- **settled**, **landed**, **demonstrated**, **tree-kept** — do not apply. step-1 lands
  nothing, because nothing in a brief is settled.
- **progress** — does not apply; step-1 is the first formalization.
