package project.ntsk.common.exception;

import lombok.Getter;
import project.ntsk.common.value.DateTime;

public class NtskException extends Exception {

	@Getter
	DateTime timestamp = DateTime.now();

}
