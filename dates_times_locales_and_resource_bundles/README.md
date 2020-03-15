# Dates, Times, Locales and Resource Bundle
+ [Overview](#overview)
+ [Dates and times](#dates-and-times)

## Overview
This module includes notes concerning to the features of the new ``java.time.*`` package to work with dates, times and amounts of time.
It shows how to take into account timezones and format dates and times values.

Moreover, it explains how to work with date-based and time-based events using new classes like ``Instant``, ``Period``, ``Duration`` and ``TemporalUnit``.

Finally, we will see the most important aspects of ``Locale``, properties files and resource bundle.

## Dates and times
One of the biggest news of Java 8 is the package ``java.time.*`` that will totally replace the oldest classes:
 * ``java.util.Date``
 * ``java.util.Calendar``
 * ``java.text.DateFormat``

![alt text](readme_resources/java-time-package.png)

The exam will be focused on the following classes of this new package. The image show the most common methods to create and adjust datetime objects.

![alt text](readme_resources/create-and-adjust-datetime-objects.png)

Take a look at [the code examples](src/date_and_time/DateAndTime.java) to understand how to create and adjust datetime objects.