package concurrency.data_race_problems;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// No duplicated numbers; guaranteed to get to 10.
// However, order is still not guaranteed.
public class AtomicIntegerExample {

  private static AtomicInteger atomicCount = new AtomicInteger(0);

  public static void main(String[] args) {
    var es = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      es.submit(() -> System.out.print(atomicCount.incrementAndGet() + " "));
    }
    es.shutdown();
  }
}
