package objektwerks

object ZioJsonCodecs {
  import zio.json._

  implicit val personDecoder: JsonDecoder[Person] = DeriveJsonDecoder.gen[Person]
  implicit val personEncoder: JsonEncoder[Person] = DeriveJsonEncoder.gen[Person]
  implicit val employeeDecoder: JsonDecoder[Employee] = DeriveJsonDecoder.gen[Employee]
  implicit val employeeEncoder: JsonEncoder[Employee] = DeriveJsonEncoder.gen[Employee]
}