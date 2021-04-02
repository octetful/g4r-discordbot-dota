plugins {
    kotlin("jvm") version "1.4.32"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.jessecorbett:diskord:1.8.1")
//    implementation("com.github.mrbean355:dota2-gsi:1.0.0")
}
