package project.ntsk.infrastructure.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.structure.NtskRepository;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.repository.SampleARepository;

@Slf4j
@Repository
public class SampleARepositoryImpl extends NtskRepository<SampleAKey, SampleAEntity> implements SampleARepository {

	private static final String TABLE_NAME = "";

	private BeanPropertyRowMapper<SampleAEntity> rowMapper = new BeanPropertyRowMapper<SampleAEntity>(SampleAEntity.class);

	public List<SampleAEntity> find(SampleAKey key) {
		return findSuper(TABLE_NAME, rowMapper, key);
	}

	public SampleAEntity findByKey(SampleAKey key) {
		return findByKeySuper(TABLE_NAME, rowMapper, key);
	}

	public int delete(SampleAKey key) {
		return deleteSuper(TABLE_NAME, key);
	}

	public int save(SampleAEntity entity) {
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("value1", entity.getValue1());
		map.put("value2", entity.getValue2());
		map.put("value3", entity.getValue3());
		return saveSuper(TABLE_NAME, map);
	}

}
