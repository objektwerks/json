package objektwerks

import spray.json.DefaultJsonProtocol

object SprayJsonCodecs extends DefaultJsonProtocol:
  import spray.json.*

  given employeeFormat: RootJsonFormat[Employee] = jsonFormat2(Employee.apply(_, _))

  def write(person: Person): JsValue =
    person match
      case employee: Employee => employee.toJson

  def read(json: JsValue): Person = json.convertTo[Employee]