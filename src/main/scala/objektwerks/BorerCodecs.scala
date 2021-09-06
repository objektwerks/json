package objektwerks

object BorerCodecs {
  import io.bullet.borer.derivation.ArrayBasedCodecs._

  implicit val employeeCodec = deriveCodec[Employee]
  implicit val personCodec = deriveAllCodecs[Person]
}