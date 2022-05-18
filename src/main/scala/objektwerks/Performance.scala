package objektwerks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations._

// uPickle imports fail in benchmark method!
import UPickleCodecs._
import upickle.default._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(1)
class Performance:
  @Benchmark
  def circe(): Unit =
    import io.circe.generic.auto._
    import io.circe.syntax._

    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    assert( employee == employeeJson.as[Employee].toOption.get )

  @Benchmark
  def jsoniter(): Unit =
    import JsoniterCodecs._
    import com.github.plokhotnyuk.jsoniter_scala.core._

    val employee = Employees.newEmployee
    val employeeJson = writeToString[Employee](employee)
    assert( employee == readFromString[Employee](employeeJson) )

  @Benchmark
  def upickle(): Unit =
    val employee = Employees.newEmployee
    val employeeJson = write(employee)
    assert( employee == read[Employee](employeeJson) )

  @Benchmark
  def ziojson(): Unit =
    import ZioJsonCodecs._
    import zio.json._

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    assert( employee == employeeJson.fromJson[Employee].getOrElse( Employee(0, "") ) )