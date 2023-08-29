package com.rest.webservices.somebean;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/api")
public class SomeBeanController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue bean() {
		SomeBean somebean = new SomeBean("value1","value2","value3","value4");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
		SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter) ;
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue beanList(){
		List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3","value4"), 
				new SomeBean("value5","value6","value7","value8"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter",filter  );
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

}
