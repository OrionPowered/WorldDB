plugins {
    id("io.github.orionpowered.worlddb.java-common-conventions")
    id("com.github.johnrengelman.shadow")
    application
}

repositories {
    maven("https://maven.alexsobiek.com/snapshots")
}

dependencies {
    implementation("com.alexsobiek.logger:85f506545f")
}

tasks {
    jar {
        archiveClassifier.set("unshaded")
    }

    shadowJar {
        archiveClassifier.set("")
        minimize() {
            exclude(dependency("ch.qos.logback:logback-classic"))
        }
    }

    build {
        dependsOn(shadowJar)
    }
}