package com.github.ojvzinn.desafioitau.service;

import com.github.ojvzinn.desafioitau.entity.TimerEntity;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    public void sendInputLog(String patch, String requestMethod) {
        System.out.println("New request in " + patch + " method: " + requestMethod);
    }

    public void sendOutputLog(TimerEntity entity, String patch, int code) {
        System.out.println("Returned code " + code + " in " + patch + " with a processing time of " + entity.getCurrentTime() + " ms.");
    }

}
