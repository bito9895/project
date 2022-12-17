package project.ntsk.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.application.service.SampleRegistAppService;
import project.ntsk.common.api.NtskBasicReq;
import project.ntsk.common.api.NtskBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;

@Slf4j
@RestController
public class SampleRegistController {

	@Autowired
	private SampleRegistAppService service;

	@PostMapping(value = "/regist", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public NtskBasicRes<SampleARes> post(@RequestBody NtskBasicReq<SampleAReq> req) {
		return service.execute(req);
	}

}
