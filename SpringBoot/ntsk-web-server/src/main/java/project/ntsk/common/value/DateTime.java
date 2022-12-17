package project.ntsk.common.value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

	LocalDateTime value;

	public DateTime(LocalDateTime value) {
		this.value = value;
	}

	public DateTime(Date date) {
		this.value = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public static DateTime now() {
		return new DateTime(LocalDateTime.now(ZoneId.systemDefault()));
	}

	public static DateTime parseUTC(String datetime) {
		return new DateTime(LocalDateTime.parse(datetime, DateTimeFormatter.ISO_INSTANT));
	}

	public static DateTime parseLocal(String datetime) {
		return new DateTime(LocalDateTime.parse(datetime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
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
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(value);
	}

	public Date toDate() {
		return Date.from(ZonedDateTime.of(value, ZoneId.systemDefault()).toInstant());
	}

	public DateTime toDateTime() {
		return new DateTime(value);
	}

	public LocalDate toLocalDate() {
		return value.toLocalDate();
	}

	public boolean isAfter(DateTime other) {
		return value.isAfter(other.value);
	}

	public boolean isBefore(DateTime other) {
		return value.isBefore(other.value);
	}

}
