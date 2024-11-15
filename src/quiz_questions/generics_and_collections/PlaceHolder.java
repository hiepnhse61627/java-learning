package quiz_questions.generics_and_collections;

import java.util.ArrayList;
import java.util.List;

public class PlaceHolder<K, V> {

  private K k;
  private V v;

  public PlaceHolder(K k, V v) {
    this.k = k;
    this.v = v;
  }

  public K getK() {
    return k;
  }

  public static <X> PlaceHolder<X, X> getDuplicateHolder(X x) {
    return new PlaceHolder<X, X>(x, x);
  }

  public static <T> void fillListSafely(T ...items) {
    List<T> list = new ArrayList<T>();
    for (T item : items) {
      list.add(item);
    }
    System.out.println(list);
  }

  public static void main(String[] args) {
    PlaceHolder<String, String> ph1 = PlaceHolder.getDuplicateHolder("b");
//    PlaceHolder<String, String> ph2 = PlaceHolder<String>.getDuplicateHolder("a");
//    PlaceHolder<String, String> ph3 = PlaceHolder<>.getDuplicateHolder("a");
//    PlaceHolder<> ph4 = new PlaceHolder<String, String>("a", "b");
    PlaceHolder<?, ?> ph5 = new PlaceHolder(10, 10);
    PlaceHolder<String, String> ph6 = PlaceHolder.<String>getDuplicateHolder("a");

    PlaceHolder.fillListSafely("11", 13); // not safe
    PlaceHolder.<String>fillListSafely("11", "12");
  }
}
