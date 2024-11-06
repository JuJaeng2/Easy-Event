package com.project.easyEvent.event.model.dto;

import com.project.easyEvent.event.model.constant.EventStatus;
import com.project.easyEvent.event.model.constant.ParticipantStatus;
import com.project.easyEvent.event.model.entity.Event;
import com.project.easyEvent.event.model.entity.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ParticipatedEvent {

    private EventInfo eventInfo; // 참여한 이벤트의 id, title
    private ParticipantStatus eventStatus; // 이벤트 참여 상태

    static public ParticipatedEvent from(Participant participant) {

        return ParticipatedEvent.builder()
                .eventInfo(EventInfo.from(participant.getEvent()))
                .eventStatus(participant.getStatus())
                .build();
    }

}
