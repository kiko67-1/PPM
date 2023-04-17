package projeto

import projeto.Game._
import scala.util.Random
import scala.collection.mutable.Stack

case class Game(size: Int){
  def run()=Game.run()
  def play()= Game.play(board: Board, player: Cells.cell, row: Int, col: Int)
  def emptyCells()= Game.emptyCells(board: Board,row: Int, col: Int)
  def printBoard()= Game.printBoard(board: Board)
  //def hasContiguousLine()= Game.hasContiguousLine(board: Board, player: Cells.cell)
  def undo()= Game.undo()
}

object Game {

  val size=0
  type cells=Cells.cell
  type Board = List[List[Cells.cell]]
  val board: Board = List.fill(size)(List.fill(size)(Cells.Empty))
  val updatedBoard = board.updated(row, board(row).updated(col, player))
  val currentPlayer = Cells.Red
  val moveHistory = Stack[(Int, Int)]()
  val player = Cells.Red
  val row=size
  val col=size

  def run(): Unit = {
    println("Starting HEX game...")
    println("You move like this: 3,2 (row 3, column 2")
    printBoard(board)
    while(!hasContiguousLine(updatedBoard, player)){
      println("Your move: ")
      val move = scala.io.StdIn.readLine()
      val Array(row1, col1) = move.split(",").map(_.toInt)
      play(board, Cells.Red, row1, col1)
      val rand = MyRandom(1)
      val (row2, col2)= randomMove(board, rand)
      play(board, Cells.Blue, row2._1, row2._2)
    }
    println("Exiting game...")
  }

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
