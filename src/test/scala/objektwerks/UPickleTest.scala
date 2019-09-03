package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

import upickle.default._

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
