package project.ntsk.domain.model.api;

import java.util.List;

import lombok.Data;
import project.ntsk.common.model.NtskDto;

@Data
public class SampleBRes implements NtskDto {

	private String value1;
	private String value2;
	private String value3;
	private List<SampleBResValues> values1;

}
