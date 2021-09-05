package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

sealed trait Identifier extends Product with Serializable
final case class Name(first: String, last: String) extends Identifier
object Name {
  import play.api.libs.json.Json

  implicit val nameFormat = Json.format[Name]
  implicit val identifierFormat = Json.format[Identifier]
}

class PlayJsonTest extends AnyFunSuite with Matchers {
  test("play json") {
    import play.api.libs.json.Json
    import Name._

    val name = Name("james", "bond")
    val nameJson = Json.toJson(name).toString

    println(s"play json name: $name")
    println(s"play json name as json: $nameJson")

    name shouldBe Json.parse(nameJson).as[Name]

    val identifier = name.asInstanceOf[Identifier]
    identifier.isInstanceOf[Identifier] shouldBe true
    val identifierJson = Json.toJson(identifier).toString

    println(s"play json identifier: $identifier")
    println(s"play json identifier as json: $identifierJson")

    identifier shouldBe Json.parse(identifierJson).as[Identifier]
  }
}