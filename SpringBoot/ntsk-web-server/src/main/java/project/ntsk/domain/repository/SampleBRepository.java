package project.ntsk.domain.repository;

import java.util.List;

import project.ntsk.domain.model.entity.SampleBEntity;
import project.ntsk.domain.model.entity.SampleBKey;

public interface SampleBRepository {

	public List<SampleBEntity> findAll();

	public List<SampleBEntity> findByKey(SampleBKey key);

	public int delete(SampleBKey key);

	public int save(SampleBEntity entity);

}
