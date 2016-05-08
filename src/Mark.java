
public enum Mark {
  X("X"), O("O"), EMPTY(" ");

  private String marker;

  Mark(String marker) {
    this.marker = marker;
  }

  @Override
  public String toString() {
    return this.marker;
  }
}
