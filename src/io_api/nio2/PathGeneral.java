package io_api.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGeneral {

  public static void main(String[] args) {
    // current directory
    System.out.println(System.getProperty("user.dir"));

    // Path.of() is new to Java 11
    var p1 = Path.of("resources/Cats.txt");
    var p2 = Path.of("/Users/nguyenhoanghiep/IdeaProjects/java-learning/src/resources/Cats.txt");

    System.out.println(p1.getFileName());
    System.out.println(p2.getFileName());

    // same as above except using varargs
    p1 =  Path.of("resources", "Cats.txt");
    System.out.println(p1.getFileName());

    // Using Paths factory class - Paths.get()
    var p3 = Paths.get("resources/Cats.txt");
    var p4 = Paths.get("/Users/nguyenhoanghiep/IdeaProjects/java-learning/src/resources/Cats.txt");

    System.out.println(p3.getFileName());
    System.out.println(p4.getFileName());

    // using varargs
    p3 = Paths.get("resources", "Cats.txt");
    System.out.println(p3.getFileName());
  }
}
