package date_and_time;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class NBAMatchReminders {

    private static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

    private static final Duration HALF_DAY_DURATION = ChronoUnit.HALF_DAYS.getDuration();

    private static final ZoneId ZONE_ID_MADRID = ZoneId.of("Europe/Madrid");

    private static ZonedDateTime MATCH_ARIZONA_TIME =
            ZonedDateTime.now(ZoneId.of("US/Arizona"))
                    .plusMonths(3)
                    .withHour(20)
                    .withMinute(0)
                    .withSecond(0);

    public static void main(String[] args) {
        ZonedDateTime matchSpainTime;
        ZonedDateTime reminderMatch;
        ZonedDateTime reminderCallMike;

        System.out.println("\nThe NBA match will be played in Arizona in three months: " + DATE_TIME_FORMATTER.format(MATCH_ARIZONA_TIME));
        matchSpainTime = MATCH_ARIZONA_TIME.withZoneSameInstant(ZONE_ID_MADRID);
        System.out.println("when in Spain would be " + DATE_TIME_FORMATTER.format(matchSpainTime));

        System.out.println("\nFor this reason, Jose need to set a couple of reminders:");
        reminderMatch = matchSpainTime.minus(HALF_DAY_DURATION);
        System.out.println("\t1. Half day before the match ---> " + DATE_TIME_FORMATTER.format(reminderMatch));
        reminderCallMike = MATCH_ARIZONA_TIME.plusHours(13).withZoneSameInstant(ZONE_ID_MADRID);
        System.out.println("\t2. When in Arizona will be 9:00 am to talk with Mike ---> " + DATE_TIME_FORMATTER.format(reminderCallMike));
    }
}
