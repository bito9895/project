package project.ntsk.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.model.api.NtskBasicReq;
import project.ntsk.domain.model.api.NtskBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.service.SampleService;
import project.ntsk.domain.value.ResponseCD;

@Slf4j
@Service
public class SampleQueryAppService {

	@Autowired
	private SampleService sampleAService;

	@Autowired
	private ModelMapper modelMapper;

	public SampleARes execute(SampleAReq req) throws NtskException {

		SampleAEntity entity = sampleAService.makeEntity();
		SampleARes res = modelMapper.map(entity, SampleARes.class);

		return res;
	}

	public NtskBasicRes<SampleARes> execute(NtskBasicReq<SampleAReq> req) throws NtskException {

		SampleAReq sampleAReq = req.getRequestData();
		SampleAKey key = new SampleAKey();
		key.setKey1(sampleAReq.getKey1());
		key.setKey2(sampleAReq.getKey2());
		key.setKey3(sampleAReq.getKey3());

		SampleAEntity entity = sampleAService.findEntity(key);
		SampleARes sampleARes = modelMapper.map(entity, SampleARes.class);

		return new NtskBasicRes<SampleARes>(ResponseCD.OK, sampleARes);
	}

}
