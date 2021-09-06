package objektwerks

sealed trait Person extends Product with Serializable
final case class Employee(id: Int, name: String) extends Person
object Employees {
  def newEmployee: Employee = Employee(1, "James Bond")
}