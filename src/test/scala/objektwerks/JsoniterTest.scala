package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory
import com.github.plokhotnyuk.jsoniter_scala.core._
import com.github.plokhotnyuk.jsoniter_scala.macros._

case class Employee(id: String, name: String)

object Employee {
  implicit val codec: JsonValueCodec[Employee] = JsonCodecMaker.make[Employee](CodecMakerConfig())
}

class JsoniterTest extends FunSuite with Matchers {
  import Employee._

  val logger = LoggerFactory.getLogger(getClass)

  test("jsoniter") {
    val employee = Employee("goldfinger", "auric goldfinger")
    val json = writeToArray(employee)
    logger.info(s"jsoniter employee: $employee")
    logger.info(s"jsoniter employee json: ${json.mkString}")
    employee shouldBe readFromArray(json)
  }
}