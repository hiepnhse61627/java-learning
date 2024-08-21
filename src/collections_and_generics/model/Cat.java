package collections_and_generics.model;

public class Cat implements Comparable<Cat> {

  private String name;
  private int age;

  public Cat() {
  }

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Cat otherCat) {
      return name.equals(otherCat.getName());
    }
    return false;
  }

  @Override
  public int compareTo(Cat o) {
    return name.compareTo(o.getName());
  }

  @Override
  public String toString() {
    return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
