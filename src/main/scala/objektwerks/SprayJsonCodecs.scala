package objektwerks

import spray.json.DefaultJsonProtocol

object SprayJsonCodecs extends DefaultJsonProtocol {
  import spray.json._

  implicit val employeeFormat = jsonFormat2(Employee)

  def write(person: Person): JsValue = person match {
    case employee: Employee => employee.toJson
  }

  def read(json: JsValue): Person = json.convertTo[Employee]
}