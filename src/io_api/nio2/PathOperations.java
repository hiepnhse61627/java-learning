package io_api.nio2;

import java.nio.file.Path;

public class PathOperations {

  public static void main(String[] args) {
    pathInfo(Path.of("/Users/nguyenhoanghiep/IdeaProjects/java-learning/src/resources/Cats.txt"));
    System.out.println("=".repeat(100));
    pathInfo(Path.of("abc/def/ghi/jkl"));
  }

  private static void pathInfo(Path path) {
    System.out.println("toString: " + path);
    System.out.println("getNameCount: " + path.getNameCount());
    for (var i = 0; i < path.getNameCount(); i++) {
      // getName(0): Users   => root is NOT a name element (see Path.of("/").getName(0); on line 21)
      System.out.println("getName(" + i + ") :" + path.getName(i));
    }
    System.out.println("getFileName: " + path.getFileName());
    System.out.println("getParent: " + path.getParent());
    System.out.println("getRoot: " + path.getRoot());
//    System.out.println("exception: " + Path.of("/").getName(0)); // java.lang.IllegalArgumentException

    System.out.println("subpath(0, 3): " + path.subpath(0, 3));
    System.out.println("subpath(1, 4): " + path.subpath(1, 4));
    System.out.println("subpath(2, 3): " + path.subpath(2, 3));

    System.out.println("isAbsolute: " + path.isAbsolute());
  }
}
