package project.ntsk.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.model.api.ApiBasicReq;
import project.ntsk.domain.model.api.ApiBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.service.SampleService;
import project.ntsk.domain.value.ResCode;

@Slf4j
@Service
public class SampleQueryAppService {

	@Autowired
	private SampleService sampleService;

	@Autowired
	private ModelMapper modelMapper;

	public SampleARes execute(SampleAReq req) throws NtskException {

		sampleService.sampleLogic();

		SampleAEntity entity = sampleService.makeEntity();
		SampleARes res = modelMapper.map(entity, SampleARes.class);

		return res;
	}

	public ApiBasicRes<SampleARes> execute(ApiBasicReq<SampleAReq> req) throws NtskException {

		SampleAReq sampleAReq = req.getRequestData();
		SampleAKey key = new SampleAKey();
		key.setKey1(sampleAReq.getKey1());
		key.setKey2(sampleAReq.getKey2());
		key.setKey3(sampleAReq.getKey3());

		SampleAEntity entity = sampleService.findEntity(key);
		SampleARes sampleARes = modelMapper.map(entity, SampleARes.class);

		return new ApiBasicRes<SampleARes>(ResCode.OK, sampleARes);
	}

}
