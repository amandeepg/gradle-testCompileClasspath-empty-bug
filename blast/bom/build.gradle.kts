plugins {
    `java-platform`
}

dependencies {
    constraints {
        api(project(":blast:processor:annotation-processor"))
    }
}
