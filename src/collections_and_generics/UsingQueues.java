package collections_and_generics;

import collections_and_generics.model.Book;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class UsingQueues {

  public static void main(String[] args) {
    System.out.println("=".repeat(30) + " linkedListQueue " + "=".repeat(30));
    linkedListQueue();

    System.out.println("=".repeat(30) + " arrayDeque " + "=".repeat(30));
    arrayDeque();

    System.out.println("=".repeat(30) + " priorityQueueNaturalOrdering " + "=".repeat(30));
    priorityQueueNaturalOrdering();

    System.out.println("=".repeat(30) + " priorityQueueDifferentOrdering " + "=".repeat(30));
    priorityQueueDifferentOrdering();
  }

  public static void linkedListQueue() {
    // A FIFO queue (First In First Out)
    var queue = new LinkedList<Integer>();
    // add() inserts into queue (throws exception if no space exists - if capacity restricted)
    // offer() inserts into queue (returns false if no space exists - capacity restricted)
    queue.add(1);      // Head -> [1]
    queue.offer(2); // Head -> [1, 2]
    queue.add(3);      // Head -> [1, 2, 3]
    queue.offer(4); // Head -> [1, 2, 3, 4]
    // element() retrieves but does not remove the head of the queue (throws exception if queue is empty)
    // peek() retrieves but does not remove the head of the queue (returns null if queue is empty)
    System.out.println(queue.element());// 1
    System.out.println(queue.peek());   // 1
    System.out.println(queue);          // [1, 2, 3, 4]
    // remove() retrieves and removes the head of this queue (throws exception if queue is empty)
    // poll() retrieves and removes the head of this queue (returns null if queue is empty)
    System.out.println(queue.remove()); // 1   Head-> [2, 3, 4]
    System.out.println(queue.poll());   // 2   Head-> [3, 4]
    System.out.println(queue);          // [3, 4]
    // offer(), poll() and pop() are the preferred methods as they do not throw exceptions (P.O.P.)
  }

  public static void arrayDeque() {
    // Deque = "doubly ended queue". Supports element insertion/removal at both ends.
    // ArrayDeque - resizeable array implementation of the Deque interface (no capacity restrictions)
    var numbers = new ArrayDeque<Integer>();
    // "arg" (as in main(String []ARGs)
    //  Deque methods that begin with "a", "r" or "g" e.g. addFirst(), addLast(), removeFirst(), removeLast(),
    //  getFirst() and getLast() all throw exception if the deque is both capacity-constrained and full.
    //  The other methods (POP): peekFirst(), peekLast(), offerFirst(), offerLast(), pollFirst(), pollLast(),
    //  rather than throw an exception in the same situation, they return null/false.

    // add at the front (the head)
    numbers.add(1);           // Head -> [1] <- Tail
    numbers.addFirst(2);   // Head -> [2, 1] <- Tail     - exception throws if deque is full
    numbers.offerFirst(3); // Head -> [3, 2, 1] <- Tail  - null/false if deque is full
    System.out.println("Head:" + numbers.getFirst() + ". Head: " + numbers.peekFirst());
    // add at the end (the tail)
    numbers.addLast(4);    // Head -> [3, 2, 1, 4] <- Tail
    numbers.offerLast(5);  // Head -> [3, 2, 1, 4, 5] <- Tail
    // remove from both ends
    numbers.removeFirst();    // Head -> [2, 1, 4, 5] <- Tail
    numbers.pollFirst();      // Head -> [1, 4, 5]    <- Tail
    numbers.removeLast();     // Head -> [1, 4]       <- Tail
    numbers.pollLast();       // Head -> [1]          <- Tail
    System.out.println(numbers); // [1]

    // The common peek(), offer(), poll() in use:
    System.out.println(numbers.offer(11));   // true     Head -> [1, 11] <- Tail
    System.out.println(numbers.offer(12));   // true     Head -> [1, 11, 12] <- Tail
    System.out.println(numbers.peek());         // 1        Head -> [1, 11, 12] <- Tail
    System.out.println(numbers.poll());         // 1        Head -> [11, 12] <- Tail
    System.out.println(numbers.poll());         // 11       Head -> [12] <- Tail
    System.out.println(numbers.poll());         // 12       Head -> [] <- Tail
    System.out.println(numbers.poll());         // null     Head -> [] <- Tail
  }

  public static void priorityQueueNaturalOrdering() {
    var names = new PriorityQueue<String>(); // alphabetic ordering
    names.add("V");
    names.add("P");
    names.add("A");
    var itNames = names.iterator();
    while (itNames.hasNext()) {
      System.out.print(names.poll() + " "); // A P V
    }

    System.out.println();

    var numbers = new PriorityQueue<Integer>(); // numeric ordering
    numbers.add(11);
    numbers.add(5);
    numbers.add(2);
    var itNumbers = numbers.iterator();
    while (itNumbers.hasNext()) {
      System.out.print(numbers.poll() + " "); // 2 5 11
    }
  }

  public static void priorityQueueDifferentOrdering() {
    // Ordering specified by a comparator at construction time

    // 1. Order by the title of the book
    // Comparator.comparing(Function)
    //    API: "Accepts a function that extracts a Comparable sort key from a type T,
    //         and returns a Comparator<T> that compares by that sort key."
    //    Function<T, R>
    //      R apply(T t)
    var comparatorTitle = Comparator.comparing(Book::getTitle);
    var booksByTitle = new PriorityQueue<>(comparatorTitle);
    booksByTitle.add(new Book("Java", 55.0));
    booksByTitle.add(new Book("Python", 23.0));
    booksByTitle.add(new Book("C++", 99.0));

    System.out.println("Ordering by title:");
    var itBooks = booksByTitle.iterator();
    while (itBooks.hasNext()) {
      Book book = booksByTitle.poll();
      System.out.println(book);
            /* C++      99.0
               Java     55.0
               Python   23.0 */
    }

    // 2. Order by the price of the book
    var comparatorPrice = Comparator.comparing(Book::getPrice);
    var booksByPrice = new PriorityQueue<>(comparatorPrice); // order by price
    booksByPrice.add(new Book("Java", 55.0));
    booksByPrice.add(new Book("Python", 23.0));
    booksByPrice.add(new Book("C++", 99.0));

    System.out.println("Ordering by price:");
    var itMoreBooks = booksByPrice.iterator();
    while (itMoreBooks.hasNext()) {
      Book book = booksByPrice.poll();
      System.out.println(book);
            /* Python   23.0
               Java     55.0
               C++      99.0 */
    }
  }
}
