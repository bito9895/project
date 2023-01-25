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
import project.ntsk.application.service.SampleQueryAppService;
import project.ntsk.common.exception.NtskException;
import project.ntsk.common.structure.NtskController;
import project.ntsk.domain.model.api.ApiBasicReq;
import project.ntsk.domain.model.api.ApiBasicRes;
import project.ntsk.domain.model.api.SampleAReq;
import project.ntsk.domain.model.api.SampleARes;
import project.ntsk.domain.value.ResCode;

@Slf4j
@RestController
public class SampleQueryController extends NtskController {

	@Autowired
	private SampleQueryAppService sampleQueryAppService;

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public SampleARes get(@ModelAttribute SampleAReq req) {
		try {
			return sampleQueryAppService.execute(req);
		} catch (NtskException e) {
			log.error(e.getMessage());
			return new SampleARes();
		}
	}

	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ApiBasicRes<SampleARes> post(@RequestBody ApiBasicReq<SampleAReq> req) {
		try {
			return sampleQueryAppService.execute(req);
		} catch (NtskException e) {
			log.error(e.getMessage());
			return new ApiBasicRes<>(ResCode.NG, null);
		}
	}

}
