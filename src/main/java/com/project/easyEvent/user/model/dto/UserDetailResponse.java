package com.project.easyEvent.user.model.dto;

import com.project.easyEvent.event.model.dto.EventIdTitle;
import com.project.easyEvent.event.model.dto.EventInfo;
import com.project.easyEvent.event.model.dto.ParticipatedEvent;
import com.project.easyEvent.user.model.entity.Users;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserDetailResponse {

    private String name;
    private String email;
    private String phone;
    private List<EventInfo> produceEventList;
    private List<ParticipatedEvent> participateEventList;


    static public UserDetailResponse from(
            Users user,
            List<EventInfo> produceEventList,
            List<ParticipatedEvent> participatedEventList) {
        return UserDetailResponse.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .produceEventList(produceEventList)
                .participateEventList(participatedEventList)
                .build();
    }

}
