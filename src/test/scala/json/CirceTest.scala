package json

import io.circe.generic.auto._
import io.circe.syntax._
import org.scalatest.{FunSuite, Matchers}

class CirceTest extends FunSuite with Matchers with Common {
  test("case class") {
    val name = Name("pussy", "galore")
    val json = name.asJson
    debug("Circe Test", name, json.toString)
    name shouldBe json.as[Name].toOption.get
  }
}