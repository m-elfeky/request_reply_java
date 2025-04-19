package com.requestreply.client.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.requestreply.client.dto.Data;
import com.requestreply.client.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    PublishingService publishingService;



    @PostMapping("/publish")
    @ResponseBody
    public String publishMessage(@RequestBody Data message) {
        try {

            return publishingService.publishMessage(message);
        } catch (JsonProcessingException e) {
            // bad practice, but for the sake of this example
            throw new RuntimeException(e);
        }
    }

}
