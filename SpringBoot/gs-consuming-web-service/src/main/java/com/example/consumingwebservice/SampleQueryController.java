package com.example.consumingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;


@RestController
public class SampleQueryController {

	@Autowired
	CountryClient quoteClient;

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public String get() throws Exception {
		String country = "Spain";

		// soap 通信
		GetCountryResponse response = quoteClient.getCountry(country);
		System.err.println(response.getCountry().getCurrency());

		return response.toString();

	}


}
