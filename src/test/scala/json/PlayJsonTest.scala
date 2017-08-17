package json

import org.scalatest.{FunSuite, Matchers}
import play.api.libs.json.Json

class PlayJsonTest extends FunSuite with Matchers with Common {
  test("case class") {
    val name = Name("james", "bond")
    val json = Json.toJson(name).toString
    debug("Play Json Test", name, json)
    name shouldBe Json.parse(json).as[Name]
  }
}