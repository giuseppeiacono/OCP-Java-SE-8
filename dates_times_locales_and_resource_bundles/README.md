# Dates, Times, Locales and Resource Bundle
+ [Overview](#overview)
+ [Dates and times](#dates-and-times)
+ [ZONED Dates and times](#zoned-dates-and-times)

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
> ``ZonedDateTime.java`` = ``LocalDateTime`` + time zone

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