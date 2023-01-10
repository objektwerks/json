package objektwerks

import spray.json.DefaultJsonProtocol

object SprayJsonCodecs extends DefaultJsonProtocol:
  import spray.json.*

  given employeeFormat: JsonFormat[Employee] = jsonFormat2(Employee.apply(_, _))

  given personFormat: RootJsonFormat[Person] = new RootJsonFormat[Person] {
    def write(person: Person): JsValue =
      JsObject((person match {
        case employee: Employee => employee.toJson
        case null => deserializationError(s"json write error on Person.")
      }).asJsObject.fields)

    def read(json: JsValue): Employee =
      json.asJsObject.getFields("id", "name") match {
        case Seq(JsString("employee")) => json.convertTo[Employee]
        case _ => serializationError(s"json read error on Person.")
      }
  }