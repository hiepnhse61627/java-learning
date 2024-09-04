package io_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingWritingExamples {

  public static void main(String[] args) {
//    copyTestFile(false);
//    copyTestFile(true);
//    copyBinaryFile(false);
    copyBinaryFile(true);
  }

  public static void copyTestFile(boolean buffering) {
    var src = new File("src/io_api/ReadingWritingExamples.java");
    var dest = new File("src/io_api/ReadingWritingExamples2.java");

    // in-built close() try-with-resource
    try (
        var reader = new BufferedReader(new FileReader(src));
        var writer = new BufferedWriter(new FileWriter(dest))
    ) {
      if (buffering) {
        // Using BufferedReader and BufferWriter APIs
        String str = null;
        // readLine() is specific to BufferedReader
        while ((str = reader.readLine()) != null) {
          writer.write(str);
          writer.newLine(); // readLine() strips out the end of line character
        }
      } else {
        // no buffering i.e. read one byte at a time; an int is used because
        // Java uses -1 to signal the end of the stream
        int b;
        while ((b = reader.read()) != -1) {
          writer.write(b);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void copyBinaryFile(boolean buffering) {
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
    var src = new File("out/production/java-learning/io_api/ReadingWritingExamples.class");
    var dest = new File("out/production/java-learning/io_api/ReadingWritingExamples2.class");

    // in-built close() with try-with-resource
    try (
        var inputStream = new BufferedInputStream(new FileInputStream(src));
        var outputStream = new BufferedOutputStream(new FileOutputStream(dest))
    ) {
      if (buffering) {
        var buffer = new byte[1024];
        int numBytesRead;
        while ((numBytesRead = inputStream.read(buffer)) > 0) {
          // As the file is unlikely to be an exact multiple of 1024 bytes. 'numBytesRead' helps
          // us to write out exactly the number of extra bytes above that multiple
          // e.g. 2058 = 1024 + 1024 + 10
          // write (byte[], int, int) is in FileOutputStream and BufferedOutputStream
          outputStream.write(buffer, 0, numBytesRead);
          outputStream.flush();
        }
      } else {
        // no buffering i.e. read one byte at a time; an int is used because
        // Java uses -1 to signal the end of the stream
        int b;
        while ((b = inputStream.read()) != -1) {
          outputStream.write(b);
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
