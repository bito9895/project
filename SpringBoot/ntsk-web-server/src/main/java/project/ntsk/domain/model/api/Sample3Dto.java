package project.ntsk.domain.model.api;

import lombok.Data;
import project.ntsk.common.model.NtskDto;
import project.ntsk.domain.value.SampleID;

@Data
public class Sample3Dto implements NtskDto {

	private SampleID key;
	private String key1;
	private String key2;
	private String key3;
	private String value1;
	private String value2;
	private String value3;
	
}
