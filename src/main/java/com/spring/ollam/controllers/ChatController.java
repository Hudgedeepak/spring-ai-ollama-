package com.spring.ollam.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/")
public class ChatController {

    private ChatClient chatClient; //it gives the response, it has all method. we did not get direct bean , we have create builder bean than we use it.

    public ChatController(ChatClient.Builder builder) {
        this.chatClient=builder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chatMessage(@RequestParam(value = "q", required = true) String message){
        String resultResponse = chatClient.prompt(message).call().content();
        return ResponseEntity.ok(resultResponse);
    }
}
