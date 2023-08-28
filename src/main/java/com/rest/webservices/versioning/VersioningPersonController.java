package com.rest.webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 nameFirstVersion() {
		return new PersonV1("Kumud Kishor");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 nameSecondVersion() {
		return new PersonV2("Kumud","Kishor");
	}
	
	@GetMapping(path="/person", params="version=1" )
	public PersonV1 nameFirstVersionRequestParam() {
		return new PersonV1("Kumud Kishor");
	}
	
	@GetMapping(path="/person" , params = "version=2")
	public PersonV2 nameSecondVersionRequestParam() {
		return new PersonV2("Kumud","Kishor");
	}
}
