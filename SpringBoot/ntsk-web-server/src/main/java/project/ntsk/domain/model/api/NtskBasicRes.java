package project.ntsk.domain.model.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.model.NtskDto;
import project.ntsk.domain.value.ResponseCD;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NtskBasicRes<T> implements NtskDto {
	private ResponseCD responseCode;
	private T responseData;
}
