package project.ntsk.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.api.NtskBasicReq;
import project.ntsk.common.api.NtskBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.service.SampleAService;

@Slf4j
@Service
public class SampleRegistAppService {

	@Autowired
	private SampleAService sampleAService;

	@Transactional
	public NtskBasicRes<SampleARes> execute(NtskBasicReq<SampleAReq> req) {
		NtskBasicRes<SampleARes> res = new NtskBasicRes<SampleARes>();
		return res;
	}

}
