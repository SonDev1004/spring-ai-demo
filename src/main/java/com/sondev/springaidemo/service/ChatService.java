package com.sondev.springaidemo.service;

import com.sondev.springaidemo.dto.ChatRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder
//                customize config here if needed
                .build();
    }


    public String chat(ChatRequest request) {
        return chatClient
                .prompt(request.message())
                .call()
                .content();
    }
}
