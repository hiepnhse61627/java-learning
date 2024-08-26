package concurrency.data_race_problems;

/*
// 1.
        public synchronized static void addToCounter(){
// 2.
        public static void addToCounter(){
            synchronized(FixRaceWithSynchronized.class){
// 3.
        synchronized(lock){
// 4.
        synchronize on 'this'
//          - make addToCounter() an instance method
//          - synchronized(this) inside the method
//          - create an instance of the overall class FixRaceWithSynchronized in main()
//          - ensure that all the threads share the same instance!
*/
public class FixRaceWithSynchronized {

  private static final Object lock = new Object();
  private static int count = 0;

//  public synchronized static void addToCounter() {
//    int c = count;
//    System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getName());
//    count = c + 1; // not atomic
//    System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getName());
//  }

//  public static void addToCounter() {
//    synchronized (FixRaceWithSynchronized.class) {
//      int c = count;
//      System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getName());
//      count = c + 1; // not atomic
//      System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getName());
//    }
//  }

//  public static void addToCounter() {
//    synchronized (lock) {
//      int c = count;
//      System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getName());
//      count = c + 1; // not atomic
//      System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getName());
//    }
//  }

  public synchronized void addToCounter() {
    //        synchronized(this){
    int c = count;
    System.out.println("Before. " + count + ". Thread id: " + Thread.currentThread().getName());
    count = c + 1; // not atomic
    System.out.println("After. " + count + ". Thread id: " + Thread.currentThread().getName());
    // }
  }

  public static void main(String[] args) {
    // When sync on 'this' make sure all threads use the same instance
    FixRaceWithSynchronized instance = new FixRaceWithSynchronized();
    for (int i = 0; i < 10; i++) {
      new Thread(instance::addToCounter).start();
//      new Thread(() -> addToCounter()).start();
    }
  }
}
