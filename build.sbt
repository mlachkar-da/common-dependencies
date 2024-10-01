import Dependencies._

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "common-dependencies",
    libraryDependencies ++= commonLibs,
  )