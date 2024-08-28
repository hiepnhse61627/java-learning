package localisation;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Locale.Category;

public class SettingLocaleCategories {

  public static void main(String[] args) {
    var n = 77_000.11;
    var localeFrench = new Locale("fr", "FR");

//    Locale.setDefault(localeFrench); // changes *both* DISPLAY and FORMAT

    var defaultLocale = Locale.getDefault();
    System.out.println(defaultLocale.getDisplayName());
    System.out.println(defaultLocale.getDisplayLanguage());
    System.out.println(defaultLocale.getDisplayCountry());
    System.out.println(NumberFormat.getInstance().format(n));

    Locale.setDefault(Category.DISPLAY, localeFrench);
    System.out.println("DISPLAY changed: " + defaultLocale.getDisplayName());
    System.out.println("DISPLAY changed: " + defaultLocale.getDisplayLanguage());
    System.out.println("DISPLAY changed: " + defaultLocale.getDisplayCountry());
    System.out.println("DISPLAY changed: " + NumberFormat.getInstance().format(n));

    Locale.setDefault(Locale.Category.FORMAT, localeFrench);
    System.out.println("DISPLAY: " + defaultLocale.getDisplayName());
    System.out.println("DISPLAY: " + defaultLocale.getDisplayLanguage());
    System.out.println("DISPLAY: " + defaultLocale.getDisplayCountry());
    System.out.println("FORMAT changed: " + NumberFormat.getInstance().format(n));
  }
}
