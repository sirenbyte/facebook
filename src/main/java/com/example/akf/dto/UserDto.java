package com.example.akf.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
}
