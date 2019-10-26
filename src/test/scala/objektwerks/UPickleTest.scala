package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

sealed trait Message extends Product with Serializable

object Message {
  import upickle.default._

  implicit val messageRW: ReadWriter[Message] = ReadWriter.merge( macroRW[Entity] )
}

sealed trait Entity extends Message

object Entity {
  import upickle.default._

  implicit val entityRW: ReadWriter[Entity] = ReadWriter.merge( macroRW[Company] )
}

case class Company(name: String, address: String) extends Entity

object Company {
  import upickle.default._

  implicit val readWriter: ReadWriter[Company] = macroRW
}

class UPickleTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("upickle") {
    import upickle.default._

    val company = Company("objektwerks", "33 Beach Rd., Boca Grande, FL 33333")
    val json = write(company)
    logger.info(s"upickle company: $company")
    logger.info(s"upickle company json: $json")
    company shouldBe read[Company](json)

    val entity = Company("ipawerks", "66 IPA Circle, Boca Grande, FL 66666").asInstanceOf[Entity]
    val entityJson = write(entity)
    logger.info(s"upickle entity: $entity")
    logger.info(s"upickle entity json: $entityJson")
    entity shouldBe read[Entity](entityJson)

    val message = Company("dipawerks", "99 DIPA Drive, Boca Grande, FL 99999").asInstanceOf[Message]
    val messageJson = write(message)
    logger.info(s"upickle message: $message")
    logger.info(s"upickle message json: $messageJson")
    message shouldBe read[Message](messageJson)
  }
}
