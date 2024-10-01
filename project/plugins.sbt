libraryDependencies ++= Seq(
  "io.circe" %% "circe-generic" % "0.14.10",
  "io.circe" %% "circe-core" % "0.14.10",
  "io.circe" %% "circe-parser" % "0.14.10",
  "com.github.pathikrit" %% "better-files" % "3.9.1",
  "org.typelevel" %% "cats-core" % "2.9.0"
)
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.6")
