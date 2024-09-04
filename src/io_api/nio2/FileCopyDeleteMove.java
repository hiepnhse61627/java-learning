package io_api.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDeleteMove {

  public static void main(String[] args) throws IOException {
    // current directory
    System.out.println(System.getProperty("user.dir"));

    // no file created on hard disk by any of these commands
    var source = Paths.get("resources/nio2/source.txt");
    var target01 = Paths.get("resources/nio2/target-01.txt");
    var target02 = Paths.get("resources/nio2/target-02.txt");

    Files.createDirectories(Paths.get("resources/nio2")); // relative directory created
    if (Files.exists(source)) {
      // If source and target were directories then this would be a 'shallow' copy i.e. the files and
      // subdirectories within the source directory are NOT copied. We will perform a 'deep' copy
      // where the whole tree is copied with streams later.
      Files.copy(source, target01, StandardCopyOption.REPLACE_EXISTING); // no exception
      Files.move(target01, target02, StandardCopyOption.REPLACE_EXISTING);
      // now we have source and target02 files
      // source and target02 files remaining
    } else {
      Files.createFile(source); // create source file
      Files.copy(source, target01); // now we have source and target01 files
      Files.move(target01, target02); // now we have source and target02 files
      Files.delete(target02); // only the source file left
    }
  }
}
