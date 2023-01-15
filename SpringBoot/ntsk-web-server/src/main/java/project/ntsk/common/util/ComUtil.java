package project.ntsk.common.util;

public class ComUtil {

	public static final String CNAME = ComUtil.class.getSimpleName();

	/**
	 * トリム（NULLのみ）.
	 *
	 * @param str 文字列
	 * @return String 文字列
	 */
	public static String trimEndNull(String str) {
		char[] value = str.toCharArray();
		int len = value.length;
		int st = 0;

		while ((st < len) && (value[len - 1] == 0x00)) {
			len--;
		}
		return ((st > 0) || (len < value.length)) ? str.substring(st, len) : str;
	}

	/**
	 * lpad(左埋め).
	 *
	 * @param str 文字列
	 * @param len 長さ
	 * @param addStr 付加文字
	 * @return String 文字列
	 */
	public static String lpad(String str, int len, String addStr) {
		return fillString(str, "L", len, addStr);
	}

	/**
	 * lpad(左埋め).
	 *
	 * @param str 文字列
	 * @param len 長さ
	 * @param addStr 付加文字
	 * @return String 文字列
	 */
	public static String lpad(int str, int len, String addStr) {
		return fillString(String.valueOf(str), "L", len, addStr);
	}

	/**
	 * rpad(右埋め).
	 *
	 * @param str 文字列
	 * @param len 長さ
	 * @param addStr 付加文字
	 * @return String 文字列
	 */
	public static String rpad(String str, int len, String addStr) {
		return fillString(str, "R", len, addStr);
	}

	/**
	 * rpad(右埋め).
	 *
	 * @param str 文字列
	 * @param len 長さ
	 * @param addStr 付加文字
	 * @return String 文字列
	 */
	public static String rpad(int str, int len, String addStr) {
		return fillString(String.valueOf(str), "R", len, addStr);
	}

	/**
	 * fillString.
	 *
	 * @param str 文字列
	 * @param position L/R
	 * @param len 長さ
	 * @param addStr 付加文字
	 * @return String 文字列
	 */
	private static String fillString(String str, String position, int len, String addStr) {
		if (addStr == null || addStr.length() == 0) {
			return str;
		}
		if (str == null) {
			str = "";
		}
		StringBuffer buffer = new StringBuffer(str);
		while (len > buffer.length()) {
			if (position.equalsIgnoreCase("l")) {
				int sum = buffer.length() + addStr.length();
				if (sum > len) {
					addStr = addStr.substring(0, addStr.length() - (sum - len));
					buffer.insert(0, addStr);
				} else {
					buffer.insert(0, addStr);
				}
			} else {
				buffer.append(addStr);
			}
		}
		if (buffer.length() == len) {
			return buffer.toString();
		}
		return buffer.toString().substring(0, len);
	}

}
