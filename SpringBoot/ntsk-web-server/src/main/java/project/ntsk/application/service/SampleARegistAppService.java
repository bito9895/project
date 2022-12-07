package project.ntsk.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import project.ntsk.common.api.NtskReq;
import project.ntsk.common.api.NtskRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.service.SampleAService;

public class SampleARegistAppService {

	@Autowired
	private SampleAService sampleAService;

	public NtskRes<SampleARes> execute(NtskReq<SampleAReq> req) {
		NtskRes<SampleARes> res = new NtskRes<SampleARes>();
		return res;
	}

}
