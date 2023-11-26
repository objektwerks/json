package objektwerks

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BorerTest extends AnyFunSuite with Matchers:
  test("borer"):
    import io.bullet.borer.Json
    import BorerCodecs.given