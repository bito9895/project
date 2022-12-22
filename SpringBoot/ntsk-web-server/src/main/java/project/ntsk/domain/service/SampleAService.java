package project.ntsk.domain.service;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.cars.Shiporder;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.repository.SampleARepository;

@Slf4j
@Component
public class SampleAService {

	@Autowired
	private SampleARepository sampleARepository;

	public SampleAEntity makeEntity() throws NtskException {

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


			Shiporder obj = null;
			try {
				JAXBContext jc = JAXBContext.newInstance("project.ntsk.domain.cars");
	            Unmarshaller um = jc.createUnmarshaller();

	            obj = (Shiporder) um.unmarshal(Paths.get("./xml/sample.xml").toFile());


			} catch (Exception ex) {
			  ex.printStackTrace();
			}


			return aftEntity;

		} catch (Exception e) {
			throw new NtskException(this.getClass().getName());
		}

	}

	public SampleAEntity findEntity(SampleAKey key) {
		return sampleARepository.findByKey(key);
	}

	public void saveEntity() {

	}

}
