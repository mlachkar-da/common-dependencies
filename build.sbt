import Dependencies._
import Dependency._

ThisBuild / scalaVersion := "2.13.15"

lazy val root = (project in file("."))
  .settings(
    name := "common-dependencies",
    libraryDependencies ++= commonDependencies
  )

lazy val writeDependencies =
  taskKey[Unit]("Writes the dependencies to a JSON file")

writeDependencies := {
  val outputFile = baseDirectory.value / "common-dependencies.json"
  val deps = libraryDependencies.value.map(toDependency)
  val json = Dependency.asJson(deps)
  IO.write(outputFile, json)
}
