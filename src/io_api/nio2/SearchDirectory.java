package io_api.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SearchDirectory {

  public static void main(String[] args) {
    var startPath = Paths.get("src/io_api");
    try (var streamPath = Files.find(startPath, 10,
        (path, attr) -> attr.isRegularFile() && path.toString().endsWith(".java"))) {
      streamPath.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
