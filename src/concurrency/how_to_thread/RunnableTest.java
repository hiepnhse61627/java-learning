package concurrency.how_to_thread;

import java.util.concurrent.Executors;

public class RunnableTest {

  public static void main(String[] args) {
    // create an ExecutorService with a fixed thread pool consisting of one thread
    var es = Executors.newSingleThreadExecutor();

    // execute the Runnable task (asynchronously) - void run()
    es.execute(() -> System.out.println("Runnable Example"));

    // shutdown the executor service otherwise this application will never terminate;
    // existing tasks will be allowed to complete but no new tasks accepted
    es.shutdown();
  }
}
