package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

sealed trait Identifier extends Product with Serializable

final case class Name(first: String, last: String) extends Identifier

object Name {
  import play.api.libs.json.Json

  implicit val nameFormat = Json.format[Name]
  implicit val identifierFormat = Json.format[Identifier]
}

class PlayJsonTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("play json") {
    import play.api.libs.json.Json
    import Name._

    val name = Name("james", "bond")
    val nameAsJson = Json.toJson(name).toString

    logger.info(s"play json name: $name")
    logger.info(s"play json name as json: $nameAsJson")

    name shouldBe Json.parse(nameAsJson).as[Name]

    val identifier = name.asInstanceOf[Identifier]
    identifier.isInstanceOf[Identifier] shouldBe true
    val identifierAsJson = Json.toJson(identifier).toString

    logger.info(s"play json identifier: $identifier")
    logger.info(s"play json identifier as json: $identifierAsJson")

    identifier shouldBe Json.parse(identifierAsJson).as[Identifier]
  }
}