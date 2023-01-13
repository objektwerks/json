package objektwerks

object ZioJsonCodecs:
  import zio.json.*

  given JsonDecoder[Person] = DeriveJsonDecoder.gen[Person]
  given JsonEncoder[Person] = DeriveJsonEncoder.gen[Person]
  given JsonDecoder[Employee] = DeriveJsonDecoder.gen[Employee]
  given JsonEncoder[Employee] = DeriveJsonEncoder.gen[Employee]