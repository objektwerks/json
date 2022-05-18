package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import upickle.default.*

class UPickleTest extends AnyFunSuite with Matchers:
  test("upickle") {
    import UPickleCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = write(employee)
    employee shouldBe read[Employee](employeeJson)

    println(s"upickle employee: $employee")
    println(s"upickle employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val personJson = write(person)
    person shouldBe read[Person](personJson)

    println(s"upickle person: $person")
    println(s"upickle person json: $personJson")
  }