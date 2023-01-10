package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SprayJsonTest extends AnyFunSuite with Matchers:
  test("spray json") {
    import SprayJsonCodecs.given
    import spray.json.*

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    employee shouldBe employeeJson.convertTo[Employee]

    println(s"spray json employee: $employee")
    println(s"spray json employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = person.toJson
    person shouldBe personJson.convertTo[Person]

    println(s"spray json person: $person")
    println(s"spray json person json: $personJson")
  }