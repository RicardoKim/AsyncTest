package com.example.asyncTest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class TestService {

    @Async
    public void asyncMethod(int threadNumber){
        try{
            for(int i = 0 ; i < 100 ; i ++){
                log.error(threadNumber + "th thread count :" + i);
                Thread.sleep(100);
            }
            log.info("Thread " + threadNumber + " Complete : " + LocalDateTime.now());
        }catch(InterruptedException e){
            log.info(e.getMessage());
        }
    }
}
