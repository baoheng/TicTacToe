
public class Board {

  protected static final Integer DIMENSION = 3;
  private Cell[][] cells;

  public Board() {
    this.cells = new Cell[Board.DIMENSION][Board.DIMENSION];
    for (int i = 0; i < Board.DIMENSION; i++) {
      for (int j = 0; j < Board.DIMENSION; j++) {
        this.cells[i][j] = new Cell();
      }
    }
  }

  public void init() {
    for (int i = 0; i < Board.DIMENSION; i++) {
      for (int j = 0; j < Board.DIMENSION; j++) {
        this.cells[i][j].clear();;
      }
    }
  }

  public void print() {
    System.out.println("-------------");
    for (int i = 0; i < Board.DIMENSION; i++) {
      System.out.println("| " + this.cells[i][0].getContent().toString() + " | "
          + this.cells[i][1].getContent().toString() + " | "
          + this.cells[i][2].getContent().toString() + " |");
      System.out.println("-------------");
    }
  }

  public boolean hasWon(Mark m) {
    Boolean result = false;
    for (int i = 0; i < 3; i++) {
      if (this.cells[i][0].getContent() == m && this.cells[i][1].getContent() == m
          && this.cells[i][2].getContent() == m) {
        result = true;
      } else if (this.cells[0][i].getContent() == m && this.cells[1][i].getContent() == m
          && this.cells[2][i].getContent() == m) {
        result = true;
      }
    }
    if (this.cells[0][0].getContent() == m && this.cells[1][1].getContent() == m
        && this.cells[2][2].getContent() == m) {
      result = true;
    } else if (this.cells[0][2].getContent() == m && this.cells[1][1].getContent() == m
        && this.cells[2][0].getContent() == m) {
      result = true;
    }
    return result;
  }

  public boolean isTie() {
    if (hasWon(Mark.X) || hasWon(Mark.O)) {
      return false;
    }
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.cells[i][j].getContent() != Mark.EMPTY) {
          count++;
        }
      }
    }
    if (count == 9) {
      return true;
    }
    return false;
  }

  public void setMark(Integer row, Integer column, Mark m) {
    this.cells[row][column].setContent(m);
  }
}
