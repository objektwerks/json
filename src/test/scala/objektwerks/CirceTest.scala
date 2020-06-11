package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import org.slf4j.LoggerFactory

sealed trait Work extends Product with Serializable
case class Task(worker: String, work: String) extends Work

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

    val work = task.asInstanceOf[Work]
    work.isInstanceOf[Work] shouldBe true
    val workAsJson = work.asJson

    logger.info(s"circe work: $work")
    logger.info(s"circe work as json: $workAsJson")

    work shouldBe workAsJson.as[Work].toOption.get
  }
}