package project.ntsk.domain.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.model.NtskDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiErrorRes implements NtskDto {
	private String errorCode;
	private String errorMessage;
}
