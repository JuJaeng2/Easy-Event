package com.project.easyEvent.event.model.entity;

import java.time.LocalDateTime;

import com.project.easyEvent.common.entity.CreatedTime;
import com.project.easyEvent.event.model.constant.EventStatus;
import com.project.easyEvent.user.model.entity.Users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Event extends CreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn
    private Users producer;

    private String title;
    private Integer maxParticipant;
    private Integer participantCnt;
    private LocalDateTime startTime;
    private LocalDateTime deadline;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private EventStatus status;
}
