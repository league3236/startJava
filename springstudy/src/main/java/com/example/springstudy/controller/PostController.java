package com.example.springstudy.controller;


import com.example.springstudy.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form>
    // ajax 검색
    // http post body -> data
//      http://localhost:8080/api/postMethod
//    {
//        "account" : "league",
//            "email" : "league@gmail.com",
//            "page" : 50
//    }

    @PostMapping(value = "/postMethod")
    public SearchParam PostMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }
}
