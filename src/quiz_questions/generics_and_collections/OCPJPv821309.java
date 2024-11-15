package quiz_questions.generics_and_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OCPJPv821309 {

  public <E extends CharSequence> Collection<E> getWordsStartingWith(Collection<E> input, char ch) {
    Collection<E> returnValue = new ArrayList<E>();
    int len = input.size();
    for (E e : input) {
      if (e.charAt(0) == ch) {
        returnValue.add(e);
      }
    }
    return returnValue;
  }

  public void checkIt() {
    List<String> a = new ArrayList<String>();
    a.add("apple");
    a.add("cherry");

    Set<StringBuffer> b = new HashSet<StringBuffer>();
    b.add(new StringBuffer("apple"));

    Collection<String> ac = getWordsStartingWith(a, 'a');
    Collection<StringBuffer> bc = getWordsStartingWith(b, 'b');

    System.out.println(ac);
    System.out.println(bc);
  }

  public static void main(String[] args) {
    OCPJPv821309 test = new OCPJPv821309();
    test.checkIt();
  }
}
