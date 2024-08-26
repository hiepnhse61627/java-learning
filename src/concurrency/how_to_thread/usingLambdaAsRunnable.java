package concurrency.how_to_thread;

public class usingLambdaAsRunnable {

  public static void main(String[] args) {
    Thread t = new Thread(() -> System.out.println("run(): " + Thread.currentThread().getName()));
    t.start();
//    t.run(); // main thread
    System.out.println("main(): " + Thread.currentThread().getName());
  }
}
