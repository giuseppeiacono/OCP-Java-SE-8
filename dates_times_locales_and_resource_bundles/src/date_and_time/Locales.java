package date_and_time;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Locales {

    public static void main(String[] args) {
        // Locale's constructors of the exam
        Locale localeJapan = new Locale("ja");
        Locale localeItaly = new Locale("it", "IT");

        List<Locale> locales = Arrays.asList(localeJapan, localeItaly);
        getZonedDateTimeByLocales(locales);
        getLanguageAndCountryByLocale(locales);
    }

    private static void getZonedDateTimeByLocales(List<Locale> locales) {
        ZonedDateTime madridDateTime = ZonedDateTime.now();
        System.out.println("\nJapan (Long) format: " + madridDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locales.get(0))));
        System.out.println("Italy (Long) format: " + madridDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locales.get(1))));
    }

    private static void getLanguageAndCountryByLocale(List<Locale> locales) {
        System.out.println("\nItaly default language: " + locales.get(1).getLanguage());
        System.out.println("Italy default country: " + locales.get(1).getCountry());
        System.out.println("\nItaly language by Japan locale: " + locales.get(1).getDisplayLanguage(locales.get(0)));
        System.out.println("Italy country by Japan locale: " + locales.get(1).getDisplayCountry(locales.get(0)));
    }


}
