package project.ntsk.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NtskSimpleRes implements NtskRes {
	private String responseCode;
}
