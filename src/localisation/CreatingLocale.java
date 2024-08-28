package localisation;

import java.util.Locale;

public class CreatingLocale {

  public static void main(String[] args) {
    // 1. Constructor
    System.out.println(new Locale("en"));                 // en
    var localeEnglishGB = new Locale("en", "GB"); // en_GB
    System.out.println(localeEnglishGB.getDisplayLanguage());      // English
    System.out.println(localeEnglishGB.getDisplayCountry());       // United Kingdom

    System.out.println("=".repeat(100));

    // 2. Built-in constants
    System.out.println(Locale.FRENCH);                     // fr
    var localeFrance = Locale.FRANCE;                      // fr_FR
    System.out.println(localeFrance.getDisplayLanguage()); // French
    System.out.println(localeFrance.getDisplayCountry());  // France

    System.out.println("=".repeat(100));

    // 3. Locale.Builder() pattern
    var localeArabicEgypt = new Locale.Builder()
        .setLanguage("ar")
        .setRegion("EG")
        .build();
    System.out.println(localeArabicEgypt);
    var localeArabicKuwait = new Locale.Builder()
        .setRegion("KW")
        .setLanguage("ar")
        .build();
    System.out.println(localeArabicKuwait);  // ar_KW
  }

}
