package concurrency.how_to_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmittingTaskCollections {

  // Single Thread Executors will accept tasks sequentially in the order they are submitted.
//  private static ExecutorService executorService = Executors.newSingleThreadExecutor()
  // with 4 threads to share the work, there is no guarantee which letter will appear first
  private static ExecutorService executorService = Executors.newFixedThreadPool(4);
  private static List<Callable<String>> callables = new ArrayList<>();

  public static void main(String[] args) {
    callables.add(() -> "A"); // adding Callable tasks
    callables.add(() -> "B");
    callables.add(() -> "C");
    callables.add(() -> "D");

//    invokeAny();
    invokerAll();
  }

  public static void invokeAny() {
    try {
      // submitting a collection of tasks
      // executes synchronously and returns when one of the tasks has completed, all other tasks are cancelled.
      // Note: Sing thread executor wil always execute the first task submitted.
      String result = executorService.invokeAny(callables); // TimeUnit overloaded version exists
      System.out.println(result);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    } finally {
      // don't forget to shut down the executor
      // finally always executes
      executorService.shutdown();
    }

    System.out.println("Always at the end!");
  }

  public static void invokerAll() {
    try {
      // submitting a collection of tasks
      // executes synchronously and returns when all the tasks are completed
      // order is maintained i.e. the result for callables.get(0) goes into list.get(0)
      var list = executorService.invokeAll(callables); // TimeUnit overloaded version exists
      for (var future : list) {
        System.out.println(future.get()); // A, B, C, D in order
      }
    } catch (InterruptedException | ExecutionException ex) {
      throw new RuntimeException(ex);
    } finally {
      // don't forget to shut down the executor
      // finally always executes
      executorService.shutdown();
    }
    System.out.println("Always at the end!");
  }
}
