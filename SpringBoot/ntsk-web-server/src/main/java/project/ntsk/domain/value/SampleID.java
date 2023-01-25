package project.ntsk.domain.value;

import lombok.Getter;

public enum SampleID {

	SAMPLE1(1, "SAMPLE1"),
	SAMPLE2(2, "SAMPLE2"),
	SAMPLE3(3, "SAMPLE3");

	@Getter
	private int no;
	@Getter
	private String name;

	private SampleID(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public static SampleID of(int no) {
		for (SampleID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static SampleID of(String name) {
		for (SampleID enumValue : values()) {
			if (enumValue.getName() == name) {
				return enumValue;
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public static SampleID[] getAll() {
		return values();
	}

	public static boolean exsistNo(int no) {
		for (SampleID enumValue : values()) {
			if (enumValue.getNo() == no) {
				return true;
			}
		}
		return false;
	}

	public static boolean exsistName(String name) {
		for (SampleID enumValue : values()) {
			if (enumValue.getName() == name) {
				return true;
			}
		}
		return false;
	}

}
