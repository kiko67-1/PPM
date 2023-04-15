package projeto

object Cells extends Enumeration {
  type cell = Value
  val Red, Blue, Empty = Value
  val X= Int
  val Y= Int
  val rCell = (X, Y, Red)
  val bCell = (X, Y, Blue)
  def blue(cell: cell) = {
    cell == Blue
  }
  def red(cell: cell) = {
    cell == Red
  }
  def empty() = {
    Empty
  }
}