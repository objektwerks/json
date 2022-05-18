package objektwerks

sealed trait Person:
  def name: String

final case class Employee(id: Int, name: String) extends Person

object Employees:
  def newEmployee: Employee = Employee(1, "James Bond")