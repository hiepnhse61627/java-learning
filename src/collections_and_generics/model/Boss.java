package collections_and_generics.model;

public class Boss implements Comparable<Boss> {

  private int id;

  public Boss(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public int compareTo(Boss o) {
    return this.id - o.getId();
  }

  @Override
  public String toString() {
    return "Boss{" +
        "id=" + id +
        '}';
  }
}
