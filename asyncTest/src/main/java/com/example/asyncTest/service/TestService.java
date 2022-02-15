package com.example.asyncTest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Future;

@Slf4j
@Service
public class TestService {

    @Async
    public Future<Boolean> asyncMethod(int threadNumber){
        try{
            for(int i = 0 ; i < 100 ; i ++){
                log.info(threadNumber + "th thread count :" + i);
                Thread.sleep(100);
            }
            log.info("Thread " + threadNumber + " Complete : " + LocalDateTime.now());
            return new AsyncResult<>(true);
        }catch(InterruptedException e){
            log.info(e.getMessage());
            return new AsyncResult<>(false);
        }
    }
}
