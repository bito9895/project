package project.ntsk.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.entity.NtskEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleAKey implements NtskEntity {

	private Integer key1;
	private Integer key2;
	private Integer key3;

}
