package project.ntsk.common.value;

import lombok.Getter;

public enum ResID {

	OK(0, "OK"),
	NG(1, "NG");

	@Getter
	private int no;
	@Getter
	private String name;

	private ResID(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static ResID of(int no) {
		for (ResID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResID of(String name) {
		for (ResID enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static ResID[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (ResID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (ResID enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
