package com.example.asyncTest.controller;

import com.example.asyncTest.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    TestService testService;

    @PostMapping("admin/test")
    public ResponseEntity<?> testController() throws ExecutionException, InterruptedException {
        List<Future<Boolean>> asyncResultWaitingQueue = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            asyncResultWaitingQueue.add(testService.asyncMethod(i));
        }
        for(Future<Boolean> result : asyncResultWaitingQueue){
            result.get();
        }
        log.info("Main Process Done : " + LocalDateTime.now());
        return ResponseEntity.ok().body(LocalDateTime.now());
    }
}
