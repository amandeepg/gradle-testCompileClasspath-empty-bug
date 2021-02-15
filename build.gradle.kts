/**
 * A temporary shared root for Blast and Scythe.
 */

subprojects {
    repositories {
        maven(url = File(rootDir, "maven_local/repository"))
        mavenCentral()
        jcenter()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
}
