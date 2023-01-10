package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class JsoniterTest extends AnyFunSuite with Matchers:
  test("jsoniter") {
    import com.github.plokhotnyuk.jsoniter_scala.core.*
    import JsoniterCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = writeToString[Employee](employee)
    employee shouldBe readFromString[Employee](employeeJson)

    println(s"jsoniter employee: $employee")
    println(s"jsoniter employee json: $employeeJson")
    
    val person = employee.asInstanceOf[Person]
    val personJson = writeToString[Person](person)
    person shouldBe readFromString[Person](personJson)

    println(s"jsoniter person: $person")
    println(s"jsoniter person json: $personJson")
    println("*** Jsoniter\n")
  }