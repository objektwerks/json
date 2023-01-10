package objektwerks

object JsoniterCodecs:
  import com.github.plokhotnyuk.jsoniter_scala.core.*
  import com.github.plokhotnyuk.jsoniter_scala.macros.*

  given personCodec: JsonValueCodec[Person] = JsonCodecMaker.make[Person]( CodecMakerConfig.withDiscriminatorFieldName(None) )
  given employeeCodec: JsonValueCodec[Employee] = JsonCodecMaker.make[Employee]( CodecMakerConfig.withDiscriminatorFieldName(None) )