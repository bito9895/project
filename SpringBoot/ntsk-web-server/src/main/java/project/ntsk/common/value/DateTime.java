package project.ntsk.common.value;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

	LocalDateTime value;

	public DateTime(LocalDateTime value) {
		this.value = value;
	}

	public DateTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		this.value = localDateTime;
	}

	public DateTime(OffsetDateTime offsetDateTime) {
		Instant instant = offsetDateTime.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		this.value = localDateTime;
	}

	public DateTime(String datetime) {
		LocalDate d = LocalDate.parse(datetime.substring(0, 10), DateTimeFormatter.ISO_DATE);
		LocalTime t = LocalTime.parse(datetime.substring(11, 16), DateTimeFormatter.ofPattern("H:m"));
		this.value = LocalDateTime.of(d, t);
	}

	public static DateTime now() {
		return new DateTime(LocalDateTime.now());
	}

	public static DateTime parse(OffsetDateTime datetime) {
		return new DateTime(datetime);
	}

	public static DateTime parse(String datetime) {
		LocalDate d = LocalDate.parse(datetime.substring(0, 10), DateTimeFormatter.ISO_DATE);
		LocalTime t = LocalTime.parse(datetime.substring(11, 15), DateTimeFormatter.ofPattern("H:m"));
		return new DateTime(LocalDateTime.of(d, t));
	}

	public static DateTime parse(String date, String time) {
		LocalDate d = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
		LocalTime t = LocalTime.parse(time, DateTimeFormatter.ofPattern("H:m"));
		return new DateTime(LocalDateTime.of(d, t));
	}

	public static DateTime parse(String date, String hour, String minute) {
		return parse(date, hour + ":" + minute);
	}

	@Override
	public String toString() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(value);
	}

	public Date toDate() {
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(this.value, zone);
		Instant instant = zonedDateTime.toInstant();
		Date date = Date.from(instant);

		return date;
	}

	public OffsetDateTime toOffsetDateTime() {
		ZoneId zone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(this.value, zone);
		Instant instant = zonedDateTime.toInstant();
		ZoneOffset offset = ZoneOffset.ofHours(9);
		OffsetDateTime offsetDateTime = instant.atOffset(offset);
		return offsetDateTime;
	}

	public boolean isAfter(DateTime other) {
		return value.isAfter(other.value);
	}

	public boolean isBefore(DateTime other) {
		return value.isBefore(other.value);
	}

}
