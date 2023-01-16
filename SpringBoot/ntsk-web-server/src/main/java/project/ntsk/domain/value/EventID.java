package project.ntsk.domain.value;

import lombok.Getter;

public enum EventID {

	NTSK(1, "NTSK"),
	XXXX(2, "XXXX");

	@Getter
	private int no;
	@Getter
	private String name;

	private EventID(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static EventID of(int no) {
		for (EventID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static EventID of(String name) {
		for (EventID enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static EventID[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (EventID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (EventID enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
