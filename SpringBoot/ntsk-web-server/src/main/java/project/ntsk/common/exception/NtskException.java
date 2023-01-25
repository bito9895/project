package project.ntsk.common.exception;

import lombok.Getter;
import project.ntsk.common.value.DateTime;

public class NtskException extends Exception {

	@Getter
	DateTime dateTime = DateTime.nowLocal();

	public NtskException(String msg) {
		super(msg);
	}

	public NtskException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
