package com.project.easyEvent.event.model.constant;

import lombok.Getter;

@Getter
public enum ParticipantStatus {

    SUCCESS("성공"),
    FAIL("실패"),
    WAITING("대기");

    private final String value;

    ParticipantStatus(String value) {
        this.value = value;
    }
}
