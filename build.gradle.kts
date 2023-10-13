plugins {
    id("java")
}

group = "org.learnighub.axenix"
version = "1.0-SNAPSHOT"

apply(plugin = "java")

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    testImplementation("org.mockito:mockito-inline:4.9.0")
    testImplementation("nl.jqno.equalsverifier:equalsverifier:3.10.1")
}

sourceSets {
    main {
        java.srcDir("src/main/java")
    }

    test {
        java.srcDir("src/test/java")
    }
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}


tasks {
    test {
        testLogging.showExceptions = true
        useJUnitPlatform()
    }
}