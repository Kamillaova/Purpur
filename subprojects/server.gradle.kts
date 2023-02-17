dependencies {
  implementation("cat.inspiracio", "rhino-js-engine", "1.7.10")

  api(libs.netty.buffer)
  api(libs.netty.codec)
  api(libs.netty.handler)
  api(libs.netty.transport)
  api(libs.netty.transport.classes.epoll)
  runtimeOnly(libs.netty.transport.native.epoll) { artifact { classifier = "linux-x86_64" } }
  runtimeOnly(libs.netty.transport.native.epoll) { artifact { classifier = "linux-aarch_64" } }
}

configurations.configureEach {
  resolutionStrategy {
    force("org.slf4j:slf4j-api:1.7.36")
  }
}
