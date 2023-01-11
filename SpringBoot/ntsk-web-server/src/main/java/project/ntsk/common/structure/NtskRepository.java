package project.ntsk.common.structure;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import project.ntsk.common.entity.NtskKey;

public abstract class NtskRepository<K, E> {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;

	abstract public List<E> find(K key);

	abstract public E findByKey(K key);

	abstract public int delete(K key);

	abstract public int save(E entity);

	protected List<E> findSuper(String tblName, BeanPropertyRowMapper<E> mapper, NtskKey key) {
		String sql = "SELECT * FROM " + tblName;
		if (key.getWhere() != null) {
			sql = sql + " WHERE " + key.getWhere();
		}
		if (key.getOrderBy() != null) {
			sql = sql + " ORDER BY " + key.getOrderBy();
		}
		if (key.getLimit() != null) {
			sql = sql + " LIMIT " + String.valueOf(key.getLimit());
		}
		return jdbc.query(sql, key.getParamMap(), mapper);
	}

	protected E findByKeySuper(String tblName, BeanPropertyRowMapper<E> mapper, NtskKey key) {
		return findSuper(tblName, mapper, key).get(1);
	}

	protected int deleteSuper(String tblName, NtskKey key) {
		String sql = "DELETE FROM " + tblName;
		if (key.getWhere() != null) {
			sql = sql + " WHERE " + key.getWhere();
		}
		return jdbc.update(sql, key.getParamMap());
	}

	protected int saveSuper(String tblName, Map<String, Object> map) {

		String sql = "INSERT INTO " + tblName + " (";
		for (String key : map.keySet()) {
			sql = sql + key + ","; //ラストはカンマ不要だからね
		}
		sql = sql + ") VALUES (";
		for (String key : map.keySet()) {
			sql = sql + ":" + key + ","; //ラストはカンマ不要だからね
		}
		sql = sql + ")";
		return jdbc.update(sql, map);
	}

}
