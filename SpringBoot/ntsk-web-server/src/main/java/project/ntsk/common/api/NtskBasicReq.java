package project.ntsk.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NtskBasicReq<T> implements NtskReq {
	private String requestCode;
	private T requestData;
}
