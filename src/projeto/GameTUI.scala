package projeto

object GameTUI {
  def run(): Unit = {
    def showOptions(): Unit = {
      println("Game Options")
      println("1. Start Game")
      println("2. Exit")
      print("Enter your choice: ")
      val choice = scala.io.StdIn.readLine()
      choice match {
        case "1" => println("Starting game...")
          print("Enter board size: ")
          val newSize = scala.io.StdIn.readInt()
          println(s"Board size set to $newSize")
          Game.printBoard(Game.Board)
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
