package project.ntsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class NtskApplication {

	public static void main(String[] args) {
		log.info("APL START");
		SpringApplication.run(NtskApplication.class, args);
	}

}
