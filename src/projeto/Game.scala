package projeto
import scala.util.Random
import projeto.Game._

import scala.::
case class Game(size: Int){
  def newGame()= Game.newGame(size)

}

object Game {

  type cells=Cells.cell
  type board = List[List[Cells.cell]]


/*def
  def updateBoard(b: Game):board={ board match{
    case Nil=>Nil
    case (h1::t1)=> h1::showBoard(t1)
        case Cells.Red => "X"
        case Cells.Blue => "O"
        case Cells.Empty => "."
      }
  }
*/
  def newGame(size: Int): board = {
    val row1 = List.fill(size)("*").mkString("   ")
    val row2 = List.fill(size)(". -").mkString(" ")
    val row3 = List.fill(size)("\\ /").mkString(" ")
    val row4 = List.fill(size)("* .").mkString(" ")
    val row5 = List.fill(size)("- .").mkString(" ")
    val rows = List(row1, row2, row3, row4, row5)

    rows.map(row => row.split(" ").map {
      case "." => Cells.Empty
    }.toList)
  }


  //tarefa 1

  //def randomMove(board: board, rand: Random):((Int, Int), Random)= {
   // val a=Int
  //}

}
