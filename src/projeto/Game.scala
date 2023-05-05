package projeto

import projeto.Game.player
import scala.util.Random
import scala.collection.immutable.::

object Game extends App{

  type cells=Cells.cell
  type Board = List[List[Cells.cell]]
  val player = Cells.Blue

  def run(size: Int): Unit = {
    val board: Board = List.fill(size)(List.fill(size)(Cells.Empty))
    println("Starting Game... \n")
    print("You move like this: 32 (row 3, column 2)")
    printBoard(board)
    move(board)
    println("\nExiting game...")
  }

  def getEmptyCells(board: Board): List[(Int, Int)] = { board.zipWithIndex.flatMap {
    case (row, rowIndex) =>
      row.zipWithIndex.collect {
        case (cell, colIndex) if cell == Cells.Empty => (rowIndex, colIndex)
      }
  }
  }
  //tarefa 1
  def randomMove(board: Board, rand: MyRandom): ((Int, Int), MyRandom) = {
    val emptyCells = getEmptyCells(board)
    val (index, nextRand) = rand.nextInt
    val cell = emptyCells(index % emptyCells.length)
    ((cell._1, cell._2), nextRand.asInstanceOf[MyRandom])
  }
  def move(board: Board): Unit = {
    print("\nYour move: ")
    val m = scala.io.StdIn.readLine()
    if(m.size==2) {
      val Array(row, col) = m.split("").map(_.toInt)

      if ( row > board.size || col > board.size || row <= 0 || col <= 0 ) {
        println("Invalid coordinates! Try again")
        move(board)
      } else {
        play(board, Cells.Blue, row, col)
      }
    }
    println("Invalid coordinates! Use two numbers")
    move(board)
  }
  //tarefa 2
  def play(board: Board, player: Cells.cell, row: Int, col: Int): Board = {
    if(row-1>=board.length || col-1>=board.size){
      println("Invalid coordinates! Try again")
      move(board)
    }
    val updatedBoard = board.updated(row-1, board(row-1).updated(col-1, player))
    if (board(row-1)(col-1) == Cells.Empty) {
      printBoard(updatedBoard)+println()
      if (hasContiguousLine(updatedBoard, player)) {
        println(s"Player $player wins!")
        updatedBoard
      } else {
        println("Computer moved: ")
        val rand = MyRandom(1)
        val ((row2, col2),rand1) = randomMove(updatedBoard, rand)
        if (row2 >= board.length || col2 >= board.size) play(board, Cells.Blue, row, col)
        val updatedBoard2 = updatedBoard.updated(row2, updatedBoard(row2).updated(col2, Cells.Red))
        if ( updatedBoard(row2)(col2) == Cells.Empty ) {
          printBoard(updatedBoard2) + println()
          move(updatedBoard2)
        }else{
          play(board, Cells.Blue, row, col)
        }
        updatedBoard2
      }
    } else {
      println("Position already taken!")
      move(board)
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
      case row :: tail => s"${println()+printRow(row)}${printBoardHelper(tail)}" // ver se da para implementar as diagonais
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
  def undo(board: Board, moves: List[(Int, Int)]): Board = { moves.foldLeft(board) {
    case (currentBoard, (row, col)) => currentBoard.updated(row, currentBoard(row).updated(col, Cells.Empty)) //tentar implementar dentro do jogo
  }
  }
}
