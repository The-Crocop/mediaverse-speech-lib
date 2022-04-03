//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.google.protobuf.gradle.*;

buildscript {
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
    }
}

plugins {
    idea
    `java-library`
    `maven-publish`
    signing
    id("com.google.protobuf") version "0.8.18"
}

group = "io.citizenjournalist.speech"
version = "1.1"

java {
    withJavadocJar()
    withSourcesJar()
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            // Stub javadoc.jar artifact
            from(components["java"])
            // Provide artifacts information requited by Maven Central
            pom {
                name.set("Citizenjournalist Speech API Library")
                description.set("Library for transcription over grpc")
                url.set("https://github.com/The-Crocop/citizenjournalist-speech-grpc")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("MarkoNalis")
                        name.set("Marko Nalis")
                        email.set("marko@nalis.dev")
                    }
                }
                scm {
                    url.set("https://github.com/The-Crocop/citizenjournalist-speech-grpc")
                }

            }
        }
    }
    // Configure maven central repository
    repositories {
        maven {
            val ossrhUsername: String by extra
            val ossrhPassword: String by extra

            name = "sonatype"
            setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }
}
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        implementation(platform("com.google.cloud:libraries-bom:24.3.0"))
        implementation("javax.annotation:javax.annotation-api:1.3.2")
        api("io.grpc:grpc-protobuf")
        api("io.grpc:grpc-stub")
        implementation("io.grpc:grpc-netty-shaded")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }

    protobuf {
        protoc { artifact = "com.google.protobuf:protoc:3.19.4" }
        generatedFilesBaseDir = "$projectDir/src/generated"
        plugins {
            id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:1.42.0" }
        }
        generateProtoTasks {
            all().forEach {
                it.plugins {
                    id("grpc")
                }
                it.builtins {
                }
            }
        }
    }

    idea {
        module {
            sourceDirs.plusAssign(file("src/generated/main/java"))
            sourceDirs.plusAssign(file("src/generated/main/kotlin"))
            sourceDirs.plusAssign(file("src/generated/main/grpc"))
            generatedSourceDirs.plusAssign(file("src/generated/main/java"))
            generatedSourceDirs.plusAssign(file("src/generated/main/kotlin"))
            generatedSourceDirs.plusAssign(file("src/generated/main/grpc"))
        }
    }

    signing {
//        useInMemoryPgpKeys("-----BEGIN PGP PRIVATE KEY BLOCK-----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=IPvV-----END PGP PRIVATE KEY BLOCK-----", "Ere3d5D48a2h4KKq")
        sign(publishing.publications)
    }

    tasks.javadoc {
        if (JavaVersion.current().isJava9Compatible) {
            (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
        }
    }