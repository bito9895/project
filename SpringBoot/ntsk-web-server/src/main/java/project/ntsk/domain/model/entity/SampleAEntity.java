package project.ntsk.domain.model.entity;

import lombok.Data;
import project.ntsk.common.model.NtskEntity;

@Data
public class SampleAEntity implements NtskEntity {

	private Integer key1;
	private Integer key2;
	private Integer key3;
	private String value1;
	private String value2;
	private String value3;

	@Override
	public SampleAEntity clone() throws CloneNotSupportedException {
		SampleAEntity clone = (SampleAEntity) super.clone();
		return clone;
	}

}
