package project.ntsk.domain.value;

import lombok.Getter;

public enum ResCode {

	OK(0, "OK"),
	NG(1, "NG");

	@Getter
	private int no;
	@Getter
	private String name;

	private ResCode(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static ResCode of(int no) {
		for (ResCode enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResCode of(String name) {
		for (ResCode enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResCode[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (ResCode enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (ResCode enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
