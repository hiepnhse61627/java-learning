package ocp1721book;

public class RecordExercise {

  enum ProductType {
    FMCG, APPLIANCE, PHARMA
  }

  static class PriceWrapper {

    double price;

    public PriceWrapper(double price) {
      this.price = price;
    }

    public double getPrice() {
      return price;
    }

    public void setPrice(double price) {
      this.price = price;
    }
  }

  record Product(int productId, String name, ProductType pt) {

    public Product(int productId, String name, ProductType pt) {
      if (productId < 0) {
        throw new IllegalArgumentException("Invalid product id: " + productId);
      }
      this.productId = productId;
      this.name = name;
      this.pt = pt;
    }

//    public Product(int productId) {
//      this(productId, "Default Name", ProductType.FMCG, new PriceWrapper(0));
//      if (productId < 0) {
//        throw new IllegalArgumentException("Invalid product id: " + productId);
//      }
//    }

//    public Product {
//      if (productId < 1) {
//        throw new IllegalArgumentException("Product id must be greater than 0");
//      }
//    }

//    public void updatePrice(double price) {
//      priceWrapper.setPrice(price);
//    }
  }

  public static void main(String[] args) {
    PriceWrapper priceWrapper1 = new PriceWrapper(1.0);
    PriceWrapper priceWrapper2 = new PriceWrapper(1.0);

    Product product1 = new Product(1, "Default Name", ProductType.FMCG);
    Product product2 = new Product(1, "Default Name", ProductType.FMCG);

    System.out.println(product1.equals(product2));
  }
}
