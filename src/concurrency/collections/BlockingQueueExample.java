package concurrency.collections;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {

  public static void main(String[] args) {
    var queue = new LinkedBlockingQueue<String>();
    // regular queue methods
    queue.offer("Red");
    queue.offer("Green");
    queue.offer("Blue");
    System.out.println(queue.poll());   // Red
    System.out.println(queue.peek());   // Green
    System.out.println(queue);          // [Green, Blue]

    // special BlockingQueue methods
    try {
      // block is queue full...
      queue.offer("White", 100, TimeUnit.MILLISECONDS);
      // block is queue empty
      queue.poll(200, TimeUnit.MILLISECONDS);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    System.out.println(queue);          // [Blue, White]
  }
}
