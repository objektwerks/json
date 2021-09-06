package objektwerks

import spray.json.DefaultJsonProtocol

object ColorCodecs extends DefaultJsonProtocol {
  import spray.json._

  implicit val navyFormat = jsonFormat2(Navy)

  def write(color: Color): JsValue = color match {
    case navy: Navy => navy.toJson
  }

  def read(json: JsValue): Color = json.convertTo[Navy]
}