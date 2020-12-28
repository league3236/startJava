//https://www.fastcampus.co.kr/courses/200748/clips/
package com.example.springstudy.controller;

import com.example.springstudy.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path="/getMethod")   // localhost:8080/api/getMethod
    public String getRequest(){
        return "Hi GetMethod";
    }

    @GetMapping("getParameter")         //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        System.out.println("id : "+id);
        System.out.println("password : "+pwd);

        return id+pwd;
    }

    // localhost:8080/api/getMultiParameter?account=kwak&email=league3236&page=32
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return searchParam;
    }
}
