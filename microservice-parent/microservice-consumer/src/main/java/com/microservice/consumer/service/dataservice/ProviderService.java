package com.microservice.consumer.service.dataservice;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * feign调用数据服务
 * @author zhudeming
 *
 */
@FeignClient(name = "microservice-provider")
public interface ProviderService {
	
	@RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
    public List<String> getProviderData();

}
