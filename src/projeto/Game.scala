package projeto

import projeto.Game.player
import scala.util.Random
import scala.collection.immutable.::

object Game extends App{

  type cells=Cells.cell
  type Board = List[List[Cells.cell]]
  //val moveHistory = Stack[(Int, Int)]()
  val player = Cells.Blue

  def run(size: Int): Unit = {
    val board: Board = List.fill(size)(List.fill(size)(Cells.Empty))
    println("Starting Game... \n")
    println("You move like this: 3,2 (row 3, column 2)")
    printBoard(board)
    print("\nYour move: ")
    val move = scala.io.StdIn.readLine()
    val Array(row1, col1) = move.split(",").map(_.toInt)
    play(board, Cells.Blue, row1, col1)
    println("\nExiting game...")
  }

  def getEmptyCells(board: Board): List[(Int, Int)] = {
    board.zipWithIndex.flatMap { case (row, rowIndex) =>
      row.zipWithIndex.collect { case (cell, colIndex) if cell == Cells.Empty =>
        (rowIndex, colIndex)
      }
    }
  }
  //tarefa 1
  def randomMove(board: Board, rand: Random): (Int, Int) = {
    val emptyCells = getEmptyCells(board)
    val index = rand.nextInt(emptyCells.length)   //corrigir para ter o myRandom
    val pos= emptyCells(index)
    pos
  }

  //tarefa 2
  def play(board: Board, player: Cells.cell, row: Int, col: Int): Board = {
    val updatedBoard = board.updated(row, board(row).updated(col, player))
    if (board(row)(col) == Cells.Empty) {
  //    moveHistory.push((row, col))
      printBoard(updatedBoard)+println()
      if (hasContiguousLine(updatedBoard, player)) {
        println(s"Player $player wins!")
        updatedBoard
      } else {
        println("Computer moved: ")
        val rand = new Random()
        val (row, col) = randomMove(updatedBoard, rand)
        val updatedBoard2 = updatedBoard.updated(row, updatedBoard(row).updated(col, Cells.Red))
        if ( updatedBoard(row)(col) == Cells.Empty ) {
          printBoard(updatedBoard2) + println()
          print("\nYour move: ")
          val move = scala.io.StdIn.readLine()
          val Array(row1, col1) = move.split(",").map(_.toInt)
          play(updatedBoard2, Cells.Blue, row1, col1)
        }
        updatedBoard2
      }
    } else {
      println("Position already taken!")
      print("\nYour move: ")
      val move = scala.io.StdIn.readLine()
      val Array(row1, col1) = move.split(",").map(_.toInt)
      play(board, Cells.Blue, row1, col1)
      board
    }
  }

  //tarefa 3
  def printBoard(board: Board): String = {
    def printRow(row: List[Cells.cell]): String = row match {
      case Nil => ""
      case null :: tail => ""
      case cell :: tail => s"${print(" ")}${printCell(cell)} ${printRow(tail)}"
    }

    def printCell(cell: Cells.cell): Unit = cell match {
      case Cells.Red => print("R")
      case Cells.Blue => print("B")
      case Cells.Empty => print("X")
    }

    def printBoardHelper(board: Board): String = board match {
      case Nil => ""
      case row :: tail =>
        val i=0
        s"${println(s" "*(i-Game.board.size)+printRow(row)}${printBoardHelper(tail)}" // ver se consigo implementar as diagonais
      case _ => ""
    }
    printBoardHelper(board)
  }

  //tarefa 4
  def hasContiguousLine(board: Board, player: Cells.cell): Boolean = {
    //por fazer
    false
  }

  //tarefa 5

  def undo(board: Board, moves: List[(Int, Int)]): Board = {
    moves.foldLeft(board) { case (currentBoard, (row, col)) =>
      currentBoard.updated(row, currentBoard(row).updated(col, Cells.Empty))
    }
  }

}
