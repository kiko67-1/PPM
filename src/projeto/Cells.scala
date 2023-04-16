package projeto

object Cells extends Enumeration {
  type cell = Value
  val Red, Blue, Empty = Value
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