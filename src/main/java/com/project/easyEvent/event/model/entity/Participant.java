package com.project.easyEvent.event.model.entity;

import java.time.LocalDateTime;

import com.project.easyEvent.common.entity.CreatedTime;
import com.project.easyEvent.event.model.constant.ParticipantStatus;

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
@Getter
@Setter
@Builder
public class Participant extends CreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn
    private Event event;

    private String name;

    private String email;

    private String phone;

    private Boolean isUser; // 회원인지 비회원인지

    @Enumerated(EnumType.STRING)
    private ParticipantStatus status;

    private LocalDateTime createdAt;
}
