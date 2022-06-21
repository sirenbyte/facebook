package com.example.akf.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MessageDto {
    private Long id;
    private String messageText;
    private LocalDateTime sentDateTime;
    private Long receivedUserId;
    private Long senderUserId;
}
