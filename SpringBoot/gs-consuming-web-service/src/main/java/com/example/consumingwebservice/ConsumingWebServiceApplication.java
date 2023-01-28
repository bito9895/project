
package com.example.consumingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
 
@SpringBootApplication
public class ConsumingWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingWebServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
