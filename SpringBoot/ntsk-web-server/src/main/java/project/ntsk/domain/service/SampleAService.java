package project.ntsk.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.domain.repository.SampleARepository;
import project.ntsk.domain.repository.SampleBRepository;

@Component
@Slf4j
public class SampleAService {

	@Autowired
	private SampleARepository sampleARepository;

	@Autowired
	private SampleBRepository sampleBRepository;

	public void makeSample() {

	}

	public void findSample() {

	}

	public void saveSample() {

	}

}
