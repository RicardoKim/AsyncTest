package com.example.asyncTest.controller;

import com.example.asyncTest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    TestService testService;

    @PostMapping("admin/test")
    public ResponseEntity<?> testController(){
        for(int i = 0 ; i < 5 ; i++){
            testService.asyncMethod(i);

        }
        log.info("Main Process Done : " + LocalDateTime.now());
        return ResponseEntity.ok().body(LocalDateTime.now());
    }
}
