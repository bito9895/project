package project.ntsk.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.domain.model.api.NtskBasicReq;
import project.ntsk.domain.model.api.NtskBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.service.SampleService;

@Slf4j
@Service
public class SampleRegistAppService {

	@Autowired
	private SampleService sampleAService;

	@Transactional
	public NtskBasicRes<SampleARes> execute(NtskBasicReq<SampleAReq> req) {
		NtskBasicRes<SampleARes> res = new NtskBasicRes<SampleARes>();
		return res;
	}

}
