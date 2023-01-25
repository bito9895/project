package project.ntsk.domain.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.model.NtskDto;
import project.ntsk.domain.value.ResCode;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiBasicRes<T> implements NtskDto {
	private ResCode responseCode;
	private T responseData;
}
