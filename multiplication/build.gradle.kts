// [provides: CAP-root/docker-build] the multiplication module's build: plain Kotlin on the
// JVM, with JUnit for its unit tests.
plugins {
    id("org.jetbrains.kotlin.jvm")
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}
