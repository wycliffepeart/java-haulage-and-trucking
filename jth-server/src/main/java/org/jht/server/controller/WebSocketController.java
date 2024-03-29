package org.jht.server.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Setter
@Getter
@Accessors(chain = true)
class Message {
    private String from;
    private String text;
}

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/topic/messages") // Broadcasting the message to subscribers
    public Message handleMessage(Message message) {
        System.out.println("Received message from client: " + message);

        simpMessagingTemplate.convertAndSend("/message", message);

        return new Message().setFrom("server").setText("Message received by server: " + message);
    }
}

