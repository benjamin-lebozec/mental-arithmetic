# [provides: CAP-root/docker-build] the container the build runs in: JDK 17, Gradle and
# the Android SDK, so the host needs nothing but Docker.
FROM eclipse-temurin:17-jdk

ARG GRADLE_VERSION=8.10.2
ARG CMDLINE_TOOLS_VERSION=11076708

ENV ANDROID_HOME=/opt/android-sdk
ENV PATH=/opt/gradle/bin:/opt/android-sdk/cmdline-tools/latest/bin:$PATH

RUN apt-get update \
 && apt-get install -y --no-install-recommends unzip wget \
 && rm -rf /var/lib/apt/lists/*

RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -O /tmp/gradle.zip \
 && unzip -q /tmp/gradle.zip -d /opt \
 && mv /opt/gradle-${GRADLE_VERSION} /opt/gradle \
 && rm /tmp/gradle.zip

RUN mkdir -p ${ANDROID_HOME}/cmdline-tools \
 && wget -q https://dl.google.com/android/repository/commandlinetools-linux-${CMDLINE_TOOLS_VERSION}_latest.zip -O /tmp/tools.zip \
 && unzip -q /tmp/tools.zip -d ${ANDROID_HOME}/cmdline-tools \
 && mv ${ANDROID_HOME}/cmdline-tools/cmdline-tools ${ANDROID_HOME}/cmdline-tools/latest \
 && rm /tmp/tools.zip \
 && yes | sdkmanager --licenses > /dev/null \
 && sdkmanager "platforms;android-35" "build-tools;34.0.0" > /dev/null

WORKDIR /project
