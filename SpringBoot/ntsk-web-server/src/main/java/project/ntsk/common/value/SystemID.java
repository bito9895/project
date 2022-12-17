package project.ntsk.common.value;

import lombok.Getter;

public enum SystemID {

	NTSK(1, "NTSK"),
	XXXX(2, "XXXX");

	@Getter
	private int no;
	@Getter
	private String name;

	private SystemID(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static SystemID of(int no) {
		for (SystemID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static SystemID of(String name) {
		for (SystemID enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static SystemID[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (SystemID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (SystemID enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
