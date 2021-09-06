package objektwerks

object PlayJsonCodecs {
  import play.api.libs.json.Json

  implicit val employeeFormat = Json.format[Employee]
  implicit val personFormat = Json.format[Person]
}