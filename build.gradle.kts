plugins {
  `java`
	`java-library`
  `application`
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/jposx/jposx-shared")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("GPR_USER")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("GPR_TOKEN")
        }
    }
}


group = "dev.blac.jposx"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources")
        }
    }
}


dependencies { 
	implementation("dev.blac.jposx:jposx-shared:0.0.1")
	implementation("org.slf4j:slf4j-simple:2.0.16")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("io.github.cdimascio:dotenv-java:2.3.0")
	implementation("io.javalin:javalin:6.6.0") }

application { mainClass.set("dev.blac.jposx.core.Jposx") }

tasks.jar { manifest { attributes["Main-Class"] = "dev.blac.jposx.core.Jposx" } }
tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
