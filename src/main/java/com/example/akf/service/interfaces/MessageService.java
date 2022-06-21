package com.example.akf.service.interfaces;

import com.example.akf.dto.ChatParametersDto;
import com.example.akf.dto.MessageDto;
import com.example.akf.dto.RequestDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getUserChatWithFriend(ChatParametersDto chatParametersDto);
    MessageDto getChatNewMessage(RequestDto requestDto);
}
