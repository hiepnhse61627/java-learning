package io_api;

import java.util.Arrays;

public class ConsoleTest {

  public static void main(String[] args) {
    var console = System.console(); // not new
    if (console == null) {
      System.out.println("Console is not available");
    } else {
      var name = console.readLine("Please enter your name %s: ", "name");
      console.format("Hello there %s%n", name);
      console.printf("Welcome."); // varargs (0 args is valid)
      console.writer().println(); // blank line

      var password = console.readPassword("Enter password (between %d and %d characters): ", 4, 10);
      var confirmedPassword = console.readPassword("Verify password: ");
      var matched = Arrays.equals(password, confirmedPassword);
      if (matched) {
        console.printf("Passwords match!");
      } else {
        console.printf("Passwords do NOT match!");
      }
    }
  }
}
