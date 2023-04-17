package projeto

object Main {
  def main(args: Array[String]): Unit = {
    val g = GameTUI
    val d=Game(5)
    d.printBoard()
    //g.run()
  }

/*
    // Define uma pilha para armazenar os estados do jogo
    val gameStateStack = Stack[GameState]()

    // Função para desfazer a última jogada
    def undo(): Unit = {
      if ( gameStateStack.isEmpty ) throw new IllegalStateException("No moves to undo")
      // Remove o último estado da pilha e atualiza o tabuleiro atual
      val lastState = gameStateStack.pop()
      lastState.board(lastState.board.length - 1)(lastState.board(0).length - 1) = ' '
    }
*/
}