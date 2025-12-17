import org.gradle.kotlin.dsl.maven

rootProject.name = "SpineDebug"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven {
            name = "papermc-repo"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
        maven { url = uri("https://jitpack.io") }
    }
}