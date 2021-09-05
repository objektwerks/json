package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

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
  test("upickle") {
    import upickle.default._

    val company = Company("objektwerks", "1 Beach Rd., Boca Grande, FL 12345")
    val companyJson = write(company)

    println(s"upickle company: $company")
    println(s"upickle company as json: $companyJson")

    company shouldBe read[Company](companyJson)

    val entity = company.asInstanceOf[Entity]
    entity.isInstanceOf[Entity] shouldBe true
    val entityJson = write(entity)

    println(s"upickle entity: $entity")
    println(s"upickle entity as json: $entityJson")

    entity shouldBe read[Entity](entityJson)

    val message = company.asInstanceOf[Message]
    message.isInstanceOf[Message] shouldBe true
    val messageJson = write(message)

    println(s"upickle message: $message")
    println(s"upickle message as json: $messageJson")

    message shouldBe read[Message](messageJson)
  }
}