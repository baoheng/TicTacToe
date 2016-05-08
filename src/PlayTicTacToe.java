import java.util.Scanner;

public class PlayTicTacToe {

  private Board board;
  private Mark turn;

  public PlayTicTacToe() {
    this.board = new Board();
    this.board.init();
    this.turn = Mark.X;

    Scanner input = new Scanner(System.in);
    while (!this.board.hasWon(Mark.O) && !this.board.hasWon(Mark.X) && !this.board.isTie()) {
      Boolean validInput = false;
      System.out.print("Player " + this.turn.toString() + " enter row(1-3) column(1-3): \n");
      this.board.print();
      Integer row = -1;
      Integer column = -1;

      while (!validInput) {
        row = input.nextInt() - 1;
        column = input.nextInt() - 1;
        if (row < 0 || row > Board.DIMENSION - 1 || column < 0 || column > Board.DIMENSION - 1) {
          System.out.println("Invalid input, Player " + this.turn.toString()
              + ", please enter row(1-3) column(1-3) again: ");
          this.board.print();
          continue;
        }
        validInput = true;
      }

      this.board.setMark(row, column, this.turn);
      this.board.print();

      switch (this.turn) {
        case X: {
          this.turn = Mark.O;
          break;
        }
        default: {
          this.turn = Mark.X;
        }
      }
    }
    input.close();

    if (this.board.isTie()) {
      System.out.println("The game ends in a tie.");
    } else if (this.board.hasWon(Mark.X)) {
      System.out.println("Player X has won.");
    } else {
      System.out.println("Player O has won.");
    }
  }

  public static void main(String[] args) {
    new PlayTicTacToe();
  }

}
