package projeto

import projeto.Game._
import scala.util.Random
import scala.collection.mutable.Stack

case class Game(size: Int){
  def play()= Game.play(board: Board, player: Cells.cell, row: Int, col: Int)
  def emptyCells()= Game.emptyCells(board: Board,row: Int, col: Int)
  def printBoard()= Game.printBoard(board: Board)
  def hasContiguousLine()= Game.hasContiguousLine(board: Board, player: Cells.cell)
  def undo()= Game.undo()


}

object Game {

  val size=size
  type cells=Cells.cell
  type Board = List[List[Cells.cell]]
  val board: Board = List.fill(size)(List.fill(size)(Cells.Empty))
  val currentPlayer = Cells.Red
  val moveHistory = Stack[(Int, Int)]()
  val player = Cells.Red
  val row=size
  val col=size

 def emptyCells(board:Board,row: Int = 0, col: Int = 0): List[(Int,Int)] = {
   if(board.isEmpty){
     List()
   } else if (board.head.isEmpty) {
     emptyCells(board.tail, row + 1, 0)
   } else if (board.head.head == Cells.Empty) {
     (row, col) :: emptyCells(board.head.tail :: board.tail, row, col + 1)
   } else {
     emptyCells(board.head.tail :: board.tail, row, col + 1)
   }
 }
  //tarefa 1

  //def randomMove(board: board, rand: Random):((Int, Int), Random)= {
   // val a=Int
  //}

}
