package objektwerks

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.*

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(1)
class Performance:
  @Benchmark
  def borerBenchmark(): Employee =
    import io.bullet.borer.Json
    import io.bullet.borer.derivation.MapBasedCodecs.*
    import BorerCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = Json.encode(employee).toUtf8String
    assert( employee == Json.decode(employeeJson.getBytes("UTF8")).to[Employee].value )
    employee

  @Benchmark
  def circeBenchmark(): Unit =
    import io.circe.generic.auto.*
    import io.circe.syntax.*

    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    assert( employee == employeeJson.as[Employee].toOption.get )

  @Benchmark
  def jsoniterBenchmark(): Unit =
    import com.github.plokhotnyuk.jsoniter_scala.core.*
    import JsoniterCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = writeToString[Employee](employee)
    assert( employee == readFromString[Employee](employeeJson) )

  @Benchmark
  def upickleBenchmark(): Unit =
    import upickle.default.*
    import UPickleCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = write(employee)
    assert( employee == read[Employee](employeeJson) )

  @Benchmark
  def zioJsonBenchmark(): Unit =
    import zio.json.*
    import ZioJsonCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    assert( employee == employeeJson.fromJson[Employee].toOption.get )

  @Benchmark
  def sprayJsonBenchmark(): Unit =
    import spray.json.*
    import SprayJsonCodecs.given

    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    assert( employee == employeeJson.convertTo[Employee] )