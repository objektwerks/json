package objektwerks

import play.api.libs.json.Json

case class Name(first: String, last: String)

object Name {
  implicit val nameFormat = Json.format[Name]
}