package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ZioJsonTest extends AnyFunSuite with Matchers {
  test("zio") {
    import ZioJsonCodecs._
    import zio.json._

    val employee = Employee(1, "James Bond")
    val employeeJson = employee.toJson

    println(s"zio employee: $employee")
    println(s"zio employee json: $employeeJson")

    employee shouldBe employeeJson.fromJson[Employee].getOrElse( Employee(0, "") )

    val person = employee.asInstanceOf[Person]
    val personJson = person.toJson

    println(s"zio person: $person")
    println(s"zio person json: $personJson")

    person shouldBe personJson.fromJson[Person].getOrElse( Employee(0, "") )
  }
}