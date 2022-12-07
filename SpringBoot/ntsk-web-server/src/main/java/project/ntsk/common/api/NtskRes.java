package project.ntsk.common.api;

import lombok.Data;

@Data
public class NtskRes<T> {

	private String responseId;

	private T responseData;

}
