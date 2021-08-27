package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

import spray.json.DefaultJsonProtocol

sealed trait Color extends Product with Serializable {
  val name: String
  val code: String
}

final case class Navy(name: String, code: String) extends Color

object ColorProtocol extends DefaultJsonProtocol {
  implicit val navyFormat = jsonFormat2(Navy)
}

class SprayJsonTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("spray json") {
    import ColorProtocol._
    import spray.json._

    val navy = Navy("navy", "#000080")
    val navyJson = navy.toJson

    logger.info(s"spray json navy: $navy")
    logger.info(s"spray json navy as json: $navyJson")

    navy shouldBe navyJson.convertTo[Navy]
  }
}