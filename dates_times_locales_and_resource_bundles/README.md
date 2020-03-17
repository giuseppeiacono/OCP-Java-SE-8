# Dates, Times, Locales and Resource Bundle
+ [Overview](#overview)
+ [Dates and times](#dates-and-times)
+ [ZONED Dates and times](#zoned-dates-and-times)
+ [Date and time adjustment](#date-and-time-adjustment)
+ [Periods, Durations and Instants](#periods-durations-and-instants)
    - [NBA match reminders](#nba-match-reminders)
+ [Exam tricks](#exam-tricks)


## Overview
This module includes one of the biggest news of Java 8, the package ``java.time.*`` that will totally replace the oldest classes:
* ``java.util.Date``
* ``java.util.Calendar``
* ``java.text.DateFormat`` 

It provides intuitive features to work with datetime objects, amounts of time, timezones and it allows to format dates and times in several ways.

We will see some classes to work with date-based and time-based events.

Finally, we will talk about the most important aspects of ``Locale``, properties files and resource bundle.

## Dates and times

![alt text](readme_resources/java-time-package.png)

The exam will be focused on the following classes of this new package. The image show the most common methods to create and adjust datetime objects.

![alt text](readme_resources/create-and-adjust-datetime-objects.png)

Take a look at [the code examples](src/date_and_time/DateAndTime.java) to understand how to create and adjust datetime objects.

## ZONED Dates and times
> ``ZonedDateTime`` = ``LocalDateTime`` + time zone

Follow the basic concepts of time zones:
 * all time zones are based on GMT (Greenwich Mean Time) which use as time standard UTC (Coordinated Universal Time).
 * each time zone is represented as a ``ZoneId``
    > NOTE: the complete list of time zones is not available on the documentation of class ``ZoneId``, but it can be obtained by code:
    > ```
    > Set<String> zoneIds = ZoneId.getAvailableZoneIds();
    > List<String> zoneList = new ArrayList<String>(zoneIds);
    > Collections.sort(zoneList);
    > for (String zoneId : zoneList) {
    >       System.out.println(zoneId);
    > }
    > ```
 * ``ZoneRules`` has all the rules about time zones, daylight savings and standard time
 * ``OffsetDateTime`` is a fixed datetime and offset independent from``ZoneRules``
 
 Look at [``DateTimeWithTimeZone``](src/date_and_time/DateTimeWithTimeZone.java) to see some basic operation with ``ZonedDateTime``.

## Date and time adjustment
``LocalDateTime`` and ``ZonedDateTime`` are immutable, but you can create a new datetime object from them with the adjusters provided by ``java.time.*`` package.

There are some example in [DateTimeAdjusters](src/date_and_time/DateTimeAdjusters.java)

## Periods, Durations and Instants
The new package ``java.time.*`` provides two classes to represent a period of time: 
 * ``Period`` represent a period of time >= 1 DAY
 * ``Duration`` represent a period of time < 1 DAY
 
Both could be added-to or subtracted-from ``LocalDateTime`` and ``ZonedDateTime``. For instance, if you need to set a reminder 
one week before an event you could do it:
```
ZonedDateTime event = ZonedDateTime.of(2020, 8, 2, 14, 30, 0, 0, ZoneId.of("Europe/Madrid"));
Period oneMonthPeriod = Period.ofMonths(1);
ZonedDateTime reminder = event.minus(oneMonthPeriod); 
```

``ChronoUnit`` is an enum that represent a unit of time (minutes, months...). This class is commonly used when we need to calculate 
the time difference between two ``LocalTime`` and create a ``Duration`` from it.
```
LocalTime beginning = LocalTime.parse("11:23:00");
LocalTime end = LocalTime.parse("14:53:00");
long timeDifference = ChronoUnit.MINUTES.between(beginning, end);
Duration durationMinutes = Duration.ofMinutes(timeDifference);
System.out.println("Duration is " + durationMinutes);
```
The output is **Duration is PT3H30M**, where PT means "period of time" and the remaining value is the difference of time of three hours and 30 minutes.

### NBA match reminders
We talk about several features of the new ``java.time.*`` package that are very intuitive and simplify the way to deal with datetime objects. 
But now it's time to see a real example in order to understand how to make the most their power!

Suppose that Jose is living in Seville (Spain) and he love NBA! He would like to watch live match, but he need a reminder because they will play early in the morning in his time zone.
Moreover, Jose and his American friend Mike like to comment on the match the day after it, so Jose need another reminder to be sure that Mike will be awake when he will make the video call. 

The class [``NBAmatchReminder``](src/date_and_time/NBAMatchReminders.java) shows this scenario.

## Exam tricks
> **``Instant`` is always displayed in UTC!!!**
>
> Even if you get an ``Instant`` from a ``ZonedDateTime``, it is always displayed in UTC. That's why the method ``toString()`` use the format 
> [``DateTimeFormatter.ISO_INSTANT``](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#ISO_INSTANT) as indicated in
> [the official documentation](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html#toString--) 