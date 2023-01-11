package project.ntsk.domain.model.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ntsk.common.entity.NtskKey;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SampleAKey implements NtskKey {

	private Integer key1;
	private Integer key2;
	private Integer key3;
	private String where;
	private String orderBy;
	private Integer limit;
	private Map<String, Object> paramMap;

}
