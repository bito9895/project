package com.example.consumingwebservice;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
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
		
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("io.spring.guides.gs_producing_web_service");

		// object → xml
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		marshaller.marshal(response, result);
		String xml = writer.toString();
		System.err.println(xml);
		
		// xml → object
		response = (GetCountryResponse) marshaller.unmarshal(new StreamSource(new ByteArrayInputStream(xml.getBytes("UTF-8"))));
		System.err.println(response.toString());
		
		return response.toString();

	}


}
