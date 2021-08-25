package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

import zio.json._

sealed trait Car extends Product with Serializable
final case class Porsche(model: String, year: Int) extends Car

object Car {
  implicit val carDecoder: JsonDecoder[Car] = DeriveJsonDecoder.gen[Car]
  implicit val carEncoder: JsonEncoder[Car] = DeriveJsonEncoder.gen[Car]
  implicit val porscheDecoder: JsonDecoder[Porsche] = DeriveJsonDecoder.gen[Porsche]
  implicit val porscheEncoder: JsonEncoder[Porsche] = DeriveJsonEncoder.gen[Porsche]
}

class ZioJsonTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("zio") {
    import Car._

    val porsche = Porsche("911", 1996)
    val porscheJson = porsche.toJson

    logger.info(s"zio make: $porsche")
    logger.info(s"zio make as json: $porscheJson")

    porsche shouldBe porscheJson.fromJson[Porsche].getOrElse( Porsche("", 0) )

    val car = porsche.asInstanceOf[Car]
    car.isInstanceOf[Car] shouldBe true
    val carJson = car.toJson

    logger.info(s"zio car: $car")
    logger.info(s"zio car as json: $carJson")

    car shouldBe carJson.fromJson[Car].getOrElse( Porsche("", 0) )
  }
}