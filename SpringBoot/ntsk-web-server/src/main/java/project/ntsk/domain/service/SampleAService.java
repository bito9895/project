package project.ntsk.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.repository.SampleARepository;

@Component
@Slf4j
public class SampleAService {

	@Autowired
	private SampleARepository sampleARepository;

	public SampleAEntity makeSample() throws NtskException {

		try {

			SampleAKey key = new SampleAKey();
			key.setKey1(1);
			key.setKey2(1);
			key.setKey3(1);

			log.info("start");
			SampleAEntity befEntity = sampleARepository.findByKey(key);
			SampleAEntity aftEntity = befEntity.clone();

			log.info(befEntity.toString());
			log.info(aftEntity.toString());

			befEntity.setKey1(100);
			befEntity.setValue1("aaaa");

			log.info(befEntity.toString());
			log.info(aftEntity.toString());

			return aftEntity;

		} catch (Exception e) {
			throw new NtskException();
		}

	}

	public SampleAEntity findSample(SampleAKey key) {
		return sampleARepository.findByKey(key);
	}

	public void saveSample() {

	}

}