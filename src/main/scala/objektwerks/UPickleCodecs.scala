package objektwerks

object UPickleCodecs:
  import upickle.default.*

  given employeeRW: ReadWriter[Employee] = macroRW
  given personRW: ReadWriter[Person] = ReadWriter.merge( employeeRW )