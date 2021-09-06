package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PlayJsonTest extends AnyFunSuite with Matchers {
  test("play json") {
    import PlayJsonCodecs._
    import play.api.libs.json.Json

    val employee = Employees.newEmployee
    val employeeJson = Json.toJson(employee).toString
    employee shouldBe Json.parse(employeeJson).as[Employee]

    println(s"play json employee: $employee")
    println(s"play json employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = Json.toJson(person).toString
    person shouldBe Json.parse(personJson).as[Person]

    println(s"play json person: $person")
    println(s"play json person json: $personJson")
  }
}