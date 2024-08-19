package collections_and_generics.model;

import java.util.Objects;

public class Product implements Comparable<Product> {

  private Integer id;

  public Product(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Product otherProduct) {
      return Objects.equals(id, otherProduct.id);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + id;
    return hash;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        '}';
  }

  @Override
  public int compareTo(Product product) {  // specifies "natural ordering" for Product
    // delegate to Integer which implements Comparable<Integer>
    return id.compareTo(product.id);
    //        return Integer.compare(id, product.id); // another option
    //        return id-product.id;// sorts ascending by id
  }
}
