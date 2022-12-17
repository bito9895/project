package project.ntsk.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NtskErrorRes implements NtskRes {
	private String errorCode;
	private String errorMessage;
}
