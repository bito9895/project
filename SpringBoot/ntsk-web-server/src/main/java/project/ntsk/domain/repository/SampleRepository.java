package project.ntsk.domain.repository;

import java.util.List;

import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;

public interface SampleRepository {

	public List<SampleAEntity> find(SampleAKey key);

	public SampleAEntity findByKey(SampleAKey key);

	public int delete(SampleAKey key);

	public int save(SampleAEntity entity);

}
