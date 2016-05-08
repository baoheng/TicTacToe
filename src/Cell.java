
public class Cell {

  private Mark content;

  public Cell() {
    this.content = Mark.EMPTY;
  }

  public void clear() {
    setContent(Mark.EMPTY);
  }

  public void setContent(Mark content) {
    this.content = content;
  }

  public Mark getContent() {
    return this.content;
  }
}
