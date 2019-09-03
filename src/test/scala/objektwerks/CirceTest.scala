package objektwerks

import io.circe.generic.auto._
import io.circe.syntax._
import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

class CirceTest extends FunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("circe") {
    val task = Task("auric goldfinger", "stack gold")
    val json = task.asJson
    logger.info(s"circe task: $task")
    logger.info(s"circe task json: $json")
    task shouldBe json.as[Task].toOption.get
  }
}