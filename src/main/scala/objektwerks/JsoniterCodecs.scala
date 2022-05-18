package objektwerks

object JsoniterCodecs:
  import com.github.plokhotnyuk.jsoniter_scala.core.*
  import com.github.plokhotnyuk.jsoniter_scala.macros.*

  implicit val personCodec: JsonValueCodec[Person] = JsonCodecMaker.make
  implicit val employeeCodec: JsonValueCodec[Employee] = JsonCodecMaker.make