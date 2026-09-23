// [provides: CAP-root/docker-build] the root build: where plugins and libraries come from,
// and which modules it builds.
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "mental-arithmetic"

// Modules are found on disk, never named here: every top-level directory holding both a
// build.gradle.kts and a SPEC.md (INV-root/module-recognized).
rootDir.listFiles()!!
    .filter { it.isDirectory && it.resolve("build.gradle.kts").isFile && it.resolve("SPEC.md").isFile }
    .sortedBy { it.name }
    .forEach { include(it.name) }
