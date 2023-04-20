package projeto

import projeto.Game

import scala.util.control.Breaks

object GameTUI extends App {

  def run(): Unit = {
    println("Game Options")
    println("1. Start Game")
    println("2. Exit")
    def showOptions(): Unit = {
      print("Enter your choice: ")
      val choice = scala.io.StdIn.readLine()
      choice match {
        case "1" => println("Starting game... \n")
          boardSize()
          def boardSize(): Unit= {
            print("Enter board size: ")
            val size = scala.io.StdIn.readInt()
            if (size <= 0) {
              println("Invalid size. Please try again.")
              boardSize()
            }
            println(s"Board size set to $size")
            Game.run(size)
          }
          return
        case "2" => println("Exiting game...")
          return
        case "" => println("Invalid choice. Please try again.")
        case _ => println("Invalid choice. Please try again.")
      }
      showOptions()
    }
    showOptions()
  }
}