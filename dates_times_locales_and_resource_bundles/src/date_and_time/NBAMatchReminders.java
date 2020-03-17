package date_and_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class NBAMatchReminders {

    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");
    private static final Duration HALF_DAY_DURATION = ChronoUnit.HALF_DAYS.getDuration();
    private static final ZoneId ZONE_ID_MADRID = ZoneId.of("Europe/Madrid");
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_RESET  = "\u001B[0m";

    private static ZonedDateTime MATCH_ARIZONA_TIME =
            ZonedDateTime.now(ZoneId.of("US/Arizona"))
                    .plusMonths(3)
                    .withHour(20)
                    .withMinute(0)
                    .withSecond(0);

    public static void main(String[] args) {
        List<ZonedDateTime> reminders = createReminders();
        otherHandyMethods(reminders);
    }

    private static List<ZonedDateTime> createReminders() {
        ZonedDateTime matchSpainTime;
        ZonedDateTime matchReminder;
        ZonedDateTime videoCallReminder;

        System.out.println("\nCREATE REMINDERS");
        System.out.println("The NBA match will be played in Arizona in three months: " + getFormattedZonedDateTime(MATCH_ARIZONA_TIME));
        matchSpainTime = MATCH_ARIZONA_TIME.withZoneSameInstant(ZONE_ID_MADRID);
        System.out.println("when in Spain would be " + getFormattedZonedDateTime(matchSpainTime));

        System.out.println("\nFor this reason, Jose need to set a couple of reminders:");
        matchReminder = matchSpainTime.minus(HALF_DAY_DURATION);
        System.out.println("\t1. Half day before the match ---> " + getFormattedZonedDateTime(matchReminder));
        videoCallReminder = MATCH_ARIZONA_TIME.plusHours(13).withZoneSameInstant(ZONE_ID_MADRID);
        System.out.println("\t2. When in Arizona will be 9:00 am to talk with Mike ---> " + getFormattedZonedDateTime(videoCallReminder));

        return Arrays.asList(matchReminder, videoCallReminder);
    }

    private static void otherHandyMethods(List<ZonedDateTime> reminders) {
        System.out.println("\nOTHER HANDY METHODS");
        System.out.println("We take advantage of this example to show other handy methods of java.time.* package.");

        ZonedDateTime matchReminder = reminders.get(0);
        ZonedDateTime videoCallReminder = reminders.get(1);
        System.out.println("\nWe could know the day of the week of our reminders using the method getDayOfWeek():");
        System.out.println("\t> Day of the week for the match reminder: " + getFormattedDayOfTheWeek(matchReminder));
        System.out.println("\t> Day of the week for the video call reminder: " + getFormattedDayOfTheWeek(videoCallReminder));

        boolean isBefore = matchReminder.isBefore(videoCallReminder);
        System.out.println("\nIs the match reminder before the video call reminder? " + getFormattedBoolean(isBefore));

        boolean isLeapYear = matchReminder.toLocalDate().isLeapYear();
        System.out.println("\nIs the year of the match a leap year? " + getFormattedBoolean(isLeapYear));
        int nextYear = matchReminder.plusYears(1).getYear();
        isLeapYear = Year.of(nextYear).isLeap();
        System.out.println("\nIs " + nextYear + " a leap year? " + getFormattedBoolean(isLeapYear));
    }

    private static String getFormattedZonedDateTime(ZonedDateTime zonedDateTime) {
        return getFormattedString(DATE_TIME_FORMATTER.format(zonedDateTime));
    }

    private static String getFormattedDayOfTheWeek(ZonedDateTime zonedDateTime) {
        return getFormattedString(zonedDateTime.getDayOfWeek().toString());
    }

    private static String getFormattedBoolean(boolean b) {
        return getFormattedString(Boolean.toString(b));
    }

    private static String getFormattedString(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }
}
