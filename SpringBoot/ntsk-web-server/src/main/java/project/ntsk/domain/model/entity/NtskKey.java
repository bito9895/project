package project.ntsk.domain.model.entity;

import java.io.Serializable;
import java.util.Map;

public interface NtskKey extends Serializable {

	public String getWhere();

	public String getOrderBy();

	public Integer getLimit();

	public Map<String, Object> getParamMap();

}
