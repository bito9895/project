package project.ntsk.domain.model.api;

import lombok.Data;
import project.ntsk.common.jms.NtskJms;

@Data
public class SampleARes implements NtskJms {

	private String value1;
	private String value2;
	private String value3;

}
