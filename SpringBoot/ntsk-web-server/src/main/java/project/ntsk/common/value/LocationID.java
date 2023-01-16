package project.ntsk.common.value;

import lombok.Getter;

public enum LocationID {

	JAPAN(1, "JAPAN"), USA(2, "USA");

	@Getter
	private int no;
	@Getter
	private String name;

	private LocationID(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static LocationID of(int no) {
		for (LocationID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static LocationID of(String name) {
		for (LocationID enumValue : values()) {
			if (enumValue.getName().equals(name)) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static LocationID[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (LocationID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (LocationID enumValue : values()) {
			if (enumValue.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

}
