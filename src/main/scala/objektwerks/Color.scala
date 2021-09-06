package objektwerks

sealed trait Color extends Product with Serializable {
  val name: String
  val code: String
}

final case class Navy(name: String, code: String) extends Color