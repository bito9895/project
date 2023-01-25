package project.ntsk.domain.model.entity;

import lombok.Data;
import project.ntsk.common.model.NtskEntity;

@Data
public class SampleEntity implements NtskEntity {

	private String key1;
	private String key2;
	private String key3;
	private String value1;
	private String value2;
	private String value3;

	@Override
	public SampleEntity clone() throws CloneNotSupportedException {
		SampleEntity clone = (SampleEntity) super.clone();
		return clone;
	}

}
