package objektwerks

import io.bullet.borer.Json
import io.bullet.borer.derivation.ArrayBasedCodecs._

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

sealed trait Canine extends Product with Serializable
final case class Dog(breed: String, name: String) extends Canine

object Canine {
  implicit val dogCodec = deriveCodec[Dog]
  implicit val canineCodec = deriveAllCodecs[Canine]
}

class BorerTest extends AnyFunSuite with Matchers {
  test("borer") {
    import Canine._

    val dog = Dog("bulldog", "spike")
    val dogJson = Json.encode(dog).toUtf8String

    println(s"borer dog: $dog")
    println(s"borer dog as json: $dogJson")

    dog shouldBe Json.decode(dogJson.getBytes("UTF8")).to[Dog].value

    val canine = dog.asInstanceOf[Canine]
    canine.isInstanceOf[Canine] shouldBe true
    val canineJson = Json.encode(canine).toUtf8String

    println(s"borer canine: $canine")
    println(s"borer canine as json: $canineJson")

    canine shouldBe Json.decode(canineJson.getBytes("UTF8")).to[Canine].value
  }
}