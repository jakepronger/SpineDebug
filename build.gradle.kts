plugins {
    id("java")
}

group = "me.jakepronger.spinedebug"
version = "1.0"

dependencies {
    // PaperMC API (compileOnly because library won't run on its own)
    compileOnly("io.papermc.paper:paper-api:1.21.11-R0.1-SNAPSHOT")

    // Example of pulling a Git repo via JitPack (replace USER/REPO/BRANCH)
    implementation("com.github.jakepronger:Spine:1.0.5")


    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}