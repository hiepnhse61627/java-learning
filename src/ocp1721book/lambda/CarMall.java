package ocp1721book.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

record Car(String company, int year, double price, String type) {
  public String toString() {
    return STR."(\{company}, \{year}, \{price}, \{type})";
  }
}

interface CarFilter {
  boolean showCar(Car car);
}

public class CarMall {

  List<Car> cars = new ArrayList<>();

  CarMall() {
    cars.add(new Car("Honda", 2012, 9000.0, "HATCH"));
    cars.add(new Car("Honda", 2018, 17000, "SEDAN"));
    cars.add(new Car("Toyota", 2014, 19000.0, "SUV"));
    cars.add(new Car("Ford", 2014, 13000.0, "SPORTS"));
  }

  List<Car> showCars(CarFilter filter) {
    List<Car> filteredCars = new ArrayList<>();

    for (Car car : cars) {
      if (filter.showCar(car)) {
        filteredCars.add(car);
      }
    }

    return filteredCars;
  }

  List<Car> showCarsWithPredicate(Predicate<Car> predicate) {
    List<Car> filteredCars = new ArrayList<>();

    for (Car car : cars) {
      if (predicate.test(car)) {
        filteredCars.add(car);
      }
    }

    return filteredCars;
  }
}
