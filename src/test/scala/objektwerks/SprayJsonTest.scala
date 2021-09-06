package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SprayJsonTest extends AnyFunSuite with Matchers {
  test("spray json") {
    import SprayJsonCodecs._
    import spray.json._

    val employee = Employee(1, "James Bond")
    val employeeJson = employee.toJson

    println(s"spray json employee: $employee")
    println(s"spray json employee json: $employeeJson")

    employee shouldBe employeeJson.convertTo[Employee]

    val person = employee.asInstanceOf[Person]
    person.isInstanceOf[Person] shouldBe true
    val personJson = SprayJsonCodecs.write(person)

    println(s"spray json person: $person")
    println(s"spray json person json: $personJson")

    person shouldBe SprayJsonCodecs.read(personJson)
  }
}