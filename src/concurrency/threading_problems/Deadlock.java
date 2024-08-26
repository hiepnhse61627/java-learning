package concurrency.threading_problems;

public class Deadlock {

  public static void go() {
    final String ransom = "ransom";
    final String hostage = "hostage";

    var criminals = new Thread(() -> {
      synchronized (hostage) {
        System.out.println("The criminals have the hostage and want the ransom....");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        // make sure this next block is inside the first synchronized block
        synchronized (ransom) {
          System.out.println("The criminals have BOTH!");
        } // auto release of lock on 'ransom'
      } // auto release of lock on 'hostage'
    });

    var police = new Thread(() -> {
      synchronized (ransom) {
        System.out.println("The police has the ransom and want the hostage...");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        synchronized (hostage) {
          System.out.println("The police has BOTH!");
        } // auto release of lock on 'hostage'
      } // auto release of lock on 'ransom'
    });

    criminals.start();
    police.start();
  }

  public static void main(String[] args) {
    go();
  }
}
