# Gradle uses an empty classpath

Run:
```
$ ./gradlew :blast:processor:annotation-processor:dependencies --configuration testCompileClasspath
```

And the output will contain:
```
------------------------------------------------------------
Project ':blast:processor:annotation-processor'
------------------------------------------------------------

testCompileClasspath - Compile classpath for compilation 'test' (target  (jvm)).
No dependencies
```

But it should contain the dependencies, such an `junit:junit:4.12`.

To demonstrate a working dependencies run, which is the output I expect from the above failed run, is to configure the project without the `BOM`'s constraints using `-PdisableBom`:
```
$ ./gradlew :blast:processor:annotation-processor:dependencies --configuration testCompileClasspath -PdisableBom

> Task :blast:processor:annotation-processor:dependencies

------------------------------------------------------------
Project ':blast:processor:annotation-processor'
------------------------------------------------------------

testCompileClasspath - Compile classpath for compilation 'test' (target  (jvm)).
+--- com.squareup:javapoet:1.13.0
+--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20
|    +--- org.jetbrains.kotlin:kotlin-stdlib:1.4.20
|    |    +--- org.jetbrains.kotlin:kotlin-stdlib-common:1.4.20
|    |    \--- org.jetbrains:annotations:13.0
|    \--- org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.20
|         \--- org.jetbrains.kotlin:kotlin-stdlib:1.4.20 (*)
+--- com.google.auto.service:auto-service-annotations:1.0-rc7
+--- com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT
|    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    +--- com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT (*)
|    +--- junit:junit:4.12
|    |    \--- org.hamcrest:hamcrest-core:1.3
|    +--- org.assertj:assertj-core:3.17.2
|    +--- org.mockito:mockito-core:2.28.2
|    |    +--- net.bytebuddy:byte-buddy:1.9.10
|    |    +--- net.bytebuddy:byte-buddy-agent:1.9.10
|    |    \--- org.objenesis:objenesis:2.6
|    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0
|    |    \--- org.mockito:mockito-core:2.23.0 -> 2.28.2 (*)
|    +--- com.google.truth:truth:1.0.1
|    |    +--- com.google.guava:guava:28.1-android
|    |    |    +--- com.google.guava:failureaccess:1.0.1
|    |    |    +--- com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava
|    |    |    +--- com.google.code.findbugs:jsr305:3.0.2
|    |    |    +--- org.checkerframework:checker-compat-qual:2.5.5
|    |    |    +--- com.google.errorprone:error_prone_annotations:2.3.2 -> 2.3.3
|    |    |    +--- com.google.j2objc:j2objc-annotations:1.3
|    |    |    \--- org.codehaus.mojo:animal-sniffer-annotations:1.18
|    |    +--- org.checkerframework:checker-compat-qual:2.5.5
|    |    +--- junit:junit:4.12 (*)
|    |    +--- com.googlecode.java-diff-utils:diffutils:1.3.0
|    |    +--- com.google.auto.value:auto-value-annotations:1.6.3 -> 1.7
|    |    \--- com.google.errorprone:error_prone_annotations:2.3.3
|    +--- com.google.testing.compile:compile-testing:0.18
|    |    +--- junit:junit:4.12 (*)
|    |    +--- com.google.truth:truth:0.44 -> 1.0.1 (*)
|    |    +--- com.google.guava:guava:27.1-jre -> 28.1-android (*)
|    |    +--- com.google.auto.value:auto-value:1.5.3
|    |    \--- com.google.auto:auto-common:0.10
|    |         \--- com.google.guava:guava:23.5-jre -> 28.1-android (*)
|    +--- com.twitter.blast.processor:extension-api-annotation-processor:0.4.0-SNAPSHOT
|    |    +--- com.twitter.blast.processor:extension-api-annotation-processor:0.4.0-SNAPSHOT (*)
|    |    +--- junit:junit:4.12 (*)
|    |    +--- org.assertj:assertj-core:3.17.2
|    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    +--- com.twitter.blast.ast:javax:0.4.0-SNAPSHOT
|    |    |    +--- com.twitter.blast.ast:javax:0.4.0-SNAPSHOT (*)
|    |    |    +--- junit:junit:4.12 (*)
|    |    |    +--- org.assertj:assertj-core:3.17.2
|    |    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    |    +--- com.google.truth:truth:1.0.1 (*)
|    |    |    +--- com.google.testing.compile:compile-testing:0.18 (*)
|    |    |    +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT
|    |    |    |    +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT (*)
|    |    |    |    +--- junit:junit:4.12 (*)
|    |    |    |    +--- org.assertj:assertj-core:3.17.2
|    |    |    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    |    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    |    |    +--- com.twitter.blast:util:0.4.0-SNAPSHOT
|    |    |    |    |    +--- com.twitter.blast:util:0.4.0-SNAPSHOT (*)
|    |    |    |    |    +--- junit:junit:4.12 (*)
|    |    |    |    |    +--- org.assertj:assertj-core:3.17.2
|    |    |    |    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    |    |    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    |    |    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    |    |    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT
|    |    |    |    |         +--- com.twitter.blast.ast:javax:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.processor:extension-api-annotation-processor:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.ast:javapoet:0.4.0-SNAPSHOT (c)
|    |    |    |    |         +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT (c)
|    |    |    |    |         \--- com.twitter.blast:util:0.4.0-SNAPSHOT (c)
|    |    |    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    |    |    +--- javax.inject:javax.inject:1
|    |    |    |    +--- org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.1.0
|    |    |    |    |    \--- org.jetbrains.kotlin:kotlin-stdlib:1.3.31 -> 1.4.20 (*)
|    |    |    |    +--- com.twitter.blast:util:0.4.0-SNAPSHOT (*)
|    |    |    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    |    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    |    +--- com.squareup:javapoet:1.13.0
|    |    |    +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT (*)
|    |    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    |    +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT
|    |    |    +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT (*)
|    |    |    +--- junit:junit:4.12 (*)
|    |    |    +--- org.assertj:assertj-core:3.17.2
|    |    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    |    +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT (*)
|    |    |    +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT
|    |    |    |    +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT (*)
|    |    |    |    +--- junit:junit:4.12 (*)
|    |    |    |    +--- org.assertj:assertj-core:3.17.2
|    |    |    |    +--- org.mockito:mockito-core:2.28.2 (*)
|    |    |    |    +--- com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0 (*)
|    |    |    |    +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT (*)
|    |    |    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    |    |    +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT (*)
|    |    |    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    |    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    |    +--- com.twitter.blast.ast:core:0.4.0-SNAPSHOT (*)
|    |    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    |    +--- com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT (*)
|    |    +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT (*)
|    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    +--- com.twitter.blast.ast:javax:0.4.0-SNAPSHOT (*)
|    |    +--- com.twitter.blast.ast:javapoet:0.4.0-SNAPSHOT
|    |    |    +--- com.squareup:javapoet:1.13.0
|    |    |    +--- com.twitter.blast.ast:javax:0.4.0-SNAPSHOT (*)
|    |    |    +--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    |    |    \--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    +--- com.twitter.blast.processor:extension-api-core:0.4.0-SNAPSHOT (*)
|    |    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
|    +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT (*)
|    +--- com.squareup:javapoet:1.13.0
|    +--- com.twitter.blast.processor:extension-api-annotation-processor:0.4.0-SNAPSHOT (*)
|    +--- com.twitter.blast.processor:core:0.4.0-SNAPSHOT (*)
|    \--- com.twitter.blast:bom:0.4.0-SNAPSHOT (*)
+--- com.google.dagger:dagger:2.26
|    \--- javax.inject:javax.inject:1
+--- com.google.auto.value:auto-value-annotations:1.7
+--- com.squareup.inject:assisted-inject-annotations-dagger2:0.5.2
|    \--- com.squareup.inject:assisted-inject-annotations:0.5.2
+--- com.twitter.scythe:extension-annotation-processor:0.4.0-SNAPSHOT
|    +--- com.twitter.scythe:extension-annotation-processor:0.4.0-SNAPSHOT (*)
|    +--- com.twitter.scythe:extension-core:0.4.0-SNAPSHOT
|    |    +--- com.twitter.scythe:extension-core:0.4.0-SNAPSHOT (*)
|    |    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    |    +--- org.jetbrains.kotlin:kotlin-stdlib:1.4.20 (*)
|    |    +--- javax.inject:javax.inject:1
|    |    \--- com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT (*)
|    +--- org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.20 (*)
|    +--- org.jetbrains.kotlin:kotlin-stdlib:1.4.20 (*)
|    \--- com.twitter.scythe:extension-core:0.4.0-SNAPSHOT (*)
\--- project :blast:processor:annotation-processor -> com.twitter.blast.processor:annotation-processor:0.4.0-SNAPSHOT (*)
```