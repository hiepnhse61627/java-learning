package ocp1721book.hr;

import ocp1721book.Account;

public class HRAccount extends Account {

  public static void main(String[] args) {
    Account account = new Account();
//    account.accountId = "111";

    HRAccount hrAccount = new HRAccount();
    hrAccount.accountId = "222";

    System.out.println(hrAccount.accountId);
  }
}
