package projeto

object Main {
  def main(args: Array[String]): Unit = {
    val g: Game=Game(5)
    g.newGame()
  }













/*

  class Tarefas {

    def randomMove(board: Array[Array[Char]], rand: scala.util.Random): ((Int, Int), scala.util.Random) = {
      val validMoves = for {
        i <- 0 until board.length
        j <- 0 until board(i).length
        if board(i)(j) == ' '
      } yield (i, j)
      if ( validMoves.isEmpty ) throw new IllegalStateException("No valid moves")
      val (i, j) = validMoves(rand.nextInt(validMoves.length))
      ((i, j), rand)
    }

    def play(board: Array[Array[Char]], player: Char, row: Int, col: Int): Array[Array[Char]] = {
      if ( board(row)(col) != ' ' ) throw new IllegalArgumentException("Invalid move")
      val newBoard = board.clone()
      newBoard(row)(col) = player
      newBoard
    }

    def printBoard(board: Array[Array[Char]]): Unit = {
      for {
        i <- 0 until board.length
        j <- 0 until board(i).length
      } {
        if ( j == 0 ) print("| ")
        print(board(i)(j) + " | ")
        if ( j == board(i).length - 1 ) println()
      }
    }

    import scala.collection.mutable.Stack

    // Define uma classe para representar o estado do jogo
    case class GameState(board: Array[Array[Char]], player: Char)

    // Define uma pilha para armazenar os estados do jogo
    val gameStateStack = Stack[GameState]()

    // Função para realizar uma jogada
    def play(board: Array[Array[Char]], player: Char, row: Int, col: Int): Array[Array[Char]] = {
      if ( board(row)(col) != ' ' ) throw new IllegalArgumentException("Invalid move")
      val newBoard = board.clone()
      newBoard(row)(col) = player
      // Armazena o estado atual do jogo na pilha
      gameStateStack.push(GameState(newBoard, player))
      newBoard
    }

    // Define uma pilha para armazenar os estados do jogo
    val gameStateStack = Stack[GameState]()

    // Função para realizar uma jogada
    def play(board: Array[Array[Char]], player: Char, row: Int, col: Int): Array[Array[Char]] = {
      if ( board(row)(col) != ' ' ) throw new IllegalArgumentException("Invalid move")
      val newBoard = board.clone()
      newBoard(row)(col) = player
      // Armazena o estado atual do jogo na pilha
      gameStateStack.push(GameState(newBoard, player))
      newBoard
    }

    // Função para desfazer a última jogada
    def undo(): Unit = {
      if ( gameStateStack.isEmpty ) throw new IllegalStateException("No moves to undo")
      // Remove o último estado da pilha e atualiza o tabuleiro atual
      val lastState = gameStateStack.pop()
      lastState.board(lastState.board.length - 1)(lastState.board(0).length - 1) = ' '
    }

    // Exemplo de uso
    val board = Array.fill(3, 3)(' ')
    play(board, 'X', 0, 0)
    play(board, 'O', 1, 1)
    undo()

    import scala.io.StdIn.readLine

    // Define uma classe para representar o jogo
    case class Game(board: Array[Array[Char]], player: Char) {
      // Função para realizar uma jogada
      def play(row: Int, col: Int): Unit = {
        if ( board(row)(col) != ' ' ) throw new IllegalArgumentException("Invalid move")
        board(row)(col) = player
      }

      // Função para trocar o jogador atual
      def switchPlayer(): Unit = {
        player = if ( 'X' == player ) 'O' else 'X'
      }

      // Função para imprimir o tabuleiro
      def printBoard(): Unit = {
        for {
          i <- 0 until board.length
          j <- 0 until board(i).length
        } {
          if ( j == 0 ) print("| ")
          print(board(i)(j) + " | ")
          if ( j == board(i).length - 1 ) println()
        }
      }
    }

    // Função para criar um novo jogo com tabuleiro de dimensão configurável
    def newGame(): Game = {
      print("Enter the size of the board (e.g. 3 for a 3x3 board): ")
      val size = readLine().toInt
      val board = Array.fill(size, size)(' ')
      val player = 'X'
      Game(board, player)
    }

    // Função para imprimir as opções de interação com o jogo
    def printOptions(): Unit = {
      println("Options:")
      println("1. Play")
      println("2. Undo")
      println("3. Quit")
    }

  }

*/
}