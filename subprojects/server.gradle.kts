dependencies {
  implementation("cat.inspiracio", "rhino-js-engine", "1.7.10")
}

configurations.configureEach {
  resolutionStrategy {
    force("org.slf4j:slf4j-api:1.7.36")
  }
}
