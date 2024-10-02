import sbt.{io as _, *}

object Dependencies {
  // Versions
  lazy val commonsCodecVersion = "1.11"
  lazy val commonsIoVersion = "2.11.0"
  lazy val googleCommonProtosVersion = "2.22.0"
  lazy val protobufJavaVersion = "3.24.0"
  lazy val jacksonCoreVersion = "2.14.3"
  lazy val javaJwtVersion = "4.2.1"
  lazy val jwksRsaVersion = "0.21.3"
  lazy val hikariCPVersion = "3.2.0"
  lazy val guavaVersion = "31.1-jre"
  lazy val scalazVersion = "7.2.33-scalacheck-1.15"
  lazy val caffeineVersion = "3.1.2"
  lazy val anormVersion = "2.7.0"
  lazy val scalapbJson4sVersion = "0.11.1"
  lazy val opentelemetryVersion = "1.36.0"
  lazy val opentelemetryAlphaVersion = "1.36.0-alpha"
  lazy val opentelemetryInstrumentationAlphaVersion = "2.1.0-alpha"
  lazy val opentelemetryProtoVersion = "1.7.1-alpha"

  // Libraries
  lazy val commonsCodec =
    "commons-codec" % "commons-codec" % commonsCodecVersion
  lazy val commonsIo = "commons-io" % "commons-io" % commonsIoVersion
  lazy val googleCommonProtos =
    "com.google.api.grpc" % "proto-google-common-protos" % googleCommonProtosVersion
  lazy val protobufJava =
    "com.google.protobuf" % "protobuf-java" % protobufJavaVersion
  lazy val jacksonCore =
    "com.fasterxml.jackson.core" % "jackson-core" % jacksonCoreVersion
  lazy val javaJwt = "com.auth0" % "java-jwt" % javaJwtVersion
  lazy val jwksRsa = "com.auth0" % "jwks-rsa" % jwksRsaVersion
  lazy val hikariCP = "com.zaxxer" % "HikariCP" % hikariCPVersion
  lazy val guava = "com.google.guava" % "guava" % guavaVersion
  lazy val scalaz = "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion
  lazy val caffeine =
    "com.github.ben-manes.caffeine" % "caffeine" % caffeineVersion
  lazy val anorm = "org.playframework.anorm" %% "anorm" % anormVersion
  lazy val scalapbJson4s =
    "com.thesamet.scalapb" %% "scalapb-json4s" % scalapbJson4sVersion
  lazy val opentelemetryApi =
    "io.opentelemetry" % "opentelemetry-api" % opentelemetryVersion
  lazy val opentelemetrySdk =
    "io.opentelemetry" % "opentelemetry-sdk" % opentelemetryVersion
  lazy val opentelemetrySdkTesting =
    "io.opentelemetry" % "opentelemetry-sdk-testing" % opentelemetryVersion
  lazy val opentelemetryExporterZipkin =
    "io.opentelemetry" % "opentelemetry-exporter-zipkin" % opentelemetryVersion
  lazy val opentelemetryExporterOtlp =
    "io.opentelemetry" % "opentelemetry-exporter-otlp" % opentelemetryVersion
  lazy val opentelemetryExporterCommon =
    "io.opentelemetry" % "opentelemetry-exporter-common" % opentelemetryVersion
  lazy val opentelemetrySdkExtensionAutoconfigure =
    "io.opentelemetry" % "opentelemetry-sdk-extension-autoconfigure" % opentelemetryVersion
  lazy val opentelemetryExporterPrometheus =
    "io.opentelemetry" % "opentelemetry-exporter-prometheus" % opentelemetryAlphaVersion
  lazy val opentelemetryGrpc =
    "io.opentelemetry.instrumentation" % "opentelemetry-grpc-1.6" % opentelemetryInstrumentationAlphaVersion
  lazy val opentelemetryRuntimeTelemetry =
    "io.opentelemetry.instrumentation" % "opentelemetry-runtime-telemetry-java8" % opentelemetryInstrumentationAlphaVersion
  lazy val opentelemetryProto =
    "io.opentelemetry" % "opentelemetry-proto" % opentelemetryProtoVersion

  lazy val commonDependencies = Seq(
    commonsCodec,
    commonsIo,
    googleCommonProtos,
    protobufJava,
    jacksonCore,
    javaJwt,
    jwksRsa,
    hikariCP,
    guava,
    scalaz,
    caffeine,
    anorm,
    scalapbJson4s,
    opentelemetryApi,
    opentelemetrySdk,
    opentelemetrySdkTesting,
    opentelemetryExporterZipkin,
    opentelemetryExporterOtlp,
    opentelemetryExporterCommon,
    opentelemetrySdkExtensionAutoconfigure,
    opentelemetryExporterPrometheus,
    opentelemetryGrpc,
    opentelemetryRuntimeTelemetry,
    opentelemetryProto
  )
}
