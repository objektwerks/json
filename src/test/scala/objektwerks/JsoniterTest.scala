package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

sealed trait Person extends Product with Serializable {
  def name: String
}

object Person {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val personCodec: JsonValueCodec[Person] = JsonCodecMaker.make
}

final case class Employee(id: Int, name: String) extends Person

object Employee {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val employeeCodec: JsonValueCodec[Employee] = JsonCodecMaker.make
}

class JsoniterTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("jsoniter") {
    import com.github.plokhotnyuk.jsoniter_scala.core._

    import Employee._
    val employee = Employee(id = 1, name = "auric goldfinger")
    val employeeByteArray = writeToArray(employee)

    logger.info(s"jsoniter employee: $employee")
    logger.info(s"jsoniter employee as json: ${employeeByteArray.map(_.toChar).mkString}")
    
    employee shouldBe readFromArray(employeeByteArray)

    import Person._
    val person = employee.asInstanceOf[Person]
    person.isInstanceOf[Person] shouldBe true
    val personByteArray = writeToArray(person)

    logger.info(s"jsoniter person: $person")
    logger.info(s"jsoniter person as json: ${personByteArray.map(_.toChar).mkString}")
    
    person shouldBe readFromArray(personByteArray)
  }
}