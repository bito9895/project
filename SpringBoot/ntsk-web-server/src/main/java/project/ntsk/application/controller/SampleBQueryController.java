package project.ntsk.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.application.service.SampleBQueryAppService;
import project.ntsk.common.api.NtskReq;
import project.ntsk.common.api.NtskRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;

@RestController
@Slf4j
public class SampleBQueryController {

	@Autowired
	private SampleBQueryAppService service;

	@GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public SampleARes get(@ModelAttribute SampleAReq req) {
		return service.execute(req);
	}

	@PostMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public NtskRes<SampleARes> post(@RequestBody NtskReq<SampleAReq> req) {
		return service.execute(req);
	}

}
