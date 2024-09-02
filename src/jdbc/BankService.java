package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankService {

  private static Connection con;
  private static final BankService bankService = new BankService(); // connect to db

  public BankService() {
    try {
      var resource = new ResourceLoader();
      con = DriverManager.getConnection(
          resource.getUrl(),
          resource.getUsername(),
          resource.getPassword()
      );
      System.out.println("DB connection OK!");
    } catch (SQLException e) { // SQLException is a checked exception
      System.out.println("Exception occurred: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    System.out.println("=".repeat(60) + " retrieveOne " + "=".repeat(60));
    bankService.retrieveOne();

    System.out.println("=".repeat(60) + " retrieveAll " + "=".repeat(60));
    bankService.retrieveAll();

    System.out.println("=".repeat(60) + " deleteOne " + "=".repeat(60));
    bankService.deleteOne();

    System.out.println("=".repeat(60) + " deleteAll " + "=".repeat(60));
    bankService.deleteAll();

    System.out.println("=".repeat(60) + " add " + "=".repeat(60));
    bankService.add();

    System.out.println("=".repeat(60) + " update " + "=".repeat(60));
    bankService.update();
  }

  public void retrieveOne() {
    // retrieve one bank account
    System.out.println(bankService.getAccountDetails("123456", "12345678"));
  }

  public void retrieveAll() {
    // retrieve all bank accounts
    for (var bankAccount : bankService.getAllAccounts()) {
      System.out.println(bankAccount);
    }
  }

  public void deleteOne() {
    // delete one bank account
    var nRows = bankService.deleteBankAccount("123456", "12345678");
    if (nRows == 1) {
      System.out.println("Delete OK: " + nRows);
    } else {
      System.err.println("Delete Error: " + nRows);
    }
  }

  public void deleteAll() {
    // delete all bank accounts
    bankService.deleteAllAccounts();
  }

  public void add() {
    // add a bank account
    var nRows = bankService.addBankAccount(
        new BankAccount("123456", "12345678",
            "SK", "Dublin", 100));
    if (nRows == 1) {
      System.out.println("Add OK: " + nRows);
    } else {
      System.out.println("Add error: " + nRows);
    }
  }

  public void update() {
    // Update
    var bankAccount = bankService.getAccountDetails("123456", "12345678");
    System.out.println("BEFORE Update: " + bankAccount);
    bankAccount.setCustName("J. Bloggs");
    bankAccount.setCustAddress("London");
    var nRows = bankService.updateBankAccount(bankAccount);
    if (nRows == 1) {
      System.out.println("Update OK: " + nRows);
      System.out.println("AFTER Update: " + bankService.getAccountDetails("123456", "12345678"));
    } else {
      System.out.println("Add error: " + nRows);
    }
  }

  // SELECT one account
  private BankAccount getAccountDetails(String branchCode, String accountNo) {
    // A '?' called a 'bind variable'. It is a placeholder that we can populate at runtime.
    var selectSQL = "SELECT * FROM banks WHERE (branch_code = ? AND account_number = ?)";
    BankAccount bankAccount = null;

    // Cannot put the prepareStatement() and executeQuery() in the try-with-resource braces
    // as we have bind variables that must be set in between these 2 commands
    try (var ps = con.prepareStatement(selectSQL)) {

      ps.setString(1, branchCode); // column start at 1 in JDBC
      ps.setString(2, accountNo);

      var rs = ps.executeQuery(); // implies SELECT

      // Move the cursor to the first row
      if (!rs.next()) { // no records found
        return bankAccount; // null
      }

      bankAccount = new BankAccount(
          // API:
          // boolean rs.getBoolean(String columnLabel) also overloaded: boolean getBoolean(int columnIndex)
          // double rs.getDouble(String columnLabel) also overloaded: double getDouble(int columnIndex)
          // int rs.getInt(String columnLabel) also overloaded: int getInt(int columnIndex)
          // long rs.getLong(String columnLabel) also overloaded: long getLong(int columnIndex)
          // T rs.getObject(String columnLabel, Class<T> type ) also overloaded:
          //      T rs.getObject(int columnIndex, Class<T> type )
          rs.getString("BRANCH_CODE"),
          rs.getString(2), // "ACCOUNT_NUMBER"
          rs.getString("CUST_NAME"),
          rs.getString("CUST_ADDRESS"),
          rs.getDouble("BALANCE")
      );

    } catch (SQLException sqlException) {
      System.err.println("SQLException in getAccountDetails()");
      sqlException.printStackTrace();
    }

    return bankAccount;
  }

  // SELECT all accounts
  private List<BankAccount> getAllAccounts() {
    var bankAccounts = new ArrayList<BankAccount>();

    var selectSQL = "SELECT * FROM banks"; // no WHERE clause this time => get all records/rows
    try (var ps = con.prepareStatement(selectSQL)) {
      boolean isResultSet = ps.execute();
      if (isResultSet) { // yes, as we did a SELECT
        var rs = ps.getResultSet();
        while (rs.next()) {
          // process the record
          bankAccounts.add(new BankAccount(
              rs.getString(1),    // "BRANCH_CODE"
              rs.getString("ACCOUNT_NUMBER"),
              rs.getString("CUST_NAME"),
              rs.getString("CUST_ADDRESS"),
              rs.getDouble("BALANCE"))
          );
        }
      }
    } catch (SQLException sqlException) {
      System.err.println("SQLException in getAccountDetails()");
      sqlException.printStackTrace();
    }

    return bankAccounts;
  }

  // DELETE one account
  private int deleteBankAccount(String branchCode, String accountNo) {
    var nRows = -1;
    var deleteSQL = "DELETE FROM banks WHERE (branch_code = ? AND account_number = ?)";

    try (var ps = con.prepareStatement(deleteSQL)) {
      ps.setString(1, branchCode);
      ps.setString(2, accountNo);

      nRows = ps.executeUpdate();
    } catch (SQLException sqlException) {
      System.err.println("SQLException in deleteBankAccount()");
      sqlException.printStackTrace();
    }

    return nRows;
  }

  // DELETE all accounts
  private void deleteAllAccounts() {
    var deleteSQL = "DELETE FROM banks";

    try (var ps = con.prepareStatement(deleteSQL)) {
      ps.executeUpdate();
    } catch (SQLException sqlException) {
      System.err.println("SQLException in deleteAllAccounts()");
      sqlException.printStackTrace();
    }
  }

  // INSERT a bank account
  private int addBankAccount(BankAccount bankAccount) {
    int nRows = -1;
    var insertSQL = """
        INSERT INTO banks (BRANCH_CODE, ACCOUNT_NUMBER, CUST_NAME, CUST_ADDRESS, BALANCE)
        VALUES (?, ?, ?, ?, ?)
        """;

    try (var ps = con.prepareStatement(insertSQL)) {
      // ps.setBoolean(int parameterIndex, boolean x);    ps.setDouble(int parameterIndex, double x);
      // ps.setInt(int parameterIndex, int x);            ps.setLong(int parameterIndex, long x);
      // ps.setObject(int parameterIndex, Object x);
      ps.setString(1, bankAccount.getBranchCode()); // bind variables start at 1
      ps.setString(2, bankAccount.getAccountNo());
      ps.setString(3, bankAccount.getCustName());
      ps.setString(4, bankAccount.getCustAddress());
      ps.setDouble(5, bankAccount.getBalance());
      nRows = ps.executeUpdate();
    } catch (SQLException sqle) {
      System.err.println("SQLException in addBankAccount()");
      sqle.printStackTrace();
    }

    return nRows;
  }

  // UPDATE a bank account
  public int updateBankAccount(BankAccount bankAccount) {
    var nRows = -1;
    String updateSQL = "UPDATE banks "
        + "SET CUST_NAME=?, CUST_ADDRESS=?, BALANCE=? "
        + "WHERE (BRANCH_CODE = ? AND ACCOUNT_NUMBER=?)";

    try (var ps = con.prepareStatement(updateSQL)) {
      ps.setString(1, bankAccount.getCustName());
      ps.setString(2, bankAccount.getCustAddress());
      ps.setDouble(3, bankAccount.getBalance());
      ps.setString(4, bankAccount.getBranchCode());
      ps.setString(5, bankAccount.getAccountNo());

      nRows = ps.executeUpdate();
    } catch (SQLException sqle) {
      System.err.println("SQLException in updateBankAccount()");
      sqle.printStackTrace();
      return nRows;
    }

    return nRows;
  }
}
