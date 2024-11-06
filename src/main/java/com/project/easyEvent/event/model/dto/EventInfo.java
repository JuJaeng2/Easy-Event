package com.project.easyEvent.event.model.dto;

import com.project.easyEvent.event.model.constant.EventStatus;
import com.project.easyEvent.event.model.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EventInfo{

    private Integer id;
    private String title;
    private EventStatus eventStatus; // 이벤트 상태

    static public EventInfo from(Event event) {
        return EventInfo.builder()
                .id(event.getId())
                .title(event.getTitle())
                .eventStatus(event.getStatus())
                .build();
    }
}
