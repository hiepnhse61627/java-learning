package ocp1721book.lambda;

import java.util.Arrays;
import java.util.List;

public class TestClassFIlterCar {

  public static void main(String[] args) {
    CompanyFilter companyFilter = new CompanyFilter("Honda");
    CarMall carMall = new CarMall();

    List<Car> filteredCars = carMall.showCars(companyFilter);
    System.out.println(filteredCars);

    List<Car> lambdaFilteredCars = carMall.showCarsWithPredicate(c -> c.company().equals("Toyota"));
    System.out.println(lambdaFilteredCars);

    BooleanSupplier booleanSupplier = () -> true;
    NumberPredicate<Integer> numberPredicate = number -> number > 5;

    Shape areaCompute = () -> Math.PI * 2;
    Operation operation = (name, params) -> {
      System.out.println(name);
      System.out.println(Arrays.toString(params));
    };
  }
}

interface Shape {

  double computeArea();
}

interface Operation {

  void operate(String name, double[] params);
}

class CompanyFilter implements CarFilter {

  private String company;

  public CompanyFilter(String company) {
    this.company = company;
  }

  @Override
  public boolean showCar(Car car) {
    return car.company().equals(company);
  }
}
