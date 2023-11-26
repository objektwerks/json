package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BorerTest extends AnyFunSuite with Matchers:
  test("borer"):
    import io.bullet.borer.{Codec, Json}
    import io.bullet.borer.derivation.MapBasedCodecs.*
    import BorerCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = Json.encode[Employee](employee).toUtf8String
    employee shouldBe Json.decode[Employee](employeeJson)

    println(s"borer employee: $employee")
    println(s"borer employee json: $employeeJson")
    
    val person = employee.asInstanceOf[Person]
    val personJson = Json.encode[Person](person).toUtf8String
    person shouldBe Json.decode[Person](personJson)

    println(s"borer person: $person")
    println(s"borer person json: $personJson")