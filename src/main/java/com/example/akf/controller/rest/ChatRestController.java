package com.example.akf.controller.rest;

import com.example.akf.dto.ChatParametersDto;
import com.example.akf.dto.MessageDto;
import com.example.akf.service.interfaces.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class ChatRestController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<MessageDto>> getUserChatWithFriend(ChatParametersDto chatParametersDto) {
        return ResponseEntity.ok(messageService.getUserChatWithFriend(chatParametersDto));
    }
}
