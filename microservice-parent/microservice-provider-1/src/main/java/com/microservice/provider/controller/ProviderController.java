package com.microservice.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
    public List<String> getProviderData(){
        List<String> list = new ArrayList<>();
        list.add("hystrix application");
        return list;
    }
}
