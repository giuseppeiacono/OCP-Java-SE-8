package date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static void main(String[] args) {
        // this code use classes that have no time-zone information
        dateAndTimeNow();
        dateAndTimeOf();
        dateAndTimeParse();
        dateAndTimeAdjusters();
    }

    private static void dateAndTimeNow() {
        LocalDate localDateNow = LocalDate.now();
        System.out.println("\nLocalDate.now() is " + localDateNow);

        LocalTime localTimeNow = LocalTime.now();
        System.out.println("LocalTime.now() is " + localTimeNow);

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println("LocalDateTime.now() is " + localDateTimeNow + "  <--  date and time are separeted by 'T'");
    }

    private static void dateAndTimeOf() {
        LocalDate localDateOf = LocalDate.of(1985, 4, 24);
        System.out.println("\nLocalDate.of(1985, 4, 24) is " + localDateOf);

        LocalTime localTimeOf = LocalTime.of(12, 10, 2);
        System.out.println("LocalTime.of(12, 10, 2) is " + localTimeOf);

        LocalDateTime localDateTimeOf = LocalDateTime.of(localDateOf, localTimeOf);
        System.out.println("LocalDateTime.of(localDateOf, localTimeOf) is " + localDateTimeOf + "  <--  date and time are separeted by 'T'");
    }

    private static void dateAndTimeParse() {
        LocalDate localDateParse = LocalDate.parse("2017-06-02");
        System.out.println("\nLocalDate.parse(\"2017-06-02\") is " + localDateParse);

        LocalTime localTimeParse = LocalTime.parse("15:03:33");
        System.out.println("LocalTime.parse(15:03:33) is " + localTimeParse);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String datetime = "1968-04-30 14:10";
        LocalDateTime localDateTimeParse = LocalDateTime.parse(datetime, dateTimeFormatter);
        System.out.println("LocalDateTime.parse(" + datetime + ") is " + localDateTimeParse + "  <--  date and time are separeted by 'T'");
        System.out.println(datetime + " format is changed as " + localDateTimeParse.format(DateTimeFormatter.ofPattern("dd, MM, yy hh, mm")));
    }

    private static void dateAndTimeAdjusters() {
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println("\nLocalDateTime.now() is " + localDateTimeNow);
        System.out.println("localDateTimeNow.plusDays(3) is " + localDateTimeNow.plusDays(3));
        System.out.println("localDateTimeNow.plusHours(5) is " + localDateTimeNow.plusHours(5));
        System.out.println("localDateTimeNow.getDayOfWeek() is " + localDateTimeNow.getDayOfWeek());
        System.out.println("localDateTimeNow.getDayOfMonth() is " + localDateTimeNow.getDayOfMonth());
        System.out.println("localDateTimeNow.getDayOfYear() is " + localDateTimeNow.getDayOfYear());
    }
}
