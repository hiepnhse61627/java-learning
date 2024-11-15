package quiz_questions.generics_and_collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class OCPJPv821300 {

  public static void main(String[] args) {
    Map<Object, ? super ArrayList> m = new LinkedHashMap<>();

    m.put("1", new ArrayList<>());
//    m.put(1, new Object());
//    m.put(1.0, "Hello");

    System.out.println(m);

    Map<Object, Object> m2 = new LinkedHashMap<>();
    test(m2);
  }

  static void test(Map<Object, ? super ArrayList> m) {
    System.out.println(m);
  }
}
