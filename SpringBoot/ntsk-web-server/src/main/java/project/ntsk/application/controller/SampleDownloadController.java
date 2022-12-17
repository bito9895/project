package project.ntsk.application.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SampleDownloadController {

	@GetMapping("/download/{fileName:.+}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<byte[]> download(@PathVariable String fileName) throws Exception {

		Path filePath = Paths.get("c:/temp/" + fileName);
		byte[] data = Files.readAllBytes(filePath);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(getContentType(filePath));
		//httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//httpHeaders.setContentType(MediaType.APPLICATION_PDF);
		httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
		return new ResponseEntity<byte[]>(data, httpHeaders, HttpStatus.OK);

	}

	private MediaType getContentType(Path path) throws IOException {
		try {
			return MediaType.parseMediaType(Files.probeContentType(path));
		} catch (IOException e) {
			log.info("Could not determine file type.");
			return MediaType.APPLICATION_OCTET_STREAM;
		}
	}

}
