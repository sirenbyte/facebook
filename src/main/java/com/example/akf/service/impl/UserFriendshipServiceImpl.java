package com.example.akf.service.impl;

import com.example.akf.dto.FriendshipRequestAction;
import com.example.akf.dto.UserDto;
import com.example.akf.models.User;
import com.example.akf.models.UserFriendship;
import com.example.akf.repository.UserFriendshipRepository;
import com.example.akf.service.interfaces.UserFriendshipService;
import com.example.akf.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.akf.enumr.FriendshipActionEnum.WAITING;

@Service
@AllArgsConstructor
public class UserFriendshipServiceImpl implements UserFriendshipService {
    private final UserFriendshipRepository userFriendshipRepository;
    private final UserService userService;

    @Override
    public List<UserDto> getActiveFriendshipRequests(Long userId) {
        return userFriendshipRepository.getUserAllByToUserIdAndAction(userId, WAITING.getDescription()).stream()
                .map(this::mapUserToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createRequestForFriendship(Long userId, Long friendId) {
        if (!userFriendshipRepository.existsByFromUserIdAndToUserId(userId, friendId)) {
            userFriendshipRepository.save(UserFriendship.builder()
                    .fromUserId(userId)
                    .toUserId(friendId)
                    .action(WAITING.getDescription())
                    .actionDate(LocalDateTime.now())
                    .build());
            return mapUserToUserDto(userService.findById(userId));
        }
        throw new RuntimeException("It`s your friend");
    }

    @Override
    public void actionWithFriendshipRequest(FriendshipRequestAction friendshipRequestAction) {
        UserFriendship userFriendship = userFriendshipRepository.getByFromUserIdAndToUserId(
                        friendshipRequestAction.getRequestFromUserId(),
                        friendshipRequestAction.getRequestToUserId())
                .orElseThrow(RuntimeException::new);
        userFriendship.setAction(friendshipRequestAction.getAction().getDescription());
        userFriendship.setActionDate(LocalDateTime.now());
        userFriendshipRepository.save(userFriendship);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
