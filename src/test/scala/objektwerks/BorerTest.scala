package objektwerks

import io.bullet.borer.Json
import io.bullet.borer.derivation.MapBasedCodecs._

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

sealed trait Canine extends Product with Serializable
final case class Dog(breed: String, name: String) extends Canine

object Canine {
  implicit val dogCodec = deriveCodec[Dog]
  implicit val canineCodec = deriveAllCodecs[Canine]
}

class BorerTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("borer") {
    import Canine._

    val dog = Dog("bulldog", "spike")
    val dogAsJson = Json.encode(dog).toUtf8String

    logger.info(s"borer dog: $dog")
    logger.info(s"borer dog as json: $dogAsJson")

    dog shouldBe Json.decode(dogAsJson.getBytes("UTF8")).to[Dog].value

    val canine = dog.asInstanceOf[Canine]
    canine.isInstanceOf[Canine] shouldBe true
    val canineAsJson = Json.encode(canine).toUtf8String

    logger.info(s"borer canine: $canine")
    logger.info(s"borer canine as json: $canineAsJson")

    canine shouldBe Json.decode(canineAsJson.getBytes("UTF8")).to[Canine].value
  }
}