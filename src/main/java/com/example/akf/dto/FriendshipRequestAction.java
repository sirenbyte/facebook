package com.example.akf.dto;

import com.example.akf.enumr.FriendshipActionEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendshipRequestAction {
    private FriendshipActionEnum action;
    private Long requestFromUserId;
    private Long requestToUserId;
}
