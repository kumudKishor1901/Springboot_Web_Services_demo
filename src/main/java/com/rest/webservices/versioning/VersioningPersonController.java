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
	
	@GetMapping(path="/person", headers="X-API-VERSION=1" )
	public PersonV1 nameFirstVersionRequestHeader() {
		return new PersonV1("Kumud Kishor");
	}
	
	@GetMapping(path="/person" , headers = "X-API-VERSION=2")
	public PersonV2 nameSecondVersionRequestHeader() {
		return new PersonV2("Kumud","Kishor");
	}
	
	@GetMapping(path="/person", produces="application/vnd.company.app-v1+json" )
	public PersonV1 nameFirstVersionAcceptHeader() {
		return new PersonV1("Kumud Kishor");
	}
	
	@GetMapping(path="/person", produces="application/vnd.company.app-v2+json" )
	public PersonV2 nameSecondVersionAcceptHeader() {
		return new PersonV2("Kumud","Kishor");
	}
}
