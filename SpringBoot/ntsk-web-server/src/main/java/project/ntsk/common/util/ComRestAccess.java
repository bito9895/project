package project.ntsk.common.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ComRestAccess {

	public static final String CNAME = ComRestAccess.class.getSimpleName();

	/**
	 * GET
	 * @param endpoint エンドポイント
	 * @param clazz APIレスポンス型
	 * @return APIレスポンス
	 * @throws Exception
	 */
	public static <T> T get(String endpoint, Class<T> clazz) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<Void> requestEntity = null;
		try {
			requestEntity = RequestEntity
					.get(new URI(String.format("http://xxxxx/%s", endpoint)))
					.header("Authorization", "XXXXXXXXX") // Token
					.build();
		} catch (URISyntaxException e) {
		}
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (T) mapper.readValue(responseEntity.getBody(), clazz);

	}

	/**
	 * POST
	 * T:APIリクエスト型、T:APIレスポンス型
	 * @param endpoint エンドポイント
	 * @param param APIリクエスト
	 * @param clazz APIレスポンス型
	 * @return APIレスポンス
	 * @throws Exception
	 */
	public static <T, U> U post(String endpoint, T param, Class<U> clazz) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<T> requestEntity = null;
		try {
			requestEntity = RequestEntity
					.post(new URI(String.format("http://xxxxxx/%s", endpoint)))
					.header("Authorization", "XXXXXXXXXX") // Token
					.body(param);
		} catch (URISyntaxException e) {
		}
		ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
		final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return (U) mapper.readValue(responseEntity.getBody(), clazz);
	}

}
