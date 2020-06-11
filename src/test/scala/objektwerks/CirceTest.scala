package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import org.slf4j.LoggerFactory

case class Task(worker: String, work: String)

class CirceTest extends AnyFunSuite with Matchers {
  val logger = LoggerFactory.getLogger(getClass)

  test("circe") {
    import io.circe.generic.auto._
    import io.circe.syntax._

    val task = Task("auric goldfinger", "stack gold")
    val taskAsJson = task.asJson

    logger.info(s"circe task: $task")
    logger.info(s"circe task as json: $taskAsJson")

    task shouldBe taskAsJson.as[Task].toOption.get
  }
}