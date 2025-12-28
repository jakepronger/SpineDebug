import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.5"
    `java-library`
}

group = "me.jakepronger.spinedebug"
version = "1.0"

dependencies {
    // PaperMC API (compileOnly because library won't run on its own)
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")

    // Example of pulling a Git repo via JitPack (replace USER/REPO/BRANCH)
    implementation("com.github.jakepronger:Spine:1.1.0")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

tasks.named<ShadowJar>("shadowJar") {
    archiveClassifier.set("")
}

// Make sure the standard 'build' command generates the Shadow JAR
tasks.build {
    dependsOn("shadowJar")
}

tasks.test {
    useJUnitPlatform()
}