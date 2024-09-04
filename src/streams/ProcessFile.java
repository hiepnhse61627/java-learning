package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Cat {

  private String name;
  private String color;

  public Cat(String name, String color) {
    this.name = name;
    this.color = color;
  }

  @Override
  public String toString() {
    return "Cat{" + "name='" + name + '\'' + ", color='" + color + '\'' + '}';
  }
}

public class ProcessFile {

  public static void main(String[] args) {
    var cats = loadCats("resources/Cats.txt");
    cats.forEach(System.out::println);
  }

  public static List<Cat> loadCats(String fileName) {
    var cats = new ArrayList<Cat>();

    try (var stream = Files.lines(Paths.get(fileName))) {
      stream.forEach(line -> {
        var catArray = line.split("/");
        cats.add(new Cat(catArray[0], catArray[1]));
      });
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return cats;
  }
}
