package json

trait Common {
  def debug(title: String, name: Entity, json: String): Unit = {
    println(s"*** $title")
    println(s"name: $name")
    println(s"json: $json")
  }
}