package io_api.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesView {

  public static void main(String[] args) throws IOException {
    var path = Path.of("./src/io_api/nio2/Attributes.java");
    System.out.println(path);

    var view = Files.readAttributes(path, BasicFileAttributes.class);
    System.out.println("isDirectory: " + view.isDirectory());
    System.out.println("isRegularFile: " + view.isRegularFile());
    System.out.println("isSymbolicLink: " + view.isSymbolicLink());
    System.out.println("size: " + view.size());
    System.out.println("lastModifiedTime: " + view.lastModifiedTime());

    // changing - Files.getFileAttributeView and then BasicFileAttributeView::readAttributes()
    var updView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
    var attrs = updView.readAttributes(); // no using Files version here
    final var THIRTY_MINS_MSEC = 1000 * 60 * 30;
    var lastModifiedTime = FileTime.fromMillis(
        attrs.lastModifiedTime().toMillis() + THIRTY_MINS_MSEC);
    // not changing last access time or creation time - pass in null for them
    updView.setTimes(lastModifiedTime, null, null);

    view = Files.readAttributes(path, BasicFileAttributes.class);
    System.out.println("lastModifiedTime: " + view.lastModifiedTime());
  }
}
