package objektwerks

object JsoniterCodecs:
  import com.github.plokhotnyuk.jsoniter_scala.core.*
  import com.github.plokhotnyuk.jsoniter_scala.macros.*

  given JsonValueCodec[Person] = JsonCodecMaker.make[Person]( CodecMakerConfig.withDiscriminatorFieldName(None) )
  given JsonValueCodec[Employee] = JsonCodecMaker.make[Employee]