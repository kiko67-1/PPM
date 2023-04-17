package projeto

import projeto.Game

object GameTUI extends App {

  def run(): Unit = {
    def showOptions(): Unit = {
      println("Game Options")
      println("1. Start Game")
      println("2. Exit")
      print("Enter your choice: ")
      val choice = scala.io.StdIn.readLine()
      choice match {
        case "1" => println("Starting game... \n")
          print("Enter board size: ")
          val newSize = scala.io.StdIn.readInt()
          println(s"Board size set to $newSize")
          Game.run(newSize)
          return
        case "2" => println("Exiting game...")
          return
        case _ => println("Invalid choice. Please try again.")
      }
      showOptions()
    }
    showOptions()
  }
}
