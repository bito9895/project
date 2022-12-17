package project.ntsk.infrastructure.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.repository.SampleARepository;

@Repository
public class PostgresSampleARepository implements SampleARepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private BeanPropertyRowMapper<SampleAEntity> rowMapper = new BeanPropertyRowMapper<SampleAEntity>(SampleAEntity.class);

	public List<SampleAEntity> find(SampleAKey key) {
		String sql = "SELECT * FROM SAMPLE_A";


		return jdbcTemplate.query(sql, rowMapper);
	}

	public SampleAEntity findByKey(SampleAKey key) {
		String sql = "SELECT * FROM SAMPLE_A WHERE key1 = ? AND key2 = ? AND key3 = ?";
		return jdbcTemplate.queryForObject(sql, rowMapper, key.getKey1(), key.getKey2(), key.getKey3());
	}

	public int delete(SampleAKey key) {
		String sql = "DELETE FROM SAMPLE_A WHERE key1 = ? AND key2 = ? AND key3 = ?";
		return jdbcTemplate.update(sql);
	}

	public int save(SampleAEntity entity) {
		String sql = "INSERT INTO SAMPLE_A VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, entity.getKey1(),entity.getKey2(), entity.getKey3(), entity.getValue1(), entity.getValue2(), entity.getValue3());
	}

}
