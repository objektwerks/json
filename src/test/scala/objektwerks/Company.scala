package objektwerks

import upickle.default.{ReadWriter => RW, macroRW}

case class Company(name: String, address: String)

object Company {
  implicit val rw: RW[Company] = macroRW
}