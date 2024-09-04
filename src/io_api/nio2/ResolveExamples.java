package io_api.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveExamples {

  public static void main(String[] args) {
    var absolute = Paths.get("/Users/nguyenhoanghiep/IdeaProjects/java-learning/resources");
    var relative = Path.of("nio2");
    var file = Path.of("name.txt");

    System.out.println("absolute.resolve(relative): " + absolute.resolve(relative));
    System.out.println("absolute.resolve(file): " + absolute.resolve(file));
    System.out.println("relative.resolve(file): " + relative.resolve(file));

    // trying to resolve an absolute path within anything just returns the absolute path
    System.out.println("relative.resolve(absolute): " + relative.resolve(absolute));
    System.out.println("file.resolve(absolute): " + file.resolve(absolute));
    System.out.println("absolute.resolve(absolute): " + absolute.resolve(absolute));

    // interesting...
    var p1 = Path.of("dir");
    var p2 = Path.of("sk.txt");
    System.out.println("dir.resolve(sk.txt): "
        + p1.resolve(p2)); // dir/sk.txt
    System.out.println("sk.txt.resolve(dir): " // sk.txt could be a directory (it is) and
        + p2.resolve(p1)); // sk.txt/dir       // dir could be a file (it is)
  }
}
