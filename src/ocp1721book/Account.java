package ocp1721book;

public class Account {

  protected String accountId;

  public void read() {
    System.out.println("Account Read");
  }

  public static void main(String[] args) {
    Account a = new Account();
    a.read();
  }
}
