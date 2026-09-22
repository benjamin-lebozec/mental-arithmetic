# Resuming an interrupted refine run

Read this when the latest step is uncommitted and its plan says `unproved` (not step-0).

- **An interrupted run.** A latest step that is uncommitted, with a plan that says
  `unproved` (not step-0), means a run stopped before committing. Resume it rather than
  drafting again, unless the user says otherwise.
  - If any entry still says `to land` or `to write`, resume at "Land what step-N settled",
    with those entries only.
  - If the step's Proof section is filled in, the run stopped at the user's review. Ask
    whether they changed anything since, prove again if they did, and stop for their review
    again.
  - Otherwise resume at "Review and prove".
