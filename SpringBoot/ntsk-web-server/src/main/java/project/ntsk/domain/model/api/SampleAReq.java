package project.ntsk.domain.model.api;

import lombok.Data;
import project.ntsk.common.model.NtskDto;

@Data
public class SampleAReq implements NtskDto {

	private Integer key1;
	private Integer key2;
	private Integer key3;

}
