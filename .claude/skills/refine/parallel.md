# Running chains in parallel

Read this when a run is named by an idea with more than one chain that can move.

A run named by the idea moves every chain that can move. The provers and reviewers must
stay independent of whoever drafted and landed. So this session orchestrates, and the
agents it starts never start agents of their own.

1. **Gather the input for every chain.** Run the re-provers in parallel. Ask all the
   questions and amendments together, in as few `AskUserQuestion` calls as fit.
2. **Draft and land every chain at once.** Start one general-purpose agent per chain, in
   parallel. Each one runs this skill for its chain.
   - Tell each to read `SKILL.md`, and to do "Draft step-N+1" and "Land what step-N settled"
     for that chain and nothing else.
   - It writes its plan as `unproved` and its step before landing anything, and updates
     the plan as entries land. It does not commit. The plans show this session how far each
     chain has got.

   Chains write disjoint files, so they share the working tree safely. A demonstration that
   needs the whole application running (shared database, ports, one dev server) is the
   exception: run those one at a time.
3. **Review and prove every chain at once.** Start the reviewers, then one prover per
   chain. Send each chain's failures back to its own agent to fix, and prove again, up to
   three rounds per chain.
4. **Record, then stop for the user's review of every chain at once**, as "Stop for the
   user's review" says, chain by chain in one hand-over. The user may commit some chains
   and hold off others.
5. **Commit the approved chains, one at a time.** Commits go through the shared git index,
   so this session makes them sequentially, each staging only its own chain's paths.
6. **Ask and report.** Ask all the new questions together, then give one summary for the
   idea: which chains moved, which wait on the user, and which are done.

A chain with nothing to move on is skipped and named as blocking.
