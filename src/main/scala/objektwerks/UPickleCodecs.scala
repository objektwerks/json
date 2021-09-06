package objektwerks

object UPickleCodecs {
  import upickle.default._

  implicit val employeeRW: ReadWriter[Employee] = macroRW
  implicit val personRW: ReadWriter[Person] = ReadWriter.merge( macroRW[Employee] )
}