package io_api.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeExamples {

  public static void main(String[] args) {
    var p1 = Path.of("./x/y/../sean.txt"); // remove the ./ (redundant)
    System.out.println(p1.normalize());         // x/sean.txt

    var p2 = Path.of("/x/y/../z");
    System.out.println(p2.normalize());         // /x/z

    var p3 = Path.of("./a");
    System.out.println(p3.normalize());

    var p4 = Path.of("../x/y");            // no directory before the .. => can't be simplified
    System.out.println(p4.normalize());         // ../x/y

    // using normalize() to better compare different paths
    var p5 = Paths.get("/a/b/../../x.y");  // absolute
    var p6 = Paths.get("/x.y");            // absolute
    System.out.println(p5.normalize());         // /x.y
    System.out.println(p6.normalize());         // /x.y
    System.out.println(p5.equals(p6));          // false
    System.out.println(p5.normalize().equals(p6.normalize())); // true
  }
}
