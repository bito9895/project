package project.ntsk.infrastructure.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import project.ntsk.domain.model.entity.SampleBEntity;
import project.ntsk.domain.model.entity.SampleBKey;
import project.ntsk.domain.repository.SampleBRepository;

@Repository
public class PostgresSampleBRepository implements SampleBRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private BeanPropertyRowMapper<SampleBEntity> rowMapper = new BeanPropertyRowMapper<SampleBEntity>();

	public List<SampleBEntity> findAll() {
		String sql = "SELECT * FROM SAMPLE_B";
		return jdbcTemplate.query(sql, rowMapper);
	}

	public List<SampleBEntity> findByKey(SampleBKey key) {
		String sql = "SELECT * FROM SAMPLE_B WHERE key1 = ? AND key2 = ? AND key3 = ?";
		return jdbcTemplate.query(sql, rowMapper, key.getKey1(), key.getKey2(), key.getKey3());
	}

	public int delete(SampleBKey key) {
		String sql = "DELETE FROM SAMPLE_B WHERE key1 = ? AND key2 = ? AND key3 = ?";
		return jdbcTemplate.update(sql);
	}

	public int save(SampleBEntity entity) {
		String sql = "INSERT INTO SAMPLE_B VALUES(?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, entity.getKey1(),entity.getKey2(), entity.getKey3(), entity.getValue1(), entity.getValue2(), entity.getValue3());
	}

}
