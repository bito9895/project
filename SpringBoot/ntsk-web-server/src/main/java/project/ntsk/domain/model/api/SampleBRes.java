package project.ntsk.domain.model.api;

import java.util.List;

import lombok.Data;
import project.ntsk.common.jms.NtskJms;

@Data
public class SampleBRes implements NtskJms {

	private String value1;
	private String value2;
	private String value3;
	private List<SampleBResValues1> values1;
	private List<SampleBResValues2> values2;

}
