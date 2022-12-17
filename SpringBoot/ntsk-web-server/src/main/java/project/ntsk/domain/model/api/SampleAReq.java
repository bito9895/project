package project.ntsk.domain.model.api;

import lombok.Data;
import project.ntsk.common.jms.NtskJms;

@Data
public class SampleAReq implements NtskJms {

	private Integer key1;
	private Integer key2;
	private Integer key3;

}
