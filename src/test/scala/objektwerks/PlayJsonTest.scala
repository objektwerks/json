package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory
import play.api.libs.json.Json

class PlayJsonTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("play json") {
    val name = Name("james", "bond")
    val json = Json.toJson(name).toString
    logger.info(s"play json name: $name")
    logger.info(s"play name json: $json")
    name shouldBe Json.parse(json).as[Name]
  }
}