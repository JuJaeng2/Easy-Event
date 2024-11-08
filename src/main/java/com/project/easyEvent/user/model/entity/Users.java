package com.project.easyEvent.user.model.entity;

import com.project.easyEvent.common.entity.BaseEntity;

import com.project.easyEvent.user.model.dto.SignUpForm;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean isDeleted;

    static public Users makeNewUser(SignUpForm form) {
        return Users.builder()
                .name(form.getName())
                .email(form.getEmail())
                .password(form.getPassword())
                .build();
    }

}
