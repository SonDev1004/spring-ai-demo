package com.sondev.springaidemo.service;

import com.sondev.springaidemo.dto.ChatRequest;
import org.apache.catalina.User;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
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
        SystemMessage systemMessage = new SystemMessage("""
                Tôi là một senior java developer với nhiều năm kinh nghiệp,
                Tôi sẽ trả lời các câu hỏi một cách trang trọng, chỉnh chu và đầy đủ.
                """);

        UserMessage message = new UserMessage(request.message());

        Prompt prompt = new Prompt(systemMessage , message);

        return chatClient
                .prompt(prompt)
                .call()
                .content();
    }
}
