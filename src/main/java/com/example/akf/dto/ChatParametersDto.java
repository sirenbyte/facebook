package com.example.akf.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatParametersDto {
    private Long userId;
    private Long friendId;
}
