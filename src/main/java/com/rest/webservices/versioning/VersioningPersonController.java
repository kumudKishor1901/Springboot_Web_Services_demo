package com.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 name() {
		return new PersonV1("Kumud Kishor");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getName() {
		return new PersonV2("Kumud","Kishor");
	}
}
