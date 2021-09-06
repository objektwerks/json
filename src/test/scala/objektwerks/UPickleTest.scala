package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class UPickleTest extends AnyFunSuite with Matchers {
  test("upickle") {
    import UPickleCodecs._
    import upickle.default._

    val employee = Employee(1, "James Bond")
    val employeeJson = write(employee)

    println(s"upickle employee: $employee")
    println(s"upickle employee json: $employeeJson")

    employee shouldBe read[Employee](employeeJson)

    val person = employee.asInstanceOf[Person]
    val entityJson = write(person)

    println(s"upickle person: $person")
    println(s"upickle person json: $entityJson")

    person shouldBe read[Person](entityJson)
  }
}