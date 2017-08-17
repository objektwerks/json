package json

import play.api.libs.json.Json

trait Entity

case class Name(first: String, last: String) extends Entity

object Name {
  implicit val nameFormat = Json.format[Name]
}