package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


//   http://localhost:8082
@RestController
@RequestMapping
public class DevOpsController {


    //   http://localhost:8082
    @GetMapping
    public String devopsHello(){

        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);

        return "Welcome to DevOps: " + myObj;
    }


    //   http://localhost:8082/info
    @GetMapping("/info")
    public String devopsInfo(){

        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);

        return "DevOps Info: "+ myObj;
    }

}
