package locale;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Locales {

    public static void main(String[] args) {
        // Locale's constructors of the exam
        Locale localeJapan = new Locale("ja");
        Locale localeItaly = new Locale("it", "IT");

        List<Locale> locales = Arrays.asList(localeJapan, localeItaly);
        getZonedDateTimeByLocales(locales);
        getLanguageAndCountryByLocale(locales);
        printLabelsEnCaResourceBundle();
    }

    private static void getZonedDateTimeByLocales(List<Locale> locales) {
        ZonedDateTime madridDateTime = ZonedDateTime.now();
        System.out.println("\nThe same 'ZonedDateTime' is formatted in several ways depending on the locale:");
        System.out.println("Japan (Long) format: " + madridDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locales.get(0))));
        System.out.println("Italy (Long) format: " + madridDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(locales.get(1))));
    }

    private static void getLanguageAndCountryByLocale(List<Locale> locales) {
        System.out.println("\nItaly locale's language and country in terms of default locale:");
        System.out.println("language: " + locales.get(1).getLanguage());
        System.out.println("country: " + locales.get(1).getCountry());

        System.out.println("\nItaly locale's language and country in terms of Japan locale:");
        System.out.println("language: " + locales.get(1).getDisplayLanguage(locales.get(0)));
        System.out.println("country: " + locales.get(1).getDisplayCountry(locales.get(0)));
    }

    private static void printLabelsEnCaResourceBundle() {
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("locale.Labels", locale);
        System.out.println("\nContent of the custom resource bundle Labels_en_CA.java:");
        System.out.println("list = " + rb.getObject("list"));
        System.out.println("boolean = " + rb.getObject("boolean"));
        System.out.println("stringBuilder = " + rb.getObject("stringBuilder"));
    }
}
