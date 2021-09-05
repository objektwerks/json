package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

sealed trait Work extends Product with Serializable
final case class Task(worker: String, work: String) extends Work

class CirceTest extends AnyFunSuite with Matchers {
  test("circe") {
    import io.circe.generic.auto._
    import io.circe.syntax._

    val task = Task("auric goldfinger", "stack gold")
    val taskJson = task.asJson

    println(s"circe task: $task")
    println(s"circe task as json: $taskJson")

    task shouldBe taskJson.as[Task].toOption.get

    val work = task.asInstanceOf[Work]
    work.isInstanceOf[Work] shouldBe true
    val workJson = work.asJson

    println(s"circe work: $work")
    println(s"circe work as json: $workJson")

    work shouldBe workJson.as[Work].toOption.get
  }
}