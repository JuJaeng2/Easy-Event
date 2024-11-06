package com.project.easyEvent.event.model.dto;

import com.project.easyEvent.event.model.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EventIdTitle {

    private Integer id;
    private String title;

    static public EventIdTitle from(Event event) {
        return EventIdTitle.builder()
                .id(event.getId())
                .title(event.getTitle())
                .build();
    }

}
