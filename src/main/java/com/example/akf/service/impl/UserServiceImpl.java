package com.example.akf.service.impl;

import com.example.akf.models.User;
import com.example.akf.repository.UserRepository;
import com.example.akf.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(RuntimeException::new);
    }
}
