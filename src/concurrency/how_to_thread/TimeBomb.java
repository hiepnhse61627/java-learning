package concurrency.how_to_thread;

class CountDown implements Runnable {

  String[] timeString
      = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

//  @Override
//  public void run() {
//    for (int i = 9; i >= 0; i--) {
//      System.out.println(timeString[i]);
//    }
//  }


  @Override
  public void run() {
    for (int i = timeString.length - 1; i >= 0; i--) {
      try {
        System.out.println(timeString[i]);
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class TimeBomb {

  public static void main(String[] args) {
    var timer = new Thread(new CountDown());
    System.out.println("Starting 10 second count down... ");
    timer.start();
    try {
      // The 'main' thead must wait here... until timer thread is finished.
      // Join onto the end of timer thread.
      timer.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println("Boom!!!");
  }
}
