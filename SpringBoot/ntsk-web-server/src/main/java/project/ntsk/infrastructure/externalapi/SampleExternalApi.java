package project.ntsk.infrastructure.externalapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SampleExternalApi {

	@Autowired
	RestTemplate restTemplate;

	public void query() {
		String url = "http://hoge.com/api/sample?name={name}&age={age}";
		String name = "Tanaka";
		String age = "16";

		//リクエスト情報の作成
		RequestEntity<?> request = RequestEntity.get(url, name, age).build();

		//リクエストの送信
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
	}

	public void query2() {
		String url = "http://hoge.com/api/sample?name={name}&age={age}";
		String name = "Tanaka";
		String age = "16";

		//リクエスト情報の作成
		RequestEntity<?> request = RequestEntity.get(url, name, age).build();

		//リクエストの送信
		ResponseEntity<String> response = restTemplate.exchange(request, String.class);
	}
}
