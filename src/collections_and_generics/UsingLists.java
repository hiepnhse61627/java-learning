package collections_and_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UsingLists {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " factoryMethods " + "=".repeat(30));
    factoryMethods();

    System.out.println("=".repeat(30) + " arrayList " + "=".repeat(30));
    arrayList();

    System.out.println("=".repeat(30) + " stack " + "=".repeat(30));
    stack();

    System.out.println("=".repeat(30) + " linkedList " + "=".repeat(30));
    linkedList();
  }

  public static void factoryMethods() {
    var array = new String[]{"Alpha", "Beta", "Charlie"};
    var asList = Arrays.asList(array); // 'array' and 'asList' are now 'backed'
    var of = List.of(array);
    var copy = List.copyOf(asList);

    array[0] = "Delta";     // changes to the array 'write through' to the list
    System.out.println(Arrays.toString(array)); // [Delta, Beta, Charlie]
    System.out.println(asList);                 // [Delta, Beta, Charlie]

    asList.set(1, "Echo");  // changes to the list 'write through' to the array
    System.out.println(Arrays.toString(array)); // [Delta, Echo, Charlie]
    System.out.println(asList);                 // [Delta, Echo, Charlie]

//    of.add("Foxtrot");                        // UnsupportedOperationException
//    copy.add("Foxtrot");                      // UnsupportedOperationException
//    asList.add("Foxtrot");                    // UnsupportedOperationException
  }

  public static void arrayList() {
    // LOD = Lord of the Dance
    //     = Lists maintain Order (index) and allow Duplicates
    var list = new ArrayList<String>();
    list.add("Alan");
    list.add("Alan");
    list.add(1, "Sean");
    list.add("Mary");
    list.add("Mary");

    System.out.println(list);          // [Alan, Sean, Alan, Mary, Mary]
    System.out.println(list.get(1));   // Sean

    list.remove(0);                 // result is in: [Sean, Alan, Mary, Mary]
    list.remove("Mary");               // only first Mary is removed: [Sean, Alan, Mary]

    System.out.println(list);          // [Sean, Alan, Mary]
    list.set(0, "Jack");               // [Jack, Alan, Mary]

    // replaceAll(UnaryOperator<E> op) - UnaryOperator is a Function<T,T> where the
    //                                   input and output are the same type
    list.replaceAll(name -> name + " Kennedy");
    System.out.println(list);          // [Jack Kennedy, Alan Kennedy, Mary Kennedy]
  }

  public static void stack() {
    // Stack is a LIFO structure (Last In First Out) - we can manipulate one end only.
    // Using the Stack type as the reference type, so we get access to the push(), pop() and peek() methods.
    var stack = new Stack<String>(); // legacy class, use Deque interface instead
    stack.push("Andrea");
    stack.push("Barbara");
    stack.push("Caroline");
    System.out.println(stack);// [Andrea, Barbara, Caroline]
    //                                                ^
    //                                                ^
    //                                               top
    System.out.println("Top of stack: " + stack.peek()); // Caroline
    System.out.println("Popped: " + stack.pop());        // Caroline - [Andrea, Barbara]
    stack.push("Helen");                           // [Andrea, Barbara, Helen]
    System.out.println(stack);                          // [Andrea, Barbara, Helen]
  }

  public static void linkedList() {
    var names = new LinkedList<String>();
    names.add("Colin");         // [Colin]
    names.add("David");         // [Colin, David]
    names.addFirst("Brian");    // [Brian, Colin, David]
    names.addLast("Edward");    // [Brian, Colin, David, Edward]
    System.out.println(names);  // [Brian, Colin, David, Edward]

    names.remove("David");      // [Brian, Colin, Edward]
    names.removeFirst();        // [Colin, Edward]
    names.removeLast();         // [Colin]
    System.out.println(names);  // [Colin]
  }
}
