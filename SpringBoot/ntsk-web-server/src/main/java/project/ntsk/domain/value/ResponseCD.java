package project.ntsk.domain.value;

import lombok.Getter;

public enum ResponseCD {

	OK(0, "OK"),
	NG(1, "NG");

	@Getter
	private int no;
	@Getter
	private String name;

	private ResponseCD(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static ResponseCD of(int no) {
		for (ResponseCD enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResponseCD of(String name) {
		for (ResponseCD enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResponseCD[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (ResponseCD enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (ResponseCD enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
