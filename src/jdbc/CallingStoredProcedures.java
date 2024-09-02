package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallingStoredProcedures {

  private static Connection con;
  private static final CallingStoredProcedures bank = new CallingStoredProcedures(); // connect to db

  private CallingStoredProcedures() {
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
    noParams();
  }

  private static void noParams() {
    var noParamsSQL = "{call read_mysql_addresses()}";
    // try-with-resource will tidy up
    // PreparedStatement ps = con.prepareStatement(sql)
    try (var callableStatement = con.prepareCall(noParamsSQL)) {
      var resultSet = callableStatement.executeQuery();

      while (resultSet.next()) {
        System.out.println(resultSet.getString("CUST_ADDRESS"));
      }
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

  private static void inParam() {
    var inParamSQL = "{call read_addresses(?)}";

    try (var callableStatement = con.prepareCall(inParamSQL)) {
      callableStatement.setString(1, "Dublin"); // PreparedStatement can do this
//      callableStatement.setString("address", "Dublin"); // CallableStatement only

      try (var resultSet = callableStatement.executeQuery()) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString("CUST_ADDRESS"));
        }
      }
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

  private static void outParam() {
    var outParamSQL = "{?= call count_customers(?)}"; // the first question mark is optional

    try (var callableStatement = con.prepareCall(outParamSQL)) {

      callableStatement.registerOutParameter(1, Types.INTEGER);
      callableStatement.execute(); // no ResultSet coming back for this time
      System.out.println(callableStatement.getInt("count"));

    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }

  private static void inOutParam() {
    var inOutParamSQL = "{call square_number(?)}";

    try (var callableStatement = con.prepareCall(inOutParamSQL)) {

      callableStatement.setInt(1, 5);
      callableStatement.registerOutParameter(1, Types.INTEGER);
      callableStatement.execute();
      System.out.println(callableStatement.getInt("number"));

    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}
