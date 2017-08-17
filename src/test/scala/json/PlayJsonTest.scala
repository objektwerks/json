package json

import org.scalatest.{FunSuite, Matchers}
import play.api.libs.json.Json

class PlayJsonTest extends FunSuite with Matchers with Logging {
  test("case class") {
    val name = Name("james", "bond")
    val json = Json.toJson(name).toString
    log(name, json)
    name shouldBe Json.parse(json).as[Name]
  }
}