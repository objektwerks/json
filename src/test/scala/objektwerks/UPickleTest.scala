package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
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

final case class Company(name: String, address: String) extends Entity

object Company {
  import upickle.default._

  implicit val readWriter: ReadWriter[Company] = macroRW
}

class UPickleTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("upickle") {
    import upickle.default._

    val company = Company("objektwerks", "1 Beach Rd., Boca Grande, FL 12345")
    val companyAsJson = write(company)

    logger.info(s"upickle company: $company")
    logger.info(s"upickle company as json: $companyAsJson")

    company shouldBe read[Company](companyAsJson)

    val entity = company.asInstanceOf[Entity]
    entity.isInstanceOf[Entity] shouldBe true
    val entityAsJson = write(entity)

    logger.info(s"upickle entity: $entity")
    logger.info(s"upickle entity as json: $entityAsJson")

    entity shouldBe read[Entity](entityAsJson)

    val message = company.asInstanceOf[Message]
    message.isInstanceOf[Message] shouldBe true
    val messageAsJson = write(message)

    logger.info(s"upickle message: $message")
    logger.info(s"upickle message as json: $messageAsJson")

    message shouldBe read[Message](messageAsJson)
  }
}