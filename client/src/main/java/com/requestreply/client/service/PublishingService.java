package com.requestreply.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.requestreply.client.dto.Data;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

@Service
public class PublishingService {

    private final RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    public PublishingService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper =  objectMapper;
    }
    public String publishMessage(Data message) throws JsonProcessingException {
        // Convert the Data object to a JSON string
        String jsonMessage = objectMapper.writeValueAsString(message);

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setCorrelationId(UUID.randomUUID().toString());
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setTimestamp(new Date());
        Message requestMessage = new Message(jsonMessage.getBytes(), messageProperties);
        Message responseMessage = rabbitTemplate.sendAndReceive("test", requestMessage);
        if (responseMessage != null) {
            String response = new String(responseMessage.getBody());
            System.out.println("Received response: " + response);
            return response;
        } else {
            System.out.println("No response received");
            return null;
        }
    }

}
