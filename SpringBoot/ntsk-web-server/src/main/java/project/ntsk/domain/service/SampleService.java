package project.ntsk.domain.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import project.ntsk.common.exception.NtskException;
import project.ntsk.domain.model.api.Sample2Dto;
import project.ntsk.domain.model.api.Sample3Dto;
import project.ntsk.domain.model.api.SampleDto;
import project.ntsk.domain.model.entity.SampleAEntity;
import project.ntsk.domain.model.entity.SampleAKey;
import project.ntsk.domain.model.entity.SampleEntity;
import project.ntsk.domain.repository.SampleRepository;
import project.ntsk.domain.value.SampleID;

@Slf4j
@Component
public class SampleService {

	@Autowired
	private SampleRepository sampleARepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ModelMapper modelMapper;

	public void sampleLogic() throws NtskException {

		SampleDto dto = new SampleDto();
		dto.setKey(SampleID.SAMPLE1);
		dto.setKey1("1");
		dto.setKey2("2");
		dto.setKey3("3");
		dto.setValue1("a");
		dto.setValue2("b");
		dto.setValue3("c");

		SampleEntity entity = new SampleEntity();

		try {

			// dto → map
			Map<String, Object> map = objectMapper.convertValue(dto, new TypeReference<Map<String, Object>>() {});
			log.debug(map.toString());

			// map → dto
			dto = objectMapper.convertValue(map, SampleDto.class);
			log.debug(map.toString());

			// dto → entity
			entity = objectMapper.convertValue(dto, SampleEntity.class);
			log.debug(entity.toString());

			entity = modelMapper.map(dto, SampleEntity.class);
			log.debug(entity.toString());

			// list → map
			List<SampleEntity> list = new ArrayList<>();
			list.add(entity.clone());
			list.add(entity.clone());
			list.add(entity.clone());

			Map<String, SampleEntity> mapA = list.stream().collect(
					Collectors.toMap(
							s -> s.getKey1(),
							s -> s,
							(oldKey, newKey) -> newKey,
							LinkedHashMap::new));

			log.debug(mapA.toString());

			Map<String, String> mapB = list.stream().collect(
					Collectors.toMap(
							SampleEntity::getKey1,
							SampleEntity::getValue1,
							(oldKey, newKey) -> newKey,
							LinkedHashMap::new));

			log.debug(mapB.toString());

			// map → list
			Map<String, SampleEntity> mapX = new LinkedHashMap<>();
			mapX.put("1", entity.clone());
			mapX.put("2", entity.clone());
			mapX.put("3", entity.clone());

			List<SampleEntity> listA = new ArrayList<>(mapX.values());

			log.debug(listA.toString());

			List<SampleEntity> listB = mapX.values().stream().sorted(
					Comparator.comparingInt(v -> Integer.parseInt(v.getKey1()))).toList();

			log.debug(listB.toString());

			// list → list ※stream
			List<SampleEntity> listC = new ArrayList<>();
			listC.add(entity.clone());
			listC.add(entity.clone());
			listC.add(entity.clone());

			List<String> listD = listC.stream()
					.map(v -> v.getValue1())
					.filter(v -> v.startsWith("a"))
					.collect(Collectors.toList());

			log.debug(listD.toString());

			// stream map forEach

			// stream collection

			// enum map create
			Map<SampleID, SampleDto> collectionA = new EnumMap<>(SampleID.class);

			log.debug(collectionA.toString());

			Map<SampleID, SampleDto> collectionB = Stream.of(SampleID.getAll())
					.map(v -> load(v))
					.collect(Collectors.toMap(
							SampleDto::getKey,
							Function.identity(),
							(oldKey, newKey) -> newKey,
							LinkedHashMap::new));

			log.debug(collectionB.toString());

			// list先頭のみの処理
			Optional<SampleEntity> first = list.stream().findFirst();
			if (first.isPresent()) {
				// 処理
				log.debug(first.toString());
			}

			// dto子階層のNULLチェック
			Optional<Sample3Dto> dto3 = Optional.ofNullable(dto)
					.map(SampleDto::getSample2Dto)
					.map(Sample2Dto::getSample3Dto);

			if (dto3.isPresent()) {
				// 処理
				log.debug(dto3.toString());
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}

	}

	private SampleDto load(SampleID id) {
		SampleDto sampleDto = new SampleDto();
		sampleDto.setKey(id);
		return sampleDto;
	}

	public SampleAEntity makeEntity() throws NtskException {

		try {

			SampleAKey key = new SampleAKey();
			key.setKey1(1);
			key.setKey2(1);
			key.setKey3(1);

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
			throw new NtskException(this.getClass().getName());
		}

	}

	public SampleAEntity findEntity(SampleAKey key) {
		return sampleARepository.findByKey(key);
	}

	public void saveEntity() {

	}

}
