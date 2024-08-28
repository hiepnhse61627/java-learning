package localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalisingDates {

  public static void main(String[] args) {
    var localeUS = Locale.US;
    var localeFrench = new Locale("fr", "FR");
    var localGerman = Locale.GERMANY;

    var localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);

    var dateMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    // Using the United States locale (en_US)
    System.out.println(dateMedium.withLocale(localeUS).format(localDateTime));
    // Using the French locale
    System.out.println(dateMedium.withLocale(localeFrench).format(localDateTime));

    var timeShort = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
    // Using the United States locale (en_US)
    System.out.println(timeShort.withLocale(localeUS).format(localDateTime));
    // Using the German locale
    System.out.println(timeShort.withLocale(localGerman).format(localDateTime));

    var dateTimeShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    // Using the VN locale
    System.out.println(dateTimeShort
        .withLocale(new Locale.Builder()
            .setLanguage("vn")
            .setRegion("VN")
            .build())
        .format(localDateTime));
    // Using the United States locale
    System.out.println(dateTimeShort.withLocale(localeUS).format(localDateTime));
  }
}
