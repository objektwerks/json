package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SprayJsonTest extends AnyFunSuite with Matchers {
  test("spray json") {
    import SprayJsonCodecs._
    import spray.json._

    val employee = Employee(1, "James Bond")
    val employeeJson = employee.toJson
    employee shouldBe employeeJson.convertTo[Employee]

    println(s"spray json employee: $employee")
    println(s"spray json employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = SprayJsonCodecs.write(person)
    person shouldBe SprayJsonCodecs.read(personJson)

    println(s"spray json person: $person")
    println(s"spray json person json: $personJson")
  }
}