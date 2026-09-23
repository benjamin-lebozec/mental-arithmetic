share the app with friends through github, not through an app store

- the repository becomes public
- on every push to master, the ci publishes a github release with the apk attached as a
  plain .apk file (no zip), and a fixed link always downloads the latest one
- the apk needs no store-grade signing, but every build must be signed with the same key,
  so a new version installs over the old one without uninstalling. keep that key out of
  the public repository (github secret)
- add a README: a few words on what the app is, a screenshot, the link to the latest apk,
  and how to install an apk from outside the play store
