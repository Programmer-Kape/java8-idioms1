package org.kape.idioms1;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class DateTimeApi {

  public static final String DATE_FORMAT = "yyyy-MM-dd";

  public static final String TIME_FORMAT = "HH:mm";

  public static final String DT_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

  public static void main(String... args) {
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    LocalDateTime dt1 = LocalDateTime.now();
    LocalDateTime dt2 = date.atTime(time);
  }
}
