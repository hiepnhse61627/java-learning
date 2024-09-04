package io_api.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;

// current directory: /Users/nguyenhoanghiep/IdeaProjects/java-learning
public class Attributes {

  public static void main(String[] args) {
    checkAttributes(Path.of("./src/io_api/nio2/Attributes.java"));
  }

  public static void checkAttributes(Path path) {
    System.out.println(path);
    System.out.println("isDirectory: " + Files.isDirectory(path));
    System.out.println("isRegularFile: " + Files.isRegularFile(path));
    System.out.println("isSymbolicLink: " + Files.isSymbolicLink(path));
    System.out.println("isReadable: " + Files.isReadable(path));
    System.out.println("isWritable: " + Files.isWritable(path));
    System.out.println("isExecutable: " + Files.isExecutable(path));
    try {
      // isHidden(), size() and getLastModifiedTime() all throw IOException
      System.out.println("isHidden: " + Files.isHidden(path));
      System.out.println("size: " + Files.size(path));
      System.out.println("getLastModified: " + Files.getLastModifiedTime(path));
      //
      var millisFromEpoch = Files.getLastModifiedTime(path).toMillis();
      var zonedDateTime = FileTime.fromMillis(millisFromEpoch)
          .toInstant()
          .atZone(ZoneId.of("Asia/Ho_Chi_Minh"));
      System.out.println(zonedDateTime);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
