package io_api.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeExamples {

  public static void main(String[] args) {
    relativePaths();
    System.out.println("=".repeat(100));
    absolutePaths();
//    mixPaths();  // exception
  }

  public static void relativePaths() {
    // two relative paths - both are assumed to be in the same current working directory
    var p1 = Paths.get("cattle.txt");    // file does not exist
    var p2 = Path.of("farm/horses.txt"); // file does not exist

    // how do I get from p1 to p2 ?
    // file itself is one level => .. at start
    System.out.println(p1.relativize(p2));

    // how do I get from p2 to p1 ?
    System.out.println(p2.relativize(p1));
  }

  public static void absolutePaths() {
    // two absolute paths
    var p1 = Paths.get("/cattle.txt");           // file does not exist
    var p2 = Paths.get("/home/farm/horses.txt"); // file does not exist

    System.out.println(p1.relativize(p2));
    System.out.println(p2.relativize(p1));
  }

  public static void mixPaths() {
    var p1 = Paths.get("cattle.txt");
    var p2 = Paths.get("/cattle.txt");

    System.out.println(p1.relativize(p2)); // java.lang.IllegalArgumentException
    System.out.println(p2.relativize(p1)); // java.lang.IllegalArgumentException
  }
}
