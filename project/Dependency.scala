import sbt.{io as _, *}
import io.circe.syntax.*
import io.circe.*, io.circe.generic.semiauto.*

case class Dependency(
    org: String,
    artifact: String,
    version: String,
    crossVersion: String
)

object Dependency {
  implicit val depEncoder: Encoder[Dependency] = deriveEncoder[Dependency]
  val filter = Set("org.scala-lang")

  def toDependency(m: ModuleID): Dependency = Dependency(
    org = m.organization,
    artifact = m.name,
    version = m.revision,
    crossVersion = m.crossVersion.toString
  )

  def asJson(deps: Seq[Dependency]): String = deps.asJson.spaces2
}
