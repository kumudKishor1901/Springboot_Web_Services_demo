package com.rest.webservices.somebean;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SomeBeanController {
	
	@GetMapping("/filtering")
	public SomeBean bean() {
		return new SomeBean("value1","value2","value3","value4");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> beanList(){
		return Arrays.asList(new SomeBean("value1","value2","value3","value4"), 
				new SomeBean("value5","value6","value7","value8"));
	}

}
