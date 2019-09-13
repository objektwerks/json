package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

case class Company(name: String, address: String)

object Company {
  import upickle.default._

  implicit val readWriter: ReadWriter[Company] = macroRW
}

class UPickleTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("upickle") {
    import upickle.default._

    val company = Company("objektwerks", "33 Beach Rd., Boca Grande, FL 33333")
    val json = write(company)
    logger.info(s"upickle company: $company")
    logger.info(s"upickle company json: $json")
    company shouldBe read[Company](json)
  }
}
