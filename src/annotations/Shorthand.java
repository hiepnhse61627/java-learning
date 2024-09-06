package annotations;

// Example - "value" element for shorthand
@interface Team {

  // "value" element is the key!
  String value() default "Soccer"; // required or optional is fine

  int numPlayers() default 2;      // must be optional if we wish to use shorthand i.e. "value"
}

class Sport {

  @Team(numPlayers = 6, value = "Volleyball")
  void beach() { // all provided
  }

  @Team(value = "Tennis")
  void strawberriesAndCream() { // numPlayers omitted
  }

  // Where shorthand is used (as in below), then there MUST be a "value" element.
  @Team("Curling")
  void slow() { // numPlayers omitted AND "value=" omitted, same as: value="Curling"
  }
}

// Example - shorthand for arrays with ONLY one element
@interface Quiz {

  String[] topics();
}

class Competitor {

  @Quiz(topics = {"General Knowledge", "Music"})
  String favoriteTopic;

  @Quiz(topics = {"Sport"})
  String leastFavoriteTopic;

  @Quiz(topics = "Sport")
  String leastOtherFavoriteTopic; // shorthand - compiler inserts the {}

  // @Quiz(topics = "Sport", "Jazz")  // {} missing
  String topic1;

  // @Quiz(topics = null)  // constant expression required (even {} is ok)
  String topic2;
}

// Example - combining both shorthands
//         - value()
//         - arrays with ONLY one element
@interface Colors {

  String[] value(); // "value" element AND an array
}

class TestRainbow {

  @Colors(value = {"Red"})
  String color1; // all details provided i.e. "value" and array {}

  @Colors(value = "Red")
  String color2; // shorthand for single element array i.e. {} omitted

  @Colors({"Red"})
  String color3; // shorthand for "value" element i.e. "value=" omitted, array {} included

  @Colors("Red")
  String color4; // shorthand for both "value" element and single element array, "value=" omitted and array {} omitted
}

public class Shorthand {

  public static void main(String[] args) {

  }
}
