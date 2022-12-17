package project.ntsk.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.value.ResID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NtskBasicRes<T> implements NtskRes {
	private ResID responseCode;
	private T responseData;
}
