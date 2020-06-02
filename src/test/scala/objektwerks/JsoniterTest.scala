package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

sealed trait Person extends Product with Serializable {
  def name: String
}

object Person {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val codec: JsonValueCodec[Person] = JsonCodecMaker.make[Person](CodecMakerConfig)
}

case class Employee(id: String, name: String) extends Person

object Employee {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val codec: JsonValueCodec[Employee] = JsonCodecMaker.make[Employee](CodecMakerConfig)
}

class JsoniterTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("jsoniter") {
    import Employee._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employee("goldfinger", "auric goldfinger")
    employee.isInstanceOf[Employee] shouldBe true
    val employeeAsJson = writeToArray(employee)

    logger.info(s"jsoniter employee: $employee")
    logger.info(s"jsoniter employee as json: ${employeeAsJson.mkString}")
    
    employee shouldBe readFromArray(employeeAsJson)

    val person: Person = Employee("bond", "james bond")
    person.isInstanceOf[Person] shouldBe true
    val personAsJson = writeToArray(person)

    logger.info(s"jsoniter person: $person")
    logger.info(s"jsoniter person as json: ${personAsJson.mkString}")
    
    person shouldBe readFromArray(personAsJson)
  }
}