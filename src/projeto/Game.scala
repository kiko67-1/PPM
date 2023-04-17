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
  def randomMove(board: Board, rand: MyRandom):((Int, Int), MyRandom)= {
      //val coordenates = emptyCells(board)
      //val int = coordenates()
    ((0,1), rand)
  }

  //tarefa 2
  def play(board: Board, player: Cells.cell, row: Int, col: Int): Board = {
    if (board(row)(col) == Cells.Empty) {
      moveHistory.push((row, col))
      if (hasContiguousLine(updatedBoard, player)) {
        println(s"Player $player wins!")
        updatedBoard
      } else {
        val nextPlayer = if (player == Cells.Red) Cells.Blue else Cells.Red
        updatedBoard
      }
    } else {
      println("Position already taken!")
      board
    }
  }

  //tarefa 3
  def printBoard(board: Board): String = {
    def printRow(row: List[Cells.cell]): String = row match {
      case Nil => ""
      case cell :: tail => s"${printCell(cell)} ${printRow(tail)}"
    }

    def printCell(cell: Cells.cell): String = cell match {
      case Cells.Red => "R"
      case Cells.Blue => "B"
      case Cells.Empty => "."
    }

    def printBoardHelper(board: List[List[Cells.cell]]): String = board match {
      case Nil => ""
      case row :: tail => s"${printRow(row)}${printBoardHelper(tail)}"
    }
    printBoardHelper(board)
  }

  //tarefa 4
  def hasContiguousLine(board: Board, player: Cells.cell): Boolean = {
    //por fazer
    false
  }

  //tarefa 5
  def undo(): Unit = {
    if (moveHistory.nonEmpty) {
      val (row, col) = moveHistory.pop()
      //board = board.updated(row, board(row).updated(col, Cells.Empty))
      //currentPlayer = if (currentPlayer == Cells.Red) Cells.Blue else Cells.Red
    } else {
      println("No moves to undo!")
    }
  }

}
