package jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ClosingResources {

  public static void main(String[] args) {
    var resources = new ResourceLoader();
    var sql = "SELECT * FROM banks";
    // These resources will be closed automatically in reverse order:
    //      ResultSet, PreparedStatement, Connection
    // This is the order that we want
    try (
        var connection = DriverManager.getConnection(
            resources.getUrl(), resources.getUsername(), resources.getPassword());
        var preparedStatement = connection.prepareStatement(sql);
        var resultSet = preparedStatement.executeQuery()
    ) {
      while (resultSet.next()) {
        // process the record
        BankAccount bankAccount = new BankAccount(
            resultSet.getString(1),    // "BRANCH_CODE"
            resultSet.getString("ACCOUNT_NUMBER"),
            resultSet.getString("CUST_NAME"),
            resultSet.getString("CUST_ADDRESS"),
            resultSet.getDouble("BALANCE"));

        System.out.println(bankAccount);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
