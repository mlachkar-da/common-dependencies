import sbt.{io as _, *}
import cats.syntax.either.*


object Dependencies {

  lazy val google_common_protos =
    resolveDependency("com.google.api.grpc", "proto-google-common-protos")
  lazy val commons_io = resolveDependency("commons-io", "commons-io")
  lazy val auth0_java = resolveDependency("com.auth0", "java-jwt")
  lazy val auth0_jwks = resolveDependency("com.auth0", "jwks-rsa")
  lazy val guava = resolveDependency("com.google.guava", "guava")
  // TODO(#10852) one database library, not two
  lazy val anorm = resolveDependency("org.playframework.anorm", "anorm")
  lazy val scalapb_json4s = resolveDependency("com.thesamet.scalapb", "scalapb-json4s")

  lazy val commonLibs = Seq(commons_io, auth0_java, auth0_jwks, guava, anorm, scalapb_json4s)

  object resolveDependency {
    import io.circe._
    import io.circe.parser._
    import io.circe.generic.auto._
    import better.files._

    lazy val ThisProject = "Canton"
    lazy val OtherProjects: Set[String] = Set("DamlSDK")

    case class Dependencies(dependencies: List[Dependency])

    case class Dependency(org: String, artifacts: Seq[String], version: String, users: Set[String])

    private val dependenciesForThisProject =
      decode[Dependencies](file"dependencies.json".contentAsString)
        .valueOr { err =>
          throw new RuntimeException(s"Failed to parse dependencies file: $err")
        }
        .dependencies
        .flatMap {
          case Dependency(org, artifacts, version, users) if users contains ThisProject =>
            artifacts.map(artifact => (org, artifact) -> (org % artifact % version))
          case dep if dep.users.subsetOf(OtherProjects) => Seq.empty
          case invalid =>
            throw new RuntimeException(s"Invalid dependency definition: $invalid")
        }
        .toMap

    def apply(organization: String, artifact: String): ModuleID =
      dependenciesForThisProject
        .get(organization -> artifact)
        .orElse(dependenciesForThisProject.get(organization -> s"${artifact}_2.13"))
        .getOrElse(
          throw new RuntimeException(s"Unknown dependency: $organization, $artifact")
        )
  }
}