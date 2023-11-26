package objektwerks

import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs.*

object BorerCodecs:
  given Codec[Person] = deriveCodec[Person]
  given Codec[Employee]  = deriveCodec[Employee]