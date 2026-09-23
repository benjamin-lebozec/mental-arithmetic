---
name: refine
description: Take an idea from a plain brief to code and SPEC.md files in proved refinement steps. Reads the chain's plan docs/specs/<idea>/state.md (only what has not landed yet), its latest step-N.md (step-0 is the user's brief) and the SPEC.md files of the parts it touches. Rewrites the plan and records what changed in step-N+1.md. Lands whatever step-N had settled, as cited code plus claims in the SPEC.md on its path, and removes it from the plan. Has an independent prover check the step, stops for the user's review, commits, and asks the step's questions in the conversation. Runs from a clean context. Proposes splitting the chain into branches that write disjoint files. Use when the user runs /refine, asks to refine, build or change an idea or a step, or has just written a step-0.md.
---

# Refining an idea, one proved step at a time, into code and specs

An idea becomes code by refinement, the way the B-Method turns an abstract machine into an
implementation. It moves one step at a time. Each step makes a little more concrete, and
each is **proved against the step before it** before anything is built on it.

Refinement is transitive, so a chain of individually proved steps proves the tree against
the brief. Nobody ever has to hold the brief and the code side by side, which gets harder
to do honestly with every decision in between.

**Every item ends as code, as a claim in a `SPEC.md`, or both.** When an item is settled,
the next run **lands** it:
- it writes the code and cites the item's id;
- it writes the claim into the `SPEC.md` on that code's path;
- it removes the item from the plan.

Landing happens in every run that has something settled, not in one final implementation
step. So the plan shrinks as the chain moves, and no document grows large before the code
it describes exists. No agent builds outside a refine run.

**The plan holds only what has not landed.** Each chain has one plan, `state.md`, which
every run rewrites. Each run also writes a step, `step-N.md`, recording what it changed in
the plan and the tree, and how that was proved. Both are committed. A chain is `done` when
its plan has nothing left but its Why and its Success signal. It owns nothing from then on.
A later idea that changes its code starts a chain of its own, from the tree.

Throughout this file:
- "step-N" means the plan and the tree as step-N's commit left them, together with step-N's
  record;
- "step-N+1" means the plan and tree this run leaves, together with the step it writes.

`CLAUDE.md`'s rules govern everything a step lands. They are already in your context, so
do not read the file again. Then read, in this skill's directory:
- `obligations.md`, its Terms and The obligations. Its Splitting and Step 1 sections are
  read only when the run splits or writes step 1;
- `state-template.md` and `step-template.md`;
- `spec-template.md`, only when the run lands something.

The obligations define what "refines" means, and you draft and build to discharge them.

## Working economically

Every turn of a run re-reads its whole context, so the cost of a run is its number of turns
times the size of its context. Keep both small. None of this loosens a rule:
- **Read once, read narrowly.** Read a file once, and read only the part you need: a
  section with `awk`, or a range with `sed -n`, rather than the whole file. Do not re-read a
  file after writing it: the write would have failed if it had not landed.
- **Write whole files in one call.** Write the plan and the step each with one `Write`.
  Check the plan's diff afterwards with one `git diff`, rather than patching it line by
  line. "Byte for byte" is a rule about the result, not about how it is written.
- **Keep command output short.** Send test runs to a log in the scratchpad and read only
  the summary (`… > <log> 2>&1; tail -n 15 <log>`). The step records the command and the
  counts, and names the log. Read more of the log only when a test fails.
- **Batch independent reads and searches** into one call.
- **Look at a screenshot only when a success criterion needs it.** Record in the step what
  it showed.

## State lives in the files and in git

A run assumes nothing from the conversation before it. It can be the first message of a
fresh session. Everything it needs is on disk:

- **The plan and the latest step.** A chain's plan is `state.md` in its directory, and its
  latest step is the highest-numbered `step-N.md` there. The trunk lives in
  `docs/specs/<idea>/`, and a branch in `docs/specs/<idea>/<branch>/`.
- **The tree.** The `SPEC.md` files the plan names (under `lands in:` and in Reopened), and
  the files under them. What has landed is read there, never from earlier steps.
- **The step's commit.** Every run ends with a commit, made once the user has reviewed the
  step. `git log -1 --format=%H -- <step file>` finds the commit of step-N.
- **What changed since.** Run `git diff <that commit> -- <plan> <step-N> <every path the
  plan's Files list names> <every SPEC.md the plan names>`, and `git status`. Answers
  written into the plan's `answer:` lines after its commit are input. Every other change is
  a user edit, and so a candidate amendment.
- **An interrupted run.** A latest step that is uncommitted, with a plan that says
  `unproved` (not step-0), means a run stopped before committing. Read `resume.md`.

Never rely on anything a previous run "knew" that the plan, the step and the tree do not
say. If the next run would need it, write it:
- in the plan, when the chain still has to act on it;
- in a `SPEC.md`, when the tree must keep honouring it;
- in the step, when it is only part of how this step got there.

## The chain

- `step-0.md` is the user's brief, in their own words and any form. The run that writes
  step-1 commits step-0 with it.
- A run rewrites the plan, writes one new step per chain it moves, and writes whatever that
  step lands. It ends with one commit per chain. A split run rewrites the trunk's plan,
  writes each new branch's plan, and writes a step for each, in one commit.
- Only the plan is edited after its commit, and only in two ways:
  - the run writes the user's answers into its `answer:` lines;
  - the user edits anything they disagree with, in the plan, or in a file or spec the chain
    touched.

  A committed step is never edited. To go back, the user reverts the later steps' commits.
- **A new idea reads the tree, not the steps.** Neither a draft nor a proof reads another
  chain's steps or plan to learn what is built. The one exception is a chain in flight:
  another chain's Files list is read, to keep files disjoint.
- A chain is linear. An idea need not be one chain: see `splitting.md`.

## One run

1. **Find the chains and their state.** The user names the idea (its directory or a file
   in it), or one chain (`<idea>/<branch>`).
   - Named by the idea, a run takes every chain that can move, in parallel (see
     `parallel.md`).
   - Named by a chain, it takes only that one.

   For each chain, read the plan, the latest step's This step section, the specs the plan
   names, and git's state as described above. Read the rest of the latest step only when
   the plan says `unproved`. A `done` chain has nothing to do: a change to what it landed is
   a new idea, so say so.

2. **Gather the input.** Four sources, in this order:
   - **Unanswered questions.** If the plan has open questions with empty `answer:` lines,
     ask them now, in the conversation (see Asking). Write each answer into its line.
   - **Changes the user asks for in this conversation.** Record them as amendments to
     confirm.
   - **User edits since step-N's commit** (when N ≥ 1). Give the chain, step-N, the commit
     of the step its `refines:` names, and step-N's commit to the `refinement-prover` in
     `re-prove` mode. Its failures are edits that are not refinements: the user changed
     their mind, or slipped. Skip the re-prover when the diff above shows nothing but the
     plan's `answer:` lines, and record that in the step's re-proof bullet. `re-prove`
     skips those lines anyway: an answer is proved by the next `prove`, under
     `answers-applied`, and one that contradicts a commitment fails there as an unconfirmed
     amendment.
   - **Answers that contradict a step-N commitment or a landed claim.**

   Together, the last three are the **amendments**. Put them to the user in the
   conversation: the old text, the new text, and where each came from. Get confirmation
   before drafting. An amendment the user did not mean is undone: they revert the edit, or
   you do at their word.

   If nothing is answered, amended or settled, draft only if something can be made
   concrete anyway. If nothing can, stop and name the questions that block.

3. **Draft step-N+1** from the plan and the specs it names. Rewrite the plan with
   `status: unproved`, and write the step with its Changes. Both go to disk before
   anything lands. See Drafting. Every item this run lands says `to land`, and every file it
   writes says `to write`: that is the run's checklist.

4. **Land what step-N settled.** Work through the `to land` and `to write` entries. See
   Landing. Skip this when nothing is settled.

5. **Review and prove.** Launch both agents in the same message, so they run in parallel.
   They judge different things, and a fix to either's finding is proved again anyway.
   - The `module-contract-reviewer`, when the tree changed. Give it step-N's commit and
     scope `change`. Use scope `full` when this step takes the chain to `done`, adds a
     module, or edits a module rule. Name, in the prompt, the ids whose declaration this
     step added, changed or retired: the reviewer walks each of them over the whole tree.
   - The `refinement-prover` in `prove` mode, given the chain, step-N+1, and step-N's
     commit.

   Fix what the reviewer finds and each failure the prover reports, in the plan, the step,
   a spec or the code. Keep the step's Changes matching the diffs. A reviewer fix is then
   proved again with the rest.

   If a fix needs a choice that isn't yours, put the item back in the plan as an open
   question, and take its code and its spec line out. Then prove again.

   Stop after three rounds. Do not overrule the prover: if you think a verdict is wrong,
   record it with your reason, and put it to the user.

6. **Record the proof** in the step: the review, the demonstrations, the prover's verdicts
   (on each Changes entry, and one line per obligation), and the re-proof's outcome. Then
   set the plan's `status`:
   - `done` if only the Why and Success signal are left and `terminal` is discharged;
   - `split` for a trunk step that handed everything it could to branches, and waits on
     them;
   - `refining` if anything remains;
   - `unproved` if failures survived three rounds. The next run's re-proof starts there.

7. **Stop for the user's review.** Nothing is committed until the user has looked at it.
   Give them, in the conversation:
   - the step file, the plan's diff, each spec's diff, every file the step wrote or
     changed, by path, and the `git diff --stat`;
   - what was decided and what landed where, and each prover or reviewer verdict that is
     not `discharged`;
   - each item settled and landed in this step under standing authorization, with the
     answers it rests on, since this review is the first time the user sees it;
   - any verdict you disputed, with your reason.

   Then ask with `AskUserQuestion`: commit as it is (recommended when the proof is clean),
   or "I edited something", or hold off. Wait for the answer. Do not ask the step's
   questions yet: the review is about what was done, the questions about what comes next.
   - **Commit:** go on to 8.
   - **Edited:** ask what they meant by each change that alters a commitment or a claim,
     and record it under Amendments with their words. Then go back to 5, prove again, and
     stop here again after it.
   - **Hold off:** stop. Leave everything uncommitted. The next run resumes here.

8. **Commit.** Stage exactly these files by path, never with `git add -A` or `git add .`:
   - the new step;
   - the plan;
   - every spec and file this step wrote, changed or deleted.

   Commit with the message
   `refine(<idea>[/<branch>]): step-<N+1> — <one line: what was decided or landed>`, ending
   with the attribution lines the session asks for. A hook that fails is fixed, and the
   commit is made again; never skip hooks. An `unproved` step is committed too, once the
   user has reviewed it, so its failures are on record and the next run finds them.

9. **Ask the step's questions** in the conversation (see Asking). Write each answer into
   the plan's `answer:` lines. Do not commit them: the next run's commit carries them. If
   a split is possible, propose it here too (see `splitting.md`).

10. **Report.** Say:
   - what was decided, what landed and in which spec, and the commit;
   - how `remaining` moved;
   - which questions are still open;
   - which items are now settled and will land in the next run;
   - any obligation not discharged.

   When the chain is `done`, list the specs it wrote to. The user may now `/clear`: the
   next run needs nothing from this conversation.

## Asking

Questions between steps go to the user in the conversation, never only in a file.

- Use `AskUserQuestion`, at most four questions per call, the ones that unblock the most
  first. Give each question its options, with the recommended one first and labelled
  "(Recommended)". Each option's description says what it unblocks.
- An option list longer than four goes in the question text, with the best four as
  options. The user can always answer in their own words.
- Write the answer into the plan as given: the option, and the user's words quoted, with
  the date. If the user skips a question or defers it, leave its `answer:` empty. The next
  run asks it again.
- Amendment confirmations and split proposals are asked the same way.

## Drafting step-N+1

- **Draft from the plan and the tree.** Do not reopen the brief or earlier steps. Whatever
  the plan lost, it lost at a proved step, and reading back would smuggle it past the
  proof. If you notice a loss, tell the user; they may restore it as an amendment. What has
  landed, read in its spec.
- **Apply every answer, then every confirmed amendment.** Each answer closes its question
  and yields exactly the items it decides.
- **Then make one layer concrete.** Take the most abstract items left, and refine them only
  as far as step-N and its answers already settle. Small steps are easy to prove, and a
  step that decides everything at once cannot be reviewed.
- **Place each item as soon as you can.** Once you know which directory's code will hold an
  item, name its `lands in:` spec: the `SPEC.md` of the deepest directory that contains
  every file holding it. A spec that does not exist yet is added to the Files list. Choose
  its namespace, unique in the tree, when you add it.
- **Grow the Files list with the items.** Name the files that will hold each item, and on
  each file the ids it will hold. A file is ready to be written in the next run once its
  path is final and every item it holds is settled. The list is what the user reviews to
  see what will be coded, so keep it current, and never let code appear that it did not
  name.
- **Prefer landing early.** An item that can be settled and landed on its own should not
  wait for its neighbours. Settle it now, so the next run can land it, or this run under
  standing authorization (see Landing).
- **Derive, don't guess.** Whatever follows from step-N gets drafted. A call the user would
  probably accept, but has not made, is an assumption, stated in the open where they can
  strike it. Anything genuinely theirs to choose is an open question, never a silent
  choice. That covers a boundary the input does not settle, a trade-off, and anything a
  success criterion rests on.
- **Ask few, and ask well.** Ask the questions whose answers unblock the most, about five a
  step rather than everything that could be asked. Each has options, a recommendation with
  its reason, what it unblocks, and what raised it.
- **Ids when final.** A requirement becomes a `CAP-` once it has a success criterion and a
  landing spec. Its namespace is that spec's. Rules become `INV-`, refusals `NOT-`, needs
  `REQ-`, admitted gaps `LIM-`, each with its final id the first time it is written. There
  are no provisional ids. Before using an id, search the tree's specs and every other plan
  for it: it must be new.
- **Success criteria come from the user.** No `success:` line may exist unless it traces to
  the answer to `q-validation`. An `INV-` held by code needs no such answer for its test:
  the test shows the rule as written, as `CLAUDE.md`'s Testing rule says. Name that test in
  the plan's `shown in:` line when the invariant is placed.
- **Open parts.** When the idea adds to an open part (for example a new module under the
  root), read the Contract section of that part's `SPEC.md`. The plan carries, as a
  requirement, that the addition follows that Contract, and lists only files the contract
  lets an addition create. When the part's `SPEC.md` is on the addition's path (the root, for
  a module), its Contract already binds the addition: nothing lands in the addition's
  `SPEC.md` to repeat it. Otherwise, write a `REQ-` naming the contract ids the addition
  follows, which lands in the addition's `SPEC.md`.
- **Reopen, don't overwrite.** An item that changes a landed claim is written under
  Reopened, with the claim quoted, the change and its authority. The code and spec change
  only when that entry lands.
- **Files other chains list are off limits.** Before naming a file, search the Files lists
  of every chain in flight (`docs/specs/*/state.md`, `docs/specs/*/*/state.md` whose status
  is not `done`). If the idea needs a file another chain lists, stop and record an open
  question about the boundary.
- **Touch only what changes.** Every plan line this step does not change stays byte for
  byte as it was. Do not rewrap, reorder or reword. Every line you do change is listed in
  the step's Changes, and nothing else is: the prover checks the plan's diff against it
  (`matched`). A question the step closes leaves the plan; its answer stays quoted in
  Changes.
- **Keep the record short.** Changes quotes old plan text in full. A landed item says only
  where it went, unless it landed reworded. The Proof section gives one bullet per
  obligation with a line or two of evidence. The Reviews section gives the verdicts that
  are not `holds` and a count of the rest. Do not paste whole reports.

## Landing

Only items and files **settled in step-N** land. The user saw step-N and its questions, so
every line of code and every spec line answers to a decision they have seen. An item you
settle while drafting step-N+1 waits for the next run. That is what keeps the code from
getting ahead of the review.

**The one exception is standing authorization.** When the user has told you to take the
recommended option, and this run closes questions that way, an item or file those answers
settle may land in this same run. It must meet `settled` in `obligations.md`: every question
that blocked it was answered with its recommended option, under an authorization its
`answer:` line quotes with its date, and nothing else about it is left to decide (no new
assumption, no amendment, no open question naming it, its spec or its files). The user has
delegated those decisions, and reviews them once, at the stop before the commit. Name each
such item in This step as "settled and landed in this step". Anything the user answered in
their own words, or chose between options with, is not delegated. It still waits one run,
so the user sees the plan it produced before code is written from it. This saves a whole
step, with its drafter, prover and reviewer, for every settling step it removes.

- **The plan is on disk before the code.** Drafting rewrote the plan with every settled
  entry this run takes, including those settled under standing authorization, marked
  `to land` or `to write`. Land only those, and update the plan
  as each lands, so it always says how far the run got. A run that stops halfway is resumed
  from the plan, not from memory.
  - A **file** is written whole: its header citation, and every id its `holds:` line names
    that this run lands. It then says `written in step-N+1, open for: …` if later items
    still need it, or leaves the list (`closed`) if nothing does.
  - An **item** lands once four things are true:
    - its files are written;
    - its claim is in its spec;
    - for a capability, its success criterion is demonstrated;
    - for an invariant held by code, its unit test passes, and fails on a scratch copy
      whose guard is broken;
    - for a claim no code cites, the reviewer has confirmed it holds.

    It is then removed from the plan. A capability is removed when it works, not when its
    file exists.
  - An entry the run finds it cannot land goes back to `planned`, and This step says why.
    If that is because the plan was wrong, the fix is a question or an amendment, never a
    quiet change of plan.
  - Code that no `to land` entry names is not written. If the run finds it needs a file the
    plan does not name, add that file as `planned`, and to Changes. The next run writes it,
    once the user has seen it.
  - Nothing may still say `to land` or `to write` when the step is committed, unless the
    plan is `unproved`.
- **Land whole slices:** a capability together with the invariants, non-goals and
  requirements that bear on it. Leave a slice for a later run rather than land half of it.
- **Write the spec with the code.** Use `spec-template.md`. Write the item's claim as the
  plan settled it: one line, its `success:`, its `held by:`, and `why:` or `assumes:` only
  where the plan's reason or assumption would otherwise be lost. Nothing that restates the
  code. An open part's spec also gets its Contract section.
- **Cite the ids** in the comment that explains the code, as `CLAUDE.md` rule 4 says:
  - `[provides:]` for a capability landed in a spec on the file's path;
  - `[enforces:]` for a code-held invariant, or an open contract's invariant, declared on
    the file's path;
  - `[uses:]` for any other capability;
  - `[demonstrates:]` in a new test file, or a stand-in only tests load, for the capability
    or invariant it shows. A new test never cites `[provides:]`. An existing test that this
    step extends keeps its header, and adds a block citing `[demonstrates:]` over the lines
    it adds.

  Every file has a header citation. Nothing names the scaffolding, a step or a plan.
- **A reopened item lands** by replacing its spec text and updating every file that relied
  on the old text. Search the tree for its id.
- **Demonstrate each capability's success criterion** as written, and record the evidence
  in the step: what was run or observed, and what it showed. A screenshot or long output
  goes in the scratchpad, and the step says what it showed. A criterion you cannot carry
  out means the capability does not land: say why, and ask the user. A criterion only a
  person can judge (a screenshot review) lands with a `LIM-` saying so, as `CLAUDE.md`
  rule 4 requires.
- **Demonstrate each invariant held by code** with its unit test, as `CLAUDE.md`'s Testing
  rule says: it passes on the tree, and fails on a scratch copy of the tree (a `git worktree`
  in the scratchpad) whose guard is broken. Record both runs, and how the guard was broken.
- **Run the tests of every module the step changed**, as `CLAUDE.md`'s Testing rule says:
  the JVM unit tests of each Gradle module touched (`./gradlew :<module>:testDebugUnitTest`,
  or `:<module>:test` for a plain Kotlin module), and every module's when a root build file
  changed. Record the command and the counts. A failure blocks the
  commit: fix it, or put the item back as `planned` and say why.

## Splitting, parallel runs, step 1, resuming

These are read only when they apply, to keep every run's context small:

- `splitting.md` — when a split is possible, proposed or confirmed. Also the Splitting
  section of `obligations.md`.
- `parallel.md` — when a run is named by an idea with more than one chain that can move.
- `first-step.md` — when the chain has only `step-0.md`. Also the Step 1 section of
  `obligations.md`.
- `resume.md` — when the latest step is uncommitted and its plan says `unproved`.

## The last step

A chain is `done` when its plan holds only its Why and Success signal, its Files list is
empty, and the prover discharges `terminal`. The plan and steps stay in `docs/specs/` as the
record of how the tree was refined. Nothing in the tree depends on them, and no later idea
reads them.
