package objektwerks

import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs.*

object BorerCodes:
  given Codec[Person] = deriveAllCodecs[Person]