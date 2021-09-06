package objektwerks

sealed trait Person extends Product with Serializable
final case class Employee(id: Int, name: String) extends Person
object Employee {
  def newInstance: Employee = Employee(1, "James Bond")
}