package com.web.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by li wen ya on 2020/1/14
 */
@RestController
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/hello")
    public String test(){
        simpMessagingTemplate.convertAndSend("/topic/test","hello world");
        return "success";
    }

    @Scheduled(cron = "0/5 * * * * ? ")
    public void scheduling(){
        simpMessagingTemplate.convertAndSend("/topic/test","hello world test webSocket");
    }


}
