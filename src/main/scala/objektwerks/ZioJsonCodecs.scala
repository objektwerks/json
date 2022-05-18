package objektwerks

object ZioJsonCodecs:
  import zio.json.*

  given personDecoder: JsonDecoder[Person] = DeriveJsonDecoder.gen[Person]
  given personEncoder: JsonEncoder[Person] = DeriveJsonEncoder.gen[Person]
  given employeeDecoder: JsonDecoder[Employee] = DeriveJsonDecoder.gen[Employee]
  given employeeEncoder: JsonEncoder[Employee] = DeriveJsonEncoder.gen[Employee]