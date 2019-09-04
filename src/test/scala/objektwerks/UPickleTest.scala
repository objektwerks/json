package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory
import upickle.default.{macroRW, ReadWriter => RW, _}

case class Company(name: String, address: String)

object Company {
  implicit val rw: RW[Company] = macroRW
}

class UPickleTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("upickle") {
    val company = Company("objektwerks", "33 Beach Rd., Boca Grande, FL 33333")
    val json = write(company)
    logger.info(s"upickle json: $company")
    logger.info(s"upickle company json: $json")
    company shouldBe read[Company](json)
  }
}
