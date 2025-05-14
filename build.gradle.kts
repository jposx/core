plugins {
  java
  application
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/resources")
        }
    }
}

repositories { mavenCentral() }

dependencies { 
	implementation("org.slf4j:slf4j-simple:2.0.16")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("io.github.cdimascio:dotenv-java:2.3.0")
	implementation("io.javalin:javalin:6.6.0") }

application { mainClass.set("dev.blac.jpos.Jpos") }

tasks.jar { manifest { attributes["Main-Class"] = "dev.blac.jpos.Jpos" } }
tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
