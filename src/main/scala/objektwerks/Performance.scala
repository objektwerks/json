package objektwerks

import com.github.plokhotnyuk.jsoniter_scala.core.*

import io.circe.generic.auto.*
import io.circe.syntax.*

import java.util.concurrent.TimeUnit

import org.openjdk.jmh.annotations.*

import upickle.default.*

import zio.json.*

import JsoniterCodecs.*
import UPickleCodecs.given
import ZioJsonCodecs.given

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(1)
class Performance:
  @Benchmark
  def circe(): Unit =
    val employee = Employees.newEmployee
    val employeeJson = employee.asJson
    assert( employee == employeeJson.as[Employee].toOption.get )

  @Benchmark
  def jsoniter(): Unit =
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
    val employee = Employees.newEmployee
    val employeeJson = employee.toJson
    assert( employee == employeeJson.fromJson[Employee].toOption.get )