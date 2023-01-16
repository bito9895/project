package project.ntsk.domain.model.api;

import java.util.List;

import lombok.Data;
import project.ntsk.common.model.NtskDto;

@Data
public class SampleBReq implements NtskDto {

	private String key1;
	private String key2;
	private String key3;
	private List<SampleBReqKeys> keys;

}
