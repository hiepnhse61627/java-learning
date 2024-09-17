package record_patterns;

public class TestRecords {

  public static void main(String[] args) {
    records();
  }

  public static void records() {
    var p1 = new Person("Hiep Nguyen", 29);
    System.out.println(p1);                          // Person[name=Hiep Nguyen, age=29]
    System.out.println(p1.name() + ": " + p1.age()); // Hiep Nguyen: 29
    patternMatching(p1);
    patternMatching("abc");

    var pairS = new Pair<>("Hiep", "Nguyen");
    var pairI = new Pair<>(10, 20);
    patternMatching(pairS);
    patternMatching(pairI);
  }

  public static void patternMatching(Object obj) {
    // "Person person" is a "type pattern". At runtime, "pattern matching" is performed by instanceof
    // to see if "obj" is referring to a Person object;
    // is so, "person" is made to refer to that Person object.
    if (obj instanceof Person person) {
      System.out.println("PM: " + person.name() + ": " + person.age());
    } else if (obj instanceof Pair pair) {
      System.out.println("PM: " + pair.x() + ": " + pair.y());
    }
  }
}

// old pre-Java 16 instanceof-and-cast idiom
//        if(obj instanceof String){
//            String s = (String)obj;
//            System.out.println(s.toUpperCase());
//        }

// new post-Java 16 idiom
//        if(obj instanceof String s){
//            System.out.println(s.toUpperCase());
//        }
