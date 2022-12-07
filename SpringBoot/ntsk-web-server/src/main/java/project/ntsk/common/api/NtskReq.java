package project.ntsk.common.api;

import lombok.Data;

@Data
public class NtskReq<T> {

	private String requestId;

	private T requestData;

}
