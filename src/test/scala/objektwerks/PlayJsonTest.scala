package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PlayJsonTest extends AnyFunSuite with Matchers {
  test("play json") {
    import PlayJsonCodecs._
    import play.api.libs.json.Json

    val employee = Employee(1, "James Bond")
    val employeeJson = Json.toJson(employee).toString

    println(s"play json employee: $employee")
    println(s"play json employee json: $employeeJson")

    employee shouldBe Json.parse(employeeJson).as[Employee]

    val person = employee.asInstanceOf[Person]
    person.isInstanceOf[Person] shouldBe true
    val identifierJson = Json.toJson(person).toString

    println(s"play json person: $person")
    println(s"play json person json: $identifierJson")

    person shouldBe Json.parse(identifierJson).as[Person]
  }
}