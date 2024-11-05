package com.project.easyEvent.notification.model.entity;

import com.project.easyEvent.common.entity.CreatedTime;
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
public class notification extends CreatedTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn
    private Users sender;

    @OneToOne
    @JoinColumn
    private Users receiver;

    private String message;
    private Boolean isRead;

}
