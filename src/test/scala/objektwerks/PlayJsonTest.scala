package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import org.slf4j.LoggerFactory

case class Name(first: String, last: String)

object Name {
  import play.api.libs.json.Json

  implicit val nameFormat = Json.format[Name]
}

class PlayJsonTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("play json") {
    import play.api.libs.json.Json

    val name = Name("james", "bond")
    val nameAsJson = Json.toJson(name).toString

    logger.info(s"play name: $name")
    logger.info(s"play name as json: $nameAsJson")

    name shouldBe Json.parse(nameAsJson).as[Name]
  }
}