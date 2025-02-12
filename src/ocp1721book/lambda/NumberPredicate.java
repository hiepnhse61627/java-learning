package ocp1721book.lambda;

@FunctionalInterface
public interface NumberPredicate<T extends Number> {

  boolean test(T number);
}
