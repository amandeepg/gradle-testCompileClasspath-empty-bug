plugins {
    `java-library`
    `java-test-fixtures`
}

val disableBom: String? by project

dependencies {
    if (disableBom == null) {
        api(platform(project(":blast:bom")))
    }
    implementation("com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT") {
        capabilities {
            requireCapability("com.twitter.blast.processor:annotation-processor-common")
        }
    }
}
