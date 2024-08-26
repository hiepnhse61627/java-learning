package concurrency.data_race_problems;

public class DataRace {

  private static int count = 0;

  public static void addToCounter() {
    int c = count;
    System.out.println("Before: " + count + ". Thread id: " + Thread.currentThread().getName());
    count = c + 1; // not atomic
    System.out.println("After: " + count + ". Thread id: " + Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(DataRace::addToCounter).start();
    }
  }
}
