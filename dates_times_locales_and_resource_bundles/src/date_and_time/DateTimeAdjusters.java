package date_and_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeAdjusters {

    public static void main(String[] args) {
        adjustLocalDateTime();
        adjustZonedDateTime();
    }

    private static void adjustLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("\nLocalDateTime.now() is " + localDateTime);
        System.out.println(localDateTime + " plus 4 hours is " + localDateTime.plusHours(4));
        System.out.println(localDateTime + " minus 56 days is " + localDateTime.minusDays(56));
        System.out.println(localDateTime + " plus 4 years is " + localDateTime.plusYears(4));
        System.out.println(localDateTime + " with day 230 of the year is " + localDateTime.withDayOfYear(230));
        System.out.println(localDateTime + " with day 28 of the month is " + localDateTime.withDayOfMonth(28));
    }

    private static void adjustZonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("\nZonedDateTime.now() is " + zonedDateTime);
        System.out.println(zonedDateTime + " plus 28 hours is " + zonedDateTime.plusHours(28));
        System.out.println(zonedDateTime + " minus 14 days is " + zonedDateTime.minusDays(14));
        System.out.println(zonedDateTime + " plus 40 years is " + zonedDateTime.plusYears(40));
        System.out.println(zonedDateTime + " with day 41 of the year is " + zonedDateTime.withDayOfYear(41));
        System.out.println(zonedDateTime + " with day 1 of the month is " + zonedDateTime.withDayOfMonth(1));
        System.out.println(zonedDateTime + " with the same instant of US/Pacific zone is " + zonedDateTime.withZoneSameInstant(ZoneId.of("US/Pacific")));
    }
}
