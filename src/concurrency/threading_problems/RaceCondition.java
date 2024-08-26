package concurrency.threading_problems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

  private int balance = 50;

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) {
    this.balance -= amount;
  }
}

public class RaceCondition implements Runnable {

  private static final Lock lock = new ReentrantLock();

  // There is ONLY ONE BankAccount! It is shared between the two threads.
  private final BankAccount bankAccount = new BankAccount();

  public static void main(String[] args) {
    var runnable = new RaceCondition(); // only 1 instance
    var john = new Thread(runnable);    // BOTH threads share the 1 instance
    var mary = new Thread(runnable);
    john.setName("John");
    mary.setName("Mary");
    john.start();
    mary.start();
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
//      makeWithdrawal1(10);
      makeWithdrawal2(10);
      if (bankAccount.getBalance() < 0) {
        System.out.println("Account is overdrawn!");
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private synchronized void makeWithdrawal1(int amount) {
//  private void makeWithdrawal1(int amount) {
    if (bankAccount.getBalance() >= amount) {
      System.out.println(
          Thread.currentThread().getName() + ". Balance BEFORE: " + bankAccount.getBalance());

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      bankAccount.withdraw(amount);
      System.out.println(
          Thread.currentThread().getName() + ". Balance AFTER: " + bankAccount.getBalance());
    } else {
      System.out.println(
          Thread.currentThread().getName() + " is unable to withdraw " + "as balance is: "
              + bankAccount.getBalance());
    }
  }

  // using lock
  private void makeWithdrawal2(int amount) {
    try {
      lock.lock(); // blocking call; one thread gets in, others wait
      if (bankAccount.getBalance() >= amount) {
        System.out.println(
            Thread.currentThread().getName() + ". Balance BEFORE: " + bankAccount.getBalance());

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        bankAccount.withdraw(amount);
        System.out.println(
            Thread.currentThread().getName() + ". Balance AFTER: " + bankAccount.getBalance());
      } else {
        System.out.println(
            Thread.currentThread().getName() + " is unable to withdraw " + "as balance is: "
                + bankAccount.getBalance());
      }
    } finally {
      lock.unlock();
    }
  }
}
