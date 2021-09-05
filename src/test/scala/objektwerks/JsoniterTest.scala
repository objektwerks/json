package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

sealed trait Person extends Product with Serializable
final case class Employee(id: Int, name: String) extends Person

object Codecs {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val personCodec: JsonValueCodec[Person] = JsonCodecMaker.make
  implicit val employeeCodec: JsonValueCodec[Employee] = JsonCodecMaker.make
}

class JsoniterTest extends AnyFunSuite with Matchers {
  test("jsoniter") {
    import Codecs._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employee(id = 1, name = "auric goldfinger")
    val employeeJson = writeToString[Employee](employee)
    employee shouldBe readFromString[Employee](employeeJson)

    println(s"jsoniter employee: $employee")
    println(s"jsoniter employee as json: $employeeJson")
    
    val personJson = writeToString[Person](employee)
    employee shouldBe readFromString[Employee](personJson)
    employeeJson shouldBe personJson
    
    println(s"jsoniter person json: $personJson")
  }
}