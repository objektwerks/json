package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SprayJsonTest extends AnyFunSuite with Matchers {
  test("spray json") {
    import ColorCodecs._
    import spray.json._

    val navy = Navy("navy", "#000080")
    val navyJson = navy.toJson

    println(s"spray json navy: $navy")
    println(s"spray json navy json: $navyJson")

    navy shouldBe navyJson.convertTo[Navy]

    val color = navy.asInstanceOf[Color]
    color.isInstanceOf[Color] shouldBe true
    val colorJson = ColorCodecs.write(color)

    println(s"spray json color: $color")
    println(s"spray json color json: $colorJson")

    color shouldBe ColorCodecs.read(colorJson)
  }
}