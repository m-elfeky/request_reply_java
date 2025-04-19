package com.requestreply.server.consumer;

import com.requestreply.server.DTO.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    // Consume message from rabbitmq queue test
    @RabbitListener(queues = "test")
    public String consumeMessage(Data message) {
        String strReturn = message.toString();
        System.out.println("Received message: " + message.toString());
        // Process the message here
        return strReturn;
    }
}
