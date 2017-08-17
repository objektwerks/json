package json

import org.scalatest.{FunSuite, Matchers}
import play.api.libs.json.Json

class PlayJsonTest extends FunSuite with Matchers {
  test("case class") {
    val name = Name("james", "bond")
    val json = Json.toJson(name).toString
    name shouldBe Json.parse(json).as[Name]
  }
}