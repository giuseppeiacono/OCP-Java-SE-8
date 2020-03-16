package date_and_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeWithTimeZone {

    public static void main(String[] args) {
        zonedDateTimeNow();
        zonedDateTimeOf();
        zonedDateTimeParse();
        isTimezoneInDaylightTime();
        getAllZoneIds();
    }

    private static void zonedDateTimeNow() {
        ZonedDateTime zonedDateTimeNow = ZonedDateTime.now();
        System.out.println("\nZonedDateTime.now() is " + zonedDateTimeNow);
    }

    private static void zonedDateTimeOf() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        ZoneId zoneIdRome = ZoneId.of("Europe/Rome");
        ZonedDateTime zonedDateTimeRomeOf = ZonedDateTime.of(localDateTimeNow, zoneIdRome);
        System.out.println("\nZonedDateTime.of(localDateTimeNow, zoneIdRome) is " + zonedDateTimeRomeOf);
    }

    private static void zonedDateTimeParse() {
        String zonedDateTimeToParse = "2019-04-01T16:24:11.252+05:30[Europe/Madrid]";
        ZonedDateTime zonedDateTimeParse = ZonedDateTime.parse(zonedDateTimeToParse);
        System.out.println("\nZonedDateTime.parse(\"2019-04-01T16:24:11.252+05:30[Europe/Madrid]\") is " + zonedDateTimeParse);

        String format = "E, d MMM yyyy HH:mm:ss z";
        zonedDateTimeToParse = "Mon, 1 Apr 2019 11:05:30 GMT";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        ZonedDateTime zonedDateTimeFormatted = ZonedDateTime.parse(zonedDateTimeToParse, dateTimeFormatter);
        System.out.println("Applying the format '" + format + "' to " + zonedDateTimeToParse + " we obtain " + zonedDateTimeFormatted);
    }

    private static void isTimezoneInDaylightTime() {
        ZoneId pacific = ZoneId.of("US/Pacific");
        ZonedDateTime zonedDateTimePacific = ZonedDateTime.of(LocalDateTime.now(), pacific);
        boolean isDaylightTime = pacific.getRules().isDaylightSavings(zonedDateTimePacific.toInstant());
        System.out.println("\nUS/Pacific is in Daylight Savings Time: " + Boolean.toString(isDaylightTime).toUpperCase());
    }

    private static void getAllZoneIds() {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        List<String> zoneList = new ArrayList<>(zoneIds);
        Collections.sort(zoneList);
        System.out.println("\n----------- Complete list of zone ids -----------");
        for (String zoneId : zoneList) {
            System.out.println(zoneId);
        }
    }
}
