package json

import io.circe.generic.auto._
import io.circe.syntax._
import org.scalatest.{FunSuite, Matchers}

class CirceTest extends FunSuite with Matchers with Logging {
  test("case class") {
    val name = Name("auric", "goldfinger")
    val json = name.asJson
    log(name, json.toString)
    name shouldBe json.as[Name].toOption.get
  }
}