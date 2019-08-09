package com.microservice.exception.controller;


import com.microservice.exception.service.dataservice.PSFallbackBadRequestExpcetion;
import com.microservice.exception.service.dataservice.PSFallbackOtherExpcetion;
import com.microservice.exception.service.dataservice.ProviderServiceCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


/**
 * 
 */
@RestController
public class ExceptionController {
    private static Logger log = LoggerFactory.getLogger(ExceptionController.class);
    
    @GetMapping("/getProviderServiceCommand")
    public String providerServiceCommand(){
    	String result = new ProviderServiceCommand("World").execute();
    	return result;
    }
    

    @GetMapping("/getPSFallbackBadRequestExpcetion")
    public String providerServiceFallback(){
    	String result = new PSFallbackBadRequestExpcetion().execute();
    	return result;
    }
    
    
    @GetMapping("/getPSFallbackOtherExpcetion")
    public String pSFallbackOtherExpcetion(){
    	String result = new PSFallbackOtherExpcetion().execute();
    	return result;
    }
    
    @GetMapping("/getFallbackMethodTest")
    @HystrixCommand
    public String getFallbackMethodTest(String id){
    	throw new RuntimeException("getFallbackMethodTest failed");
    }
    
    public String fallback(String id, Throwable throwable) {
    	log.error(throwable.getMessage());
        return "this is fallback message";
    }
 
}
