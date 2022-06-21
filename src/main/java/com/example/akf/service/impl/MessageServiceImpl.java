package com.example.akf.service.impl;

import com.example.akf.dto.ChatParametersDto;
import com.example.akf.dto.MessageDto;
import com.example.akf.dto.RequestDto;
import com.example.akf.models.Message;
import com.example.akf.repository.MessageRepository;
import com.example.akf.service.interfaces.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public List<MessageDto> getUserChatWithFriend(ChatParametersDto chatParametersDto) {
        return messageRepository.getBySenderUserIdAndReceivedUserId(chatParametersDto.getUserId(), chatParametersDto.getFriendId())
                .stream().map(this::mapMessageToMessageDto).collect(Collectors.toList());
    }

    @Override
    public MessageDto getChatNewMessage(RequestDto requestDto) {
        return mapMessageToMessageDto(messageRepository.save(Message.builder()
                .messageText(requestDto.getMessageText())
                .senderUserId(requestDto.getRequestFromUserId())
                .receivedUserId(requestDto.getRequestToUserId())
                .build()));
    }

    private MessageDto mapMessageToMessageDto(Message message) {
        return MessageDto.builder()
                .id(message.getId())
                .messageText(message.getMessageText())
                .sentDateTime(message.getSentDateTime())
                .receivedUserId(message.getReceivedUserId())
                .senderUserId(message.getSenderUserId())
                .build();
    }
}
