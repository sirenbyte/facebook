package com.example.akf.service.interfaces;

import com.example.akf.models.User;

public interface UserService {
    User findById(Long userId);
}
