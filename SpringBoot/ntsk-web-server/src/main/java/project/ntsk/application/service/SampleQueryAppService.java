package project.ntsk.application.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.ntsk.common.api.NtskBasicReq;
import project.ntsk.common.api.NtskBasicRes;
import project.ntsk.common.exception.NtskException;
import project.ntsk.common.value.ResID;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.service.SampleAService;

@Service
public class SampleQueryAppService {

	@Autowired
	private SampleAService sampleAService;

	@Autowired
	private ModelMapper modelMapper;

	public SampleARes execute(SampleAReq req) throws NtskException {

		SampleAEntity entity = sampleAService.makeSample();
		SampleARes res = modelMapper.map(entity, SampleARes.class);

		return res;
	}

	public NtskBasicRes<SampleARes> execute(NtskBasicReq<SampleAReq> req) throws NtskException {

		SampleAReq sampleAReq = req.getRequestData();
		SampleAKey key = new SampleAKey();
		key.setKey1(sampleAReq.getKey1());
		key.setKey2(sampleAReq.getKey2());
		key.setKey3(sampleAReq.getKey3());

		SampleAEntity entity = sampleAService.findSample(key);
		SampleARes sampleARes = modelMapper.map(entity, SampleARes.class);

		return new NtskBasicRes<SampleARes>(ResID.OK, sampleARes);
	}

}
