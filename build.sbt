import Dependencies._
import Dependency._

ThisBuild / scalaVersion := "2.13.15"
Global / onChangedBuildSource := ReloadOnSourceChanges
lazy val root = (project in file("."))
  .settings(
    name := "common-dependencies",
    libraryDependencies ++= commonDependencies
  )

lazy val writeDependencies =
  taskKey[Unit]("Writes the dependencies to a JSON file")

writeDependencies := {
  val outputFile = baseDirectory.value / "common-dependencies.json"
  val deps = libraryDependencies.value
    .map(toDependency)

  val toWrite = deps.sortBy(dep => (dep.org, dep.artifact, dep.version)).toSet
  val json = Dependency.asJson(toWrite.toSeq)
  IO.write(outputFile, json)
}

lazy val writeDependencyTree =
  taskKey[Unit](
    "Writes the dependencies including the transitive ones to a JSON file"
  )

writeDependencyTree := {
  val outputFile = baseDirectory.value / "all-common-dependencies.json"
  val report = update.value
  val deps = report.configurations
    .find(_.configuration.name == Compile.name)
    .map { config =>
      config.modules.map(_.module)
    }
    .map(_.toSet)
    .getOrElse(Nil)

  val toWrite = deps
    .map(toDependency)
    .toSeq
    .sortBy(dep => (dep.org, dep.artifact, dep.version))
    .toSet

  val json = Dependency.asJson(toWrite.toSeq)
  IO.write(outputFile, json)
}
