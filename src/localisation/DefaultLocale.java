package localisation;

import java.util.Locale;

public class DefaultLocale {

  public static void main(String[] args) {
    var locale = Locale.getDefault();
    System.out.println(locale);
  }
}
