package com.microservice.consumer.service.impl;


import java.util.List;

import com.microservice.consumer.service.IHelloService;
import com.microservice.consumer.service.dataservice.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 
 */
@Component
public class HelloServiceImpl implements IHelloService {
	
    @Autowired
    private ProviderService dataService;

	@Override
	public List<String> getProviderData() {
		return dataService.getProviderData();
	}

}
