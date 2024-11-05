package com.project.easyEvent.event.model.constant;

import lombok.Getter;

@Getter
public enum EventStatus {

    UPCOMING("오픈 대기"),
    OPEN("오픈"),
    CLOSED("마감");

    private final String value;

    EventStatus(String value) {
        this.value = value;
    }
}
