package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CirceTest extends AnyFunSuite with Matchers {
  test("circe") {
    import io.circe.generic.auto._
    import io.circe.syntax._

    val employee = Employee(1, "James Bond")
    val employeeJson = employee.asJson

    println(s"circe employee: $employee")
    println(s"circe employee json: $employeeJson")

    employee shouldBe employeeJson.as[Employee].toOption.get

    val person = employee.asInstanceOf[Person]
    val personJson = person.asJson

    println(s"circe person: $person")
    println(s"circe person json: $personJson")

    person shouldBe personJson.as[Person].toOption.get
  }
}