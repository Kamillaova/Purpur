plugins {
  `java-library`
  `maven-publish`
  id("xyz.jpenilla.toothpick")
}

toothpick {
  forkName = "Purpur"
  groupId = "dev.kamillaova.purpur"
  forkUrl = "https://github.com/Kamillaova/Purpur"
  val versionTag = System.getenv("BUILD_NUMBER")
    ?: "\"${commitHash() ?: error("Could not obtain git hash")}\""
  forkVersion = "git-$forkName-$versionTag"

  minecraftVersion = "1.16.5"
  nmsPackage = "1_16_R3"
  nmsRevision = "R0.1-SNAPSHOT"

  upstream = "Paper"
  upstreamBranch = "ver/1.16.5"

  server {
    project = projects.purpurServer.dependencyProject
    patchesDir = rootProject.projectDir.resolve("patches/server")
  }
  api {
    project = projects.purpurApi.dependencyProject
    patchesDir = rootProject.projectDir.resolve("patches/api")
  }
}

subprojects {
  repositories {
    maven("https://nexus.velocitypowered.com/repository/velocity-artifacts-snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
  }

  java {
    sourceCompatibility = JavaVersion.toVersion(17)
    targetCompatibility = JavaVersion.toVersion(17)
  }
}
