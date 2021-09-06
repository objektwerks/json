package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BorerTest extends AnyFunSuite with Matchers {
  test("borer") {
    import BorerCodecs._
    import io.bullet.borer.Json

    val employee = Employee(1, "James Bond")
    val employeeJson = Json.encode(employee).toUtf8String
    employee shouldBe Json.decode(employeeJson.getBytes("UTF8")).to[Employee].value

    println(s"borer employee: $employee")
    println(s"borer employee json: $employeeJson")

    val person = employee.asInstanceOf[Person]
    val canineJson = Json.encode(person).toUtf8String
    person shouldBe Json.decode(canineJson.getBytes("UTF8")).to[Person].value

    println(s"borer person: $person")
    println(s"borer person json: $canineJson")
  }
}