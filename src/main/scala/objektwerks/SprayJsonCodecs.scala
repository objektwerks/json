package objektwerks

import spray.json.*

object SprayJsonCodecs extends DefaultJsonProtocol:
  given JsonFormat[Employee] = jsonFormat2(Employee.apply(_, _))

  given RootJsonFormat[Person] = new RootJsonFormat[Person] {
    def write(person: Person): JsValue =
      person match
        case employee: Employee => employee.toJson

    def read(json: JsValue): Person = json.convertTo[Employee]
  }