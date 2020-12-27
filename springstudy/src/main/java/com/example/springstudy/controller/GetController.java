package com.example.springstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod")   // localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi GetMethod";
    }
}
