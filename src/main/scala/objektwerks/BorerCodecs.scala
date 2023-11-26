package objektwerks

import io.bullet.borer.Codec
import io.bullet.borer.derivation.MapBasedCodecs.*


given Codec[Person] = deriveAllCodecs[Person]