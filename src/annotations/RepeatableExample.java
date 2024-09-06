package annotations;

import java.lang.annotation.Repeatable;

@interface Batteries {

  Battery[] value() default @Battery(level = "medium", recharge = true); // by convention, the plural of the annotation is used must be value()
}

@Repeatable(Batteries.class)
@interface Battery {

  String level();

  boolean recharge();
}

@Battery(level = "high", recharge = false)
@Battery(level = "low", recharge = true)
class ElectricCar {

}

public class RepeatableExample {

}
