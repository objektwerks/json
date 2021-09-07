package objektwerks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@Fork(1)
class JsonLibraryPerformance {
  @Benchmark
  def borer(): Boolean = {
    import BorerCodecs._
    import io.bullet.borer.Json

    val employee = Employees.newEmployee
    val employeeJson = Json.encode(employee).toUtf8String
    employee == Json.decode(employeeJson.getBytes("UTF8")).to[Employee].value
  }

  @Benchmark
  def circe(): Boolean = {
    import io.circe.generic.auto._
    import io.circe.syntax._

    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    employee == employeeJson.as[Employee].toOption.get
  }

  @Benchmark
  def jsoniter(): Boolean = {
    import JsoniterCodecs._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employees.newEmployee
    val employeeJson = writeToString[Employee](employee)
    employee == readFromString[Employee](employeeJson)
  }

  @Benchmark
  def playjson(): Boolean = {
    import PlayJsonCodecs._
    import play.api.libs.json.Json

    val employee = Employees.newEmployee
    val employeeJson = Json.toJson(employee).toString
    employee == Json.parse(employeeJson).as[Employee]
  }

  @Benchmark
  def sprayjson(): Boolean = {
    import SprayJsonCodecs._
    import spray.json._

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    employee == employeeJson.convertTo[Employee]
  }

  @Benchmark
  def upickle(): Boolean = {
  }

  @Benchmark
  def ziojson(): Boolean = {
  }
}