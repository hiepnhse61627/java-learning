package collections_and_generics;

import collections_and_generics.model.Product;
import java.util.ArrayList;
import java.util.Collections;

public class SortingProducts {

  public static void main(String[] args) {
    comparable();
  }

  public static void comparable() {
    var products = new ArrayList<Product>();
    products.add(new Product(99));
    products.add(new Product(9));
    products.add(new Product(19));

    Collections.sort(products);
    System.out.println(products);
  }
}
