package project.ntsk.common.exception;

import org.springframework.lang.Nullable;

import lombok.Getter;
import project.ntsk.common.value.DateTime;

public class NtskException extends Exception {

	@Getter
	DateTime dateTime = DateTime.now();

	public NtskException(String msg) {
		super(msg);
	}

	public NtskException(@Nullable String msg, @Nullable Throwable cause) {
		super(msg, cause);


	}

}
