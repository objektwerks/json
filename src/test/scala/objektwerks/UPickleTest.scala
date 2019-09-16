package objektwerks

import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

sealed trait Entity extends Product with Serializable

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

    val entity = Company("ipawerks", "99 IPA Circle, Boca Grande, FL 99999").asInstanceOf[Entity]
    val entityJson = write(entity)
    logger.info(s"upickle entity: $entity")
    logger.info(s"upickle entity json: $entityJson")
    entity shouldBe read[Entity](entityJson)
  }
}
