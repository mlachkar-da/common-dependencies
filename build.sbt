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
  val deps = libraryDependencies.value
    .sortBy(module => (module.organization, module.name, module.revision))
    .map(toDependency)
  val json = Dependency.asJson(deps)
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
    .flatMap { config =>
      config.modules.map(_.module)
    }
    .toSet
    .toSeq
    .sortBy((module: ModuleID) =>
      (module.organization, module.name, module.revision)
    )

  val json = Dependency.asJson(deps.map(toDependency))
  IO.write(outputFile, json)
}
