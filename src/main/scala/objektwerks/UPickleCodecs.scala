package objektwerks

object UPickleCodecs;
  import upickle.default._

  given employeeRW: ReadWriter[Employee] = macroRW
  given personRW: ReadWriter[Person] = ReadWriter.merge( macroRW[Employee] )