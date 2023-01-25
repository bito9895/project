package project.ntsk.common.value;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lombok.Getter;

public class DateTime {

	LocalDateTime value;

	public static enum DateTimeFormat {
		YYYYMMDD("JAPAN"),
		YYYYMMDDHHmm("JAPAN"),
		YYYYMMDDHHmmss("JAPAN"),
		YYYYMMDDHHmmssSSS("USA"),
		YYYY_MM_DD("USA"),
		YYYY_MM_DDTHHSS("USA");

		@Getter
		private DateTimeFormatter value;

		private DateTimeFormat(String format) {
			this.value = DateTimeFormatter.ofPattern(format);
		}

		private DateTimeFormat(DateTimeFormatter format) {
			this.value = format;
		}

	}

	public DateTime(LocalDateTime value) {
		this.value = value;
	}

	public DateTime(Date date) {
		this.value = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	public static DateTime parse(Date date) {
		return new DateTime(date);
	}

	public static DateTime parse(String datetime, DateTimeFormat format) {
		if (format == null) {

		}
		if (DateTimeFormat.YYYYMMDD.equals(format)) {

		}
		return new DateTime(LocalDateTime.parse(datetime, format.value));
	}

	public static DateTime nowLocal() {
		return new DateTime(LocalDateTime.now(ZoneId.systemDefault()));
	}

	public static DateTime nowUTC() {
		return new DateTime(LocalDateTime.now(ZoneId.of("UTC")));
	}

	public String toString(DateTimeFormatter format) {
		return DateTimeFormatter.ofPattern(format.toString()).format(value);
	}

	public Date toDate() {
		return Date.from(ZonedDateTime.of(value, ZoneId.systemDefault()).toInstant());
	}

	public boolean isAfter(DateTime other) {
		return value.isAfter(other.value);
	}

	public boolean isBefore(DateTime other) {
		return value.isBefore(other.value);
	}

	public DateTime addDays(int addDays) {
		return new DateTime(addDays > 0 ? value.plusDays(addDays) : value.minusDays(addDays));
	}

	public DateTime addHour(int addHours) {
		return new DateTime(addHours > 0 ? value.plusHours(addHours) : value.minusHours(addHours));
	}

	public DateTime addMinutes(int addMinutes) {
		return new DateTime(addMinutes > 0 ? value.plusMinutes(addMinutes) : value.minusMinutes(addMinutes));
	}

	public DateTime addSeconds(int addSeconds) {
		return new DateTime(addSeconds > 0 ? value.plusSeconds(addSeconds) : value.minusSeconds(addSeconds));
	}

	public long diffDays(DateTime other) {
		return ChronoUnit.DAYS.between(value, other.value);
	}

	public long diffHours(DateTime other) {
		return ChronoUnit.HOURS.between(value, other.value);
	}

	public long diffMinutes(DateTime other) {
		return ChronoUnit.MINUTES.between(value, other.value);
	}

	public long diffSeconds(DateTime other) {
		return ChronoUnit.SECONDS.between(value, other.value);
	}

}
