package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

case class Employee(id: String, name: String)

object Employee {
  import com.github.plokhotnyuk.jsoniter_scala.core._
  import com.github.plokhotnyuk.jsoniter_scala.macros._

  implicit val codec: JsonValueCodec[Employee] = JsonCodecMaker.make[Employee](CodecMakerConfig())
}

class JsoniterTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("jsoniter") {
    import Employee._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employee("goldfinger", "auric goldfinger")
    val json = writeToArray(employee)
    logger.info(s"jsoniter employee: $employee")
    logger.info(s"jsoniter employee json: ${json.mkString}")
    employee shouldBe readFromArray(json)
  }
}