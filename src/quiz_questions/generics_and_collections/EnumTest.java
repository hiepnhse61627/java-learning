package quiz_questions.generics_and_collections;

enum Pets {
  DOG("D") {
    public String getName() {
      return "SUB";
    }
  }, CAT("C");


  static final String prefix = "prefix - ";
  String name;

  Pets(String s) {
    name = prefix + s;
  }

  public String getName() {
    return name;
  }
}

public class EnumTest {

  public static void main(String[] args) {
    Pets pet = Pets.DOG;
    System.out.println(pet.getName());
  }
}
