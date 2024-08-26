package concurrency.how_to_thread;

import java.util.concurrent.Executors;

public class VariousTypes {

  public static void main(String[] args) {
    // CachedThreadPool
    var cachedThreadPool = Executors.newCachedThreadPool();

    // FixedThreadPool
    var cpuCount = Runtime.getRuntime().availableProcessors();
    var fixedThreadPool = Executors.newFixedThreadPool(cpuCount);

    // SingleThreadPool
    var singleThreadPool = Executors.newSingleThreadExecutor();
  }
}
