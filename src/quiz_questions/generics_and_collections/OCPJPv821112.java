package quiz_questions.generics_and_collections;

class SpecialPicker<K> {
  public K pickOne(K k1, K k2) {
    return k1.hashCode() > k2.hashCode() ? k1 : k2;
  }
}

public class OCPJPv821112 {

  public static void main(String[] args) {
    SpecialPicker<Integer> picker = new SpecialPicker<Integer>();
    System.out.println(picker.pickOne(1, 2).intValue() + 1);
  }
}
