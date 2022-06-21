package com.example.akf.service.interfaces;

import com.example.akf.dto.FriendshipRequestAction;
import com.example.akf.dto.UserDto;

import java.util.List;

public interface UserFriendshipService {
    List<UserDto> getActiveFriendshipRequests(Long userId);

    UserDto createRequestForFriendship(Long userId, Long friendId);

    void actionWithFriendshipRequest(FriendshipRequestAction friendshipRequestAction);
}
